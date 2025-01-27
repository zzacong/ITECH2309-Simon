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
public class GreenButton extends Button {

    public GreenButton() {
        super(Colour.getColour(Keys.GREEN));
    }

    public GreenButton(JButton button) {
        super(Colour.getColour(Keys.GREEN), button);
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
