package Controllers.Books;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import scean.SceanManager;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBooksPageController implements Initializable {

    public ComboBox comboBoxBookType;
    AddBooksController addBooksController = new AddBooksController();

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
    void btnRegisterBookOnAction(ActionEvent event) {
        addBooksController.addBooks(
                txtBookId.getText(),
                txtBookName.getText(),
                txtBookAuthor.getText(),
                txtRate.getText(),
                comboBoxBookType.getValue().toString()
        );
    }

    public void comboBoxBookTypeOnActon(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> cmbList = FXCollections.observableArrayList();
        cmbList.add("Adventure");
        cmbList.add("Love Story");
        cmbList.add("18+");
        cmbList.add("Childrens Literature");
        cmbList.add("Fantasy");

        comboBoxBookType.setItems(cmbList);
    }
}
