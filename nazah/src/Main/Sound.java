package Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];


    public Sound()
    {
        soundURL[0] = getClass().getResource("/happy-14585.wav");
        soundURL[1] = getClass().getResource("/correct-6033.wav");
        soundURL[2] = getClass().getResource("/8-bit-powerup-6768.wav");
        soundURL[3] = getClass().getResource("/creeper-36141.wav");
//        soundURL[4] = getClass().getResource("/happy-14585.wav");
    }
    public void setFile(int i)
    {
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void play()
    {
        clip.start();

    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
//        clip.stop();
    }

}
