import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


public class TableViewExampleChart extends Application {
  
  public class DataEntry {
    private SimpleStringProperty first;
    private SimpleDoubleProperty second;
    
    private DataEntry(String f, Double s) {
      this.first = new SimpleStringProperty(f);
      this.second = new SimpleDoubleProperty(s);
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
    public SimpleDoubleProperty secondProperty() {
      return second;
    }
    public Double getSecond() {
      return second.get();
    }
    public void setSecond(Double s) {
      second.set(s);
    }
  }
  
  private final ObservableList<DataEntry> data =
    FXCollections.observableArrayList(
      new DataEntry("A", 3.5),
      new DataEntry("B", 5.0),
      new DataEntry("C", 4.0));

  private TableView createTableView(ObservableList<DataEntry> data) {
  
    TableView table = new TableView();
    TableColumn fstCol = new TableColumn("Category");
    TableColumn sndCol = new TableColumn("Value");
    table.getColumns().addAll(fstCol, sndCol);
    
    // Para evitar warnings
    // TableView<DataEntry> table = new TableView<DataEntry>();
    // TableColumn<DataEntry,String> fstCol = new TableColumn<DataEntry,String>("Category");
    // TableColumn<DataEntry,String> sndCol = new TableColumn<DataEntry,String>("Value");
    //table.getColumns().add(fstCol);
    //table.getColumns().add(sndCol);
    
    fstCol.setCellValueFactory(
      new PropertyValueFactory<DataEntry,String>("first"));
    sndCol.setCellValueFactory(
      new PropertyValueFactory<DataEntry,String>("second"));
    
    table.setItems(data);
    return table;
  }
  
  private BarChart<String,Number> createBarChart(ObservableList<DataEntry> data) {
    
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    BarChart<String,Number> bchart = 
      new BarChart<String,Number>(xAxis,yAxis);
      
    xAxis.setLabel("Category");
    yAxis.setLabel("Value");
 
    XYChart.Series series1 = new XYChart.Series();
    series1.setName("Series1");
    for (DataEntry entry : data) {
      series1.getData().add(new XYChart.Data(entry.getFirst(), entry.getSecond()));
    }
    
    bchart.getData().addAll(series1);  
    return bchart;
  }
  
  @Override
  public void start(Stage stage) {
    
    TableView table = createTableView(data);
    BarChart<String,Number> bchart = createBarChart(data);
    
    HBox hbox = new HBox();
    hbox.setSpacing(5);
    hbox.setPadding(new Insets(10, 10, 10, 10));
    hbox.getChildren().addAll(table, bchart);
    
    stage.setTitle(this.getClass().getName());
    stage.setScene(new Scene(hbox,600,400));
    stage.show();
  }
  
  
  public static void main(String[] args) {
    launch(args);
  }
}
