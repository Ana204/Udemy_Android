package app.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText valorConta;
    TextView porcentagem, valorDaGorjeta, valorTotal;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorConta = findViewById(R.id.valorConta);
        porcentagem = findViewById(R.id.porcentagem);
        valorDaGorjeta = findViewById(R.id.valorDaGorjeta);
        valorTotal = findViewById(R.id.valorTotal);
        seekBar = findViewById(R.id.seekBar);
    }
}