import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlButton extends JButton implements MouseListener {

    private ControlPanel controlPanel;

    private String moveNotation;

    public ControlButton(ControlPanel controlPanel, String moveNotation) {
        super(moveNotation);
        setFont(new Font("Futura", Font.ITALIC, 30));
        this.moveNotation = moveNotation;
        this.controlPanel = controlPanel;
        this.addMouseListener(this);
    }

    //When mouse pressed, sends to control panel: R, R' F' etc
    public void mousePressed(MouseEvent e) {
        controlPanel.sendCommand( moveNotation);
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }
}
