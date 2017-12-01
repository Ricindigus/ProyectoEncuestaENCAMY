package com.example.administrador.encal.Pojos;

import android.content.ContentValues;

import com.example.administrador.encal.Modelo.SQLConstantes;

/**
 * Created by USUARIO on 16/11/2017.
 */

public class Sec200PojoF1 {

    private String ID;
    private String P_201_1;
    private String P_201_2;
    private String P_201_3;
    private String P_201_4;

    private String P_202;

    private String P_203;
    private String P_203_O;

    private String P_204;

    private String P_205_1;
    private String P_205_2;
    private String P_205_3;
    private String P_205_4;
    private String P_205_5;
    private String P_205_6;
    private String P_205_6_O;
    private String OBS;

    public Sec200PojoF1() {
        this.ID = "";
        P_201_1 = "";
        P_201_2 = "";
        P_201_3 = "";
        P_201_4 = "";
        P_202 = "";
        P_203 = "";
        P_203_O = "";
        P_204 = "";
        P_205_1 = "";
        P_205_2 = "";
        P_205_3 = "";
        P_205_4 = "";
        P_205_5 = "";
        P_205_6 = "";
        P_205_6_O = "";
        this.OBS = "";
    }

    public Sec200PojoF1(String ID, String p_201_1, String p_201_2, String p_201_3, String p_201_4, String p_202, String p_203, String p_203_O, String p_204, String p_205_1, String p_205_2, String p_205_3, String p_205_4, String p_205_5, String p_205_6, String p_205_6_O, String OBS) {
        this.ID = ID;
        P_201_1 = p_201_1;
        P_201_2 = p_201_2;
        P_201_3 = p_201_3;
        P_201_4 = p_201_4;
        P_202 = p_202;
        P_203 = p_203;
        P_203_O = p_203_O;
        P_204 = p_204;
        P_205_1 = p_205_1;
        P_205_2 = p_205_2;
        P_205_3 = p_205_3;
        P_205_4 = p_205_4;
        P_205_5 = p_205_5;
        P_205_6 = p_205_6;
        P_205_6_O = p_205_6_O;
        this.OBS = OBS;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getP_201_1() {
        return P_201_1;
    }

    public void setP_201_1(String p_201_1) {
        P_201_1 = p_201_1;
    }

    public String getP_201_2() {
        return P_201_2;
    }

    public void setP_201_2(String p_201_2) {
        P_201_2 = p_201_2;
    }

    public String getP_201_3() {
        return P_201_3;
    }

    public void setP_201_3(String p_201_3) {
        P_201_3 = p_201_3;
    }

    public String getP_201_4() {
        return P_201_4;
    }

    public void setP_201_4(String p_201_4) {
        P_201_4 = p_201_4;
    }

    public String getP_202() {
        return P_202;
    }

    public void setP_202(String p_202) {
        P_202 = p_202;
    }

    public String getP_203() {
        return P_203;
    }

    public void setP_203(String p_203) {
        P_203 = p_203;
    }

    public String getP_203_O() {
        return P_203_O;
    }

    public void setP_203_O(String p_203_O) {
        P_203_O = p_203_O;
    }

    public String getP_204() {
        return P_204;
    }

    public void setP_204(String p_204) {
        P_204 = p_204;
    }

    public String getP_205_1() {
        return P_205_1;
    }

    public void setP_205_1(String p_205_1) {
        P_205_1 = p_205_1;
    }

    public String getP_205_2() {
        return P_205_2;
    }

    public void setP_205_2(String p_205_2) {
        P_205_2 = p_205_2;
    }

    public String getP_205_3() {
        return P_205_3;
    }

    public void setP_205_3(String p_205_3) {
        P_205_3 = p_205_3;
    }

    public String getP_205_4() {
        return P_205_4;
    }

    public void setP_205_4(String p_205_4) {
        P_205_4 = p_205_4;
    }

    public String getP_205_5() {
        return P_205_5;
    }

    public void setP_205_5(String p_205_5) {
        P_205_5 = p_205_5;
    }

    public String getP_205_6() {
        return P_205_6;
    }

    public void setP_205_6(String p_205_6) {
        P_205_6 = p_205_6;
    }

    public String getP_205_6_O() {
        return P_205_6_O;
    }

    public void setP_205_6_O(String p_205_6_O) {
        P_205_6_O = p_205_6_O;
    }

    public String getOBS() {
        return OBS;
    }

    public void setOBS(String OBS) {
        this.OBS = OBS;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(17);
        contentValues.put(SQLConstantes.SECCION200_ID,ID);
        contentValues.put(SQLConstantes.SECCION200_P_201_1,P_201_1);
        contentValues.put(SQLConstantes.SECCION200_P_201_2,P_201_2);
        contentValues.put(SQLConstantes.SECCION200_P_201_3,P_201_3);
        contentValues.put(SQLConstantes.SECCION200_P_201_4,P_201_4);
        contentValues.put(SQLConstantes.SECCION200_P_202,P_202);
        contentValues.put(SQLConstantes.SECCION200_P_203,P_203);
        contentValues.put(SQLConstantes.SECCION200_P_203_O,P_203_O);
        contentValues.put(SQLConstantes.SECCION200_P_204,P_204);
        contentValues.put(SQLConstantes.SECCION200_P_205_1,P_205_1);
        contentValues.put(SQLConstantes.SECCION200_P_205_2,P_205_2);
        contentValues.put(SQLConstantes.SECCION200_P_205_3,P_205_3);
        contentValues.put(SQLConstantes.SECCION200_P_205_4,P_205_4);
        contentValues.put(SQLConstantes.SECCION200_P_205_5,P_205_5);
        contentValues.put(SQLConstantes.SECCION200_P_205_6,P_205_6);
        contentValues.put(SQLConstantes.SECCION200_P_205_6_O,P_205_6_O);
        contentValues.put(SQLConstantes.SECCION200_OBS,OBS);
        return contentValues;

    }
}