package app.mobile.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar seekbarVolume;
    AppCompatButton buttonPlay, buttonPause, buttonStop;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbarVolume = findViewById(R.id.seekbarVolume);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPause = findViewById(R.id.buttonPause);
        buttonStop = findViewById(R.id.buttonStop);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.musica);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null){
                    mediaPlayer.start();
                }
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.musica);
                }
            }
        });

    }

}