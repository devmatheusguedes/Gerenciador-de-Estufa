package br.com.gerenciadordeestufa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class CaixaDaguaFragment extends Fragment implements FragmentConfigView<View>{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_caixasdagua, container, false);    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configurarCliques(view);
    }

    @Override
    public void configurarCliques(View view) {
        view.findViewById(R.id.btnCadastrarCaixa).setOnClickListener(v -> {
            navegar(R.id.action_caixaDaguaFragment_to_cadastrarCaixaDaguaFragment);
        });
    }

    @Override
    public void navegar(int actionId) {
        NavHostFragment.findNavController(this).navigate(actionId);

    }
}
