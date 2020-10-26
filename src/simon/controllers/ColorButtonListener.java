/**
 * 
 */
package simon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import simon.models.Button;

/**
 * @author Zac
 *
 */
public class ColorButtonListener implements ActionListener {

    private Button button;
    private GameController controller;

    public ColorButtonListener(GameController controller, Button button) {
        this.controller = controller;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("out");
        controller.respond(button.getColour());
    }

}
