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
    private double pH;

    private double temperatura;
    @ColumnInfo(name = "ec")
    private double eC;
    @ColumnInfo(name = "ppm")
    private double pPM;
    private String observacao;
    @ColumnInfo(name = "volume_atual_da_caixa")
    private long volumaeAtualDaCaixa;
    @ColumnInfo(name = "data_leitura")
    private long dataLeitura;

    public LeituraEntity(long pH, long temperatura, long eC, long pPM, String observacao,
                         long volumaeAtualDaCaixa, long dataLeitura) {
        this.pH = pH;
        this.temperatura = temperatura;
        this.eC = eC;
        this.pPM = pPM;
        this.observacao = observacao;
        this.volumaeAtualDaCaixa = volumaeAtualDaCaixa;
        this.dataLeitura = dataLeitura;
    }

    public long getId() {
        return id;
    }

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double geteC() {
        return eC;
    }

    public void seteC(double eC) {
        this.eC = eC;
    }

    public double getpPM() {
        return pPM;
    }

    public void setpPM(double pPM) {
        this.pPM = pPM;
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
