package Part2MVC;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

import A1Java.SocialDistancingUtility;

public class GivenModel extends AbstractModel {
	
	public GivenModel() {
		
	}
	
	@Override
	public Boolean isSafe() {
		return A1Java.SocialDistancingUtility.isGivenSafe(getDistance(), getDuration(), getExhalation());
	}

}
