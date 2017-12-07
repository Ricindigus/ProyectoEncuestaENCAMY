package com.example.administrador.encal.Pojos;

import android.content.ContentValues;

import com.example.administrador.encal.Modelo.SQLConstantes;

/**
 * Created by mcarazas on 29/11/2017.
 */

public class Visita {

    //COLUMNAS_VISITA
    private  String ID;
    private  String ID_EMPRESA;
    private  String V_NRO;
    private  String V_DIA;
    private  String V_MES;
    private  String V_ANIO;
    private  String V_HORA;
    private  String V_MINUTO;
    private  String V_RESULTADO;
    private  String V_RESULTADO_O;
    private  String V_PROX_VIS_DIA;
    private  String V_PROX_VIS_MES;
    private  String V_PROX_VIS_ANIO;
    private  String V_PROX_VIS_HORA;
    private  String V_PROX_VIS_MINUTO;

    public Visita() {
        ID =  "";
        ID_EMPRESA = "";
        V_NRO = "";
        V_DIA = "";
        V_MES = "";
        V_ANIO = "";
        V_HORA = "";
        V_MINUTO = "";
        V_RESULTADO = "";
        V_RESULTADO_O = "";
        V_PROX_VIS_DIA = "";
        V_PROX_VIS_MES = "";
        V_PROX_VIS_ANIO = "";
        V_PROX_VIS_HORA = "";
        V_PROX_VIS_MINUTO = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_EMPRESA() {
        return ID_EMPRESA;
    }

    public void setID_EMPRESA(String ID_EMPRESA) {
        this.ID_EMPRESA = ID_EMPRESA;
    }

    public String getV_NRO() {
        return V_NRO;
    }

    public void setV_NRO(String v_NRO) {
        V_NRO = v_NRO;
    }

    public String getV_DIA() {
        return V_DIA;
    }

    public void setV_DIA(String v_DIA) {
        V_DIA = v_DIA;
    }

    public String getV_MES() {
        return V_MES;
    }

    public void setV_MES(String v_MES) {
        V_MES = v_MES;
    }

    public String getV_ANIO() {
        return V_ANIO;
    }

    public void setV_ANIO(String v_ANIO) {
        V_ANIO = v_ANIO;
    }

    public String getV_HORA() {
        return V_HORA;
    }

    public void setV_HORA(String v_HORA) {
        V_HORA = v_HORA;
    }

    public String getV_MINUTO() {
        return V_MINUTO;
    }

    public void setV_MINUTO(String v_MINUTO) {
        V_MINUTO = v_MINUTO;
    }

    public String getV_RESULTADO() {
        return V_RESULTADO;
    }

    public void setV_RESULTADO(String v_RESULTADO) {
        V_RESULTADO = v_RESULTADO;
    }

    public String getV_RESULTADO_O() {
        return V_RESULTADO_O;
    }

    public void setV_RESULTADO_O(String v_RESULTADO_O) {
        V_RESULTADO_O = v_RESULTADO_O;
    }

    public String getV_PROX_VIS_DIA() {
        return V_PROX_VIS_DIA;
    }

    public void setV_PROX_VIS_DIA(String v_PROX_VIS_DIA) {
        V_PROX_VIS_DIA = v_PROX_VIS_DIA;
    }

    public String getV_PROX_VIS_MES() {
        return V_PROX_VIS_MES;
    }

    public void setV_PROX_VIS_MES(String v_PROX_VIS_MES) {
        V_PROX_VIS_MES = v_PROX_VIS_MES;
    }

    public String getV_PROX_VIS_ANIO() {
        return V_PROX_VIS_ANIO;
    }

    public void setV_PROX_VIS_ANIO(String v_PROX_VIS_ANIO) {
        V_PROX_VIS_ANIO = v_PROX_VIS_ANIO;
    }

    public String getV_PROX_VIS_HORA() {
        return V_PROX_VIS_HORA;
    }

    public void setV_PROX_VIS_HORA(String v_PROX_VIS_HORA) {
        V_PROX_VIS_HORA = v_PROX_VIS_HORA;
    }

    public String getV_PROX_VIS_MINUTO() {
        return V_PROX_VIS_MINUTO;
    }

    public void setV_PROX_VIS_MINUTO(String v_PROX_VIS_MINUTO) {
        V_PROX_VIS_MINUTO = v_PROX_VIS_MINUTO;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(15);
        contentValues.put(SQLConstantes.VISITA_ID,ID);
        contentValues.put(SQLConstantes.VISITA_ID_EMPRESA,ID_EMPRESA);
        contentValues.put(SQLConstantes.VISITA_N,V_NRO);
        contentValues.put(SQLConstantes.VISITA_DIA,V_DIA);
        contentValues.put(SQLConstantes.VISITA_MES,V_MES);
        contentValues.put(SQLConstantes.VISITA_ANIO,V_ANIO);
        contentValues.put(SQLConstantes.VISITA_HORA,V_HORA);
        contentValues.put(SQLConstantes.VISITA_MINUTO,V_MINUTO);
        contentValues.put(SQLConstantes.VISITA_RESULTADO,V_RESULTADO);
        contentValues.put(SQLConstantes.VISITA_RESULTADO_ESP,V_RESULTADO_O);
        contentValues.put(SQLConstantes.VISITA_PROX_DIA,V_PROX_VIS_DIA);
        contentValues.put(SQLConstantes.VISITA_PROX_MES,V_PROX_VIS_MES);
        contentValues.put(SQLConstantes.VISITA_PROX_ANIO,V_PROX_VIS_ANIO);
        contentValues.put(SQLConstantes.VISITA_PROX_HORA,V_PROX_VIS_HORA);
        contentValues.put(SQLConstantes.VISITA_PROX_MINUTO,V_PROX_VIS_MINUTO);
        return contentValues;
    }
}
