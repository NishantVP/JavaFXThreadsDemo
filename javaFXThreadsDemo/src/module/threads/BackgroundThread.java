package module.threads;

import module.gui.GUIupdateController;

public class BackgroundThread implements Runnable {
	
	GUIupdateController uiController;
	
	public BackgroundThread(GUIupdateController controller) {
		this.uiController = controller;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(i < 25) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			uiController.updateLabel(Integer.toString(i));
			i++;
			//uiController.updateLabel("Hello");
			
		}

	}

}
