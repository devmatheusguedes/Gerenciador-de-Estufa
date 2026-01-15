package br.com.gerenciadordeestufa.estufa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EstufaViewModelNavigation extends ViewModel {
    public enum Evento{
        IR_PARA_CADASTRAR_ESTUFAS,
        ESTUFA_SELECIONADA
    }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();

    public LiveData<Evento> getEvento(){
        return evento;
    }

    public void onCadastrarEstufas(){
        evento.setValue(Evento.IR_PARA_CADASTRAR_ESTUFAS);
    }

    public void onEstufaSelecionada(){
        evento.setValue(Evento.ESTUFA_SELECIONADA);
    }

    public void limparEvento(){
        evento.setValue(null);
    }
}
