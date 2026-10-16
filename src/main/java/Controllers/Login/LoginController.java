package Controllers.Login;

import DB.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    Connection connection = dbConnection.getConnection();

    public boolean CheckUserNameAndPassword(String username, String password) {
        String SQL = "SELECT * FROM users";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");

                if (dbUsername.equals(username) && dbPassword.equals(password)){
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return false;
    }
}
