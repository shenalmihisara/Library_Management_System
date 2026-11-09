package Controllers.Books;

import Controllers.Alert.AlertUtill;
import DB.dbConnection;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.ReturnBookDTO;

import java.sql.*;
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

    public boolean returnBooks(ReturnBookDTO returnBookDTO) {

        String SQL = "INSERT INTO return_book_history(return_book_id, book_id, member_id, issue_date, due_date, return_date) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, returnBookDTO.getReturnBookId());
            preparedStatement.setString(2, returnBookDTO.getBookId());
            preparedStatement.setString(3, returnBookDTO.getMemberId());
            preparedStatement.setDate(4, Date.valueOf(returnBookDTO.getIssueDate()));
            preparedStatement.setDate(5, Date.valueOf(returnBookDTO.getReturnDate()));
            preparedStatement.setDate(6, Date.valueOf(returnBookDTO.getReturnDate()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public void deleteIssueBook(TextField txtIssueBookId) {
        String SQL = "DELETE FROM issueBooks WHERE issue_book_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, txtIssueBookId.getText());

            preparedStatement.executeUpdate();

            AlertUtill.showAlert(Alert.AlertType.INFORMATION, "Sucess", "Sucessfully You Return Book");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//    public LocalDate getDate(String id) {
//
//    }
}
