package br.com.gerenciadordeestufa.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    public enum Evento{
        IR_PARA_ESTUFAS,
        IR_PARA_CAIXA_DAGUA,
        IR_PARA_NOVA_LEITURA,
        IR_PARA_ALERTAS,
        IR_PARA_PARAMETROS_IDEAIS
    }

    private final MutableLiveData<Evento> evento = new MutableLiveData<>();

    public LiveData<Evento> getEvento(){
        return evento;
    }

    public void onEstufas(){
        evento.setValue(Evento.IR_PARA_ESTUFAS);
    }

    public void onCaixaDagua(){
        evento.setValue(Evento.IR_PARA_CAIXA_DAGUA);
    }

    public void onNovaLeitura(){
        evento.setValue(Evento.IR_PARA_NOVA_LEITURA);
    }

    public void onAlertas(){
        evento.setValue(Evento.IR_PARA_ALERTAS);
    }

    public void onParametrosIdeais(){
        evento.setValue(Evento.IR_PARA_PARAMETROS_IDEAIS);
    }

    public void LimparEvento(){
        evento.setValue(null);
    }

}
