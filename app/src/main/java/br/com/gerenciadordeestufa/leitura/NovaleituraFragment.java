package br.com.gerenciadordeestufa.leitura;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import br.com.gerenciadordeestufa.R;
import br.com.gerenciadordeestufa.ViewConfigurator;

public class NovaleituraFragment extends Fragment {

    private NovaLeituraViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nova_leitura, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(NovaLeituraViewModel.class);

        viewModel.getEvento().observe(getViewLifecycleOwner(), evento -> {
            if (evento == null) return;
            switch (evento){
                case ACAO_SALVAR_LEITURA:
                    System.out.print("salvando");
                    break;
            }
            viewModel.limparEvento();
        });

        ViewConfigurator.configurar(view, v -> {
            v.findViewById(R.id.btn_salvar_leitura).setOnClickListener(l -> {
                viewModel.onSalvar();
            });
        });
    }
}
