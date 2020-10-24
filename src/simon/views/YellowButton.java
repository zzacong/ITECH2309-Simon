/**
 * 
 */
package simon.views;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import simon.models.Colour.COLOUR;

/**
 * @author Zac
 *
 */
public class YellowButton extends Button {

    public YellowButton() {
        super(COLOUR.YELLOW);
    }

    @Override
    public ImageIcon getDefaultIcon() {
        return new ImageIcon("images/Yellow.png");
    }

    @Override
    public ImageIcon getPressedImage() {
        return new ImageIcon("images/DarkYellow.png");
    }

}
