package Controllers.Books;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scean.SceanManager;

import java.io.IOException;

public class BooksHistoryPageController {
    public void btnGoBackToTheBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Books_Page.fxml");
    }
}
