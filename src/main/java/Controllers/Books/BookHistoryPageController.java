package Controllers.Books;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import scean.SceanManager;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class BookHistoryPageController implements Initializable {

    BookHistoryController bookHistoryController = new BookHistoryController();

    @FXML
    private Button btnAddBooks;

    @FXML
    private Button btnAddMemberSidebar;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnDeleteBooks;

    @FXML
    private Button btnDeleteMember;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMember;

    @FXML
    public TableView<Map<String, String>>tblReturnBookHistory;

    @FXML
    public TableColumn<Map<String, String>, String>colReturnId;

    @FXML
    private TableColumn<Map<String, String>, String> colBookId;

    @FXML
    private TableColumn<Map<String, String>, String> colBookName;

    @FXML
    private TableColumn<Map<String, String>, String> colDueDate;

    @FXML
    private TableColumn<Map<String, String>, String> colHistoryId;

    @FXML
    private TableColumn<Map<String, String>, String> colIssueDate;

    @FXML
    private TableColumn<Map<String, String>, String> colMemberId;

    @FXML
    private TableColumn<Map<String, String>, String> colMemberName;

    @FXML
    private TableColumn<Map<String, String>, String> colReturnDate;

    @FXML
    private TableColumn<Map<String, String>, String> colStatus;

    private ObservableList<Map<String, String>> masterReturnBookHistory = FXCollections.observableArrayList();

    @FXML
    void btnAddBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Add_Books_Page.fxml");
    }

    @FXML
    void btnAddMemberSidebarOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Books_Page.fxml");
    }

    @FXML
    void btnDeleteBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Delete_Books_Page.fxml");
    }

    @FXML
    void btnDeleteMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Delete_Member_page.fxml");
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

    public void initiableColumns(){
        colReturnId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("return_id", "")));
        colBookId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("book_id", "")));
        colBookName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("book_name", "")));
        colMemberId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("member_id", "")));
        colMemberName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("member_name", "")));
        colIssueDate.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("issue_date", "")));
        colDueDate.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("due_date", "")));
        colReturnDate.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("return_date", "")));
        colStatus.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("status", "")));
    }

    public void loadTable(){
        ObservableList<Map<String, String>> returnBookHistoryFromDb = bookHistoryController.getBookHistoryBooks();
        masterReturnBookHistory.setAll(returnBookHistoryFromDb);
        tblReturnBookHistory.setItems(masterReturnBookHistory);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiableColumns();
        loadTable();

    }
}
