package spaceinvaders.group_22.logger;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
/**
 * Class used to write logs to a file.
 * @author Dorian
 *
 */
public class LogWriter  implements Runnable{
	
	/**
	 * Location of the logfile.
	 */
	private String logLocation;
	/**
	 * List of logEvents to write to the file.
	 */
	private ArrayList<LogEvent> eventList;
	/**
	 * Creates a new WriteLog object.
	 * @param location the location of the log file
	 */
	public LogWriter(final String location, final ArrayList<LogEvent> allEvents) {
		eventList = allEvents;
		logLocation = location;
	}
	/**
	 * Cleares the log file.
	 */
	public void clearLogFile() {
		try {
			FileWriter writer = new FileWriter(logLocation, false);
			writer.write("");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Writes the list of logItems to the logfile.
	 * @param allEvents all the events that are logged
	 */
	@Override
	public void run() {
		BufferedWriter writer;
		try {
			System.out.println(logLocation);
			FileWriter fstream = new FileWriter(logLocation, true);
			writer = new BufferedWriter (fstream);
			for (LogEvent event : eventList) {
				writer.write(event.toString());
				writer.newLine();
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
