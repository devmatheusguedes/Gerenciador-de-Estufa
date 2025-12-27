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
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View cardEstufas = view.findViewById(R.id.card_estufas_id);
        cardEstufas.setOnClickListener(v ->{
            NavHostFragment
                }
        );
    }
}
