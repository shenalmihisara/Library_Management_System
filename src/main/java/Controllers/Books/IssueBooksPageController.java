package Controllers.Books;

import Controllers.Alert.AlertUtill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import scean.SceanManager;

import java.net.URL;
import java.util.ResourceBundle;

public class IssueBooksPageController implements Initializable {

    IssueBooksController issueBooksController = new IssueBooksController();

    @FXML
    private Button btnAddBooks;

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnCancle;

    @FXML
    private Button btnDeleteBooks;

    @FXML
    private Button btnDeleteMember;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnIssueBook;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMember;

    @FXML
    private DatePicker dateDue;

    @FXML
    private DatePicker dateIssue;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtMemberName;

    @FXML
    public TextField txtIssueBookId;

    @FXML
    void btnAddBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Add_Books_Page.fxml");
    }

    @FXML
    void btnAddMemberOnAction(ActionEvent event) {
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

    @FXML
    void btnCancleOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Books_Page.fxml");
    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {
        issueBooksController.issueBooks(
                issueBooksController.genarateIssueBookId(),
                txtMemberId.getText(),
                txtBookId.getText(),
                dateIssue.getValue(),
                dateDue.getValue()

        );

        txtMemberId.clear();
        txtBookId.clear();
        txtBookName.clear();
        txtMemberName.clear();
        dateIssue.setValue(null);
        dateDue.setValue(null);
    }


    public void btnGetMemberIdOnAction(ActionEvent actionEvent) {
        String memberId = issueBooksController.getMemberIdFromDb(txtMemberName.getText());

        if (memberId != null){
            txtMemberId.setText(memberId);
        }else {
            txtMemberId.clear();
            AlertUtill.showAlert(Alert.AlertType.ERROR,"Error","cannot find member Id");
        }
    }

    public void btnGetBookIdOnAction(ActionEvent actionEvent) {
        String bookId = issueBooksController.getBookIdFromDb(txtBookName.getText());

        if (bookId != null){
            txtBookId.setText(bookId);
        }else {
            txtBookId.clear();
            AlertUtill.showAlert(Alert.AlertType.ERROR,"Error", "cannot find book Id");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtMemberId.setEditable(false);

        txtIssueBookId.setText("Your Issue Book Id Is : " + issueBooksController.genarateIssueBookId());
    }
}
