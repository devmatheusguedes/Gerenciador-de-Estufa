package br.com.gerenciadordeestufa.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "alerta")
public class AlertaEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "data_hora")
    private long dataHora;

    @ColumnInfo(name = "tipo_de_alerta")
    private TipoAlerta tipoAlerta;

    private boolean resolvido;

    public AlertaEntity(long dataHora, TipoAlerta tipoAlerta) {
        this.dataHora = dataHora;
        this.tipoAlerta = tipoAlerta;
    }

    public long getId() {
        return id;
    }

    public long getDataHora() {
        return dataHora;
    }

    public TipoAlerta getTipoAlerta() {
        return tipoAlerta;
    }

    public boolean getResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDataHora(long dataHora) {
        this.dataHora = dataHora;
    }

    public void setTipoAlerta(TipoAlerta tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }
}
