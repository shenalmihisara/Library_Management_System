package Controllers.Members;

import DB.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMemberController {
    Connection connection = dbConnection.getInstance().getConnection();


    public boolean CheckMemberNameAndMemberidAndReEntterMemberId(String name, String memberId, String reMemberId) {

        if (!reMemberId.equals(memberId)){
            return false;
        }

        String SQL = "DELETE FROM members WHERE member_name = ? AND member_id = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, memberId);

            int rowDeleted = preparedStatement.executeUpdate();

            return rowDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
