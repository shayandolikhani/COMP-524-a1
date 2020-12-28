package Part3Weka;
import gradingTools.comp524f20.assignment1.WekaUtil;
import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;


public class SocialDistanceClassifierFactory {
	static Classifier Singleton;

	
	public static Classifier getSingleton() {
		if (Singleton == null) {
			Singleton = new J48();
			WekaUtil.buildTreeModel(Singleton, "SafeSocialization.txt");
		}
		return Singleton;
	}
	
	public static void setClassifier(Classifier newclassifier) {
		Singleton = newclassifier;
	}
}