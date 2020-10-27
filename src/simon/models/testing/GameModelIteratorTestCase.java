package simon.models.testing;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simon.models.Colour;
import simon.models.GameModel;

public class GameModelIteratorTestCase {

    GameModel app;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        app = new GameModel();
    }

    @Test
    public void testGetNewSequenceIterator() {
        app.addOneToGameSequence();
        app.addOneToGameSequence();
        assertNotEquals(app.getNewSequenceIterator(), app.getNewSequenceIterator());
    }

    @Test
    public void testResetIter() {
        app.addOneToGameSequence();
        app.addOneToGameSequence();
        app.resetIter();
        Iterator<Colour> oldIter = app.getIter();
        app.resetIter();
        assertNotEquals(oldIter, app.getIter());
    }

}
