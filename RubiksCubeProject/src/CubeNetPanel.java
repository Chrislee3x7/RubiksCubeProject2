import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class CubeNetPanel extends JComponent {

    private Cube cube;
    private CubeFace[] cubeFaceArray;
    private static final int faceDimensions = 55;
    private static final int distanceBetweenNetAndWindow = (200 - 3 * (faceDimensions))/2;
    private static final int distanceBetween2CubeFace = 3;
    private static final int fixDistance  = 10;

    public CubeNetPanel(Cube cube) {
        this.cube = cube;
        this.cubeFaceArray = cube.getCubeFaceArray();
        setPreferredSize(new Dimension(325, 200));
    }

    public void displayCubeNet () {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        paintEachCubeFace(g, (325 - (4 * faceDimensions))/2, faceDimensions + distanceBetweenNetAndWindow - fixDistance, 1);

        paintEachCubeFace(g, (325 - (4 * faceDimensions))/2 + (faceDimensions) + distanceBetween2CubeFace, faceDimensions + distanceBetweenNetAndWindow - fixDistance, 0);

        paintEachCubeFace(g, (325 - (4 * faceDimensions))/2 + (faceDimensions * 2) + distanceBetween2CubeFace * 2,  faceDimensions + distanceBetweenNetAndWindow - fixDistance, 3);

        paintEachCubeFace(g, (325 - (4 * faceDimensions))/2 + (faceDimensions * 3) + distanceBetween2CubeFace * 3 , faceDimensions + distanceBetweenNetAndWindow - fixDistance, 5);

        paintEachCubeFace(g, (325 - (4 * faceDimensions))/2 + (faceDimensions) + distanceBetween2CubeFace, distanceBetweenNetAndWindow - distanceBetween2CubeFace - fixDistance, 4);

        paintEachCubeFace(g, (325 - (4 * faceDimensions))/2 + (faceDimensions) + distanceBetween2CubeFace, 200 - faceDimensions - distanceBetweenNetAndWindow + distanceBetween2CubeFace - fixDistance, 2);





    }
    public void paintEachCubeFace(Graphics g, int topLeftCornerX, int topLeftCornerY, int faceIndex) {

        int stickerPaintedCount = 0;
        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                paintSticker(g, topLeftCornerX + (x * faceDimensions/3), topLeftCornerY + (y * faceDimensions/3), cubeFaceArray[faceIndex].getSticker(stickerPaintedCount));
                stickerPaintedCount++;
            }
        }


    }

    public void paintSticker (Graphics g, int topLeftCornerX, int topLeftCornerY, Sticker sticker) {
        Color displayColor = sticker.getDisplayColor();
        g.setColor(Color.black);
        g.drawRect(topLeftCornerX, topLeftCornerY, faceDimensions/3, faceDimensions/3);
        g.setColor(displayColor);
        g.fillRect(topLeftCornerX, topLeftCornerY, faceDimensions/3, faceDimensions/3);
    }

}
