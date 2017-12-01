package com.example.administrador.encal.Pojos;

import android.content.ContentValues;

import com.example.administrador.encal.Modelo.SQLConstantes;

/**
 * Created by mcarazas on 24/11/2017.
 */

public class CaratulaPojo {

    private String ID;
    private String NOMBREDD;
    private String CCDD;
    private String NOMBREPV;
    private String CCPP;
    private String NOMBREDI;
    private String CCDI;
    private String GPSLATITUD;
    private String GPSLONGITUD;
    private String SECTOR_TR;
    private String ARA_TR;
    private String ZONA;
    private String MANZANA_ID;
    private String FRENTE;
    private String TIPVIA;
    private String TIPVIA_ESPEC;
    private String TIPVIA_D;
    private String NROPTA;
    private String BLOCK;
    private String INTERIOR;
    private String PISO;
    private String MZA;
    private String LOTE;
    private String KM;
    private String REF_DIREC;

    public CaratulaPojo( ) {
        this.ID = "";
        this.NOMBREDD = "";
        this.CCDD = "";
        this.NOMBREPV = "";
        this.CCPP = "";
        this.NOMBREDI = "";
        this.CCDI = "";
        this.GPSLATITUD = "";
        this.GPSLONGITUD = "";
        this.SECTOR_TR = "";
        this.ARA_TR = "";
        this.ZONA = "";
        this.MANZANA_ID = "";
        this.FRENTE = "";
        this.TIPVIA = "";
        this.TIPVIA_ESPEC = "";
        this.TIPVIA_D = "";
        this.NROPTA = "";
        this.BLOCK = "";
        this.INTERIOR = "";
        this.PISO = "";
        this.MZA = "";
        this.LOTE = "";
        this.KM = "";
        this.REF_DIREC = "";
    }

    public CaratulaPojo(String ID, String NOMBREDD, String CCDD, String NOMBREPV, String CCPP, String NOMBREDI, String CCDI, String GPSLATITUD, String GPSLONGITUD, String SECTOR_TR, String ARA_TR, String ZONA, String MANZANA_ID, String FRENTE, String TIPVIA, String TIPVIA_ESPEC, String TIPVIA_D, String NROPTA, String BLOCK, String INTERIOR, String PISO, String MZA, String LOTE, String KM, String REF_DIREC, String OBS) {
        this.ID = ID;
        this.NOMBREDD = NOMBREDD;
        this.CCDD = CCDD;
        this.NOMBREPV = NOMBREPV;
        this.CCPP = CCPP;
        this.NOMBREDI = NOMBREDI;
        this.CCDI = CCDI;
        this.GPSLATITUD = GPSLATITUD;
        this.GPSLONGITUD = GPSLONGITUD;
        this.SECTOR_TR = SECTOR_TR;
        this.ARA_TR = ARA_TR;
        this.ZONA = ZONA;
        this.MANZANA_ID = MANZANA_ID;
        this.FRENTE = FRENTE;
        this.TIPVIA = TIPVIA;
        this.TIPVIA_ESPEC = TIPVIA_ESPEC;
        this.TIPVIA_D = TIPVIA_D;
        this.NROPTA = NROPTA;
        this.BLOCK = BLOCK;
        this.INTERIOR = INTERIOR;
        this.PISO = PISO;
        this.MZA = MZA;
        this.LOTE = LOTE;
        this.KM = KM;
        this.REF_DIREC = REF_DIREC;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNOMBREDD() {
        return NOMBREDD;
    }

    public void setNOMBREDD(String NOMBREDD) {
        this.NOMBREDD = NOMBREDD;
    }

    public String getCCDD() {
        return CCDD;
    }

    public void setCCDD(String CCDD) {
        this.CCDD = CCDD;
    }

    public String getNOMBREPV() {
        return NOMBREPV;
    }

    public void setNOMBREPV(String NOMBREPV) {
        this.NOMBREPV = NOMBREPV;
    }

    public String getCCPP() {
        return CCPP;
    }

    public void setCCPP(String CCPP) {
        this.CCPP = CCPP;
    }

    public String getNOMBREDI() {
        return NOMBREDI;
    }

    public void setNOMBREDI(String NOMBREDI) {
        this.NOMBREDI = NOMBREDI;
    }

    public String getCCDI() {
        return CCDI;
    }

    public void setCCDI(String CCDI) {
        this.CCDI = CCDI;
    }

    public String getGPSLATITUD() {
        return GPSLATITUD;
    }

    public void setGPSLATITUD(String GPSLATITUD) {
        this.GPSLATITUD = GPSLATITUD;
    }

    public String getGPSLONGITUD() {
        return GPSLONGITUD;
    }

    public void setGPSLONGITUD(String GPSLONGITUD) {
        this.GPSLONGITUD = GPSLONGITUD;
    }

    public String getSECTOR_TR() {
        return SECTOR_TR;
    }

    public void setSECTOR_TR(String SECTOR_TR) {
        this.SECTOR_TR = SECTOR_TR;
    }

    public String getARA_TR() {
        return ARA_TR;
    }

    public void setARA_TR(String ARA_TR) {
        this.ARA_TR = ARA_TR;
    }

    public String getZONA() {
        return ZONA;
    }

    public void setZONA(String ZONA) {
        this.ZONA = ZONA;
    }

    public String getMANZANA_ID() {
        return MANZANA_ID;
    }

    public void setMANZANA_ID(String MANZANA_ID) {
        this.MANZANA_ID = MANZANA_ID;
    }

    public String getFRENTE() {
        return FRENTE;
    }

    public void setFRENTE(String FRENTE) {
        this.FRENTE = FRENTE;
    }

    public String getTIPVIA() {
        return TIPVIA;
    }

    public void setTIPVIA(String TIPVIA) {
        this.TIPVIA = TIPVIA;
    }

    public String getTIPVIA_ESPEC() {
        return TIPVIA_ESPEC;
    }

    public void setTIPVIA_ESPEC(String TIPVIA_ESPEC) {
        this.TIPVIA_ESPEC = TIPVIA_ESPEC;
    }

    public String getTIPVIA_D() {
        return TIPVIA_D;
    }

    public void setTIPVIA_D(String TIPVIA_D) {
        this.TIPVIA_D = TIPVIA_D;
    }

    public String getNROPTA() {
        return NROPTA;
    }

    public void setNROPTA(String NROPTA) {
        this.NROPTA = NROPTA;
    }

    public String getBLOCK() {
        return BLOCK;
    }

    public void setBLOCK(String BLOCK) {
        this.BLOCK = BLOCK;
    }

    public String getINTERIOR() {
        return INTERIOR;
    }

    public void setINTERIOR(String INTERIOR) {
        this.INTERIOR = INTERIOR;
    }

    public String getPISO() {
        return PISO;
    }

    public void setPISO(String PISO) {
        this.PISO = PISO;
    }

    public String getMZA() {
        return MZA;
    }

    public void setMZA(String MZA) {
        this.MZA = MZA;
    }

    public String getLOTE() {
        return LOTE;
    }

    public void setLOTE(String LOTE) {
        this.LOTE = LOTE;
    }

    public String getKM() {
        return KM;
    }

    public void setKM(String KM) {
        this.KM = KM;
    }

    public String getREF_DIREC() {
        return REF_DIREC;
    }

    public void setREF_DIREC(String REF_DIREC) {
        this.REF_DIREC = REF_DIREC;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(25);
        contentValues.put(SQLConstantes.CARATULA_ID,ID);
        contentValues.put(SQLConstantes.CARATULA_DEPARTAMENTO,NOMBREDD);
        contentValues.put(SQLConstantes.CARATULA_DEPARTAMENTO_COD,CCDD);
        contentValues.put(SQLConstantes.CARATULA_PROVINCIA,NOMBREPV);
        contentValues.put(SQLConstantes.CARATULA_PROVINCIA_COD,CCPP);
        contentValues.put(SQLConstantes.CARATULA_DISTRITO,NOMBREDI);
        contentValues.put(SQLConstantes.CARATULA_DISTRITO_COD,CCDI);
        contentValues.put(SQLConstantes.CARATULA_GPSLATITUD,GPSLATITUD);
        contentValues.put(SQLConstantes.CARATULA_GPSLONGITUD,GPSLONGITUD);
        contentValues.put(SQLConstantes.CARATULA_SECTOR,SECTOR_TR);
        contentValues.put(SQLConstantes.CARATULA_AREA,ARA_TR);
        contentValues.put(SQLConstantes.CARATULA_ZONA,ZONA);
        contentValues.put(SQLConstantes.CARATULA_MANZANA_MUESTRA,MANZANA_ID);
        contentValues.put(SQLConstantes.CARATULA_FRENTE,FRENTE);
        contentValues.put(SQLConstantes.CARATULA_TIPVIA,TIPVIA);
        contentValues.put(SQLConstantes.CARATULA_TIPVIA_OTRO,TIPVIA_ESPEC);
        contentValues.put(SQLConstantes.CARATULA_NOMVIA,TIPVIA_D);
        contentValues.put(SQLConstantes.CARATULA_NPUERTA,NROPTA);
        contentValues.put(SQLConstantes.CARATULA_BLOCK,BLOCK);
        contentValues.put(SQLConstantes.CARATULA_INTERIOR,INTERIOR);
        contentValues.put(SQLConstantes.CARATULA_PISO,PISO);
        contentValues.put(SQLConstantes.CARATULA_MANZANA_VIA,MZA);
        contentValues.put(SQLConstantes.CARATULA_LOTE,LOTE);
        contentValues.put(SQLConstantes.CARATULA_KM,KM);
        contentValues.put(SQLConstantes.CARATULA_REFERENCIA,REF_DIREC);
        return contentValues;

    }


}