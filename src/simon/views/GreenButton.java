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
public class GreenButton extends Button {

    public GreenButton() {
        super(COLOUR.GREEN);
    }

    @Override
    public ImageIcon getDefaultIcon() {
        return new ImageIcon("images/Green.png");
    }

    @Override
    public ImageIcon getPressedImage() {
        return new ImageIcon("images/DarkGreen.png");
    }

}
