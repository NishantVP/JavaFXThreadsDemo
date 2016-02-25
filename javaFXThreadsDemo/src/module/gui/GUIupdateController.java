package module.gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import module.threads.BackgroundThread;

public class GUIupdateController implements Initializable {
	
	@FXML Label count;
	private Task<Boolean> task;
	private String updateString;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		BackgroundThread p = new BackgroundThread(this);
	    new Thread(p).start();
	    
	    task = new Task<Boolean>() {
            @Override 
            public Boolean call() {    
            	System.out.println("this");
                final AtomicInteger i = new AtomicInteger(0);
                for( ; i.get() < 20; i.incrementAndGet()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                        	count.setText(updateString);                      
                        }
                    });

                try {
                  Thread.sleep(1000);
                }
                catch (InterruptedException e) {}
            }
            return Boolean.valueOf(true);               
          }        
       };           
       
      
	}
	
	public void updateLabel(String s) {
		this.updateString = s;
		Thread th = new Thread(task);
	       th.setDaemon(true);
	       th.start();
	       
		//count.setText(s);
	}

}
