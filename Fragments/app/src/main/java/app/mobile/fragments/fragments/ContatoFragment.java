package app.mobile.fragments.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.mobile.fragments.R;


public class ContatoFragment extends Fragment {

    TextView txtContato;

    public ContatoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contato, container, false);

        txtContato = view.findViewById(R.id.txtContato);
        txtContato.setText(R.string.contato);

        return view;
    }
}