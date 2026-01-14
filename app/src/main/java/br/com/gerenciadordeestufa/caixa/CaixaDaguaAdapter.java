package br.com.gerenciadordeestufa.caixa;

import android.graphics.Color;
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

    // 🔹 Interface de clique
    public interface OnItemClickListener {
        void onItemClick(CaixaDaguaEnity caixa);
    }

    private List<CaixaDaguaEnity> lista = new ArrayList<>();
    private OnItemClickListener listener;
    private int selectPosition = RecyclerView.NO_POSITION;

    // 🔹 Permite que o Fragment injete o listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

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
        holder.bind(caixa, listener);

        if (position == selectPosition){
            holder.itemView.setBackgroundColor(Color.rgb(34, 69, 70));
        }
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

        void bind(
                CaixaDaguaEnity caixa,
                OnItemClickListener listener
        ) {
            nome.setText(caixa.getNome());
            volume.setText("Volume: " + caixa.getVolume());

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(caixa);
                }
            });
        }
    }
}
