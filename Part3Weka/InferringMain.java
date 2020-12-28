package Part3Weka;
import Part2MVC.MVCsetup;
import Part2MVC.ModelFactory;

public class InferringMain {
	public static void main (String[] args) {
		ModelFactory.setModel(new WekaModel());
		MVCsetup.startSafeMVC("Weka");
	}

}
