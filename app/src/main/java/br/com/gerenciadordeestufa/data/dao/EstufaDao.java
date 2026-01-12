package br.com.gerenciadordeestufa.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;
import br.com.gerenciadordeestufa.data.entity.EstufaEntity;

@Dao
public interface EstufaDao extends BaseDao<EstufaEntity> {
    @Query("select * from estufa")
    List<EstufaEntity> getAll();

    @Query("select * from estufa where id in (:id)")
    List<EstufaEntity> loadAllByIds(long[] id);


    @Query("select * from estufa where nome like :nome")
    EstufaEntity findByName(String nome);
}
