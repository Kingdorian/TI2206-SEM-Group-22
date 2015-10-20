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
		LogEvent event = new LogEvent(new Exception(), "A test Exception occurred"); 
		logger.log("A test Exception occurred", new Exception());
		Assert.assertEquals(event, logger.getAllEvents().get(0));
	}
	/**
	 * Tests the log class for LogEvent.Type as a parameter.
	 */
/*	@Test
	public void testLogEvent() {
		Logger logger = new Logger("testlog.log", 5);
		
		logger.log("A test", LogEvent.Type.INFO);
		LogEvent event = new LogEvent( LogEvent.Type.INFO, "A test" );
		try (BufferedReader br = new BufferedReader(new FileReader(logger.getLogFileLocation()))) {
		    String line = br.readLine();
		    Assert.assertTrue(event.toString().contains("[INFO] A test"));
		} catch (IOException e) {
			e.printStackTrace();
			fail("error reading file");
		}

	}*/
	/**
	 * Tests the log method with an Exception with low loglevel.
	 */
	@Test
	public final void testLogEventExceptionLowerLogLevel() {
		Logger logger = Logger.getInstance();
		LogEvent event = new LogEvent(new Exception(), "A test Exception occurred"); 
		logger.log("A test Exception occurred", new Exception());
		Assert.assertEquals(new ArrayList<LogEvent>(), logger.getAllEvents());
	}
	/**
	 * Tests the log class for LogEvent.Type as a parameter when loglevel is lower then type.
	 */
	@Test
	public final void testLogEventLowerLogLevel() {
		Logger logger = Logger.getInstance();
		LogEvent event = new LogEvent(LogEvent.Type.INFO, "A test"); 
		logger.log("A test", LogEvent.Type.INFO);
		// Since the loglevel is lower then the level of the added logEvent
		// the LogEventlist should be an empty arrayList.
		Assert.assertEquals(new ArrayList<LogEvent>(), logger.getAllEvents());
	}
}
