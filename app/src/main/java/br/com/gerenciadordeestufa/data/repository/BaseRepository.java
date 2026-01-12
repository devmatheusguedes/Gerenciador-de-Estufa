package br.com.gerenciadordeestufa.data.repository;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.gerenciadordeestufa.data.dao.BaseDao;
import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;

public abstract class BaseRepository<T> {
    private final BaseDao<T> dao;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    protected BaseRepository(BaseDao<T> dao) {
        this.dao = dao;
    }

    public void inserir(T e) {
        executor.execute(() -> dao.insert(e));
    }

    public List<T> listarTodas() {
        return dao.getAll();
    }

    public void delete(T e){
        dao.delete(e);
    }



}
