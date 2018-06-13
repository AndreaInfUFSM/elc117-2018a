import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.TextField;

public class TableViewExample5 extends Application {
  
  public class DataEntry {
    private SimpleStringProperty first;
    private SimpleStringProperty second;
    
    private DataEntry(String f, String s) {
      this.first = new SimpleStringProperty(f);
      this.second = new SimpleStringProperty(s);
    }
    public SimpleStringProperty firstProperty() {
      return first;
    }
    public String getFirst() {
      return first.get();
    }
    public void setFirst(String f) {
      first.set(f);
    }
    public SimpleStringProperty secondProperty() {
      return second;
    }
    public String getSecond() {
      return second.get();
    }
    public void setSecond(String s) {
      second.set(s);
    }
  }

  
  private final ObservableList<DataEntry> data =
    FXCollections.observableArrayList(
      new DataEntry("Aaaaa", "Bbbbb"),
      new DataEntry("Ccccc", "Ddddd"),
      new DataEntry("Eeeee", "Fffff"));
  
  @Override
  public void start(Stage stage) {
    Label label = new Label("TableView Example");
    
    TableView table = new TableView();
    TableColumn fstCol = new TableColumn("A");
    TableColumn sndCol = new TableColumn("B");
    table.getColumns().addAll(fstCol, sndCol);
    
    // Para evitar warnings
    // TableView<DataEntry> table = new TableView<DataEntry>();
    // TableColumn<DataEntry,String> fstCol = new TableColumn<DataEntry,String>("A");
    // TableColumn<DataEntry,String> sndCol = new TableColumn<DataEntry,String>("B");
    //table.getColumns().add(fstCol);
    //table.getColumns().add(sndCol);
    
    fstCol.setCellValueFactory(
      new PropertyValueFactory<DataEntry,String>("first"));
    sndCol.setCellValueFactory(
      new PropertyValueFactory<DataEntry,String>("second"));
    
    table.setItems(data);
    
    TextField txtfld = new TextField();
    
    Button btnAdd = new Button("Add");
    btnAdd.setOnAction(ev -> {
      data.add(new DataEntry("Ggggg",txtfld.getText()));
      System.out.println("added "+txtfld.getText());
    });
    
    
    Button btnDel = new Button("Del");
    btnDel.setOnAction(ev -> {
      int selectedIndex = table.getSelectionModel().getSelectedIndex();
      if (selectedIndex >= 0 && selectedIndex < data.size()) {
         System.out.println("Removing "+selectedIndex);
         data.remove(selectedIndex);
      } else {
        System.out.println("Selected:"+selectedIndex);
      }
    });
    
    
    VBox vbox = new VBox();
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 10, 10, 10));
    vbox.getChildren().addAll(label, table, txtfld, btnAdd, btnDel);
    
    stage.setScene(new Scene(vbox,180,400));
    stage.show();
  }
  
  
  public static void main(String[] args) {
    launch(args);
  }
}
