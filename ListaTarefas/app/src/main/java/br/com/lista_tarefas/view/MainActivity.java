package br.com.lista_tarefas.view;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.material.divider.MaterialDividerItemDecoration;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.lista_tarefas.R;
import br.com.lista_tarefas.adapter.Adapter;
import br.com.lista_tarefas.helper.RecyclerItemClickListener;
import br.com.lista_tarefas.model.Tarefa;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView recyclerViewTarefas;
    private Adapter adapter;
    private List<Tarefa> listaTarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        recyclerViewTarefas = findViewById(R.id.recyclerViewTarefas);

        recyclerViewTarefas.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerViewTarefas,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Log.i("CLICK", "onItemClick: ");
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Log.i("CLICK", "onLongItemClick: ");
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        })
        );

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), add_tarefas.class);
                startActivity(intent);

            }
        });
    }

    public void loadList(){

        //list tarefas
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setNomeTarefa("Ir ao shopping ");
        listaTarefas.add(tarefa1);

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setNomeTarefa("Ir a feira");
        listaTarefas.add(tarefa2);

        //config
        adapter = new Adapter(listaTarefas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewTarefas.setLayoutManager(layoutManager);
        recyclerViewTarefas.setHasFixedSize(true);
        recyclerViewTarefas.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerViewTarefas.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        loadList();
        super.onStart();
    }
}