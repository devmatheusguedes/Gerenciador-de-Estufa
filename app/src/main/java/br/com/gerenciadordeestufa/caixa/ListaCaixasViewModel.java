package br.com.gerenciadordeestufa.caixa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;
import br.com.gerenciadordeestufa.data.repository.CaixaDaguaRepository;

public class ListaCaixasViewModel extends ViewModel {
    private final LiveData<List<CaixaDaguaEnity>> caixas;

    public ListaCaixasViewModel(CaixaDaguaRepository repository) {
        this.caixas = repository.listarTodasAsCaixas();
    }

    public LiveData<List<CaixaDaguaEnity>> getCaixas() {
        return caixas;
    }


}
