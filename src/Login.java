import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Login{
    @FXML
    private Button loginButton;
    @FXML
    private Button signupButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    public void loginButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        FXMLLoader recommendLoader = new FXMLLoader(getClass().getResource("Recommend.fxml"));
        Scene recommendScene = new Scene(recommendLoader.load());
        String recommendCSS = this.getClass().getResource("Recommend.css").toExternalForm();
        recommendScene.getStylesheets().add(recommendCSS);

        if (usernameTextField.getText().isBlank() == true || passwordTextField.getText().isBlank() == true){
            loginMessageLabel.setText("請輸入帳號和密碼以登入");
        }
        else if (vaildLogin()) {
            loginMessageLabel.setText("登入成功！請等待片刻...");
            Timeline blink = new Timeline(
                new KeyFrame(Duration.seconds(0.5), new KeyValue(loginMessageLabel.opacityProperty(), 0.3)),
                new KeyFrame(Duration.seconds(1.0), new KeyValue(loginMessageLabel.opacityProperty(), 1.0))
            );
            blink.setCycleCount(5);
            blink.play();

            PauseTransition delay = new PauseTransition(Duration.seconds(3));
            delay.setOnFinished(e -> {
                stage.setScene(recommendScene);
            });
            delay.play();
        }
        else {
            loginMessageLabel.setText("登入失敗！帳號或密碼錯誤");
        }
    }

    public void signupButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        FXMLLoader formLoader = new FXMLLoader();
        formLoader.setLocation(getClass().getResource("Form.fxml"));
        Scene formScene = new Scene(formLoader.load());
        String formCSS = this.getClass().getResource("Form.css").toExternalForm();
        formScene.getStylesheets().add(formCSS);

        if (usernameTextField.getText().isBlank() == true || passwordTextField.getText().isBlank() == true){
            loginMessageLabel.setText("請輸入帳號和密碼以註冊");
        }
        else if (vaildSignup()) {
            loginMessageLabel.setText("註冊成功！請等待片刻...");
            Timeline blink = new Timeline(
                new KeyFrame(Duration.seconds(0.5), new KeyValue(loginMessageLabel.opacityProperty(), 0.3)),
                new KeyFrame(Duration.seconds(1.0), new KeyValue(loginMessageLabel.opacityProperty(), 1.0))
            );
            blink.setCycleCount(5);
            blink.play();

            PauseTransition delay = new PauseTransition(Duration.seconds(3.5));
            delay.setOnFinished(e -> {
                stage.setScene(formScene);
            });
            delay.play();
        }
        else {
            loginMessageLabel.setText("登入失敗！");
        }
    }

    public boolean vaildLogin(){
        return true;
    }

    public boolean vaildSignup(){
        return true;
    }
}
