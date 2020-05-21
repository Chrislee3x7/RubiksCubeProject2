import javax.swing.*;
import javax.swing.plaf.ScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftToolsPanel extends JPanel implements ActionListener{

    private JComboBox viewOptions;

    private String[] views = {"Front View", "Top-Front View", "Front-Right View", "Top-Front-Right View"};

    private DisplayCube displayCube;

    private JTextArea moveHistoryBox;

    private JScrollPane scroll;

    private JLabel moveCountBox;

    private int numberOfMoves = 0;

    public LeftToolsPanel(DisplayCube displayCube) {
        this.displayCube = displayCube;
        setPreferredSize(new Dimension(325, 200));
        viewOptions = new JComboBox(views);
        moveHistoryBox = new JTextArea();
        moveHistoryBox.setFont(new Font("Courier",Font.PLAIN, 16));
        moveHistoryBox.setEditable(false);
        moveHistoryBox.setLineWrap(true);
        moveHistoryBox.setWrapStyleWord(true);
        scroll = new JScrollPane(moveHistoryBox);
        scroll.setPreferredSize(new Dimension(325, 130));
        moveHistoryBox.setOpaque(false);
        moveHistoryBox.setBackground(new Color(255,252,187, 50));
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBackground(new Color(255,252,187, 50));

        scroll.getVerticalScrollBar().setBackground(new Color(0,200,0));

        viewOptions.addActionListener(this);
        viewOptions.setSelectedItem("Top-Front-Right View");

        moveCountBox = new JLabel("Move count: " + numberOfMoves);

        setLayout(new BorderLayout());
        add(scroll, BorderLayout.NORTH);
        add(moveCountBox, BorderLayout.CENTER);
        add(viewOptions, BorderLayout.SOUTH);
        setOpaque(false);
    }

    public void addMove(String commandNotation)
    {
        moveHistoryBox.append(commandNotation + " ");
        numberOfMoves++;
        updateMoveCountBox();
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
    public void resetMoveHistoryBox() {
        moveHistoryBox.setText("");
        numberOfMoves = 0;
        updateMoveCountBox();
    }

    public void updateMoveCountBox()
    {
        moveCountBox.setText("Move count: " + numberOfMoves);
    }
}
