package com.example.aprendaingles.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendaingles.R;

public class VogaisFragment extends Fragment {

    ImageButton imageUm, imgDois, imageTres, imgQuatro, imageCinco;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vogais, container, false);

        imageUm = view.findViewById(R.id.imageUm);
        imgDois = view.findViewById(R.id.imgDois);
        imageTres = view.findViewById(R.id.imageTres);
        imgQuatro = view.findViewById(R.id.imgQuatro);
        imageCinco = view.findViewById(R.id.imageCinco);

        return view;
    }
}