package br.com.gerenciadordeestufa.estufa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.com.gerenciadordeestufa.data.entity.EstufaEntity;
import br.com.gerenciadordeestufa.data.repository.EstufaRepository;

public class ListaEstufaViewModel extends ViewModel {
    private final LiveData<List<EstufaEntity>> estufas;

    public ListaEstufaViewModel(EstufaRepository repository) {
        this.estufas = repository.listarEstufas();
    }

    public LiveData<List<EstufaEntity>> getEstufas() {
        return estufas;
    }
}
