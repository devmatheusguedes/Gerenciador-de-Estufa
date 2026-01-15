package br.com.gerenciadordeestufa.estufa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.gerenciadordeestufa.R;
import br.com.gerenciadordeestufa.ViewConfigurator;
import br.com.gerenciadordeestufa.data.database.AppDatabase;
import br.com.gerenciadordeestufa.data.repository.EstufaRepository;

public class EstufasFragment extends Fragment {

    private EstufaViewModelNavigation estufaViewModel;

    private ListaEstufaViewModel listaEstufaViewModel;
    private EstufaAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estufa, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.rv_greenhouses);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new EstufaAdapter();
        recyclerView.setAdapter(adapter);
        EstufaRepository repository = new EstufaRepository(AppDatabase.getDatabase(requireContext()).estufaDao());
        ListaEstufaViewModelFactory factory = new ListaEstufaViewModelFactory(repository);
        listaEstufaViewModel = new ViewModelProvider(this, factory)
                .get(ListaEstufaViewModel.class);

        listaEstufaViewModel.getEstufas().observe(getViewLifecycleOwner(),estufaEntity -> {
            adapter.submitList(estufaEntity);
        });

        estufaViewModel = new ViewModelProvider(this).get(EstufaViewModelNavigation.class);

        adapter.selectOnItemListner(estufa -> {
            estufaViewModel.onEstufaSelecionada();
        });



        estufaViewModel.getEvento().observe(
                getViewLifecycleOwner(), evento -> {
                    if (evento == null) return;
                    switch (evento){
                        case IR_PARA_CADASTRAR_ESTUFAS:
                            NavHostFragment.findNavController(this)
                                    .navigate(R.id.action_estufasFragment2_to_cadastroEstufaFragment);
                            break;
                        case ESTUFA_SELECIONADA:
                            Toast.makeText(getContext(), "Estufa selecionada", Toast.LENGTH_SHORT).show();
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
