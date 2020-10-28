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
public class GameBusyState implements IGameState {

    // BusyState: disable all colour buttons
    @Override
    public void play(GameController controller) {
        disableAllButtons(controller.getView());
        if (!controller.isBusy()) {
            controller.setState(new GameIdleState());
        }
    }

    public void disableAllButtons(GameWindow view) {
        for (JButton button : view.getColourButtons()) {
            button.setEnabled(false);
        }
    }

}
