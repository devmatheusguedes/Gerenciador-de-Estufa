package br.com.gerenciadordeestufa.alert;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlertViewModel extends ViewModel {
    public enum Evento{
        ACAO_MARCAR_COMO_RESOLVIDO
    }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();

    public LiveData<Evento> getEvento(){
        return evento;
    }

    public void onMarcarComoResolvido(){
        evento.setValue(Evento.ACAO_MARCAR_COMO_RESOLVIDO);
    }

    public void limparEvento(){
        evento.setValue(null);
    }
}
