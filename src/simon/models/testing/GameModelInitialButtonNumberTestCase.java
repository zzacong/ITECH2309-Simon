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
public class GameModelInitialButtonNumberTestCase {

    GameModel app;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        app = new GameModel();
    }

    @Test
    public void testValidLowerBoundInitialNumber() {
        app.setInitialNumber(1);
        assertEquals(1, app.getInitialNumber());
    }

    @Test
    public void testValidUpperBoundInitialNumber() {
        app.setInitialNumber(5);
        assertEquals(5, app.getInitialNumber());
    }

    @Test
    public void testInvalidLowerBoundInitialNumber() {
        app.setInitialNumber(0);
        assertEquals(1, app.getInitialNumber());
    }

    @Test
    public void testInvalidUpperBoundInitialNumber() {
        app.setInitialNumber(6);
        assertEquals(1, app.getInitialNumber());
    }

}
