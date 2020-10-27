/**
 * 
 */
package simon.models.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simon.models.Colour;
import simon.models.GameModel;

/**
 * @author Zac
 *
 */
public class GameModelColourTestCase {

    GameModel app;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        app = new GameModel();
    }

    @Test
    public void testGetRandomColour() {
        assertEquals(Colour.class, app.getRandomColour().getClass());
    }

}
