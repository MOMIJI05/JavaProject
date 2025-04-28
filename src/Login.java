import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    private String salt = "javaproject505";

    public void loginButtonOnAction(ActionEvent event) throws IOException, Exception{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        if (usernameTextField.getText().isBlank() == true || passwordTextField.getText().isBlank() == true) {
            loginMessageLabel.setText("請輸入帳號和密碼以登入");
            return;
        }

        if (!vaildLogin(usernameTextField.getText(), passwordTextField.getText())) {
            loginMessageLabel.setText("登入失敗！帳號或密碼錯誤");
            return;
        }

        loginMessageLabel.setText("登入成功！請等待片刻...");

        Platform.runLater(() -> {
            Loading loading = new Loading(stage);
            loading.show();

            new Thread(() -> {
                try{
                    FXMLLoader recommendLoader = new FXMLLoader(getClass().getResource("Recommend.fxml"));
                    Scene recommendScene = new Scene(recommendLoader.load());
                    String recommendCSS = this.getClass().getResource("Recommend.css").toExternalForm();
                    recommendScene.getStylesheets().add(recommendCSS);

                    Platform.runLater(() -> {
                        stage.setScene(recommendScene);
                        loading.closeStage();
                    });
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        });
    }

    public void signupButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        if (usernameTextField.getText().isBlank() == true || passwordTextField.getText().isBlank() == true){
            loginMessageLabel.setText("請輸入帳號和密碼以註冊");
            return;
        }

        if (!vaildSignup(usernameTextField.getText(), passwordTextField.getText())) {
            loginMessageLabel.setText("註冊失敗！帳號已存在");
            return;
        }

        loginMessageLabel.setText("註冊成功！請等待片刻...");

        Platform.runLater(() -> {
            Loading loading = new Loading(stage);
            loading.show();

            new Thread(() -> {
                try{
                    FXMLLoader formLoader = new FXMLLoader(getClass().getResource("Form.fxml"));
                    Scene formScene = new Scene(formLoader.load());
                    String formCSS = this.getClass().getResource("Form.css").toExternalForm();
                    formScene.getStylesheets().add(formCSS);

                    Platform.runLater(() -> {
                        stage.setScene(formScene);
                        loading.closeStage();
                    });
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        });

    }

    public boolean vaildLogin(String userName, String originPassword){
        // String saltedPassword = salt + originPassword;
        // System.out.println("Origin password adding salt: " + saltedPassword);
        // System.out.println("Hashed password: " + hash(saltedPassword));
        return true;
    }

    public boolean vaildSignup(String userName, String originPassword){
        // String saltedPassword = salt + originPassword;
        // System.out.println("User name: " + userName);
        // System.out.println("Origin password adding salt: " + saltedPassword);
        // System.out.println("Hashed password: " + hash(saltedPassword));
        return true;
    }

    public String hash(String originPassWord){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(originPassWord.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);
            String hashedPassword = no.toString(16);
            while(hashedPassword.length() < 64){
                hashedPassword = "0" + hashedPassword;
            }
            return hashedPassword;
        }
        catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}
