import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    private static final int WIDTH = 400;

    //Window dimension from displaycube
    private static final int HEIGHT = 600;

    private Cube cube;

    private GridLayout gridLayout;

    public ControlPanel(Cube cube) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT + 50));
        gridLayout = new GridLayout(8,3);
        setLayout(gridLayout);

        this.cube = cube;

        add(new ControlButton(this, "U"));
        add(new ControlButton(this, "L"));
        add(new ControlButton(this, "F"));
        add(new ControlButton(this, "U'"));
        add(new ControlButton(this, "L'"));
        add(new ControlButton(this, "F'"));
        add(new ControlButton(this, "R"));
        add(new ControlButton(this, "B"));
        add(new ControlButton(this, "D"));
        add(new ControlButton(this, "R'"));
        add(new ControlButton(this, "B'"));
        add(new ControlButton(this, "D'"));
        add(new ControlButton(this, "M"));
        add(new ControlButton(this, "S"));
        add(new ControlButton(this, "E"));
        add(new ControlButton(this, "M'"));
        add(new ControlButton(this, "S'"));
        add(new ControlButton(this, "E'"));
        add(new ControlButton(this, "x"));
        add(new ControlButton(this, "y"));
        add(new ControlButton(this, "z"));
        add(new ControlButton(this, "x'"));
        add(new ControlButton(this, "y'"));
        add(new ControlButton(this, "z'"));
    }

    public void sendCommand(String commandNotation) {
        cube.preformMove(commandNotation);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.LIGHT_GRAY);


    }

}
