package app.pedra.papeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgPedra, imgPapel, imgtesoura, imgPadrao;
    TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPedra = findViewById(R.id.imgPedra);
        imgPapel = findViewById(R.id.imgPapel);
        imgtesoura = findViewById(R.id.imgtesoura);
        imgPadrao = findViewById(R.id.imgPadrao);
        txtInfo = findViewById(R.id.txtInfo);

        SelecionadoPedra();
        SelecionadoPapel();
        SelecionadoTesoura();
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        String[] opcoes = {"PEDRA", "PAPEL", "TESOURA"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        System.out.println("ESCOLHA DO USUARIO " + escolhaUsuario);
        System.out.println("ESCOLHA DO APP " +escolhaApp);


        switch ( escolhaApp ){
            case "PEDRA" :
                imgPadrao.setImageResource(R.drawable.pedra);
                break;
            case "PAPEL":
                imgPadrao.setImageResource(R.drawable.papel);
                break;
            case "TESOURA" :
                imgPadrao.setImageResource(R.drawable.tesoura);
                break;
        }


        if (
                (escolhaApp.equals("PEDRA") && escolhaUsuario.equals("TESOURA")) ||
                (escolhaApp.equals("PAPEL") && escolhaUsuario.equals("PEDRA")) ||
                (escolhaApp.equals("TESOURA") && escolhaUsuario.equals("PAPEL"))
        ){//App ganhador
            txtInfo.setText("Você perdeu :( ");
            txtInfo.setTextColor(Color.RED);
        }else if (
                (escolhaUsuario.equals("PEDRA") && escolhaApp.equals("TESOURA")) ||
                (escolhaUsuario.equals("PAPEL") && escolhaApp.equals("PEDRA")) ||
                (escolhaUsuario=="TESOURA" && escolhaApp=="PAPEL")
        ){//Usuario ganhador
            txtInfo.setText("Você ganhou :) ");
            txtInfo.setTextColor(Color.GREEN);
        }else {//Empate
            txtInfo.setText("Empatamos ;) ");
            txtInfo.setTextColor(Color.BLACK);
        }

    }

    public void SelecionadoPedra() {
        imgPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opcaoSelecionada("PEDRA");
            }
        });
    }

    public void SelecionadoPapel() {
        imgPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opcaoSelecionada("PAPEL");
            }
        });
    }

    public void SelecionadoTesoura() {
        imgtesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opcaoSelecionada("TESOURA");
            }
        });
    }
}