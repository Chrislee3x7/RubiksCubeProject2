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

        JPanel displayCube = new DisplayCube(cube);
        window.getContentPane().add(displayCube);

        //window.setBounds(200, 50, 400, 430);
        window.setBounds(200, 50, 600, 700);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setResizable(true);
        window.setVisible(true);
    }

}
