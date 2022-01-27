package app.pedra.componentes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;
    TextInputEditText edtEmail;
    Button ButtonEnviar;
    TextView edtResultado;
    AppCompatCheckBox verde,azul,vermelho;
    RadioButton RadioButtonFeminino, RadioButtonMasculino;
    RadioGroup RadioGroupSexo;

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
        RadioButtonFeminino = findViewById(R.id.RadioButtonFeminino);
        RadioButtonMasculino = findViewById(R.id.RadioButtonMasculino);
        RadioGroupSexo = findViewById(R.id.RadioGroupSexo);

        RadioGrup();

        ButtonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //RadioButton();
                //checkbox();

/*                String nome = edtNome.getText().toString();
                String email = edtEmail.getText().toString();

                edtResultado.setText("Nome: "+ nome + "Email: " + email);*/
            }
        });
    }

    //ouvindo por mudança, se ouve alteração nas opções
    public void RadioGrup(){
        RadioGroupSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                if (checkedId == R.id.RadioButtonFeminino){
                    edtResultado.setText("FEMININO");
                }else if (checkedId == R.id.RadioButtonMasculino){
                    edtResultado.setText("MASCULINO");
                }
            }
        });
    }

    public void RadioButton(){

        String texto = "";
        if (RadioButtonMasculino.isChecked()){
            String opcaoSelecionada = RadioButtonMasculino.getText().toString();
            texto = opcaoSelecionada;
        }
        if (RadioButtonFeminino.isChecked()){
            String opcaoSelecionada = RadioButtonFeminino.getText().toString();
            texto = opcaoSelecionada;
        }
        edtResultado.setText(texto);
    }

    public void checkbox(){

        boolean ckeckAzul = azul.isChecked();
        boolean ckeckVermelho = vermelho.isChecked();

        String texto = "";
        if ( verde.isChecked()){
            String corSelecionada = verde.getText().toString();
            texto = corSelecionada;
            //texto = "VERDE SELECIONADO - ";
        }
        if (ckeckAzul){
            texto = texto + "AZUL SELECIONADO - ";
        }
        if (ckeckVermelho){
            texto = texto + "VERMELHO SELECIONADO - ";
        }

        edtResultado.setText(texto);

    }
}