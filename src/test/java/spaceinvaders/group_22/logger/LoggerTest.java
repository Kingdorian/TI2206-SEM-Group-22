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
		Logger logger = new Logger("testlog.log", 5);
		LogEvent event = new LogEvent(new Exception(), "A test Exception occurred"); 
		logger.log("A test Exception occurred", new Exception());
		Assert.assertEquals(event, logger.getAllEvents().get(0));
	}
	/**
	 * Tests the log method with an Exception with low loglevel.
	 */
	@Test
	public final void testLogEventExceptionLowerLogLevel() {
		Logger logger = new Logger("testlog.log", 0);
		logger.log("A test Exception occurred", new Exception());
		Assert.assertEquals(new ArrayList<LogEvent>(), logger.getAllEvents());
	}
	/**
	 * Tests the log class for LogEvent.Type as a parameter when loglevel is lower then type.
	 */
	@Test
	public final void testLogEventLowerLogLevel() {
		Logger logger = new Logger("testlog.log", 1);
		logger.log("A test", LogEvent.Type.INFO);
		// Since the loglevel is lower then the level of the added logEvent
		// the LogEventlist should be an empty arrayList.
		Assert.assertEquals(new ArrayList<LogEvent>(), logger.getAllEvents());
	}
}
