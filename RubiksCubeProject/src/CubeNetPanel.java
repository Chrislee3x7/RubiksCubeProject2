import javax.swing.*;
import java.awt.*;

public class CubeNetPanel extends JComponent {

    private Cube cube;
    private int cubeHeight;

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
        cubeHeight = 40;

        g.drawRect(cubeHeight, 20, cubeHeight * 3, cubeHeight * 3);
//        g.drawRect(cubeHeight, 60, cubeHeight * 3,  cubeHeight * 3);
        g.drawRect(cubeHeight, 100, cubeHeight * 3, cubeHeight * 3);

    }
    public void paintEachCubeFace() {

    }

}
