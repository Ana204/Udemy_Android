package com.example.aprendaingles.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendaingles.R;

public class BichosFragment extends Fragment implements View.OnClickListener{

    ImageButton imageUm, imgDois, imageTres, imgQuatro, imageCinco, imgSeis;
    MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bichos, container, false);

        imageUm = view.findViewById(R.id.imageUm);
        imgDois = view.findViewById(R.id.imgDois);
        imageTres = view.findViewById(R.id.imageTres);
        imgQuatro = view.findViewById(R.id.imgQuatro);
        imageCinco = view.findViewById(R.id.imageCinco);
        imgSeis = view.findViewById(R.id.imgSeis);

        //setando o evento de onclick, passando apenas this para que a class seja responsavel por criar o evento de click
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

        switch ( view.getId() ){
            case R.id.imageUm :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                Som();
                break;

            case R.id.imgDois:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                Som();
                break;

            case R.id.imageTres:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                Som();
                break;

            case R.id.imgQuatro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                Som();
                break;

            case R.id.imageCinco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                Som();
                break;

            case R.id.imgSeis:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                Som();
                break;
        }
    }

    public void Som(){
        if (mediaPlayer != null ){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}