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
}
