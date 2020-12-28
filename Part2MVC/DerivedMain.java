package Part2MVC;

public class DerivedMain {
	public static void main (String[] args) {
		ModelFactory.setModel(new DerivedModel());
		MVCsetup.startSafeMVC("Derived");
	}

}
