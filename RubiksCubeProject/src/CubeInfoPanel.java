import javax.swing.*;
import java.awt.*;

//contains cubeDisplay, and toolPanel
public class CubeInfoPanel extends JPanel {

    private Cube cube;

    private DisplayCube displayCube;

    private Image background;

    public CubeInfoPanel(Cube cube) {
        background = Toolkit.getDefaultToolkit().getImage("RubiksCubeProject/Background4.jpg");

        displayCube = cube.getDisplayCube();

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 700));


        //JComponent toolPanel = new JComponent();


        //toolPanel.setBackground(Color.CYAN);
        toolPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        toolPanel.setPreferredSize(new Dimension(600, 200));

        add(displayCube, BorderLayout.NORTH);
        add(toolPanel, BorderLayout.SOUTH);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, -1300, -900,this);
    }
}
