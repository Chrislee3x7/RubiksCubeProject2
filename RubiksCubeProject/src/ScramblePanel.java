import javax.swing.*;
import java.awt.*;

public class ScramblePanel extends JPanel{

    private String currentScramble;

    private JTextField scrambleText;

    private JButton resetCubeButton;

    private JButton scrambleCubeButton;

    public ScramblePanel(Cube cube) {
        currentScramble = cube.getCurrentScramble();
        System.out.println(currentScramble);
        resetCubeButton = new JButton("Reset");
        scrambleCubeButton = new JButton("Scramble");
        scrambleText = new JTextField();
        scrambleText.setText(currentScramble);
        scrambleText.setHorizontalAlignment(JTextField.CENTER);

        setPreferredSize(new Dimension(600, 30));

        add(resetCubeButton, BorderLayout.WEST);
        add(scrambleText, BorderLayout.CENTER);
        add(scrambleCubeButton, BorderLayout.EAST);
    }

    public void updateScramble(String newScramble) {
        currentScramble = newScramble;
        scrambleText.setText(newScramble);
    }


}
