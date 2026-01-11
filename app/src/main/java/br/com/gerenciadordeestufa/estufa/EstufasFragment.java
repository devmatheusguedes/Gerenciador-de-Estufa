package br.com.gerenciadordeestufa.estufa;

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

public class EstufasFragment extends Fragment {

    private EstufaViewModel estufaViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estufa, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        estufaViewModel = new ViewModelProvider(this).get(EstufaViewModel.class);

        estufaViewModel.getEvento().observe(
                getViewLifecycleOwner(), evento -> {
                    if (evento == null) return;
                    switch (evento){
                        case IR_PARA_CADASTRAR_ESTUFAS:
                            NavHostFragment.findNavController(this)
                                    .navigate(R.id.action_estufasFragment2_to_cadastroEstufaFragment);
                            break;

                    }
                    estufaViewModel.limparEvento();
                }
        );

        ViewConfigurator.configurar(view,
                v ->{
            v.findViewById(R.id.btn_add_greenhouse)
                    .setOnClickListener(l -> {
                        estufaViewModel.onCadastrarEstufas();
                    });
                });
    }


}
