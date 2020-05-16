import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JPanel {

    private boolean isVisible;

    private CubeInfoPanel cubeInfoPanel;

    private CubeNet cubeNet;

    public ToolPanel(CubeInfoPanel cubeInfoPanel) {
        this.cubeInfoPanel = cubeInfoPanel;
        cubeNet = new CubeNet(cube);
        add(cubeNet);
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
