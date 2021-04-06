package by.epamtc.final_task.dao.pool;

import by.epamtc.final_task.dao.pool.exception.PoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

class ConnectionCreator {

    public static final Logger LOGGER = LogManager.getLogger();
    private static ConnectionCreator instance;
    private static final Properties properties = new Properties();
    private static final String DATABASE_URL;
    private static final String PROPERTIES_FILE = "dataBase.properties";
    private static final String DRIVER_NAME = "db.driver";
    private static final String URL = "db.url";

    static {
        try (InputStream inputStream =
                     ConnectionCreator.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
            String driverName = (String) properties.get(DRIVER_NAME);
            Class.forName(driverName);
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.FATAL, "ConnectionCreator was not initialized", e);
            throw new ExceptionInInitializerError("ConnectionCreator was not initialized");
        }
        DATABASE_URL = (String) properties.get(URL);
    }

    private ConnectionCreator() {
    }

    static ConnectionCreator getInstance() {
        if (instance == null) {
            instance = new ConnectionCreator();
        }
        return instance;
    }

    Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, properties);
    }
}
