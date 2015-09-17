package spaceinvaders.group_22.logger;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTest {

	@Test
	public void testLogEventException() {
		Logger logger = new Logger("", 5);
		LogEvent event = new LogEvent(new Exception(), LogEvent.Type.WARNING, "A test Exception occurred" ); 
		logger.log("A test Exception occurred", new Exception());
		Assert.assertEquals(event, logger.getAllEvents().get(0));
	}
	@Test
	public void testLogEvent() {
		Logger logger = new Logger("", 5);
		LogEvent event = new LogEvent(new Exception(), LogEvent.Type.INFO, "A test" ); 
		logger.log("A test", LogEvent.Type.INFO);
		Assert.assertEquals(event, logger.getAllEvents().get(0));
	}
}
