package app.carregamento.componentes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AppCompatButton buttonCarregar,buttonRecuperar;
    ProgressBar progressBarCircular, progressBarHorizontal;
    SeekBar seekbarEscala;
    TextView resultado;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCarregar = findViewById(R.id.buttonCarregar);
        progressBarCircular = findViewById(R.id.progressBarCircular);
        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        buttonRecuperar = findViewById(R.id.buttonRecuperar);
        seekbarEscala = findViewById(R.id.seekbarEscala);
        resultado = findViewById(R.id.resultado);

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

        seekbarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            resultado.setText("RESULTADO: " + progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        buttonRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("ESCOLHIDO " + seekbarEscala.getProgress());
            }
        });
    }


}