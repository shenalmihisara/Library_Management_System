package Controllers.Members;

import DB.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMemberController {
    Connection connection = dbConnection.getConnection();

    public void addMembers(String Id, String Name, String Address, String Email, String phonenumber) {
        String SQL = "INSERT INTO members(member_id, member_name, email, phone_number, address) VALUE(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3,Email);
            preparedStatement.setString(4, phonenumber);
            preparedStatement.setString(5, Address);

            preparedStatement.executeUpdate();
            System.out.println("successfully added member");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
