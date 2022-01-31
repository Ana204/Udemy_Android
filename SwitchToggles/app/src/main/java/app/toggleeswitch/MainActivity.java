 package app.toggleeswitch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

 public class MainActivity extends AppCompatActivity {

    SwitchCompat  SwitchLembrarSenha;
    ToggleButton ToggleButton;
    AppCompatButton btnEnviar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwitchLembrarSenha = findViewById(R.id.SwitchLembrarSenha);
        ToggleButton = findViewById(R.id.ToggleButton);
        btnEnviar = findViewById(R.id.btnEnviar);
        txtResultado = findViewById(R.id.txtResultado);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }
}