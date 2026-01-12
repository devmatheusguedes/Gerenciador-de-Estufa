package br.com.gerenciadordeestufa.parametros_ideais;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EditParametrosViewModel extends ViewModel {

    public enum Evento{
        ACAO_CANCELAR,
        ACAO_SALVAR
    }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();

    public LiveData<Evento> getEvento(){
        return evento;
    }

    public void onSalvar(){
        evento.setValue(Evento.ACAO_SALVAR);
    }

    public void onCancelar(){
        limparEvento();
    }

    private void limparEvento(){
        evento.setValue(null);
    }
}
