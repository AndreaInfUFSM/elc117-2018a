import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloImage extends Application {
   public static void main(String[] args) {
      launch(args);
   }
   
   @Override
   public void start(Stage stage) {
      Image image = new Image("madeira.png");
      ImageView imageView = new ImageView(image);
      //imageView.setPreserveRatio(true);
      //imageView.setFitWidth(150);
      StackPane root = new StackPane();
      root.getChildren().add(imageView);
      stage.setScene(new Scene(root, 300, 250));
      stage.show();
   }
}
