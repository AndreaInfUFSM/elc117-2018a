import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewExample1 extends Application {
  
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage stage) {
    Label label = new Label("TableView Example");
    
    TableView table = new TableView();
    TableColumn fstCol = new TableColumn("A");
    TableColumn sndCol = new TableColumn("B");
    table.getColumns().addAll(fstCol, sndCol);
    
    VBox vbox = new VBox();
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 10, 10, 10));
    vbox.getChildren().addAll(label, table);
    
    stage.setScene(new Scene(vbox,180,400));
    stage.show();
  }
}
