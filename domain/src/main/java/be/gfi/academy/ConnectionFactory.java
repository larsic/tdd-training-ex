package be.gfi.academy;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum ConnectionFactory {

    INSTANCE;

    private static final String connectionURL;
    private static final Properties userCredentials;

    static{
        try {
            Properties db_config = new Properties();

            InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties");
            db_config.load(is);

            userCredentials = new Properties();
            userCredentials.put("user", db_config.getProperty("be.gfi.academy.user"));
            userCredentials.put("password", db_config.getProperty("be.gfi.academy.password"));

            connectionURL = String.format("jdbc:mysql://%s:%d/%s",
                    db_config.getProperty("be.gfi.academy.host"),
                    Integer.valueOf(db_config.getProperty("be.gfi.academy.port")),
                    db_config.getProperty("be.gfi.academy.database"));

        } catch (IOException e) {
            //TODO: use Logger framework
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            
            connection = DriverManager.getConnection(connectionURL, userCredentials);
            return connection;

        } catch (SQLException e) {
            try {
                if(connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException cantCloseConnectioNException) {
                //TODO: use logger framework
                cantCloseConnectioNException.printStackTrace();
                throw new RuntimeException(e);
            }
            //TODO: use logger framework
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
