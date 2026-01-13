package br.com.gerenciadordeestufa.cadastrocaixa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;

import br.com.gerenciadordeestufa.R;
import br.com.gerenciadordeestufa.data.database.AppDatabase;
import br.com.gerenciadordeestufa.data.repository.CaixaDaguaRepository;

public class CadastrarCaixaDaguaFragment extends Fragment {

    private CadastrarCaixaDaguaViewModelNavigation navViewModel;
    private CadastroCaixaViewModelPersistence dataViewModel;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_cadastro_caixa_dagua, container, false);
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);

        // 🔹 Repository
        CaixaDaguaRepository repository =
                new CaixaDaguaRepository(
                        AppDatabase.getDatabase(requireContext()).caixaDaguaDao()
                );

        // 🔹 Factory
        CadastroCaixaViewModelFactory factory =
                new CadastroCaixaViewModelFactory(repository);

        // 🔹 ViewModels
        navViewModel =
                new ViewModelProvider(this)
                        .get(CadastrarCaixaDaguaViewModelNavigation.class);

        dataViewModel =
                new ViewModelProvider(this, factory)
                        .get(CadastroCaixaViewModelPersistence.class);

        // 🔹 Observa evento de navegação
        navViewModel.getEvento().observe(getViewLifecycleOwner(), evento -> {
            if (evento == null) return;

            if (evento == CadastrarCaixaDaguaViewModelNavigation.Evento.ACAO_CADASTRAR) {

                TextInputEditText edtNome = view.findViewById(R.id.inputNome);
                TextInputEditText edtCapacidade = view.findViewById(R.id.inputVolumeMaximo);

                String nome = edtNome.getText() != null ? edtNome.getText().toString() : "";
                String capStr = edtCapacidade.getText() != null ? edtCapacidade.getText().toString() : "";

                if (nome.isEmpty() || capStr.isEmpty()) {
                    Toast.makeText(getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double capacidade = Double.parseDouble(capStr);
                    dataViewModel.salvarCaixa(nome, capacidade);
                    Toast.makeText(getContext(), "Caixa salva com sucesso", Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(), "Capacidade inválida", Toast.LENGTH_SHORT).show();
                }
            }

            navViewModel.limparEvento();
        });

        // 🔹 Botão
        view.findViewById(R.id.btnCadastrar).setOnClickListener(v ->
                navViewModel.onAcaoCadastrar()
        );
    }
}
