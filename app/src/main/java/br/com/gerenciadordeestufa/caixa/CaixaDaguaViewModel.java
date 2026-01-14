package br.com.gerenciadordeestufa.caixa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import br.com.gerenciadordeestufa.cadastrocaixa.CadastrarCaixaDaguaViewModelNavigation;
import br.com.gerenciadordeestufa.data.entity.CaixaDaguaEnity;

public class CaixaDaguaViewModel extends ViewModel {

    public enum Evento {
        IR_PARA_CADASTRO_CAIXA,
        IR_PARA_HISTORICO,
        CAIXA_SELECIONADA,
        VOLTAR
    }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();
    private CaixaDaguaEnity entity;

    public LiveData<Evento> getEvento() {
        return evento;
    }

    public void onCadastrarCaixaClicado() {
        evento.setValue(Evento.IR_PARA_CADASTRO_CAIXA);
    }

    public void onVerHistoricoClicado() {
        evento.setValue(Evento.IR_PARA_HISTORICO);
    }

    public void onVoltarClicado(){
        evento.setValue(Evento.VOLTAR);
    }

    public void onCaixaSelecionada(CaixaDaguaEnity entity){
        this.entity = entity;
        evento.setValue(Evento.CAIXA_SELECIONADA);
    }

    public CaixaDaguaEnity getEntity() {
        return entity;
    }

    public void limparEvento() {
        evento.setValue(null);
    }

}
