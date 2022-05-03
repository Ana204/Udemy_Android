package br.com.lista_tarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.lista_tarefas.model.Tarefa;

public class TarefaDAO implements InterfaceTarefaDAO{

    private SQLiteDatabase write;
    private SQLiteDatabase read;
    ContentValues contentValues;

    public TarefaDAO(Context context){
        DbHelper db = new DbHelper(context);

        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        contentValues = new ContentValues();
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

        contentValues = new ContentValues();
        contentValues.put("nome", tarefa.getNomeTarefa());
        int id = tarefa.getId();

        try{
            String[] args = {Integer.toString(id)};
            write.update(DbHelper.TABELA_NAME, contentValues, "id=?", args);
            Log.i("INFO", "TAREFA ATUALIZADA COM SUCESSO !!");

        }catch (Exception e){
            Log.e("INFO", "ERROR AO ATUALIZAR TAREFA: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_NAME;

        try{
            Cursor cursor = read.rawQuery(sql, null);

            while ( cursor.moveToNext() ){

                Tarefa tarefa = new Tarefa();

                int id = cursor.getInt( cursor.getColumnIndex("id") );
                String nomeTarefa = cursor.getString( cursor.getColumnIndex("nome") );

                tarefa.setId(id);
                tarefa.setNomeTarefa( nomeTarefa );

                tarefas.add( tarefa );
                Log.i("ERROR", tarefa.getNomeTarefa() );
            }

        }catch (SQLException e){
            Log.e("ERROR", "Falha ao lisar: " + e.getMessage());
        }


        return tarefas;
    }
}
