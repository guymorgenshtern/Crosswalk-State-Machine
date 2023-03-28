package WalkwaySimulator.States.VehicleStates;

import WalkwaySimulator.Context;
import WalkwaySimulator.States.State;

public class VehiclesGreenIntState extends VehiclesEnabledState{

	/**
	 * constructor
	 * @param c - context
	 * @param interval - time
	 */
	public VehiclesGreenIntState(Context c, int interval) {
		super(c, interval);
	}
	
	/**
	 * timeout
	 */
	@Override
	public State timeout() {
		return this;
	}
	
	/**
	 * returns yellow as soon as pedestrian waiting is called
	 */
	@Override
	public State pedestrianWaiting() {
		return new VehiclesYellowState(this.context, 3);
	}

}
