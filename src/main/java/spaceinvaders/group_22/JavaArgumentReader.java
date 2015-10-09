package spaceinvaders.group_22;

import java.util.Arrays;

/**
 * Class responsible for reading the java arguments.
 * @author Jochem
 *
 */
@SuppressWarnings("checkstyle:magicnumber") 
public class JavaArgumentReader {

	/**
	 * String containing the arguments.
	 */
	private String[] args;
	
	/**
	 * Constructor for the argumentreader.
	 * @param arguments The arguments to be read.
	 */
	public JavaArgumentReader(final String[] arguments) {
		args = arguments;
	}

	/**
	 * Returns the loglevel supplied using the argument -log=<integer>
	 * If the argument is not supplied, it returns a default value of 0.
	 * @return The loglevel specified. 
	 * If it is not specified it returns a default of 0.
	 */
	public final int parseLogLevel() {
		for (String arg : Arrays.asList(args)) {
			if (arg.startsWith("-log=")) {
				int i = Integer.parseInt(arg.substring(5));
				
				if (i >= 0 && i <= 5) {
					return i;		
					}
				}
			}
		return 0;
	}
}
