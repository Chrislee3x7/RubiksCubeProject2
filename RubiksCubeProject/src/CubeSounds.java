import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class CubeSounds {


    public static void playRotateCubeSound1() {
        String tinyButtonPush = "RubiksCubeProject/TinyButtonPushSound.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void playRotateCubeSound2() {
        String tinyButtonPush = "RubiksCubeProject/ComputerErrorSound.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void playRotateCubeSound3() {
        String tinyButtonPush = "RubiksCubeProject/DryFireGun.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void playRotateCubeSound4() {
        String tinyButtonPush = "RubiksCubeProject/Whoosh.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void playRotateCubeSound5() {
        String tinyButtonPush = "RubiksCubeProject/Pling.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void playClickOn() {
        String tinyButtonPush = "RubiksCubeProject/ClickOn.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void playClickOff() {
        String tinyButtonPush = "RubiksCubeProject/ClickOff.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void playWoosh2() {
        String tinyButtonPush = "RubiksCubeProject/Woosh2.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void playWoosh3() {
        String tinyButtonPush = "RubiksCubeProject/Woosh3.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void play8BitPowerUp1() {
        String tinyButtonPush = "RubiksCubeProject/8BitPowerUp1.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void play8BitPowerUp2() {
        String tinyButtonPush = "RubiksCubeProject/8BitPowerUp2.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void playUmbrellaOpening() {
        String tinyButtonPush = "RubiksCubeProject/UmbrellaOpening.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void playHighTechWhoosh() {
        String tinyButtonPush = "RubiksCubeProject/HighTechWhoosh.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public static void playHighSweepSlide() {
        String tinyButtonPush = "RubiksCubeProject/HiSweepSlide.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(tinyButtonPush);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }
}
