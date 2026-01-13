package br.com.gerenciadordeestufa.cadastrocaixa;

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
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CadastroCaixaViewModelPersistence.class)) {
            return (T) new CadastroCaixaViewModelPersistence(repository);
        }
        throw new IllegalArgumentException("ViewModel desconhecida");
    }
}
