package br.com.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textEditName;
    AppCompatButton buttonEnviar;
    TextView textResult;

    SharedPreferences preferences;
    private final String FILE_PREFERENCE = "FilePreference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEditName = findViewById(R.id.textEditName);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        textResult = findViewById(R.id.textResult);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences = getSharedPreferences(FILE_PREFERENCE, 0);
                SharedPreferences.Editor edit = preferences.edit();



                if (textEditName.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Preencha o campo", Toast.LENGTH_SHORT).show();
                }
                else {
                    String nome = textEditName.getText().toString();
                    edit.putString("nome", nome);
                    edit.commit();

                    textResult.setText("Olá, " + nome);
                }
            }
        });

        preferences = getSharedPreferences(FILE_PREFERENCE, 0);
        if(preferences.contains("nome")){
            String nome = preferences.getString("nome", "ERROR");
            textResult.setText("Olá, " + nome);
        }
    }
}