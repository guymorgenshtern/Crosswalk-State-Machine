package WalkwaySimulator;

public class Timer extends Thread{
	Context context;
	int interval;
	
	/**
	 * constructor
	 * @param c - context
	 * @param interval - in seconds
	 */
	public Timer (Context c, int interval) {
		this.context = c;
		this.interval = interval;
		this.start();
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(interval * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.timeout();
		
	}
}
