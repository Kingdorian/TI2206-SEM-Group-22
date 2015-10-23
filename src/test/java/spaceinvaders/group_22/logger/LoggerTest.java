package spaceinvaders.group_22.logger;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
/**
 * Test class for the spaceinvaders.group_22.logger.Logger class.
 * @author Dorian
 *
 */
@SuppressWarnings("checkstyle:magicnumber")   
public class LoggerTest {
	/**
	 * Tests the log method with an Exception as a parameter.
	 */
	@Test
	public final void testLogEventException() {
		Logger logger = Logger.getInstance();
		logger.setLogLevel(5);
		logger.clear();
		LogEvent event = new LogEvent(new Exception(), "A test Exception occurred"); 
		logger.log("A test Exception occurred", new Exception());
		Assert.assertTrue(logger.getAllEvents().contains(event));
		logger.setLogLevel(1);
	}
	/**
	 * Tests the log method with an Exception with low loglevel.
	 */
	@Test
	public final void testLogEventExceptionLowerLogLevel() {
		Logger logger = Logger.getInstance();
		logger.setLogLevel(0);
		logger.clear();
		logger.log("A test Exception occurred", new Exception());
		LogEvent event = new LogEvent(new Exception(), "A test Exception occurred"); 
		Assert.assertFalse(logger.getAllEvents().contains(event));
		logger.setLogLevel(1);
	}
	/**
	 * Tests the log class for LogEvent.Type as a parameter when loglevel is lower then type.
	 */
	@Test
	public final void testLogEventLowerLogLevel() {
		Logger logger = Logger.getInstance();
		logger.clear();
		logger.log("A test", LogEvent.Type.INFO);
		LogEvent event = new LogEvent(LogEvent.Type.INFO, "A test"); 
		// Since the loglevel is lower then the level of the added logEvent
		// the LogEventlist should be an empty arrayList.
		Assert.assertFalse(logger.getAllEvents().contains(event));
	}
}
