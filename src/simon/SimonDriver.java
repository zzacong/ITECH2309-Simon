/**
 * 
 */
package simon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

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
                GameWindowController gameController = new GameWindowController(app, gameWindow);
                gameController.control();
            }
        });

    }

}
