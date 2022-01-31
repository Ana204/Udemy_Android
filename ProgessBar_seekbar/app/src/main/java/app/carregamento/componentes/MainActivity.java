package app.carregamento.componentes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    AppCompatButton buttonCarregar;
    ProgressBar progressBarCircular, progressBarHorizontal;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCarregar = findViewById(R.id.buttonCarregar);
        progressBarCircular = findViewById(R.id.progressBarCircular);
        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);

        progressBarCircular.setVisibility(View.GONE);

        buttonCarregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress = progress + 1;
                progressBarHorizontal.setProgress(progress);
                progressBarCircular.setVisibility(View.VISIBLE);

                if (progress == 10){
                    progressBarCircular.setVisibility(View.GONE);
                }
            }
        });
    }
}