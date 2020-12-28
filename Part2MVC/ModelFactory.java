package Part2MVC;
import Part3Weka.WekaModel;

public class ModelFactory {
	static AbstractModel abstractModel;
	
	public static AbstractModel getSingleton(String model) {
		if (abstractModel == null) {
			if (model == "Derived") {
				abstractModel = new DerivedModel();
			}
			
			if (model == "Given") {
				abstractModel = new GivenModel();
			}
			
			if (model == "Interpolated") {
				abstractModel = new InterpolatedModel();
			}
			
			if (model == "Weka") {
				abstractModel = new WekaModel();
			}
		}
		
		return abstractModel;
	}
	
	
	public static AbstractModel getSingleton() {
		if (abstractModel == null) {
			abstractModel = new GivenModel();
		}
		
		return abstractModel;
	}
	
	
	
	public static void setModel(AbstractModel newmodel) {
		abstractModel = newmodel;
	}
	
}
