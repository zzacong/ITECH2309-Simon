/**
 * 
 */
package simon.controllers;

import javax.swing.JButton;

import simon.views.GameWindow;

/**
 * @author Zac
 *
 */
public class GameIdleState implements IGameState {

    // IdleState: enable all colour buttons
    @Override
    public void play(GameController controller) {
        enableAllButtons(controller.getView());
        if (controller.isBusy()) {
            controller.setState(new GameBusyState());
        }
    }

    public void enableAllButtons(GameWindow view) {
        for (JButton button : view.getColourButtons()) {
            button.setEnabled(true);
        }
    }

}
