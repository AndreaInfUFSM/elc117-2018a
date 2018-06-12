/**
 * @assoc - - - AppendableView
 * @navassoc - - "*" AppenderThread
 */
class ThreadController {
  
  private AppendableView view;
  private static final int NTHREADS = 2;
  private AppenderThread[] thr = new AppenderThread[NTHREADS];
  
  ThreadController(AppendableView view) {
    this.view = view;
    for (int i = 0; i < NTHREADS; i++)
      this.view.setStopped(i);  
  }
  
  void runThread(int i) {
    System.out.println("Running Thread"+i);
    // Set view to a running state
    this.view.setRunning(i);
    // Start running thread
    thr[i] = new AppenderThread(this.view.getTextArea(i));
    thr[i].start();

  }
  
  void stopThread(int i) {
    System.out.println("Stopping Thread"+i);
    if (thr[i] != null) {
      // Interrupt thread execution 
      thr[i].interrupt();
      // Set view to a stopped state
      this.view.setStopped(i);
    }
  }
  
}
