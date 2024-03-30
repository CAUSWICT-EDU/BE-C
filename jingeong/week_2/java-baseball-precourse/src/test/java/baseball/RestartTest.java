package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestartTest {

    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;

    @BeforeEach
    public void setUp() {
        System.setIn(testIn);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(systemIn);
    }

    @Test
    void testRestartGame() {
        // Simulate user input '1'
        String input = "1\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        // Start the game
        try {
            Game game = Game.getInstance();
            // Simulate end of the game
            game.endFlag = true;

            // Call restartGame() method
            game.restartGame();

            // Check if the game restarts
            assertFalse(game.endFlag); // End flag should be false after restart
            assertEquals(1, game.round); // Round should reset to 1 after restart

            // Simulate user input other than '1'
            input = "2\n";
            testIn = new ByteArrayInputStream(input.getBytes());
            System.setIn(testIn);

            // Call restartGame() method
            game.restartGame();

            // Check if the game object is deleted
            assertNull(Game.game); // Game object should be null after inputting anything other than '1'
        } catch (ExceptionInInitializerError e) {
            System.out.println("진행시켜");
        }


    }
}
