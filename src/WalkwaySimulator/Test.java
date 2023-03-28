package WalkwaySimulator;

public class Test extends Thread {
	
	/**
	 * Separate thread for testing flow of state machine
	 */
	public Test() {
		this.start();
	}
	
	@Override
	public void run() {
		Context context = new Context();
		
		// during VehiclesGreenState
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        context.pedestrianWaiting();
                
        //during VehiclesGreenIntState
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                
        context.pedestrianWaiting();
        
        //during PedestriansFlashState
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                
        context.pedestrianWaiting();
	}
	
	public static void main(String[] args) {
		Test test = new Test();
	}
}
