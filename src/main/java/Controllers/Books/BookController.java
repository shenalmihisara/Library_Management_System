package Controllers.Books;

import DB.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BookController {
    Connection connection = dbConnection.getInstance().getConnection();


    public ObservableList<Map<String, String>> getAllBooks(){
        ObservableList<Map<String, String>> BookList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM books ORDER BY book_id ASC";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Map<String, String> row = new HashMap<>();

                row.put("book_id", resultSet.getString("book_id") != null ? resultSet.getString("book_id") : "");
                row.put("book_name", resultSet.getString("book_name") != null ? resultSet.getString("book_name") : "");
                row.put("book_author", resultSet.getString("book_author") != null ? resultSet.getString("book_author") : "");
                row.put("rate", resultSet.getString("rate") != null ? resultSet.getString("rate") : "");

                BookList.add(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return BookList;
    }
}
