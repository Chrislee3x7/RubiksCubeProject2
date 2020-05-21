import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

//contains cubeDisplay, and toolPanel
public class CubeInfoPanel extends JPanel implements MouseListener, KeyListener{

    private Cube cube;

    private DisplayCube displayCube;

    private ToolPanel toolPanel;

    private Image background;

    private String storedValuePressed = "";

    private boolean isPrimeDown = false;

    private List<String> moveNotations = new ArrayList<>();
    {
        moveNotations.add("R");
        moveNotations.add("R'");
        moveNotations.add("L");
        moveNotations.add("L'");
        moveNotations.add("B");
        moveNotations.add("B'");
        moveNotations.add("F");
        moveNotations.add("F'");
        moveNotations.add("D");
        moveNotations.add("D'");
        moveNotations.add("U");
        moveNotations.add("U'");
        moveNotations.add("R");
        moveNotations.add("R'");
        moveNotations.add("z");
        moveNotations.add("z'");
        moveNotations.add("S");
        moveNotations.add("S'");
        moveNotations.add("y");
        moveNotations.add("y'");
        moveNotations.add("E");
        moveNotations.add("E'");
        moveNotations.add("x");
        moveNotations.add("x'");
        moveNotations.add("M");
        moveNotations.add("M'");
    }

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
    }

    public void keyTyped(KeyEvent e) {
//        System.out.println("key typed");
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == '\'') {
            isPrimeDown = true;
        }


        storedValuePressed = Character.toString(e.getKeyChar());

        if(isPrimeDown && !storedValuePressed.isEmpty() && moveNotations.contains(storedValuePressed)) {
            if(storedValuePressed.equals("r") || storedValuePressed.equals("l") || storedValuePressed.equals("f") || storedValuePressed.equals("d") || storedValuePressed.equals("u") || storedValuePressed.equals("b")) {
                this.storedValuePressed = storedValuePressed.toUpperCase();
            }
            if(e.getKeyChar() != '\''){
                System.out.println("ho");
                cube.performMove(storedValuePressed + "'");

            }
        }
        if(!isPrimeDown && !storedValuePressed.isEmpty() && moveNotations.contains(storedValuePressed)){
            if(storedValuePressed.equals("r") || storedValuePressed.equals("l") || storedValuePressed.equals("f") || storedValuePressed.equals("d") || storedValuePressed.equals("u") || storedValuePressed.equals("b")) {
                this.storedValuePressed = storedValuePressed.toUpperCase();
            }
            if(e.getKeyChar() != '\''){
                System.out.println("dodododoodod");
                cube.performMove(storedValuePressed);
            }

        }

    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == '\'') {
            isPrimeDown = false;
        }
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
