import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftToolsPanel extends JPanel implements ActionListener{

    private JComboBox viewOptions;

    private String[] views = {"Front View", "Top-Front View", "Front-Right View", "Top-Front-Right View"};

    private DisplayCube displayCube;

    private JTextArea moveHistoryBox;

    private JScrollPane scroll;

    public LeftToolsPanel(DisplayCube displayCube) {
        this.displayCube = displayCube;
        setPreferredSize(new Dimension(325, 200));
        viewOptions = new JComboBox(views);
        moveHistoryBox = new JTextArea();
        moveHistoryBox.setEditable(false);
        moveHistoryBox.setLineWrap(true);
        scroll = new JScrollPane(moveHistoryBox);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(325, 150));
        moveHistoryBox.setBackground(new Color(233,209,249));
        //this class will listen, and send commands to display cube
        viewOptions.addActionListener(this);
        viewOptions.setSelectedItem("Top-Front-Right View");
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.NORTH);
        add(viewOptions, BorderLayout.SOUTH);
        setOpaque(false);

    }

    public void addMove()
    {
        moveHistoryBox.append("PP");
        //Rip my life
    }

    public void actionPerformed(ActionEvent e) {
        String view = (String) ((JComboBox) e.getSource()).getSelectedItem();
        switch (view) {
            case "Front View":
                displayCube.setCurrentView(View.FRONT);
                break;
            case "Top-Front View":
                displayCube.setCurrentView(View.TOP_FRONT);
                break;
            case "Front-Right View":
                displayCube.setCurrentView(View.FRONT_RIGHT);
                break;
            case "Top-Front-Right View" :
                displayCube.setCurrentView(View.TOP_FRONT_RIGHT);
                break;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.setColor(Color.YELLOW);
//        g.drawOval(0, 0, 100, 100);

    }
}
