package Part2MVC;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

import A1Java.SocialDistancingUtility;

public abstract class AbstractModel {
	
	public static final String DIST = "Distance";
	public static final String DUR = "Duration";
	public static final String EXH = "Exhalation";
	public static final String SAFE = "Safe";
	
	Integer Distance = null;
	Integer Duration = null;
	Integer Exhalation = null;
	Boolean Safe = null;
	
	PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyChangeSupport.addPropertyChangeListener(aListener);
	}
	
	public Integer getDistance() {
		return Distance;
	}
	
	public Integer getDuration() {
		return Duration;
	}
	
	public Integer getExhalation() {
		return Exhalation;
	}
	
	public abstract Boolean isSafe();
	
	public void setValues(Integer distance, Integer duration, Integer exhalation) {
		Integer oldDistance = Distance;
		Integer oldDuration = Duration;
		Integer oldExhalation = Exhalation;
		Boolean oldSafe = Safe;
		Distance = distance;
		Duration = duration;
		Exhalation = exhalation;
		Safe = isSafe();
		propertyChangeSupport.firePropertyChange(DIST, oldDistance, Distance);
		propertyChangeSupport.firePropertyChange(DUR, oldDuration, Duration);
		propertyChangeSupport.firePropertyChange(EXH, oldExhalation, Exhalation);
		propertyChangeSupport.firePropertyChange(SAFE, oldSafe, Safe);
		resetProperties();
	}
	
	protected void resetProperties() {
		Distance = null;
		Duration = null;
		Exhalation = null;
		Safe = null;
	}
		
	
}
