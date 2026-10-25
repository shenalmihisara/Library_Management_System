package Controllers.Books;

import Controllers.Members.MemberController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import scean.SceanManager;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class BooksPageController implements Initializable {

    BookController bookController = new BookController();

    @FXML
    public TableView<Map<String, String>>tableBooks;

    @FXML
    public TableColumn<Map<String, String>, String>colBookId;

    @FXML
    public TableColumn<Map<String, String>, String>colBookName;

    @FXML
    public TableColumn<Map<String, String>, String>colBookAuthor;

    @FXML
    public TableColumn<Map<String, String>, String>colRate;

    @FXML
    public TableColumn<Map<String, String>, String>colBookCategory;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMember;

    private ObservableList<Map<String, String>> masterBookList = FXCollections.observableArrayList();

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Books_Page.fxml");
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Home/Home_Page.fxml");
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Login/Login_page.fxml");
    }

    @FXML
    void btnMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Members_page.fxml");
    }

    public void btnReturnBooksDetailOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Return_Books_Page.fxml");
    }

    public void btnBookHistoryDetailOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Books_History_Page.fxml");
    }

    public void btnIssueBooksDetailOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Issue_Books_Page.fxml");
    }

    public void btnAddMemberSidebarOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }

    public void btnAddBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Add_Books_Page.fxml");
    }

    public void btnDeleteBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Delete_Books_Page.fxml");
    }

    public void initiableColumns(){
        colBookId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("book_id","")));
        colBookName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("book_name", "")));
        colBookAuthor.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("book_author", "")));
        colRate.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("rate","")));
        colBookCategory.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("book_type", "")));


    }

    public void loadBooks(){
        ObservableList<Map<String, String>> bookFromDB = bookController.getAllBooks();
        masterBookList.setAll(bookFromDB);
        tableBooks.setItems(masterBookList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiableColumns();
        loadBooks();
    }

    public void btnDeleteMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Delete_Member_page.fxml");
    }

    public void btnIssueBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Issue_Books_Page.fxml");
    }

    public void btnReturmBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Return_Books_Page.fxml");
    }

    public void btnBookHistoryOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Books_History_Page.fxml");
    }
}
