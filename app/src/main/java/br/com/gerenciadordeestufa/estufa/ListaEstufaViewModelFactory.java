package br.com.gerenciadordeestufa.estufa;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import br.com.gerenciadordeestufa.data.repository.EstufaRepository;

public class ListaEstufaViewModelFactory implements ViewModelProvider.Factory {
    private final EstufaRepository repository;

    public ListaEstufaViewModelFactory(EstufaRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ListaEstufaViewModel.class)){
            return (T) new ListaEstufaViewModel(repository);
        }

        throw new IllegalArgumentException("viewModel desconhecida");
    }
}
