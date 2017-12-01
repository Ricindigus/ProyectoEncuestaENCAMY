package com.example.administrador.encal.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrador.encal.Pojos.BDFragment;
import com.example.administrador.encal.Pojos.CaratulaPojo;
import com.example.administrador.encal.Pojos.IdentificacionPojo;
import com.example.administrador.encal.Pojos.Marco;
import com.example.administrador.encal.Pojos.Sec100PojoF1;
import com.example.administrador.encal.Pojos.Sec200PojoF1;
import com.example.administrador.encal.Pojos.Sec300PojoF1;
import com.example.administrador.encal.Pojos.Sec400PojoF1;
import com.example.administrador.encal.Pojos.Ubigeo;
import com.example.administrador.encal.Pojos.Usuario;

import java.util.ArrayList;

/**
 * Created by mcarazas on 27/11/2017.
 */

public class Data {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public Data(Context contexto) {
        this.contexto = contexto;
        sqLiteOpenHelper = new DBHelper(contexto);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }

    public long getNumeroItemsMarco(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tableMarco);
    }
    public long getNumeroItemsUsuario(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tableUsuarios);
    }
    public long getNumeroItemsUbigeo(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tableUbigeo);
    }
    public long getNumeroItemsVisita(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tableVisitas);
    }
    public long getNumeroItemsCaratula(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tableCaratulas);
    }
    public long getNumeroItemsIdentificacion(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tableIdentificaciones);
    }
    public long getNumeroItemsFragment(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tableFragments);
    }
    public long getNumeroItemsModulo1(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tableModulo1);
    }
    public long getNumeroItemsModulo2(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tableModulo2);
    }
    public long getNumeroItemsModulo3(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tableModulo3);
    }
    public long getNumeroItemsModulo4(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tableModulo4);
    }

    //------------------------------------------MARCO---------------------------------------------------------------------
    public Marco getMarco(String idEmpresa){
        Marco marco = new Marco();
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableMarco,
                    SQLConstantes.ALL_COLUMNS_MARCO,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                marco.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_ID)));
                marco.setRUC(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_RUC)));
                marco.setRAZON_SOCIAL(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_RAZON_SOCIAL)));
                marco.setNOMBRE_COMERCIAL(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_NOMBRE_COMERCIAL)));
                marco.setOPERADOR(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_OPERADOR)));
                marco.setJEFE(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_JEFE)));
                marco.setOBSERVADOR(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_OBSERVADOR)));
                marco.setANIO(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_ANIO)));
                marco.setMES(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_MES)));
                marco.setPERIODO(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_PERIODO)));
                marco.setCCDD(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_CCDD)));
                marco.setDEPARTAMENTO(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_DEPARTAMENTO)));
                marco.setCCPP(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_CCPP)));
                marco.setPROVINCIA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_PROVINCIA)));
                marco.setCCDI(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_CCDI)));
                marco.setDISTRITO(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_DISTRITO)));
                marco.setT_EMPRESA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_T_EMPRESA)));
                marco.setFRENTE(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_FRENTE)));
                marco.setZONA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_ZONA)));
                marco.setMANZANA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_MANZANA)));
                marco.setCAT_VIA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_CAT_VIA)));
                marco.setNOM_VIA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_NOM_VIA)));
                marco.setPUERTA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_PUERTA)));
                marco.setINTERIOR(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_INTERIOR)));
                marco.setPISO(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_PISO)));
                marco.setMZ(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_MZ)));
                marco.setLOTE(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_LOTE)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return marco;
    }
    public ArrayList<Marco> getAllMarcos(String idUsuario, int permisoUsuario){
        ArrayList<Marco> marcos = new ArrayList<Marco>();
        String[] whereArgs = new String[]{String.valueOf(idUsuario)};
        Cursor cursor = null;
        try{
            switch (permisoUsuario){
                case 1: cursor = sqLiteDatabase.query(SQLConstantes.tableMarco, SQLConstantes.ALL_COLUMNS_MARCO,
                        SQLConstantes.WHERE_CLAUSE_ID_OPERADOR,whereArgs,null,null,null);break;
                case 2: cursor = sqLiteDatabase.query(SQLConstantes.tableMarco, SQLConstantes.ALL_COLUMNS_MARCO,
                        SQLConstantes.WHERE_CLAUSE_ID_JEFE,whereArgs,null,null,null);break;
                case 3: cursor = sqLiteDatabase.query(SQLConstantes.tableMarco, SQLConstantes.ALL_COLUMNS_MARCO,
                        SQLConstantes.WHERE_CLAUSE_ID_OBSERVADOR,whereArgs,null,null,null);break;
            }

            while(cursor.moveToNext()){
                Marco marco = new Marco();
                marco.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_ID)));
                marco.setRUC(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_RUC)));
                marco.setRAZON_SOCIAL(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_RAZON_SOCIAL)));
                marco.setNOMBRE_COMERCIAL(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_NOMBRE_COMERCIAL)));
                marco.setOPERADOR(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_OPERADOR)));
                marco.setJEFE(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_JEFE)));
                marco.setOBSERVADOR(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_OBSERVADOR)));
                marco.setANIO(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_ANIO)));
                marco.setMES(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_MES)));
                marco.setPERIODO(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_PERIODO)));
                marco.setCCDD(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_CCDD)));
                marco.setDEPARTAMENTO(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_DEPARTAMENTO)));
                marco.setCCPP(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_CCPP)));
                marco.setPROVINCIA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_PROVINCIA)));
                marco.setCCDI(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_CCDI)));
                marco.setDISTRITO(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_DISTRITO)));
                marco.setT_EMPRESA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_T_EMPRESA)));
                marco.setFRENTE(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_FRENTE)));
                marco.setZONA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_ZONA)));
                marco.setMANZANA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_MANZANA)));
                marco.setCAT_VIA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_CAT_VIA)));
                marco.setNOM_VIA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_NOM_VIA)));
                marco.setPUERTA(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_PUERTA)));
                marco.setINTERIOR(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_INTERIOR)));
                marco.setPISO(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_PISO)));
                marco.setMZ(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_MZ)));
                marco.setLOTE(cursor.getString(cursor.getColumnIndex(SQLConstantes.MARCO_LOTE)));
                marcos.add(marco);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return marcos;
    }

    public void insertarMarco(Marco marco){
        ContentValues contentValues = marco.toValues();
        sqLiteDatabase.insert(SQLConstantes.tableMarco,null,contentValues);
    }
    public void InsertarMarcos(ArrayList<Marco> empresas){
        long items = getNumeroItemsMarco();
        if(items == 0){
            for (Marco empresa : empresas) {
                try {
                    insertarMarco(empresa);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    //----------------------------------------FIN MARCO--------------------------------------------------

    //----------------------USUARIOS-----------------------------------------------------------------------------------------
    public void insertarUsuario(Usuario usuario){
        ContentValues contentValues = usuario.toValues();
        sqLiteDatabase.insert(SQLConstantes.tableUsuarios,null,contentValues);
    }
    public void insertarUsuarios(ArrayList<Usuario> usuarios){
        long items = getNumeroItemsUsuario();
        if(items == 0){
            for (Usuario usuario : usuarios) {
                try {
                    insertarUsuario(usuario);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public Usuario getUsuario(String idUsuario){
        Usuario usuario = new Usuario();
        String[] whereArgs = new String[]{idUsuario};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableUsuarios,
                    SQLConstantes.ALL_COLUMNS_USUARIOS,SQLConstantes.WHERE_CLAUSE_ID_USUARIO,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                usuario.setUSUARIO_ID(cursor.getString(cursor.getColumnIndex(SQLConstantes.USUARIO_ID)));
                usuario.setUSUARIO_PASSWORD(cursor.getString(cursor.getColumnIndex(SQLConstantes.USUARIO_PASSWORD)));
                usuario.setUSUARIO_PERMISO(cursor.getString(cursor.getColumnIndex(SQLConstantes.USUARIO_PERMISO)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return usuario;
    }
    //------------------FIN USUARIO-----------------------------------------------------------------------------------------------------
    //----------------------UBIGEOS-------------------------------------------------------------------------------------------------------
    public void insertarUbigeo(Ubigeo ubigeo){
        ContentValues contentValues = ubigeo.toValues();
        sqLiteDatabase.insert(SQLConstantes.tableUbigeo,null,contentValues);
    }
    public void insertarUbigeos(ArrayList<Ubigeo> ubigeos){
        long items = getNumeroItemsUbigeo();
        if(items == 0){
            for (Ubigeo ubigeo : ubigeos) {
                try {
                    insertarUbigeo(ubigeo);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public ArrayList<String> getUbigeos(String idUbi){
        ArrayList<String> ubigeos = new ArrayList<String>();
        ubigeos.add("Seleccione");
        String[] whereArgs = new String[]{idUbi};
        long items = getNumeroItemsUbigeo();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableUbigeo,
                    SQLConstantes.ALL_COLUMNS_UBIGEOS,SQLConstantes.WHERE_CLAUSE_ID_UBIGEO,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                ubigeos.add(cursor.getString(cursor.getColumnIndex(SQLConstantes.UBIGEO_DISTRITO)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return ubigeos;
    }
    //------------------FIN UBIGEO-----------------------------------------------------------------------------------------------------

    //------------------CARATULA-------------------------------------------------------------------------------------------------------

    public void insertarCaratula(CaratulaPojo caratula){
        ContentValues contentValues = caratula.toValues();
        sqLiteDatabase.insert(SQLConstantes.tableCaratulas,null,contentValues);
    }
    public void InsertarCaratulas(ArrayList<CaratulaPojo> caratulas){
        long items = getNumeroItemsCaratula();
        if(items == 0){
            for (CaratulaPojo caratula : caratulas) {
                try {
                    insertarCaratula(caratula);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void actualizarCaratula(String idEmpresa, ContentValues contentValues){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.update(SQLConstantes.tableCaratulas,contentValues,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }
    public boolean existeCaratula(String idEmpresa){
        boolean encontrado = false;
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableCaratulas,
                    SQLConstantes.ALL_COLUMNS_CARATULA,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1) encontrado = true;
        }finally {
            if(cursor != null)cursor.close();
        }
        return encontrado;
    }
    public CaratulaPojo getCaratula(String idEmpresa){
        CaratulaPojo caratula = new CaratulaPojo();
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableCaratulas,
                    SQLConstantes.ALL_COLUMNS_CARATULA,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                caratula.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_ID)));
                caratula.setNOMBREDD(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_DEPARTAMENTO)));
                caratula.setCCDD(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_DEPARTAMENTO_COD)));
                caratula.setNOMBREPV(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_PROVINCIA)));
                caratula.setCCPP(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_PROVINCIA_COD)));
                caratula.setNOMBREDI(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_DISTRITO)));
                caratula.setCCDI(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_DISTRITO_COD)));
                caratula.setGPSLATITUD(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_GPSLATITUD)));
                caratula.setGPSLONGITUD(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_GPSLONGITUD)));
                caratula.setSECTOR_TR(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_SECTOR)));
                caratula.setARA_TR(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_AREA)));
                caratula.setZONA(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_ZONA)));
                caratula.setMANZANA_ID(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_MANZANA_MUESTRA)));
                caratula.setFRENTE(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_FRENTE)));
                caratula.setTIPVIA(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_TIPVIA)));
                caratula.setTIPVIA_ESPEC(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_TIPVIA_OTRO)));
                caratula.setTIPVIA_D(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_NOMVIA)));
                caratula.setNROPTA(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_NPUERTA)));
                caratula.setBLOCK(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_BLOCK)));
                caratula.setINTERIOR(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_INTERIOR)));
                caratula.setPISO(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_PISO)));
                caratula.setMZA(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_MANZANA_VIA)));
                caratula.setLOTE(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_LOTE)));
                caratula.setKM(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_KM)));
                caratula.setREF_DIREC(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_REFERENCIA)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return caratula;
    }

    public ArrayList<CaratulaPojo> getAllCaratulas(){
        ArrayList<CaratulaPojo> caratulas = new ArrayList<CaratulaPojo>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableCaratulas,
                    SQLConstantes.ALL_COLUMNS_CARATULA,null,null,null,null,null);
            while(cursor.moveToNext()) {
                CaratulaPojo caratula = new CaratulaPojo();
                caratula.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_ID)));
                caratula.setNOMBREDD(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_DEPARTAMENTO)));
                caratula.setCCDD(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_DEPARTAMENTO_COD)));
                caratula.setNOMBREPV(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_PROVINCIA)));
                caratula.setCCPP(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_PROVINCIA_COD)));
                caratula.setNOMBREDI(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_DISTRITO)));
                caratula.setCCDI(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_DISTRITO_COD)));
                caratula.setGPSLATITUD(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_GPSLATITUD)));
                caratula.setGPSLONGITUD(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_GPSLONGITUD)));
                caratula.setSECTOR_TR(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_SECTOR)));
                caratula.setARA_TR(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_AREA)));
                caratula.setZONA(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_ZONA)));
                caratula.setMANZANA_ID(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_MANZANA_MUESTRA)));
                caratula.setFRENTE(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_FRENTE)));
                caratula.setTIPVIA(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_TIPVIA)));
                caratula.setTIPVIA_ESPEC(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_TIPVIA_OTRO)));
                caratula.setTIPVIA_D(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_NOMVIA)));
                caratula.setNROPTA(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_NPUERTA)));
                caratula.setBLOCK(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_BLOCK)));
                caratula.setINTERIOR(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_INTERIOR)));
                caratula.setPISO(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_PISO)));
                caratula.setMZA(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_MANZANA_VIA)));
                caratula.setLOTE(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_LOTE)));
                caratula.setKM(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_KM)));
                caratula.setREF_DIREC(cursor.getString(cursor.getColumnIndex(SQLConstantes.CARATULA_REFERENCIA)));
                caratulas.add(caratula);
            }
        }finally {
            if(cursor!=null) cursor.close();
        }
        return caratulas;
    }
    public void deleteCaratula(String idEmpresa){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.delete(SQLConstantes.tableCaratulas,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }

//-----------------------------------------FIN CARATULA-------------------------------------------------------------------------------

    //----------------------------------------IDENTIFICACION---------------------------------------------------------------------------
    public void insertarIdentificacion(IdentificacionPojo identificacion){
        ContentValues contentValues = identificacion.toValues();
        sqLiteDatabase.insert(SQLConstantes.tableIdentificaciones,null,contentValues);
    }

    public void InsertarIdentificaciones(ArrayList<IdentificacionPojo> identificaciones){
        long items = getNumeroItemsIdentificacion();
        if(items == 0){
            for (IdentificacionPojo identificacion : identificaciones) {
                try {
                    insertarIdentificacion(identificacion);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean existeIdentificacion(String idEmpresa){
        boolean encontrado = false;
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableIdentificaciones,
                    SQLConstantes.ALL_COLUMNS_IDENTIFICACIONES,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1) encontrado = true;
        }finally {
            if(cursor != null)cursor.close();
        }
        return encontrado;
    }

    public void actualizarIdentificacion(String idEmpresa, ContentValues contentValues){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.update(SQLConstantes.tableIdentificaciones,contentValues,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }

    public IdentificacionPojo getIdentificacion(String idEmpresa){
        IdentificacionPojo identificacion = new IdentificacionPojo();
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableIdentificaciones,
                    SQLConstantes.ALL_COLUMNS_IDENTIFICACIONES,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                identificacion.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_ID)));
                identificacion.setNUM_RUC(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_RUC)));
                identificacion.setRAZON_SOCIAL(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_RAZON)));
                identificacion.setNOM_COMER_MYPE(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_NOMBRE)));
                identificacion.setANO_INI(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_ANIO_FUNCIONAMIENTO)));
                identificacion.setPAGWEB_NO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_WEBNO)));
                identificacion.setPAGWEB(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_WEB)));
                identificacion.setCORREO_NO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CORREONO)));
                identificacion.setCORREO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CORREO)));
                identificacion.setTELFIJO_NO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_FIJONO)));
                identificacion.setTELFIJO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_FIJO)));
                identificacion.setTELMOVIL_NO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_MOVILNO)));
                identificacion.setTELMOVIL(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_MOVIL)));
                identificacion.setCOND_APEL_NOM(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_NOMBRE)));
                identificacion.setCOND_SEXO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_SEXO)));
                identificacion.setCOND_EDAD(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_EDAD)));
                identificacion.setCOND_NEST(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_ESTUDIOS)));
                identificacion.setINFOR_CARGO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO)));
                identificacion.setINFOR_CARGO_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO_ESP)));
                identificacion.setINFOR_APEL_NOM(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_APEYNOM)));
                identificacion.setCONOCE_INACAL(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_CONOCE_INACAL)));
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return identificacion;
    }

    public ArrayList<IdentificacionPojo> getAllIdentificaciones(){
        ArrayList<IdentificacionPojo> identificaciones = new ArrayList<IdentificacionPojo>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableIdentificaciones,
                    SQLConstantes.ALL_COLUMNS_IDENTIFICACIONES,null,null,null,null,null);
            while(cursor.moveToNext()){
                IdentificacionPojo identificacion = new IdentificacionPojo();
                identificacion.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_ID)));
                identificacion.setNUM_RUC(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_RUC)));
                identificacion.setRAZON_SOCIAL(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_RAZON)));
                identificacion.setNOM_COMER_MYPE(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_NOMBRE)));
                identificacion.setANO_INI(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_ANIO_FUNCIONAMIENTO)));
                identificacion.setPAGWEB_NO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_WEBNO)));
                identificacion.setPAGWEB(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_WEB)));
                identificacion.setCORREO_NO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CORREONO)));
                identificacion.setCORREO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CORREO)));
                identificacion.setTELFIJO_NO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_FIJONO)));
                identificacion.setTELFIJO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_FIJO)));
                identificacion.setTELMOVIL_NO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_MOVILNO)));
                identificacion.setTELMOVIL(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_MOVIL)));
                identificacion.setCOND_APEL_NOM(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_NOMBRE)));
                identificacion.setCOND_SEXO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_SEXO)));
                identificacion.setCOND_EDAD(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_EDAD)));
                identificacion.setCOND_NEST(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_ESTUDIOS)));
                identificacion.setINFOR_CARGO(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO)));
                identificacion.setINFOR_CARGO_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO_ESP)));
                identificacion.setINFOR_APEL_NOM(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_APEYNOM)));
                identificacion.setCONOCE_INACAL(cursor.getString(cursor.getColumnIndex(SQLConstantes.IDENTIFICACION_CONDUCTOR_CONOCE_INACAL)));
                identificaciones.add(identificacion);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return identificaciones;
    }
    public void deleteIdentificacion(String idEmpresa){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.delete(SQLConstantes.tableIdentificaciones,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }
    //-----------------FIN IDENTIFICACION----------------------------------------------------------------------------------------------
    //----------------FRAGMENTS-----------------------------------------------------------------------------------------------
    public BDFragment getFragment(String idFragment){
        BDFragment bdFragment = new BDFragment();
        String[] whereArgs = new String[]{idFragment};
        Cursor cursor = null;
        try {
            cursor = sqLiteDatabase.query(SQLConstantes.tableFragments,
                    SQLConstantes.ALL_COLUMNS_FRAGMENTS, SQLConstantes.WHERE_CLAUSE_ID_EMPRESA, whereArgs, null, null, null);
            if (cursor.getCount() == 1) {
                cursor.moveToFirst();
                bdFragment.setFRAGMENT_ID(cursor.getString(cursor.getColumnIndex(SQLConstantes.FRAGMENT_ID)));
                bdFragment.setFRAGMENT_HABILITADO(cursor.getString(cursor.getColumnIndex(SQLConstantes.FRAGMENT_HABILITADO)));
                bdFragment.setFRAGMENT_AVANCE(cursor.getString(cursor.getColumnIndex(SQLConstantes.FRAGMENT_AVANCE)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor != null) cursor.close();
        }
        return bdFragment;
    }

    public boolean existeFragment(String idFragment){
        boolean encontrado = false;
        String[] whereArgs = new String[]{idFragment};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableFragments,
                    SQLConstantes.ALL_COLUMNS_FRAGMENTS,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1) encontrado = true;
        }finally {
            if(cursor != null){
                cursor.close();
            }
        }
        return encontrado;
    }

    public void insertarFragment(BDFragment bdFragment){
        ContentValues contentValues = bdFragment.toValues();
        sqLiteDatabase.insert(SQLConstantes.tableFragments,null,contentValues);
    }

    public void insertarFragments(ArrayList<BDFragment> bdFragments){
        long items = getNumeroItemsFragment();
        for (BDFragment bdFragment : bdFragments) {
            try {
                insertarFragment(bdFragment);
            }catch (SQLiteException e){
                e.printStackTrace();
            }

        }

    }
    public void actualizarFragment(String idFragment, ContentValues contentValues){
        String[] whereArgs = new String[]{idFragment};
        sqLiteDatabase.update(SQLConstantes.tableFragments,contentValues,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }
//------------------------------------------FIN FRAGMENTS--------------------------------------------------------------------------


    //--------------------------------------MODULO1------------------------------------------------------------------------------------
    public Sec100PojoF1 getModulo1(String idEmpresa){
        Sec100PojoF1 modulo1 = new Sec100PojoF1();
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableModulo1,
                    SQLConstantes.ALL_COLUMNS_SECCION100,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                modulo1.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_ID)));
                modulo1.setP_101(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_101)));
                modulo1.setP_101_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_101_1)));
                modulo1.setP_101_1_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_101_1_O)));
                modulo1.setP_102A(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102A)));
                modulo1.setP_102_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102_1)));
                modulo1.setP_102B(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102B)));
                modulo1.setP_102_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102_2)));
                modulo1.setP_102C(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102C)));
                modulo1.setP_102_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102_3)));
                modulo1.setP_102D(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102D)));
                modulo1.setP_102_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102_4)));
                modulo1.setP_103(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_103)));
                modulo1.setP_103_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_103_O)));
                modulo1.setP_104(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_104)));
                modulo1.setP_105(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_105)));
                modulo1.setP_106_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_106_1)));
                modulo1.setP_106_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_106_2)));
                modulo1.setP_106_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_106_3)));
                modulo1.setP_106_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_106_4)));
                modulo1.setP_106_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_106_5)));
                modulo1.setP_107_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_107_1)));
                modulo1.setP_107_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_107_2)));
                modulo1.setP_107_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_107_3)));
                modulo1.setP_108(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_108)));
                modulo1.setP_109_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_1)));
                modulo1.setP_109_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_2)));
                modulo1.setP_109_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_3)));
                modulo1.setP_109_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_4)));
                modulo1.setP_109_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_5)));
                modulo1.setP_109_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_6)));
                modulo1.setP_109_6_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_6_O)));
                modulo1.setP_110_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_1)));
                modulo1.setP_110_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_2)));
                modulo1.setP_110_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_3)));
                modulo1.setP_110_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_4)));
                modulo1.setP_110_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_5)));
                modulo1.setP_110_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_6)));
                modulo1.setP_110_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_7)));
                modulo1.setP_110_7_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_7_O)));
                modulo1.setP_111(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_111)));
                modulo1.setP_112(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_112)));
                modulo1.setP_112_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_112_O)));
                modulo1.setP_113_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_113_1)));
                modulo1.setP_113_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_113_2)));
                modulo1.setP_113_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_113_3)));
                modulo1.setP_113_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_113_4)));
                modulo1.setP_113_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_113_5)));
                modulo1.setP_113_5_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_113_5_O)));
                modulo1.setP_114_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_1)));
                modulo1.setP_114_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_2)));
                modulo1.setP_114_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_3)));
                modulo1.setP_114_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_4)));
                modulo1.setP_114_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_5)));
                modulo1.setP_114_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_6)));
                modulo1.setP_114_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_7)));
                modulo1.setP_114_7_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_7_O)));
                modulo1.setOBS(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_OBS)));

            }
        }finally {
            if(cursor != null)cursor.close();
        }
        return modulo1;
    };

    public boolean existeModulo1(String idEmpresa){
        boolean encontrado = false;
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableModulo1,
                    SQLConstantes.ALL_COLUMNS_SECCION100,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1) encontrado = true;
        }finally {
            if(cursor != null)cursor.close();
        }
        return encontrado;
    }

    public void insertarModulo1(Sec100PojoF1 modulo1){
        ContentValues contentValues = modulo1.toValues();
        sqLiteDatabase.insert(SQLConstantes.tableModulo1,null,contentValues);
    }

    public void insertarModulos1(ArrayList<Sec100PojoF1> modulos1){
        long items = getNumeroItemsModulo1();
        if(items == 0){
            for (Sec100PojoF1 modulo1 : modulos1) {
                try {
                    insertarModulo1(modulo1);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void actualizarModulo1(String idempresa, ContentValues contentValues){
        String[] whereArgs = new String[]{idempresa};
        sqLiteDatabase.update(SQLConstantes.tableModulo1,contentValues,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }

    public ArrayList<Sec100PojoF1> getAllModulo1(){
        ArrayList<Sec100PojoF1> modulos1 = new ArrayList<Sec100PojoF1>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tableModulo1,
                    SQLConstantes.ALL_COLUMNS_SECCION100,null,null,null,null,null);
            while(cursor.moveToNext()){
                Sec100PojoF1 modulo1 = new Sec100PojoF1();
                modulo1.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_ID)));
                modulo1.setP_101(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_101)));
                modulo1.setP_101_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_101_1)));
                modulo1.setP_101_1_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_101_1_O)));
                modulo1.setP_102A(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102A)));
                modulo1.setP_102_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102_1)));
                modulo1.setP_102B(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102B)));
                modulo1.setP_102_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102_2)));
                modulo1.setP_102C(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102C)));
                modulo1.setP_102_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102_3)));
                modulo1.setP_102D(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102D)));
                modulo1.setP_102_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_102_4)));
                modulo1.setP_103(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_103)));
                modulo1.setP_103_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_103_O)));
                modulo1.setP_104(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_104)));
                modulo1.setP_105(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_105)));
                modulo1.setP_106_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_106_1)));
                modulo1.setP_106_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_106_2)));
                modulo1.setP_106_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_106_3)));
                modulo1.setP_106_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_106_4)));
                modulo1.setP_106_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_106_5)));
                modulo1.setP_107_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_107_1)));
                modulo1.setP_107_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_107_2)));
                modulo1.setP_107_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_107_3)));
                modulo1.setP_108(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_108)));
                modulo1.setP_109_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_1)));
                modulo1.setP_109_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_2)));
                modulo1.setP_109_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_3)));
                modulo1.setP_109_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_4)));
                modulo1.setP_109_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_5)));
                modulo1.setP_109_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_6)));
                modulo1.setP_109_6_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_109_6_O)));
                modulo1.setP_110_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_1)));
                modulo1.setP_110_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_2)));
                modulo1.setP_110_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_3)));
                modulo1.setP_110_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_4)));
                modulo1.setP_110_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_5)));
                modulo1.setP_110_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_6)));
                modulo1.setP_110_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_7)));
                modulo1.setP_110_7_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_110_7_O)));
                modulo1.setP_111(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_111)));
                modulo1.setP_112(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_112)));
                modulo1.setP_112_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_112_O)));
                modulo1.setP_113_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_113_1)));
                modulo1.setP_113_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_113_2)));
                modulo1.setP_113_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_113_3)));
                modulo1.setP_113_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_113_4)));
                modulo1.setP_113_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_113_5)));
                modulo1.setP_113_5_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_113_5_O)));
                modulo1.setP_114_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_1)));
                modulo1.setP_114_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_2)));
                modulo1.setP_114_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_3)));
                modulo1.setP_114_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_4)));
                modulo1.setP_114_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_5)));
                modulo1.setP_114_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_6)));
                modulo1.setP_114_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_7)));
                modulo1.setP_114_7_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_P_114_7_O)));
                modulo1.setOBS(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION100_OBS)));
                modulos1.add(modulo1);
            }
        }finally {
            if(cursor != null)cursor.close();
        }
        return modulos1;
    }
    public void deleteModulo1(String idEmpresa){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.delete(SQLConstantes.tableModulo1,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }
//----------------------------------------------FIN MODULO 1-----------------------------------------------------------------------

    //---------------------------------MODULO2-------------------------------------------------------------
    public Sec200PojoF1 getModulo2(String idEmpresa){
        Sec200PojoF1 modulo2 = new Sec200PojoF1();
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = sqLiteDatabase.query(SQLConstantes.tableModulo2,
                SQLConstantes.ALL_COLUMNS_SECCION200,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
        if(cursor.getCount() == 1){
            cursor.moveToFirst();
            modulo2.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_ID)));
            modulo2.setP_201_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_201_1)));
            modulo2.setP_201_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_201_2)));
            modulo2.setP_201_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_201_3)));
            modulo2.setP_201_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_201_4)));
            modulo2.setP_202(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_202)));
            modulo2.setP_203(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_203)));
            modulo2.setP_203_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_203_O)));
            modulo2.setP_204(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_204)));
            modulo2.setP_205_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_1)));
            modulo2.setP_205_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_2)));
            modulo2.setP_205_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_3)));
            modulo2.setP_205_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_4)));
            modulo2.setP_205_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_5)));
            modulo2.setP_205_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_6)));
            modulo2.setP_205_6_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_6_O)));
            modulo2.setOBS(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_OBS)));
        }
        cursor.close();
        return modulo2;
    }

    public ArrayList<Sec200PojoF1> getAllModulo2(){
        ArrayList<Sec200PojoF1> modulos2 = new ArrayList<Sec200PojoF1>();
        Cursor cursor = sqLiteDatabase.query(SQLConstantes.tableModulo2,
                SQLConstantes.ALL_COLUMNS_SECCION200,null,null,null,null,null);
        while(cursor.moveToNext()){
            Sec200PojoF1 modulo2 = new Sec200PojoF1();
            modulo2.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_ID)));
            modulo2.setP_201_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_201_1)));
            modulo2.setP_201_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_201_2)));
            modulo2.setP_201_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_201_3)));
            modulo2.setP_201_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_201_4)));
            modulo2.setP_202(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_202)));
            modulo2.setP_203(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_203)));
            modulo2.setP_203_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_203_O)));
            modulo2.setP_204(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_204)));
            modulo2.setP_205_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_1)));
            modulo2.setP_205_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_2)));
            modulo2.setP_205_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_3)));
            modulo2.setP_205_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_4)));
            modulo2.setP_205_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_5)));
            modulo2.setP_205_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_6)));
            modulo2.setP_205_6_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_P_205_6_O)));
            modulo2.setOBS(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION200_OBS)));
            modulos2.add(modulo2);
        }
        cursor.close();
        return modulos2;
    }
    public boolean existeModulo2(String idEmpresa){
        boolean encontrado = false;
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = sqLiteDatabase.query(SQLConstantes.tableModulo2,
                SQLConstantes.ALL_COLUMNS_SECCION200,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
        if(cursor.getCount() == 1) encontrado = true;
        cursor.close();
        return encontrado;
    }
    public void insertarModulo2(Sec200PojoF1 modulo2){
        ContentValues contentValues = modulo2.toValues();
        sqLiteDatabase.insert(SQLConstantes.tableModulo2,null,contentValues);
    }
    public void insertarModulos2(ArrayList<Sec200PojoF1> modulos2){
        long items = getNumeroItemsModulo2();
        if(items == 0){
            for (Sec200PojoF1 modulo2 : modulos2) {
                try {
                    insertarModulo2(modulo2);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void actualizarModulo2(String idempresa, ContentValues contentValues){
        String[] whereArgs = new String[]{idempresa};
        sqLiteDatabase.update(SQLConstantes.tableModulo2,contentValues,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }
    public void deleteModulo2(String idEmpresa){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.delete(SQLConstantes.tableModulo2,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }
    //-------------------------------------FIN MODULO2-----------------------------------------------------------------

//-----------------------------------------MODULO 3---------------------------------------------------------------

    public Sec300PojoF1 getModulo3(String idEmpresa){
        Sec300PojoF1 modulo3 = new Sec300PojoF1();
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = sqLiteDatabase.query(SQLConstantes.tableModulo3,
                SQLConstantes.ALL_COLUMNS_SECCION300,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
        if(cursor.getCount() == 1){
            cursor.moveToFirst();
            modulo3.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_ID)));
            modulo3.setP_301(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_301)));
            modulo3.setP_302(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302)));
            modulo3.setP_302A_M_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_M_1)));
            modulo3.setP_302A_M_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_M_2)));
            modulo3.setP_302A_M_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_M_3)));
            modulo3.setP_302A_M_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_M_4)));
            modulo3.setP_302A_M_4_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_M_4_O)));
            modulo3.setP_302A_L_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_L_1)));
            modulo3.setP_302A_L_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_L_2)));
            modulo3.setP_302A_L_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_L_3)));
            modulo3.setP_302A_L_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_L_4)));
            modulo3.setP_302A_L_4_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_L_4_O)));
            modulo3.setP_302A_P_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_P_1)));
            modulo3.setP_302A_P_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_P_2)));
            modulo3.setP_302A_P_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_P_3)));
            modulo3.setP_302A_P_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_P_4)));
            modulo3.setP_302A_P_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_P_5)));
            modulo3.setP_302A_P_5_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_P_5_O)));
            modulo3.setP_302A_T_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_T_1)));
            modulo3.setP_302A_T_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_T_2)));
            modulo3.setP_302A_T_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_T_3)));
            modulo3.setP_302A_T_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_T_4)));
            modulo3.setP_302A_T_4_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_T_4_O)));
            modulo3.setP_302A_V_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_V_1)));
            modulo3.setP_302A_V_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_V_2)));
            modulo3.setP_302A_V_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_V_3)));
            modulo3.setP_302A_V_3_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_V_3_O)));
            modulo3.setP_302A_O_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_O_1)));
            modulo3.setP_302A_O_1_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_O_1_O)));
            modulo3.setP_302B_M_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_M_1)));
            modulo3.setP_302B_M_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_M_2)));
            modulo3.setP_302B_M_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_M_3)));
            modulo3.setP_302B_M_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_M_4)));
            modulo3.setP_302B_L_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_L_1)));
            modulo3.setP_302B_L_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_L_2)));
            modulo3.setP_302B_L_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_L_3)));
            modulo3.setP_302B_L_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_L_4)));
            modulo3.setP_302B_P_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_P_1)));
            modulo3.setP_302B_P_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_P_2)));
            modulo3.setP_302B_P_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_P_3)));
            modulo3.setP_302B_P_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_P_4)));
            modulo3.setP_302B_P_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_P_5)));
            modulo3.setP_302B_T_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_T_1)));
            modulo3.setP_302B_T_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_T_2)));
            modulo3.setP_302B_T_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_T_3)));
            modulo3.setP_302B_T_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_T_4)));
            modulo3.setP_302B_V_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_V_1)));
            modulo3.setP_302B_V_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_V_2)));
            modulo3.setP_302B_V_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_V_3)));
            modulo3.setP_302B_O_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_O_1)));
            modulo3.setP_302C_M_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_M_1)));
            modulo3.setP_302C_M_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_M_2)));
            modulo3.setP_302C_M_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_M_3)));
            modulo3.setP_302C_M_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_M_4)));
            modulo3.setP_302C_L_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_L_1)));
            modulo3.setP_302C_L_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_L_2)));
            modulo3.setP_302C_L_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_L_3)));
            modulo3.setP_302C_L_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_L_4)));
            modulo3.setP_302C_P_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_P_1)));
            modulo3.setP_302C_P_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_P_2)));
            modulo3.setP_302C_P_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_P_3)));
            modulo3.setP_302C_P_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_P_4)));
            modulo3.setP_302C_P_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_P_5)));
            modulo3.setP_302C_T_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_T_1)));
            modulo3.setP_302C_T_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_T_2)));
            modulo3.setP_302C_T_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_T_3)));
            modulo3.setP_302C_T_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_T_4)));
            modulo3.setP_302C_V_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_V_1)));
            modulo3.setP_302C_V_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_V_2)));
            modulo3.setP_302C_V_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_V_3)));
            modulo3.setP_302C_O_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_O_1)));
            modulo3.setP_303_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_303_1)));
            modulo3.setP_303_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_303_2)));
            modulo3.setP_303_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_303_3)));
            modulo3.setP_303_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_303_4)));
            modulo3.setP_303_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_303_5)));
            modulo3.setP_304(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_304)));
            modulo3.setP_305(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_305)));
            modulo3.setOBS(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_OBS)));
        }
        cursor.close();
        return modulo3;
    }


    public boolean existeModulo3(String idEmpresa){
        boolean encontrado = false;
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = sqLiteDatabase.query(SQLConstantes.tableModulo3,
                SQLConstantes.ALL_COLUMNS_SECCION300,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
        if(cursor.getCount() == 1) encontrado = true;
        cursor.close();
        return encontrado;
    }

    public ArrayList<Sec300PojoF1> getAllModulo3(){
        ArrayList<Sec300PojoF1> modulos3 = new ArrayList<Sec300PojoF1>();
        Cursor cursor = sqLiteDatabase.query(SQLConstantes.tableModulo3,
                SQLConstantes.ALL_COLUMNS_SECCION300,null,null,null,null,null);
        while(cursor.moveToNext()){
            Sec300PojoF1 modulo3 = new Sec300PojoF1();
            modulo3.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_ID)));
            modulo3.setP_301(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_301)));
            modulo3.setP_302(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302)));
            modulo3.setP_302A_M_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_M_1)));
            modulo3.setP_302A_M_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_M_2)));
            modulo3.setP_302A_M_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_M_3)));
            modulo3.setP_302A_M_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_M_4)));
            modulo3.setP_302A_M_4_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_M_4_O)));
            modulo3.setP_302A_L_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_L_1)));
            modulo3.setP_302A_L_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_L_2)));
            modulo3.setP_302A_L_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_L_3)));
            modulo3.setP_302A_L_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_L_4)));
            modulo3.setP_302A_L_4_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_L_4_O)));
            modulo3.setP_302A_P_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_P_1)));
            modulo3.setP_302A_P_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_P_2)));
            modulo3.setP_302A_P_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_P_3)));
            modulo3.setP_302A_P_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_P_4)));
            modulo3.setP_302A_P_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_P_5)));
            modulo3.setP_302A_P_5_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_P_5_O)));
            modulo3.setP_302A_T_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_T_1)));
            modulo3.setP_302A_T_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_T_2)));
            modulo3.setP_302A_T_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_T_3)));
            modulo3.setP_302A_T_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_T_4)));
            modulo3.setP_302A_T_4_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_T_4_O)));
            modulo3.setP_302A_V_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_V_1)));
            modulo3.setP_302A_V_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_V_2)));
            modulo3.setP_302A_V_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_V_3)));
            modulo3.setP_302A_V_3_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_V_3_O)));
            modulo3.setP_302A_O_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_O_1)));
            modulo3.setP_302A_O_1_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302A_O_1_O)));
            modulo3.setP_302B_M_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_M_1)));
            modulo3.setP_302B_M_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_M_2)));
            modulo3.setP_302B_M_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_M_3)));
            modulo3.setP_302B_M_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_M_4)));
            modulo3.setP_302B_L_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_L_1)));
            modulo3.setP_302B_L_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_L_2)));
            modulo3.setP_302B_L_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_L_3)));
            modulo3.setP_302B_L_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_L_4)));
            modulo3.setP_302B_P_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_P_1)));
            modulo3.setP_302B_P_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_P_2)));
            modulo3.setP_302B_P_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_P_3)));
            modulo3.setP_302B_P_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_P_4)));
            modulo3.setP_302B_P_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_P_5)));
            modulo3.setP_302B_T_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_T_1)));
            modulo3.setP_302B_T_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_T_2)));
            modulo3.setP_302B_T_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_T_3)));
            modulo3.setP_302B_T_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_T_4)));
            modulo3.setP_302B_V_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_V_1)));
            modulo3.setP_302B_V_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_V_2)));
            modulo3.setP_302B_V_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_V_3)));
            modulo3.setP_302B_O_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302B_O_1)));
            modulo3.setP_302C_M_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_M_1)));
            modulo3.setP_302C_M_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_M_2)));
            modulo3.setP_302C_M_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_M_3)));
            modulo3.setP_302C_M_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_M_4)));
            modulo3.setP_302C_L_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_L_1)));
            modulo3.setP_302C_L_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_L_2)));
            modulo3.setP_302C_L_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_L_3)));
            modulo3.setP_302C_L_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_L_4)));
            modulo3.setP_302C_P_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_P_1)));
            modulo3.setP_302C_P_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_P_2)));
            modulo3.setP_302C_P_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_P_3)));
            modulo3.setP_302C_P_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_P_4)));
            modulo3.setP_302C_P_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_P_5)));
            modulo3.setP_302C_T_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_T_1)));
            modulo3.setP_302C_T_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_T_2)));
            modulo3.setP_302C_T_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_T_3)));
            modulo3.setP_302C_T_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_T_4)));
            modulo3.setP_302C_V_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_V_1)));
            modulo3.setP_302C_V_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_V_2)));
            modulo3.setP_302C_V_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_V_3)));
            modulo3.setP_302C_O_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_302C_O_1)));
            modulo3.setP_303_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_303_1)));
            modulo3.setP_303_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_303_2)));
            modulo3.setP_303_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_303_3)));
            modulo3.setP_303_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_303_4)));
            modulo3.setP_303_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_303_5)));
            modulo3.setP_304(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_304)));
            modulo3.setP_305(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_P_305)));
            modulo3.setOBS(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION300_OBS)));
            modulos3.add(modulo3);
        }
        cursor.close();
        return modulos3;
    }


    public void insertarModulo3(Sec300PojoF1 modulo3){
        ContentValues contentValues = modulo3.toValues();
        sqLiteDatabase.insert(SQLConstantes.tableModulo3,null,contentValues);
    }

    public void insertarModulos3(ArrayList<Sec300PojoF1> modulos3){
        long items = getNumeroItemsModulo3();
        if(items == 0){
            for (Sec300PojoF1 modulo3 : modulos3) {
                try {
                    insertarModulo3(modulo3);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void actualizarModulo3(String idempresa, ContentValues contentValues){
        String[] whereArgs = new String[]{idempresa};
        sqLiteDatabase.update(SQLConstantes.tableModulo3,contentValues,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }
    public void deleteModulo3(String idEmpresa){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.delete(SQLConstantes.tableModulo3,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }
//----------------------------------------------- FIN MODULO 3 ------------------------------------------------------------------


//-------------------------------------------------------MODULO 4------------------------------------------------------------------



    public Sec400PojoF1 getModulo4(String idEmpresa){
        Sec400PojoF1 modulo4 = new Sec400PojoF1();
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = sqLiteDatabase.query(SQLConstantes.tableModulo4,
                SQLConstantes.ALL_COLUMNS_SECCION400,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
        if(cursor.getCount() == 1){
            cursor.moveToFirst();
            modulo4.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_ID)));
            modulo4.setP_401_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_401_1)));
            modulo4.setP_401_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_401_2)));
            modulo4.setP_401_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_401_3)));
            modulo4.setP_401_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_401_4)));
            modulo4.setP_401_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_401_5)));
            modulo4.setP_402(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_402)));
            modulo4.setP_403_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_403_1)));
            modulo4.setP_403_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_403_2)));
            modulo4.setP_403_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_403_3)));
            modulo4.setP_403_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_403_4)));
            modulo4.setP_404(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_404)));
            modulo4.setP_405(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_405)));
            modulo4.setP_406(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_406)));
            modulo4.setP_407_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_1)));
            modulo4.setP_407_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_2)));
            modulo4.setP_407_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_3)));
            modulo4.setP_407_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_4)));
            modulo4.setP_407_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_5)));
            modulo4.setP_407_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_6)));
            modulo4.setP_407_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_7)));
            modulo4.setP_407_7_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_7_O)));
            modulo4.setP_408_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_1)));
            modulo4.setP_408_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_2)));
            modulo4.setP_408_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_3)));
            modulo4.setP_408_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_4)));
            modulo4.setP_408_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_5)));
            modulo4.setP_408_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_6)));
            modulo4.setP_408_6_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_6_O)));
            modulo4.setP_409_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_409_1)));
            modulo4.setP_409_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_409_2)));
            modulo4.setP_409_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_409_3)));
            modulo4.setP_409_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_409_4)));
            modulo4.setP_409_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_409_5)));
            modulo4.setP_409_5_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_409_5_O)));
            modulo4.setP_410(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_410)));
            modulo4.setP_410_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_410_O)));
            modulo4.setOBS(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_OBS)));
        }
        cursor.close();
        return modulo4;
    }


    public boolean existeModulo4(String idEmpresa){
        boolean encontrado = false;
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = sqLiteDatabase.query(SQLConstantes.tableModulo4,
                SQLConstantes.ALL_COLUMNS_SECCION400,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
        if(cursor.getCount() == 1) encontrado = true;
        cursor.close();
        return encontrado;
    }

    public ArrayList<Sec400PojoF1> getAllModulo4(){
        ArrayList<Sec400PojoF1> modulos4 = new ArrayList<Sec400PojoF1>();
        Cursor cursor = sqLiteDatabase.query(SQLConstantes.tableModulo4,
                SQLConstantes.ALL_COLUMNS_SECCION400,null,null,null,null,null);
        while(cursor.moveToNext()){
            Sec400PojoF1 modulo4 = new Sec400PojoF1();
            modulo4.setID(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_ID)));
            modulo4.setP_401_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_401_1)));
            modulo4.setP_401_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_401_2)));
            modulo4.setP_401_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_401_3)));
            modulo4.setP_401_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_401_4)));
            modulo4.setP_401_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_401_5)));
            modulo4.setP_402(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_402)));
            modulo4.setP_403_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_403_1)));
            modulo4.setP_403_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_403_2)));
            modulo4.setP_403_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_403_3)));
            modulo4.setP_403_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_403_4)));
            modulo4.setP_404(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_404)));
            modulo4.setP_405(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_405)));
            modulo4.setP_406(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_406)));
            modulo4.setP_407_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_1)));
            modulo4.setP_407_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_2)));
            modulo4.setP_407_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_3)));
            modulo4.setP_407_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_4)));
            modulo4.setP_407_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_5)));
            modulo4.setP_407_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_6)));
            modulo4.setP_407_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_7)));
            modulo4.setP_407_7_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_407_7_O)));
            modulo4.setP_408_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_1)));
            modulo4.setP_408_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_2)));
            modulo4.setP_408_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_3)));
            modulo4.setP_408_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_4)));
            modulo4.setP_408_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_5)));
            modulo4.setP_408_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_6)));
            modulo4.setP_408_6_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_408_6_O)));
            modulo4.setP_409_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_409_1)));
            modulo4.setP_409_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_409_2)));
            modulo4.setP_409_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_409_3)));
            modulo4.setP_409_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_409_4)));
            modulo4.setP_409_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_409_5)));
            modulo4.setP_409_5_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_409_5_O)));
            modulo4.setP_410(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_410)));
            modulo4.setP_410_O(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_P_410_O)));
            modulo4.setOBS(cursor.getString(cursor.getColumnIndex(SQLConstantes.SECCION400_OBS)));
            modulos4.add(modulo4);
        }
        cursor.close();
        return modulos4;
    }


    public void insertarModulo4(Sec400PojoF1 modulo4){
        ContentValues contentValues = modulo4.toValues();
        sqLiteDatabase.insert(SQLConstantes.tableModulo4,null,contentValues);
    }

    public void insertarModulos4(ArrayList<Sec400PojoF1> modulos4){
        long items = getNumeroItemsModulo4();
        if(items == 0){
            for (Sec400PojoF1 modulo4 : modulos4) {
                try {
                    insertarModulo4(modulo4);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void actualizarModulo4(String idempresa, ContentValues contentValues){
        String[] whereArgs = new String[]{idempresa};
        sqLiteDatabase.update(SQLConstantes.tableModulo4,contentValues,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }
    public void deleteModulo4(String idEmpresa){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.delete(SQLConstantes.tableModulo4,SQLConstantes.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }
//-------------------------------------------- FIN MODULO 4-----------------------------------------------------------------------


}
