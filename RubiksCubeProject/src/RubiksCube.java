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
<<<<<<< HEAD
        ControlPanel controlPanel = new ControlPanel();

        window.add(displayCube, BorderLayout.WEST);
        window.add(controlPanel, BorderLayout.EAST);
=======
        window.getContentPane().add(displayCube);
>>>>>>> 169a18cfe1e46d1addac9ebb7542185ec553f2cb

        //window.setBounds(200, 50, 400, 430);
        window.setBounds(200, 50, 600, 650);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);

        displayCube.update();

<<<<<<< HEAD
        cube.rotateSideLayer(1,TurnDirection.CLOCKWISE);
        //cube.rotateM(TurnDirection.CLOCKWISE, LayerNotation.M);

=======
        cube.rotateSideLayer(2,TurnDirection.COUNTERCLOCKWISE);
        cube.rotateSideLayer(2,TurnDirection.COUNTERCLOCKWISE);
        cube.rotateSideLayer(0, TurnDirection.CLOCKWISE);
        cube.rotateSideLayer(0, TurnDirection.CLOCKWISE);
        displayCube.update();
>>>>>>> 169a18cfe1e46d1addac9ebb7542185ec553f2cb

        //cube.rotateSideLayer(0, TurnDirection.CLOCKWISE);
    }

}
