package br.com.gerenciadordeestufa.estufa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EstufaViewModel extends ViewModel {
    public enum Evento{
        IR_PARA_CADASTRAR_ESTUFAS
    }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();

    public LiveData<Evento> getEvento(){
        return evento;
    }

    public void onCadastrarEstufas(){
        evento.setValue(Evento.IR_PARA_CADASTRAR_ESTUFAS);
    }

    public void limparEvento(){
        evento.setValue(null);
    }
}
