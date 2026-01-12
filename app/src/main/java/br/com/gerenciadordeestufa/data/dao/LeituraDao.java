package br.com.gerenciadordeestufa.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import br.com.gerenciadordeestufa.data.entity.LeituraEntity;
@Dao
public interface LeituraDao extends BaseDao<LeituraEntity> {
    @Query("select * from leitura")
    List<LeituraEntity> getAll();

    @Query("select * from leitura where id in (:id)")
    List<LeituraEntity> loadAllByIds(long[] id);
}
