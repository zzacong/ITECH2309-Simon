/**
 * 
 */
package simon.models.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simon.models.GameModel;

/**
 * @author Zac
 *
 */
public class GameModelRoundscoreTestCase {

    GameModel app;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        app = new GameModel();
    }

    @Test
    public void testIncrementRoundscore() {
        app.setRoundscore(0);
        app.incrementRoundScore();
        assertEquals(1, app.getRoundscore());
    }

    @Test
    public void testUpdateHighScore() {
        app.setHighscore(1);
        app.setRoundscore(2);
        app.updateHighScore();
        assertEquals(2, app.getHighscore());
    }

    @Test
    public void testRemainHighScore() {
        app.setHighscore(2);
        app.setRoundscore(1);
        app.updateHighScore();
        assertEquals(2, app.getHighscore());
    }

}
