/**
 * 
 */
package simon.models;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import simon.models.Colour.Keys;

/**
 * @author Zac
 *
 */
public class RedButton extends Button {

    private static final long serialVersionUID = 1L;

    public RedButton() {
        super(Colour.getColour(Keys.RED));
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
    public Icon getDisabledIcon() {
        return new ImageIcon("images/WhiteRed.png");
    }

    @Override
    public Color getBackgroundColour() {
        return Color.RED;
    }

}
