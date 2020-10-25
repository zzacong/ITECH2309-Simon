/**
 * 
 */
package simon;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import simon.models.GameModel;

/**
 * @author Zac
 *
 */
public class Roller {
    ArrayList<String> string = new ArrayList<String>();

    public static void main(String[] args) {
        Roller r = new Roller();
        r.test();
    }

    public void test() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked");

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        frame.setBounds(100, 100, 100, 100);
        frame.add(panel);
        panel.setBackground(Color.RED);
        // panel.removeMouseListener();
        // panel.setEnabled(false);
        frame.setVisible(true);
    }

    public void run() {
        string.add("one");
        string.add("two");
        string.add("three");
        string.add("four");
        string.add("five");
        Iterator<String> iter = string.iterator();

        Timer animator = new Timer();
        animator.schedule(new TimerTask() {
            public void run() {
                if (iter.hasNext()) {
                    String s = iter.next();
                    if (s == "three") {
                        System.out.println("run2");
                        run2();
                    }
                    System.out.println(s);
                } else {
                    System.out.println("cancel");

                    animator.cancel();
                }
            }
        }, 0, 500);
    }

    public void run2() {
        Iterator<String> iter = string.iterator();
        Timer animator = new Timer();
        animator.schedule(new TimerTask() {
            public void run() {
                if (iter.hasNext()) {
                    System.out.println(iter.next());
                } else {
                    System.out.println("cancel2");
                    animator.cancel();
                }
            }
        }, 0, 500);
    }
}
