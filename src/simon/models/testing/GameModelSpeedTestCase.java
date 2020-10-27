package simon.models.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simon.models.GameModel;

public class GameModelSpeedTestCase {

    GameModel app;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        app = new GameModel();
    }

    @Test
    public void testSpeedUp() {
        app.setInitialSpeed(1);
        app.resetSpeed();
        app.speedUp();
        assertEquals(900, app.getSpeed());
    }

    @Test
    public void testMaxSpeed() {
        app.setInitialSpeed(1);
        app.resetSpeed();
        for (int i = 0; i < 20; i++) {
            app.speedUp();
        }
        assertEquals(300, app.getSpeed());
    }

}
