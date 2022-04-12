package br.com.anotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesAnnotation {

    private Context context;
    private SharedPreferences preferences;
    private final String FILE_NAME = "anotacion.pref";

    public PreferencesAnnotation(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(FILE_NAME, 0);
    }

    public void salvarAnnotation(){

    }

    public String getAnnotation(){

        return "";
    }
}
