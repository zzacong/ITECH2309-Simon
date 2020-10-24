/**
 * 
 */
package simon.views;

/**
 * @author Zac
 *
 */
public class BtnPressedState implements IButtonState {

    @Override
    public void setButtonIcon(Button button) {
        button.setIcon(button.getPressedImage());
        // if (button.isPressed()) {
        // button.setState(new BtnIdleState());
        // }
    }

}
