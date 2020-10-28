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

        // Return a random Key
        public static Keys getRandomKey() {
            return values()[r.nextInt(4)];
        }
    };

    private static final HashMap<Keys, Colour> COLOUR = new HashMap<Keys, Colour>();

    private Colour() {
    }

    public static Colour getColour(Keys key) {
        Colour instance = COLOUR.get(key); // get the copy from HashMap
        if (instance == null) { // if not in HashMap, create a new one
            instance = new Colour();
            COLOUR.put(key, instance);
        }
        return instance;
    }

}
