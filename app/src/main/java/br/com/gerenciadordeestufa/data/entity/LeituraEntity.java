package br.com.gerenciadordeestufa.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

@Entity(tableName = "leitura")
public class LeituraEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "ph")
    private double ph;

    private double temperatura;
    @ColumnInfo(name = "ec")
    private double ec;
    @ColumnInfo(name = "ppm")
    private double ppm;
    private String observacao;
    @ColumnInfo(name = "volume_atual_da_caixa")
    private long volumaeAtualDaCaixa;
    @ColumnInfo(name = "data_leitura")
    private long dataLeitura;

    public LeituraEntity(){}

    public LeituraEntity(long ph, long temperatura, long ec, long ppm, String observacao,
                         long volumaeAtualDaCaixa, long dataLeitura) {
        this.ph = ph;
        this.temperatura = temperatura;
        this.ec = ec;
        this.ppm = ppm;
        this.observacao = observacao;
        this.volumaeAtualDaCaixa = volumaeAtualDaCaixa;
        this.dataLeitura = dataLeitura;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getEc() {
        return ec;
    }

    public void setEc(double ec) {
        this.ec = ec;
    }

    public double getPpm() {
        return ppm;
    }

    public void setPpm(double ppm) {
        this.ppm = ppm;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public long getVolumaeAtualDaCaixa() {
        return volumaeAtualDaCaixa;
    }

    public void setVolumaeAtualDaCaixa(long volumaeAtualDaCaixa) {
        this.volumaeAtualDaCaixa = volumaeAtualDaCaixa;
    }

    public long getDataLeitura() {
        return dataLeitura;
    }

    public void setDataLeitura(long dataLeitura) {
        this.dataLeitura = dataLeitura;
    }
}
