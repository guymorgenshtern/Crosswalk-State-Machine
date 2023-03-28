package WalkwaySimulator.States.PedestrianStates;

import WalkwaySimulator.Context;
import WalkwaySimulator.Logger;
import WalkwaySimulator.States.State;

public class PedestriansWalkState extends PedestriansEnabledState{

	/**'
	 * 
	 * @param c - context
	 * @param interval - state interval
	 */
	public PedestriansWalkState(Context c, int interval) {
		super(c, interval);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public State timeout() {
		return new PedestriansFlashState(this.context, 2, 7, false);
	}
	
	@Override
	public void handleState() {
		Logger.signalPedestrians("WALK");
	}

}
