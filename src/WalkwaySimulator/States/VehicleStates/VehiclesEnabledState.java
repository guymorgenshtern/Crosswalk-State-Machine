package WalkwaySimulator.States.VehicleStates;

import WalkwaySimulator.Context;
import WalkwaySimulator.Logger;
import WalkwaySimulator.States.OperationalState;
import WalkwaySimulator.States.State;

public class VehiclesEnabledState extends OperationalState{

	/**
	 * 
	 * @param c - context
	 * @param interval - state interval
	 */
	public VehiclesEnabledState(Context c, int interval) {
		super(c, interval);
	}
	
	/**
	 * 
	 * @param c - context
	 * @param interval - state interval
	 * @param pedestrianWaiting - pedestrian waiting flag
	 */
	public VehiclesEnabledState(Context c, int interval, boolean pedestrianWaiting) {
		super(c, interval, pedestrianWaiting);
	}
	
	@Override
	public State timeout() {
		return new VehiclesGreenState(this.context, 10, this.pedestrianWaiting);
	}
	
	@Override
	public void handleState() {
		Logger.signalPedestrians("DONT_WALK");
	}

}
