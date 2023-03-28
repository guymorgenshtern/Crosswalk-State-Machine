package WalkwaySimulator.States.PedestrianStates;

import WalkwaySimulator.Context;
import WalkwaySimulator.Logger;
import WalkwaySimulator.States.OperationalState;
import WalkwaySimulator.States.State;

public class PedestriansEnabledState extends OperationalState {

	public PedestriansEnabledState(Context c, int interval) {
		super(c, interval);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public State timeout() {
		return new PedestriansWalkState(this.context, 15);
	}
	
	@Override
	public void handleState() {
		Logger.signalVehicles("RED");
	}

}
