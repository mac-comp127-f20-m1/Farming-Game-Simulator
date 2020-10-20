
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio{

    Clip clip
    public Audio(){
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(MyClazz.class.getResource("music.wav"));
        clip = AudioSystem.getClip();
        clip.open(audioIn);
    }
   


public void PlayMusic(){
   clip.start();
}

