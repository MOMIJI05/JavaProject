import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Form {
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
    private Label submitMessageLabel;

    public void submitButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader recommendLoader = new FXMLLoader();
        recommendLoader.setLocation(getClass().getResource("Recommend.fxml"));
        Scene recommendScene = new Scene(recommendLoader.load());
        String recommendCSS = this.getClass().getResource("Recommend.css").toExternalForm();
        recommendScene.getStylesheets().add(recommendCSS);

        if(vaildSubmit()){
            stage.setScene(recommendScene);
        }
        else{
            submitMessageLabel.setText("請至少選擇1個類型");
        }
    }

    public boolean vaildSubmit(){
        return true;
    }

}
