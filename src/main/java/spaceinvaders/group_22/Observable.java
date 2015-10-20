package spaceinvaders.group_22;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class defining an Observable object.
 * @author Jochem
 *
 */
public abstract class Observable {
	
	
		
	/**
	 * List containing the observers subscribed to this observable.
	 */
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * Registers a new observer to the observable object.
	 * @param o Observer
	 */
	protected final void registerObserver(final Observer o) {
		observers.add(o);
	}
	
	/**
	 * Removes an observer to the observable object.
	 * @param o Observer to remove
	 */
	protected final void removeObserver(final Observer o) {
		if (observers.contains(o)) {
			observers.remove(o);
		}
	}
	
	/**
	 * Notifies the observers about a change.
	 */
	protected final void notifyObservers() {
		for (Observer o : observers) {
			o.update(this);
		}
	}
}
