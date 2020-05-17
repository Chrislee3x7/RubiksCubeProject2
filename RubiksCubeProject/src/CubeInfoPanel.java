import javax.swing.*;
import java.awt.*;

//contains cubeDisplay, and toolPanel
public class CubeInfoPanel extends JPanel {

    private Cube cube;

    private DisplayCube displayCube;

    private ToolPanel toolPanel;

    private Image background;

    public CubeInfoPanel(Cube cube) {
        background = Toolkit.getDefaultToolkit().getImage("RubiksCubeProject/Background4.jpg");

        displayCube = cube.getDisplayCube();

        toolPanel = new ToolPanel(cube);

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 700));
        updateDisplayCube();

        add(toolPanel, BorderLayout.SOUTH);
        add(displayCube, BorderLayout.NORTH);
    }

    public void toggleToolPanelVisibility() {
        toolPanel.toggleVisibility();
    }

    public void updateDisplayCube() {
        displayCube.setCubeSpaceAllocated(toolPanel.isOpen());
        displayCube.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, -1300, -900, this);
    }
}
