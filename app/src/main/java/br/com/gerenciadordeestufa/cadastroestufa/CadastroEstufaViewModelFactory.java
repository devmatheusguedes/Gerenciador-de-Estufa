package br.com.gerenciadordeestufa.cadastroestufa;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import br.com.gerenciadordeestufa.data.repository.EstufaRepository;

public class CadastroEstufaViewModelFactory implements ViewModelProvider.Factory {
    private final EstufaRepository repository;

    public CadastroEstufaViewModelFactory(EstufaRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CadastrarEstufaViewModelPersistence.class)){
            return (T) new CadastrarEstufaViewModelPersistence(repository);
        }
        throw new IllegalArgumentException("ViewModel desconhecida");
    }
}
