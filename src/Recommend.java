import java.io.IOException;

import javafx.application.Platform;
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
    @FXML
    private Button movieButton1;
    @FXML
    private Button movieButton2;
    @FXML
    private Button movieButton3;
    @FXML
    private Button movieButton4;
    @FXML
    private Button movieButton5;
    @FXML
    private Button movieButton6;
    @FXML
    private Label movieName1;
    @FXML
    private Label movieName2;
    @FXML
    private Label movieName3;
    @FXML
    private Label movieName4;
    @FXML
    private Label movieName5;
    @FXML
    private Label movieName6;


    public void submitButtonOnAction(ActionEvent event){
        recommendMessageLabel.setText("請至少選擇1個類型");
    }

    public void accountButtonOnAction(ActionEvent event) throws IOException{
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

    public void movieButtonOnAction(ActionEvent event) throws IOException{
        String movieButtonId = ((Button)event.getSource()).getId();
        Label movieLabel;
        String movieName;
        if(movieButtonId.equals("movieButton1")) movieLabel = movieName1;
        else if(movieButtonId.equals("movieButton2")) movieLabel = movieName2;
        else if(movieButtonId.equals("movieButton3")) movieLabel = movieName3;
        else if(movieButtonId.equals("movieNutton4")) movieLabel = movieName4;
        else if(movieButtonId.equals("movieNutton4")) movieLabel = movieName5;
        else movieLabel = movieName6;

        movieName = movieLabel.getText();
        // System.out.println(movieButtonId);
        // System.out.println(movieName);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Platform.runLater(() -> {
            Loading loading = new Loading(stage);
            loading.show();

            new Thread(() -> {
                try{
                    FXMLLoader introductionLoader = new FXMLLoader(getClass().getResource("Introduction.fxml"));
                    Scene introductionScene = new Scene(introductionLoader.load());
                    String introductionCSS = this.getClass().getResource("Introduction.css").toExternalForm();
                    introductionScene.getStylesheets().add(introductionCSS);

                    Platform.runLater(() -> {
                        stage.setScene(introductionScene);
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
