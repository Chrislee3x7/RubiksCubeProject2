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

        ControlPanel controlPanel = new ControlPanel(cube);

        DisplayCube displayCube = cube.getDisplayCube();
        window.add(displayCube, BorderLayout.WEST);
        window.add(controlPanel, BorderLayout.EAST);
        window.getContentPane().add(displayCube);

        window.setBounds(50, 50, 600, 650);
        window.pack();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        displayCube.update();

        cube.scrambleCube();

        displayCube.update();
    }

}
