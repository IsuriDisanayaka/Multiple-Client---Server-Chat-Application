import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginContoller {


    public TextField txtPass;
    public TextField txtName;

    public void LoginOnActoin(ActionEvent actionEvent) throws IOException {
        String email = txtPass.getText().trim();
        String password = txtPass.getText().trim();
        if (email.length() > 0 && password.length() > 0) {
            if (
                    password.equalsIgnoreCase("1234")) {
                URL resourse = this.getClass().getResource("/Client_Ui.fxml");
                Parent load = FXMLLoader.load(resourse);
                Scene scene = new Scene(load);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again!!",
                            ButtonType.OK, ButtonType.NO).show();
                }

        } else {
            new Alert(Alert.AlertType.WARNING, "Empty!!",
                    ButtonType.OK, ButtonType.NO).show();
        }
    }

    public void ExitOnActions(ActionEvent actionEvent) {
        System.exit(0);
    }
}

