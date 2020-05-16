import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolPanel extends JPanel implements ActionListener {

    private boolean isVisible;

    private CubeInfoPanel cubeInfoPanel;

    private CubeNetPanel cubeNet;

    private Cube cube;

    private JButton toolPanelButton;

    public ToolPanel(CubeInfoPanel cubeInfoPanel, Cube cube, JButton toolPanelButton) {
        this.cubeInfoPanel = cubeInfoPanel;
        this.cube = cube;
        this.toolPanelButton = toolPanelButton;

        setLayout(new BorderLayout());
        cubeNet = new CubeNetPanel(cube);
        add(cubeNet, BorderLayout.EAST);
        setBorder(BorderFactory.createLineBorder(Color.GREEN));
        setPreferredSize(new Dimension(600, 200));
        setOpaque(false);
    }

    //a button will do this
    public void toggleVisibility() {
        if (isVisible) {
            setVisible(false);
            isVisible = false;
        }
        else {
            setVisible(true);
            isVisible = true;
        }
    }
    //is visible basically
    public boolean isOpen() {
        return isVisible;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == toolPanelButton) {
            toggleVisibility();
            cubeInfoPanel.updateDisplayCube();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(40, 40, 40, 40);
    }
}
