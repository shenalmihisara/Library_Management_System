package Controllers.Members;

import DB.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MemberController {
    Connection connection = dbConnection.getInstance().getConnection();

    public ObservableList<Map<String, String>> getAllMembers(){
        ObservableList<Map<String, String>> MemberList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM members ORDER BY member_id ASC";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Map<String, String> row = new HashMap<>();

                row.put("member_id", resultSet.getString("member_id") != null ? resultSet.getString("member_id") : "");
                row.put("member_name", resultSet.getString("member_name") != null ? resultSet.getString("member_name") : "");
                row.put("email", resultSet.getString("email") != null ? resultSet.getString("email") : "");
                row.put("phone_number", resultSet.getString("phone_number") != null ? resultSet.getString("phone_number") : "");
                row.put("address", resultSet.getString("address") != null ? resultSet.getString("address") : "");

                MemberList.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return MemberList;
    }
}
