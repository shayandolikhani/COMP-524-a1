package Part3Weka;
import A1Java.SocialDistancingUtility;
import Part2MVC.AbstractModel;

public class WekaModel extends AbstractModel {
	
	public WekaModel () {
		
	}


	@Override
	public Boolean isSafe() {
		return SocialDistancingUtility.isInferredSafe(getDistance(), getDuration(), getExhalation());
	}
	
	
	
}
