/**
 * 
 */
package simon.models;

import java.util.HashMap;
import java.util.Random;

/**
 * @author Zac
 *
 */
public class Colour {

    private static Random r = new Random();

    public static enum Keys {
        GREEN, RED, BLUE, YELLOW;

        public static Keys getRandomKey() {
            return values()[r.nextInt(4)];
        }
    };

    private static final HashMap<Keys, Colour> COLOUR = new HashMap<Keys, Colour>();

    private Colour() {
    }

    public static Colour getColour(Keys key) {
        Colour instance = COLOUR.get(key);
        if (instance == null) {
            instance = new Colour();
            COLOUR.put(key, instance);
        }
        return instance;
    }

}
