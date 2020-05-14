public class EdgePiece implements Piece {

    private Sticker color1;
    private Sticker color2;

    public EdgePiece(Sticker color1, Sticker color2) {
        this.color1 = color1;
        this.color2 = color2;
    }

    public void display() {

    }
//    public Sticker[] getColor() {
//        Sticker[] edgePieceColors = new Sticker[2];
//        edgePieceColors[0] = color1;
//        edgePieceColors[1] = color2;
//        return edgePieceColors;
//    }
}
