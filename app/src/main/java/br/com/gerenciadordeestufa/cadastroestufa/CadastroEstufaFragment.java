package br.com.gerenciadordeestufa.cadastroestufa;

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
import br.com.gerenciadordeestufa.ViewConfigurator;
import br.com.gerenciadordeestufa.data.database.AppDatabase;
import br.com.gerenciadordeestufa.data.repository.EstufaRepository;

public class CadastroEstufaFragment extends Fragment {

    private CadastrarEstufaViewModel navViewModel;
    private CadastrarEstufaViewModelPersistence dataViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_estufa, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EstufaRepository repository = new EstufaRepository(AppDatabase.getDatabase(requireContext()).estufaDao());
        CadastroEstufaViewModelFactory factory = new CadastroEstufaViewModelFactory(repository);
        navViewModel = new ViewModelProvider(this).get(CadastrarEstufaViewModel.class);
        dataViewModel = new ViewModelProvider(this, factory).get(CadastrarEstufaViewModelPersistence.class);
        navViewModel.getEvento().observe(getViewLifecycleOwner(), evento -> {
            if (evento == null) return;
            switch (evento){
                case ACAO_CADASTRAR_ESTUFA:
                    TextInputEditText text = view.findViewById(R.id.inputNomeEstufa);
                    String nome = text != null? String.valueOf(text.getText()) : "";
                    if (nome.isEmpty()){
                        Toast.makeText(getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    dataViewModel.salvar(nome);
                    Toast.makeText(getContext(), "Salvo com sucesso", Toast.LENGTH_SHORT).show();
                    break;
            }
            navViewModel.limparEvento();
        });
        ViewConfigurator.configurar(view,
                v -> {
                    v.findViewById(R.id.btnCadastrarEstufa)
                            .setOnClickListener(l -> {
                                navViewModel.onCadastrarEstufa();
                            });
                });
    }


}
