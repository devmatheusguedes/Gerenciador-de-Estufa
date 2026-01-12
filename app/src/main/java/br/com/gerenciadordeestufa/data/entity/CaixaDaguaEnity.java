package br.com.gerenciadordeestufa.data.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "caixa_dagua")
public class CaixaDaguaEnity {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String nome;
    private String observacao;
    private double volume;



    public CaixaDaguaEnity(double volume){
        this.volume = volume;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

}
