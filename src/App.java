import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Login.fxml"));
            //loader.setLocation(getClass().getResource("Form.fxml"));
            //loader.setLocation(getClass().getResource("Recommend.fxml"));
            //loader.setLocation(getClass().getResource("Introduction.fxml"));
            //loader.setLocation(getClass().getResource("Favorities.fxml"));
            //loader.setLocation(getClass().getResource("DeleteAccount.fxml"));
            //loader.setLocation(getClass().getResource("Logout.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root);

            String css = this.getClass().getResource("Login.css").toExternalForm();
            //String css = this.getClass().getResource("Form.css").toExternalForm();
            //String css = this.getClass().getResource("Recommend.css").toExternalForm();
            //String css = this.getClass().getResource("Introduction.css").toExternalForm();
            //String css = this.getClass().getResource("Favorities.css").toExternalForm();
            //String css = this.getClass().getResource("DeleteAccount.css").toExternalForm();
            //String css = this.getClass().getResource("Logout.css").toExternalForm();
            scene.getStylesheets().add(css);

            primaryStage.setTitle("自動化電影推薦");
            Image icon = new Image("file:\\c:\\Users\\Addmin\\Desktop\\JavaProject\\resource\\stackOverflowIcon.png");
            primaryStage.getIcons().add(icon);
            primaryStage.setScene(scene);
            primaryStage.setWidth(1280);
            primaryStage.setHeight(800);
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
