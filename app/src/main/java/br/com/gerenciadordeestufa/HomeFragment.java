package br.com.gerenciadordeestufa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getActivity() != null){
            getActivity().setTitle("Menu");
        }
        View view = inflater.inflate(
                R.layout.fragment_home, container, false
        );

        Button buttonAcessarEstufas = view.findViewById(R.id.acessarEstufas);

        buttonAcessarEstufas.setOnClickListener(v -> abrirEstufas());
        return view;
    }

    private void abrirEstufas(){
        trocarfragment(new EstufasFragment(), "EStufas");
    }

    private void trocarfragment(Fragment fragment, String titulo) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction().replace(
                        R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();

        requireActivity().setTitle(titulo);
    }
}
