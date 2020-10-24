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
public class RedButton extends Button {

    public RedButton() {
        super(COLOUR.RED);
    }

    @Override
    public ImageIcon getDefaultIcon() {
        return new ImageIcon("images/Red.png");
    }

    @Override
    public ImageIcon getPressedImage() {
        return new ImageIcon("images/DarkRed.png");
    }

}
