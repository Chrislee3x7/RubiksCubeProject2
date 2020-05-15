import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlButton extends JButton implements MouseListener {

    private ControlPanel controlPanel;

    private String moveNotation;

    public ControlButton(ControlPanel controlPanel, String moveNotation) {
        super(moveNotation);
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
