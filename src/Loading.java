import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Loading {
    private Stage stage;
    private StackPane root;

    public Loading(Stage owner){
        ImageView loadingImageView = new ImageView(new Image("https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExcjQ1a3pnOHVhMzBmaGY1NDVpbXoyOTR6eHJqM2Y3YWozaTN0cXp6MiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/1n6FOu976kb1yr5uW5/giphy.gif"));
        loadingImageView.setFitHeight(350);
        loadingImageView.setPreserveRatio(true);

        root = new StackPane();
        root.setMouseTransparent(true);
        root.setPrefSize(150, 100);
        root.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0, 0.3), null, null)));
        root.getChildren().addAll(loadingImageView);

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initOwner(owner);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setX(owner.getX());
        stage.setY(owner.getY());
        stage.setHeight(owner.getHeight());
        stage.setWidth(owner.getWidth());
    }

    public void show(){
        Platform.runLater(() -> stage.show());
    }

    public void closeStage(){
        Platform.runLater(() -> stage.close());
    }

}
