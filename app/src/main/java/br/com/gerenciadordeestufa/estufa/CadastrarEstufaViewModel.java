package br.com.gerenciadordeestufa.estufa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CadastrarEstufaViewModel extends ViewModel {

    public enum Evento{
        ACAO_CADASTRAR_ESTUFA
    }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();

    public LiveData<Evento> getEvento(){
        return evento;
    }

    public void onCadastrarEstufa(){
        evento.setValue(Evento.ACAO_CADASTRAR_ESTUFA);
    }

    public void limparEvento(){
        evento.setValue(null);
    }
}
