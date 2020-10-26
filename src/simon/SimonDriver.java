/**
 * 
 */
package simon;

import javax.swing.SwingUtilities;

import simon.controllers.Controller;
import simon.controllers.GameWindowController;
import simon.models.GameModel;
import simon.views.GameWindow;

/**
 * @author Zac
 *
 */
public class SimonDriver {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameWindow gameWindow = new GameWindow();
                GameModel app = new GameModel();
                Controller gameController = new GameWindowController(app, gameWindow);

                gameController.control();
            }
        });

    }

}
