package br.com.gerenciadordeestufa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        configurarCliques(view);
    }

    private void configurarCliques(View view) {
        view.findViewById(R.id.card_estufas_id).setOnClickListener(v -> navegar(R.id.action_homeFragment_to_estufasFragment2));
        view.findViewById(R.id.card_caixas_dagua_id).setOnClickListener(v -> navegar(R.id.action_homeFragment_to_caixaDaguaFragment));
        view.findViewById(R.id.btn_new_reading).setOnClickListener(v -> navegar(R.id.action_homeFragment_to_novaleituraFragment));
        view.findViewById(R.id.card_alertas_id).setOnClickListener(v -> navegar(R.id.action_homeFragment_to_alertaFragment));
    }

    private void navegar(int actionId) {
        NavHostFragment.findNavController(this).navigate(actionId);
    }
}
