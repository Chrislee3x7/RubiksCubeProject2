import javax.swing.*;
import java.awt.*;

//contains cubeDisplay, and toolPanel
public class CubeInfoPanel extends JPanel {

    private Cube cube;

    private DisplayCube displayCube;

    private ToolPanel toolPanel;

    private JButton toolPanelButton;

    private Image background;

    public CubeInfoPanel(Cube cube) {
        background = Toolkit.getDefaultToolkit().getImage("RubiksCubeProject/Background4.jpg");

        displayCube = cube.getDisplayCube();

        toolPanel = new ToolPanel(this, cube);
        toolPanel.setVisible(true);

        

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 700));

        add(displayCube, BorderLayout.NORTH);
        add(toolPanel, BorderLayout.SOUTH);
    }

    public void updateDisplayCube() {
        displayCube.update();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, -1300, -900,this);
    }
}
