package br.com.gerenciadordeestufa.caixa;

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

public class CaixaDaguaFragment extends Fragment {

    private CaixaDaguaViewModel caixaDaguaViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_caixasdagua, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1️⃣ Inicializa o ViewModel
        caixaDaguaViewModel =
                new ViewModelProvider(this).get(CaixaDaguaViewModel.class);

        // 2️⃣ Observa os eventos do ViewModel
        caixaDaguaViewModel.getEvento().observe(
                getViewLifecycleOwner(),
                evento -> {
                    if (evento == null) return;

                    switch (evento) {
                        case IR_PARA_CADASTRO_CAIXA:
                            NavHostFragment
                                    .findNavController(this)
                                    .navigate(
                                            R.id.action_caixaDaguaFragment_to_cadastrarCaixaDaguaFragment
                                    );
                            break;

                        case IR_PARA_HISTORICO:
                            NavHostFragment
                                    .findNavController(this)
                                    .navigate(
                                            R.id.action_caixaDaguaFragment_to_historicoDeLeituraFragment
                                    );
                            break;

                    }

                    caixaDaguaViewModel.limparEvento();
                }
        );

        // 3️⃣ Liga os botões ao ViewModel
        ViewConfigurator.configurar(view, v -> {

            v.findViewById(R.id.btnCadastrarCaixa)
                    .setOnClickListener(l ->
                            caixaDaguaViewModel.onCadastrarCaixaClicado()
                    );

            v.findViewById(R.id.btnVerHistorico)
                    .setOnClickListener(l ->
                            caixaDaguaViewModel.onVerHistoricoClicado()
                    );
        });
    }
}
