package spaceinvaders.group_22.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class that data that is related to a single LogEvent is stored in.
 * @author Dorian
 *
 */
public class LogEvent {
	/*
	 * The time the event happended.
	 */
	private String time;
	/**
	 * The description of the event.
	 */
	private String description;
	/**
	 * The exception that happened.
	 */
	private Exception exception;
	/**
	 * Enum that indicates the type of event.
	 */
	Type type;
	/**
	 * Enum to indicate different log levels.
	 * @author Dorian
	 *
	 */
	public enum Type {
		ERROR, WARNING, INFO, DEBUG, TRACE; 
	}
	/**
	 * Creates a new logEvent.
	 * @param type the type of event.
	 * @param event a discription of the event.
	 */
	public LogEvent(Type type, String event) {
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		//Get the current date+time
		Date date = new Date();
		time = timeFormat.format(date);
		this.type = type;
	}
	/**
	 * Creates a exception new logEvent.
	 * @param type the type of event.
	 * @param event a discription of the event.
	 */
	public LogEvent(Exception exception, Type type, String event) {
		this(type, event);
		this.exception = exception;
	}
}
