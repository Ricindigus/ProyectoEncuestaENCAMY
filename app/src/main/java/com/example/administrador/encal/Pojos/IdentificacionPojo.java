package com.example.administrador.encal.Pojos;

import android.content.ContentValues;

import com.example.administrador.encal.Modelo.SQLConstantes;

/**
 * Created by mcarazas on 24/11/2017.
 */
public class IdentificacionPojo {

    public String ID;
    public String NUM_RUC;
    public String RAZON_SOCIAL;
    public String NOM_COMER_MYPE;
    public String ANO_INI;
    public String PAGWEB_NO;
    public String PAGWEB;
    public String CORREO_NO;
    public String CORREO;
    public String TELFIJO_NO;
    public String TELFIJO;
    public String TELMOVIL_NO;
    public String TELMOVIL;
    public String COND_APEL_NOM;
    public String COND_SEXO;
    public String COND_EDAD;
    public String COND_NEST;
    public String INFOR_CARGO;
    public String INFOR_CARGO_O;
    public String INFOR_APEL_NOM;
    public String CONOCE_INACAL;

    public IdentificacionPojo() {
        this.ID = "";
        this.NUM_RUC = "";
        this.RAZON_SOCIAL = "";
        this.NOM_COMER_MYPE = "";
        this.ANO_INI = "";
        this.PAGWEB_NO = "";
        this.PAGWEB = "";
        this.CORREO_NO = "";
        this.CORREO = "";
        this.TELFIJO_NO = "";
        this.TELFIJO = "";
        this.TELMOVIL_NO = "";
        this.TELMOVIL = "";
        this.COND_APEL_NOM = "";
        this.COND_SEXO = "";
        this.COND_EDAD = "";
        this.COND_NEST = "";
        this.INFOR_CARGO = "";
        this.INFOR_CARGO_O = "";
        this.INFOR_APEL_NOM = "";
        this.CONOCE_INACAL = "";
    }

    public IdentificacionPojo(String ID, String NUM_RUC, String RAZON_SOCIAL, String NOM_COMER_MYPE, String ANO_INI, String PAGWEB_NO, String PAGWEB, String CORREO_NO, String CORREO, String TELFIJO_NO, String TELFIJO, String TELMOVIL_NO, String TELMOVIL, String COND_APEL_NOM, String COND_SEXO, String COND_EDAD, String COND_NEST, String INFOR_CARGO, String INFOR_CARGO_O, String INFOR_APEL_NOM, String CONOCE_INACAL, String OBS) {
        this.ID = ID;
        this.NUM_RUC = NUM_RUC;
        this.RAZON_SOCIAL = RAZON_SOCIAL;
        this.NOM_COMER_MYPE = NOM_COMER_MYPE;
        this.ANO_INI = ANO_INI;
        this.PAGWEB_NO = PAGWEB_NO;
        this.PAGWEB = PAGWEB;
        this.CORREO_NO = CORREO_NO;
        this.CORREO = CORREO;
        this.TELFIJO_NO = TELFIJO_NO;
        this.TELFIJO = TELFIJO;
        this.TELMOVIL_NO = TELMOVIL_NO;
        this.TELMOVIL = TELMOVIL;
        this.COND_APEL_NOM = COND_APEL_NOM;
        this.COND_SEXO = COND_SEXO;
        this.COND_EDAD = COND_EDAD;
        this.COND_NEST = COND_NEST;
        this.INFOR_CARGO = INFOR_CARGO;
        this.INFOR_CARGO_O = INFOR_CARGO_O;
        this.INFOR_APEL_NOM = INFOR_APEL_NOM;
        this.CONOCE_INACAL = CONOCE_INACAL;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNUM_RUC() {
        return NUM_RUC;
    }

    public void setNUM_RUC(String NUM_RUC) {
        this.NUM_RUC = NUM_RUC;
    }

    public String getRAZON_SOCIAL() {
        return RAZON_SOCIAL;
    }

    public void setRAZON_SOCIAL(String RAZON_SOCIAL) {
        this.RAZON_SOCIAL = RAZON_SOCIAL;
    }

    public String getNOM_COMER_MYPE() {
        return NOM_COMER_MYPE;
    }

    public void setNOM_COMER_MYPE(String NOM_COMER_MYPE) {
        this.NOM_COMER_MYPE = NOM_COMER_MYPE;
    }

    public String getANO_INI() {
        return ANO_INI;
    }

    public void setANO_INI(String ANO_INI) {
        this.ANO_INI = ANO_INI;
    }

    public String getPAGWEB_NO() {
        return PAGWEB_NO;
    }

    public void setPAGWEB_NO(String PAGWEB_NO) {
        this.PAGWEB_NO = PAGWEB_NO;
    }

    public String getPAGWEB() {
        return PAGWEB;
    }

    public void setPAGWEB(String PAGWEB) {
        this.PAGWEB = PAGWEB;
    }

    public String getCORREO_NO() {
        return CORREO_NO;
    }

    public void setCORREO_NO(String CORREO_NO) {
        this.CORREO_NO = CORREO_NO;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getTELFIJO_NO() {
        return TELFIJO_NO;
    }

    public void setTELFIJO_NO(String TELFIJO_NO) {
        this.TELFIJO_NO = TELFIJO_NO;
    }

    public String getTELFIJO() {
        return TELFIJO;
    }

    public void setTELFIJO(String TELFIJO) {
        this.TELFIJO = TELFIJO;
    }

    public String getTELMOVIL_NO() {
        return TELMOVIL_NO;
    }

    public void setTELMOVIL_NO(String TELMOVIL_NO) {
        this.TELMOVIL_NO = TELMOVIL_NO;
    }

    public String getTELMOVIL() {
        return TELMOVIL;
    }

    public void setTELMOVIL(String TELMOVIL) {
        this.TELMOVIL = TELMOVIL;
    }

    public String getCOND_APEL_NOM() {
        return COND_APEL_NOM;
    }

    public void setCOND_APEL_NOM(String COND_APEL_NOM) {
        this.COND_APEL_NOM = COND_APEL_NOM;
    }

    public String getCOND_SEXO() {
        return COND_SEXO;
    }

    public void setCOND_SEXO(String COND_SEXO) {
        this.COND_SEXO = COND_SEXO;
    }

    public String getCOND_EDAD() {
        return COND_EDAD;
    }

    public void setCOND_EDAD(String COND_EDAD) {
        this.COND_EDAD = COND_EDAD;
    }

    public String getCOND_NEST() {
        return COND_NEST;
    }

    public void setCOND_NEST(String COND_NEST) {
        this.COND_NEST = COND_NEST;
    }

    public String getINFOR_CARGO() {
        return INFOR_CARGO;
    }

    public void setINFOR_CARGO(String INFOR_CARGO) {
        this.INFOR_CARGO = INFOR_CARGO;
    }

    public String getINFOR_CARGO_O() {
        return INFOR_CARGO_O;
    }

    public void setINFOR_CARGO_O(String INFOR_CARGO_O) {
        this.INFOR_CARGO_O = INFOR_CARGO_O;
    }

    public String getINFOR_APEL_NOM() {
        return INFOR_APEL_NOM;
    }

    public void setINFOR_APEL_NOM(String INFOR_APEL_NOM) {
        this.INFOR_APEL_NOM = INFOR_APEL_NOM;
    }

    public String getCONOCE_INACAL() {
        return CONOCE_INACAL;
    }

    public void setCONOCE_INACAL(String CONOCE_INACAL) {
        this.CONOCE_INACAL = CONOCE_INACAL;
    }


    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(21);
        contentValues.put(SQLConstantes.IDENTIFICACION_ID,ID);
        contentValues.put(SQLConstantes.IDENTIFICACION_RUC,NUM_RUC);
        contentValues.put(SQLConstantes.IDENTIFICACION_RAZON,RAZON_SOCIAL);
        contentValues.put(SQLConstantes.IDENTIFICACION_NOMBRE,NOM_COMER_MYPE);
        contentValues.put(SQLConstantes.IDENTIFICACION_ANIO_FUNCIONAMIENTO,ANO_INI);
        contentValues.put(SQLConstantes.IDENTIFICACION_WEBNO,PAGWEB_NO);
        contentValues.put(SQLConstantes.IDENTIFICACION_WEB,PAGWEB);
        contentValues.put(SQLConstantes.IDENTIFICACION_CORREONO,CORREO_NO);
        contentValues.put(SQLConstantes.IDENTIFICACION_CORREO,CORREO);
        contentValues.put(SQLConstantes.IDENTIFICACION_FIJONO,TELFIJO_NO);
        contentValues.put(SQLConstantes.IDENTIFICACION_FIJO,TELFIJO);
        contentValues.put(SQLConstantes.IDENTIFICACION_MOVILNO,TELMOVIL_NO);
        contentValues.put(SQLConstantes.IDENTIFICACION_MOVIL,TELMOVIL);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_NOMBRE,COND_APEL_NOM);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_SEXO,COND_SEXO);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_EDAD,COND_EDAD);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_ESTUDIOS,COND_NEST);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO,INFOR_CARGO);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO_ESP,INFOR_CARGO_O);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_APEYNOM,INFOR_APEL_NOM);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_CONOCE_INACAL,CONOCE_INACAL);
        return contentValues;

    }

}