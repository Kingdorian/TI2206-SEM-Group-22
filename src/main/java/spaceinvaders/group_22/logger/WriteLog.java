package spaceinvaders.group_22.logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class WriteLog {
	
	/**
	 * Location of the logfile.
	 */
	private String logLocation;
	/**
	 * Creates a new WriteLog object.
	 */
	public WriteLog(String location) {
		logLocation = location;
	}
	/**
	 * Writes the list of logItems to the logfile.
	 * @param allEvents
	 */
	public void write(ArrayList<LogEvent> allEvents) {
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
