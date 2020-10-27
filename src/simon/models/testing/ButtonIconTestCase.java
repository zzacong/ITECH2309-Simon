/**
 * 
 */
package simon.models.testing;

import static org.junit.Assert.assertEquals;

import javax.swing.ImageIcon;

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
public class ButtonIconTestCase {

    Button btn;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGreenBtnDefaultIcon() {
        btn = new GreenButton();
        assertEquals(new ImageIcon("images/Green.png").getImage(), btn.getIcon().getImage());
    }

    @Test
    public void testRedBtnDefaultIcon() {
        btn = new RedButton();
        assertEquals(new ImageIcon("images/Red.png").getImage(), btn.getIcon().getImage());
    }

    @Test
    public void testYellowBtnDefaultIcon() {
        btn = new YellowButton();
        assertEquals(new ImageIcon("images/Yellow.png").getImage(), btn.getIcon().getImage());
    }

    @Test
    public void testBlueBtnDefaultIcon() {
        btn = new BlueButton();
        assertEquals(new ImageIcon("images/Blue.png").getImage(), btn.getIcon().getImage());
    }

    @Test
    public void testGreenBtnPressedIcon() {
        btn = new GreenButton();
        assertEquals(new ImageIcon("images/DarkGreen.png").getImage(), btn.getPressedIcon().getImage());
    }

    @Test
    public void testRedBtnPressedIcon() {
        btn = new RedButton();
        assertEquals(new ImageIcon("images/DarkRed.png").getImage(), btn.getPressedIcon().getImage());
    }

    @Test
    public void testYellowBtnPressedIcon() {
        btn = new YellowButton();
        assertEquals(new ImageIcon("images/DarkYellow.png").getImage(), btn.getPressedIcon().getImage());
    }

    @Test
    public void testBlueBtnPressedIcon() {
        btn = new BlueButton();
        assertEquals(new ImageIcon("images/DarkBlue.png").getImage(), btn.getPressedIcon().getImage());
    }

    @Test
    public void testGreenBtnDisabledIcon() {
        btn = new GreenButton();
        assertEquals(new ImageIcon("images/WhiteGreen.png").getImage(), btn.getDisabledIcon().getImage());
    }

    @Test
    public void testRedBtnDisabledIcon() {
        btn = new RedButton();
        assertEquals(new ImageIcon("images/WhiteRed.png").getImage(), btn.getDisabledIcon().getImage());
    }

    @Test
    public void testYellowBtnDisabledIcon() {
        btn = new YellowButton();
        assertEquals(new ImageIcon("images/WhiteYellow.png").getImage(), btn.getDisabledIcon().getImage());
    }

    @Test
    public void testBlueBtnDisabledIcon() {
        btn = new BlueButton();
        assertEquals(new ImageIcon("images/WhiteBlue.png").getImage(), btn.getDisabledIcon().getImage());
    }

}
