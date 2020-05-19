import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScramblePanel extends JPanel implements ActionListener {

    private String currentScramble;

    private JButton scrambleTextButton;

    private JButton resetCubeButton;

    private JButton toolPanelButton;

    private Cube cube;

    private CubeInfoPanel cubeInfoPanel;

    private LeftToolsPanel leftToolsPanel;

    public ScramblePanel(Cube cube, CubeInfoPanel cubeInfoPanel, LeftToolsPanel leftToolsPanel) {
        this.cube = cube;
        this.cubeInfoPanel = cubeInfoPanel;
        this.leftToolsPanel = leftToolsPanel;
        //setBorder(BorderFactory.createLineBorder(Color.BLACK));

        currentScramble = cube.getCurrentScramble();
        resetCubeButton = new JButton("Reset");
        resetCubeButton.setFont(new Font("Hebrew", Font.ITALIC, 20));
        resetCubeButton.addActionListener(this);
        resetCubeButton.setPreferredSize(new Dimension(100, 40));

        scrambleTextButton = new JButton(currentScramble);
        scrambleTextButton.setPreferredSize(new Dimension(820, 40));
        scrambleTextButton.addActionListener(this);
        scrambleTextButton.setFont(new Font("Hebrew", Font.ITALIC, 25));
        scrambleTextButton.setHorizontalAlignment(JButton.CENTER);


        toolPanelButton = new JButton("Tools");
        toolPanelButton.setPreferredSize(new Dimension(100,40));
        toolPanelButton.setFont(new Font("Hebrew", Font.ITALIC, 20));
        toolPanelButton.setBackground(Color.RED);
        toolPanelButton.addActionListener(this);

        //scrambleTextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //setPreferredSize(new Dimension(200, 40));
        setBackground(new Color(158, 196, 197));

        //setLayout(layout);
        add(toolPanelButton);
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
        else if (e.getSource() == toolPanelButton) {
            cubeInfoPanel.toggleToolPanelVisibility();
            cubeInfoPanel.updateDisplayCube();
        }
    }

    public void updateScramble(String newScramble) {
        leftToolsPanel.resetMoveHistoryBox();
        currentScramble = newScramble;
        scrambleTextButton.setText(newScramble);
    }


}
