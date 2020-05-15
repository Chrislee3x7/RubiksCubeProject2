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
        window.getContentPane().add(displayCube);

        //window.setBounds(200, 50, 400, 430);
        window.setBounds(200, 50, 600, 650);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);

        displayCube.update();

//        cube.rotateSideLayer(2,TurnDirection.COUNTERCLOCKWISE);
//        cube.rotateSideLayer(2,TurnDirection.COUNTERCLOCKWISE);
//        cube.rotateSideLayer(0, TurnDirection.CLOCKWISE);
//        cube.rotateSideLayer(0, TurnDirection.CLOCKWISE);

        cube.rotateMiddleLayer(TurnDirection.CLOCKWISE, LayerNotation.M);
        cube.rotateMiddleLayer(TurnDirection.COUNTERCLOCKWISE, LayerNotation.S);
        cube.rotateMiddleLayer(TurnDirection.CLOCKWISE, LayerNotation.E);

        displayCube.update();

        //cube.rotateSideLayer(0, TurnDirection.CLOCKWISE);
    }

}
