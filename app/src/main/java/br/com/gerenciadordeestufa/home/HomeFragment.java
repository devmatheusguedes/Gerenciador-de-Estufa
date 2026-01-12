package br.com.gerenciadordeestufa.home;

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


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        homeViewModel.getEvento().observe(getViewLifecycleOwner(),
                evento -> {
                    if (evento == null) return;

                    switch (evento){
                        case IR_PARA_ESTUFAS:
                            NavHostFragment
                                    .findNavController(this)
                                    .navigate(
                                            R.id.action_homeFragment_to_estufasFragment2
                                    );
                            break;

                        case IR_PARA_CAIXA_DAGUA:
                            NavHostFragment
                                    .findNavController(this)
                                    .navigate(
                                            R.id.action_homeFragment_to_caixaDaguaFragment
                                    );
                            break;
                        case IR_PARA_ALERTAS:
                            NavHostFragment.findNavController(this)
                                    .navigate(
                                            R.id.action_homeFragment_to_alertaFragment
                                    );
                            break;
                        case IR_PARA_NOVA_LEITURA:
                            NavHostFragment.findNavController(this)
                                    .navigate(
                                            R.id.action_homeFragment_to_novaleituraFragment
                                    );
                            break;
                        case IR_PARA_PARAMETROS_IDEAIS:
                            NavHostFragment
                                    .findNavController(this)
                                    .navigate(R.id.action_homeFragment_to_parametrosIdeaisFragment);
                            break;
                    }
                homeViewModel.limparEvento();
                });

        ViewConfigurator.configurar(view,
                v -> {
                    v.findViewById(R.id.card_estufas_id)
                            .setOnClickListener(l ->
                                    homeViewModel.onEstufas());

                    v.findViewById(R.id.card_caixas_dagua_id)
                            .setOnClickListener(l ->
                                    homeViewModel.onCaixaDagua());

                    v.findViewById(R.id.card_alertas_id)
                            .setOnClickListener(l ->
                                    homeViewModel.onAlertas());

                    v.findViewById(R.id.btn_new_reading)
                            .setOnClickListener(l ->
                                    homeViewModel.onNovaLeitura());
                    v.findViewById(R.id.btnConfiguracoes)
                            .setOnClickListener(l ->
                                    homeViewModel.onParametrosIdeais());
                });



    }


}
