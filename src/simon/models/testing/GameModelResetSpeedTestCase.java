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
public class GameModelResetSpeedTestCase {

    GameModel app;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        app = new GameModel();
    }

    @Test
    public void testNoResetSpeed() {
        app.setInitialSpeed(0);
        app.resetSpeed();
        app.speedUp();
        assertNotEquals(app.getInitialSpeed(), app.getSpeed());
    }

    @Test
    public void testResetSpeed() {
        app.setInitialSpeed(0);
        app.resetSpeed();
        app.speedUp();
        app.resetSpeed();
        assertEquals(app.getInitialSpeed(), app.getSpeed());
    }

}
