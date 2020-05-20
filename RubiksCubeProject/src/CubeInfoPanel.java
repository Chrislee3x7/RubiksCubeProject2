import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//contains cubeDisplay, and toolPanel
public class CubeInfoPanel extends JPanel implements MouseListener, KeyListener{

    private Cube cube;

    private DisplayCube displayCube;

    private ToolPanel toolPanel;

    private Image background;

    public CubeInfoPanel(Cube cube) {
        background = Toolkit.getDefaultToolkit().getImage("RubiksCubeProject/Background4.jpg");

        displayCube = cube.getDisplayCube();

        toolPanel = new ToolPanel(cube);

        //setFocusable(true);
        //System.out.println(isFocusable());

        addMouseListener(this);
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
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

    public ToolPanel getToolPanel() {
        return toolPanel;
    }


    public void mouseClicked(MouseEvent e) {
        this.requestFocusInWindow();
        System.out.println("tyring to focus");
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("key typed");
        System.out.println(e.getKeyChar());
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("key pressed");
    }

    public void keyReleased(KeyEvent e) {

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
