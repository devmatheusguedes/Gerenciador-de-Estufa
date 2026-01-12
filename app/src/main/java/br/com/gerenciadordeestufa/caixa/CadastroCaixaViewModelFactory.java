package br.com.gerenciadordeestufa.caixa;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import br.com.gerenciadordeestufa.data.repository.CaixaDaguaRepository;

public class CadastroCaixaViewModelFactory implements ViewModelProvider.Factory {
    private final CaixaDaguaRepository repository;


    public CadastroCaixaViewModelFactory(CaixaDaguaRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return ViewModelProvider.Factory.super.create(modelClass);
    }
}
