package spaceinvaders.group_22.logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to log the events happening in the program.
 * @author Dorian
 *
 */
public final class Logger {
	
	/**
	 * The singleton unique instance of Logger.
	 */
	private static volatile Logger uniqueInstance;
	
	/**
	 * Location of the logfile.
	 */
	private String logFileLoc;
	/**
	 * ArrayList to store LogEvents..
	 */
	private ArrayList<LogEvent> allEvents = new ArrayList<LogEvent>();
	/**
	 * Indicates the level to log.
	 * 0 no logging
	 * 1 Errors only
	 * 2 Errors and Warnings
	 * 3 Errors, Warnings and Info
	 * 4 Errors, Warnings, Info and Debug
	 * 5 Errors, Warnings, Info, Debug and Trace 
	 */
	private static int logLevel;
	
	/**
	 * Creates a new logger object.
	 * @param logLocation the location of the log file
	 */
	private Logger(final String logLocation) {
		String folder = System.getProperty("user.dir");
		if (new File(folder).mkdirs()) {
			log("Create new directories", LogEvent.Type.INFO);
		}
		File file = new File(folder, logLocation);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		logFileLoc = folder + "/" + logLocation;
		LogWriter logWriter = new LogWriter(logFileLoc, null);
		logWriter.clearLogFile();
	}

	/**
	 * Returns the singleton instance of Logger.
	 * @return the Loggers unique instance.
	 */
	public static Logger getInstance() {
		if (uniqueInstance == null) {
			synchronized (Logger.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Logger("log.log");
		       }
			}	
		}
		return uniqueInstance; 
	}
	
	/**
	 * Logs an exception.
	 * @param description the description of this log item.
	 * @param exception the exception to log.
	 */
	public void log(final String description, final Exception exception) {
		if (logLevel >= LogEvent.Type.WARNING.getValue()) {
			LogEvent event = new LogEvent(exception, description);
			System.out.println(event.toString());
			allEvents.add(event);
			writeLog();
		}
	}
	/**
	 * Logs an event.
	 * @param description the description of this log item.
	 * @param type the type of this log item.
	 */
	public void log(final String description, final LogEvent.Type type) {
		if (logLevel >= type.getValue()) {
			LogEvent event = new LogEvent(type, description);
			System.out.println(event.toString());
			allEvents.add(event);
			// Only write when its a critical error.
			if(logLevel <= LogEvent.Type.INFO.getValue()) {
				writeLog();
			}
		}
	}
	/**
	 * Writes the log to a file.
	 */
	public void writeLog() {
		ArrayList<LogEvent> tempList = new ArrayList<LogEvent>(allEvents);
		LogWriter logWriter = new LogWriter(logFileLoc, tempList);
		new Thread(logWriter).start();
	}
	/**
	 * Returns all events logged untill this point.
	 * @return the events logged untill this point.
	 */
	public ArrayList<LogEvent> getAllEvents() {
		return allEvents;
	}
	
	/**
	 * Returns the location of the logfile.
	 * @return the location of the logfile.
	 */
	public String getLogFileLocation() {
		return logFileLoc;
	}
	
	/**
	 * Sets the log file location to another file.
	 * @param newLoc The new location of the logger file.
	 */
	public void setLogFileLocation(final String newLoc) {
		logFileLoc = newLoc;
	}
	
	/**
	 * Sets the log level to a different level.
	 * @param newLogLevel The new level of the logger.
	 */
	public static void setLogLevel(final int newLogLevel) {
		logLevel = newLogLevel;
	}
	/**
	 * Clears the logger.
	 */
	public void clear() {
		allEvents.clear();
	}	
}
