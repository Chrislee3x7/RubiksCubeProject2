import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Cube {

    private CubeFace[] cubeFaceArray;
    private int upFaceIndex;
    private int frontFaceIndex;
    private int rightFaceIndex;
    private DisplayCube displayCube;


    public Cube() {

        this.displayCube = new DisplayCube(this);
        cubeFaceArray = new CubeFace[6];
        cubeFaceArray[0] = new CubeFace(StickerColor.WHITE, 0);
        cubeFaceArray[1] = new CubeFace(StickerColor.ORANGE, 1);
        cubeFaceArray[2] = new CubeFace(StickerColor.GREEN, 2);
        cubeFaceArray[3] = new CubeFace(StickerColor.RED, 3);
        cubeFaceArray[4] = new CubeFace(StickerColor.BLUE, 4);
        cubeFaceArray[5] = new CubeFace(StickerColor.YELLOW, 5);
        upFaceIndex = 0;
        frontFaceIndex = 2;
        rightFaceIndex = 3;
    }

    public CubeFace[] getCubeFaceArray() {
        return cubeFaceArray;
    }

    public int getUpFaceIndex() {
        return upFaceIndex;
    }

    public int getFrontFaceIndex() {
        return frontFaceIndex;
    }

    public int getRightFaceIndex() {
        return rightFaceIndex;
    }

    public DisplayCube getDisplayCube() {
        return displayCube;
    }

    public void scrambleCube() {
        StringBuilder scramble = scrambleGenerator();
        while (scramble.length() > 0) {
            String currentMove = scramble.substring(0, 1);
            if(scramble.substring(0, 1).equals(" ")) {
                scramble.replace(0, 1, "");
            }
            else {
                preformMove(currentMove);
                scramble.replace(0, 1, "");
            }

        }
    }

    //basically all stickers of the layer being rotated must move.
    //each sticker (except center) has "other" sticker(s) that must follow it
    //because they are attached to the same piece
    //so when this method is called, it will move not just the stickers on its own layer,
    //but also the connected stickers.

    public StringBuilder scrambleGenerator () {
        int randomNumOfMoves = (int) (Math.random() * 5 + 26);
        StringBuilder scrambleNotation = new StringBuilder();
        int i = 0;
        String temp1 = "";
        String temp2 = "";
        while (i < randomNumOfMoves) {
            int randomMove = (int) (Math.random() * ControlPanel.moveNotations.length);
            String temp = ControlPanel.moveNotations[randomMove];

//            if((temp1.equals(temp2) && temp1.equals(temp) && !temp1.equals("") && !temp2.equals("")) || (temp2.endsWith("'") && temp.charAt(0) == temp2.charAt(0)) || (temp.endsWith("'") && temp2.charAt(0) == temp.charAt(0))) {
//                continue;
//            }
//            if (temp1 .equals(temp) && temp2.equals(temp) &&  )
//            if(!temp1.equals("")){
//                temp2 = temp1;
//            }
//            temp1 = temp;

            scrambleNotation.append(temp + " ");
            i++;
        }
        return scrambleNotation;
    }

    public void preformMove (String commandNotation) {
//        MoveNotationInfo moveNotationInfo = ControlPanel.moveNotationInfoMap.get(commandNotation);
//        rotateSide(moveNotationInfo.getLayerNotation(), moveNotationInfo.getTurnDirection());

        switch (commandNotation) {
            case "U":
                rotateSide(LayerNotation.U, TurnDirection.CLOCKWISE);
                break;
            case "U'":
                rotateSide(LayerNotation.U, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "L":
                rotateSide(LayerNotation.L, TurnDirection.CLOCKWISE);
                break;
            case "L'":
                rotateSide(LayerNotation.L, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "F":
                rotateSide(LayerNotation.F, TurnDirection.CLOCKWISE);
                break;
            case "F'":
                rotateSide(LayerNotation.F, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "R":
                rotateSide(LayerNotation.R, TurnDirection.CLOCKWISE);
                break;
            case "R'":
                rotateSide(LayerNotation.R, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "B":
                rotateSide(LayerNotation.B, TurnDirection.CLOCKWISE);
                break;
            case "B'":
                rotateSide(LayerNotation.B, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "D":
                rotateSide(LayerNotation.D, TurnDirection.CLOCKWISE);
                break;
            case "D'":
                rotateSide(LayerNotation.D, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "M":
                rotateMiddleLayer(LayerNotation.M, TurnDirection.CLOCKWISE);
                break;
            case "M'":
                rotateMiddleLayer(LayerNotation.M, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "S":
                rotateMiddleLayer(LayerNotation.S, TurnDirection.CLOCKWISE);
                break;
            case "S'":
                rotateMiddleLayer(LayerNotation.S, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "E":
                rotateMiddleLayer(LayerNotation.E, TurnDirection.CLOCKWISE);
                break;
            case "E'":
                rotateMiddleLayer(LayerNotation.E, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "x":
                rotateCube(LayerNotation.X, TurnDirection.CLOCKWISE);
                break;
            case "x'":
                rotateCube(LayerNotation.X, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "y":
                rotateCube(LayerNotation.Y, TurnDirection.CLOCKWISE);
                break;
            case "y'":
                rotateCube(LayerNotation.Y, TurnDirection.COUNTERCLOCKWISE);
                break;
            case "z":
                rotateCube(LayerNotation.Z, TurnDirection.CLOCKWISE);
                break;
            case "z'":
                rotateCube(LayerNotation.Z, TurnDirection.COUNTERCLOCKWISE);
                break;
        }
        displayCube.update();

    }

    public void rotateCube (LayerNotation layerNotation, TurnDirection turnDirection) {
        switch (layerNotation) {
            case Z:
                switch (turnDirection) {
                    case CLOCKWISE:
                        rotateSide(frontFaceIndex, turnDirection);
                        rotateMiddleLayer(LayerNotation.S, turnDirection);
                        rotateSide(getOppositeFaceColor(frontFaceIndex), TurnDirection.COUNTERCLOCKWISE);
                        break;
                    case COUNTERCLOCKWISE:
                        rotateSide(frontFaceIndex, turnDirection);
                        rotateMiddleLayer(LayerNotation.S, turnDirection);
                        rotateSide(getOppositeFaceColor(frontFaceIndex), TurnDirection.CLOCKWISE);
                        break;
                }
                break;
            case Y:
                switch (turnDirection) {
                    case CLOCKWISE:
                        rotateSide(upFaceIndex, TurnDirection.CLOCKWISE);
                        rotateMiddleLayer(LayerNotation.E, TurnDirection.COUNTERCLOCKWISE);
                        rotateSide(getOppositeFaceColor(upFaceIndex), TurnDirection.COUNTERCLOCKWISE);
                        break;
                    case COUNTERCLOCKWISE:
                        rotateSide(upFaceIndex, TurnDirection.COUNTERCLOCKWISE);
                        rotateMiddleLayer(LayerNotation.E, TurnDirection.CLOCKWISE);
                        rotateSide(getOppositeFaceColor(upFaceIndex), TurnDirection.CLOCKWISE);
                        break;
                }
                break;
            case X:
                switch (turnDirection) {
                    case CLOCKWISE:
                        rotateSide(rightFaceIndex, TurnDirection.CLOCKWISE);
                        rotateMiddleLayer(LayerNotation.M, TurnDirection.COUNTERCLOCKWISE);
                        rotateSide(getOppositeFaceColor(rightFaceIndex), TurnDirection.COUNTERCLOCKWISE);
                        break;
                    case COUNTERCLOCKWISE:
                        rotateSide(rightFaceIndex, TurnDirection.COUNTERCLOCKWISE);
                        rotateMiddleLayer(LayerNotation.M, TurnDirection.CLOCKWISE);
                        rotateSide(getOppositeFaceColor(rightFaceIndex), TurnDirection.CLOCKWISE);
                        break;
                }
                break;
        }
    }

    public void rotateSide(LayerNotation layerNotation, TurnDirection turnDirection) {
        //System.out.println("Trying to rotate layer");
        rotateAllEdges(getFaceIndex(layerNotation), turnDirection);
        rotateAllCorners(getFaceIndex(layerNotation), turnDirection);
    }

    public void rotateSide(int faceIndex, TurnDirection turnDirection) {
        //System.out.println("Trying to rotate layer");
        rotateAllEdges(faceIndex, turnDirection);
        rotateAllCorners(faceIndex, turnDirection);
    }

    public int getFaceIndex(LayerNotation layerNotation) {
        int returnValue = -1;
        switch (layerNotation) {
            case U:
                returnValue = upFaceIndex;
                break;
            case u:
                returnValue = upFaceIndex;
                break;
            case L:
                returnValue = getOppositeFaceColor(rightFaceIndex);
                break;
            case l:
                returnValue = getOppositeFaceColor(rightFaceIndex);
                break;
            case F:
                returnValue = frontFaceIndex;
                break;
            case f:
                returnValue = frontFaceIndex;
                break;
            case R:
                returnValue = rightFaceIndex;
                break;
            case r:
                returnValue = rightFaceIndex;
                break;
            case B:
                returnValue = getOppositeFaceColor(frontFaceIndex);
                break;
            case b:
                returnValue = getOppositeFaceColor(frontFaceIndex);
                break;
            case D:
                returnValue = getOppositeFaceColor(upFaceIndex);
                break;
            case d:
                returnValue = getOppositeFaceColor(upFaceIndex);
                break;
        }
        return returnValue;
    }

    public void rotateMiddleLayer(LayerNotation layerNotation, TurnDirection turnDirection) {
        int oppositeUpFaceIndex = getOppositeFaceColor(upFaceIndex);
        int oppositeFrontFaceIndex = getOppositeFaceColor(frontFaceIndex);
        int oppositeRightFaceIndex = getOppositeFaceColor(rightFaceIndex);
        switch (layerNotation) {
            case S:
                switch (turnDirection) {
                    case CLOCKWISE:
                        //switches Centerpiece
                        switchTwoStickers(cubeFaceArray[rightFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[getOppositeFaceColor(upFaceIndex)].getSticker(4).getStickerLocation());
                        switchTwoStickers(cubeFaceArray[upFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[getOppositeFaceColor(oppositeRightFaceIndex)].getSticker(4).getStickerLocation());
                        switchTwoStickers(cubeFaceArray[oppositeRightFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[getOppositeFaceColor(oppositeUpFaceIndex)].getSticker(4).getStickerLocation());
                        //switch top edges
                        switchFourMiddleTopAndLeftEdges(turnDirection, LayerNotation.S);
                        switchFourMiddleBottomAndRightEdges(turnDirection, LayerNotation.S);
                        break;


                    case COUNTERCLOCKWISE:
                        //switches Centerpiece
                        switchTwoStickers(cubeFaceArray[upFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[rightFaceIndex].getSticker(4).getStickerLocation());
                        switchTwoStickers(cubeFaceArray[rightFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[oppositeUpFaceIndex].getSticker(4).getStickerLocation());
                        switchTwoStickers(cubeFaceArray[oppositeUpFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[oppositeRightFaceIndex].getSticker(4).getStickerLocation());
                        //switch top edges
                        switchFourMiddleTopAndLeftEdges(turnDirection, LayerNotation.S);
                        switchFourMiddleBottomAndRightEdges(turnDirection, LayerNotation.S);
                        break;
                }
                break;
            case E:
                switch (turnDirection) {
                    case CLOCKWISE:
                        //switches Centerpiece
                        switchTwoStickers(cubeFaceArray[rightFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[getOppositeFaceColor(frontFaceIndex)].getSticker(4).getStickerLocation());
                        switchTwoStickers(cubeFaceArray[frontFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[getOppositeFaceColor(oppositeRightFaceIndex)].getSticker(4).getStickerLocation());
                        switchTwoStickers(cubeFaceArray[oppositeRightFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[getOppositeFaceColor(oppositeFrontFaceIndex)].getSticker(4).getStickerLocation());
                        //switch top edges
                        switchFourMiddleTopAndLeftEdges(turnDirection, LayerNotation.E);
                        switchFourMiddleBottomAndRightEdges(turnDirection, LayerNotation.E);
                        break;


                    case COUNTERCLOCKWISE:
                        //switches Centerpiece
                        switchTwoStickers(cubeFaceArray[frontFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[rightFaceIndex].getSticker(4).getStickerLocation());
                        switchTwoStickers(cubeFaceArray[rightFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[oppositeFrontFaceIndex].getSticker(4).getStickerLocation());
                        switchTwoStickers(cubeFaceArray[oppositeFrontFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[oppositeRightFaceIndex].getSticker(4).getStickerLocation());
                        //switch top edges
                        switchFourMiddleTopAndLeftEdges(turnDirection, LayerNotation.E);
                        switchFourMiddleBottomAndRightEdges(turnDirection, LayerNotation.E);
                        break;
                }
                break;
            case M:
                switch (turnDirection) {
                    case CLOCKWISE:
                        //switches Centerpiece
                        switchTwoStickers(cubeFaceArray[frontFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[getOppositeFaceColor(upFaceIndex)].getSticker(4).getStickerLocation());
                        switchTwoStickers(cubeFaceArray[upFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[getOppositeFaceColor(oppositeFrontFaceIndex)].getSticker(4).getStickerLocation());
                        switchTwoStickers(cubeFaceArray[oppositeFrontFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[getOppositeFaceColor(oppositeUpFaceIndex)].getSticker(4).getStickerLocation());
                        //switch top edges
                        switchFourMiddleTopAndLeftEdges(turnDirection, LayerNotation.M);
                        switchFourMiddleBottomAndRightEdges(turnDirection, LayerNotation.M);
                        break;


                    case COUNTERCLOCKWISE:
                        //switches Centerpiece
                        switchTwoStickers(cubeFaceArray[oppositeFrontFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[upFaceIndex].getSticker(4).getStickerLocation());
                        switchTwoStickers(cubeFaceArray[upFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[frontFaceIndex].getSticker(4).getStickerLocation());
                        switchTwoStickers(cubeFaceArray[frontFaceIndex].getSticker(4).getStickerLocation(), cubeFaceArray[oppositeUpFaceIndex].getSticker(4).getStickerLocation());
                        //switch top edges
                        switchFourMiddleTopAndLeftEdges(turnDirection, LayerNotation.M);
                        switchFourMiddleBottomAndRightEdges(turnDirection, LayerNotation.M);
                        break;
            }
            break;
        }

    }

    private void switchFourMiddleBottomAndRightEdges (TurnDirection turnDirection, LayerNotation layerNotation) {
        int oppositeUpFaceIndex = getOppositeFaceColor(upFaceIndex);
        int oppositeFrontFaceIndex = getOppositeFaceColor(frontFaceIndex);
        int oppositeRightFaceIndex = getOppositeFaceColor(rightFaceIndex);

        StickerLocation upFaceRightEdge = cubeFaceArray[upFaceIndex].getSticker(5).getStickerLocation();
        StickerLocation rightFaceBottomEdge = cubeFaceArray[rightFaceIndex].getSticker(7).getStickerLocation();
        StickerLocation bottomFaceLeftEdge = cubeFaceArray[oppositeUpFaceIndex].getSticker(3).getStickerLocation();
        StickerLocation leftFaceTopEdge =cubeFaceArray[oppositeRightFaceIndex].getSticker(1).getStickerLocation();

        StickerLocation frontFaceRightEdge = cubeFaceArray[frontFaceIndex].getSticker(5).getStickerLocation();
        StickerLocation rightFaceRightEdge = cubeFaceArray[rightFaceIndex].getSticker(5).getStickerLocation();
        StickerLocation backFaceRightEdge = cubeFaceArray[oppositeFrontFaceIndex].getSticker(5).getStickerLocation();
        StickerLocation leftFaceRightEdge =cubeFaceArray[oppositeRightFaceIndex].getSticker(5).getStickerLocation();

        StickerLocation upFaceBottomEdge = cubeFaceArray[upFaceIndex].getSticker(7).getStickerLocation();
        StickerLocation frontFaceBottomEdge = cubeFaceArray[frontFaceIndex].getSticker(7).getStickerLocation();
        StickerLocation bottomFaceBottomEdge = cubeFaceArray[oppositeUpFaceIndex].getSticker(7).getStickerLocation();
        StickerLocation backFaceTopEdge = cubeFaceArray[oppositeFrontFaceIndex].getSticker(1).getStickerLocation();
        switch (layerNotation) {
            case M:
                switch (turnDirection) {
                    case CLOCKWISE:
                        switchTwoStickers(frontFaceBottomEdge, upFaceBottomEdge);
                        switchTwoStickers(upFaceBottomEdge, backFaceTopEdge);
                        switchTwoStickers(backFaceTopEdge, bottomFaceBottomEdge);
                        break;

                    case COUNTERCLOCKWISE:
                        switchTwoStickers(backFaceTopEdge, upFaceBottomEdge);
                        switchTwoStickers(upFaceBottomEdge, frontFaceBottomEdge);
                        switchTwoStickers(frontFaceBottomEdge, bottomFaceBottomEdge);
                        break;
                }
                break;
            case E:
                switch (turnDirection) {
                    case CLOCKWISE:
                        switchTwoStickers(rightFaceRightEdge, frontFaceRightEdge);
                        switchTwoStickers(frontFaceRightEdge, leftFaceRightEdge);
                        switchTwoStickers(leftFaceRightEdge, backFaceRightEdge);
                        break;

                    case COUNTERCLOCKWISE:
                        switchTwoStickers(frontFaceRightEdge, rightFaceRightEdge);
                        switchTwoStickers(rightFaceRightEdge, backFaceRightEdge);
                        switchTwoStickers(backFaceRightEdge, leftFaceRightEdge);
                        break;
                }
                break;
            case S:
                switch (turnDirection) {
                    case CLOCKWISE:
                        switchTwoStickers(rightFaceBottomEdge, upFaceRightEdge);
                        switchTwoStickers(upFaceRightEdge, leftFaceTopEdge);
                        switchTwoStickers(leftFaceTopEdge, bottomFaceLeftEdge);
                        break;

                    case COUNTERCLOCKWISE:
                        switchTwoStickers(upFaceRightEdge, rightFaceBottomEdge);
                        switchTwoStickers(rightFaceBottomEdge, bottomFaceLeftEdge);
                        switchTwoStickers(bottomFaceLeftEdge, leftFaceTopEdge);
                        break;
                }
                break;
        }
    }

    private void switchFourMiddleTopAndLeftEdges (TurnDirection turnDirection, LayerNotation layerNotation) {
        int oppositeUpFaceIndex = getOppositeFaceColor(upFaceIndex);
        int oppositeFrontFaceIndex = getOppositeFaceColor(frontFaceIndex);
        int oppositeRightFaceIndex = getOppositeFaceColor(rightFaceIndex);

        StickerLocation upFaceLeftEdge = cubeFaceArray[upFaceIndex].getSticker(3).getStickerLocation();
        StickerLocation rightFaceTopEdge = cubeFaceArray[rightFaceIndex].getSticker(1).getStickerLocation();
        StickerLocation bottomFaceRightEdge = cubeFaceArray[oppositeUpFaceIndex].getSticker(5).getStickerLocation();
        StickerLocation leftFaceBottomEdge = cubeFaceArray[oppositeRightFaceIndex].getSticker(7).getStickerLocation();

        StickerLocation frontFaceLeftEdge = cubeFaceArray[frontFaceIndex].getSticker(3).getStickerLocation();
        StickerLocation rightFaceLeftEdge = cubeFaceArray[rightFaceIndex].getSticker(3).getStickerLocation();
        StickerLocation backFaceLeftEdge = cubeFaceArray[oppositeFrontFaceIndex].getSticker(3).getStickerLocation();
        StickerLocation leftFaceLeftEdge = cubeFaceArray[oppositeRightFaceIndex].getSticker(3).getStickerLocation();

        StickerLocation upFaceTopEdge = cubeFaceArray[upFaceIndex].getSticker(1).getStickerLocation();
        StickerLocation frontFaceTopEdge = cubeFaceArray[frontFaceIndex].getSticker(1).getStickerLocation();
        StickerLocation bottomFaceTopEdge = cubeFaceArray[oppositeUpFaceIndex].getSticker(1).getStickerLocation();
        StickerLocation backFaceBottomEdge = cubeFaceArray[oppositeFrontFaceIndex].getSticker(7).getStickerLocation();

        switch (layerNotation) {
            case M:
                switch (turnDirection) {
                    case CLOCKWISE:
                        switchTwoStickers(frontFaceTopEdge, upFaceTopEdge);
                        switchTwoStickers(upFaceTopEdge, backFaceBottomEdge);
                        switchTwoStickers(backFaceBottomEdge, bottomFaceTopEdge);
                        break;

                    case COUNTERCLOCKWISE:
                        switchTwoStickers(upFaceTopEdge, frontFaceTopEdge);
                        switchTwoStickers(frontFaceTopEdge, bottomFaceTopEdge);
                        switchTwoStickers(bottomFaceTopEdge, backFaceBottomEdge);
                        break;
                }
                break;
            case E:
                switch (turnDirection) {
                    case CLOCKWISE:
                        switchTwoStickers(rightFaceLeftEdge, frontFaceLeftEdge);
                        switchTwoStickers(frontFaceLeftEdge, leftFaceLeftEdge);
                        switchTwoStickers(leftFaceLeftEdge, backFaceLeftEdge);
                        break;

                    case COUNTERCLOCKWISE:
                        switchTwoStickers(frontFaceLeftEdge, rightFaceLeftEdge);
                        switchTwoStickers(rightFaceLeftEdge, backFaceLeftEdge);
                        switchTwoStickers(backFaceLeftEdge, leftFaceLeftEdge);
                        break;
                }
                break;
            case S:
                switch (turnDirection) {
                    case CLOCKWISE:
                        switchTwoStickers(rightFaceTopEdge, upFaceLeftEdge);
                        switchTwoStickers(upFaceLeftEdge, leftFaceBottomEdge);
                        switchTwoStickers(leftFaceBottomEdge, bottomFaceRightEdge);
                        break;

                    case COUNTERCLOCKWISE:
                        switchTwoStickers(upFaceLeftEdge, rightFaceTopEdge);
                        switchTwoStickers(rightFaceTopEdge, bottomFaceRightEdge);
                        switchTwoStickers(bottomFaceRightEdge, leftFaceBottomEdge);
                        break;
                }
                break;

        }
    }

    private int getOppositeFaceColor(int faceIndex) {
        int returnOppositeFaceIndex = 0;
        switch (faceIndex) {
            case 0:
                returnOppositeFaceIndex = 5;
                break;
            case 1:
                returnOppositeFaceIndex = 3;
                break;
            case 2:
                returnOppositeFaceIndex = 4;
                break;
            case 3:
                returnOppositeFaceIndex = 1;
                break;
            case 4:
                returnOppositeFaceIndex = 2;
                break;
            case 5:
                break;
        }
        return returnOppositeFaceIndex;
    }

    private void rotateAllCorners(int faceIndex, TurnDirection turnDirection) {

        StickerLocation cornerSticker0 = cubeFaceArray[faceIndex].getSticker(0).getStickerLocation();
        StickerLocation cornerSticker2 = cubeFaceArray[faceIndex].getSticker(2).getStickerLocation();
        StickerLocation cornerSticker6 = cubeFaceArray[faceIndex].getSticker(6).getStickerLocation();
        StickerLocation cornerSticker8 = cubeFaceArray[faceIndex].getSticker(8).getStickerLocation();

        switch (turnDirection) {
            case COUNTERCLOCKWISE:
                //System.out.println("try turn corners counter-clockwise");
                switchTwoCornersOnFace(cornerSticker0, cornerSticker6);
                switchTwoCornersOnFace(cornerSticker0, cornerSticker8);
                switchTwoCornersOnFace(cornerSticker0, cornerSticker2);
                break;

            case CLOCKWISE:
                //System.out.println("try turn corners clockwise");
                switchTwoCornersOnFace(cornerSticker0, cornerSticker2);
                switchTwoCornersOnFace(cornerSticker0, cornerSticker8);
                switchTwoCornersOnFace(cornerSticker0, cornerSticker6);
                break;
        }
    }

    private List<StickerLocation> fourCornersLocationLeft(CubeFace cubeFace) {
        List<StickerLocation> cornersStickerLocationsLeft = new ArrayList<>();
        for (int i = 0; i < 9; i = i + 2) {
            if (i == 4) {
                continue;
            }
            cornersStickerLocationsLeft.add(getLeftCornerStickerIndex(cubeFace.getSticker(i).getStickerLocation()));
        }
        return cornersStickerLocationsLeft;
    }

    private List<StickerLocation> fourCornersLocationRight(CubeFace cubeFace) {
        List<StickerLocation> cornersStickerLocationsRight = new ArrayList<>();
        for (int i = 0; i < 9; i = i + 2) {
            if (i == 4) {
                continue;
            }
            cornersStickerLocationsRight.add(getRightCornerStickerIndex(cubeFace.getSticker(i).getStickerLocation()));
        }
        return cornersStickerLocationsRight;
    }

    private StickerLocation getLeftCornerStickerIndex(StickerLocation stickerLocation) {
        int topFace = stickerLocation.getFaceIndex();
        int stickerIndex = stickerLocation.getStickerIndex();
        switch (topFace) {
            case 0:
                switch (stickerIndex) {
                    case 0:
                        return getStickerLocation(4, 2);
                    case 2:
                        return getStickerLocation(3, 2);
                    case 6:
                        return getStickerLocation(1, 2);
                    case 8:
                        return getStickerLocation(2, 2);
                }
            case 1:
                switch (stickerIndex) {
                    case 0:
                        return getStickerLocation(0, 0);
                    case 2:
                        return getStickerLocation(2, 0);
                    case 6:
                        return getStickerLocation(4, 8);
                    case 8:
                        return getStickerLocation(5, 0);
                }
            case 2:
                switch (stickerIndex) {
                    case 0:
                        return getStickerLocation(0, 6);
                    case 2:
                        return getStickerLocation(3, 0);
                    case 6:
                        return getStickerLocation(1, 8);
                    case 8:
                        return getStickerLocation(5, 2);
                }
            case 3:
                switch (stickerIndex) {
                    case 0:
                        return getStickerLocation(0, 8);
                    case 2:
                        return getStickerLocation(4, 0);
                    case 6:
                        return getStickerLocation(2, 8);
                    case 8:
                        return getStickerLocation(5, 8);
                }
            case 4:
                switch (stickerIndex) {
                    case 0:
                        return getStickerLocation(0, 2);
                    case 2:
                        return getStickerLocation(1, 0);
                    case 6:
                        return getStickerLocation(3, 8);
                    case 8:
                        return getStickerLocation(5, 6);
                }
            case 5:
                switch (stickerIndex) {
                    case 0:
                        return getStickerLocation(2, 6);
                    case 2:
                        return getStickerLocation(3, 6);
                    case 6:
                        return getStickerLocation(1, 6);
                    case 8:
                        return getStickerLocation(4, 6);
                }
        }
        return null;
    }

    private StickerLocation getRightCornerStickerIndex(StickerLocation stickerLocation) {
        int topFace = stickerLocation.getFaceIndex();
        int stickerIndex = stickerLocation.getStickerIndex();
        switch (topFace) {
            case 0:
                switch (stickerIndex) {
                    case 0:
                        return getStickerLocation(1, 0);
                    case 2:
                        return getStickerLocation(4, 0);
                    case 6:
                        return getStickerLocation(2, 0);
                    case 8:
                        return getStickerLocation(3, 0);
                }
            case 1:
                switch (stickerIndex) {
                    case 0:
                        return getStickerLocation(4, 2);
                    case 2:
                        return getStickerLocation(0, 6);
                    case 6:
                        return getStickerLocation(5, 6);
                    case 8:
                        return getStickerLocation(2, 6);
                }
            case 2:
                switch (stickerIndex) {
                    case 0:
                        return getStickerLocation(1, 2);
                    case 2:
                        return getStickerLocation(0, 8);
                    case 6:
                        return getStickerLocation(5, 0);
                    case 8:
                        return getStickerLocation(3, 6);
                }
            case 3:
                switch (stickerIndex) {
                    case 0:
                        return getStickerLocation(2, 2);
                    case 2:
                        return getStickerLocation(0, 2);
                    case 6:
                        return getStickerLocation(5, 2);
                    case 8:
                        return getStickerLocation(4, 6);
                }
            case 4:
                switch (stickerIndex) {
                    case 0:
                        return getStickerLocation(3, 2);
                    case 2:
                        return getStickerLocation(0, 0);
                    case 6:
                        return getStickerLocation(5, 8);
                    case 8:
                        return getStickerLocation(1, 6);
                }
            case 5:
                switch (stickerIndex) {
                    case 0:
                        return getStickerLocation(1, 8);
                    case 2:
                        return getStickerLocation(2, 8);
                    case 6:
                        return getStickerLocation(4, 8);
                    case 8:
                        return getStickerLocation(3, 8);
                }
        }
        return null;
    }

    private void rotateAllEdges(int faceIndex, TurnDirection turnDirection) {
        StickerLocation edgeSticker1 = cubeFaceArray[faceIndex].getSticker(1).getStickerLocation();
        StickerLocation edgeSticker3 = cubeFaceArray[faceIndex].getSticker(3).getStickerLocation();
        StickerLocation edgeSticker5 = cubeFaceArray[faceIndex].getSticker(5).getStickerLocation();
        StickerLocation edgeSticker7 = cubeFaceArray[faceIndex].getSticker(7).getStickerLocation();
        //cycles sticker 1 all the way around to rotate them all clockwise
        switch (turnDirection) {
            case COUNTERCLOCKWISE:
                switchTwoEdgesOnFace(edgeSticker1, edgeSticker3);
                switchTwoEdgesOnFace(edgeSticker1, edgeSticker7);
                switchTwoEdgesOnFace(edgeSticker1, edgeSticker5);
                break;
            case CLOCKWISE:
                switchTwoEdgesOnFace(edgeSticker1, edgeSticker5);
                switchTwoEdgesOnFace(edgeSticker1, edgeSticker7);
                switchTwoEdgesOnFace(edgeSticker1, edgeSticker3);
                break;
        }
    }

    private void switchTwoEdgesOnFace(StickerLocation stickerLocation1, StickerLocation stickerLocation2) {
        //gets other sticker location
        StickerLocation otherStickerLocation1 = getOtherEdgeStickerIndex(stickerLocation1);
        StickerLocation otherStickerLocation2 = getOtherEdgeStickerIndex(stickerLocation2);
        //switches both sets of stickers
        switchTwoStickers(stickerLocation1, stickerLocation2);
        switchTwoStickers(otherStickerLocation1, otherStickerLocation2);
    }

    private void switchTwoStickers(StickerLocation stickerLocation1, StickerLocation stickerLocation2) {
        int faceIndex1 = stickerLocation1.getFaceIndex();
        int faceIndex2 = stickerLocation2.getFaceIndex();
        int stickerIndex1 = stickerLocation1.getStickerIndex();
        int stickerIndex2 = stickerLocation2.getStickerIndex();

        Sticker sticker1 = cubeFaceArray[faceIndex1].getSticker(stickerIndex1);
        Sticker sticker2 = cubeFaceArray[faceIndex2].getSticker(stickerIndex2);

        cubeFaceArray[faceIndex1].setSticker(sticker2, stickerIndex1);
        cubeFaceArray[faceIndex2].setSticker(sticker1, stickerIndex2);
        //sticker locations change when stickers are changed places
        StickerLocation tempStickerLocation1 = sticker1.getStickerLocation();
        sticker1.setStickerLocation(sticker2.getStickerLocation());
        sticker2.setStickerLocation(tempStickerLocation1);
    }

    private void switchTwoCornersOnFace(StickerLocation stickerLocation1, StickerLocation stickerLocation2) {
        //System.out.println("Tried to switch two corners on face");
        StickerLocation otherStickerLocationR1 = getRightCornerStickerIndex(stickerLocation1);
        StickerLocation otherStickerLocationR2 = getRightCornerStickerIndex(stickerLocation2);
        StickerLocation otherStickerLocationL1 = getLeftCornerStickerIndex(stickerLocation1);
        StickerLocation otherStickerLocationL2 = getLeftCornerStickerIndex(stickerLocation2);
        switchTwoStickers(stickerLocation1, stickerLocation2);
        switchTwoStickers(otherStickerLocationL1, otherStickerLocationL2);
        switchTwoStickers(otherStickerLocationR1, otherStickerLocationR2);
    }

    private StickerLocation getOtherEdgeStickerIndex(StickerLocation stickerLocation) {
        // 0th index is face index in cubeFaceArray
        // 1st index is sticker index on said face
        int faceIndex = stickerLocation.getFaceIndex();
        int stickerIndex = stickerLocation.getStickerIndex();
        switch (faceIndex) {
            case 0:
                switch (stickerIndex) {
                    case 1:
                        return getStickerLocation(4, 1);
                    case 3:
                        return getStickerLocation(1, 1);
                    case 5:
                        return getStickerLocation(3, 1);
                    case 7:
                        return getStickerLocation(2, 1);
                }

            case 1:
                switch (stickerIndex) {
                    case 1:
                        return getStickerLocation(0, 3);
                    case 3:
                        return getStickerLocation(4, 5);
                    case 5:
                        return getStickerLocation(2, 3);
                    case 7:
                        return getStickerLocation(5, 3);
                }

            case 2:
                switch (stickerIndex) {
                    case 1:
                        return getStickerLocation(0, 7);
                    case 3:
                        return getStickerLocation(1, 5);
                    case 5:
                        return getStickerLocation(3, 3);
                    case 7:
                        return getStickerLocation(5, 1);
                }

            case 3:
                switch (stickerIndex) {
                    case 1:
                        return getStickerLocation(0, 5);
                    case 3:
                        return getStickerLocation(2, 5);
                    case 5:
                        return getStickerLocation(4, 3);
                    case 7:
                        return getStickerLocation(5, 5);
                }

            case 4:
                switch (stickerIndex) {
                    case 1:
                        return getStickerLocation(0, 1);
                    case 3:
                        return getStickerLocation(3, 5);
                    case 5:
                        return getStickerLocation(1, 3);
                    case 7:
                        return getStickerLocation(5, 7);
                }

            case 5:
                switch (stickerIndex) {
                    case 1:
                        return getStickerLocation(2, 7);
                    case 3:
                        return getStickerLocation(1, 7);
                    case 5:
                        return getStickerLocation(3, 7);
                    case 7:
                        return getStickerLocation(4, 7);
                }

        }
        return null;
    }

    private StickerLocation getStickerLocation(int faceIndex, int stickerIndex) {
        return cubeFaceArray[faceIndex].getSticker(stickerIndex).getStickerLocation();
    }

    private StickerLocation[] getOtherCornersStickersIndex(StickerLocation stickerLocation) {
        //first index is for placing which sticker since there are 2
        //second index is for the sticker
        int faceIndex = stickerLocation.getFaceIndex();
        int stickerIndex = stickerLocation.getStickerIndex();
        StickerLocation[] stickerLocations = new StickerLocation[2];
        switch (faceIndex) {
            case 0:
                switch (stickerIndex) {
                    case 0:
                        //first other sticker
                        stickerLocations[0] = getStickerLocation(1, 0);
                        //second other sticker
                        stickerLocations[0] = getStickerLocation(4, 2);
                        return stickerLocations;
                    case 2:
                        //first other sticker
                        stickerLocations[0] = getStickerLocation(3, 2);
                        //second other sticker
                        stickerLocations[0] = getStickerLocation(4, 0);
                        return stickerLocations;
                    case 6:
                        stickerLocations[0] = getStickerLocation(1, 2);
                        stickerLocations[0] = getStickerLocation(3, 0);
                        return stickerLocations;
                    case 8:
                        stickerLocations[0] = getStickerLocation(2, 2);
                        stickerLocations[0] = getStickerLocation(3, 0);
                        return stickerLocations;
                }
            case 1:
                switch (stickerIndex) {
                    case 0:
                        stickerLocations[0] = getStickerLocation(0, 0);
                        stickerLocations[0] = getStickerLocation(4, 2);
                        return stickerLocations;
                    case 2:
                        stickerLocations[0] = getStickerLocation(0, 6);
                        stickerLocations[0] = getStickerLocation(2, 0);
                        return stickerLocations;
                    case 6:
                        stickerLocations[0] = getStickerLocation(4, 8);
                        stickerLocations[0] = getStickerLocation(5, 6);
                        return stickerLocations;
                    case 8:
                        stickerLocations[0] = getStickerLocation(3, 6);
                        stickerLocations[0] = getStickerLocation(5, 0);
                        return stickerLocations;
                }
            case 2:
                switch (stickerIndex) {
                    case 0:
                        stickerLocations[0] = getStickerLocation(0, 6);
                        stickerLocations[0] = getStickerLocation(1, 2);
                        return stickerLocations;
                    case 2:
                        stickerLocations[0] = getStickerLocation(0, 8);
                        stickerLocations[0] = getStickerLocation(3, 0);
                        return stickerLocations;
                    case 6:
                        stickerLocations[0] = getStickerLocation(1, 8);
                        stickerLocations[0] = getStickerLocation(5, 0);
                        return stickerLocations;
                    case 8:
                        stickerLocations[0] = getStickerLocation(4, 6);
                        stickerLocations[0] = getStickerLocation(5, 2);
                        return stickerLocations;
                }
            case 3:
                switch (stickerIndex) {
                    case 0:
                        stickerLocations[0] = getStickerLocation(0, 8);
                        stickerLocations[0] = getStickerLocation(2, 2);
                        return stickerLocations;
                    case 2:
                        stickerLocations[0] = getStickerLocation(0, 2);
                        stickerLocations[0] = getStickerLocation(4, 0);
                        return stickerLocations;
                    case 6:
                        stickerLocations[0] = getStickerLocation(2, 8);
                        stickerLocations[0] = getStickerLocation(5, 2);
                        return stickerLocations;
                    case 8:
                        stickerLocations[0] = getStickerLocation(4, 6);
                        stickerLocations[0] = getStickerLocation(5, 8);
                        return stickerLocations;
                }
            case 4:
                switch (stickerIndex) {
                    case 0:
                        stickerLocations[0] = getStickerLocation(0, 2);
                        stickerLocations[0] = getStickerLocation(4, 2);
                        return stickerLocations;
                    case 2:
                        stickerLocations[0] = getStickerLocation(0, 0);
                        stickerLocations[0] = getStickerLocation(1, 0);
                        return stickerLocations;
                    case 6:
                        stickerLocations[0] = getStickerLocation(3, 8);
                        stickerLocations[0] = getStickerLocation(5, 8);
                        return stickerLocations;
                    case 8:
                        stickerLocations[0] = getStickerLocation(1, 6);
                        stickerLocations[0] = getStickerLocation(5, 6);
                        return stickerLocations;
                }
            case 5:
                switch (stickerIndex) {
                    case 0:
                        stickerLocations[0] = getStickerLocation(1, 8);
                        stickerLocations[0] = getStickerLocation(2, 6);
                        return stickerLocations;
                    case 2:
                        stickerLocations[0] = getStickerLocation(2, 8);
                        stickerLocations[0] = getStickerLocation(3, 6);
                        return stickerLocations;
                    case 6:
                        stickerLocations[0] = getStickerLocation(1, 6);
                        stickerLocations[0] = getStickerLocation(4, 8);
                        return stickerLocations;
                    case 8:
                        stickerLocations[0] = getStickerLocation(3, 8);
                        stickerLocations[0] = getStickerLocation(4, 6);
                        return stickerLocations;
                }
        }
        return null;

    }
}
