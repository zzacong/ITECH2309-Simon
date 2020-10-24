/**
 * 
 */
package simon.views;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import simon.models.Colour.COLOUR;

/**
 * @author Zac
 *
 */
public abstract class Button extends JButton {

    private COLOUR colour;

    public Button(COLOUR colour) {
        this.setColour(colour);
        setIcon(getDefaultIcon());
        controlAppearance();
    }

    public COLOUR getColour() {
        return this.colour;
    }

    public void setColour(COLOUR colour) {
        this.colour = colour;
    }

    public void controlAppearance() {
        this.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (getBtnModal().isPressed()) {
                    setIcon(getPressedImage());
                } else {
                    setIcon(getDefaultIcon());
                }
            }

        });
    }

    public ButtonModel getBtnModal() {
        return this.getModel();
    }

    public abstract ImageIcon getDefaultIcon();

    public abstract ImageIcon getPressedImage();

}
