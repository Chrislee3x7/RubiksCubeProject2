import javax.swing.*;
import java.awt.*;

public class RubiksCube {

    //JPanel displayCube;

    JFrame window;

    ControlPanel controlPanel;

    CubeInfoPanel cubeInfoPanel;

    ScramblePanel scramblePanel;

    public static void main(String[] args) {
        RubiksCube rubiksCube = new RubiksCube();

    }

    public RubiksCube() {
        //Starts by making the solved faces in the default "white up green front orientation"
        Cube cube = new Cube(this);

        window = new JFrame("Rubik's Cube");

        cubeInfoPanel = new CubeInfoPanel(cube, this);

        controlPanel = new ControlPanel(cube, cubeInfoPanel.getToolPanel().getLeftToolsPanel());

        window.add(cubeInfoPanel, BorderLayout.WEST);
        window.add(controlPanel, BorderLayout.EAST);

        scramblePanel = new ScramblePanel(cube, cubeInfoPanel, cubeInfoPanel.getToolPanel().getLeftToolsPanel(), this);
        window.add(scramblePanel, BorderLayout.SOUTH);

        //window.setPreferredSize(new Dimension( 600, 650 ));
        window.pack();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setResizable(true);
        window.setVisible(true);
    }

    public void toggleControlPanelVisibility() {
        if (controlPanel.isVisible()) {
            controlPanel.toggleVisibility();
            cubeInfoPanel.setPreferredSize(new Dimension(1050, 700));
            cubeInfoPanel.getDisplayCube().setWindowDimensionX(1050);
        } else {
            cubeInfoPanel.setPreferredSize(new Dimension(650, 700));
            cubeInfoPanel.getDisplayCube().setWindowDimensionX(650);
            controlPanel.toggleVisibility();
        }


        //cubeInfoPanel.getDisplayCube().setWindowDimension(800);

    }

    public CubeInfoPanel getCubeInfoPanel() {
        return cubeInfoPanel;
    }

    public ScramblePanel getScramblePanel() {
        return scramblePanel;
    }

    public JFrame getWindow() {
        return window;
    }
}
