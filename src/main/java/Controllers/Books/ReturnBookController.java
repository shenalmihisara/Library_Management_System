package Controllers.Books;

import DB.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ReturnBookController {

    Connection connection = dbConnection.getInstance().getConnection();

    public String genarateReturnBookId() {
        String SQL = """
                SELECT MAX(CAST(SUBSTRING(return_book_id, 3) AS UNSIGNED)) FROM return_book_history WHERE return_book_id REGEXP '^RB[0-9]+$'
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                int lastId = resultSet.getInt(1);

                if (resultSet.wasNull()){
                    lastId = 0;
                }
                return String.format("RB%03d", lastId + 1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public Map<String, String> get(String member_name) {
        String SQL =  "SELECT i.issue_book_id, i.book_id, b.book_name, " +
                "i.member_id, m.member_name, " +
                "i.issue_date, i.due_date " +
                "FROM issuebooks i " +
                "INNER JOIN books b ON i.book_id = b.book_id " +
                "INNER JOIN members m ON i.member_id = m.member_id " +
                "WHERE m.member_name = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, member_name);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Map<String, String> data = new HashMap<>();

                data.put("issue_book_id", resultSet.getString("issue_book_id"));
                data.put("member_id", resultSet.getString("member_id"));
                data.put("book_id", resultSet.getString("book_id"));
                data.put("book_name", resultSet.getString("book_name"));
                data.put("issue_date", resultSet.getString("issue_date"));
                data.put("due_date", resultSet.getString("due_date"));

                return data;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;

    }

//    public LocalDate getDate(String id) {
//
//    }
}
