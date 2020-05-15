import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel{

    private static final int WIDTH = 400;

    //Window dimension from displaycube
    private static final int HEIGHT = 600;

    public ControlPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT + 50));
    }

}
