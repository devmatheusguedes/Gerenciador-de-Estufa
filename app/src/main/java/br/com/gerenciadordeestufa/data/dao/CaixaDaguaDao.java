package br.com.gerenciadordeestufa.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;

@Dao
public interface CaixaDaguaDao extends BaseDao<CaixaDaguaEnity>{
    @Query("select * from caixa_dagua")
    LiveData<List<CaixaDaguaEnity>> getAll();

    @Query("select * from caixa_dagua where id in (:idCaixa)")
    List<CaixaDaguaEnity> loadAllByIds(long[] idCaixa);


    @Query("select * from caixa_dagua where nome like :nomeCaixa")
    CaixaDaguaEnity findByName(String nomeCaixa);


}
