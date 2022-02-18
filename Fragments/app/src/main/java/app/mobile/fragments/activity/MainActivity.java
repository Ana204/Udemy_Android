package app.mobile.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import app.mobile.fragments.R;
import app.mobile.fragments.fragments.ContatoFragment;
import app.mobile.fragments.fragments.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    AppCompatButton buttonConversas, buttonContato;
    ConversasFragment conversasFragment;
    ContatoFragment contatoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //remover a sobra do actionBar
        getSupportActionBar().setElevation(0);

        buttonConversas = findViewById(R.id.buttonConversas);
        buttonContato = findViewById(R.id.buttonContato);


        conversasFragment = new ConversasFragment();

        //Configurar obj para fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FrameLayout, conversasFragment);
        transaction.commit();

        buttonConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                conversasFragment = new ConversasFragment();

                //Configurar obj para fragmento
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.FrameLayout, conversasFragment);
                transaction.commit();
            }
        });

        buttonContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contatoFragment = new ContatoFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.FrameLayout, contatoFragment);
                transaction.commit();
            }
        });
    }
}