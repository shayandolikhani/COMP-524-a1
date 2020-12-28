package Part2MVC;

public class InterpolatedMain {
	public static void main (String[] args) {
		ModelFactory.setModel(new InterpolatedModel());
		MVCsetup.startSafeMVC("Interpolated");
	}
}
