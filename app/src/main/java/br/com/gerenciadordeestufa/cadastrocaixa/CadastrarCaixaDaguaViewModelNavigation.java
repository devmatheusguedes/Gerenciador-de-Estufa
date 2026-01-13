package br.com.gerenciadordeestufa.cadastrocaixa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CadastrarCaixaDaguaViewModelNavigation extends ViewModel {
    public enum Evento { ACAO_CADASTRAR }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();

    public LiveData<Evento> getEvento() {
        return evento;
    }

    public void onAcaoCadastrar() {
        evento.setValue(Evento.ACAO_CADASTRAR);
    }

    public void limparEvento() {
        evento.setValue(null);
    }
}
