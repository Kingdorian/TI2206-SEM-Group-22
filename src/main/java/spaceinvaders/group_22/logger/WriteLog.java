package spaceinvaders.group_22.logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
/**
 * Class used to write logs to a file.
 * @author Dorian
 *
 */
public class WriteLog {
	
	/**
	 * Location of the logfile.
	 */
	private String logLocation;
	/**
	 * Creates a new WriteLog object.
	 * @param location the location of the log file
	 */
	public WriteLog(final String location) {
		logLocation = location;
	}
	/**
	 * Writes the list of logItems to the logfile.
	 * @param allEvents all the events that are logged
	 */
	public final void write(final ArrayList<LogEvent> allEvents) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(logLocation, "UTF-8");
			for (LogEvent event : allEvents) {
				writer.println(event.toString());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// Even my fridge supports UTF-8...
			e.printStackTrace();
		}
	}

}
