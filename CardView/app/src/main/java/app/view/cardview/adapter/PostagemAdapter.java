package app.view.cardview.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyViewHolder> {


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome, textPostagem;
        ImageView imgPostagem;

        public MyViewHolder(View itemView) {
            super(itemView);

/*            nome = itemView.findViewById(R.id.nome);
            textPostagem = itemView.findViewById(R.id.textPostagem);
            imgPostagem = itemView.findViewById(R.id.imgPostagem);*/
        }
    }
}
