package br.com.gerenciadordeestufa.data.repository;

import android.util.Log;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import br.com.gerenciadordeestufa.GerenciadorEstufaApp;
import br.com.gerenciadordeestufa.data.dao.CaixaDaguaDao;
import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;

public class CaixaDaguaRepository {

    private CaixaDaguaDao caixaDaguaDao;

    public CaixaDaguaRepository(){
        caixaDaguaDao = GerenciadorEstufaApp.getAppDatabase().caixaDaguaDao();
    }

    public void teste(){
        Executors.newSingleThreadExecutor().execute(() -> {
            CaixaDaguaEnity caixaDaguaEnity = new CaixaDaguaEnity(500, "caixa 1");
            caixaDaguaDao.insert(caixaDaguaEnity);

            List<CaixaDaguaEnity> all = caixaDaguaDao.getAll();
            Log.d("DB_TESTE", "Total de caixas: " + all.size());

        });
    }
}
