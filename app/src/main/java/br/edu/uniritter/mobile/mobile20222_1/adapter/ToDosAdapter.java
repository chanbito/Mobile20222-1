package br.edu.uniritter.mobile.mobile20222_1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.mobile20222_1.R;
import br.edu.uniritter.mobile.mobile20222_1.model.ToDo;


public class ToDosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private List<ToDo> dados;

    public ToDosAdapter(List<ToDo> dados) {
        this.dados = dados;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutVH = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_todos_vh,
                parent,false);
        return new ToDoViewHolder(layoutVH);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ToDo obj = dados.get(position);
        TextView tv1 = holder.itemView.findViewById(R.id.textViewtitle);
        tv1.setText(obj.getTitle()+"");
        ((CheckBox) holder.itemView.findViewById(R.id.checkBox)).setChecked(obj.getCompleted());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }


}
class ToDoViewHolder extends RecyclerView.ViewHolder {
    public View view;
    public ToDoViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }
}
