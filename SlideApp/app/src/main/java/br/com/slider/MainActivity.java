package br.com.slider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //Standard slide (SimpleSlide)
       /*

        addSlide(new SimpleSlide.Builder()
                .title("Titulo")
                .description("Descricao")
                .image(R.drawable.um)
                .background(android.R.color.holo_orange_light)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Titulo2")
                .description("Descricao2")
                .image(R.drawable.dois)
                .background(android.R.color.holo_orange_light)
                .build());*/

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_green_light)
                .fragment(R.layout.intro_one)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_green_light)
                .fragment(R.layout.intro_two)
                .build()
        );

    }
}