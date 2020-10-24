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
public interface IGameState {

    public void play(GameWindowController controller);
}
