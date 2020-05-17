import java.awt.*;

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

    public Color getDisplayColor() {
        switch (color) {
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

}
