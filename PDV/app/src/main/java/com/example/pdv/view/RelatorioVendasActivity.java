package com.example.pdv.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pdv.R;

import com.example.pdv.dao.VendasDao;
import com.example.pdv.helper.SQLiteDataHelper;
import com.example.pdv.model.Venda;
import java.util.List;

public class RelatorioVendasActivity extends AppCompatActivity {
    private TextView tvRelatorio;
    private SQLiteDataHelper baseDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_vendas);
        VendasDao vendasDao = VendasDao.getInstancia(this);

        List<Venda> listaVendas = vendasDao.getAll();

        StringBuilder relatorioText = new StringBuilder();
        for (Venda venda : listaVendas) {
            relatorioText.append("ID: ").append(venda.getId_vendas()).append("\n");
            relatorioText.append("Produto: ").append(venda.getProduto()).append("\n");
            relatorioText.append("Quantidade: ").append(venda.getQuantidade()).append("\n\n");
            relatorioText.append("Valor Total: ").append(venda.getValor_total()).append("\n\n");
        }

        tvRelatorio.setText(relatorioText.toString());
    }

    protected void onDestroy() {
        super.onDestroy();
        vendasDao.close();
    }
    }
