package br.com.gerenciadordeestufa.parametros_ideais;

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

public class EditParametrosIdeaisFragment extends Fragment{
    private EditParametrosViewModel viewModel;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_parametros_ideais, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(EditParametrosViewModel.class);

        viewModel.getEvento().observe(getViewLifecycleOwner(), evento -> {
            if (evento == null) return;
            switch (evento){
                case ACAO_SALVAR:
                    System.out.print("Salvando");
                    break;
                case ACAO_CANCELAR:
                    viewModel.onCancelar();
                    break;
            }
            viewModel.onCancelar();
        });

        ViewConfigurator.configurar(view, v -> {
            v.findViewById(R.id.btn_save_params).setOnClickListener( l -> {
                viewModel.onSalvar();
            });
            v.findViewById(R.id.btn_cancel_params).setOnClickListener(l -> {
                viewModel.onCancelar();
            });
        });
    }
}
