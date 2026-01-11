package br.com.gerenciadordeestufa.alert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import br.com.gerenciadordeestufa.R;
import br.com.gerenciadordeestufa.ViewConfigurator;

public class AlertaFragment extends Fragment {
    private AlertViewModel alertViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alertas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alertViewModel = new ViewModelProvider(this).get(AlertViewModel.class);

        alertViewModel.getEvento().observe(getViewLifecycleOwner(),
                evento -> {
                    if (evento == null) return;
                    if (evento == AlertViewModel.Evento.ACAO_MARCAR_COMO_RESOLVIDO) {
                        System.out.print("realizando ação do botão");
                    }
                    alertViewModel.limparEvento();
                });

        ViewConfigurator.configurar(view, v -> {
            v.findViewById(R.id.fab_mark_resolved)
                    .setOnClickListener(l -> {
                        alertViewModel.onMarcarComoResolvido();
                    });
        });
    }
}
