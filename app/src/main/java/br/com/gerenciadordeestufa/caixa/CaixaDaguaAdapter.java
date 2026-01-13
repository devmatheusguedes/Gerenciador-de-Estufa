package br.com.gerenciadordeestufa.caixa;

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

public class CaixaDaguaAdapter
        extends RecyclerView.Adapter<CaixaDaguaAdapter.ViewHolder> {

    private List<CaixaDaguaEnity> lista = new ArrayList<>();

    public void submitList(List<CaixaDaguaEnity> novaLista) {
        lista = novaLista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_caixa_dagua, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position
    ) {
        CaixaDaguaEnity caixa = lista.get(position);
        holder.nome.setText(caixa.getNome());
        holder.volume.setText("Volume: " + caixa.getVolume());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome, volume;

        ViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.tvNome);
            volume = itemView.findViewById(R.id.tvVolume);
        }
    }
}

