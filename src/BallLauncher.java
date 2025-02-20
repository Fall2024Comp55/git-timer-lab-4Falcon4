import acm.graphics.*;
import acm.program.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class BallLauncher extends GraphicsProgram implements ActionListener {
    public static final int PROGRAM_HEIGHT = 600;
    public static final int PROGRAM_WIDTH = 800;
    public static final int SIZE = 25;
    public static final int MS = 50;
    public static final int SPEED = 5;
    private ArrayList<GOval> balls;

    public void init() {
        setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
        balls = new ArrayList<>();
        requestFocus();
    }

    public void run() {
        addMouseListeners();


        Timer t = new Timer(MS, this);
        t.start();
    }

    public void mousePressed(MouseEvent e) {
        GOval ball = makeBall(SIZE / 2, e.getY());
        balls.add(ball);
        add(ball);
    }

    public void actionPerformed(ActionEvent e) {
        balls.forEach(ball -> {
			ball.move(SPEED, 0);
		});


    }

    public GOval makeBall(double x, double y) {
        GOval temp = new GOval(x - SIZE / 2, y - SIZE / 2, SIZE, SIZE);
        temp.setColor(Color.RED);
        temp.setFilled(true);
        return temp;
    }

    public static void main(String[] args) {
        new BallLauncher().start();
    }

}
