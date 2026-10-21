    package Controllers.Books;

    import DB.dbConnection;
    import javafx.geometry.Insets;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;

    public class AddBooksController {
        Connection connection = dbConnection.getInstance().getConnection();

        public void addBooks(String book_id, String book_name, String book_author, String rate){
            String SQL = "INSERT INTO books(book_id, book_name, book_author, rate) VALUES (?, ?, ?, ?);";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setInt(1, 3);
                preparedStatement.setString(2, book_name);
                preparedStatement.setString(3, book_author);
                preparedStatement.setString(4, rate);

                preparedStatement.executeUpdate();
                System.out.println("Sucsesfully add book");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
