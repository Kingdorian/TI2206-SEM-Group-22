package spaceinvaders.group_22.logger;

import java.util.ArrayList;

/**
 * Class to log the 
 * @author Dorian
 *
 */
public class Logger {
	/**
	 * ArrayList to store LogEvents.
	 */
	private ArrayList<LogEvent> allEvents = new ArrayList<LogEvent>();
	/**
	 * Creates a new logger object.
	 */
	public Logger() {
		
	}
	/**
	 * Logs an exception.
	 * @param description the description of this log item.
	 * @param exception the exception to log.
	 */
	public void log(String description, Exception exception) {
		allEvents.add(new LogEvent(exception, LogEvent.Type.ERROR, description));
	}
	/**
	 * Logs an event.'
	 * @param description the description of this log item.
	 * @param type the type of this log item.
	 */
	public void log(String description, LogEvent.Type type) {
		allEvents.add(new LogEvent(type, description));
	}
	
}
