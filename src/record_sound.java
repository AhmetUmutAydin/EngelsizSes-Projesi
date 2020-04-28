import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class record_sound {

	AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;

	TargetDataLine line;

	AudioFormat getAudioFormat() {

		float sampleRate = 44100;

		int sampleSizeInBits = 16;

		int channels = 1;

		boolean signed = true;

		boolean bigEndian = true;

		AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,

				channels, signed, bigEndian);

		return format;
	}

	void start(String pcs) {
		File wavFile = new File("C://Users//" + pcs + "//Desktop//sesler//java_ses//Kayitsesi.wav");
		try {

			AudioFormat format = getAudioFormat();

			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

			// checks if system supports the data line

			if (!AudioSystem.isLineSupported(info)) {

				System.out.println("Line not supported");

				System.exit(0);

			}

			line = (TargetDataLine) AudioSystem.getLine(info);

			line.open(format);

			line.start(); // start capturing

			System.out.println("Start capturing...");

			AudioInputStream ais = new AudioInputStream(line);

			System.out.println("Start recording...");

			// start recording

			AudioSystem.write(ais, fileType, wavFile);

		} catch (LineUnavailableException ex) {

			ex.printStackTrace();

		} catch (IOException ioe) {

			ioe.printStackTrace();

		}

	}

	void finish() {

		line.stop();

		line.close();

		System.out.println("Finished");

	}

}