package com.example.pdv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pdv.model.Venda;

import java.util.ArrayList;

public class VendaListAdapter extends
        RecyclerView.Adapter<VendaListAdapter.ViewHolder>{
    private ArrayList<Venda> listaVenda;
    private Context context;

    public VendaListAdapter(ArrayList<Venda> listaVenda, Context context) {
        this.listaVenda = listaVenda;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.item_list_venda,
                parent, false);

        return new ViewHolder(listItem);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Venda vendaSelecionado = listaVenda.get(position);
        holder.tvId_Vendas.setText(String.valueOf(vendaSelecionado.getId_vendas()));
        holder.tvProdutos.setText(vendaSelecionado.getProduto());
        holder.tvQuantidade.setText(vendaSelecionado.getQuantidade());
        holder.tvValor_Total.setText((int) vendaSelecionado.getValor_total());
    }

    @Override
    public int getItemCount() {
        return this.listaVenda.size();
    }

    /**Classe que vincula o componente do xml para ser manipulado**/
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvId_Vendas;
        public TextView tvProdutos;
        public TextView tvQuantidade;
        public TextView tvValor_Total;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvId_Vendas = itemView.findViewById(R.id.tvId_Vendas);
            this.tvProdutos = itemView.findViewById(R.id.tvProdutos);
            this.tvQuantidade = itemView.findViewById(R.id.tvQuantidade);
            this.tvValor_Total = itemView.findViewById(R.id.tvValor_Total);
        }
    }
}
