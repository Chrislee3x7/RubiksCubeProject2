import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ControlPanel extends JPanel {

    private static final int WIDTH = 400;

    //Window dimension from displaycube
    private static final int HEIGHT = 600;

    private Cube cube;

    private GridLayout gridLayout;

    private static String[] allNotation = {"U", "L", "F", "R", "U'", "L'", "F'", "R'", "B", "D", "M", "S",
            "B'", "D'", "M'", "S'", "E", "x", "y", "z", "E'", "x'", "y'", "z'"};

    public static String[] moveNotations = {"U", "L", "F", "U'", "L'", "F'", "R", "B", "D", "R'", "B'", "D'"};



    public ControlPanel(Cube cube) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT + 50));
        gridLayout = new GridLayout(6,4);
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
