import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeleteAccount {
    @FXML
    private Button favoriteButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button turnbackButton;
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;

    public void favoriteButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        FXMLLoader favoriteLoader = new FXMLLoader(getClass().getResource("Favorite.fxml"));
        Scene favoriteScene = new Scene(favoriteLoader.load());
        String favoriteCSS = this.getClass().getResource("Favorite.css").toExternalForm();
        favoriteScene.getStylesheets().add(favoriteCSS);

        stage.setScene(favoriteScene);
    }

    public void logoutButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        FXMLLoader logoutLoader = new FXMLLoader(getClass().getResource("Logout.fxml"));
        Scene logoutScene = new Scene(logoutLoader.load());
        String logoutCSS = this.getClass().getResource("Logout.css").toExternalForm();
        logoutScene.getStylesheets().add(logoutCSS);

        stage.setScene(logoutScene);
    }

    public void turnbackButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        FXMLLoader recommendLoader = new FXMLLoader(getClass().getResource("Recommend.fxml"));
        Scene recommendScene = new Scene(recommendLoader.load());
        String recommendCSS = this.getClass().getResource("Recommend.css").toExternalForm();
        recommendScene.getStylesheets().add(recommendCSS);

        stage.setScene(recommendScene);
    }

    public void yesButtonOnAction(ActionEvent event) throws IOException{
        String[] options = {"是", "否"};
        var selection = JOptionPane.showOptionDialog(null, "確定要刪除帳戶嗎？", "Message", 0, 1, null, options, options[0]);

        if(selection == 0){
            JOptionPane.showMessageDialog(null, "已刪除帳戶，即將跳轉到登入頁面", "Message", JOptionPane.INFORMATION_MESSAGE);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Scene loginScene = new Scene(loginLoader.load());
            String loginCSS = this.getClass().getResource("Login.css").toExternalForm();
            loginScene.getStylesheets().add(loginCSS);

            stage.setScene(loginScene);
        }
    }
}
