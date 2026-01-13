package br.com.gerenciadordeestufa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.gerenciadordeestufa.data.database.AppDatabase;
import br.com.gerenciadordeestufa.data.repository.CaixaDaguaRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}