package br.com.gerenciadordeestufa.cadastroestufa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.gerenciadordeestufa.data.entity.EstufaEntity;
import br.com.gerenciadordeestufa.data.repository.EstufaRepository;

public class CadastrarEstufaViewModelPersistence extends ViewModel {

    private final EstufaRepository repository;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public CadastrarEstufaViewModelPersistence(EstufaRepository repository) {
        this.repository = repository;
    }

    public void salvar(String nome){
        EstufaEntity estufaEntity = new EstufaEntity(nome);
        executorService.execute(() -> {
            repository.salvar(estufaEntity);

        });
    }

    public void atualizar(String nome){
        executorService.execute(() -> {
            repository.atualizar(new EstufaEntity(nome));

        });
    }

    public void deletar(String nome){
        EstufaEntity estufaEntity = repository.pesquisarPorNome(nome);
        executorService.execute(() -> repository.deletar(estufaEntity));
    }

    private LiveData<List<EstufaEntity>> listarEstufas(){
       return repository.listarEstufas();
    }
}
