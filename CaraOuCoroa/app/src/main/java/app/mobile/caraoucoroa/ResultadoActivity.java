package app.mobile.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {

    AppCompatButton buttonVoltar;
    ImageView imgResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        getSupportActionBar().hide();

        imgResultado = findViewById(R.id.imgResultado);
        buttonVoltar = findViewById(R.id.buttonVoltar);

        //Recuperar dados
        Bundle dados = getIntent().getExtras();
        int numero = dados.getInt("numero");

        if (numero == 0){
            imgResultado.setImageResource(R.drawable.moeda_cara);
        } else {
            imgResultado.setImageResource(R.drawable.moeda_coroa);
        }

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}