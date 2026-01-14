package br.com.gerenciadordeestufa.caixa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;
import br.com.gerenciadordeestufa.data.repository.CaixaDaguaRepository;

public class CaixaDaguaViewModelPersistence {
    private final CaixaDaguaRepository repository;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public CaixaDaguaViewModelPersistence(CaixaDaguaRepository repository) {
        this.repository = repository;
    }

    public void salvar(String nome, double capacidade){
        CaixaDaguaEnity enity = new CaixaDaguaEnity(capacidade, nome);
        executorService.execute(() ->{
            repository.inserir(enity);
        });
    }

    public void atualizar(String nome, double capacidade){
        CaixaDaguaEnity enity = new CaixaDaguaEnity(capacidade, nome);
        executorService.execute(() ->{
            repository.update(enity);
        });
    }

    public void deletar(CaixaDaguaEnity caixaDaguaEnity){
        executorService.execute(() -> {
            repository.deletar(caixaDaguaEnity);

        });
    }


}
