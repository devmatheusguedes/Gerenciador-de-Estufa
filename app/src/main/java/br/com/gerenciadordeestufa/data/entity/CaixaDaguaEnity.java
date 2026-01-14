package br.com.gerenciadordeestufa.data.entity;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "caixa_dagua", foreignKeys = @ForeignKey(
            entity = EstufaEntity.class,
            parentColumns = "id",
            childColumns = "idEstufa",
            onDelete = ForeignKey.CASCADE
    ),
        indices = @Index("idEstufa")
)
public class CaixaDaguaEnity {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String nome;
    private String observacao;
    private double volume;

    private int idEstufa;


    public CaixaDaguaEnity(){}

    public CaixaDaguaEnity(double volume, String s){
        this.volume = volume;
        this.nome = s;
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

    @Override
    public String toString() {
        return "CaixaDaguaEnity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", observacao='" + observacao + '\'' +
                ", volume=" + volume +
                '}';
    }
}
