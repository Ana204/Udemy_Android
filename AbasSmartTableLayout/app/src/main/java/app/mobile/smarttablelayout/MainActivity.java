package app.mobile.smarttablelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class MainActivity extends AppCompatActivity {

    SmartTabLayout ViewPagerTab;
    ViewPager ViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPagerTab = findViewById(R.id.ViewPagerTab);
        ViewPager = findViewById(R.id.ViewPager);
    }
}