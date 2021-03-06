package spaceinvaders.group_22.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * Class used to write logs to a file.
 * @author Dorian
 *
 */
public class LogWriter  implements Runnable {
	
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
	 * @param allEvents the events to be logged in this LogWriter
	 */
	public LogWriter(final String location, final ArrayList<LogEvent> allEvents) {
		eventList = allEvents;
		logLocation = location;
	}
	/**
	 * Cleares the log file.
	 */
	public final void clearLogFile() {
		try {
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(
					new FileOutputStream(new File(logLocation)), "UTF-8"));
			writer.write("");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Writes the list of logItems to the logfile.
	 */
	@Override
	public final void run() {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(new File(logLocation)), "UTF-8"));
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
