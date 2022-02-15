package app.view.cardview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import app.view.cardview.R;
import app.view.cardview.adapter.PostagemAdapter;
import app.view.cardview.model.Postagem;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewPostagem;
    List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPostagem = findViewById(R.id.recyclerViewPostagem);

        //definir layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewPostagem.setLayoutManager(layoutManager);

        //definir adapter
        prepararPostagem();
        PostagemAdapter adapter = new PostagemAdapter(postagens);
        recyclerViewPostagem.setAdapter( adapter);

    }

    public void prepararPostagem(){
        Postagem p = new Postagem("Ana Gomes", "#VIAGEM_INCRIVEL " , R.drawable.paissagem2);
        this.postagens.add(p);

        p = new Postagem("Marcos Viana", "FLORESTA !!" , R.drawable.floresta);
        this.postagens.add(p);

        p = new Postagem("Luciana", "#AMOOOO# !!" , R.drawable.paissagem);
        this.postagens.add(p);

        p = new Postagem("Viana", "INCRIVEL !!" , R.drawable.vangogh);
        this.postagens.add(p);
    }
}