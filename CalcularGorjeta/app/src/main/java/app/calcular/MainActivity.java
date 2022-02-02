package app.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText valorConta;
    TextView porcentagem, valorDaGorjeta, valorTotal;
    SeekBar seekBar;

    double valorporcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorConta = findViewById(R.id.valorConta);
        porcentagem = findViewById(R.id.porcentagem);
        valorDaGorjeta = findViewById(R.id.valorDaGorjeta);
        valorTotal = findViewById(R.id.valorTotal);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                valorporcentagem = progress;
                porcentagem.setText(Math.round(valorporcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){

        String valorDaConta = valorConta.getText().toString();

    if (valorDaConta == null || valorDaConta.equals("") || valorDaConta.equals(".")){
            Toast.makeText(MainActivity.this, "Digite o valor da sua conta", Toast.LENGTH_LONG).show();
    }else {
        double valorconta = Double.parseDouble(valorDaConta);

        double gorjeta = valorconta * (valorporcentagem/100);
        valorDaGorjeta.setText("R$ " + Math.round(gorjeta));

        double valorTotalDaConta = valorconta + gorjeta;
        valorTotal.setText("R$ " + valorTotalDaConta);

    }

    }
}