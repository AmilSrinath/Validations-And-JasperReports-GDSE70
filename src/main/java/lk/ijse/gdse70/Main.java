package lk.ijse.gdse70;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Amil Srinath
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/CustomerForm.fxml"));
        stage.setScene(new Scene(parent));
        stage.setTitle("Customer Form");
        stage.show();
    }
}