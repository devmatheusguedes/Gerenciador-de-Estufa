package br.com.gerenciadordeestufa.caixa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CadastrarCaixaDaguaViewModel extends ViewModel {
    public enum Evento{
        ACAO_CADASTRAR
    }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();

    public LiveData<Evento> getEvento(){
        return evento;
    }

    public void onAcaoCadastrar(){
        evento.setValue(Evento.ACAO_CADASTRAR);
    }

    public void limparEvento(){
        evento.setValue(null);
    }
}
