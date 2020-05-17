import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeViewPanel extends JPanel implements ActionListener{

    JComboBox viewOptions;

    String[] views = {"Front View", "Front-Right View", "Top-Front View", "Top-Front-Right View"};

    public ChangeViewPanel () {
        setPreferredSize(new Dimension(325, 200));
        viewOptions = new JComboBox(views);
        //this class will listen, and send commands to display cube
        viewOptions.addActionListener(this);
        setBorder(BorderFactory.createLineBorder(Color.RED));
        setLayout(new BorderLayout());
        add(viewOptions, BorderLayout.SOUTH);
        setOpaque(false);

    }

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String view = (String)cb.getSelectedItem();
        viewOptions.setName(view);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.setColor(Color.YELLOW);
//        g.drawOval(0, 0, 100, 100);

    }
}
