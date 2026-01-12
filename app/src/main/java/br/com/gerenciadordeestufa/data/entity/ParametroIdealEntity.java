package br.com.gerenciadordeestufa.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "parametro_ideal")
public class ParametroIdealEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "ph_minimo")
    private double pHMinimo;
    @ColumnInfo(name = "ph_maximo")
    private double pHMaximo;
    @ColumnInfo(name = "ec_minimo")
    private double eCMinimo;
    @ColumnInfo(name = "ec_maximo")
    private double eCMaximo;

    @ColumnInfo(name = "temperatura_ideal")
    private double temperaturaIdeal;

    public ParametroIdealEntity(double pHMinimo, double pHMaximo, double eCMinimo,
                                double eCMaximo, double temperaturaIdeal) {
        this.pHMinimo = pHMinimo;
        this.pHMaximo = pHMaximo;
        this.eCMinimo = eCMinimo;
        this.eCMaximo = eCMaximo;
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getpHMinimo() {
        return pHMinimo;
    }

    public void setpHMinimo(double pHMinimo) {
        this.pHMinimo = pHMinimo;
    }

    public double getpHMaximo() {
        return pHMaximo;
    }

    public void setpHMaximo(double pHMaximo) {
        this.pHMaximo = pHMaximo;
    }

    public double geteCMinimo() {
        return eCMinimo;
    }

    public void seteCMinimo(double eCMinimo) {
        this.eCMinimo = eCMinimo;
    }

    public double geteCMaximo() {
        return eCMaximo;
    }

    public void seteCMaximo(double eCMaximo) {
        this.eCMaximo = eCMaximo;
    }

    public double getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(double temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    @Override
    public String toString() {
        return "ParametroIdealEntity{" +
                "id=" + id +
                ", pHMinimo=" + pHMinimo +
                ", pHMaximo=" + pHMaximo +
                ", eCMinimo=" + eCMinimo +
                ", eCMaximo=" + eCMaximo +
                ", temperaturaIdeal=" + temperaturaIdeal +
                '}';
    }
}
