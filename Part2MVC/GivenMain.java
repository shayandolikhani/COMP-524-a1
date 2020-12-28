package Part2MVC;

public class GivenMain {
	public static void main (String[] args) {
		ModelFactory.setModel(new GivenModel());
		MVCsetup.startSafeMVC("Given");
	}

}
