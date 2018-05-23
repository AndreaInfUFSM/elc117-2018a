import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class MouseCircles extends Application {

   private Circle c;

   @Override
   public void start(Stage stage) {
      Pane pane = new Pane();
      
      pane.setOnMousePressed(new EventHandler<MouseEvent>() {
         public void handle(MouseEvent e) {
            c = new Circle(e.getX(), e.getY(), 10, Color.RED);
            pane.getChildren().add(c);
         }
      });
      
      Scene scene = new Scene(pane, 600, 500);
      stage.setScene(scene);
      stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
