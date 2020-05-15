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

        window.getContentPane().add(displayCube);
        window.getContentPane().add(controlPanel);

        window.setLocation(200,50);
        window.pack();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);

        displayCube.update();

        cube.rotateSideLayer(1,TurnDirection.CLOCKWISE);
        cube.rotateM(TurnDirection.CLOCKWISE, LayerNotation.M);


    }

}
