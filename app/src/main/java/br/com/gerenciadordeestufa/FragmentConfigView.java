package br.com.gerenciadordeestufa;

import android.view.View;

public interface FragmentConfigView<T> {

    public void configurarCliques(T view);

    public void navegar(int actionId);
}
