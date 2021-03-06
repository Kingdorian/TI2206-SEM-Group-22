package spaceinvaders.group_22.ui;

import java.util.concurrent.CountDownLatch;

import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * A JUnit {@link Rule} for running tests on the JavaFX thread and performing
 * JavaFX initialisation.  To include in your test case, add the following code:
 * 
 * Source can be found here:
 * https://gist.github.com/andytill/3835914#file-javafxthreadingrule-java
 * 
 */
public class JavaFXThreadingRule implements TestRule {
    
    /**
     * Flag for setting up the JavaFX, we only need to do this once for all tests.
     */
    private static boolean jfxIsSetup;

    @Override
    public final Statement apply(final Statement statement, final Description description) {
        
        return new OnJFXThreadStatement(statement);
    }
    /**
     * JFX statement for JUnit.
     * @author Jochem
     *
     */
    private static class OnJFXThreadStatement extends Statement {
        /**
         * Used for testing.
         */
        private final Statement statement;
        /**
         * 
         * @param aStatement statement of JFX.
         */
        public OnJFXThreadStatement(final Statement aStatement) {
            statement = aStatement;
        }
        /**
         * Exception that could be thrown.
         */
        private Throwable rethrownException = null;
        
        @Override
        public void evaluate() throws Throwable {
            
            if (!jfxIsSetup) {
                setupJavaFX();
                
                jfxIsSetup = true;
            }
            
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        statement.evaluate();
                    } catch (Throwable e) {
                        rethrownException = e;
                    }
                    countDownLatch.countDown();
                } });
            
            countDownLatch.await();
            
            // if an exception was thrown by the statement during evaluation,
            // then re-throw it to fail the test
            if (rethrownException != null) {
                throw rethrownException;
            }
        }

        /**
         * Set up JavaFX, so testing is enabled for JFX elements.
         * @throws InterruptedException that could be thrown.
         */
        protected void setupJavaFX() throws InterruptedException {
            
            long timeMillis = System.currentTimeMillis();
            
            final CountDownLatch latch = new CountDownLatch(1);
            
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    // initializes JavaFX environment
                    new JFXPanel(); 
                    
                    latch.countDown();
                }
            });
            
            System.out.println("javafx initialising...");
            latch.await();
            System.out.println("javafx is initialised in " + (System.currentTimeMillis() - timeMillis) + "ms");
        }
        
    }
}
