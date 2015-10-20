package spaceinvaders.group_22;

/**
 * Interface for observers.
 * @author Jochem
 *
 */
public interface Observer {

	/**
	 * Update method called if an observable object notifies.
	 * @param o An object which notifies.
	 */
	void update(Object o);
	
}
