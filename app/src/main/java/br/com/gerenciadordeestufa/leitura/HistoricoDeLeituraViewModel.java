package br.com.gerenciadordeestufa.leitura;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HistoricoDeLeituraViewModel extends ViewModel {
    public enum Evento{

    }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();

    public LiveData<Evento> getEvento(){
        return evento;
    }

    public void limparEvento(){
        evento.setValue(null);
    }
}
