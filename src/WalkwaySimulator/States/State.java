package WalkwaySimulator.States;

import WalkwaySimulator.Timer;
import WalkwaySimulator.Context;

public abstract class State {
	protected Context context;
	
	/**
	 * constructor
	 * @param c
	 * @param interval
	 */
	public State(Context c, int interval) {
		this.context = c;
		new Timer(c, interval);
	}
	
	/**
	 * template for state timeout method
	 * @return
	 */
	public abstract State timeout();
	
	/**
	 * default for handleState method
	 */
	public void handleState() {
		System.out.println("------------------");
	}
	
	/** 
	 * default for pedestrianWaiting method
	 * @return
	 */
	public State pedestrianWaiting() {
		return this;
	}
	
}
