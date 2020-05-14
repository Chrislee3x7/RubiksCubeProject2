public class Sticker {

    private StickerColor color;
    private StickerLocation stickerLocation;

    public Sticker(StickerColor color, int faceIndex, int stickerIndex) {
        this.color = color;
        this.stickerLocation = new StickerLocation(faceIndex, stickerIndex);
    }

    public StickerColor getColor() {
        return color;
    }

    public StickerLocation getStickerLocation() {
        return stickerLocation;
    }

    public void setStickerLocation(StickerLocation newLocation) {
        stickerLocation = newLocation;
    }

}
