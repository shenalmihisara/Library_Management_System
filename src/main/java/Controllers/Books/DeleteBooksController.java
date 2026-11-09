package Controllers.Books;

import DB.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBooksController {

    Connection connection = dbConnection.getInstance().getConnection();

    public boolean checkBookNameAndBookId(String bookName, String bookId, String reEntterBookId) {
        if (!reEntterBookId.equals(bookId)){
            return false;
        }

        String SQL = "DELETE FROM books WHERE book_name = ? AND book_id = ? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, bookName);
            preparedStatement.setString(2, bookId);

            int rowDeleted = preparedStatement.executeUpdate();

            return rowDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
