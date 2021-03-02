package by.epamtc.final_task.dao.pool;

import by.epamtc.final_task.dao.pool.exception.PoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.concurrent.BlockingQueue;
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
    public static ConnectionPool getInstance() {
        if (!instanceWasCreated.get()) {
            lock.lock();
            try {
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
}
