/**
 * 
 */
package simon.models;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author Zac
 *
 */
public abstract class Button {

    private Colour colour;
    private JButton button;

    public Button(Colour colour) {
        this.setColour(colour);
    }

    public Button(Colour colour, JButton button) {
        this(colour);
        this.setButton(button);
        this.getButton().setIcon(getIcon());
        this.getButton().setPressedIcon(getPressedIcon());
        this.getButton().setDisabledIcon(getDisabledIcon());
    }

    public Colour getColour() {
        return this.colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public JButton getButton() {
        return this.button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    // The icon used as default
    public abstract ImageIcon getIcon();

    // The icon used when button is pressed
    public abstract ImageIcon getPressedIcon();

    // The icon used when button is disabled
    public abstract ImageIcon getDisabledIcon();

    // The colour used to highlight th ebutton
    public abstract Color getBackgroundColour();

}
