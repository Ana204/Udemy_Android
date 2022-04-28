package br.com.lista_tarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import br.com.lista_tarefas.model.Tarefa;

public class TarefaDAO implements InterfaceTarefaDAO{

    private SQLiteDatabase write;
    private SQLiteDatabase read;

    public TarefaDAO(Context context){
        DbHelper db = new DbHelper(context);

        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", tarefa.getNomeTarefa());

        try{
            write.insert(DbHelper.TABELA_NAME, null, contentValues);
            Log.i("INFO", "TAREFA SALVA COM SUCESSO !!");
        }catch (Exception e){
            Log.e("INFO", "ERROR AO SALVAR TAREFA: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
        return null;
    }
}
