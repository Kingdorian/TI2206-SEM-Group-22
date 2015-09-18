package spaceinvaders.group_22.logger;

import static org.junit.Assert.fail;

import java.io.File;
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
		
		String folder = System.getProperty("user.dir");
		new File(folder).mkdirs();
		File file = new File(folder, "/logs/testlog1.log");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		folder = folder + "/logs/testlog1.log";
		LogWriter logWriter = new LogWriter(folder, eventList);
		new Thread(logWriter).start();
		try {
			Thread.sleep(300);
			List<String> fileContent = Files.readAllLines(Paths.get(folder), StandardCharsets.UTF_8);
			Assert.assertEquals(event1.toString(), fileContent.get(0));
			Assert.assertEquals(event2.toString(), fileContent.get(1));
			System.out.println(new File(folder).delete());
		} catch (IOException e) {
			e.printStackTrace();
			fail("error reading file");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
