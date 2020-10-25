/**
 * 
 */
package simon.views;

import java.awt.Color;

import javax.swing.ImageIcon;

import simon.models.Colour.COLOUR;

/**
 * @author Zac
 *
 */
public class GreenButton extends Button {

    public GreenButton() {
        super(COLOUR.GREEN);
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
