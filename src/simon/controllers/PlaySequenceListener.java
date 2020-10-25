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
    Button button;

    public PlaySequenceListener(GameWindowController controller) {
        this.controller = controller;
    }

    public void resetListener() {
        this.iter = controller.getApp().getNewSequenceIterator();
        timer.setDelay(controller.getSpeed());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (iter.hasNext()) { // safe check
            System.out.println(".");
            pressButton(iter.next());
        } else {
            System.out.println("stop");
            releaseButton();
            controller.setBusy(false);
            timer.stop();
        }
    }

    public void start() {
        timer.start();
    }

    public boolean isRunning() {
        return this.timer.isRunning();
    }

    private void pressButton(COLOUR c) {
        releaseButton();
        for (Button btn : controller.getColourButtons()) {
            if (Colour.compareColour(btn.getColour(), c)) {
                btn.setBackground(btn.getBackgroundColour());
                button = btn;
            }
        }
    }

    private void releaseButton() {
        if (button != null) {
            button.setBackground(null);
        }
    }

}
