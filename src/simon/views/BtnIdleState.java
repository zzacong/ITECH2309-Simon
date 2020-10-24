/**
 * 
 */
package simon.views;

/**
 * @author Zac
 *
 */
public class BtnIdleState implements IButtonState {

    @Override
    public void setButtonIcon(Button button) {
        button.setIcon(button.getDefaultIcon());
        // if (button.isPressed()) {
        // button.setState(new BtnPressedState());
        // }
    }

}
