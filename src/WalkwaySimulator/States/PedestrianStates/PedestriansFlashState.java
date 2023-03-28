package WalkwaySimulator.States.PedestrianStates;

import WalkwaySimulator.Context;
import WalkwaySimulator.Logger;
import WalkwaySimulator.States.OperationalState;
import WalkwaySimulator.States.State;

public class PedestriansFlashState extends PedestriansEnabledState{
	private int pedestrianFlashCtr;
	private boolean pedestrianWaiting;
	
	/**
	 * constructor
	 * @param c - context
	 * @param interval - state time in seconds
	 * @param pedestrianFlashCtr - determines if flashing on or off
	 */
	public PedestriansFlashState(Context c, int interval, int pedestrianFlashCtr) {
		super(c, interval);
		this.pedestrianFlashCtr = pedestrianFlashCtr;
		this.pedestrianWaiting = false;
	}
	
	/**
	 * constructor
	 * @param c - context
	 * @param interval - state time in seconds
	 * @param pedestrianFlashCtr - determines if flashing on or off
	 * @param pedestrianWaiting - denotes if pedestrian currently waiting
	 */
	public PedestriansFlashState(Context c, int interval, int pedestrianFlashCtr, boolean pedestrianWaiting) {
		super(c, interval);
		this.pedestrianFlashCtr = pedestrianFlashCtr;
		this.pedestrianWaiting = pedestrianWaiting;
	}
	
	@Override
	/**
	 * pedestrianFlashCtr > 0 -> flash again, else restart state machine
	 */
	public State timeout() {
		
		if (pedestrianFlashCtr != 0) {
			return new PedestriansFlashState(this.context, 2, pedestrianFlashCtr, pedestrianWaiting);
		} else {
			return new OperationalState(context, 0, pedestrianWaiting);	
		}
	}
	
	@Override
	/**
	 * handles prints and decrementing flash counter
	 */
	public void handleState() {
		if ((pedestrianFlashCtr&1) == 0) {
			Logger.signalPedestrians("DONT_WALK");
		} else {
			Logger.signalPedestrians("---------");
		}
		
		this.pedestrianFlashCtr--;
	}
	
	/**
	 * sets pedestrianWaiting flag to true before returning
	 */
	public State pedestrianWaiting() {
		pedestrianWaiting = true;
		return super.pedestrianWaiting();
	}

}
