public class StickerLocation {

    private int faceIndex;
    private int stickerIndex;

    public StickerLocation (int faceIndex, int stickerIndex) {
        this.faceIndex = faceIndex;
        this.stickerIndex = stickerIndex;
    }

    public int getFaceIndex (){
        return faceIndex;
    }

    public int getStickerIndex (){
        return stickerIndex;
    }
    public void setLocation (StickerLocation stickerLocation) {
        faceIndex = stickerLocation.getFaceIndex();
        stickerIndex = stickerLocation.getStickerIndex();
    }
}
