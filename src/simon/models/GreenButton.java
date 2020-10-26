/**
 * 
 */
package simon.models;

import java.awt.Color;

import javax.swing.ImageIcon;

import simon.models.Colour.Keys;

/**
 * @author Zac
 *
 */
public class GreenButton extends Button {

    private static final long serialVersionUID = 1L;

    public GreenButton() {
        super(Colour.getColour(Keys.GREEN));
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("images/Green.png");
    }

    @Override
    public ImageIcon getPressedIcon() {
        return new ImageIcon("images/DarkGreen.png");
    }

    @Override
    public ImageIcon getDisabledIcon() {
        return new ImageIcon("images/WhiteGreen.png");
    }

    @Override
    public Color getBackgroundColour() {
        return Color.GREEN;
    }

}
