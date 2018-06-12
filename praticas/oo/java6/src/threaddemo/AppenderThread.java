class AppenderThread extends Thread {
  
  protected AppendableText textArea;
  protected static final int SLEEP_MILLIS = 1000;
  
  public AppenderThread(AppendableText textArea) {
    this.textArea = textArea;
  }
  
  public void run() {
    int i = 0;
    try {
      while (true) {
        final String str = "Counting: " + i + "\n";
        textArea.append(str);
        Thread.sleep(SLEEP_MILLIS);
        i++;
      }
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
    
  }
}
