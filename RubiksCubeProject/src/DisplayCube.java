import javax.swing.*;
import java.awt.*;

public class DisplayCube extends JComponent {

    private static final int CUBE_SPACE_ALLOCATED = 550;

    private static final int WINDOW_DIMENSION = 650;

    private static final int CUBE_OFFSET_FROM_WINDOW_EDGE = 40;

    private static final int CUBE_RADIUS = (CUBE_SPACE_ALLOCATED - 2 * CUBE_OFFSET_FROM_WINDOW_EDGE) / 2;

    private static final double APOTHEM = CUBE_RADIUS * Math.cos(Math.PI / 6);

    //based on up face
    private static final double STICKER_GAP = 10;

    private static final double SHORT_STICKER_GAP = (STICKER_GAP / (Math.sqrt(3))) / 2;

    private static final double STICKER_DIAGONAL = (2 * APOTHEM - 4 * STICKER_GAP) / 3;

    private static final double STICKER_LENGTH = (STICKER_DIAGONAL / (Math.sqrt(3)));

    //private Image background;

    private Cube cube;

    public DisplayCube(Cube cube) {
        this.cube = cube;
        setPreferredSize(new Dimension(WINDOW_DIMENSION, WINDOW_DIMENSION - 100));


        //System.out.println(APOTHEM);
    }

    public void update() {
        repaint();
    }

    public Color getDisplayColor(StickerColor stickerColor) {
        switch (stickerColor) {
            case WHITE:
                // can be changed to take user input later
                return Color.WHITE;
            case ORANGE:
                return new Color(255, 135, 8);
            case GREEN:
                return new Color(9, 207, 2);
            case BLUE:
                return new Color(8, 119, 255);
            case RED:
                return new Color(235, 41, 2);
            case YELLOW:
                return Color.YELLOW;
            default:
                //System.out.println("Bruh where's the color");
                return null;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

//        g.drawImage(background, -1300, -900,this);
        //Background3
        //g.drawImage(background, -900, -400, this);

        Polygon rhombus1 = new Polygon();
        rhombus1.addPoint(WINDOW_DIMENSION / 2, CUBE_SPACE_ALLOCATED / 2);
        rhombus1.addPoint((int) (WINDOW_DIMENSION / 2 + APOTHEM), CUBE_SPACE_ALLOCATED / 2 - CUBE_RADIUS / 2);
        rhombus1.addPoint(WINDOW_DIMENSION / 2, CUBE_SPACE_ALLOCATED / 2 - CUBE_RADIUS);
        rhombus1.addPoint((int) (WINDOW_DIMENSION / 2 - APOTHEM), CUBE_SPACE_ALLOCATED / 2 - CUBE_RADIUS / 2);
        Polygon rhombus2 = new Polygon();
        rhombus2.addPoint(WINDOW_DIMENSION / 2, CUBE_SPACE_ALLOCATED / 2);
        rhombus2.addPoint(WINDOW_DIMENSION / 2, CUBE_SPACE_ALLOCATED / 2 + CUBE_RADIUS);
        rhombus2.addPoint((int) (WINDOW_DIMENSION / 2 - APOTHEM), CUBE_SPACE_ALLOCATED / 2 + CUBE_RADIUS / 2);
        rhombus2.addPoint((int) (WINDOW_DIMENSION / 2 - APOTHEM), CUBE_SPACE_ALLOCATED / 2 - CUBE_RADIUS / 2);
        Polygon rhombus3 = new Polygon();
        rhombus3.addPoint(WINDOW_DIMENSION / 2, CUBE_SPACE_ALLOCATED / 2);
        rhombus3.addPoint(WINDOW_DIMENSION / 2, CUBE_SPACE_ALLOCATED / 2 + CUBE_RADIUS);
        rhombus3.addPoint((int) (WINDOW_DIMENSION / 2 + APOTHEM), CUBE_SPACE_ALLOCATED / 2 + CUBE_RADIUS / 2);
        rhombus3.addPoint((int) (WINDOW_DIMENSION / 2 + APOTHEM), CUBE_SPACE_ALLOCATED / 2 - CUBE_RADIUS / 2);

        g.setColor(Color.BLACK);
        g.fillPolygon(rhombus1);
        g.fillPolygon(rhombus2);
        g.fillPolygon(rhombus3);
//        g.setColor(Color.WHITE);

        displayCubeFace(g, cube.getUpFaceIndex(), LayerNotation.U);
        displayCubeFace(g, cube.getFrontFaceIndex(), LayerNotation.F);
        displayCubeFace(g, cube.getRightFaceIndex(), LayerNotation.R);

        //g.fillPolygon(makeUpFaceSticker(2, 2));

    }

    public void displayCubeFace(Graphics g, int faceIndex, LayerNotation face) {
        CubeFace currentFace = cube.getCubeFaceArray()[faceIndex];
        for (Sticker sticker : currentFace.getAllStickers()) {
            StickerColor stickerColor = sticker.getColor();
            g.setColor(getDisplayColor(stickerColor));
//            g.setColor(Color.green);
            //System.out.println(stickerColor);
            switch (face) {
                case U:
                    g.fillPolygon(makeUpFaceSticker(sticker.getStickerLocation().getStickerIndex() % 3,
                            sticker.getStickerLocation().getStickerIndex() / 3));
                    break;
                case F:
                    g.fillPolygon(makeFrontFaceSticker(sticker.getStickerLocation().getStickerIndex() % 3,
                            sticker.getStickerLocation().getStickerIndex() / 3));
                    break;
                case R:
                    g.fillPolygon(makeRightFaceSticker(sticker.getStickerLocation().getStickerIndex() % 3,
                            sticker.getStickerLocation().getStickerIndex() / 3));
                    break;
                default:
                    System.out.println("this is a broken sticker");
            }
        }
    }

    public Polygon makeUpFaceSticker(int sX, int sY) {
        final double horizontalTranslate = (0.5 * STICKER_GAP + 0.5 * STICKER_DIAGONAL);
        final double verticalTranslate = SHORT_STICKER_GAP + 0.5 * STICKER_LENGTH;
        final double baseX1 = (WINDOW_DIMENSION / 2 - APOTHEM + 2 * STICKER_GAP + STICKER_DIAGONAL);
        final double baseY1 = (CUBE_SPACE_ALLOCATED / 2 - CUBE_RADIUS + STICKER_LENGTH / 2 + 2 * SHORT_STICKER_GAP);
        final double baseX2 = (WINDOW_DIMENSION / 2 - APOTHEM + 2 * STICKER_GAP + STICKER_DIAGONAL / 2 + STICKER_DIAGONAL);
        final double baseY2 = (CUBE_SPACE_ALLOCATED / 2 - CUBE_RADIUS + 2 * SHORT_STICKER_GAP);
        final double baseX3 = (WINDOW_DIMENSION / 2 - APOTHEM + 2 * STICKER_GAP + STICKER_DIAGONAL + STICKER_DIAGONAL);
        final double baseY3 = (CUBE_SPACE_ALLOCATED / 2 - CUBE_RADIUS + STICKER_LENGTH / 2 + 2 * SHORT_STICKER_GAP);
        final double baseX4 = (WINDOW_DIMENSION / 2 - APOTHEM + 2 * STICKER_GAP + STICKER_DIAGONAL / 2 + STICKER_DIAGONAL);
        final double baseY4 = (CUBE_SPACE_ALLOCATED / 2 - CUBE_RADIUS + STICKER_LENGTH + 2 * SHORT_STICKER_GAP);

        Polygon sticker = new Polygon();
        sticker.addPoint((int) (baseX1 + sX * horizontalTranslate - sY * horizontalTranslate),
                (int) (baseY1 + sY * verticalTranslate + sX * verticalTranslate));
        sticker.addPoint((int) (baseX2 + sX * horizontalTranslate - sY * horizontalTranslate),
                (int) (baseY2 + sY * verticalTranslate + sX * verticalTranslate));
        sticker.addPoint((int) (baseX3 + sX * horizontalTranslate - sY * horizontalTranslate),
                (int) (baseY3 + sY * verticalTranslate + sX * verticalTranslate));
        sticker.addPoint((int) (baseX4 + sX * horizontalTranslate - sY * horizontalTranslate),
                (int) (baseY4 + sY * verticalTranslate + sX * verticalTranslate));

        return sticker;
    }

    public Polygon makeFrontFaceSticker(int sX, int sY) {
        final double horizontalTranslate = STICKER_DIAGONAL / 2 + STICKER_GAP / 2;
        final double verticalTranslate = STICKER_LENGTH + 2 * SHORT_STICKER_GAP;
        final double horizontalCausedVerticalTranslate = STICKER_LENGTH / 2 + SHORT_STICKER_GAP;
        final double baseX1 = (WINDOW_DIMENSION / 2 - APOTHEM + STICKER_GAP / 2);
        final double baseY1 = (CUBE_SPACE_ALLOCATED / 2 - SHORT_STICKER_GAP - STICKER_LENGTH / 2);
        final double baseX2 = (WINDOW_DIMENSION / 2 - APOTHEM + STICKER_GAP / 2);
        final double baseY2 = (CUBE_SPACE_ALLOCATED / 2 - STICKER_LENGTH - SHORT_STICKER_GAP - STICKER_LENGTH / 2);
        final double baseX3 = (WINDOW_DIMENSION / 2 - APOTHEM + STICKER_GAP / 2 + STICKER_DIAGONAL / 2);
        final double baseY3 = (CUBE_SPACE_ALLOCATED / 2 - STICKER_LENGTH / 2 - SHORT_STICKER_GAP - STICKER_LENGTH / 2);
        final double baseX4 = (WINDOW_DIMENSION / 2 - APOTHEM + STICKER_GAP / 2 + STICKER_DIAGONAL / 2);
        final double baseY4 = (CUBE_SPACE_ALLOCATED / 2 + STICKER_LENGTH / 2 - SHORT_STICKER_GAP - STICKER_LENGTH / 2);

        Polygon sticker = new Polygon();
        sticker.addPoint((int) (baseX1 + sX * horizontalTranslate), (int) (baseY1 + sY * verticalTranslate + sX * horizontalCausedVerticalTranslate));
        sticker.addPoint((int) (baseX2 + sX * horizontalTranslate), (int) (baseY2 + sY * verticalTranslate + sX * horizontalCausedVerticalTranslate));
        sticker.addPoint((int) (baseX3 + sX * horizontalTranslate), (int) (baseY3 + sY * verticalTranslate + sX * horizontalCausedVerticalTranslate));
        sticker.addPoint((int) (baseX4 + sX * horizontalTranslate), (int) (baseY4 + sY * verticalTranslate + sX * horizontalCausedVerticalTranslate));

        return sticker;
    }

    public Polygon makeRightFaceSticker(int sX, int sY) {
        final double horizontalTranslate = STICKER_DIAGONAL / 2 + STICKER_GAP / 2;
        final double verticalTranslate = STICKER_LENGTH + SHORT_STICKER_GAP * 2;
        final double horizontalCausedVerticalTranslate = STICKER_LENGTH / 2 + SHORT_STICKER_GAP;
        final double baseX1 = (WINDOW_DIMENSION / 2 + STICKER_GAP / 2 + STICKER_DIAGONAL / 2);
        final double baseY1 = (CUBE_SPACE_ALLOCATED / 2 + SHORT_STICKER_GAP + STICKER_LENGTH / 2);
        final double baseX2 = (WINDOW_DIMENSION / 2 + STICKER_GAP / 2 + STICKER_DIAGONAL / 2);
        final double baseY2 = (CUBE_SPACE_ALLOCATED / 2 - STICKER_LENGTH + SHORT_STICKER_GAP + STICKER_LENGTH / 2);
        final double baseX3 = (WINDOW_DIMENSION / 2 + STICKER_GAP / 2);
        final double baseY3 = (CUBE_SPACE_ALLOCATED / 2 - STICKER_LENGTH / 2 + SHORT_STICKER_GAP + STICKER_LENGTH / 2);
        final double baseX4 = (WINDOW_DIMENSION / 2 + STICKER_GAP / 2);
        final double baseY4 = (CUBE_SPACE_ALLOCATED / 2 + STICKER_LENGTH / 2 + SHORT_STICKER_GAP + STICKER_LENGTH / 2);

        Polygon sticker = new Polygon();
        sticker.addPoint((int) (baseX1 + sX * horizontalTranslate), (int) (baseY1 + sY * verticalTranslate - sX * horizontalCausedVerticalTranslate));
        sticker.addPoint((int) (baseX2 + sX * horizontalTranslate), (int) (baseY2 + sY * verticalTranslate - sX * horizontalCausedVerticalTranslate));
        sticker.addPoint((int) (baseX3 + sX * horizontalTranslate), (int) (baseY3 + sY * verticalTranslate - sX * horizontalCausedVerticalTranslate));
        sticker.addPoint((int) (baseX4 + sX * horizontalTranslate), (int) (baseY4 + sY * verticalTranslate - sX * horizontalCausedVerticalTranslate));

        return sticker;
    }
}
