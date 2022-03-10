package app.mobile.smarttablelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import app.mobile.smarttablelayout.Fragments.EmAltaFragment;
import app.mobile.smarttablelayout.Fragments.HomeFragment;
import app.mobile.smarttablelayout.Fragments.InscricoesFragment;

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

        //Configurar adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Home", HomeFragment.class)
                        .add("Inscrições", InscricoesFragment.class)
                        .add("Em Alta", EmAltaFragment.class)
                .create()
        );

        ViewPager.setAdapter(adapter);
        ViewPagerTab.setViewPager(ViewPager);
    }
}