package Controllers.Books;

import Controllers.Alert.AlertUtill;
import DB.dbConnection;
import javafx.scene.control.Alert;

import java.sql.*;
import java.time.LocalDate;

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

    public void issueBooks( String issuBookId, String member_id, String book_id, LocalDate issue_date, LocalDate due_date) {
        String SQL = "INSERT INTO issueBooks(issue_book_id, member_id, book_id, issue_date, due_date) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, issuBookId);
            preparedStatement.setString(2, member_id);
            preparedStatement.setString(3, book_id);
            preparedStatement.setDate(4, Date.valueOf(issue_date));
            preparedStatement.setDate(5, Date.valueOf(due_date));

            preparedStatement.executeUpdate();

            System.out.println("Sucess");
            AlertUtill.showAlert(Alert.AlertType.INFORMATION, "Sucess", "Sucessfully Add Member");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
