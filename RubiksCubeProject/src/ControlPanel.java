import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    private static final int WIDTH = 400;

    //Window dimension from displaycube
    private static final int HEIGHT = 600;

    private Cube cube;

    private GridLayout gridLayout;

    private String[] allNotation = {"U", "L", "F", "U'", "L'", "F'", "R", "B", "D", "R'", "B'", "D'",
            "M", "S", "E", "M'", "S'", "E'", "x", "y", "z", "x'", "y'", "z'"};

    public ControlPanel(Cube cube) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT + 50));
        gridLayout = new GridLayout(8,3);
        setLayout(gridLayout);

        this.cube = cube;
        for (String notationSymbol : allNotation) {
            add(new ControlButton(this, notationSymbol));
        }
    }

    public void sendCommand(String commandNotation) {
        cube.preformMove(commandNotation);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.LIGHT_GRAY);


    }

}
