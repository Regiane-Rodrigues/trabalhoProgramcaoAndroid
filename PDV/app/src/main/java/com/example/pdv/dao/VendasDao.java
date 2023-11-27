package com.example.pdv.dao;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.pdv.helper.SQLiteDataHelper;
import com.example.pdv.model.Venda;

import java.util.ArrayList;
public class VendasDao implements IGenericDao<Venda>{
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase baseDados;
    private String[]colunas = {"ID_VENDAS","PRODUTO","QUANTIDADE","VALOR_TOTAL"};
    private String tabela = "VENDAS";
    private Context context;
    private static VendasDao instancia;

    public static VendasDao getInstancia(Context context){
        if(instancia == null){
            return instancia = new VendasDao(context);
        }else{
            return instancia;
        }
    }
    private VendasDao(Context context){
        this.context = context;
        openHelper = new SQLiteDataHelper(this.context,"BYTECOFEE_BD",null,1);
        baseDados = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Venda obj){
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0],obj.getId_vendas());
            valores.put(colunas[1],obj.getProduto());
            valores.put(colunas[2],obj.getQuantidade());
            valores.put(colunas[3],obj.getValor_total());
            return baseDados.insert(tabela, null, valores);
        }catch (SQLException ex){
            Log.e("BYTECOFEE","ERRO:VendasDao.insert() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(Venda obj){
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[1],obj.getProduto());
            valores.put(colunas[2],obj.getQuantidade());
            valores.put(colunas[3],obj.getValor_total());

            String[]identificador = {String.valueOf(obj.getId_vendas())};

            return baseDados.update(tabela,  valores,
                    colunas[0]+"= ?", identificador);
        }catch (SQLException ex){
            Log.e("BYTECOFEE","ERRO:VendasDao.update() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(Venda obj){
        try{
            String[]identificador ={String.valueOf(obj.getId_vendas())};
            return baseDados.delete(tabela,colunas[0]+"= ?", identificador);
        }catch(SQLException ex){
            Log.e("BYTECOFEE","ERRO:VendasDao.delete() "+ex.getMessage());
        }
        return 0;
    }

    public ArrayList<Venda> getAll() {
        ArrayList<Venda> lista = new ArrayList<>();
        try {
            Cursor cursor = baseDados.query(tabela, colunas, null, null, null, null, colunas[0] + " desc");
            if (cursor.moveToFirst()) {
                do {
                    Venda venda = new Venda();
                    venda.setId_vendas(cursor.getInt(0));
                    venda.setProduto(cursor.getString(1));
                    venda.setQuantidade(cursor.getInt(2));
                    venda.setValor_total(cursor.getDouble(3));

                    lista.add(venda);

                } while (cursor.moveToNext());
            }

        } catch (SQLException ex) {
            Log.e("BYTECOFEE", "ERRO:VendasDao.getAll()  " + ex.getMessage());
        }
        return lista;
    }
    @Override
    public Venda getById(int id) {
        try{
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = baseDados.query(tabela, colunas,
                    colunas[0]+"= ?", identificador,
                    null, null, null);

            if(cursor.moveToFirst()){
                Venda venda = new Venda();
                venda.setId_vendas(cursor.getInt(0));
                venda.setProduto(cursor.getString(1));
                venda.setQuantidade(cursor.getInt(2));
                venda.setValor_total(cursor.getDouble(3));

                return venda;
            }
        }catch (SQLException ex){
            Log.e("BYTECOFEE", "ERRO:VendasDao.getById() " + ex.getMessage());
        }
        return null;
    }
}
