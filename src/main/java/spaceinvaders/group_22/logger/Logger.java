package spaceinvaders.group_22.logger;

import java.util.ArrayList;

/**
 * Class to log the events happening in the program.
 * @author Dorian
 *
 */
public class Logger {
	/**
	 * ArrayList to store LogEvents..
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
	 * @param level the scope of logging between 0-5.
	 */
	public Logger(final String logLocation, final int level) {
		logWriter = new WriteLog(logLocation);
		logLevel = level;
	}
	/**
	 * Logs an exception.
	 * @param description the description of this log item.
	 * @param exception the exception to log.
	 */
	public final void log(final String description, final Exception exception) {
		if (logLevel >= LogEvent.Type.WARNING.getValue()) {
			LogEvent event = new LogEvent(exception, description);
			System.out.println(event.toString());
			allEvents.add(event);
		}
	}
	/**
	 * Logs an event.
	 * @param description the description of this log item.
	 * @param type the type of this log item.
	 */
	public final void log(final String description, final LogEvent.Type type) {
		if (logLevel >= type.getValue()) {
			LogEvent event = new LogEvent(type, description);
			System.out.println(event.toString());
			allEvents.add(event);
		}
	}
	/**
	 * Writes the log to a file.
	 */
	public final void writeLog() {
		logWriter.write(allEvents);
		allEvents.clear();
	}
	/**
	 * Returns all events logged untill this point.
	 * @return the events logged untill this point.
	 */
	public final ArrayList<LogEvent> getAllEvents() {
		return allEvents;
	}

	
}
