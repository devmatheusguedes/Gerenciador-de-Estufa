package br.com.gerenciadordeestufa;

public interface FragmentConfigView<T> {

    public void configurarCliques(T view);

    public void navegar(int actionId);
}
