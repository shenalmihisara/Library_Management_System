package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    private static Connection connection;
    private static dbConnection instance;

    private dbConnection(){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Library_Management_System",
                    "root",
                    "1234"
            );
        } catch (SQLException e) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Library_Management_System",
                        "root",
                        "1234");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static dbConnection getInstance(){
        if(instance == null){
            instance = new dbConnection();
        }

        return instance;
    }

    public Connection getConnection(){
        return connection;
    }


}
