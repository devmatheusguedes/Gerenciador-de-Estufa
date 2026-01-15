package br.com.gerenciadordeestufa.estufa;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.gerenciadordeestufa.data.entity.EstufaEntity;
import br.com.gerenciadordeestufa.data.repository.EstufaRepository;

public class EstufaViewModelPersistence {
    private final EstufaRepository repository;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public EstufaViewModelPersistence(EstufaRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<EstufaEntity>> listarEstufas(){
        return repository.listarEstufas();
    }
}
