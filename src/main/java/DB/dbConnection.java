package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    public static Connection getConnection(){

        Connection connection;

        {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Library_Management_System",
                        "root",
                        "1234"
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
