public class CornerPiece implements Piece {

    private Sticker color1;
    private Sticker color2;
    private Sticker color3;

    public CornerPiece(Sticker color1, Sticker color2, Sticker color3) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
    }

    public void display() {

    }
//    public Sticker[] getColor() {
//        Sticker[] cornerPieceColor = new Sticker[3];
//        cornerPieceColor[0] = color1;
//        cornerPieceColor[1] = color2;
//        cornerPieceColor[2] = color3;
//        return cornerPieceColor;
//    }
}
