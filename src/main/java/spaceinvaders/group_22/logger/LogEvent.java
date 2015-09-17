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
	public static enum Type {
		ERROR(1), WARNING(2), INFO(3), DEBUG(4), TRACE(5);
		
		private final int level;
		Type(int level) {
			this.level = level;
		}
		public int getValue() {
			return level;
		}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((exception == null) ? 0 : exception.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		// If objects are in the same memory location
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if ( !(obj instanceof LogEvent )) {
			return false;
		}
		// Cast object to Lo
		LogEvent other = (LogEvent) obj;
		if (this.description.equals(other.getDescription())) {
			
		}
		if (!(other.getException().getClass() != exception.getClass())) {
			return false;
		}
		if ( !time.equals(other.getTime())) {
			return false;
		}
		if (type != other.getType()) {
			return false;
		}
		return true;
	}
	/**
	 * Returns the time this LogEvent happened.
	 * @return the time this LogEvent happened.
	 */
	String getTime() {
		return time;
	}
	/**
	 * Returns the description of this LogEvent.
	 * @return the description of this LogEvent.
	 */
	String getDescription() {
		return description;
	}
	/**
	 * Returns the exception that this logEvent reports.
	 * @return the exception that this logEvent reports.
	 */
	Exception getException() {
		return exception;
	}
	/**
	 * Return the the type of LogEvent.
	 * @return the type of logEvent
	 */
	Type getType() {
		return type;
	}
	
}
