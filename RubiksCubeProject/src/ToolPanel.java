import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JPanel {

    private boolean isVisible;

    private CubeNetPanel cubeNet;

    public ToolPanel(Cube cube) {

        isVisible = true;
        setLayout(new BorderLayout());
        cubeNet = new CubeNetPanel(cube);
        add(cubeNet, BorderLayout.EAST);
        setBorder(BorderFactory.createLineBorder(Color.GREEN));
        setPreferredSize(new Dimension(650, 180));
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
        g.drawRect(40, 40, 40, 40);
    }
}
