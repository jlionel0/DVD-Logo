import javax.swing.*;

public class DVDMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving DVD");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MovingDVD canvas = new MovingDVD();

        frame.add(canvas);
        frame.setVisible(true);
    }
}
