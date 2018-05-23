import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


interface BrowsableImageCollection<T> {
   public T forward();
   public T backward();
   public T current();
}

// Classe que encapsula uma implementacao de uma colecao 'navegavel' de imagens.
// Outras implementacoes sao possiveis: por exemplo, pode-se otimizar o codigo 
// para evitar criar uma nova imagem (new Image) a cada chamada de metodo.
class ImageModel implements BrowsableImageCollection<Image> {

   private List<String> names = Arrays.asList("acacia.png", 
                                              "carvalho.png",
                                              "carvalhoescuro.png", 
                                              "eucalipto.png", 
                                              "pinheiro.png",
                                              "selva.png");
   private int curr = 0;
   
   public Image forward() {
      curr = curr == names.size()-1 ? 0 : curr+1;
      return current();
   }
   public Image backward() {
      curr = curr == 0 ? names.size()-1 : curr-1;
      return current();
   }
   public Image current() {
      return new Image(names.get(curr));
   }
}



public class ImageBrowser extends Application {


   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage stage) {

      BrowsableImageCollection<Image> images = new ImageModel();

      ImageView imageView = new ImageView(images.current());
      Button btnBack = new Button("<");
      Button btnFwd = new Button(">");

      btnBack.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            imageView.setImage(images.backward());
         }
      });

      btnFwd.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            imageView.setImage(images.forward());
         }
      });

      HBox root = new HBox();
      root.setAlignment(Pos.CENTER);
      root.getChildren().addAll(btnBack,imageView,btnFwd);
      stage.setTitle("Blocos de Madeira");
      stage.setScene(new Scene(root, 300, 250));
      stage.show();
   }
}
