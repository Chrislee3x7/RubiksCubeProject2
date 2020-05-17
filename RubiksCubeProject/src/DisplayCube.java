import javax.swing.*;
import java.awt.*;

public class DisplayCube extends JLayeredPane {

    private int cubeSpaceAllocated = CUBE_SPACE_ALLOCATED_WITH_TOOLS;

    private static final int CUBE_SPACE_ALLOCATED_WITHOUT_TOOLS = 700;

    private static final int CUBE_SPACE_ALLOCATED_WITH_TOOLS = 550;

    private static final int WINDOW_DIMENSION = 650;

    private static final int CUBE_OFFSET_FROM_WINDOW_EDGE = 40;

    private int CUBE_RADIUS = (cubeSpaceAllocated - 2 * CUBE_OFFSET_FROM_WINDOW_EDGE) / 2;

    private double APOTHEM = CUBE_RADIUS * Math.cos(Math.PI / 6);

    private double STICKER_DIAGONAL = (2 * APOTHEM - 4 * STICKER_GAP) / 3;

    private double STICKER_LENGTH = (STICKER_DIAGONAL / (Math.sqrt(3)));

    //based on up face
    private static final double STICKER_GAP = 10;

    private static final double SHORT_STICKER_GAP = (STICKER_GAP / (Math.sqrt(3))) / 2;

    private View currentView;

    private Cube cube;

    public DisplayCube(Cube cube) {
        this.cube = cube;
        setPreferredSize(new Dimension(WINDOW_DIMENSION, WINDOW_DIMENSION + 50));
        currentView = View.TOP_FRONT_RIGHT;
        //System.out.println(APOTHEM);
    }

    public void setCubeSpaceAllocated(boolean toolPanelIsOpen) {
        if (toolPanelIsOpen) {
            cubeSpaceAllocated = CUBE_SPACE_ALLOCATED_WITH_TOOLS;
        } else {
            cubeSpaceAllocated = CUBE_SPACE_ALLOCATED_WITHOUT_TOOLS;
        }
    }

    public void setCurrentView(View view) {
        currentView = view;
        update();
    }

    public void update() {
        repaint();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //displayCube0(g);
        //currentView = View.FRONT;
        switch (currentView) {
            case FRONT:
                displayCube0(g);
                break;
            case TOP_FRONT:
                displayCube1(g);
                break;
            case FRONT_RIGHT:
                displayCube2(g);
                break;
            case TOP_FRONT_RIGHT:
                displayCube3(g);
        }

    }

    //All display view type 0: FRONT
    public void displayCube0(Graphics g) {
        double cubeSideLength = APOTHEM * Math.sqrt(2);
        g.fillRect((int) (WINDOW_DIMENSION / 2 - cubeSideLength / 2),
                (int) (cubeSpaceAllocated / 2 - cubeSideLength / 2),
                (int) cubeSideLength, (int) cubeSideLength);
        CubeFace currentFace = cube.getCubeFaceArray()[cube.getFrontFaceIndex()];
        for (Sticker sticker : currentFace.getAllStickers()) {
            g.setColor(sticker.getDisplayColor());
            int stickerIndex = sticker.getStickerLocation().getStickerIndex();
            drawFrontSticker0(g, stickerIndex % 3, stickerIndex / 3);
        }
    }

    public void drawFrontSticker0(Graphics g, int x, int y) {
        double cubeSideLength = APOTHEM * Math.sqrt(2);
        double stickerGap = STICKER_GAP / 2 * Math.sqrt(2);
        double stickerLength = STICKER_DIAGONAL / 2 * Math.sqrt(2);
        g.fillRect((int) ((WINDOW_DIMENSION / 2 - cubeSideLength / 2 + stickerGap + x * (stickerGap + stickerLength))),
                (int) (cubeSpaceAllocated / 2 - cubeSideLength / 2 + stickerGap + y * (stickerGap + stickerLength)),
                (int) stickerLength, (int) stickerLength);
    }

    public void drawSideStickers0(Graphics g) {

    }

    //All display view type 1: TOP_FRONT
    public void displayCube1(Graphics g) {
        double shortCubeSideLength = APOTHEM;
        double cubeSideLength = APOTHEM * Math.sqrt(2);
        g.fillRect((int) (WINDOW_DIMENSION / 2 - cubeSideLength / 2), (int) (cubeSpaceAllocated / 2 - shortCubeSideLength),
                (int) cubeSideLength, (int) (shortCubeSideLength * 2));
        CubeFace currentFace = cube.getCubeFaceArray()[cube.getUpFaceIndex()];
        for (Sticker sticker : currentFace.getAllStickers()) {
            g.setColor(sticker.getDisplayColor());
            int stickerIndex = sticker.getStickerLocation().getStickerIndex();
            drawUpFaceSticker1(g, stickerIndex % 3, stickerIndex / 3);
        }
        currentFace = cube.getCubeFaceArray()[cube.getFrontFaceIndex()];
        for (Sticker sticker : currentFace.getAllStickers()) {
            g.setColor(sticker.getDisplayColor());
            int stickerIndex = sticker.getStickerLocation().getStickerIndex();
            drawFrontFaceSticker1(g, stickerIndex % 3, stickerIndex / 3);
        }
    }

    public void drawUpFaceSticker1(Graphics g, int x, int y) {
        double cubeSideLength = APOTHEM * Math.sqrt(2);
        double shortCubeSideLength = APOTHEM;
        double stickerGap = STICKER_GAP / 2 * Math.sqrt(2);
        double shortStickerGap = STICKER_GAP / 2;
        double stickerLength = STICKER_DIAGONAL / 2 * Math.sqrt(2);
        double shortStickerLength = STICKER_DIAGONAL / 2;
        g.fillRect((int) ((WINDOW_DIMENSION / 2 - cubeSideLength / 2 + stickerGap + x * (stickerGap + stickerLength))),
                (int) (cubeSpaceAllocated / 2 - shortCubeSideLength + shortStickerGap + y * (shortStickerGap + shortStickerLength)),
                (int) stickerLength, (int) shortStickerLength);

    }

    public void drawFrontFaceSticker1(Graphics g, int x, int y) {
        double cubeSideLength = APOTHEM * Math.sqrt(2);
        double shortCubeSideLength = APOTHEM;
        double stickerGap = STICKER_GAP / 2 * Math.sqrt(2);
        double shortStickerGap = STICKER_GAP / 2;
        double stickerLength = STICKER_DIAGONAL / 2 * Math.sqrt(2);
        double shortStickerLength = STICKER_DIAGONAL / 2;
        g.fillRect((int) ((WINDOW_DIMENSION / 2 - cubeSideLength / 2 + stickerGap + x * (stickerGap + stickerLength))),
                (int) (cubeSpaceAllocated / 2 + shortStickerGap + y * (shortStickerGap + shortStickerLength)),
                (int) stickerLength, (int) shortStickerLength);
    }


    //All display view type 1: FRONT_RIGHT
    public void displayCube2(Graphics g) {
        double shortCubeSideLength = APOTHEM;
        double cubeSideLength = APOTHEM * Math.sqrt(2);
        g.fillRect((int) (WINDOW_DIMENSION / 2 - shortCubeSideLength), (int) (cubeSpaceAllocated / 2 - cubeSideLength / 2),
                (int) (shortCubeSideLength * 2), (int) cubeSideLength);
        CubeFace currentFace = cube.getCubeFaceArray()[cube.getFrontFaceIndex()];
        for (Sticker sticker : currentFace.getAllStickers()) {
            g.setColor(sticker.getDisplayColor());
            int stickerIndex = sticker.getStickerLocation().getStickerIndex();
            drawFrontFaceSticker2(g, stickerIndex % 3, stickerIndex / 3);
        }
        currentFace = cube.getCubeFaceArray()[cube.getRightFaceIndex()];
        for (Sticker sticker : currentFace.getAllStickers()) {
            g.setColor(sticker.getDisplayColor());
            int stickerIndex = sticker.getStickerLocation().getStickerIndex();
            drawRightFaceSticker2(g, stickerIndex % 3, stickerIndex / 3);
        }
    }

    public void drawFrontFaceSticker2(Graphics g, int x, int y) {
        double cubeSideLength = APOTHEM * Math.sqrt(2);
        double shortCubeSideLength = APOTHEM;
        double stickerGap = STICKER_GAP / 2 * Math.sqrt(2);
        double shortStickerGap = STICKER_GAP / 2;
        double stickerLength = STICKER_DIAGONAL / 2 * Math.sqrt(2);
        double shortStickerLength = STICKER_DIAGONAL / 2;
        g.fillRect((int) ((WINDOW_DIMENSION / 2 - shortCubeSideLength + shortStickerGap + x * (shortStickerGap + shortStickerLength))),
                (int) (cubeSpaceAllocated / 2 - cubeSideLength / 2 + stickerGap + y * (stickerGap + stickerLength)),
                (int) shortStickerLength, (int) stickerLength);
    }

    public void drawRightFaceSticker2(Graphics g, int x, int y) {
        double cubeSideLength = APOTHEM * Math.sqrt(2);
        double shortCubeSideLength = APOTHEM;
        double stickerGap = STICKER_GAP / 2 * Math.sqrt(2);
        double shortStickerGap = STICKER_GAP / 2;
        double stickerLength = STICKER_DIAGONAL / 2 * Math.sqrt(2);
        double shortStickerLength = STICKER_DIAGONAL / 2;
        g.fillRect((int) ((WINDOW_DIMENSION / 2 + shortStickerGap + x * (shortStickerGap + shortStickerLength))),
                (int) (cubeSpaceAllocated / 2 - cubeSideLength / 2 + stickerGap + y * (stickerGap + stickerLength)),
                (int) shortStickerLength, (int) stickerLength);
    }

        //All display view type 3: TOP_FRONT_RIGHT
    public void displayCube3(Graphics g) {
        Polygon rhombus1 = new Polygon();
        rhombus1.addPoint(WINDOW_DIMENSION / 2, cubeSpaceAllocated / 2);
        rhombus1.addPoint((int) (WINDOW_DIMENSION / 2 + APOTHEM), cubeSpaceAllocated / 2 - CUBE_RADIUS / 2);
        rhombus1.addPoint(WINDOW_DIMENSION / 2, cubeSpaceAllocated / 2 - CUBE_RADIUS);
        rhombus1.addPoint((int) (WINDOW_DIMENSION / 2 - APOTHEM), cubeSpaceAllocated / 2 - CUBE_RADIUS / 2);
        Polygon rhombus2 = new Polygon();
        rhombus2.addPoint(WINDOW_DIMENSION / 2, cubeSpaceAllocated / 2);
        rhombus2.addPoint(WINDOW_DIMENSION / 2, cubeSpaceAllocated / 2 + CUBE_RADIUS);
        rhombus2.addPoint((int) (WINDOW_DIMENSION / 2 - APOTHEM), cubeSpaceAllocated / 2 + CUBE_RADIUS / 2);
        rhombus2.addPoint((int) (WINDOW_DIMENSION / 2 - APOTHEM), cubeSpaceAllocated / 2 - CUBE_RADIUS / 2);
        Polygon rhombus3 = new Polygon();
        rhombus3.addPoint(WINDOW_DIMENSION / 2, cubeSpaceAllocated / 2);
        rhombus3.addPoint(WINDOW_DIMENSION / 2, cubeSpaceAllocated / 2 + CUBE_RADIUS);
        rhombus3.addPoint((int) (WINDOW_DIMENSION / 2 + APOTHEM), cubeSpaceAllocated / 2 + CUBE_RADIUS / 2);
        rhombus3.addPoint((int) (WINDOW_DIMENSION / 2 + APOTHEM), cubeSpaceAllocated / 2 - CUBE_RADIUS / 2);

        g.setColor(Color.BLACK);
        g.fillPolygon(rhombus1);
        g.fillPolygon(rhombus2);
        g.fillPolygon(rhombus3);
//        g.setColor(Color.WHITE);

        displayCubeFace3(g, cube.getUpFaceIndex(), LayerNotation.U);
        displayCubeFace3(g, cube.getFrontFaceIndex(), LayerNotation.F);
        displayCubeFace3(g, cube.getRightFaceIndex(), LayerNotation.R);

        //g.fillPolygon(makeUpFaceSticker3(2, 2));
    }

    public void displayCubeFace3(Graphics g, int faceIndex, LayerNotation face) {
        CubeFace currentFace = cube.getCubeFaceArray()[faceIndex];
        for (Sticker sticker : currentFace.getAllStickers()) {
            g.setColor(sticker.getDisplayColor());
//            g.setColor(Color.green);
            //System.out.println(stickerColor);
            switch (face) {
                case U:
                    g.fillPolygon(makeUpFaceSticker3(sticker.getStickerLocation().getStickerIndex() % 3,
                            sticker.getStickerLocation().getStickerIndex() / 3));
                    break;
                case F:
                    g.fillPolygon(makeFrontFaceSticker3(sticker.getStickerLocation().getStickerIndex() % 3,
                            sticker.getStickerLocation().getStickerIndex() / 3));
                    break;
                case R:
                    g.fillPolygon(makeRightFaceSticker3(sticker.getStickerLocation().getStickerIndex() % 3,
                            sticker.getStickerLocation().getStickerIndex() / 3));
                    break;
                default:
                    System.out.println("this is a broken sticker");
            }
        }
    }

    public Polygon makeUpFaceSticker3(int sX, int sY) {
        final double horizontalTranslate = (0.5 * STICKER_GAP + 0.5 * STICKER_DIAGONAL);
        final double verticalTranslate = SHORT_STICKER_GAP + 0.5 * STICKER_LENGTH;
        final double baseX1 = (WINDOW_DIMENSION / 2 - APOTHEM + 2 * STICKER_GAP + STICKER_DIAGONAL);
        final double baseY1 = (cubeSpaceAllocated / 2 - CUBE_RADIUS + STICKER_LENGTH / 2 + 2 * SHORT_STICKER_GAP);
        final double baseX2 = (WINDOW_DIMENSION / 2 - APOTHEM + 2 * STICKER_GAP + STICKER_DIAGONAL / 2 + STICKER_DIAGONAL);
        final double baseY2 = (cubeSpaceAllocated / 2 - CUBE_RADIUS + 2 * SHORT_STICKER_GAP);
        final double baseX3 = (WINDOW_DIMENSION / 2 - APOTHEM + 2 * STICKER_GAP + STICKER_DIAGONAL + STICKER_DIAGONAL);
        final double baseY3 = (cubeSpaceAllocated / 2 - CUBE_RADIUS + STICKER_LENGTH / 2 + 2 * SHORT_STICKER_GAP);
        final double baseX4 = (WINDOW_DIMENSION / 2 - APOTHEM + 2 * STICKER_GAP + STICKER_DIAGONAL / 2 + STICKER_DIAGONAL);
        final double baseY4 = (cubeSpaceAllocated / 2 - CUBE_RADIUS + STICKER_LENGTH + 2 * SHORT_STICKER_GAP);

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

    public Polygon makeFrontFaceSticker3(int sX, int sY) {
        final double horizontalTranslate = STICKER_DIAGONAL / 2 + STICKER_GAP / 2;
        final double verticalTranslate = STICKER_LENGTH + 2 * SHORT_STICKER_GAP;
        final double horizontalCausedVerticalTranslate = STICKER_LENGTH / 2 + SHORT_STICKER_GAP;
        final double baseX1 = (WINDOW_DIMENSION / 2 - APOTHEM + STICKER_GAP / 2);
        final double baseY1 = (cubeSpaceAllocated / 2 - SHORT_STICKER_GAP - STICKER_LENGTH / 2);
        final double baseX2 = (WINDOW_DIMENSION / 2 - APOTHEM + STICKER_GAP / 2);
        final double baseY2 = (cubeSpaceAllocated / 2 - STICKER_LENGTH - SHORT_STICKER_GAP - STICKER_LENGTH / 2);
        final double baseX3 = (WINDOW_DIMENSION / 2 - APOTHEM + STICKER_GAP / 2 + STICKER_DIAGONAL / 2);
        final double baseY3 = (cubeSpaceAllocated / 2 - STICKER_LENGTH / 2 - SHORT_STICKER_GAP - STICKER_LENGTH / 2);
        final double baseX4 = (WINDOW_DIMENSION / 2 - APOTHEM + STICKER_GAP / 2 + STICKER_DIAGONAL / 2);
        final double baseY4 = (cubeSpaceAllocated / 2 + STICKER_LENGTH / 2 - SHORT_STICKER_GAP - STICKER_LENGTH / 2);

        Polygon sticker = new Polygon();
        sticker.addPoint((int) (baseX1 + sX * horizontalTranslate), (int) (baseY1 + sY * verticalTranslate + sX * horizontalCausedVerticalTranslate));
        sticker.addPoint((int) (baseX2 + sX * horizontalTranslate), (int) (baseY2 + sY * verticalTranslate + sX * horizontalCausedVerticalTranslate));
        sticker.addPoint((int) (baseX3 + sX * horizontalTranslate), (int) (baseY3 + sY * verticalTranslate + sX * horizontalCausedVerticalTranslate));
        sticker.addPoint((int) (baseX4 + sX * horizontalTranslate), (int) (baseY4 + sY * verticalTranslate + sX * horizontalCausedVerticalTranslate));

        return sticker;
    }

    public Polygon makeRightFaceSticker3(int sX, int sY) {
        final double horizontalTranslate = STICKER_DIAGONAL / 2 + STICKER_GAP / 2;
        final double verticalTranslate = STICKER_LENGTH + SHORT_STICKER_GAP * 2;
        final double horizontalCausedVerticalTranslate = STICKER_LENGTH / 2 + SHORT_STICKER_GAP;
        final double baseX1 = (WINDOW_DIMENSION / 2 + STICKER_GAP / 2 + STICKER_DIAGONAL / 2);
        final double baseY1 = (cubeSpaceAllocated / 2 + SHORT_STICKER_GAP + STICKER_LENGTH / 2);
        final double baseX2 = (WINDOW_DIMENSION / 2 + STICKER_GAP / 2 + STICKER_DIAGONAL / 2);
        final double baseY2 = (cubeSpaceAllocated / 2 - STICKER_LENGTH + SHORT_STICKER_GAP + STICKER_LENGTH / 2);
        final double baseX3 = (WINDOW_DIMENSION / 2 + STICKER_GAP / 2);
        final double baseY3 = (cubeSpaceAllocated / 2 - STICKER_LENGTH / 2 + SHORT_STICKER_GAP + STICKER_LENGTH / 2);
        final double baseX4 = (WINDOW_DIMENSION / 2 + STICKER_GAP / 2);
        final double baseY4 = (cubeSpaceAllocated / 2 + STICKER_LENGTH / 2 + SHORT_STICKER_GAP + STICKER_LENGTH / 2);

        Polygon sticker = new Polygon();
        sticker.addPoint((int) (baseX1 + sX * horizontalTranslate), (int) (baseY1 + sY * verticalTranslate - sX * horizontalCausedVerticalTranslate));
        sticker.addPoint((int) (baseX2 + sX * horizontalTranslate), (int) (baseY2 + sY * verticalTranslate - sX * horizontalCausedVerticalTranslate));
        sticker.addPoint((int) (baseX3 + sX * horizontalTranslate), (int) (baseY3 + sY * verticalTranslate - sX * horizontalCausedVerticalTranslate));
        sticker.addPoint((int) (baseX4 + sX * horizontalTranslate), (int) (baseY4 + sY * verticalTranslate - sX * horizontalCausedVerticalTranslate));

        return sticker;
    }
}
