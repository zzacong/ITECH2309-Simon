/**
 * 
 */
package simon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;

import simon.models.Colour;
import simon.models.Colour.COLOUR;
import simon.views.Button;

/**
 * @author Zac
 *
 */
public class PlaySequenceListener implements ActionListener {

    Timer timer = new Timer(1000, this);
    GameWindowController controller;
    Iterator<COLOUR> iter;
    ArrayList<Button> buttons;
    Button button;

    public PlaySequenceListener(GameWindowController controller) {
        this.controller = controller;
        this.iter = controller.getNewIter();
        this.buttons = controller.getButtons();
    }

    public PlaySequenceListener(Iterator<COLOUR> iter, ArrayList<Button> buttons) {
        this.iter = iter;
        this.buttons = buttons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (iter.hasNext()) {
            System.out.println("pressed");
            pressButton(iter.next());
        } else {
            System.out.println("stop");
            timer.stop();
        }
    }

    public void start() {
        timer.start();
    }

    private void pressButton(COLOUR c) {
        if (button != null) {
            button.setIcon(button.getDefaultIcon());
        }
        for (Button btn : buttons) {
            if (Colour.compareColour(btn.getColour(), c)) {
                btn.setIcon(btn.getPressedImage());
                button = btn;
            }
        }
    }

}
