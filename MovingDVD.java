import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class MovingDVD extends JPanel implements ActionListener {
    private double x = 50;
    private double y = 100;
    private double xSpeed = 2.0; // changed from int to double for more precise speed modification
    private double ySpeed = 1.8;
    private final Random rand = new Random();
    private Color color = new Color(46, 48, 140); // original base color for dvd logo
    private static final int LOGO_W = 100;
    private static final int LOGO_H = 60;
    private int corners = 0;

    public MovingDVD() {
        setBackground(Color.BLACK);
        Timer timer = new Timer(16, this); // tick every 16ms 
        timer.start();
    }

    @Override 
    protected void paintComponent(Graphics brush) {
        super.paintComponent(brush); // erase the old logo
        brush.setColor(color); // exact dvd logo blue
        
        // dvd text
        brush.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48));
        brush.drawString("DVD", (int) x, (int) y + 40);

        // oval underneath dvd logo
        brush.fillOval((int) x, (int) y + 46, LOGO_W, 14);

        // counter 
        brush.setColor(Color.WHITE);
        brush.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        brush.drawString("Corner hits: " + corners, 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += xSpeed; // update positions
        y += ySpeed;

        boolean hitX = false;
        boolean hitY = false;

        // if logo hits right or left edge reverse direction
        if(x < 0 || x + LOGO_W > getWidth()) {
            xSpeed *= -1; // flips speed
            hitX = true;
            x = Math.max(0, Math.min(x, getWidth() - LOGO_W)); // keeps logo within the frame
        }
        if(y < 0 || y + LOGO_H > getHeight()) {
            ySpeed *= -1; // reverses direction
            hitY = true;
            y = Math.max(0, Math.min(y, getHeight() - LOGO_H)); // keeps logo within the frame
        }
        if(hitX || hitY) {
            color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // randomize color
        }
        if(hitX && hitY) {
            corners++; // hit a corner and add to counter 
        }
        repaint();
    }
}
