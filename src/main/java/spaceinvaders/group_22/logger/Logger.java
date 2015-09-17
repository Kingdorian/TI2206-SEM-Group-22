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
	 * Object to write logs to a file.
	 */
	private WriteLog logWriter;
	/**
	 * Indicates the level to log.
	 * 0 no logging
	 * 1 Errors only
	 * 2 Errors and Warnings
	 * 3 Errors, Warnings and Info
	 * 4 Errors, Warnings, Info and Debug
	 * 5 Errors, Warnings, Info, Debug and Trace 
	 */
	private int logLevel;
	/**
	 * Creates a new logger object.
	 * @param logLocation the location of the log file
	 * @param logLevel the scope of logging between 0-5.
	 */
	public Logger(String logLocation, int logLevel) {
		logWriter = new WriteLog(logLocation);
		this.logLevel = logLevel;
	}
	/**
	 * Logs an exception.
	 * @param description the description of this log item.
	 * @param exception the exception to log.
	 */
	public void log(String description, Exception exception) {
		if (logLevel >= LogEvent.Type.WARNING.getValue()) {
			allEvents.add(new LogEvent(exception, LogEvent.Type.ERROR, description));
		}
	}
	/**
	 * Logs an event.'
	 * @param description the description of this log item.
	 * @param type the type of this log item.
	 */
	public void log(String description, LogEvent.Type type) {
		if (logLevel >= type.getValue() ) {
			allEvents.add(new LogEvent(type, description));
		}
	}
	/**
	 * Writes the log to a file.
	 */
	public void writeLog() {
		logWriter.write(allEvents);
	}
	
}
