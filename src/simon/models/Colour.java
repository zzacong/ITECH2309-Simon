/**
 * 
 */
package simon.models;

import java.util.ArrayList;
import java.util.Arrays;

import simon.controllers.ColorButtonListener;

/**
 * @author Zac
 *
 */
public class Colour {

    public static enum COLOUR {
        GREEN, RED, BLUE, YELLOW
    };

    private static ArrayList<COLOUR> colourList = new ArrayList<COLOUR>(
            Arrays.asList(COLOUR.GREEN, COLOUR.RED, COLOUR.BLUE, COLOUR.YELLOW));

    public static COLOUR getColour(int index) {
        return colourList.get(index);
    }

    public static boolean compareColour(COLOUR c1, COLOUR c2) {
        return c1 == c2;
    }

}
