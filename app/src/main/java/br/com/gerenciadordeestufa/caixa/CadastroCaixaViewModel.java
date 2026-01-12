package br.com.gerenciadordeestufa.caixa;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.com.gerenciadordeestufa.data.dao.CaixaDaguaDao;
import br.com.gerenciadordeestufa.data.database.AppDatabase;
import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;
import br.com.gerenciadordeestufa.data.repository.CaixaDaguaRepository;

public class CadastroCaixaViewModel extends ViewModel {
    private final CaixaDaguaRepository repository;

    public CadastroCaixaViewModel(@NonNull Application app) {
        super(app);
        AppDatabase db = AppDatabase.getDatabase(app);
        repository = new CaixaDaguaRepository(db.caixaDaguaDao());
    }

    public void salvarCaixa(String nome, double capacidade){
        CaixaDaguaEnity caixaDaguaEnity = new CaixaDaguaEnity(capacidade, nome);
        repository.inserir(caixaDaguaEnity);
    }

    public List<CaixaDaguaEnity> listarCaixas(){
        return repository.listarTodasAsCaixas();
    }
}
