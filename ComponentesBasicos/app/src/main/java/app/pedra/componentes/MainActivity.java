package app.pedra.componentes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;
    TextInputEditText edtEmail;
    Button ButtonEnviar;
    TextView edtResultado;
    AppCompatCheckBox verde,azul,vermelho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        ButtonEnviar = findViewById(R.id.ButtonEnviar);
        edtResultado = findViewById(R.id.edtResultado);
        verde = findViewById(R.id.verde);
        azul = findViewById(R.id.azul);
        vermelho = findViewById(R.id.vermelho);


        ButtonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

/*                String nome = edtNome.getText().toString();
                String email = edtEmail.getText().toString();

                edtResultado.setText("Nome: "+ nome + "Email: " + email);*/
            }
        });
    }

    public void checkbox(){

    }
}