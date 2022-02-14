package app.view.cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.recyclerview.widget.RecyclerView;

import app.view.cardview.R;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyViewHolder> {


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.postagem_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nome.setText("ANA LUCIA GOMES");
        holder.textPostagem.setText("#tbt VIAGEM INCRIIIVEL !!");
        holder.imgPostagem.setImageResource(R.drawable.paisagem2);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome, textPostagem;
        ImageView imgPostagem;

        public MyViewHolder(View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.nome);
            textPostagem = itemView.findViewById(R.id.textPostagem);
            imgPostagem = itemView.findViewById(R.id.imgPostagem);
        }
    }
}
