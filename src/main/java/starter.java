import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scean.SceanManager;

public class starter extends Application {
    public static void main(String[] args) { launch();

    }

    @Override
    public void start(Stage stage) throws Exception {
        SceanManager.setStage(stage);
        SceanManager.switchPage("/view/Login/Login_page.fxml");
    }
}
