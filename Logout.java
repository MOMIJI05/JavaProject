import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class Logout{
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

    public void submitButtonOnAction(ActionEvent event){
        submitMessageLabel.setText("請至少選擇1個類型");
    }
}