package app.mobile.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import app.mobile.fragments.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //remover a sobra do actionBar
        getSupportActionBar().setElevation(0);
    }
}