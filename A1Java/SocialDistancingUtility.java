package A1Java;

import Part3Weka.*;
import gradingTools.comp524f20.assignment1.WekaUtil;
import java.util.*;




public class SocialDistancingUtility {

	public static void main(String[] args) {
//		printGivenAndGeneratedCombinationsDerivedSafety();
//		printSafeDistancesAndDurations(9);
//	    printSafeDistancesAndDurations(11);
//	    printSafeDistancesAndDurations(51);
		
//		int safe = compareSafetyComputations();
//		System.out.println(safe);
		

	}
	
	static final int SMALL_DIST = 6;
	static final int MED_DIST = 13;
	static final int LARGE_DIST = 27;
	
	static final int SMALL_DUR = 15;
	static final int MED_DUR = 30;
	static final int LARGE_DUR = 120;
	
	static final int SMALL_EXH = 10;
	static final int MED_EXH = 30;
	static final int LARGE_EXH = 50;
			
	/* if the exact combination of the method parameters is safe, based on the given data, the function returns true,
	 * otherwise it returns false**/
	public static boolean isGivenSafe(int distance, int duration, int exhalation) {
		if (distance == MED_DIST && duration == MED_DUR) {
			if (exhalation == MED_EXH) {
				return true;
			}
		}
		
		else if (distance == SMALL_DIST && duration == MED_DUR) {
			if (exhalation == SMALL_EXH) {
				return true;
			}
		}
		
		else if (distance == LARGE_DIST && duration == MED_DUR) {
			if (exhalation == LARGE_EXH) {
				return true;
			}
		}
		
		else if (distance == MED_DIST && duration == SMALL_DUR) {
			if (exhalation == LARGE_EXH) {
				return true;
			}
		}
		
		else if (distance == MED_DIST && duration == LARGE_DUR) {
			if (exhalation == SMALL_EXH) {
				return true;
			}
		}
		
		else if (distance == LARGE_DIST && duration == LARGE_DUR) {
			if (exhalation == MED_EXH) {
				return true;
			}
		}
		
		else if (distance == SMALL_DIST && duration == SMALL_DUR) {
			if (exhalation == MED_EXH) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/* if the combination of the 3 interpolated values is safe based on the given data
	 * then the function will return true, otherwise it will return false   **/
	public static boolean isInterpolatedSafe(int distance, int duration, int exhalation) {
		distance = lowInterpolation(distance);
		duration = highInterpolationDur(duration);
		exhalation = highInterpolationExh(exhalation);
		
		if (isGivenSafe(distance, duration, exhalation)) {
			return true;
		}
		
		return false;
		
		
	}
	
	/* given a distance and duration value, interpolates the two and returns true 
	 * if the combination of the two with the medium exhalation value returns true,
	 * otherwise returns false **/
	public static boolean isInterpolatedSafe(int distance, int duration) {
		distance = lowInterpolation(distance);
		duration = highInterpolationDur(duration);
		
		if (isGivenSafe(distance, duration, MED_EXH)) {
			return true;
		}
		
		return false;
	}
	
	/* given a distance value, interpolates it and returns true 
	 * if the combination of the medium exhalation and medium duration values
	 * with it returns true, otherwise returns false **/
	public static boolean isInterpolatedSafe(int distance) {
		distance = lowInterpolation(distance);
		
		if (isGivenSafe(distance, MED_DUR, MED_EXH)) {
			return true;
		}
		
		return false;
	}
	
	
	
	public static boolean isInferredSafe(int distance, int duration, int exhalation) {
		 final String TRUE = "true";
		 final String FALSE = "false";
		 String resultAttributeName = "safe";
		 String[] resultValueNames = {TRUE, FALSE};
		 String[] featureNames = {"distance", "duration", "exhalation"};
		
		
		double[] anInputFeatureValues = {distance, duration, exhalation};
		String aResultString = WekaUtil.predictString(SocialDistanceClassifierFactory.getSingleton(), featureNames, anInputFeatureValues, resultAttributeName, resultValueNames);
		return TRUE.equals(aResultString) ?true:false;
	}
	
	
	
	
	//generates a random distance, duration, and exhalation combination,
	//tests if it is safe, and prints the results in a 4-tuple
	public static void printGeneratedCombinationDerivedSafety() {
		int randomDist = randomInt(4, 32);
		int randomDur = randomInt(13, 125);
		int randomExh = randomInt(8, 53);
		boolean safe = isDerivedSafe(randomDist, randomDur, randomExh);
		System.out.println(randomDist + "," + randomDur + "," + randomExh + "," + safe);
		
		
	}
	
	
	
	public static void printGeneratedCombinationInferredSafety() {
		int randomDist = randomInt(4, 32);
		int randomDur = randomInt(13, 125);
		int randomExh = randomInt(8, 53);
		boolean safe = isInferredSafe(randomDist, randomDur, randomExh);
		System.out.println(randomDist + "," + randomDur + "," + randomExh + "," + safe);
	}
	
	//prints each of the safe combinations from table two, 
	// then prints the results of calling printgeneratedcombination ten times
	public static void printGivenAndGeneratedCombinationsDerivedSafety() {
		System.out.println("Distance,Duration,Exhalation,IsSafe");
		
		System.out.println(MED_DIST + "," + MED_DUR + "," + MED_EXH + ",true");
		System.out.println(SMALL_DIST + "," + MED_DUR + "," + SMALL_EXH + ",true");
		System.out.println(LARGE_DIST + "," + MED_DUR + "," + LARGE_EXH + ",true");
		System.out.println(MED_DIST + "," + SMALL_DUR + "," + LARGE_EXH + ",true");
		System.out.println(MED_DIST + "," + LARGE_DUR + "," + SMALL_EXH + ",true");
		System.out.println(LARGE_DIST + "," + LARGE_DUR + "," + MED_EXH + ",true");
		System.out.println(SMALL_DIST + "," + SMALL_DUR + "," + MED_EXH + ",true");
		
		System.out.println("----------------");
		
		for (int i = 0; i < 10; i++) {
			printGeneratedCombinationDerivedSafety();
		}
	}
	
	
	public static void printGivenAndGeneratedCombinationsInferredSafety() {
	System.out.println("Distance,Duration,Exhalation,IsSafe");
		
		System.out.println(MED_DIST + "," + MED_DUR + "," + MED_EXH + ",true");
		System.out.println(SMALL_DIST + "," + MED_DUR + "," + SMALL_EXH + ",true");
		System.out.println(LARGE_DIST + "," + MED_DUR + "," + LARGE_EXH + ",true");
		System.out.println(MED_DIST + "," + SMALL_DUR + "," + LARGE_EXH + ",true");
		System.out.println(MED_DIST + "," + LARGE_DUR + "," + SMALL_EXH + ",true");
		System.out.println(LARGE_DIST + "," + LARGE_DUR + "," + MED_EXH + ",true");
		System.out.println(SMALL_DIST + "," + SMALL_DUR + "," + MED_EXH + ",true");
		
		System.out.println("----------------");
		
		for (int i = 0; i < 10; i++) {
			printGeneratedCombinationInferredSafety();
		}
		
	}
	
	
	// given an exhalation level, interpolates it and 
	// returns a possibly empty list of safe pairs of 
	// duration and distance values associated with it
	public static List<Integer[]> generateSafeDistancesAndDurations (int exhalation) {
		exhalation = highInterpolationExh(exhalation);
		if (exhalation == SMALL_EXH) {
			List<Integer[]> safelist= new ArrayList<Integer[]>();
			Integer[] pair1 = {SMALL_DIST, MED_DUR};
			Integer[] pair2 = {MED_DIST, LARGE_DUR};
			safelist.add(pair1);
			safelist.add(pair2);
			return safelist;
			
		}
		
		else if (exhalation == MED_EXH) {
			List<Integer[]> safelist= new ArrayList<Integer[]>();
			Integer[] pair1 = {MED_DIST, MED_DUR};
			Integer[] pair2 = {LARGE_DIST, LARGE_DUR};
			Integer[] pair3 = {SMALL_DIST, SMALL_DUR};
			safelist.add(pair1);
			safelist.add(pair2);
			safelist.add(pair3);
			return safelist;
		}
		
		else if (exhalation == LARGE_EXH) {
			List<Integer[]> safelist= new ArrayList<Integer[]>();
			Integer[] pair1 = {LARGE_DIST, MED_DUR};
			Integer[] pair2 = {MED_DIST, SMALL_DUR};
			safelist.add(pair1);
			safelist.add(pair2);
			return safelist;
		}
		
		List<Integer[]> safelist= new ArrayList<Integer[]>();
		return safelist;
	}
	
//	uses generateSafeDistancesAndDurations to determine
//	the list of safe distances and durations for the passed 
//	exhalation value and prints the list with the passed value
	public static void printSafeDistancesAndDurations(int exhalation) {
		List<Integer[]> returnedlist = generateSafeDistancesAndDurations(exhalation);
		System.out.print(exhalation + ",");
		System.out.print("[");
		for (int i = 0; i < returnedlist.size(); i++) {
			System.out.print("{");
			for (int j = 0; j < returnedlist.get(i).length; j++) {
				System.out.print(returnedlist.get(i)[j]);
				if (j != returnedlist.get(i).length - 1) {
					System.out.print(",");
				}
			}
			System.out.print("}");
		}
		System.out.print("]");
		System.out.print("\n");
		
	}
	
	
	
	public static int compareSafetyComputations() {
		System.out.println("Distance,Duration,Exhalation,Derived,Inferred");
		int count = 0;
		
		for (int i = 0; i < 10; i++) {
			int randomDist = randomInt(4, 32);
			int randomDur = randomInt(13, 125);
			int randomExh = randomInt(8, 53);
			boolean derivedSafe = isDerivedSafe(randomDist, randomDur, randomExh);
			boolean inferredSafe = isInferredSafe(randomDist, randomDur, randomExh);
			if (derivedSafe == inferredSafe) {
				count++;
			}
			System.out.println(randomDist + "," + randomDur + "," + randomExh + "," + derivedSafe + "," + inferredSafe);
		}
		
		return count;
		
	}
	
	
	
	
	
	
	/* returns true if the combination of the three given parameters is safer
	 * than at least one of the combinations in the data table, otherwise
	 * returns false**/
	public static boolean isDerivedSafe(int distance, int duration, int exhalation) {
		if (distance >= MED_DIST && duration <= MED_DUR) {
			if (exhalation <=  MED_EXH) {
				return true;
			}
		}
		
		if (distance >= SMALL_DIST && duration <= MED_DUR) {
			if (exhalation <=  SMALL_EXH) {
				return true;
			}
		}
		
		if (distance >= LARGE_DIST && duration <= MED_DUR) {
			if (exhalation <=  LARGE_EXH) {
				return true;
			}
		}
		
		if (distance >= MED_DIST && duration <= SMALL_DUR) {
			if (exhalation <=  LARGE_EXH) {
				return true;
			}
		}
		
		if (distance >= MED_DIST && duration <= LARGE_DUR) {
			if (exhalation <=  SMALL_EXH) {
				return true;
			}
		}
		
		if (distance >= LARGE_DIST && duration <= LARGE_DUR) {
			if (exhalation <=  MED_EXH) {
				return true;
			}
		}
		
		if (distance >= SMALL_DIST && duration <= SMALL_DUR) {
			if (exhalation <=  MED_EXH) {
				return true;
			}
		}
		
		return false;
	}
	
	//generate a random integer within a given range
	static int randomInt(int min, int max) {
		int range = (max - min) + 1;
		return (int)(Math.random() * range) + min;
	}
	
	
	
	
	
	
	
	
	/* given a distance value, returns the low interpolation of the value **/
	static int lowInterpolation(int distance) {
		
		if (distance >= LARGE_DIST) {
			distance = LARGE_DIST;
			return distance;
		}
		
		else if (distance >= MED_DIST) {
			distance = MED_DIST;
			return distance;
		}
		
		else if (distance >= SMALL_DIST) {
			distance = SMALL_DIST;
			return distance;
		}
		
		else if (distance < SMALL_DIST) {
			distance = 0;
			return distance;
		}
		
		return distance;
	}
	
	/*given a duration value, returns the high interpolation of the value**/
	static int highInterpolationDur(int duration) {
	
		if (duration > LARGE_DUR) {
			duration = Integer.MAX_VALUE;
			return duration;
		}
		
		else if (duration > MED_DUR) {
			duration = LARGE_DUR;
			return duration;
		}
		
		else if (duration > SMALL_DUR) {
			duration = MED_DUR;
			return duration;
		}
		
		else if (duration <= SMALL_DUR) {
			duration = SMALL_DUR;
			return duration;
		}
		
		return duration;
	}
	
	/* given an exhalation value, returns the high interpolation of the value **/
	static int highInterpolationExh(int exhalation) {
		
		if (exhalation > LARGE_EXH) {
			exhalation = Integer.MAX_VALUE;
			return exhalation;
		}
		
		else if (exhalation > MED_EXH) {
			exhalation = LARGE_EXH;
			return exhalation;
		}
		
		else if (exhalation > SMALL_EXH) {
			exhalation = MED_EXH;
			return exhalation;
		}
		
		else if (exhalation <= SMALL_EXH) {
			exhalation = SMALL_EXH;
			return exhalation;
		}
		
		return exhalation;
	}
	

}
