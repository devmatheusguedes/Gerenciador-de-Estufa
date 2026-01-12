package br.com.gerenciadordeestufa.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "estufa")
public class EstufaEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nome;
    private String observacoes;

    public EstufaEntity(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
