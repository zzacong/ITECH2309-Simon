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
public class YellowButton extends Button {

    private static final long serialVersionUID = 1L;

    public YellowButton() {
        super(COLOUR.YELLOW);
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
    public Icon getDisabledIcon() {
        return new ImageIcon("images/WhiteYellow.png");
    }

    @Override
    public Color getBackgroundColour() {
        return Color.YELLOW;
    }

}