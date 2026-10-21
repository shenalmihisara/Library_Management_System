package Controllers.Members;

import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.control.cell.MapValueFactory;
import javafx.stage.Stage;
import scean.SceanManager;

import java.io.IOException;
import java.lang.reflect.Member;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MembersPageController implements Initializable {

    MemberController memberController = new MemberController();

    @FXML
    public TableView<Map<String, String>>tblMembers;

    @FXML
    public TableColumn<Map<String, String>, String> colMemberAddress;

    @FXML
    private TableColumn<Map<String,String>, String>colMemberId;

    @FXML
    private TableColumn<Map<String, String>, String>colMemberName;

    @FXML
    private TableColumn<Map<String, String>, String>colMemberEmail;

    @FXML
    private TableColumn<Map<String, String>, String>colMemberPhoneNum;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMember;

    private ObservableList<Map<String, String>> masterMemberList = FXCollections.observableArrayList();

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
    public void btnMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Members_page.fxml");
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnAddMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }


    public void initializeColumns(){
        colMemberId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("member_id", "" )));
        colMemberName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("member_name", "")));
        colMemberEmail.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("email","")));
        colMemberPhoneNum.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("phone_number","")));
        colMemberAddress.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("address", "")));

    }

    private void loadMember(){
        ObservableList<Map<String, String>> MemberFromDb = memberController.getAllMembers();
        masterMemberList.setAll(MemberFromDb);
        tblMembers.setItems(masterMemberList);
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        initializeColumns();
        loadMember();
    }

    public void btnAddMemberSidebarOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }

    public void btnAddBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Add_Books_Page.fxml");
    }

    public void btnDeleteMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Delete_Member_page.fxml");
    }
}
