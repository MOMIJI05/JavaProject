import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Logout{
    @FXML
    private Button favoriteButton;
    @FXML
    private Button deleteAccountButton;
    @FXML
    private Button turnbackButton;
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;

    public void favoriteButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        Platform.runLater(() -> {
            Loading loading = new Loading(stage);
            loading.show();

            new Thread(() -> {
                try{
                    FXMLLoader favoriteLoader = new FXMLLoader(getClass().getResource("Favorite.fxml"));
                    Scene favoriteScene = new Scene(favoriteLoader.load());
                    String favoriteCSS = this.getClass().getResource("Favorite.css").toExternalForm();
                    favoriteScene.getStylesheets().add(favoriteCSS);

                    Platform.runLater(() -> {
                        stage.setScene(favoriteScene);
                        loading.closeStage();
                    });
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        });
    }

    public void deleteAccountButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();


        Platform.runLater(() -> {
            Loading loading = new Loading(stage);
            loading.show();

            new Thread(() -> {
                try{
                    FXMLLoader deleteAccountLoader = new FXMLLoader(getClass().getResource("DeleteAccount.fxml"));
                    Scene deleteAccountScene = new Scene(deleteAccountLoader.load());
                    String deleteAccountCSS = this.getClass().getResource("DeleteAccount.css").toExternalForm();
                    deleteAccountScene.getStylesheets().add(deleteAccountCSS);

                    Platform.runLater(() -> {
                        stage.setScene(deleteAccountScene);
                        loading.closeStage();
                    });
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        });
    }

    public void turnbackButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();


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

    public void yesButtonOnAction(ActionEvent event) throws IOException{
        JOptionPane.showMessageDialog(null, "已登出，即將跳轉到登入頁面", "Message", JOptionPane.INFORMATION_MESSAGE);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();


        Platform.runLater(() -> {
            Loading loading = new Loading(stage);
            loading.show();

            new Thread(() -> {
                try{
                    FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
                    Scene loginScene = new Scene(loginLoader.load());
                    String loginCSS = this.getClass().getResource("Login.css").toExternalForm();
                    loginScene.getStylesheets().add(loginCSS);

                    Platform.runLater(() -> {
                        stage.setScene(loginScene);
                        loading.closeStage();
                    });
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        });
    }

}
