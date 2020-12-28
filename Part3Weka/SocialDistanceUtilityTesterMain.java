package Part3Weka;
import A1Java.SocialDistancingUtility;

public class SocialDistanceUtilityTesterMain {
	public static void main(String[] args) {
		SocialDistancingUtility.printGivenAndGeneratedCombinationsDerivedSafety();
		SocialDistancingUtility.printGivenAndGeneratedCombinationsInferredSafety();
		SocialDistancingUtility.compareSafetyComputations();
		SocialDistancingUtility.printSafeDistancesAndDurations(30);
		SocialDistancingUtility.printSafeDistancesAndDurations(29);
		SocialDistancingUtility.printSafeDistancesAndDurations(32);
		
		

	}

}
