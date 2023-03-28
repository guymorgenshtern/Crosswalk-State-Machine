package WalkwaySimulator.States.VehicleStates;

import WalkwaySimulator.Context;
import WalkwaySimulator.Logger;
import WalkwaySimulator.States.State;
import WalkwaySimulator.States.PedestrianStates.PedestriansEnabledState;

public class VehiclesYellowState extends VehiclesEnabledState{

	/**
	 * 
	 * @param c - context
	 * @param interval - state interval
	 */
	public VehiclesYellowState(Context c, int interval) {
		super(c, interval);
	}
	
	@Override
	public State timeout() {
		return new PedestriansEnabledState(this.context, 0);
	}
	
	@Override
	public void handleState() {
		Logger.signalVehicles("YELLOW");
	}

}
