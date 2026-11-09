package Controllers.Books;

import Controllers.Alert.AlertUtill;
import DB.dbConnection;
import javafx.scene.control.Alert;
import model.IssueBookDTO;

import java.sql.*;

public class IssueBooksController {

    Connection connection = dbConnection.getInstance().getConnection();

    public String getMemberIdFromDb(String member_name) {
        String SQL = "SELECT member_id FROM members WHERE member_name = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, member_name);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return resultSet.getString("member_id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String getBookIdFromDb(String book_id) {

        String SQL = "SELECT book_id FROM books WHERE book_name = ? ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, book_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return resultSet.getString("book_id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean issueBooks(IssueBookDTO issueBookDTO) {
        String SQL = "INSERT INTO issueBooks(issue_book_id, member_id, book_id, issue_date, due_date) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, issueBookDTO.getBookId());
            preparedStatement.setString(2, issueBookDTO.getMemberId());
            preparedStatement.setString(3, issueBookDTO.getBookId());
            preparedStatement.setDate(4, Date.valueOf(issueBookDTO.getIssueDate()));
            preparedStatement.setDate(5, Date.valueOf(issueBookDTO.getDueDate()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public String genarateIssueBookId() {

        String SQL = """
                SELECT MAX(CAST(SUBSTRING(issue_book_id, 3) AS UNSIGNED)) FROM issueBooks WHERE issue_book_id REGEXP '^IB[0-9]+$'""";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                int lastId = resultSet.getInt(1);

                if (resultSet.wasNull()){
                    lastId = 0;
                }
                return String.format("IB%03d", lastId + 1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }
}
