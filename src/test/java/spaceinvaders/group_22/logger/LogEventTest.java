package spaceinvaders.group_22.logger;


import org.junit.Assert;
import org.junit.Test;
/**
 * Test class for spaceinvaders.group_22.logger.LogEvent.class.
 * @author Dorian
 *
 */
public class LogEventTest {
	/**
	 * Tests the getException method.
	 */
	@Test
	public void testGetException() {
		Exception ex = new Exception();
		LogEvent event = new LogEvent(ex, null);
		Assert.assertEquals(ex, event.getException());
	}
	/**
	 * Tests the getDescription method.
	 */
	@Test
	public void testGetDescription() {
		LogEvent event = new LogEvent(LogEvent.Type.INFO, "this is a description");
		Assert.assertEquals("this is a description", event.getDescription());
	}
	/**
	 * Tests the getType method.
	 */
	@Test
	public void testGetType() {
		LogEvent event = new LogEvent(LogEvent.Type.WARNING, null);
		Assert.assertEquals(LogEvent.Type.WARNING, event.getType());
	}
	

}
