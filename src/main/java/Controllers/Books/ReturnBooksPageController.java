package Controllers.Books;

import Controllers.Alert.AlertUtill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.ReturnBookDTO;
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

        ReturnBookDTO returnBookDTO = new ReturnBookDTO();

        returnBookDTO.setReturnBookId(txtReturnBookId.getText());
        returnBookDTO.setBookId(txtBookId.getText());
        returnBookDTO.setMemberId(txtMemberId.getText());
        returnBookDTO.setIssueDate(dateIssue.getValue());
        returnBookDTO.setDueDate(dateDue.getValue());
        returnBookDTO.setReturnDate(String.valueOf(dateReturn.getValue()));

        boolean IsAdded = returnBookController.returnBooks(returnBookDTO);

        if (IsAdded){
            AlertUtill.showAlert(Alert.AlertType.INFORMATION,
                    "Sucess",
                    "Sucessfully return book");
        } else {
            AlertUtill.showAlert(Alert.AlertType.ERROR,
                    "Error",
                    "Faild to return book");
        }

        returnBookController.deleteIssueBook(txtIssueBookId);

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
