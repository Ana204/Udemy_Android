package app.mobile.navigationdrawer.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.mobile.navigationdrawer.R;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


public class SobreFragment extends Fragment {


    public SobreFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       // return inflater.inflate(R.layout.fragment_sobre, container, false);

        String descricao = "A ATM Consultoria tem como missão apoiar organização " +
                "que desejam alcançar o sucesso atráves da exelência em gestão e " +
                "da busca pela qualidade";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato conosco")
                .addEmail("atentimento@atmconsultoria.com.br", "Envie um e-mail")
                .addWebsite("https://www.google.com/", "Acesse nosso site")

                .addGroup("Redes sociais")
                .addFacebook("AnaGomes", "Facebook")
                .addInstagram("AnaGomes", "Instagram")
                .addTwitter("AnaGomes", "Twitter")
                .addYoutube("AnaGomes", "Youtube")
                .addGitHub("Ana204", "GitHub")
                .addPlayStore("com.facebook.katana", "Download App")

                .addItem(versao)
                .create();
    }
}