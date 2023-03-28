package WalkwaySimulator.States;

import WalkwaySimulator.Context;
import WalkwaySimulator.States.VehicleStates.VehiclesEnabledState;

public class OperationalState extends State{
	protected boolean pedestrianWaiting;
	
	/**
	 * constructor
	 * @param c - context
	 * @param interval - state time in seconds
	 */
	public OperationalState(Context c, int interval) {
		super(c, interval);
		this.pedestrianWaiting = false;
	}
	
	/**
	 * constructor
	 * @param c - context
	 * @param interval - state time in seconds
	 * @param pedestrianWaiting - denotes if pedestrian currently waiting
	 */
	public OperationalState(Context c, int interval, boolean pedestrianWaiting) {
		super(c, interval);
		this.pedestrianWaiting = pedestrianWaiting;
	}

	@Override
	public State timeout() {
		return new VehiclesEnabledState(this.context, 0, this.pedestrianWaiting);
	}	

}
