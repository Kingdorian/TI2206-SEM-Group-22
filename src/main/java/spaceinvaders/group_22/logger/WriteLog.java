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
	public final void write(final ArrayList<LogEvent> allEvents) {
		BufferedWriter writer;
		try {

			FileWriter fstream = new FileWriter(logLocation, true);
			writer = new BufferedWriter (fstream);
			for (LogEvent event : allEvents) {
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
