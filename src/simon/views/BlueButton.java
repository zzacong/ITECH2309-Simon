/**
 * 
 */
package simon.views;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import simon.models.Colour;
import simon.models.Colour.COLOUR;

/**
 * @author Zac
 *
 */
public class BlueButton extends Button {

    public BlueButton() {
        super(COLOUR.BLUE);
    }

    @Override
    public ImageIcon getDefaultIcon() {
        return new ImageIcon("images/Blue.png");
    }

    @Override
    public ImageIcon getPressedImage() {
        return new ImageIcon("images/DarkBlue.png");
    }

}
