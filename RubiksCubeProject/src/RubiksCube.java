import javax.swing.*;
import java.awt.*;

public class RubiksCube {

    //JPanel displayCube;

    JFrame window;

    public static void main(String[] args) {
        RubiksCube rubiksCube = new RubiksCube();

    }

    public RubiksCube()
    {
        //Starts by making the solved faces in the default "white up green front orientation"
        Cube cube = new Cube();

        window = new JFrame("Rubik's Cube");

        CubeInfoPanel cubeInfoPanel = new CubeInfoPanel(cube);

        ControlPanel controlPanel = new ControlPanel(cube, cubeInfoPanel.getToolPanel().getLeftToolsPanel());

        window.add(cubeInfoPanel, BorderLayout.WEST);
        window.add(controlPanel, BorderLayout.EAST);

        ScramblePanel scramblePanel = new ScramblePanel(cube, cubeInfoPanel, cubeInfoPanel.getToolPanel().getLeftToolsPanel());
        window.add(scramblePanel, BorderLayout.SOUTH);
        //window.add(displayCube, BorderLayout.NORTH);

        //window.setPreferredSize(new Dimension( 600, 650 ));
        window.pack();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setResizable(true);
        window.setVisible(true);
//        displayCube.update();

        //cube.scrambleCube();

//        displayCube.update();

    }

}
