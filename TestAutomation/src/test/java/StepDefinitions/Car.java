//Author: Ertuğrul Demir
package StepDefinitions;

public class Car {

	private int key_value = 345;
	private boolean started = false;
	
	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	boolean start(int key) {

		if (key_value == key) { 
			return true; 		//we can also change started value here 
		}
		return false;


	}

	
}
