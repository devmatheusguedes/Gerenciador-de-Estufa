package br.com.gerenciadordeestufa.parametros_ideais;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ParametrosIdeaisViewModel extends ViewModel {
    public enum Evento{
        IR_PARA_EDITAR_PARAMETROS_IDEAIS
    }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();

    public LiveData<Evento> getEvento(){
        return evento;
    }

    public void onEditarParametros(){
        evento.setValue(Evento.IR_PARA_EDITAR_PARAMETROS_IDEAIS);
    }

    public void limparEvento(){
        evento.setValue(null);
    }
}
