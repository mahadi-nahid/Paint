
package paint;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author MdMahadiHasan
 */
public class Paint {

    public static void main(String[] args) {
        PaintFrame paintFrame = new PaintFrame();
        paintFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        paintFrame.setSize(1000, 700);
        paintFrame.setVisible(true);
        paintFrame.setResizable(false);
        paintFrame.setLocation(200,50);
    }
    
}
