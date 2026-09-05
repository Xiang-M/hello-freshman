package com.example.util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {
    public static void playSound() {
        try {
            // 从webapp/sounds目录加载音效文件
            String soundPath = "sounds/display-sound.mp3";
            File soundFile = new File(soundPath);

            if (soundFile.exists()) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("无法播放音效: " + e.getMessage());
        }
    }
}