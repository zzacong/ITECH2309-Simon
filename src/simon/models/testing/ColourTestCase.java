/**
 * 
 */
package simon.models.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simon.models.Colour;
import simon.models.Colour.Keys;

/**
 * @author Zac
 *
 */
public class ColourTestCase {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testSameGreenInstance() {
        Colour colour1 = Colour.getColour(Keys.GREEN);
        Colour colour2 = Colour.getColour(Keys.GREEN);
        assertEquals(colour1, colour2);
    }

    @Test
    public void testSameRedInstance() {
        Colour colour1 = Colour.getColour(Keys.RED);
        Colour colour2 = Colour.getColour(Keys.RED);
        assertEquals(colour1, colour2);
    }

    @Test
    public void testSameYellowInstance() {
        Colour colour1 = Colour.getColour(Keys.YELLOW);
        Colour colour2 = Colour.getColour(Keys.YELLOW);
        assertEquals(colour1, colour2);
    }

    @Test
    public void testSameBlueInstance() {
        Colour colour1 = Colour.getColour(Keys.BLUE);
        Colour colour2 = Colour.getColour(Keys.BLUE);
        assertEquals(colour1, colour2);
    }

    @Test
    public void testNotSameInstance() {
        Colour colour1 = Colour.getColour(Keys.GREEN);
        Colour colour2 = Colour.getColour(Keys.BLUE);
        assertNotEquals(colour1, colour2);
    }

}
