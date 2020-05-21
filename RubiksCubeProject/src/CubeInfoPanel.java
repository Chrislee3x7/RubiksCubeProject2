import sun.java2d.loops.GeneralRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

//contains cubeDisplay, and toolPanel
public class CubeInfoPanel extends JPanel implements MouseListener, KeyListener {

    private Cube cube;

    private DisplayCube displayCube;

    private ToolPanel toolPanel;

    private Image background;

    private String storedValuePressed = "";

    private boolean isPrimeDown = false;

    private RubiksCube rubiksCube;

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

    public CubeInfoPanel(Cube cube, RubiksCube rubiksCube) {
        background = Toolkit.getDefaultToolkit().getImage("RubiksCubeProject/Background4.jpg");

        this.rubiksCube = rubiksCube;
        this.cube = cube;
        displayCube = cube.getDisplayCube();

        toolPanel = new ToolPanel(cube);

        //setFocusable(true);
        //System.out.println(isFocusable());

        //controlPanel = new ControlPanel(cube, toolPanel.getLeftToolsPanel());


        addMouseListener(this);
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        setPreferredSize(new Dimension(650, 700));
        updateDisplayCube();
        //setBorder(BorderFactory.createLineBorder(Color.GREEN));

        setLayout(new BorderLayout());


        add(displayCube, BorderLayout.CENTER);
        add(toolPanel, BorderLayout.SOUTH);
        //add(controlPanel, BorderLayout.EAST);

//        setLayout(new GridBagLayout());
//
//        GridBagConstraints c = new GridBagConstraints();
//        c.fill = GridBagConstraints.VERTICAL;
//        //c.anchor = GridBagConstraints.FIRST_LINE_START;
//        c.anchor = GridBagConstraints.FIRST_LINE_START;
//        c.weightx = 0.5;
//        c.weighty = 0.5;
//        c.gridx = 0;
//        c.gridy = 0;
//        c.gridheight = 3;
//        c.gridwidth = 3;
//
//        add(displayCube, c);
//
//        c.weightx = 0.5;
//        c.weighty = 0.0;
//        c.gridx = 0;
//        c.gridy = 4;
//        c.gridheight = 1;
//        c.gridwidth = 3;
//
//        add(toolPanel, c);
//
//        c.weightx = 0.5;
//        c.weighty = 1;
//        c.gridx = 4;
//        c.gridy = 0;
//        c.gridwidth =  2;
//        c.gridheight = 4;
//        c.anchor = GridBagConstraints.LAST_LINE_END;
//        add(controlPanel, c);


//        c.fill = GridBagConstraints.VERTICAL;
//        c.gridx = 0;
//        c.gridy = 0;
//        c.gridwidth = 4;
//        add(displayCube, c);
//        c.gridx = 4;
//        c.gridy = 0;
//        c.gridwidth = 1;
//        add(new JButton("Button two"), c);
//        c.fill = GridBagConstraints.VERTICAL;
//        c.ipady = 20;
//        c.gridx = 4;
//        c.gridy = 1;
//        c.anchor = GridBagConstraints.PAGE_END;
//        this.add(new JButton("Button Four"), c);


    }

    public DisplayCube getDisplayCube() {
        return displayCube;
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
        if (e.getKeyChar() == '\'') {
            isPrimeDown = true;
            return;
        }

        storedValuePressed = Character.toString(e.getKeyChar()).toUpperCase();

        if (isPrimeDown && !storedValuePressed.isEmpty() && moveNotations.contains(storedValuePressed)) {

            cube.performMove(storedValuePressed + "'");
            toolPanel.getLeftToolsPanel().addMove(storedValuePressed + "'");
            CubeSounds.playRotateCubeSound4();
        } else if (!isPrimeDown && !storedValuePressed.isEmpty() && moveNotations.contains(storedValuePressed)) {

            cube.performMove(storedValuePressed);
            toolPanel.getLeftToolsPanel().addMove(storedValuePressed);
            CubeSounds.playRotateCubeSound4();
        }
        storedValuePressed = storedValuePressed.toLowerCase();
        if (isPrimeDown && !storedValuePressed.isEmpty() && moveNotations.contains(storedValuePressed)) {

            cube.performMove(storedValuePressed + "'");
            toolPanel.getLeftToolsPanel().addMove(storedValuePressed + "'");
            CubeSounds.playRotateCubeSound4();
        } else if (!isPrimeDown && !storedValuePressed.isEmpty() && moveNotations.contains(storedValuePressed)) {

            cube.performMove(storedValuePressed);
            toolPanel.getLeftToolsPanel().addMove(storedValuePressed);
            CubeSounds.playRotateCubeSound4();
        }

    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == '\'') {
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
