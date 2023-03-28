package WalkwaySimulator;

public class Logger {
	/**
	 * print statement for vehicle info 
	 * @param colour
	 */
	public static void signalVehicles(String colour) {
		System.out.println("LIGHT: " + colour);
	}
	
	/**
	 * print statement for pedestrian info
	 * @param message
	 */
	public static void signalPedestrians(String message) {
		System.out.println("PEDESTRIANS: " + message);
	}
}
