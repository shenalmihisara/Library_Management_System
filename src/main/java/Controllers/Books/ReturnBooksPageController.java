package Controllers.Books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import scean.SceanManager;

import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.ResourceBundle;

public class ReturnBooksPageController implements Initializable {

    ReturnBookController returnBookController = new ReturnBookController();

    @FXML
    private Button btnAddBooks;

    @FXML
    private Button btnAddMember;

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
    private Button btnReturnBook;

    @FXML
    private Button btnReturnBookCancle;

    @FXML
    private DatePicker dateDue;

    @FXML
    private DatePicker dateIssue;

    @FXML
    private DatePicker dateReturn;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtIssueBookId;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtMemberName;

    @FXML
    private TextField txtReturnBookId;

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
    void btnReturnBookCancleOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Books_Page.fxml");
    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {
//        returnBookController.returnBooks(
//                txtReturnBookId.getText(),
//                txtMemberName.getText(),
//                txtIssueBookId.getText(),
//                txtMemberId.getText(),
//                txtBookId.getText(),
//                txtBookName.getText(),
//                dateIssue.getValue(),
//                dateDue.getValue(),
//                dateReturn.getValue()
//        );
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {

        Map<String, String> data = returnBookController.get(txtMemberName.getText());

        if (data != null) {
            txtIssueBookId.setText(data.get("issue_book_id"));
            txtMemberId.setText(data.get("member_id"));
            txtBookId.setText(data.get("book_id"));
            txtBookName.setText(data.get("book_name"));
            dateIssue.setValue(LocalDate.parse(data.get("issue_date")));
            dateDue.setValue(LocalDate.parse(data.get("due_date")));
        } else {
            System.out.println("return book id not found");
        }
//        dateIssue.setValue(returnBookController.getDate(dateIssue.getId()));
//        dateDue.setValue(returnBookController.getDate(dateDue.getId()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtReturnBookId.setText(returnBookController.genarateReturnBookId());
        txtReturnBookId.setEditable(false);

        txtReturnBookId.setEditable(false);
        txtMemberId.setEditable(false);
        txtBookId.setEditable(false);
        txtBookName.setEditable(false);
        dateIssue.setEditable(false);
        dateDue.setEditable(false);
    }
}
