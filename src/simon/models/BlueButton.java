/**
 * 
 */
package simon.models;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import simon.models.Colour.Keys;

/**
 * @author Zac
 *
 */
public class BlueButton extends Button {

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
    public ImageIcon getDisabledIcon() {
        return new ImageIcon("images/WhiteBlue.png");
    }

    @Override
    public Color getBackgroundColour() {
        return Color.BLUE;
    }

}
