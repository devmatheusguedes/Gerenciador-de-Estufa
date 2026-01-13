package br.com.gerenciadordeestufa.data.database;

import androidx.room.TypeConverter;

import br.com.gerenciadordeestufa.data.entity.TipoAlerta;

public class TipoAlertaConverter {

    @TypeConverter
    public static String toString(TipoAlerta tipoAlerta){
        return tipoAlerta == null? null : tipoAlerta.name();
    }

    public static TipoAlerta toEnum(String valor){
        return valor == null? null : TipoAlerta.valueOf(valor);
    }

}
