import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        toolPanel = new ToolPanel(this, cube ,toolPanelButton);

        toolPanelButton = new JButton("Tools");
        toolPanelButton.setPreferredSize(new Dimension(40,40));
        toolPanelButton.addActionListener(toolPanel);

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 700));

        add(displayCube);
        add(toolPanel);
        add(toolPanelButton);
        toolPanelButton.setVisible(true);
    }

    public void updateDisplayCube() {
        displayCube.setCubeSpaceAllocated(toolPanel.isOpen());
        displayCube.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, -1300, -900,this);
    }
}
