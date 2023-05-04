import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

    public static boolean dPressed;
    public static boolean wPressed;
    public static boolean aPressed;
    public static boolean sPressed;
    public static boolean spacePressed;

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_D) {

            System.out.println("Key pressed: d");
            dPressed = true;
        }
        if (keyCode == KeyEvent.VK_W) {

            System.out.println("Key pressed: w");
            wPressed = true;

        }
        if (keyCode == KeyEvent.VK_A) {

            System.out.println("Key pressed: a");
            aPressed = true;
        }
        if (keyCode == KeyEvent.VK_S) {

            System.out.println("Key pressed: s");
            sPressed = true;

        }
        if (keyCode == KeyEvent.VK_SPACE) {

            System.out.println("Key pressed: space");
            spacePressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
    }

    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
    }
}