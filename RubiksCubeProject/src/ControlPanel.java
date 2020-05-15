import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

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
        switch (commandNotation) {
            case "U":
                cube.rotateSideLayer(LayerNotation.D, TurnDirection.CLOCKWISE);
                break;
            case "U'":
                cube.rotateSideLayer(LayerNotation.D, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "L":
                cube.rotateSideLayer(LayerNotation.D, TurnDirection.CLOCKWISE);
                break;
            case "L'":
                cube.rotateSideLayer(LayerNotation.D, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "F":
                cube.rotateSideLayer(LayerNotation.D, TurnDirection.CLOCKWISE);
                break;
            case "F'":
                cube.rotateSideLayer(LayerNotation.D, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "R":
                cube.rotateSideLayer(LayerNotation.D, TurnDirection.CLOCKWISE);
                break;
            case "R'":
                cube.rotateSideLayer(LayerNotation.D, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "B":
                cube.rotateSideLayer(LayerNotation.D, TurnDirection.CLOCKWISE);
                break;
            case "B'":
                cube.rotateSideLayer(LayerNotation.D, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "D":
                cube.rotateSideLayer(LayerNotation.D, TurnDirection.CLOCKWISE);
                break;
            case "D'":
                cube.rotateSideLayer(LayerNotation.D, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "M":
                cube.rotateMiddleLayer();
            case "M'":
            case "S":
            case "S'":
            case "E":
            case "E'":
            case "x":
            case "x'":
            case "y":
            case "y'":
            case "z":
            case "z'":

        }
        System.out.println(commandNotation);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.LIGHT_GRAY);


    }

}
