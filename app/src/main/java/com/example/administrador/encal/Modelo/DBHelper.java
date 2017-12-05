package com.example.administrador.encal.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mcarazas on 27/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper{
    public static final int DB_VERSION = 1;
    public DBHelper(Context context) {
        super(context, SQLConstantes.DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MARCO);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_USUARIOS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_UBIGEOS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_CARATULAS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_VISITAS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_RESULTADOS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_IDENTIFICACIONES);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_FRAGMENTS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_SECCION100);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_SECCION200);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_SECCION300);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_SECCION400);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_MARCO);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_USUARIOS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_UBIGEO);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_CARATULAS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_DATOS_ENTREVISTA);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_VISITAS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_RESULTADOS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_IDENTIFICACIONES);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_FRAGMENTS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_SECCION100);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_SECCION200);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_SECCION300);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_SECCION400);
        onCreate(sqLiteDatabase);
    }
}
