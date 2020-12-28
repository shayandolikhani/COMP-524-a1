package Part2MVC;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

import A1Java.SocialDistancingUtility;

public class DerivedModel extends AbstractModel {
	
	public DerivedModel() {
		
	}
	
	@Override
	public Boolean isSafe() {
		return A1Java.SocialDistancingUtility.isDerivedSafe(getDistance(), getDuration(), getExhalation());
	}

}
