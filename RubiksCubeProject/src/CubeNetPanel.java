import javax.swing.*;
import java.awt.*;

public class CubeNetPanel extends JComponent {

    private Cube cube;

    public CubeNetPanel(Cube cube) {
        this.cube = cube;
        setPreferredSize(new Dimension(325, 200));
        setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    public void displayCubeNet () {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.drawRect(0, 0, 100, 100);

    }

}
