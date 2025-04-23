import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Recommend {
    @FXML
    private CheckBox actionCheckBox;
    @FXML
    private CheckBox scifiCheckBox;
    @FXML
    private CheckBox comedyCheckBox;
    @FXML
    private CheckBox suspenseCheckBox;
    @FXML
    private CheckBox romanceCheckBox;
    @FXML
    private CheckBox animationCheckBox;
    @FXML
    private CheckBox musicalCheckBox;
    @FXML
    private Button submitButton;
    @FXML
    private Button accountButton;
    @FXML
    private Label recommendMessageLabel;


    public void submitButtonOnAction(ActionEvent event){
        recommendMessageLabel.setText("請至少選擇1個類型");
    }

    public void accountButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        FXMLLoader favoriteLoader = new FXMLLoader(getClass().getResource("Favorite.fxml"));
        Scene favoriteScene = new Scene(favoriteLoader.load());
        String favoriteCSS = this.getClass().getResource("Favorite.css").toExternalForm();
        favoriteScene.getStylesheets().add(favoriteCSS);

        stage.setScene(favoriteScene);
    }

    public void movieButton1OnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        FXMLLoader introductionLoader = new FXMLLoader(getClass().getResource("Introduction.fxml"));
        Scene introductionScene = new Scene(introductionLoader.load());
        String introductionCSS = this.getClass().getResource("Introduction.css").toExternalForm();
        introductionScene.getStylesheets().add(introductionCSS);

        stage.setScene(introductionScene);
    }
}
