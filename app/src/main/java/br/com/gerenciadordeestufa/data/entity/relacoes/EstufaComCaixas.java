package br.com.gerenciadordeestufa.data.entity.relacoes;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;
import br.com.gerenciadordeestufa.data.entity.EstufaEntity;

public class EstufaComCaixas {
    @Embedded
    public EstufaEntity entity;

    @Relation(
            parentColumn = "id",
            entityColumn = "idEstufa"
    )
    public List<CaixaDaguaEnity> caixas;
}
