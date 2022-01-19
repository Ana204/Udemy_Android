package app.pedra.papeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgPedra, imgPapel, imgtesoura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPedra = findViewById(R.id.imgPedra);
        imgPapel = findViewById(R.id.imgPapel);
        imgtesoura = findViewById(R.id.imgtesoura);

        SelecionadoPedra();
        SelecionadoPapel();
        SelecionadoTesoura();
    }

    public void opcaoSelecionada(String opcaoSelecionada){
        System.out.println(opcaoSelecionada);
    }

    public void SelecionadoPedra(){
        imgPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opcaoSelecionada("CLICOU NA PEDRA");
            }
        });
    }

    public void SelecionadoPapel(){
        imgPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opcaoSelecionada("CLICOU NO PAPEL");
            }
        });
    }

    public void SelecionadoTesoura(){
        imgtesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opcaoSelecionada("CLICOU NA TESOURA");
            }
        });
    }
}