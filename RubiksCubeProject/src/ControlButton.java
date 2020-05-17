import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class ControlButton extends JButton implements ActionListener {

    private ControlPanel controlPanel;

    private String moveNotation;

    public ControlButton(ControlPanel controlPanel, String moveNotation) {
        super(moveNotation);

        if (moveNotation.contains("U") || moveNotation.contains("L") || moveNotation.contains("F")
                || moveNotation.contains("R") || moveNotation.contains("B") || moveNotation.contains("D")) {
            setBackground(new Color(193, 221, 216));
        }
        else if (moveNotation.contains("M") || moveNotation.contains("S") || moveNotation.contains("E")) {
            setBackground(new Color(245, 228, 220));
        }
        else {
            setBackground(new Color(242, 194, 194));
        }
        setOpaque(true);
        setFont(new Font("Futura", Font.ITALIC, 30));
        this.moveNotation = moveNotation;
        this.controlPanel = controlPanel;
        this.addActionListener(this);
    }

    //When button pressed, sends to control panel: R, R' F' etc
    public void actionPerformed(ActionEvent e) {
        controlPanel.sendCommand(moveNotation);
    }
}
