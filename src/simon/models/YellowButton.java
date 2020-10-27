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
public class YellowButton extends Button {

    public YellowButton() {
        super(Colour.getColour(Keys.YELLOW));
    }

    public YellowButton(JButton button) {
        super(Colour.getColour(Keys.YELLOW), button);
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("images/Yellow.png");
    }

    @Override
    public ImageIcon getPressedIcon() {
        return new ImageIcon("images/DarkYellow.png");
    }

    @Override
    public ImageIcon getDisabledIcon() {
        return new ImageIcon("images/WhiteYellow.png");
    }

    @Override
    public Color getBackgroundColour() {
        return Color.YELLOW;
    }

}
