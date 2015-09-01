package group22.space_invaders;
	
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.animation.Timeline;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			stage.setTitle("Templerun");
			Group root = new Group();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			Canvas canvas = new Canvas(900, 900);
			root.getChildren().add(canvas);
			final GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.setFill(Color.BLACK);
			gc.setStroke(Color.BLACK);
			gc.setLineWidth(0);
			gc.setFont(Font.font("Times New Roman", FontWeight.BOLD, 48));
			gc.fillText("TempleRun", 50, 50);
			gc.strokeText("TempleRun", 50, 50);
			
			 Timeline gameLoop = new Timeline();
		     gameLoop.setCycleCount( Timeline.INDEFINITE );
		        
			final Image player = new Image("testplayer.gif", 100, 0, false, false);
			final long timeStart = System.currentTimeMillis();
		    KeyFrame frame = new KeyFrame(
		    		Duration.seconds(0.017),                // 60 FPS
		            new EventHandler<ActionEvent>()
		            {
		                public void handle(ActionEvent ae)
		                {
		                    double t = (System.currentTimeMillis() - timeStart) / 1000.0; 
		                    // Clear the canvas
		                    gc.clearRect(0, 0, 900,900);
		                    gc.drawImage( player, 400-10*t, 600 );
		                }
            });
			
		     
	        gameLoop.getKeyFrames().add( frame );
	        gameLoop.play();
	        
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
