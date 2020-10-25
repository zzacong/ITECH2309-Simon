/**
 * 
 */
package simon.views;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import simon.models.Colour;
import simon.models.Colour.COLOUR;

/**
 * @author Zac
 *
 */
public class BlueButton extends Button {

    public BlueButton() {
        super(COLOUR.BLUE);
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
