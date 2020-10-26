/**
 * 
 */
package simon.controllers;

import simon.views.GameWindow;

/**
 * @author Zac
 *
 */
public class GameIdleState implements IGameState {

    @Override
    public void play(GameController controller) {
        enableAllButtons(controller.getView());
        if (controller.isBusy()) {
            controller.setState(new GameBusyState());
        }
    }

    public void enableAllButtons(GameWindow view) {
        view.getBtnGreen().setEnabled(true);
        view.getBtnRed().setEnabled(true);
        view.getBtnBlue().setEnabled(true);
        view.getBtnYellow().setEnabled(true);
    }

}
