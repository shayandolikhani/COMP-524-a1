package Part2MVC;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

import A1Java.SocialDistancingUtility;

public class ConsoleView implements SafeView {
	
	public ConsoleView() {
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (AbstractModel.DIST == evt.getPropertyName()) {
			System.out.println(evt);
		}
		if (AbstractModel.DUR == evt.getPropertyName()) {
			System.out.println(evt);
		}
		if (AbstractModel.EXH == evt.getPropertyName()) {
			System.out.println(evt);
		}
		if (AbstractModel.SAFE == evt.getPropertyName()) {
			Boolean safe = (Boolean) evt.getNewValue();
			System.out.println(evt);
			System.out.println(safe ? "Safe." : "Not Safe!");
		}
		
	}

}
