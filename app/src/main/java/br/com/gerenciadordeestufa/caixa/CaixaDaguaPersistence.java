package br.com.gerenciadordeestufa.caixa;

import androidx.lifecycle.ViewModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.gerenciadordeestufa.data.repository.CaixaDaguaRepository;

public class CaixaDaguaPersistence extends ViewModel {
    private final CaixaDaguaRepository repository;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public CaixaDaguaPersistence(CaixaDaguaRepository repository) {
        this.repository = repository;
    }


}
