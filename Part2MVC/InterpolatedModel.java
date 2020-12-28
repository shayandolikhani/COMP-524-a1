package Part2MVC;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

import A1Java.SocialDistancingUtility;

public class InterpolatedModel extends AbstractModel {
	
	public InterpolatedModel() {
		
	}
	
	@Override
	public Boolean isSafe() {
		if (getDuration() == null && getExhalation() == null) {
			return A1Java.SocialDistancingUtility.isInterpolatedSafe(getDistance());
		}
		
		if (getExhalation() == null) {
			return A1Java.SocialDistancingUtility.isInterpolatedSafe(getDistance(), getDuration());
		}
		
		return A1Java.SocialDistancingUtility.isInterpolatedSafe(getDistance(), getDuration(), getExhalation());
	}

}