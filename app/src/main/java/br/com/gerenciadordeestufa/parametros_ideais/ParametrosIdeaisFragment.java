package br.com.gerenciadordeestufa.parametros_ideais;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import br.com.gerenciadordeestufa.R;
import br.com.gerenciadordeestufa.ViewConfigurator;

public class ParametrosIdeaisFragment extends Fragment {

    private ParametrosIdeaisViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_parametros_ideais, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ParametrosIdeaisViewModel.class);
        viewModel.getEvento().observe(getViewLifecycleOwner(), evento -> {
            if (evento == null) return;
            switch (evento){
                case IR_PARA_EDITAR_PARAMETROS_IDEAIS:
                    NavHostFragment
                            .findNavController(this)
                            .navigate(R.id.action_parametrosIdeaisFragment_to_editParametrosIdeaisFragment);
                    break;
            }
        viewModel.limparEvento();
        });
        ViewConfigurator.configurar(view, v -> {
            v.findViewById(R.id.btn_edit_parameters)
                    .setOnClickListener(l -> {
                       viewModel.onEditarParametros();
                    });
        });
    }
}
