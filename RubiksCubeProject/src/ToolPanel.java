import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JPanel {

    private boolean isVisible;

    private CubeInfoPanel cubeInfoPanel;

    private CubeNet cubeNet;

    private Cube cube;

    public ToolPanel(CubeInfoPanel cubeInfoPanel, Cube cube) {
        this.cubeInfoPanel = cubeInfoPanel;
        this.cube = cube;

        setLayout(new BorderLayout());
        cubeNet = new CubeNet(cube);
        add(cubeNet, BorderLayout.EAST);
        setBorder(BorderFactory.createLineBorder(Color.GREEN));
        setPreferredSize(new Dimension(600, 200));
        setOpaque(false);
    }

    //a button will do this
    public void setVisibility(boolean isVisible) {
        this.isVisible = isVisible;
        setVisible(isVisible);
        cubeInfoPanel.updateDisplayCube();
    }
    //is visible basically
    public boolean isOpen() {
        return isVisible;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(40, 40, 40, 40);
    }
}
