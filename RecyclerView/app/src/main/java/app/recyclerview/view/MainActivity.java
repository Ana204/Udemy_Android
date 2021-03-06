package app.recyclerview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.recyclerview.R;
import app.recyclerview.RecyclerItemClickListener;
import app.recyclerview.adapter.Adapter;
import app.recyclerview.model.Filme;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        Adapter adapter = new Adapter( listaFilmes );

        //lista de filmes
        criarFilmes();

        //configurar recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);

                        Toast.makeText(MainActivity.this, "item selecionado: " + filme.getTituloFilme(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);

                        Toast.makeText(MainActivity.this, "item selecionado: " + filme.getTituloFilme(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));
    }

    public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2021");
        listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Liga da Justi??a", "Fic????o", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Capit??o Am??rica", "Aventura/Fic????o", "2016");
        listaFilmes.add(filme);

        filme = new Filme("A M??mia", "Terror", "2017");
        listaFilmes.add(filme);

        filme = new Filme("A bela ea Fera", "Romance", "2016");
        listaFilmes.add(filme);

    }
}