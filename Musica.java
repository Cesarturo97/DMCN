package omicron_15;
import java.io.File;
import javax.sound.sampled.*;
public class Musica extends Thread{
	File sound;
		//title;
	public Musica(){
		this.sound=new File("deviltrigger.wav").getAbsoluteFile();
	}
	public void run(){
			Battle(this.sound);
			System.out.println("musica iniciada");
	}
	public void Battle(File musica) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musica);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			while(!clip.isRunning()){
				Thread.sleep(10);
			}
			while(clip.isRunning()){
				Thread.sleep(10);
			}
			clip.close();
		}catch(Exception ex) {
			System.out.println("Error al reproducir el audio.");
			ex.printStackTrace();
		}
	}
}
