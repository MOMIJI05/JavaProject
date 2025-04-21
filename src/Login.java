import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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


    public void loginButtonOnAction(ActionEvent event){
        if(usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false){
            vaildLogin();
        }
        else{
            loginMessageLabel.setText("請輸入帳號和密碼以登入");
        }
    }

    public void SignupButtonOnAction(ActionEvent event){
        if(usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false){
            vaildSignup();
        }
        else{
            loginMessageLabel.setText("請輸入帳號和密碼以註冊");
        }
    }

    public void vaildLogin(){
        loginMessageLabel.setText("登入成功！");
    }

    public void vaildSignup(){
        loginMessageLabel.setText("註冊成功！");
    }
}
