package br.com.anotacoes;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import br.com.anotacoes.databinding.ActivityMainBinding;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private PreferencesAnnotation preferencesAnnotation;
    EditText editTextTextMultiLine;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesAnnotation = new PreferencesAnnotation(getApplicationContext());
        editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        fab = findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String edittext = editTextTextMultiLine.getText().toString();
                if (edittext.equals("")){
                    Snackbar.make(view, "Anote alguma coisa", Snackbar.LENGTH_LONG).show();
                }else {
                    preferencesAnnotation.salvarAnnotation(edittext);
                    Snackbar.make(view, "Anotação salva com sucesso !!", Snackbar.LENGTH_LONG).show();
                }


            }
        });
       String annotation =  preferencesAnnotation.getAnnotation();
       if (!annotation.equals("")){
           editTextTextMultiLine.setText(annotation);
       }
    }


}