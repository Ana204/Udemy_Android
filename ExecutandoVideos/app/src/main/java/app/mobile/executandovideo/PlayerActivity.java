package app.mobile.executandovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        //Executar o vídeo
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.start();
    }
}