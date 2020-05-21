import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JPanel {

    private boolean isVisible;

    private CubeNetPanel cubeNet;

    private LeftToolsPanel leftToolsPanel;

    public ToolPanel(Cube cube) {

        isVisible = true;
        setLayout(new BorderLayout());
        cubeNet = new CubeNetPanel(cube);
        leftToolsPanel = new LeftToolsPanel(cube.getDisplayCube());
        cubeNet = new CubeNetPanel(cube);
        leftToolsPanel = new LeftToolsPanel(cube.getDisplayCube());
        add(cubeNet, BorderLayout.EAST);
        add(leftToolsPanel, BorderLayout.WEST);
        //setBorder(BorderFactory.createLineBorder(Color.GREEN));
        setPreferredSize(new Dimension(650, 180));
        setVisible(isVisible);
        setOpaque(false);
    }

    //a button will do this
    public void toggleVisibility() {
        if (isVisible) {
            setVisible(false);
            isVisible = false;
        } else {
            setVisible(true);
            isVisible = true;
        }
    }

    //is visible basically
    public boolean isOpen() {
        return isVisible;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawRect(40, 40, 40, 40);
    }

    public CubeNetPanel getCubeNet() {
        return cubeNet;
    }

    public LeftToolsPanel getLeftToolsPanel() {
        return leftToolsPanel;
    }
}
