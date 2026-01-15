package br.com.gerenciadordeestufa.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import androidx.room.TypeConverters;

import br.com.gerenciadordeestufa.data.dao.AlertaDao;
import br.com.gerenciadordeestufa.data.dao.CaixaDaguaDao;
import br.com.gerenciadordeestufa.data.dao.EstufaDao;
import br.com.gerenciadordeestufa.data.dao.LeituraDao;
import br.com.gerenciadordeestufa.data.dao.ParametroIdealDao;
import br.com.gerenciadordeestufa.data.entity.AlertaEntity;
import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;
import br.com.gerenciadordeestufa.data.entity.EstufaEntity;
import br.com.gerenciadordeestufa.data.entity.LeituraEntity;
import br.com.gerenciadordeestufa.data.entity.ParametroIdealEntity;
import br.com.gerenciadordeestufa.data.entity.TipoAlerta;

@Database(
        entities = {CaixaDaguaEnity.class, LeituraEntity.class,
                EstufaEntity.class, ParametroIdealEntity.class,
                AlertaEntity.class
        },
        version = 2
)
@TypeConverters({TipoAlertaConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract CaixaDaguaDao caixaDaguaDao();
    public abstract LeituraDao leituraDao();
    public abstract EstufaDao estufaDao();
    public abstract ParametroIdealDao parametroIdealDao();
    public abstract AlertaDao alertaDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (AppDatabase.class){
                if (INSTANCE == null){
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "gerenciador_estufa.db")
                                    .fallbackToDestructiveMigration()
                                    .build();
                }
            }
        }
        return INSTANCE;
    }



}
