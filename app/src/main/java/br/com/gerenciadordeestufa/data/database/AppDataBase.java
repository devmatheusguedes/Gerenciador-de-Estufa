package br.com.gerenciadordeestufa.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.com.gerenciadordeestufa.data.dao.CaixaDaguaDao;
import br.com.gerenciadordeestufa.data.dao.LeituraDao;
import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;
import br.com.gerenciadordeestufa.data.entity.EstufaEntity;
import br.com.gerenciadordeestufa.data.entity.LeituraEntity;
import br.com.gerenciadordeestufa.data.entity.ParametroIdealEntity;

@Database(
        entities = {CaixaDaguaEnity.class, LeituraEntity.class,
                EstufaEntity.class, ParametroIdealEntity.class},
        version = 1
)
public abstract class AppDataBase extends RoomDatabase {
    public abstract CaixaDaguaDao caixaDaguaDao();
    public abstract LeituraDao leituraDao();
}
