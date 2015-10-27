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
	/**
	 * The time the event happened.
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
	@SuppressWarnings("checkstyle:visibilitymodifier")
	Type type;
	/**
	 * Enum to indicate different log levels.
	 * @author Dorian
	 *
	 */
	@SuppressWarnings("checkstyle:visibilitymodifier")
	public static enum Type {
		/**
		 * Program crashes or gets in an unrecoverable state.
		 */
		ERROR(1), 
		/**
		 * Something goes wrong but game still (partly) functions.
		 */
		WARNING(2),	
		/**
		 * Information over major events taking place in the program. 
		 */
		INFO(3), 
		/**
		 * Info that is not a major event but still interesting when debugging.
		 */
		DEBUG(4),
		/**
		 * Everything, Log all the things!
		 */
		TRACE(5);
		/**
		 * Int that indicates the level of this logEvent.
		 */
		private final int level;
		/**
		 * Creates a new Type.
		 * @param loglevel the level of this type.
		 */
		Type(final int loglevel) {
			level = loglevel;
		}
		/**
		 * The int value.
		 * @return the int value;
		 */
		public int getValue() {
			return level;
		}
	}
	/**
	 * Creates a new logEvent.
	 * @param logType the type of event.
	 * @param event a discription of the event.
	 */
	public LogEvent(final Type logType, final String event) {
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		//Get the current date+time
		Date date = new Date();
		time = timeFormat.format(date);
		type = logType;
		description = event;
	}
	/**
	 * Creates a exception new logEvent.
	 * @param logException the type of event.
	 * @param event a discription of the event.
	 */
	public LogEvent(final Exception logException, final String event) {
		this(Type.WARNING, event);
		exception = logException;
	}
	/**
	 * Creates a string representation of this LogEvent.
	 * @return a string representation of this LogEvent
	 */
	 @SuppressWarnings("checkstyle:designforextension")
	public String toString() {
		return  "["
				+ time 
				+ "] [" 
				+ type 
				+ "] " 
				+ description;
	}
	@SuppressWarnings({"checkstyle:designforextension", "checkstyle:equalshashcode"})
	@Override
	public boolean equals(final Object obj) {
		// If objects are in the same memory location
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LogEvent)) {
			return false;
		}
		// Cast object to Log
		LogEvent other = (LogEvent) obj;
		if (!this.description.equals(other.getDescription())) {
			return false;
		}
		if (other.getException() != null && exception.getClass() != null
				&& other.getException().getClass() != exception.getClass()) {
			return false;
		}
		if (!time.equals(other.getTime())) {
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
	final String getTime() {
		return time;
	}
	/**
	 * Returns the description of this LogEvent.
	 * @return the description of this LogEvent.
	 */
	public final String getDescription() {
		return description;
	}
	/**
	 * Returns the exception that this logEvent reports.
	 * @return the exception that this logEvent reports.
	 */
	public final Exception getException() {
		return exception;
	}
	/**
	 * Return the the type of LogEvent.
	 * @return the type of logEvent
	 */
	public final Type getType() {
		return type;
	}
	/**
	 * HashCode method.
	 * @return hashcode of this object
	 */
	@Override
	public final int hashCode() {
		  return 0;
	}
	
}
