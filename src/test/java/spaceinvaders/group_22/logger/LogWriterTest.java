package spaceinvaders.group_22.logger;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for the LogWriter.
 * @author Dorian
 *
 */
public class LogWriterTest {
	/**
	 * Tests if a log is written correctly.
	 */
	@Test
	public void testWriteLog() {
		ArrayList<LogEvent> eventList = new ArrayList<LogEvent>();
		LogEvent event1 = new LogEvent(LogEvent.Type.INFO, "this is an event");
		LogEvent event2 = new LogEvent(new Exception(), "this is an event");
		eventList.add(event1);
		eventList.add(event2);
		LogWriter logWriter = new LogWriter("logs/log.log", eventList);
		logWriter.clearLogFile();
		new Thread(logWriter).start();
		try {
			List<String> fileContent = Files.readAllLines(Paths.get("logs/log.log"), StandardCharsets.UTF_8);
			Assert.assertEquals(event1.toString(), fileContent.get(0));
			Assert.assertEquals(event2.toString(), fileContent.get(1));
		} catch (IOException e) {
			e.printStackTrace();
			fail("error reading file");
		}

		
	}
}
