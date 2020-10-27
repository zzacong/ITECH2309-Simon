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
import simon.models.GreenButton;
import simon.models.RedButton;
import simon.models.YellowButton;

/**
 * @author Zac
 *
 */
public class ButtonCreationTestCase {

    Button btn;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCreateGreenButton() {
        btn = new GreenButton();
        assertNotNull(btn);
    }

    @Test
    public void testCreateRedButton() {
        btn = new RedButton();
        assertNotNull(btn);
    }

    @Test
    public void testCreateYellowButton() {
        btn = new YellowButton();
        assertNotNull(btn);
    }

    @Test
    public void testCreateBlueButton() {
        btn = new BlueButton();
        assertNotNull(btn);
    }

}
