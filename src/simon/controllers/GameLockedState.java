/**
 * 
 */
package simon.controllers;

import simon.models.GameModel;
import simon.views.GameWindow;

/**
 * @author Zac
 *
 */
public class GameLockedState implements IGameState {

    @Override
    public void play(GameWindowController controller) {
        disableAllButtons(controller.getView());
        if (!controller.isBusy()) {
            controller.setState(new GameIdleState());
        }
    }

    public void disableAllButtons(GameWindow view) {
        view.getBtnGreen().setEnabled(false);
        view.getBtnRed().setEnabled(false);
        view.getBtnBlue().setEnabled(false);
        view.getBtnYellow().setEnabled(false);
    }

}
