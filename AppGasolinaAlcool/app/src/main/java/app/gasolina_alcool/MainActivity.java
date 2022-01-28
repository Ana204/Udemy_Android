package app.gasolina_alcool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editAlcool,editGasolina;
    AppCompatButton btnCalcular;
    AppCompatTextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool = findViewById(R.id.editAlcool);
        editGasolina = findViewById(R.id.editGasolina);
        btnCalcular = findViewById(R.id.btnCalcular);
        resultado = findViewById(R.id.resultado);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String precoAlcool = editAlcool.getText().toString();
                String precoGasolina = editGasolina.getText().toString();

                //validar os campos
               Boolean camposValidados =  validarCampos(precoAlcool, precoGasolina);

               if (camposValidados){

                   Double valorAlcool = Double.parseDouble(precoAlcool);
                   Double valorGasolina = Double.parseDouble(precoGasolina);

                   if (valorAlcool / valorGasolina >= 0.7){
                       resultado.setText("Melhor usar Gasolina");
                   }else {
                       resultado.setText("Melhor usar álcool");
                   }

               }else {

               }
            }
        });
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        if (pAlcool.isEmpty() || pGasolina.isEmpty()){
           resultado.setText("Preencha os campos com os preços!");
        }

        return camposValidados;
    }
}