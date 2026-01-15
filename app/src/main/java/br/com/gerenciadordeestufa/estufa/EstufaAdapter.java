package br.com.gerenciadordeestufa.estufa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.gerenciadordeestufa.R;
import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;
import br.com.gerenciadordeestufa.data.entity.EstufaEntity;

public class EstufaAdapter extends
        RecyclerView.Adapter<EstufaAdapter.ViewHolder> {
    public interface OnItemClickListner{
        void onItemClick(EstufaEntity entity);
    }

    private List<EstufaEntity> lista = new ArrayList<>();
    private OnItemClickListner listner;
    public void selectOnItemListner(OnItemClickListner listner){
        this.listner = listner;
    }

    public void submitList(List<EstufaEntity> novaLista){
        lista = novaLista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_esufa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EstufaEntity estufaEntity = lista.get(position);
        holder.bind(estufaEntity, listner);

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        ViewHolder(View itemView){
            super(itemView);
            nome = itemView.findViewById(R.id.estufaTvNome);
        }

        void bind(EstufaEntity enity, OnItemClickListner listner){
            nome.setText(enity.getNome());

            itemView.setOnClickListener(v->{
                if (listner != null){
                    listner.onItemClick(enity);
                }
            });
        }

    }
}
