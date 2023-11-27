package com.example.pdv.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
private Button btRegistrarVenda;
private Button btGerarRelatorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btRegistrarVenda = findViewById(R.id.btRegistrarVenda);
        btGerarRelatorio = findViewById(R.id.btGerarRelatorio);

        btRegistrarVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrarVendaActivity.class);
                startActivity(intent);
            }
        });

        btGerarRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RelatorioVendasActivity.class);
                startActivity(intent);
            }
        });
    }
}