package Part2MVC;

public class MVCsetup {
	public static void startSafeMVC(String model) {
		ModelFactory.getSingleton(model).addPropertyChangeListener(ViewFactory.getSingleton());
		ControllerFactory.getSingleton().processInput(model);
	}

}
