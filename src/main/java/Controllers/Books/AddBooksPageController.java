package Controllers.Books;

import Controllers.Alert.AlertUtill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.BookDTO;
import scean.SceanManager;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBooksPageController implements Initializable {

    AddBooksController addBooksController = new AddBooksController();

    @FXML
    public ComboBox comboBoxBookType;

    @FXML
    private Button btnAddBooks;

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnCancleBookRegister;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMember;

    @FXML
    private Button btnRegisterBook;

    @FXML
    public TextField txtBookAuthor;

    @FXML
    public TextField txtBookId;

    @FXML
    public TextField txtBookName;

    @FXML
    public TextField txtRate;

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
    void btnCancleBookRegisterOnAction(ActionEvent event) {
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

    @FXML
    public void btnDeleteBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Delete_Books_Page.fxml");
    }

    @FXML
    void btnRegisterBookOnAction(ActionEvent event) {

        BookDTO bookDTO = new BookDTO();

        bookDTO.setBookId(txtBookId.getText());
        bookDTO.setBookName(txtBookName.getText());
        bookDTO.setBookAuthor(txtBookAuthor.getText());
        bookDTO.setRate(txtRate.getText());
        bookDTO.setBookTytpe(comboBoxBookType.getValue().toString());

        if (
                bookDTO.getBookId() == null || bookDTO.getBookId().trim().isEmpty() ||
                bookDTO.getBookName() == null || bookDTO.getBookName().trim().isEmpty() ||
                bookDTO.getBookAuthor() == null || bookDTO.getBookAuthor().trim().isEmpty() ||
                bookDTO.getRate() == null || bookDTO.getRate().trim().isEmpty() ||
                bookDTO.getBookTytpe() == null || bookDTO.getBookTytpe().trim().isEmpty()
        ){
            AlertUtill.showAlert(Alert.AlertType.WARNING,
                    "WARNING",
                    "Fill All Requid Fields");
            return;
        }

        boolean bookAdded = addBooksController.addBooks(bookDTO);

        if (bookAdded){
            AlertUtill.showAlert(Alert.AlertType.INFORMATION,
                    "SUCESS",
                    "Sucessfully Add Book!  Your Book Id : " + bookDTO.getBookId());
        } else {
            AlertUtill.showAlert(Alert.AlertType.ERROR,
                    "ERROR",
                    "Faild To Add Book");
        }

        txtBookId.clear();
        txtBookName.clear();
        txtBookAuthor.clear();
        txtRate.clear();
        comboBoxBookType.setValue("Book Type");

        txtBookId.setText(addBooksController.genarateBookId());
        txtBookId.setEditable(false);
    }

    public void comboBoxBookTypeOnActon(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtBookId.setText(addBooksController.genarateBookId());
        txtBookId.setEditable(false);

        ObservableList<String> cmbList = FXCollections.observableArrayList();
        cmbList.add("Adventure");
        cmbList.add("Love Story");
        cmbList.add("18+");
        cmbList.add("Childrens Literature");
        cmbList.add("Fantasy");

        comboBoxBookType.setItems(cmbList);
    }

    public void btnDeleteMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Delete_Member_page.fxml");
    }
}
