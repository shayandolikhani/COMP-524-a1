package Part2MVC;
import java.util.Scanner;

import A1Java.SocialDistancingUtility;

public class Controller {
	public Controller() {
		
	}
	
	public void processInput(String model) {
		Scanner in = new Scanner(System.in);
		for (;;) {
			System.out.println("Please enter data regarding your guest interaction.");
			System.out.println("Distance?");
			int distance = in.nextInt();
			if (distance < 0) {
				System.out.println("Quitting");
				break;
			}
			System.out.println("Duration?");
			int duration = in.nextInt();
			if (duration < 0) {
				System.out.println("Quitting");
				break;
			}
			System.out.println("Exhalation Level?");
			int exhalation = in.nextInt();
			if (exhalation < 0) {
				System.out.println("Quitting");
				break;
			}
			ModelFactory.getSingleton(model).setValues(distance, duration, exhalation);
			
		}
	}
}