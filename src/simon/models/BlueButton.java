/**
 * 
 */
package simon.models;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import simon.models.Colour.Keys;

/**
 * @author Zac
 *
 */
public class BlueButton extends Button {

    private static final long serialVersionUID = 1L;

    public BlueButton() {
        super(Colour.getColour(Keys.BLUE));
    }

    public BlueButton(JButton button) {
        super(Colour.getColour(Keys.BLUE), button);
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("images/Blue.png");
    }

    @Override
    public ImageIcon getPressedIcon() {
        return new ImageIcon("images/DarkBlue.png");
    }

    @Override
    public Icon getDisabledIcon() {
        return new ImageIcon("images/WhiteBlue.png");
    }

    @Override
    public Color getBackgroundColour() {
        return Color.BLUE;
    }

}
