package spaceinvaders.group_22;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import spaceinvaders.group_22.JavaArgumentReader;

/**
 * Test for the argument reader.
 * @author Jochem
 *
 */
@RunWith(Parameterized.class)
@SuppressWarnings("checkstyle:magicnumber")   
public class JavaArgumentReaderTest {

	/**
	 * Static game used for testing.
	 */
	private static JavaArgumentReader reader;
	
	/**
	 * Method defining logLevel parameters.
	 * @return The loglevel parameters to test.
	 */
	@Parameters
	public static Collection<Object[]> logParameters() {
		return Arrays.asList(new Object[][] { 
			{ new String[]{"-log=-42"}, 0 }, 
			{ new String[]{"-log=0"}, 0 }, 
			{ new String[]{"-log=1"}, 1 }, 
			{ new String[]{"-log=2"}, 2 }, 
			{ new String[]{"-log=3"}, 3 }, 
			{ new String[]{"-log=4"}, 4 }, 
			{ new String[]{"-log=5"}, 5 }, 
			{ new String[]{"-log=42"}, 0 }, 
		});
	}
	
	/**
	 * The argument string.
	 */
    private String[] arg;
    
    /**
     * The expected outcome for an argument string.
     */
    private int expectedLoglevel;

    /**
     * Constructor for a JavaArgumentReaderTest.
     * @param input	The arguments to evaluate.
     * @param expected The expected outcome for this arguments.
     */
    public JavaArgumentReaderTest(final String[] input, final int expected) {
            arg = input;
            expectedLoglevel = expected;
    }
	
	
	/**
	 * Test the decrease time left method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void testReadLogLevel() {
		reader = new JavaArgumentReader(arg);
		assertEquals(reader.parseLogLevel(), expectedLoglevel);
	}

}
