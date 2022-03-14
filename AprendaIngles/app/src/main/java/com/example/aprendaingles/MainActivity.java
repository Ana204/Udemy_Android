package com.example.aprendaingles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.aprendaingles.Fragments.BichosFragment;
import com.example.aprendaingles.Fragments.NumerosFragment;
import com.example.aprendaingles.Fragments.VogaisFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    SmartTabLayout ViewPagerTab;
    ViewPager ViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        ViewPagerTab = findViewById(R.id.ViewPagerTab);
        ViewPager = findViewById(R.id.ViewPager);

        //Configurar Adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Bichos", BichosFragment.class)
                        .add("Números", NumerosFragment.class)
                        .add("Vogais", VogaisFragment.class)
                .create()
        );

        ViewPager.setAdapter(adapter);
        ViewPagerTab.setViewPager(ViewPager);
    }
}