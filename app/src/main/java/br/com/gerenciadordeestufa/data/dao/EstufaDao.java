package br.com.gerenciadordeestufa.data.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;
import br.com.gerenciadordeestufa.data.entity.EstufaEntity;
import br.com.gerenciadordeestufa.data.entity.relacoes.EstufaComCaixas;

@Dao
public interface EstufaDao extends BaseDao<EstufaEntity> {
    @Query("select * from estufa")
    List<EstufaEntity> getAll();

    @Query("select * from estufa where id in (:id)")
    List<EstufaEntity> loadAllByIds(long[] id);

    @Transaction
    @Query("SELECT * FROM estufa")
    List<EstufaComCaixas> listarCaixasDaEStufa();

    @Query("select * from estufa where nome like :nome")
    EstufaEntity findByName(String nome);
}
