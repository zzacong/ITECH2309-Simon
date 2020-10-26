/**
 * 
 */
package simon.controllers;

import simon.views.GameWindow;

/**
 * @author Zac
 *
 */
public class GameBusyState implements IGameState {

    @Override
    public void play(GameController controller) {
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
