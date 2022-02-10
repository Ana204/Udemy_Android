package app.view.cardview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import app.view.cardview.R;
import app.view.cardview.adapter.AdapterPostagem;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewPostagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPostagem = findViewById(R.id.recyclerViewPostagem);

        //definir layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewPostagem.setLayoutManager(layoutManager);

        //definir adapter
        AdapterPostagem adapter = new AdapterPostagem();
        recyclerViewPostagem.setAdapter( adapter);

    }
}