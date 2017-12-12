package com.example.administrador.encal.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.encal.Fragments.Seccion200Fragment1;
import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Modelo.SQLConstantes;
import com.example.administrador.encal.Pojos.CaratulaPojo;
import com.example.administrador.encal.Pojos.IdentificacionPojo;
import com.example.administrador.encal.Pojos.Marco;
import com.example.administrador.encal.Pojos.ResultadoEncuesta;
import com.example.administrador.encal.Pojos.Sec100PojoF1;
import com.example.administrador.encal.Pojos.Sec200PojoF1;
import com.example.administrador.encal.Pojos.Sec300PojoF1;
import com.example.administrador.encal.Pojos.Sec400PojoF1;
import com.example.administrador.encal.Pojos.Visita;
import com.example.administrador.encal.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static android.os.Environment.getExternalStorageDirectory;

public class ImportarActivity extends AppCompatActivity {
    private TextView txtImportar;
    private Button btnImportar;
    private Button btnVolver;
    private EditText edtArchivo;
    private Marco marco;
    private CaratulaPojo caratula;
    private ResultadoEncuesta resultadoEncuesta;
    private Visita currentVisita;
    private ArrayList<Visita> visitas;
    private IdentificacionPojo identificacion;
    private Sec100PojoF1 modulo1;
    private Sec200PojoF1 modulo2;
    private Sec300PojoF1 modulo3;
    private Sec400PojoF1 modulo4;
    private String currentTag = null;
    private String currentVariable = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importar);

        txtImportar = (TextView) findViewById(R.id.txtImportar);
        btnImportar = (Button) findViewById(R.id.importacion_btnImportar);
        btnVolver = (Button) findViewById(R.id.importacion_btnVolver);
        edtArchivo = (EditText) findViewById(R.id.importacion_edtArchivo);

        btnImportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreArchivo = edtArchivo.getText().toString() + ".xml";
                parseXMLImportar(nombreArchivo);
                Toast.makeText(ImportarActivity.this, "Empresa importada", Toast.LENGTH_SHORT).show();
            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void parseXMLImportar(String nombreArchivo){
        marco = new Marco();
        caratula = new CaratulaPojo();
        resultadoEncuesta = new ResultadoEncuesta();
        visitas = new ArrayList<Visita>();
        identificacion = new IdentificacionPojo();
        modulo1 = new Sec100PojoF1();
        modulo2 = new Sec200PojoF1();
        modulo3 = new Sec300PojoF1();
        modulo4 = new Sec400PojoF1();

        XmlPullParserFactory factory;
        FileInputStream fis = null;
        try {
            StringBuilder sb = new StringBuilder();
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "ENCAMY5");
            File file = new File(nuevaCarpeta, nombreArchivo);
            FileInputStream fileInputStream = new FileInputStream(file);
            fis = new FileInputStream(file);
            xpp.setInput(fis, null);
            int eventType = xpp.getEventType();
//            while (eventType != XmlPullParser.END_DOCUMENT) {
//                if (eventType == XmlPullParser.START_DOCUMENT)
//                {}
//                else if (eventType == XmlPullParser.START_TAG)
//                    sb.append("\n<" + xpp.getName() + ">");
//
//                else if (eventType == XmlPullParser.END_TAG)
//                    sb.append("</" + xpp.getName() + ">");
//                else if (eventType == XmlPullParser.TEXT)
//                    sb.append(xpp.getText());
//
//                eventType = xpp.next();
//            }

            while(eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_TAG){
                    handleStarTag(xpp.getName());
                }else if(eventType == XmlPullParser.END_TAG){
                    handleEndTag(xpp.getName());
                }else if(eventType == XmlPullParser.TEXT){
                    handleText(xpp.getText());
                }
                eventType = xpp.next();
            }
            Data data = new Data(this);
            data.open();
//            data.insertarMarco(marco);
            String idEmpresa = marco.getID();
            if(!caratula.getID().equals("")){data.deleteCaratula(idEmpresa);data.insertarCaratula(caratula);}
            if(!resultadoEncuesta.getRESFIN_ID().equals("")){data.deleteResultado(idEmpresa);data.insertarResultado(resultadoEncuesta);}
            if(visitas.size()>0){data.deleteAllVisitas(idEmpresa);data.insertarVisitas(visitas);}
            if(!identificacion.getID().equals("")){data.deleteIdentificacion(idEmpresa);data.insertarIdentificacion(identificacion);}
            if(!modulo1.getID().equals("")){data.deleteModulo1(idEmpresa);data.insertarModulo1(modulo1);}
            if(!modulo2.getID().equals("")){data.deleteModulo2(idEmpresa);data.insertarModulo2(modulo2);}
            if(!modulo3.getID().equals("")){data.deleteModulo3(idEmpresa);data.insertarModulo3(modulo3);}
            if(!modulo4.getID().equals("")){data.deleteModulo4(idEmpresa);data.insertarModulo4(modulo4);}
            data.close();
//            txtImportar.setText(sb.toString());
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(ImportarActivity.this, "No existe el archivo", Toast.LENGTH_SHORT).show();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleText(String text) {
        String xmlText = text;
        switch (currentTag){
            case "MARCO": agregarVariableMarco(currentVariable,text);break;
            case "CARATULA":agregarVariableCaratula(currentVariable,text);break;
            case "VISITA":agregarVariableVisita(currentVariable,text);break;
            case "RESULTADO_ENCUESTA":agregarVariableResultadoEncuesta(currentVariable,text);break;
            case "IDENTIFICACION":agregarVariableIdentificacion(currentVariable,text);break;
            case "MODULO1":agregarVariableModulo1(currentVariable,text);break;
            case "MODULO2":agregarVariableModulo2(currentVariable,text);break;
            case "MODULO3":agregarVariableModulo3(currentVariable,text);break;
            case "MODULO4":agregarVariableModulo4(currentVariable,text);break;
        }
    }

    private void handleStarTag(String name) {
        switch (name){
            case "MARCO": currentTag = "MARCO";break;
            case "CARATULA":currentTag = "CARATULA";break;
            case "VISITA":currentTag = "VISITA";currentVisita = new Visita();break;
            case "RESULTADO_ENCUESTA":currentTag = "RESULTADO_ENCUESTA";break;
            case "IDENTIFICACION":currentTag = "IDENTIFICACION";break;
            case "MODULO1":currentTag = "MODULO1";break;
            case "MODULO2":currentTag = "MODULO2";break;
            case "MODULO3":currentTag = "MODULO3";break;
            case "MODULO4":currentTag = "MODULO4";break;
            default: currentVariable = name;break;
        }
    }
    public void handleEndTag(String name){
        switch (name){
            case "VISITA": visitas.add(currentVisita);break;
        }
    }

    public void agregarVariableMarco(String campo, String valor){
        switch(campo){
            case "ID":marco.setID(valor);break;
            case  SQLConstantes.MARCO_RUC:marco.setRUC(valor);break;
            case SQLConstantes.MARCO_RAZON_SOCIAL:marco.setRAZON_SOCIAL(valor);break;
            case SQLConstantes.MARCO_NOMBRE_COMERCIAL:marco.setNOMBRE_COMERCIAL(valor);break;
            case SQLConstantes.MARCO_OPERADOR:marco.setOPERADOR(valor);break;
            case SQLConstantes.MARCO_JEFE:marco.setJEFE(valor);break;
            case SQLConstantes.MARCO_OBSERVADOR:marco.setOBSERVADOR(valor);break;
            case SQLConstantes.MARCO_ANIO:marco.setANIO(valor);break;
            case SQLConstantes.MARCO_MES:marco.setMES(valor);break;
            case SQLConstantes.MARCO_PERIODO:marco.setPERIODO(valor);break;
            case SQLConstantes.MARCO_CCDD:marco.setCCDD(valor);break;
            case SQLConstantes.MARCO_DEPARTAMENTO:marco.setDEPARTAMENTO(valor);break;
            case SQLConstantes.MARCO_CCPP:marco.setCCPP(valor);break;
            case SQLConstantes.MARCO_PROVINCIA:marco.setPROVINCIA(valor);break;
            case SQLConstantes.MARCO_CCDI:marco.setCCDI(valor);break;
            case SQLConstantes.MARCO_DISTRITO:marco.setDISTRITO(valor);break;
            case SQLConstantes.MARCO_T_EMPRESA:marco.setT_EMPRESA(valor);break;
            case SQLConstantes.MARCO_FRENTE:marco.setFRENTE(valor);break;
            case SQLConstantes.MARCO_ZONA:marco.setZONA(valor);break;
            case SQLConstantes.MARCO_MANZANA:marco.setMANZANA(valor);break;
            case SQLConstantes.MARCO_CAT_VIA:marco.setCAT_VIA(valor);break;
            case SQLConstantes.MARCO_NOM_VIA:marco.setNOM_VIA(valor);break;
            case SQLConstantes.MARCO_PUERTA:marco.setPUERTA(valor);break;
            case SQLConstantes.MARCO_INTERIOR:marco.setINTERIOR(valor);break;
            case SQLConstantes.MARCO_PISO:marco.setPISO(valor);break;
            case SQLConstantes.MARCO_MZ:marco.setMZ(valor);break;
            case SQLConstantes.MARCO_LOTE:marco.setLOTE(valor);break;
        }

    }
    public void agregarVariableCaratula(String campo, String valor){
        switch (campo){
            case "ID":caratula.setID(valor);break;
            case SQLConstantes.CARATULA_DEPARTAMENTO:caratula.setNOMBREDD(valor);break;
            case SQLConstantes.CARATULA_DEPARTAMENTO_COD:caratula.setCCDD(valor);break;
            case SQLConstantes.CARATULA_PROVINCIA:caratula.setNOMBREPV(valor);break;
            case SQLConstantes.CARATULA_PROVINCIA_COD:caratula.setCCPP(valor);break;
            case SQLConstantes.CARATULA_DISTRITO:caratula.setNOMBREDI(valor);break;
            case SQLConstantes.CARATULA_DISTRITO_COD:caratula.setCCDI(valor);break;
            case SQLConstantes.CARATULA_GPSLATITUD:caratula.setGPSLATITUD(valor);break;
            case SQLConstantes.CARATULA_GPSLONGITUD:caratula.setGPSLONGITUD(valor);break;
            case SQLConstantes.CARATULA_SECTOR:caratula.setSECTOR_TR(valor);break;
            case SQLConstantes.CARATULA_AREA:caratula.setARA_TR(valor);break;
            case SQLConstantes.CARATULA_ZONA:caratula.setZONA(valor);break;
            case SQLConstantes.CARATULA_MANZANA_MUESTRA:caratula.setMANZANA_ID(valor);break;
            case SQLConstantes.CARATULA_FRENTE:caratula.setFRENTE(valor);break;
            case SQLConstantes.CARATULA_TIPVIA:caratula.setTIPVIA(valor);break;
            case SQLConstantes.CARATULA_NOMVIA:caratula.setTIPVIA_D(valor);break;
            case SQLConstantes.CARATULA_TIPVIA_OTRO:caratula.setTIPVIA_ESPEC(valor);break;
            case SQLConstantes.CARATULA_NPUERTA:caratula.setNROPTA(valor);break;
            case SQLConstantes.CARATULA_BLOCK:caratula.setBLOCK(valor);break;
            case SQLConstantes.CARATULA_INTERIOR:caratula.setINTERIOR(valor);break;
            case SQLConstantes.CARATULA_PISO:caratula.setPISO(valor);break;
            case SQLConstantes.CARATULA_MANZANA_VIA:caratula.setMZA(valor);break;
            case SQLConstantes.CARATULA_LOTE:caratula.setLOTE(valor);break;
            case SQLConstantes.CARATULA_KM:caratula.setKM(valor);break;
            case SQLConstantes.CARATULA_REFERENCIA:caratula.setREF_DIREC(valor);break;
        }
    }

    public void agregarVariableVisita(String campo, String valor){
        switch (campo){
            case "ID":currentVisita.setID_EMPRESA(valor);break;
            case SQLConstantes.VISITA_N:currentVisita.setV_NRO(valor);break;
            case SQLConstantes.VISITA_DIA:currentVisita.setV_DIA(valor);break;
            case SQLConstantes.VISITA_MES:currentVisita.setV_MES(valor);break;
            case SQLConstantes.VISITA_ANIO:currentVisita.setV_ANIO(valor);break;
            case SQLConstantes.VISITA_HORA:currentVisita.setV_HORA(valor);break;
            case SQLConstantes.VISITA_MINUTO:currentVisita.setV_MINUTO(valor);break;
            case SQLConstantes.VISITA_RESULTADO:currentVisita.setV_RESULTADO(valor);break;
            case SQLConstantes.VISITA_RESULTADO_ESP:currentVisita.setV_RESULTADO_O(valor);break;
            case SQLConstantes.VISITA_PROX_DIA:currentVisita.setV_PROX_VIS_DIA(valor);break;
            case SQLConstantes.VISITA_PROX_MES:currentVisita.setV_PROX_VIS_MES(valor);break;
            case SQLConstantes.VISITA_PROX_ANIO:currentVisita.setV_PROX_VIS_ANIO(valor);break;
            case SQLConstantes.VISITA_PROX_HORA:currentVisita.setV_PROX_VIS_HORA(valor);break;
            case SQLConstantes.VISITA_PROX_MINUTO:currentVisita.setV_PROX_VIS_MINUTO(valor);break;

        }
    }

    public void agregarVariableResultadoEncuesta(String campo, String valor){
        switch (campo){
            case "RESFIN_ID":resultadoEncuesta.setRESFIN_ID(valor);break;
            case SQLConstantes.RESULTADO_DIA:resultadoEncuesta.setRESFIN_DIA(valor);break;
            case SQLConstantes.RESULTADO_MES:resultadoEncuesta.setRESFIN_MES(valor);break;
            case SQLConstantes.RESULTADO_ANIO:resultadoEncuesta.setRESFIN_ANIO(valor);break;
            case SQLConstantes.RESULTADO_HORA:resultadoEncuesta.setRESFIN_HORA(valor);break;
            case SQLConstantes.RESULTADO_MIN:resultadoEncuesta.setRESFIN_MIN(valor);break;
            case SQLConstantes.RESULTADO_RESULTADO:resultadoEncuesta.setRESFIN(valor);break;
            case SQLConstantes.RESULTADO_RESULTADO_ESP:resultadoEncuesta.setRESFIN_O(valor);break;
        }
    }


    public void agregarVariableIdentificacion(String campo, String valor){
        switch (campo){
            case "ID":identificacion.setID(valor);break;
            case SQLConstantes.IDENTIFICACION_RUC:identificacion.setNUM_RUC(valor);break;
            case SQLConstantes.IDENTIFICACION_RAZON:identificacion.setRAZON_SOCIAL(valor);break;
            case SQLConstantes.IDENTIFICACION_NOMBRE:identificacion.setNOM_COMER_MYPE(valor);break;
            case SQLConstantes.IDENTIFICACION_WEB:identificacion.setPAGWEB(valor);break;
            case SQLConstantes.IDENTIFICACION_WEBNO:identificacion.setPAGWEB_NO(valor);break;
            case SQLConstantes.IDENTIFICACION_CORREO:identificacion.setCORREO(valor);break;
            case SQLConstantes.IDENTIFICACION_CORREONO:identificacion.setCORREO_NO(valor);break;
            case SQLConstantes.IDENTIFICACION_FIJO:identificacion.setTELFIJO(valor);break;
            case SQLConstantes.IDENTIFICACION_FIJONO:identificacion.setTELFIJO_NO(valor);break;
            case SQLConstantes.IDENTIFICACION_MOVIL:identificacion.setTELMOVIL(valor);break;
            case SQLConstantes.IDENTIFICACION_MOVILNO:identificacion.setTELMOVIL_NO(valor);break;
            case SQLConstantes.IDENTIFICACION_ANIO_FUNCIONAMIENTO:identificacion.setANO_INI(valor);break;
            case SQLConstantes.IDENTIFICACION_CONDUCTOR_NOMBRE:identificacion.setCOND_APEL_NOM(valor);break;
            case SQLConstantes.IDENTIFICACION_CONDUCTOR_SEXO:identificacion.setCOND_SEXO(valor);break;
            case SQLConstantes.IDENTIFICACION_CONDUCTOR_EDAD:identificacion.setCOND_EDAD(valor);break;
            case SQLConstantes.IDENTIFICACION_CONDUCTOR_ESTUDIOS:identificacion.setCOND_NEST(valor);break;
            case SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO:identificacion.setINFOR_CARGO(valor);break;
            case SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO_ESP:identificacion.setINFOR_CARGO_O(valor);break;
        }
    }
    public void agregarVariableModulo1(String campo, String valor){
        switch (campo){
            case "ID":modulo1.setID(valor);break;

            case SQLConstantes.SECCION100_P_101:modulo1.setP_101(valor);break;
            case SQLConstantes.SECCION100_P_101_1:modulo1.setP_101_1(valor);break;
            case SQLConstantes.SECCION100_P_101_1_O:modulo1.setP_101_1_O(valor);break;
            case SQLConstantes.SECCION100_P_102A:modulo1.setP_102A(valor);break;
            case SQLConstantes.SECCION100_P_102_1:modulo1.setP_102_1(valor);break;
            case SQLConstantes.SECCION100_P_102B:modulo1.setP_102B(valor);break;
            case SQLConstantes.SECCION100_P_102_2:modulo1.setP_102_2(valor);break;
            case SQLConstantes.SECCION100_P_102C:modulo1.setP_102C(valor);break;
            case SQLConstantes.SECCION100_P_102_3:modulo1.setP_102_3(valor);break;
            case SQLConstantes.SECCION100_P_102D:modulo1.setP_102D(valor);break;
            case SQLConstantes.SECCION100_P_102_4:modulo1.setP_102_4(valor);break;
            case SQLConstantes.SECCION100_P_103:modulo1.setP_103(valor);break;
            case SQLConstantes.SECCION100_P_103_O:modulo1.setP_103_O(valor);break;
            case SQLConstantes.SECCION100_P_104:modulo1.setP_104(valor);break;
            case SQLConstantes.SECCION100_P_105:modulo1.setP_105(valor);break;
            case SQLConstantes.SECCION100_P_106_1:modulo1.setP_106_1(valor);break;
            case SQLConstantes.SECCION100_P_106_2:modulo1.setP_106_2(valor);break;
            case SQLConstantes.SECCION100_P_106_3:modulo1.setP_106_3(valor);break;
            case SQLConstantes.SECCION100_P_106_4:modulo1.setP_106_4(valor);break;
            case SQLConstantes.SECCION100_P_106_5:modulo1.setP_106_5(valor);break;
            case SQLConstantes.SECCION100_P_107_1:modulo1.setP_107_1(valor);break;
            case SQLConstantes.SECCION100_P_107_2:modulo1.setP_107_2(valor);break;
            case SQLConstantes.SECCION100_P_107_3:modulo1.setP_107_3(valor);break;
            case SQLConstantes.SECCION100_P_108:modulo1.setP_108(valor);break;
            case SQLConstantes.SECCION100_P_109_1:modulo1.setP_109_1(valor);break;
            case SQLConstantes.SECCION100_P_109_2:modulo1.setP_109_2(valor);break;
            case SQLConstantes.SECCION100_P_109_3:modulo1.setP_109_3(valor);break;
            case SQLConstantes.SECCION100_P_109_4:modulo1.setP_109_4(valor);break;
            case SQLConstantes.SECCION100_P_109_5:modulo1.setP_109_5(valor);break;
            case SQLConstantes.SECCION100_P_109_6:modulo1.setP_109_6(valor);break;
            case SQLConstantes.SECCION100_P_109_6_O:modulo1.setP_109_6_O(valor);break;
            case SQLConstantes.SECCION100_P_110_1:modulo1.setP_110_1(valor);break;
            case SQLConstantes.SECCION100_P_110_2:modulo1.setP_110_2(valor);break;
            case SQLConstantes.SECCION100_P_110_3:modulo1.setP_110_3(valor);break;
            case SQLConstantes.SECCION100_P_110_4:modulo1.setP_110_4(valor);break;
            case SQLConstantes.SECCION100_P_110_5:modulo1.setP_110_5(valor);break;
            case SQLConstantes.SECCION100_P_110_6:modulo1.setP_110_6(valor);break;
            case SQLConstantes.SECCION100_P_110_7:modulo1.setP_110_7(valor);break;
            case SQLConstantes.SECCION100_P_110_7_O:modulo1.setP_110_7_O(valor);break;
            case SQLConstantes.SECCION100_P_111:modulo1.setP_111(valor);break;
            case SQLConstantes.SECCION100_P_112:modulo1.setP_112(valor);break;
            case SQLConstantes.SECCION100_P_112_O:modulo1.setP_112_O(valor);break;
            case SQLConstantes.SECCION100_P_113_1:modulo1.setP_113_1(valor);break;
            case SQLConstantes.SECCION100_P_113_2:modulo1.setP_113_2(valor);break;
            case SQLConstantes.SECCION100_P_113_3:modulo1.setP_113_3(valor);break;
            case SQLConstantes.SECCION100_P_113_4:modulo1.setP_113_4(valor);break;
            case SQLConstantes.SECCION100_P_113_5:modulo1.setP_113_5(valor);break;
            case SQLConstantes.SECCION100_P_113_5_O:modulo1.setP_113_5_O(valor);break;
            case SQLConstantes.SECCION100_P_114_1:modulo1.setP_114_1(valor);break;
            case SQLConstantes.SECCION100_P_114_2:modulo1.setP_114_2(valor);break;
            case SQLConstantes.SECCION100_P_114_3:modulo1.setP_114_3(valor);break;
            case SQLConstantes.SECCION100_P_114_4:modulo1.setP_114_4(valor);break;
            case SQLConstantes.SECCION100_P_114_5:modulo1.setP_114_5(valor);break;
            case SQLConstantes.SECCION100_P_114_6:modulo1.setP_114_6(valor);break;
            case SQLConstantes.SECCION100_P_114_7:modulo1.setP_114_7(valor);break;
            case SQLConstantes.SECCION100_P_114_7_O:modulo1.setP_114_7_O(valor);break;
            case SQLConstantes.SECCION100_OBS:modulo1.setOBS(valor);break;
        }
    }
    public void agregarVariableModulo2(String campo, String valor){
        switch (campo){
            case "ID":modulo2.setID(valor);break;
            case SQLConstantes.SECCION200_P_201_1:modulo2.setP_201_1(valor);break;
            case SQLConstantes.SECCION200_P_201_2:modulo2.setP_201_2(valor);break;
            case SQLConstantes.SECCION200_P_201_3:modulo2.setP_201_3(valor);break;
            case SQLConstantes.SECCION200_P_201_4:modulo2.setP_201_4(valor);break;
            case SQLConstantes.SECCION200_P_202:modulo2.setP_202(valor);break;
            case SQLConstantes.SECCION200_P_203:modulo2.setP_203(valor);break;
            case SQLConstantes.SECCION200_P_203_O:modulo2.setP_203_O(valor);break;
            case SQLConstantes.SECCION200_P_204:modulo2.setP_204(valor);break;
            case SQLConstantes.SECCION200_P_205_1:modulo2.setP_205_1(valor);break;
            case SQLConstantes.SECCION200_P_205_2:modulo2.setP_205_2(valor);break;
            case SQLConstantes.SECCION200_P_205_3:modulo2.setP_205_3(valor);break;
            case SQLConstantes.SECCION200_P_205_4:modulo2.setP_205_4(valor);break;
            case SQLConstantes.SECCION200_P_205_5:modulo2.setP_205_5(valor);break;
            case SQLConstantes.SECCION200_P_205_6:modulo2.setP_205_6(valor);break;
            case SQLConstantes.SECCION200_P_205_6_O:modulo2.setP_205_6_O(valor);break;
            case SQLConstantes.SECCION200_OBS:modulo2.setOBS(valor);break;
        }
    }
    public void agregarVariableModulo3(String campo, String valor){
        switch (campo){
            case "ID":modulo3.setID(valor);break;
            case SQLConstantes.SECCION300_P_301:modulo3.setP_301(valor);break;
            case SQLConstantes.SECCION300_P_302:modulo3.setP_302(valor);break;
            case SQLConstantes.SECCION300_P_302A_M_1:modulo3.setP_302A_M_1(valor);break;
            case SQLConstantes.SECCION300_P_302A_M_2:modulo3.setP_302A_M_2(valor);break;
            case SQLConstantes.SECCION300_P_302A_M_3:modulo3.setP_302A_M_3(valor);break;
            case SQLConstantes.SECCION300_P_302A_M_4:modulo3.setP_302A_M_4(valor);break;
            case SQLConstantes.SECCION300_P_302A_M_4_O:modulo3.setP_302A_M_4_O(valor);break;
            case SQLConstantes.SECCION300_P_302A_L_1:modulo3.setP_302A_L_1(valor);break;
            case SQLConstantes.SECCION300_P_302A_L_2:modulo3.setP_302A_L_2(valor);break;
            case SQLConstantes.SECCION300_P_302A_L_3:modulo3.setP_302A_L_3(valor);break;
            case SQLConstantes.SECCION300_P_302A_L_4:modulo3.setP_302A_L_4(valor);break;
            case SQLConstantes.SECCION300_P_302A_L_4_O:modulo3.setP_302A_L_4_O(valor);break;
            case SQLConstantes.SECCION300_P_302A_P_1:modulo3.setP_302A_P_1(valor);break;
            case SQLConstantes.SECCION300_P_302A_P_2:modulo3.setP_302A_P_2(valor);break;
            case SQLConstantes.SECCION300_P_302A_P_3:modulo3.setP_302A_P_3(valor);break;
            case SQLConstantes.SECCION300_P_302A_P_4:modulo3.setP_302A_P_4(valor);break;
            case SQLConstantes.SECCION300_P_302A_P_5:modulo3.setP_302A_P_5(valor);break;
            case SQLConstantes.SECCION300_P_302A_P_5_O:modulo3.setP_302A_P_5_O(valor);break;
            case SQLConstantes.SECCION300_P_302A_T_1:modulo3.setP_302A_T_1(valor);break;
            case SQLConstantes.SECCION300_P_302A_T_2:modulo3.setP_302A_T_2(valor);break;
            case SQLConstantes.SECCION300_P_302A_T_3:modulo3.setP_302A_T_3(valor);break;
            case SQLConstantes.SECCION300_P_302A_T_4:modulo3.setP_302A_T_4(valor);break;
            case SQLConstantes.SECCION300_P_302A_T_4_O:modulo3.setP_302A_T_4_O(valor);break;
            case SQLConstantes.SECCION300_P_302A_V_1:modulo3.setP_302A_V_1(valor);break;
            case SQLConstantes.SECCION300_P_302A_V_2:modulo3.setP_302A_V_2(valor);break;
            case SQLConstantes.SECCION300_P_302A_V_3:modulo3.setP_302A_V_3(valor);break;
            case SQLConstantes.SECCION300_P_302A_V_3_O:modulo3.setP_302A_V_3_O(valor);break;
            case SQLConstantes.SECCION300_P_302A_O_1:modulo3.setP_302A_O_1(valor);break;
            case SQLConstantes.SECCION300_P_302A_O_1_O:modulo3.setP_302A_O_1_O(valor);break;
            case SQLConstantes.SECCION300_P_302B_M_1:modulo3.setP_302B_M_1(valor);break;
            case SQLConstantes.SECCION300_P_302B_M_2:modulo3.setP_302B_M_2(valor);break;
            case SQLConstantes.SECCION300_P_302B_M_3:modulo3.setP_302B_M_3(valor);break;
            case SQLConstantes.SECCION300_P_302B_M_4:modulo3.setP_302B_M_4(valor);break;
            case SQLConstantes.SECCION300_P_302B_L_1:modulo3.setP_302B_L_1(valor);break;
            case SQLConstantes.SECCION300_P_302B_L_2:modulo3.setP_302B_L_2(valor);break;
            case SQLConstantes.SECCION300_P_302B_L_3:modulo3.setP_302B_L_3(valor);break;
            case SQLConstantes.SECCION300_P_302B_L_4:modulo3.setP_302B_L_4(valor);break;
            case SQLConstantes.SECCION300_P_302B_P_1:modulo3.setP_302B_P_1(valor);break;
            case SQLConstantes.SECCION300_P_302B_P_2:modulo3.setP_302B_P_2(valor);break;
            case SQLConstantes.SECCION300_P_302B_P_3:modulo3.setP_302B_P_3(valor);break;
            case SQLConstantes.SECCION300_P_302B_P_4:modulo3.setP_302B_P_4(valor);break;
            case SQLConstantes.SECCION300_P_302B_P_5:modulo3.setP_302B_P_5(valor);break;
            case SQLConstantes.SECCION300_P_302B_T_1:modulo3.setP_302B_T_1(valor);break;
            case SQLConstantes.SECCION300_P_302B_T_2:modulo3.setP_302B_T_2(valor);break;
            case SQLConstantes.SECCION300_P_302B_T_3:modulo3.setP_302B_T_3(valor);break;
            case SQLConstantes.SECCION300_P_302B_T_4:modulo3.setP_302B_T_4(valor);break;
            case SQLConstantes.SECCION300_P_302B_V_1:modulo3.setP_302B_V_1(valor);break;
            case SQLConstantes.SECCION300_P_302B_V_2:modulo3.setP_302B_V_2(valor);break;
            case SQLConstantes.SECCION300_P_302B_V_3:modulo3.setP_302B_V_3(valor);break;
            case SQLConstantes.SECCION300_P_302B_O_1:modulo3.setP_302B_O_1(valor);break;
            case SQLConstantes.SECCION300_P_302C_M_1:modulo3.setP_302C_M_1(valor);break;
            case SQLConstantes.SECCION300_P_302C_M_2:modulo3.setP_302C_M_2(valor);break;
            case SQLConstantes.SECCION300_P_302C_M_3:modulo3.setP_302C_M_3(valor);break;
            case SQLConstantes.SECCION300_P_302C_M_4:modulo3.setP_302C_M_4(valor);break;
            case SQLConstantes.SECCION300_P_302C_L_1:modulo3.setP_302C_L_1(valor);break;
            case SQLConstantes.SECCION300_P_302C_L_2:modulo3.setP_302C_L_2(valor);break;
            case SQLConstantes.SECCION300_P_302C_L_3:modulo3.setP_302C_L_3(valor);break;
            case SQLConstantes.SECCION300_P_302C_L_4:modulo3.setP_302C_L_4(valor);break;
            case SQLConstantes.SECCION300_P_302C_P_1:modulo3.setP_302C_P_1(valor);break;
            case SQLConstantes.SECCION300_P_302C_P_2:modulo3.setP_302C_P_2(valor);break;
            case SQLConstantes.SECCION300_P_302C_P_3:modulo3.setP_302C_P_3(valor);break;
            case SQLConstantes.SECCION300_P_302C_P_4:modulo3.setP_302C_P_4(valor);break;
            case SQLConstantes.SECCION300_P_302C_P_5:modulo3.setP_302C_P_5(valor);break;
            case SQLConstantes.SECCION300_P_302C_T_1:modulo3.setP_302C_T_1(valor);break;
            case SQLConstantes.SECCION300_P_302C_T_2:modulo3.setP_302C_T_2(valor);break;
            case SQLConstantes.SECCION300_P_302C_T_3:modulo3.setP_302C_T_3(valor);break;
            case SQLConstantes.SECCION300_P_302C_T_4:modulo3.setP_302C_T_4(valor);break;
            case SQLConstantes.SECCION300_P_302C_V_1:modulo3.setP_302C_V_1(valor);break;
            case SQLConstantes.SECCION300_P_302C_V_2:modulo3.setP_302C_V_2(valor);break;
            case SQLConstantes.SECCION300_P_302C_V_3:modulo3.setP_302C_V_3(valor);break;
            case SQLConstantes.SECCION300_P_302C_O_1:modulo3.setP_302C_O_1(valor);break;
            case SQLConstantes.SECCION300_P_303_1:modulo3.setP_303_1(valor);break;
            case SQLConstantes.SECCION300_P_303_2:modulo3.setP_303_2(valor);break;
            case SQLConstantes.SECCION300_P_303_3:modulo3.setP_303_3(valor);break;
            case SQLConstantes.SECCION300_P_303_4:modulo3.setP_303_4(valor);break;
            case SQLConstantes.SECCION300_P_303_5:modulo3.setP_303_5(valor);break;
            case SQLConstantes.SECCION300_P_304:modulo3.setP_304(valor);break;
            case SQLConstantes.SECCION300_P_305:modulo3.setP_305(valor);break;
            case SQLConstantes.SECCION300_OBS:modulo3.setOBS(valor);break;
        }
    }
    public void agregarVariableModulo4(String campo, String valor){
        switch (campo){
            case "ID":modulo4.setID(valor);break;
            case SQLConstantes.SECCION400_P_401_1:modulo4.setP_401_1(valor);break;
            case SQLConstantes.SECCION400_P_401_2:modulo4.setP_401_2(valor);break;
            case SQLConstantes.SECCION400_P_401_3:modulo4.setP_401_3(valor);break;
            case SQLConstantes.SECCION400_P_401_4:modulo4.setP_401_4(valor);break;
            case SQLConstantes.SECCION400_P_401_5:modulo4.setP_401_5(valor);break;
            case SQLConstantes.SECCION400_P_402:modulo4.setP_402(valor);break;
            case SQLConstantes.SECCION400_P_403_1:modulo4.setP_403_1(valor);break;
            case SQLConstantes.SECCION400_P_403_2:modulo4.setP_403_2(valor);break;
            case SQLConstantes.SECCION400_P_403_3:modulo4.setP_403_3(valor);break;
            case SQLConstantes.SECCION400_P_403_4:modulo4.setP_403_4(valor);break;
            case SQLConstantes.SECCION400_P_404:modulo4.setP_404(valor);break;
            case SQLConstantes.SECCION400_P_405:modulo4.setP_405(valor);break;
            case SQLConstantes.SECCION400_P_406:modulo4.setP_406(valor);break;
            case SQLConstantes.SECCION400_P_407_1:modulo4.setP_407_1(valor);break;
            case SQLConstantes.SECCION400_P_407_2:modulo4.setP_407_2(valor);break;
            case SQLConstantes.SECCION400_P_407_3:modulo4.setP_407_3(valor);break;
            case SQLConstantes.SECCION400_P_407_4:modulo4.setP_407_4(valor);break;
            case SQLConstantes.SECCION400_P_407_5:modulo4.setP_407_5(valor);break;
            case SQLConstantes.SECCION400_P_407_6:modulo4.setP_407_6(valor);break;
            case SQLConstantes.SECCION400_P_407_7:modulo4.setP_407_7(valor);break;
            case SQLConstantes.SECCION400_P_407_7_O:modulo4.setP_407_7_O(valor);break;
            case SQLConstantes.SECCION400_P_408_1:modulo4.setP_408_1(valor);break;
            case SQLConstantes.SECCION400_P_408_2:modulo4.setP_408_2(valor);break;
            case SQLConstantes.SECCION400_P_408_3:modulo4.setP_408_3(valor);break;
            case SQLConstantes.SECCION400_P_408_4:modulo4.setP_408_4(valor);break;
            case SQLConstantes.SECCION400_P_408_5:modulo4.setP_408_5(valor);break;
            case SQLConstantes.SECCION400_P_408_6:modulo4.setP_408_6(valor);break;
            case SQLConstantes.SECCION400_P_408_6_O:modulo4.setP_408_6_O(valor);break;
            case SQLConstantes.SECCION400_P_409_1:modulo4.setP_409_1(valor);break;
            case SQLConstantes.SECCION400_P_409_2:modulo4.setP_409_2(valor);break;
            case SQLConstantes.SECCION400_P_409_3:modulo4.setP_409_3(valor);break;
            case SQLConstantes.SECCION400_P_409_4:modulo4.setP_409_4(valor);break;
            case SQLConstantes.SECCION400_P_409_5:modulo4.setP_409_5(valor);break;
            case SQLConstantes.SECCION400_P_409_5_O:modulo4.setP_409_5_O(valor);break;
            case SQLConstantes.SECCION400_P_410:modulo4.setP_410(valor);break;
            case SQLConstantes.SECCION400_P_410_O:modulo4.setP_410_O(valor);break;
            case SQLConstantes.SECCION400_OBS:modulo4.setOBS(valor);break;
        }
    }

    public String convertir(String numero){
        String valor= "";
        if(!numero.equals("")){
            int num = Integer.parseInt(numero);
            num--;
            valor = valor + num;
        }
        return valor;
    }
}
