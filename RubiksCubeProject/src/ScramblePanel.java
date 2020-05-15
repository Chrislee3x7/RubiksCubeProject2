import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class ScramblePanel extends JPanel implements ActionListener {

    private String currentScramble;

    private JLabel scrambleText;

    private JButton resetCubeButton;

    private JButton scrambleCubeButton;

    private Cube cube;

    public ScramblePanel(Cube cube) {
        this.cube = cube;
        currentScramble = cube.getCurrentScramble();
        resetCubeButton = new JButton("Reset");
        resetCubeButton.addActionListener(this);

        scrambleCubeButton = new JButton("Scramble");
        scrambleCubeButton.addActionListener(this);
        //scrambleCubeButton.setBounds();

        scrambleText = new JLabel();
        scrambleText.setText(currentScramble);
        scrambleText.setFont(new Font("Hebrew", Font.ITALIC, 25));
        scrambleText.setHorizontalAlignment(JTextField.LEFT);
        scrambleText.setBounds(0,0, 100, 40);

        setPreferredSize(new Dimension(200, 40));
        setBackground(Color.LIGHT_GRAY);

        add(scrambleCubeButton);
        add(scrambleText);
        add(resetCubeButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetCubeButton) {

        }
        else if (e.getSource() == scrambleCubeButton) {
            cube.scrambleCube();
            updateScramble(cube.getCurrentScramble());
        }
    }

    public void updateScramble(String newScramble) {
        currentScramble = newScramble;
        scrambleText.setText(newScramble);
    }


}
