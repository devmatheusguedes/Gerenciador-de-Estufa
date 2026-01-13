package br.com.gerenciadordeestufa.cadastrocaixa;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import br.com.gerenciadordeestufa.R;
import br.com.gerenciadordeestufa.ViewConfigurator;
import br.com.gerenciadordeestufa.data.database.AppDatabase;
import br.com.gerenciadordeestufa.data.repository.CaixaDaguaRepository;

public class CadastrarCaixaDaguaFragment extends Fragment {

    // 🔹 ViewModel responsável APENAS por eventos (navegação / ações)
    private CadastrarCaixaDaguaViewModelNavigation navViewModel;

    // 🔹 ViewModel responsável pela persistência (Room / Repository)
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

        // 🔹 1. Cria o Repository a partir do AppDatabase
        CaixaDaguaRepository repository =
                new CaixaDaguaRepository(
                        AppDatabase.getDatabase(requireContext()).caixaDaguaDao()
                );

        // 🔹 2. Cria a Factory da ViewModel de persistência
        CadastroCaixaViewModelFactory factory =
                new CadastroCaixaViewModelFactory(repository);

        // 🔹 3. ViewModel de navegação (sem dependências)
        navViewModel =
                new ViewModelProvider(this)
                        .get(CadastrarCaixaDaguaViewModelNavigation.class);

        // 🔹 4. ViewModel de dados (com Repository via Factory)
        dataViewModel =
                new ViewModelProvider(this, factory)
                        .get(CadastroCaixaViewModelPersistence.class);

        // 🔹 5. Observa eventos disparados pela ViewModel de navegação
        navViewModel.getEvento().observe(getViewLifecycleOwner(), evento -> {
            if (evento == null) return;

            switch (evento) {
                case ACAO_CADASTRAR:
                    // 🔹 Aqui você coleta os dados da tela
                    EditText edtNome = view.findViewById(R.id.inputNome);
                    EditText edtCapacidade = view.findViewById(R.id.inputVolumeMaximo);

                    String nome = edtNome.getText().toString();
                    Log.d("NOME", "nome da caixa: " + nome);
                    double capacidade = Double.parseDouble(
                            edtCapacidade.getText().toString()
                    );
                    // 🔹 Chama a ViewModel de persistência
                    dataViewModel.salvarCaixa(nome, capacidade);
                    break;

            }

            navViewModel.limparEvento();
        });

        // 🔹 6. Configuração dos listeners da View
        ViewConfigurator.configurar(view, v -> {
            v.findViewById(R.id.btnCadastrar).setOnClickListener(l -> {
                navViewModel.onAcaoCadastrar();
            });
        });
    }
}
