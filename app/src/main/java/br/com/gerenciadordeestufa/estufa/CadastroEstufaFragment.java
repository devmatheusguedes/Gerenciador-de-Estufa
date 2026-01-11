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

public class CadastroEstufaFragment extends Fragment {

    private CadastrarEstufaViewModel cadastrarEstufaViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_estufa, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cadastrarEstufaViewModel = new ViewModelProvider(this).get(CadastrarEstufaViewModel.class);

        cadastrarEstufaViewModel.getEvento().observe(getViewLifecycleOwner(), evento -> {
            if (evento == null) return;
            switch (evento){
                case ACAO_CADASTRAR_ESTUFA:
                    System.out.print("Botão sem ação");
            }

            cadastrarEstufaViewModel.limparEvento();
        });
        ViewConfigurator.configurar(view,
                v -> {
                    v.findViewById(R.id.btnCadastrarEstufa)
                            .setOnClickListener(l -> {
                                cadastrarEstufaViewModel.onCadastrarEstufa();
                            });
                });
    }


}
