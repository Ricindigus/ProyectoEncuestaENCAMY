package com.example.administrador.encal.Pojos;

import android.content.ContentValues;

import com.example.administrador.encal.Modelo.SQLConstantes;

/**
 * Created by dmorales on 05/12/2017.
 */

public class ResultadoEncuesta {
    private String RESFIN_ID;
    private String RESFIN_DIA;
    private String RESFIN_MES;
    private String RESFIN_ANIO;
    private String RESFIN_MIN;
    private String RESFIN_HORA;
    private String RESFIN;
    private String RESFIN_O;

    public ResultadoEncuesta() {
        RESFIN_ID = "";
        RESFIN_DIA = "";
        RESFIN_MES = "";
        RESFIN_ANIO = "";
        RESFIN_MIN = "";
        RESFIN_HORA = "";
        RESFIN = "";
        RESFIN_O = "";
    }

    public String getRESFIN_ID() {
        return RESFIN_ID;
    }

    public void setRESFIN_ID(String RESFIN_ID) {
        this.RESFIN_ID = RESFIN_ID;
    }

    public String getRESFIN_DIA() {
        return RESFIN_DIA;
    }

    public void setRESFIN_DIA(String RESFIN_DIA) {
        this.RESFIN_DIA = RESFIN_DIA;
    }

    public String getRESFIN_MES() {
        return RESFIN_MES;
    }

    public void setRESFIN_MES(String RESFIN_MES) {
        this.RESFIN_MES = RESFIN_MES;
    }

    public String getRESFIN_ANIO() {
        return RESFIN_ANIO;
    }

    public void setRESFIN_ANIO(String RESFIN_ANIO) {
        this.RESFIN_ANIO = RESFIN_ANIO;
    }

    public String getRESFIN_MIN() {
        return RESFIN_MIN;
    }

    public void setRESFIN_MIN(String RESFIN_MIN) {
        this.RESFIN_MIN = RESFIN_MIN;
    }

    public String getRESFIN_HORA() {
        return RESFIN_HORA;
    }

    public void setRESFIN_HORA(String RESFIN_HORA) {
        this.RESFIN_HORA = RESFIN_HORA;
    }

    public String getRESFIN() {
        return RESFIN;
    }

    public void setRESFIN(String RESFIN) {
        this.RESFIN = RESFIN;
    }

    public String getRESFIN_O() {
        return RESFIN_O;
    }

    public void setRESFIN_O(String RESFIN_O) {
        this.RESFIN_O = RESFIN_O;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(8);
        contentValues.put(SQLConstantes.RESULTADO_ID,RESFIN_ID);
        contentValues.put(SQLConstantes.RESULTADO_DIA,RESFIN_DIA);
        contentValues.put(SQLConstantes.RESULTADO_MES,RESFIN_MES);
        contentValues.put(SQLConstantes.RESULTADO_ANIO,RESFIN_ANIO);
        contentValues.put(SQLConstantes.RESULTADO_HORA,RESFIN_HORA);
        contentValues.put(SQLConstantes.RESULTADO_MIN,RESFIN_MIN);
        contentValues.put(SQLConstantes.RESULTADO_RESULTADO,RESFIN);
        contentValues.put(SQLConstantes.RESULTADO_RESULTADO_ESP,RESFIN_O);
        return contentValues;
    }
}