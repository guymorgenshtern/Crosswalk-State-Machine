package WalkwaySimulator.States.VehicleStates;

import WalkwaySimulator.Context;
import WalkwaySimulator.Logger;
import WalkwaySimulator.States.State;

public class VehiclesGreenState extends VehiclesEnabledState{
	/**
	 * 
	 * @param c - context
	 * @param interval - state interval
	 */
	public VehiclesGreenState(Context c, int interval) {
		super(c, interval);
	}
	
	/**
	 * 
	 * @param c - context
	 * @param interval - state interval
	 * @param pedestrianWaiting - pedestrian waiting flag
	 */
	public VehiclesGreenState(Context c, int interval, boolean pedestrianWaiting) {
		super(c, interval, pedestrianWaiting);
	}
	
	@Override
	/**
	 * if pedestrianWaiting, go straight to yellow, else go to extended green
	 */
	public State timeout() {
		if (this.pedestrianWaiting) {
			return new VehiclesYellowState(this.context, 3);
		} else {
			return new VehiclesGreenIntState(this.context, 0);
		}
	}
	
	@Override
	public void handleState() {
		Logger.signalVehicles("GREEN");
	}
	
	@Override
	public State pedestrianWaiting() {
		this.pedestrianWaiting = true;
		return this;
	}

}
