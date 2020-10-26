/**
 * 
 */
package simon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Zac
 *
 */
public class Roller {
    ArrayList<String> string = new ArrayList<String>();

    public static void main(String[] args) {
        // Roller r = new Roller();
        // System.out.println(Colour.getColour(Keys.GREEN).equals(Colour.getColour(Keys.BLUE)));
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
