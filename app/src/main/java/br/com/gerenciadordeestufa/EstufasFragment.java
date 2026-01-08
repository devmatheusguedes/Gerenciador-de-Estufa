package br.com.gerenciadordeestufa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class EstufasFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estufa, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configurarCliques(view);
    }

    private void configurarCliques(View view) {
        view.findViewById(R.id.btn_add_greenhouse).setOnClickListener(v -> navegar(R.id.action_estufasFragment2_to_cadastroEstufaFragment));
    }

    private void navegar(int actionId) {
        NavHostFragment.findNavController(this).navigate(actionId);
    }
}
