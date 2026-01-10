package br.com.gerenciadordeestufa;

import android.view.View;

import java.util.function.Consumer;

public final class ViewConfigurator {

    private ViewConfigurator() {}

    public static void configurar(View view, Consumer<View> acao) {
        acao.accept(view);
    }
}
