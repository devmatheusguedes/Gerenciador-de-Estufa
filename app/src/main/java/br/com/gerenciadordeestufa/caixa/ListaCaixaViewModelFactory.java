package br.com.gerenciadordeestufa.caixa;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import br.com.gerenciadordeestufa.data.repository.CaixaDaguaRepository;

public class ListaCaixaViewModelFactory implements ViewModelProvider.Factory {
    private final CaixaDaguaRepository repository;

    public ListaCaixaViewModelFactory(CaixaDaguaRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ListaCaixasViewModel.class)){
            return (T) new ListaCaixasViewModel(repository);
        }
        throw new IllegalArgumentException("viewModel desconhecida");
    }
}
