/**
 * 
 */
package simon.models.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simon.models.BlueButton;
import simon.models.Button;
import simon.models.Colour;
import simon.models.GreenButton;
import simon.models.RedButton;
import simon.models.YellowButton;
import simon.models.Colour.Keys;

/**
 * @author Zac
 *
 */
public class ButtonColourTestCase {

    Button btn;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGreenBtnColour() {
        btn = new GreenButton();
        assertEquals(Colour.getColour(Keys.GREEN), btn.getColour());
    }

    @Test
    public void testRedBtnColour() {
        btn = new RedButton();
        assertEquals(Colour.getColour(Keys.RED), btn.getColour());
    }

    @Test
    public void testYellowBtnColour() {
        btn = new YellowButton();
        assertEquals(Colour.getColour(Keys.YELLOW), btn.getColour());
    }

    @Test
    public void testBlueBtnColour() {
        btn = new BlueButton();
        assertEquals(Colour.getColour(Keys.BLUE), btn.getColour());
    }

}
