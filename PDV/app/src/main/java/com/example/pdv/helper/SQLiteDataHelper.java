package com.example.pdv.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class   SQLiteDataHelper extends SQLiteOpenHelper {


        public SQLiteDataHelper(@Nullable Context context,
                                @Nullable String name,
                                @Nullable SQLiteDatabase.CursorFactory factory,
                                int version) {
            super(context, name, factory, version);
        }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE VENDAS (ID_VENDAS INTEGER, PRODUTO VARCHAR(100), " +
                "QUANTIDADE INTENGER, VALOR_TOTAL REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

}