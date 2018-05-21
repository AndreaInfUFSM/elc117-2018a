import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;


// Exemplo em JavaFX com tratamento de evento associado a um objeto da classe Button
// Ver mais sobre classes anonimas em:
// https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html


public class HelloButtonLabel extends Application {
   public static void main(String[] args) {
      launch(args);
   }
   public void start(Stage stage) {
      VBox vb = new VBox();
      vb.setSpacing(10);
      vb.setAlignment(Pos.CENTER);
      Label lbl = new Label("");
      Button btn = new Button("Say Hello");
      // Abaixo, classe anonima eh usada para implementar o tratamento 
      // do evento que ocorre quando usuario clica no objeto Button
      btn.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            lbl.setText("Hello");
         }
      });
      vb.getChildren().addAll(lbl, btn);
      stage.setScene(new Scene(vb, 250, 100));
      stage.show();
   }
}


