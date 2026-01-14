package br.com.gerenciadordeestufa.data.repository;

import java.util.List;

import br.com.gerenciadordeestufa.data.dao.EstufaDao;
import br.com.gerenciadordeestufa.data.entity.EstufaEntity;
import br.com.gerenciadordeestufa.data.entity.relacoes.EstufaComCaixas;

public class EstufaRepository{
    private final EstufaDao estufaDao;

    public EstufaRepository(EstufaDao estufaDao) {
        this.estufaDao = estufaDao;
    }

    public void salvar(EstufaEntity entity){
        estufaDao.insert(entity);
    }

    public void atualizar(EstufaEntity entity){
        estufaDao.update(entity);
    }

    public void deletar(EstufaEntity estufaEntity){
        estufaDao.delete(estufaEntity);
    }

    public List<EstufaComCaixas> listarCaixasDagua(){
        return estufaDao.listarCaixasDaEStufa();
    }

    public List<EstufaEntity> listarEstufas(){
        return estufaDao.getAll();
    }
}
