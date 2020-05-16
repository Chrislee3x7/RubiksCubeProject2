import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScramblePanel extends JPanel implements ActionListener {

    private String currentScramble;

    private JButton scrambleTextButton;

    private JButton resetCubeButton;

    private Cube cube;

    public ScramblePanel(Cube cube) {
        this.cube = cube;
        //setBorder(BorderFactory.createLineBorder(Color.BLACK));
        currentScramble = cube.getCurrentScramble();
        resetCubeButton = new JButton("Reset");
        resetCubeButton.addActionListener(this);
        resetCubeButton.setPreferredSize(new Dimension(100, 40));

//        scrambleCubeButton = new JButton("Scramble");
//        scrambleCubeButton.addActionListener(this);
//        scrambleCubeButton.setPreferredSize(new Dimension(130, 40));

        scrambleTextButton = new JButton(currentScramble);
        scrambleTextButton.setPreferredSize(new Dimension(900, 40));
        scrambleTextButton.addActionListener(this);
        scrambleTextButton.setFont(new Font("Hebrew", Font.ITALIC, 25));
        scrambleTextButton.setHorizontalAlignment(JButton.CENTER);

        //scrambleTextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //setPreferredSize(new Dimension(200, 40));
        setBackground(new Color(158, 196, 197));

        //setLayout(layout);
        add(scrambleTextButton);
        add(resetCubeButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetCubeButton) {
            cube.reset();
            currentScramble = "Click Me To Scramble";
            updateScramble(currentScramble);
        }
        else if (e.getSource() == scrambleTextButton) {
            cube.scrambleCube();
            updateScramble(cube.getCurrentScramble());
        }
    }

    public void updateScramble(String newScramble) {
        currentScramble = newScramble;
        scrambleTextButton.setText(newScramble);
    }


}
