package spaceinvaders.group_22.ui.multiplayergameui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import spaceinvaders.group_22.ui.GameUIController;
import spaceinvaders.group_22.ui.GameUIControllerTest;

/**
 * Test class for a SinglePlayerGameUI.
 * @author Jochem
 *
 */
public class MultiPlayerGameUIControllerTest extends GameUIControllerTest {

	@Override
	public final GameUIController createInstance() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../MultiPlayerGameUI.fxml"));
			fxmlLoader.load();
			return fxmlLoader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
