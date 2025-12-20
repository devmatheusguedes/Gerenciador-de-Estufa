package br.com.gerenciadordeestufa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEstufas = findViewById(R.id.buttonAcessarEstufas);
        btnEstufas.setOnClickListener(v -> {
            startActivity(new Intent(this, EstufaActivity.class));
        });
    }
} 