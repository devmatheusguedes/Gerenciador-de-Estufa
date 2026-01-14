package br.com.gerenciadordeestufa.cadastrocaixa;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;
import br.com.gerenciadordeestufa.data.repository.CaixaDaguaRepository;

public class CadastroCaixaViewModelPersistence extends ViewModel {

    private final CaixaDaguaRepository repository;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public CadastroCaixaViewModelPersistence(CaixaDaguaRepository repository) {
        this.repository = repository;
    }

    public void salvarCaixa(String nome, double capacidade) {
        CaixaDaguaEnity caixa = new CaixaDaguaEnity(capacidade, nome);
        executor.execute(() -> repository.inserir(caixa));
    }



}
