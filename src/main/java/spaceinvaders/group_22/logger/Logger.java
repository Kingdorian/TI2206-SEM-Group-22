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
	 * Object tow write logs to a file.
	 */
	private WriteLog logWriter;
	/**
	 * Creates a new logger object.
	 * @param logLocation the location of the log file
	 */
	public Logger(String logLocation) {
		logWriter = new WriteLog(logLocation);
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
	/**
	 * Writes the log to a file.
	 */
	public void writeLog() {
		logWriter.write(allEvents);
	}
	
}
