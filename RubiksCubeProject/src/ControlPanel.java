import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class ControlPanel extends JPanel {

    private static final int WIDTH = 400;


    //Window dimension from displaycube
    private static final int HEIGHT = 650;

    private Cube cube;

    private GridLayout layout;

    private LeftToolsPanel leftToolsPanel;



    private static String[] allNotation = {"M", "M'", "x", "x'", "E", "E'", "y", "y'", "S", "S'", "z", "z'",
            "U", "U'", "D", "D'", "F", "F'", "B", "B'", "R", "R'", "L", "L'"};


    public ControlPanel(Cube cube, LeftToolsPanel leftToolsPanel) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT + 50));
        layout = new GridLayout(6, 4);
        setLayout(layout);
        this.leftToolsPanel = leftToolsPanel;

        this.cube = cube;
        for (String notationSymbol : allNotation) {
            add(new ControlButton(this, notationSymbol));
        }

        setFocusable(true);
        //System.out.println(isFocusable());

    }


    public void sendCommand(String commandNotation) {
        cube.performMove(commandNotation);
        leftToolsPanel.addMove(commandNotation);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //setBackground(Color.BLACK);
    }

}
