package app.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.recyclerview.R;
import app.recyclerview.model.Filme;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        listaFilmes = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titulo.setText("Titulo de teste");
        holder.ano.setText("2021");
        holder.genero.setText("Comedia");
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo, ano, genero;

        public MyViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }
}
