package com.example.pdv.view;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.pdv.controller.VendaController;
public class RegistrarVendaActivity {
    private EditText etIdVendas;
    private EditText etProduto;
    private EditText etQuantidade;
    private EditText etValorTotal;
    private Button btRegistrarVenda;
    private VendaController vendaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarvenda);

        vendaController = new VendaController(this);

        etIdVendas = findViewById(R.id.etIdVendas);
        etProduto = findViewById(R.id.etProduto);
        etQuantidade = findViewById(R.id.etQuantidade);
        etValorTotal = findViewById(R.id.etValorTotal);
        btRegistrarVenda = findViewById(R.id.btRegistrarVenda);

        btRegistrarVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarVenda();
            }
        });
    }

    private void registrarVenda() {
        String idVendas = etIdVendas.getText().toString();
        String produto = etProduto.getText().toString();
        String quantidade = etQuantidade.getText().toString();
        String valorTotal = etValorTotal.getText().toString();

        String resultado = vendaController.salvarAluno(idVendas, produto, quantidade, valorTotal);
    }
    }
