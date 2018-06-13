import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.util.Map;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


//  Mostra piadas do Chuck Norris em TableView, usando a API deste site:
//  https://api.chucknorris.io/
//  Exemplifica também:
//    - CellFactory customizada para quebra de linha na segunda coluna
//    - Dialogs em JavaFX (ver mais em: http://code.makery.ch/blog/javafx-dialogs-official/)
//    - Uso de HttpURLConnection para comunicação com servidor web
//    - Uso de ScriptEngine para tratar JSON retornado pelo servidor web
//    - Bug na customização da quebra de linha :-) (primeira linha adicionada não se ajusta)
  
public class TableViewExampleJoke extends Application {
  
  private HttpJSONService http = new HttpJSONService();
  
  private TableView<TableData> table = new TableView<TableData>();
  
  private final ObservableList<TableData> data =
    FXCollections.observableArrayList();
  
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage stage) {
    
    Scene scene = new Scene(new Group());
    
    final Label label = new Label("TableView Example: Chuck Norris Jokes");
    label.setFont(new Font("Arial", 20));
    
    TableColumn<TableData,String> fstCol = new TableColumn<TableData,String>("Id");
    fstCol.setCellValueFactory(cellData -> cellData.getValue().idProperty());
    
    TableColumn<TableData,String> sndCol = new TableColumn<TableData,String>("Joke");
    sndCol.setCellValueFactory(cellData -> cellData.getValue().jokeProperty());
    
    sndCol.setCellFactory(column -> {
      return new TableCell<TableData, String>() {
        @Override
        protected void updateItem(String item, boolean empty) {
          super.updateItem(item, empty);
          if (item == null || empty) {
            setText(null);
            setStyle("");
          } else {
            Text text = new Text(item.toString());
            
            text.wrappingWidthProperty().bind(widthProperty());
            text.textProperty().bind(itemProperty());
            this.setWrapText(true);
            setGraphic(text);
            
          }
        }
      };
    });
    
    
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    table.getColumns().add(fstCol);
    table.getColumns().add(sndCol);

    table.setItems(data);
    
    Button btn = new Button("Add a joke");
    
    btn.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        Map json = null;
        try {
          json = http.sendGet("https://api.chucknorris.io/jokes/random");
        } catch (Exception e) {
          Alert alert = new Alert(AlertType.WARNING);
          alert.setTitle("Warning");
          alert.setHeaderText("Connection failed");
          alert.setContentText("Please check your Internet connection!");
          alert.showAndWait();
        }
        if (json != null)
          data.add(new TableData((String)json.get("id"), (String)json.get("value")));
      }
    });
    
    final VBox vbox = new VBox();
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 10, 10, 10));
    vbox.getChildren().addAll(label, table, btn);
    
    vbox.applyCss();
    vbox.layout();
    
    stage.setScene(new Scene(vbox, 500, 500));
    stage.show();
    
  }
  
  public class TableData {
    private final SimpleStringProperty id;
    private final SimpleStringProperty joke;
    
    private TableData(String id, String jk) {
      this.id = new SimpleStringProperty(id);
      this.joke = new SimpleStringProperty(jk);
    }
    public SimpleStringProperty idProperty() {
      return id;
    }
    public String getId() {
      return id.get();
    }
    public void setId(String id) {
      this.id.set(id);
    }
    public SimpleStringProperty jokeProperty() {
      return joke;
    }
    public String getJoke() {
      return joke.get();
    }
    public void setJoke(String jk) {
      this.joke.set(jk);
    }
    
  }
}


class HttpJSONService {
  
  private final String USER_AGENT = "Mozilla/5.0";
  private JSONParsing engine = new JSONParsing();
  
  // HTTP GET request
  public Map sendGet(String url) throws Exception {
        
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    
    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent", USER_AGENT);
    
    int responseCode = con.getResponseCode();
    
    System.out.println("\n'GET' request sent to URL : " + url);
    System.out.println("Response Code : " + responseCode);
    
    BufferedReader in = new BufferedReader(
      new InputStreamReader(con.getInputStream()));
    StringBuffer response = new StringBuffer();
    String inputLine;
    
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();
    
    // Print result
    // System.out.println(response.toString());

    // Parse JSON result
    JSONParsing engine = new JSONParsing();
    return engine.parseJSON(response.toString());
  }
  
}


class JSONParsing {
  
  private ScriptEngine engine;
  
  public JSONParsing() {
    ScriptEngineManager sem = new ScriptEngineManager();
    this.engine = sem.getEngineByName("javascript");
  }
  
  public Map parseJSON(String json) throws IOException, ScriptException {
    String script = "Java.asJSONCompatible(" + json + ")";
    Object result = this.engine.eval(script);
    Map contents = (Map) result;
    return contents;
  }
  
}

