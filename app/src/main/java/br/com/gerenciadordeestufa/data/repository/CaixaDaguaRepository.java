package br.com.gerenciadordeestufa.data.repository;

import android.util.Log;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.gerenciadordeestufa.GerenciadorEstufaApp;
import br.com.gerenciadordeestufa.data.dao.BaseDao;
import br.com.gerenciadordeestufa.data.dao.CaixaDaguaDao;
import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;

public class CaixaDaguaRepository{
    private final CaixaDaguaDao dao;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    public CaixaDaguaRepository(CaixaDaguaDao dao) {
        this.dao = dao;
    }

    public void inserir(CaixaDaguaEnity enity){
        dao.insert(enity);
    }

    public List<CaixaDaguaEnity> listarTodasAsCaixas(){
        return dao.getAll();
    }
}
