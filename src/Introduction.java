import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

public class Introduction {
    @FXML
    private Button turnbackButton;
    @FXML
    private Button starButton;
    @FXML
    private SVGPath starSVGPath;
    
    private String fullStar = "M22 9.24l-7.19-.62L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21 12 17.27 18.18 21l-1.63-7.03L22 9.24zM12 15.4l-3.76 2.27 1-4.28-3.32-2.88 4.38-.38L12 6.1l1.71 4.04 4.38.38-3.32 2.88 1 4.28L12 15.4z";
    private String emptyStar = "M12 17.27 18.18 21l-1.64-7.03L22 9.24l-7.19-.61L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21z";

    public void turnbackButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        FXMLLoader recommendLoader = new FXMLLoader(getClass().getResource("Recommend.fxml"));
        Scene recommendScene = new Scene(recommendLoader.load());
        String recommendCSS = this.getClass().getResource("Recommend.css").toExternalForm();
        recommendScene.getStylesheets().add(recommendCSS);

        stage.setScene(recommendScene);
    }

    public void starButtonOnAction(ActionEvent event) throws IOException{
        if(starSVGPath.getContent() == emptyStar){
            starSVGPath.setContent(fullStar);
        }
        else{
            starSVGPath.setContent(emptyStar);
        }
    }
}
