package br.com.lista_tarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NAME = "db_tarefas";
    public static String TABELA_NAME = "tarefas";

    public DbHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_NAME
                    + " (id INTEGER PRIMARY KEY AUTOINCREMENT,  " +
                    " nome TEXT NOT NULL ) ";

        try{
            sqLiteDatabase.execSQL(sql);
            Log.i("INFO_DB", "Sucesso ao criar a tabela ");
        }catch (Exception e){
            Log.i("INFO_DB", "Error ao criar tabela" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABELA_NAME + " ;";

        try{
            sqLiteDatabase.execSQL( sql );
            onCreate(sqLiteDatabase);
            Log.i("INFO_DB", "Sucesso ao atualizar app");
        }catch (Exception e){
            Log.i("INFO_DB", "Error ao atualizar tabela" + e.getMessage());
        }
    }
}
