/**
 * 
 */
package simon.views;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;

import simon.models.Colour;

/**
 * @author Zac
 *
 */
public abstract class Button extends JButton {

    private static final long serialVersionUID = 1L;
    private Colour colour;

    public Button(Colour colour) {
        this.setColour(colour);
    }

    public Colour getColour() {
        return this.colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public abstract Icon getIcon();

    public abstract Icon getPressedIcon();

    public abstract Icon getDisabledIcon();

    public abstract Color getBackgroundColour();

}
