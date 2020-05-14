public class CubeFace {

    Sticker[] stickers;
    StickerColor faceColor;


    public CubeFace(StickerColor faceColor, int faceIndex) {

        stickers = new Sticker[9];
        for (int i = 0; i < 9; i++) {
            stickers[i] = new Sticker(faceColor, faceIndex, i);
        }
        this.faceColor = faceColor;


    }

    public Sticker getSticker(int stickerIndex)
    {
        return stickers[stickerIndex];
    }

    public Sticker[] getAllStickers() {
        return stickers;
    }

    public void setSticker(Sticker sticker, int stickerIndex) {
        stickers[stickerIndex] = sticker;
    }
}
