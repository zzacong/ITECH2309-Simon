/**
 * 
 */
package simon.models.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simon.models.Colour;
import simon.models.GameModel;
import simon.models.Colour.Keys;

/**
 * @author Zac
 *
 */
public class GameModelSequenceTestCase {

    GameModel app;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        app = new GameModel();
    }

    @Test
    public void testAddSequence() {
        ArrayList<Colour> cList = new ArrayList<Colour>();
        cList.add(Colour.getColour(Keys.GREEN));
        cList.add(Colour.getColour(Keys.BLUE));
        cList.add(Colour.getColour(Keys.RED));
        cList.add(Colour.getColour(Keys.YELLOW));

        app.addSequence(app.getSequence(), Colour.getColour(Keys.GREEN));
        app.addSequence(app.getSequence(), Colour.getColour(Keys.BLUE));
        app.addSequence(app.getSequence(), Colour.getColour(Keys.RED));
        app.addSequence(app.getSequence(), Colour.getColour(Keys.YELLOW));
        assertEquals(cList, app.getSequence());
    }

    @Test
    public void testAddOneToGameSequence() {
        app.addOneToGameSequence();
        assertEquals(1, app.getSequence().size());
    }

}
