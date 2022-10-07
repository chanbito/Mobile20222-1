package br.edu.uniritter.mobile.mobile20222_1.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.mobile20222_1.R;
import br.edu.uniritter.mobile.mobile20222_1.model.Post;
import br.edu.uniritter.mobile.mobile20222_1.view.UserActivity;


public class PostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final static String TAG = "PostsAdapter";
    private List<Post> dados;

    public PostsAdapter(List<Post> dados) {
        this.dados = dados;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View l = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_post_vh,
                parent,false);
        return new PostsViewHolder(l);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post obj = dados.get(position);
        TextView title = holder.itemView.findViewById(R.id.textViewtitle);
        title.setText(obj.getTitle());
        TextView body = holder.itemView.findViewById(R.id.bodyEditTextTextMultiLine);
        body.setText(obj.getBody());
        Button b = holder.itemView.findViewById(R.id.button);
        b.setOnClickListener((view -> {
            Log.d(TAG, "onClick: Alguém clicou no botao de comentario");

        }));
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

}
class PostsViewHolder extends RecyclerView.ViewHolder {
    public View view;
    public PostsViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }
}
