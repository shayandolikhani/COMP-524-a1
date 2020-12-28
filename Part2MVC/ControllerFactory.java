package Part2MVC;

public class ControllerFactory {
	static Controller controller;
	
	public static Controller getSingleton() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	public static void setController(Controller newcontroller) {
		controller = newcontroller;
	}
	
}
