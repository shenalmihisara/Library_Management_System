    package Controllers.Books;

    import DB.dbConnection;
    import javafx.geometry.Insets;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;

    public class AddBooksController {
        Connection connection = dbConnection.getInstance().getConnection();

        public void addBooks(String book_id, String book_name, String book_author, String rate, String bookType){
            String SQL = "INSERT INTO books(book_id, book_name, book_author, rate, book_type) VALUES (?, ?, ?, ?, ?);";
            System.out.println(bookType);
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setInt(1, 4);
                preparedStatement.setString(2, book_name);
                preparedStatement.setString(3, book_author);
                preparedStatement.setString(4, rate);
                preparedStatement.setString(5, bookType);

                preparedStatement.executeUpdate();
                System.out.println("Sucsesfully add book");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
