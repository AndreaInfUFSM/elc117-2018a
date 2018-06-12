import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.Cursor;
import javafx.application.Platform;


public class ThreadDemoFX extends Application implements AppendableView {
    
  private static final int NTHREADS = 2;
  private Label[] lblThread = new Label[NTHREADS];
  private Button[] btnRun = new Button[NTHREADS];
  private Button[] btnStop = new Button[NTHREADS];
  private TextArea[] txtArea = new TextArea[NTHREADS];
  
  private ThreadController controller = null;
    
  public static void main(String[] args) {
    launch(args);
  }
  
  public void start(Stage stage) {
    
    for (int i = 0; i < NTHREADS; i++) {
      lblThread[i] = new Label("Thread"+i);
      btnRun[i] = new Button("Run");
      btnStop[i] = new Button("Stop");
      txtArea[i] = new TextArea();
      txtArea[i].setEditable(false);
    }

    controller = new ThreadController(this);

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(10, 10, 10, 10));
    
    for (int i = 0; i < NTHREADS; i++) {
      final int t = i;
      btnRun[i].setOnAction(e -> {controller.runThread(t);});
      btnStop[i].setOnAction(e -> {controller.stopThread(t);});
      grid.add(lblThread[i], i, 0);
      grid.add(txtArea[i], i, 1);
      grid.add(btnRun[i], i, 2);
      grid.add(btnStop[i], i, 3);
    }
    for (Node n : grid.getChildren()) {
      GridPane.setHalignment(n,HPos.CENTER);
    }
    
    stage.setScene(new Scene(grid, 250, 300));
    stage.setOnCloseRequest(e -> Platform.exit());
    stage.show();
  }
  
  public FXAppendableText getTextArea(int i) {
    return new FXAppendableText(txtArea[i]);
  }
  
  public void setRunning(int i) {
    txtArea[i].clear();
    btnRun[i].setDisable(true);
    btnStop[i].setDisable(false);
  }
  
  public void setStopped(int i) {
    btnRun[i].setDisable(false);
    btnStop[i].setDisable(true);
  }
  
}


class FXAppendableText implements AppendableText {
  private TextArea textArea;
  
  public FXAppendableText(TextArea textArea) {
    this.textArea = textArea;
  }
  
  @Override
  public void append(final String s) {
    Platform.runLater(() -> {textArea.appendText(s);});
    
  }
  
}

