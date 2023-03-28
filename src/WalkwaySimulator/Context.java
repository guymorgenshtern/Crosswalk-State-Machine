package WalkwaySimulator;
import WalkwaySimulator.States.*;

public class Context {
	
	private State currState;
	
	/**
	 * Constructor
	 */
	public Context() {
		this.currState = new OperationalState(this, 0);
	}
	
	/**
	 * Timeout call on current state
	 */
	public void timeout() {
		changeState(currState.timeout());
	}
	
	/**
	 * signals to state that a pedestrian is waiting
	 */
	public synchronized void pedestrianWaiting() {
		System.out.println("--PEDESTRIAN WAITING--");
		changeState(currState.pedestrianWaiting());
	}
	
	/**
	 * handles the changing of states
	 * @param newState
	 */
	private void changeState(State newState) {
		this.currState = newState;
		this.currState.handleState();
	}
}

