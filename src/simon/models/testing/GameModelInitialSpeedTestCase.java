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
public class GameModelInitialSpeedTestCase {

    GameModel app;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        app = new GameModel();
    }

    @Test
    public void testFastInitialSpeed() {
        app.setInitialSpeed(0);
        assertEquals(700, app.getInitialSpeed());
    }

    @Test
    public void testNormalInitialSpeed() {
        app.setInitialSpeed(1);
        assertEquals(1000, app.getInitialSpeed());
    }

    @Test
    public void testSlowInitialSpeed() {
        app.setInitialSpeed(2);
        assertEquals(1400, app.getInitialSpeed());
    }

    @Test
    public void testSetToDefaultInitialSpeed() {
        app.setInitialSpeed(3);
        assertEquals(1000, app.getInitialSpeed());
    }

    @Test
    public void testLowerBoundLimit() {
        try {
            app.setInitialSpeed(-1);
        } catch (IndexOutOfBoundsException e) {
            fail("IndexOutOfBoundsException thrown");
        }
    }
    
    @Test
    public void testUpperBoundLimit() {
        try {
            app.setInitialSpeed(3);
        } catch (IndexOutOfBoundsException e) {
            fail("IndexOutOfBoundsException thrown");
        }
    }

}
