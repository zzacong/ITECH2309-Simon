/**
 * 
 */
package simon;

import javax.swing.SwingUtilities;

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
            }
        });

    }

}
