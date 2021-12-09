package by.servlet.booking.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	public static final String URL = "jdbc:postgresql://localhost:5432/";
    public static final String DATABASE_NAME = "BookingService";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "Admin";

    public static Connection getConnection() throws SQLException {
        Connection connection;
        Properties properties = new Properties();
        properties.setProperty("user", USERNAME);
        properties.setProperty("password", PASSWORD);

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(URL + DATABASE_NAME, properties);
        return connection;
    }
}
