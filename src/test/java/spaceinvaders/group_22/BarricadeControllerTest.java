package spaceinvaders.group_22;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import spaceinvaders.group_22.ui.JavaFXThreadingRule;
import spaceinvaders.group_22.unit.Barricade;

public class BarricadeControllerTest {
	
	public BarricadeController barController;
	
	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	
	/**
	 * Class to set up a game before each test is executed.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void setUpBarControler() {
		barController = new BarricadeController(new Game(100, 100));
	}
	/**
	 * Tests if the getBarricades method works correctly.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testGetBarricades() {
		ArrayList<Barricade> barricades = new ArrayList<Barricade>();
		BarricadeController barricadeController = new BarricadeController(null);
		Barricade barricade = new  Barricade(10, 10);
		barricades.add(barricade);
		barricadeController.setBarricades(barricades);
		Assert.assertEquals(barricade, barricadeController.getBarricades().get(0));
	}

	/**
	 * Tests if the addBarricade method adds a barricade correctly.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testAddBarricade() {
		barController.setBarricades(new ArrayList<Barricade>());
		ArrayList<Barricade> barricades = new ArrayList<Barricade>();
		Barricade barricade = new Barricade(10, 10);
		barricades.add(barricade);
		barController.setBarricades(new ArrayList<Barricade>());
		barController.addBarricade(barricade);
		//Assert.assertEquals(barricades, game.getBarricades());
	}
}
