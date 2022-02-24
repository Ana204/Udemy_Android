package app.mobile.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar seekbarVolume;
    AppCompatButton buttonPlay, buttonPause, buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbarVolume = findViewById(R.id.seekbarVolume);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPause = findViewById(R.id.buttonPause);
        buttonStop = findViewById(R.id.buttonStop);

    }
}