/**
 * 
 */
package simon.models;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * @author Zac
 *
 */
public abstract class Button extends JButton {

    private static final long serialVersionUID = 1L;
    private Colour colour;
    private JButton button;

    public Button(Colour colour) {
        this.setColour(colour);
    }

    public Button(Colour colour, JButton button) {
        this.setColour(colour);
        this.button = button;
        this.button.setIcon(getIcon());
        this.button.setPressedIcon(getPressedIcon());
        this.button.setDisabledIcon(getDisabledIcon());
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

    public abstract Icon getIcon();

    public abstract Icon getPressedIcon();

    public abstract Icon getDisabledIcon();

    public abstract Color getBackgroundColour();

}
