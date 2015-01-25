package Classes;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import AudioPlayer.AudioPlayer;

public class asdas {

	public static void main(String[] args){
		
		AudioPlayer ap = new AudioPlayer();
		String filePath = "C:/Ring05.wav";
		//System.out.println(filePath);
		
		
		
		// Load Audio File
		try {
			ap.load(filePath);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Play Audio File
		try {
			ap.play();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Stop Audio File
		
		ap.stop();
		
	}
}
