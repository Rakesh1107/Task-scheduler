package base;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Alarm implements Runnable {

	@Override
	public synchronized void run() {
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File("test.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
			System.out.println("Alarm ringing");
			while (clip.isRunning()) {
		
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		} 
	}
	
}
