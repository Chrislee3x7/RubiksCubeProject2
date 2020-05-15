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

        DisplayCube displayCube = new DisplayCube(cube);
        ControlPanel controlPanel = new ControlPanel();

        window.add(displayCube, BorderLayout.WEST);
        window.add(controlPanel, BorderLayout.EAST);
        window.getContentPane().add(displayCube);

        window.setBounds(50, 50, 600, 650);
        window.pack();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);

        displayCube.update();

        //cube.rotateM(TurnDirection.CLOCKWISE, LayerNotation.M);

        displayCube.update();
        //cube.rotateSideLayer(0, TurnDirection.CLOCKWISE);
    }

}
