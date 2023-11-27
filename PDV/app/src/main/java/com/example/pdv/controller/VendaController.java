package com.example.pdv.controller;

import android.content.Context;

import com.example.pdv.dao.VendasDao;
import com.example.pdv.model.Venda;

import java.util.ArrayList;

public class VendaController {
    private Context context;

    public VendaController(Context context) {
        this.context = context;
    }
    public String salvarAluno(String id_vendas, String produto, String quantidade, String valor_total){
        try{
            if(id_vendas.equals("") || id_vendas.isEmpty()){
                return "Informe o numero de identificação!";
            }
            if(produto.equals("") || produto.isEmpty()){
                return "Informe o Produto!";
            }
            if(quantidade.equals("") || quantidade.isEmpty()){
                return "Informe a Quantidade!";
            }
            if(valor_total.equals("") || valor_total.isEmpty()){
                return "Informe o Valor Total!";
            }

            Venda venda = VendasDao.getInstancia(context)
                    .getById(Integer.parseInt(id_vendas));
            if(venda != null){
                return "O Número de Identificação ("+id_vendas+") já está cadastrado!";
            }else{
                venda = new Venda();
                venda.setId_vendas(Integer.parseInt(id_vendas));
                venda.setProduto(produto);
                venda.setQuantidade(Integer.parseInt(quantidade));
                venda.setValor_total(Double.parseDouble(valor_total));

                VendasDao.getInstancia(context).insert(venda);
            }

        }catch (Exception ex){
            return "Erro ao Gravar Venda.";
        }
        return null;
    }
    public ArrayList<Venda> retornarTodasVendas(){
        return VendasDao.getInstancia(context).getAll();
    }
}
