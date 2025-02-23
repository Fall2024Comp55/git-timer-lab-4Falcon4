import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import acm.graphics.*;
import acm.program.*;


public class ColorCircleDecomp extends GraphicsProgram implements ActionListener {
    public static final int PROGRAM_WIDTH = 800;
    public static final int PROGRAM_HEIGHT = 600;
    public static final int BALL_SIZE = 50;
    public static final int DELAY_MS = 25;

    private GOval ball;
    private int theta;
    private Color color;
    private int r;
    private int g;
    private int b;

    public void run() {
        ball = new GOval(BALL_SIZE, BALL_SIZE);
        color = new Color(85, 170, 255);
        r = color.getRed();
        g = color.getGreen();
        b = color.getBlue();
        theta = 0;

        add(ball);
        ball.setColor(color);
        ball.setFilled(true);
        ball.setLocation(PROGRAM_WIDTH/2, PROGRAM_HEIGHT-BALL_SIZE);


        Timer t = new Timer(DELAY_MS, this);
        t.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        moveBall();
        changeColor();
    }


    public void moveBall() {
        ball.movePolar(4, theta);
        theta++;
    }

    public void changeColor() {
        r++;
        g++;
        b++;
        color = new Color(
                255 - Math.abs(255 - (r % 510)),
                255 - Math.abs(255 - (g % 510)),
                255 - Math.abs(255 - (b % 510))
        );
        ball.setColor(color);
    }

    public void init() {
        setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
    }
    public static void main(String args[]) {
        new ColorCircleDecomp().start();
    }
}