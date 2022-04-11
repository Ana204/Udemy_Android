package br.com.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textEditName;
    AppCompatButton buttonEnviar;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEditName = findViewById(R.id.textEditName);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        textResult = findViewById(R.id.textResult);
    }
}