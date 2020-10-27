package simon.models.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ButtonCreationTestCase.class, ButtonColourTestCase.class, ButtonIconTestCase.class,
        ColourTestCase.class, GameModelInitialSpeedTestCase.class, GameModelInitialButtonNumberTestCase.class,
        GameModelResetSpeedTestCase.class, GameModelSpeedTestCase.class, GameModelRoundscoreTestCase.class,
        GameModelColourTestCase.class, GameModelSequenceTestCase.class, GameModelIteratorTestCase.class })
public class SimonModelTestSuite {

}
