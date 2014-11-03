package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private JButton jb4;
    private JButton jb5;
    private JButton jb6;
    private JButton jb7;
    private JButton jb8;
    private JButton jb9;
    private JButton jb10;
    //-----------------------
    private JButton pointButton;
    private JButton lineButton;
    private JButton rectangleButton;
    private JButton circleButton;
    private JButton clearButton;
    private JPanel panel1;
    private JPanel panel2;
    boolean isSelectedPoint = true;
    boolean isSelectedLine = false;
    boolean isSelectedRectangle = false;
    boolean isSelectedCircle = false;
    Color color = Color.BLACK;

    public PaintFrame() {

        super("Paint");
        setLayout(null);

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setBounds(0, 80, 2000, 1000);
        add(panel1);

        jb1 = new JButton();
        jb1.setBackground(Color.BLACK);
        jb1.setBounds(10, 10, 20, 20);
        add(jb1);

        jb2 = new JButton();
        jb2.setBackground(Color.BLUE);
        jb2.setBounds(40, 10, 20, 20);
        add(jb2);

        jb3 = new JButton();
        jb3.setBackground(Color.CYAN);
        jb3.setBounds(70, 10, 20, 20);
        add(jb3);

        jb4 = new JButton();
        jb4.setBackground(Color.DARK_GRAY);
        jb4.setBounds(100, 10, 20, 20);
        add(jb4);

        jb5 = new JButton();
        jb5.setBackground(Color.GRAY);
        jb5.setBounds(130, 10, 20, 20);
        add(jb5);

        jb6 = new JButton();
        jb6.setBackground(Color.GREEN);
        jb6.setBounds(10, 40, 20, 20);
        add(jb6);

        jb7 = new JButton();
        jb7.setBackground(Color.LIGHT_GRAY);
        jb7.setBounds(40, 40, 20, 20);
        add(jb7);

        jb8 = new JButton();
        jb8.setBackground(Color.MAGENTA);
        jb8.setBounds(70, 40, 20, 20);
        add(jb8);

        jb9 = new JButton();
        jb9.setBackground(Color.ORANGE);
        jb9.setBounds(100, 40, 20, 20);
        add(jb9);

        jb10 = new JButton();
        jb10.setBackground(Color.RED);
        jb10.setBounds(130, 40, 20, 20);
        add(jb10);

        //---------------------------------
        pointButton = new JButton("POINT");
        pointButton.setBounds(200, 10, 100, 20);
        add(pointButton);

        lineButton = new JButton("LINE");
        lineButton.setBounds(320, 10, 100, 20);
        add(lineButton);

        circleButton = new JButton("CIRCLE");
        circleButton.setBounds(200, 40, 100, 20);
        add(circleButton);

        rectangleButton = new JButton("RECTANGLE");
        rectangleButton.setBounds(320, 40, 100, 20);
        add(rectangleButton);

        clearButton = new JButton("CLEAR");
        clearButton.setBounds(450, 20, 100, 20);
        add(clearButton);

        //-----------------------------------
        MouseMotionAction action = new MouseMotionAction();
        MouseAction mouseAction = new MouseAction();
        panel1.addMouseListener(mouseAction);
        panel1.addMouseMotionListener(action);
        ActionPerformed actionPerformed = new ActionPerformed();
        jb1.addActionListener(actionPerformed);
        jb2.addActionListener(actionPerformed);
        jb3.addActionListener(actionPerformed);
        jb4.addActionListener(actionPerformed);
        jb5.addActionListener(actionPerformed);
        jb6.addActionListener(actionPerformed);
        jb7.addActionListener(actionPerformed);
        jb8.addActionListener(actionPerformed);
        jb9.addActionListener(actionPerformed);
        jb10.addActionListener(actionPerformed);
        //---------------------

        pointButton.addActionListener(actionPerformed);
        lineButton.addActionListener(actionPerformed);
        rectangleButton.addActionListener(actionPerformed);
        circleButton.addActionListener(actionPerformed);
        clearButton.addActionListener(actionPerformed);
    }

    class ActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(jb1)) {
                color = Color.BLACK;
            } else if (e.getSource().equals(jb2)) {
                color = Color.BLUE;
            } else if (e.getSource().equals(jb3)) {
                color = Color.CYAN;
            } else if (e.getSource().equals(jb4)) {
                color = Color.DARK_GRAY;
            } else if (e.getSource().equals(jb5)) {
                color = Color.GRAY;
            } else if (e.getSource().equals(jb6)) {
                color = Color.GREEN;
            } else if (e.getSource().equals(jb7)) {
                color = Color.LIGHT_GRAY;
            } else if (e.getSource().equals(jb8)) {
                color = Color.MAGENTA;
            } else if (e.getSource().equals(jb9)) {
                color = Color.ORANGE;
            } else if (e.getSource().equals(jb10)) {
                color = Color.RED;
            } //-----------------
            else if (e.getSource().equals(pointButton)) {
                isSelectedLine = false;
                isSelectedPoint = true;
                isSelectedRectangle = false;
                isSelectedCircle = false;
            } else if (e.getSource().equals(lineButton)) {
                isSelectedLine = true;
                isSelectedPoint = false;
                isSelectedRectangle = false;
                isSelectedCircle = false;
                count = 0;
            } else if (e.getSource().equals(rectangleButton)) {
                isSelectedLine = false;
                isSelectedPoint = false;
                isSelectedRectangle = true;
                isSelectedCircle = false;
                count = 0;
            } else if (e.getSource().equals(circleButton)) {
                isSelectedLine = false;
                isSelectedPoint = false;
                isSelectedRectangle = false;
                isSelectedCircle = true;
                count = 0;
            } else if (e.getSource().equals(clearButton)) {
                panel1.repaint();
                isSelectedPoint = true;
            }

        }
    }
    Graphics g;
    int xPressed = 0, yPressed = 0;
    int xReleased = 0, yReleased = 0;
    int xDragged = 0, yDragged = 0;
    int xClicked = 0, yClicked = 0;
    int x = 0;
    int y = 0;
    boolean fOrS = true;

    class MouseMotionAction implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent me) {
            xDragged = me.getX();
            yDragged = me.getY();

            g = panel1.getGraphics();
            g.setColor(color);

            if (isSelectedPoint) {
                g.drawLine(xDragged, yDragged, xDragged, yDragged);
            }
        }

        @Override
        public void mouseMoved(MouseEvent me) {
        }
    }
    int count = 0;

    class MouseAction implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            xClicked = me.getX();
            yClicked = me.getY();
            g.setColor(color);
            System.out.println("Count: " + count);
            if (count % 2 == 0) {
                fOrS = true;
                count = 0;
            } else {
                fOrS = false;
            }
            if (fOrS) {
                x = xClicked;
                y = yClicked;
                System.out.println("In Change");
            }

            System.err.println("Mouse Clicked " + xClicked + "  " + yClicked + "  ||  x,y: " + x + "," + y);
            if (isSelectedPoint) {
                g.drawLine(xClicked, yClicked, xClicked, yClicked);
            }
            if (isSelectedLine) {
                System.out.println("In DrawLine");
                g.drawLine(xClicked, yClicked, x, y);
                count++;

            }
            if (isSelectedRectangle) {
                System.err.println("In DrawRect");
                if (count == 1) {
                    int width = Math.abs(x - xClicked);
                    int height = Math.abs(y - yClicked);
                    int rectX = xClicked;
                    int rectY = yClicked;

                    System.out.println("width: " + width + " height; " + height);
                    if (x < xClicked) {
                        rectX = x;
                    }
                    if (y < yClicked) {
                        rectY = y;
                    }
                    g.drawRect(rectX, rectY, width, height);
                }
                count++;

            }
            if (isSelectedCircle) {
                System.err.println("In DrawCircle");
                if (count == 1) {
                    int radX = Math.abs(x - xClicked);
                    int radY = Math.abs(y - yClicked);
                    int circleX = xClicked;
                    int circleY = yClicked;

                    System.out.println("RadX: " + radX + "  radY: " + radY);

                    if (x < xClicked) {
                        circleX = x;
                    }
                    if (y < yClicked) {

                        circleY = y;
                    }
                    g.drawOval(circleX, circleY, radX, radY);
                }
                count++;
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            xPressed = me.getX();
            yPressed = me.getY();
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            xReleased = me.getX();
            yReleased = me.getY();
            System.err.println("Mouse Released " + xReleased + "  " + yReleased);
            // g.drawRect(x, y, xReleased, yReleased);
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }
}
