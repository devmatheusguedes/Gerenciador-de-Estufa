package br.com.gerenciadordeestufa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class ParametrosIdeaisFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_parametros_ideais, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewConfigurator.configurar(view, v -> {
            v.findViewById(R.id.btn_edit_parameters)
                    .setOnClickListener(l -> {
                        NavHostFragment.findNavController(this)
                                .navigate(R.id.action_parametrosIdeaisFragment_to_editParametrosIdeaisFragment);
                    });
        });
    }
}
