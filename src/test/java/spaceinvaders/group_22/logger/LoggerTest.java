package spaceinvaders.group_22.logger;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
/**
 * Test class for the spaceinvaders.group_22.logger.Logger class.
 * @author Dorian
 *
 */
public class LoggerTest {
	/**
	 * Tests the log method with an Exception as a parameter.
	 */
	@Test
	public void testLogEventException() {
		Logger logger = new Logger("", 5);
		LogEvent event = new LogEvent( new Exception(),  "A test Exception occurred" ); 
		logger.log("A test Exception occurred", new Exception());
		Assert.assertEquals(event, logger.getAllEvents().get(0));
	}
	/**
	 * Tests the log class for LogEvent.Type as a parameter.
	 */
	@Test
	public void testLogEvent() {
		Logger logger = new Logger("", 5);
		LogEvent event = new LogEvent( LogEvent.Type.INFO, "A test" ); 
		logger.log("A test", LogEvent.Type.INFO);
		Assert.assertEquals(event, logger.getAllEvents().get(0));
	}
	/**
	 * Tests the log method with an Exception with low loglevel.
	 */
	@Test
	public void testLogEventExceptionLowerLogLevel() {
		Logger logger = new Logger("", 0);
		LogEvent event = new LogEvent( new Exception(), "A test Exception occurred" ); 
		logger.log("A test Exception occurred", new Exception());
		Assert.assertEquals(new ArrayList<LogEvent>(), logger.getAllEvents());
	}
	/**
	 * Tests the log class for LogEvent.Type as a parameter when loglevel is lower then type.
	 */
	@Test
	public void testLogEventLowerLogLevel() {
		Logger logger = new Logger("", 1);
		LogEvent event = new LogEvent( LogEvent.Type.INFO, "A test" ); 
		logger.log("A test", LogEvent.Type.INFO);
		// Since the loglevel is lower then the level of the added logEvent
		// the LogEventlist should be an empty arrayList.
		Assert.assertEquals(new ArrayList<LogEvent>(), logger.getAllEvents());
	}
}
