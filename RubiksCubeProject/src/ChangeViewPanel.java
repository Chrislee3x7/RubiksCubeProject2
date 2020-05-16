import javax.swing.*;
import java.awt.*;

public class ChangeViewPanel extends JComponent {

    public ChangeViewPanel () {
        setPreferredSize(new Dimension(325, 200));
        setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.drawOval(0, 0, 100, 100);

    }
}
