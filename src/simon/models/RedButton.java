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
public class RedButton extends Button {

    public RedButton() {
        super(Colour.getColour(Keys.RED));
    }

    public RedButton(JButton button) {
        super(Colour.getColour(Keys.RED), button);
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("images/Red.png");
    }

    @Override
    public ImageIcon getPressedIcon() {
        return new ImageIcon("images/DarkRed.png");
    }

    @Override
    public ImageIcon getDisabledIcon() {
        return new ImageIcon("images/WhiteRed.png");
    }

    @Override
    public Color getBackgroundColour() {
        return Color.RED;
    }

}
