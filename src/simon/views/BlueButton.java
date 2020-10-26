/**
 * 
 */
package simon.views;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import simon.models.Colour.COLOUR;

/**
 * @author Zac
 *
 */
public class BlueButton extends Button {

    private static final long serialVersionUID = 1L;

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
