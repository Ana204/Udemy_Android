package com.example.aprendaingles.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;

import com.example.aprendaingles.R;


public class NumerosFragment extends Fragment implements View.OnClickListener{

    ImageButton imageUm, imgDois, imageTres, imgQuatro, imageCinco, imgSeis;
    MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        imageUm = view.findViewById(R.id.imageUm);
        imgDois = view.findViewById(R.id.imgDois);
        imageTres = view.findViewById(R.id.imageTres);
        imgQuatro = view.findViewById(R.id.imgQuatro);
        imageCinco = view.findViewById(R.id.imageCinco);
        imgSeis = view.findViewById(R.id.imgSeis);

        imageUm.setOnClickListener(this);
        imgDois.setOnClickListener(this);
        imageTres.setOnClickListener(this);
        imgQuatro.setOnClickListener(this);
        imageCinco.setOnClickListener(this);
        imgSeis.setOnClickListener(this);

       return view;
    }

    @Override
    public void onClick(View view) {

        switch( view.getId() ){
            case R.id.imageUm:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                som();
                break;
            case R.id.imgDois:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                som();
                break;
            case R.id.imageTres:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                som();
                break;
            case R.id.imgQuatro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                som();
                break;
            case R.id.imageCinco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                som();
                break;
            case R.id.imgSeis:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                som();
                break;
        }
    }

    public void som(){

        if (mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
}