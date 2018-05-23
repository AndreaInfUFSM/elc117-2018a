import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class MouseLines extends Application {

   private Line line;

   @Override
   public void start(Stage stage) {
      Pane pane = new Pane();

      pane.setOnMousePressed(new EventHandler<MouseEvent>() {
         public void handle(MouseEvent e) {
            line = new Line(e.getX(), e.getY(), e.getX(), e.getY());
            pane.getChildren().add(line);
         }
      });

      pane.setOnMouseDragged(new EventHandler<MouseEvent>() {
         public void handle(MouseEvent e) {
            line.setEndX(e.getX());
            line.setEndY(e.getY());
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
