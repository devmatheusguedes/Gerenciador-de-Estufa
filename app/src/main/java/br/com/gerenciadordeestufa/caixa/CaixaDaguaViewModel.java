package br.com.gerenciadordeestufa.caixa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CaixaDaguaViewModel extends ViewModel {

    public enum Evento {
        IR_PARA_CADASTRO_CAIXA,
        IR_PARA_HISTORICO,
        VOLTAR
    }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();

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

    public void limparEvento() {
        evento.setValue(null);
    }

}
