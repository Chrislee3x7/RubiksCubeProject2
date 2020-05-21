import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScramblePanel extends JPanel implements ActionListener {

    private String currentScramble;

    private JButton scrambleTextButton;

    private JButton resetCubeButton;

    private JButton toolPanelButton;

    private JButton controlPanelButton;

    private Cube cube;

    private CubeInfoPanel cubeInfoPanel;

    private LeftToolsPanel leftToolsPanel;

    private RubiksCube rc;

    public ScramblePanel(Cube cube, CubeInfoPanel cubeInfoPanel, LeftToolsPanel leftToolsPanel, RubiksCube rc) {
        this.cube = cube;
        this.rc = rc;
        this.cubeInfoPanel = cubeInfoPanel;
        this.leftToolsPanel = leftToolsPanel;
        //setBorder(BorderFactory.createLineBorder(Color.BLACK));

        currentScramble = cube.getCurrentScramble();
        resetCubeButton = new JButton("Reset");
        resetCubeButton.setFont(new Font("Hebrew", Font.ITALIC, 20));
        resetCubeButton.addActionListener(this);
        resetCubeButton.setPreferredSize(new Dimension(100, 40));

        scrambleTextButton = new JButton(currentScramble);
        scrambleTextButton.setPreferredSize(new Dimension(780, 40));
        scrambleTextButton.addActionListener(this);
        scrambleTextButton.setFont(new Font("Hebrew", Font.ITALIC, 25));
        scrambleTextButton.setHorizontalAlignment(JButton.CENTER);


        toolPanelButton = new JButton("Tools");
        toolPanelButton.setPreferredSize(new Dimension(100, 40));
        toolPanelButton.setFont(new Font("Hebrew", Font.ITALIC, 20));
        toolPanelButton.setBackground(Color.RED);
        toolPanelButton.addActionListener(this);

        controlPanelButton = new JButton("^");
        controlPanelButton.setPreferredSize(new Dimension(40, 40));
        controlPanelButton.setFont(new Font("Hebrew", Font.PLAIN, 20));
        controlPanelButton.addActionListener(this);

        //scrambleTextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //setPreferredSize(new Dimension(200, 40));
        setBackground(new Color(158, 196, 197));

        //setLayout(layout);
        add(toolPanelButton);
        add(scrambleTextButton);
        add(resetCubeButton);
        add(controlPanelButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetCubeButton) {
            cube.reset();
            resetScramble();
        } else if (e.getSource() == scrambleTextButton) {
            cube.scrambleCube();
            updateScramble(cube.getCurrentScramble());
        } else if (e.getSource() == toolPanelButton) {
            cubeInfoPanel.toggleToolPanelVisibility();
            cubeInfoPanel.updateDisplayCube();
        } else if (e.getSource() == controlPanelButton) {
            rc.toggleControlPanelVisibility();
//            cubeInfoPanel.updateDisplayCube();
        }
    }

    public void resetScramble() {
        currentScramble = "Click Me To Scramble";
        updateScramble(currentScramble);
    }

    public String getCurrentScramble()
    {
        return currentScramble;
    }

    public void updateScramble(String newScramble) {
        leftToolsPanel.resetMoveHistoryBox();
        currentScramble = newScramble;
        scrambleTextButton.setText(newScramble);
    }


}
