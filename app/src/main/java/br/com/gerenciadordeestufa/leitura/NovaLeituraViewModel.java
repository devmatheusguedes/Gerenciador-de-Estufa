package br.com.gerenciadordeestufa.leitura;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NovaLeituraViewModel extends ViewModel {
    public enum Evento{
        ACAO_SALVAR_LEITURA
    }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();

    public LiveData<Evento> getEvento(){
        return evento;
    }

    public void onSalvar(){
        evento.setValue(Evento.ACAO_SALVAR_LEITURA);
    }

    public void limparEvento(){
        evento.setValue(null);
    }
}
