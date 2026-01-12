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
    private double phMinimo;
    @ColumnInfo(name = "ph_maximo")
    private double phMaximo;
    @ColumnInfo(name = "ec_minimo")
    private double ecMinimo;
    @ColumnInfo(name = "ec_maximo")
    private double ecMaximo;

    @ColumnInfo(name = "temperatura_ideal")
    private double temperaturaIdeal;

    public ParametroIdealEntity(){}

    public ParametroIdealEntity(double phMinimo, double phMaximo, double ecMinimo,
                                double ecMaximo, double temperaturaIdeal) {
        this.phMinimo = phMinimo;
        this.phMaximo = phMaximo;
        this.ecMinimo = ecMinimo;
        this.ecMaximo = ecMaximo;
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPhMinimo() {
        return phMinimo;
    }

    public void setPhMinimo(double phMinimo) {
        this.phMinimo = phMinimo;
    }

    public double getPhMaximo() {
        return phMaximo;
    }

    public void setPhMaximo(double phMaximo) {
        this.phMaximo = phMaximo;
    }

    public double getEcMinimo() {
        return ecMinimo;
    }

    public void setEcMinimo(double ecMinimo) {
        this.ecMinimo = ecMinimo;
    }

    public double getEcMaximo() {
        return ecMaximo;
    }

    public void setEcMaximo(double ecMaximo) {
        this.ecMaximo = ecMaximo;
    }

    public double getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(double temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }
}
