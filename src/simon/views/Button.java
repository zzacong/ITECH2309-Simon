/**
 * 
 */
package simon.views;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;

import simon.models.Colour.COLOUR;

/**
 * @author Zac
 *
 */
public abstract class Button extends JButton {

    private static final long serialVersionUID = 1L;
    private COLOUR colour;

    public Button(COLOUR colour) {
        this.setColour(colour);
    }

    public COLOUR getColour() {
        return this.colour;
    }

    public void setColour(COLOUR colour) {
        this.colour = colour;
    }

    public abstract Icon getIcon();

    public abstract Icon getPressedIcon();

    public abstract Icon getDisabledIcon();

    public abstract Color getBackgroundColour();

}
