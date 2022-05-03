package br.com.lista_tarefas.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import br.com.lista_tarefas.R;
import br.com.lista_tarefas.helper.TarefaDAO;
import br.com.lista_tarefas.model.Tarefa;

public class add_tarefas extends AppCompatActivity {

    private TextInputEditText textTarefa;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tarefas);

        textTarefa = findViewById(R.id.textTarefa);

        editTarefa();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.salvar :
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                if (tarefaAtual != null){
                    String nomeTarefa = textTarefa.getText().toString();
                    if (!nomeTarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);
                        tarefa.setId(tarefaAtual.getId());

                        //atualizar
                        if (tarefaDAO.atualizar(tarefa)){
                            finish();
                            Toast.makeText(this, "Sucesso ao atualizar tarefa !", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    String nomeTarefa = textTarefa.getText().toString();
                    if (!nomeTarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);

                        if (tarefaDAO.salvar(tarefa)){
                            finish();
                            Toast.makeText(this, "Sucesso ao salvar tarefa !", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void editTarefa(){

        tarefaAtual = (Tarefa)getIntent().getSerializableExtra("tarefaSelecionada");

        if (tarefaAtual != null){
            textTarefa.setText(tarefaAtual.getNomeTarefa());
        }
    }
}