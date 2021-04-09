package by.epamtc.final_task.dao.pool;

import by.epamtc.final_task.dao.pool.exception.PoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ConnectionPool {

    public static final Logger LOGGER = LogManager.getLogger();
    private static ConnectionPool instance;
    private static Lock lock = new ReentrantLock();
    private static AtomicBoolean instanceWasCreated = new AtomicBoolean();
    private BlockingQueue<ProxyConnection> freeConnections;
    private BlockingQueue<ProxyConnection> givenAwayConnections;
    private static final int DEFAULT_POOL_SIZE = 32;

    private ConnectionPool() {
        freeConnections = init();
        givenAwayConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
    }

    private BlockingQueue<ProxyConnection> init() {
        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        Connection connection;
        try {
            for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
                connection = ConnectionCreator.getInstance().createConnection();
                freeConnections.offer(new ProxyConnection(connection));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, "ConnectionPool was not initialized", e);
            throw new RuntimeException("ConnectionPool was not initialized", e);
        }
        return freeConnections;
    }

    public static ConnectionPool getInstance() {
        if (!instanceWasCreated.get()) {
            try {
                lock.lock();
                if (instance == null) {
                    instance = new ConnectionPool();
                    instanceWasCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Connection getConnection() throws PoolException {
        ProxyConnection connection;
        try {
            connection = freeConnections.take();
            givenAwayConnections.put(connection);
        } catch (InterruptedException e) {
            LOGGER.log(Level.ERROR, "Impossible to create Connection", e);
            throw new PoolException("Can not get the connection", e);
        }
        return connection;
    }


    public void releaseConnection(Connection connection) throws PoolException {
        if (connection != null) {
            if (connection instanceof ProxyConnection && givenAwayConnections.remove(connection)) {
                try {
                    freeConnections.put((ProxyConnection) connection);
                } catch (InterruptedException e) {
                    LOGGER.log(Level.FATAL, "Connection is not a ProxyConnection");
                    throw new PoolException("Connection is not a ProxyConnection", e);
                }
            }
        }
    }

    public void destroyPool() throws PoolException {
        try {
            for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
                if (!freeConnections.isEmpty()) {
                    ProxyConnection connection = freeConnections.take();
                    connection.trueClose();
                }
            }
        } catch (InterruptedException | SQLException e) {
            LOGGER.log(Level.ERROR, "Impossible to destroy pool", e);
            throw new PoolException("Impossible to destroy pool", e);
        }

    }
}