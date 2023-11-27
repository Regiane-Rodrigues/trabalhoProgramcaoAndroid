package com.example.pdv.model;

public class Venda {
    private int id_vendas;
    private String produto;
    private int quantidade;
    private double valor_total;
    public Venda(){
    }

    public Venda(int id_vendas, String produto, int quantidade, double valor_total) {
        this.id_vendas = id_vendas;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor_total = valor_total;
    }

    public int getId_vendas() {
        return id_vendas;
    }

    public void setId_vendas(int id_vendas) {
        this.id_vendas = id_vendas;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
}
