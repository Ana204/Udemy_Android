package app.dodia.pensamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtFrase;
    Button buttonGerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFrase = findViewById(R.id.txtFrase);
        buttonGerar = findViewById(R.id.buttonGerar);

        buttonGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] frases =
                        {
                                "A função da liderança é produzir mais líderes, não seguidores!\n" + "\n" + " - Ralph Nader",
                                "Eu não quero chegar ao fim da minha vida e descobrir que eu vivi apenas o comprimento dela. Eu quero ter vivido a largura também\n" + "\n" + " - Diane Ackerman",
                                "A vida não é sobre encontrar a si mesmo. A vida é sobre criar você mesmo.\n" + "\n" + " - Lolly Daskal",
                                "Nada no mundo é mais comum que pessoas mal-sucedidas com talento.\n" + "\n" + " - Anonymous",
                                "Todo o segredo de uma vida bem-sucedida é descobrir qual é o destino de cada um e, então, fazer.\n" + "\n" + " - Henry Ford",
                                "A verdadeira esperança é uma qualidade, uma determinação heróica da alma. E a mais elevada forma de esperança é o desespero superado.\n" + "\n" + " - Georges Bernanos",
                                "O que nos parece como julgamentos amargos são muitas vezes bênçãos disfarçadas\n" + "\n" + " - Oscar Wilde"
                        };

                Random random = new Random();

                int numeroAleatorios = random.nextInt(frases.length);
                txtFrase.setText(frases[numeroAleatorios]);
            }
        });
    }
}