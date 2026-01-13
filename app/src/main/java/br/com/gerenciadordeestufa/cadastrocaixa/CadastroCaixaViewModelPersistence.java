package br.com.gerenciadordeestufa.cadastrocaixa;

import androidx.lifecycle.ViewModel;
import java.util.concurrent.ExecutorService; // Importar
import java.util.concurrent.Executors;       // Importar

import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity; // Verifique se corrigiu o nome para Entity
import br.com.gerenciadordeestufa.data.repository.CaixaDaguaRepository;

public class CadastroCaixaViewModelPersistence extends ViewModel {

    private final CaixaDaguaRepository repository;

    // 1. Criamos um Executor para rodar tarefas em background
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public CadastroCaixaViewModelPersistence(CaixaDaguaRepository repository) {
        this.repository = repository;
    }

    public void salvarCaixa(String nome, double capacidade) {
        CaixaDaguaEnity caixa = new CaixaDaguaEnity(capacidade, nome);

        // 2. Envolvemos a chamada do repositório dentro do executor
        executor.execute(() -> {
            repository.inserir(caixa);
        });
    }
}