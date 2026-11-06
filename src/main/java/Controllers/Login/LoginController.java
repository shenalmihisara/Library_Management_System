package Controllers.Login;

import DB.dbConnection;
import model.LoginDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    Connection connection = dbConnection.getInstance().getConnection();

    public boolean CheckUserNameAndPassword(LoginDTO loginDTO) {
        String SQL = "SELECT * FROM users";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");

                if (dbUsername.equals(loginDTO.getUserName()) && dbPassword.equals(loginDTO.getPassword())){
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return false;
    }
}
