package Controllers.Members;

import Controllers.Alert.AlertUtill;
import DB.dbConnection;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMemberController {
    Connection connection = dbConnection.getInstance().getConnection();


    public String genarateMemberId(){
        String SQL = """
                SELECT MAX(CAST(SUBSTRING(member_id, 2) AS UNSIGNED)) FROM members WHERE member_id REGEXP '^M[0-9]+$'""";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                int lastId = resultSet.getInt(1);

                if (resultSet.wasNull()){
                    lastId = 0;
                }

                return String.format("M%03d", lastId + 1);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void addMembers(String Id, String Name, String Address, String Email, String phonenumber) {
        String SQL = "INSERT INTO members(member_id, member_name, email, phone_number, address) VALUE(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, Id);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3,Email);
            preparedStatement.setString(4, phonenumber);
            preparedStatement.setString(5, Address);

            preparedStatement.executeUpdate();
            System.out.println("successfully added member" + genarateMemberId());

            AlertUtill.showAlert(Alert.AlertType.INFORMATION, "SUCESS!", "Sucessfully Add Member!  Your Member Id : " + Id);

        } catch (SQLException e) {

            new Alert(Alert.AlertType.ERROR, e.getMessage());

            throw new RuntimeException(e);
        }
    }
}
