package com.example.administrador.encal.activities;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.encal.Adapters.ExportarAdapter;
import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Modelo.SQLConstantes;
import com.example.administrador.encal.Pojos.CaratulaPojo;
import com.example.administrador.encal.Pojos.ExportarItem;
import com.example.administrador.encal.Pojos.IdentificacionPojo;
import com.example.administrador.encal.Pojos.Marco;
import com.example.administrador.encal.Pojos.ResultadoEncuesta;
import com.example.administrador.encal.Pojos.Sec100PojoF1;
import com.example.administrador.encal.Pojos.Sec200PojoF1;
import com.example.administrador.encal.Pojos.Sec300PojoF1;
import com.example.administrador.encal.Pojos.Sec400PojoF1;
import com.example.administrador.encal.Pojos.Visita;
import com.example.administrador.encal.R;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import static android.os.Environment.getExternalStorageDirectory;


public class ExportarActivity extends AppCompatActivity {

    ArrayList<Marco> marcos;
    ArrayList<ExportarItem> exportarItems;
    Data data;
    private String idUsuario;
    private String permisoUsuario;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ExportarAdapter exportarAdapter;
    private Button btnExportar;
    private Button btnVolver;
    private TextView txtMensaje;
    private ProgressBar progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exportar);
        recyclerView = (RecyclerView) findViewById(R.id.exportacion_recycler);
        btnExportar = (Button) findViewById(R.id.exportacion_btnExportar);
        btnVolver = (Button) findViewById(R.id.exportacion_btnVolver);
        txtMensaje = (TextView) findViewById(R.id.exportacion_txtMensaje);
        progreso = (ProgressBar) findViewById(R.id.exportacion_progreso);

        progreso.setMax(4200);
        txtMensaje.setVisibility(View.GONE);
        progreso.setVisibility(View.GONE);

        final Bundle recupera = getIntent().getExtras();
        if(recupera != null){
            idUsuario = recupera.getString("idUsuario");
            permisoUsuario = recupera.getString("permisoUsuario");
        }
        inicializarDatos();
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        exportarAdapter = new ExportarAdapter(exportarItems, this, new ExportarAdapter.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b, int pos) {
                if(b){
                    exportarItems.get(pos).setSeleccionado(1);
                }else{
                    exportarItems.get(pos).setSeleccionado(0);
                }
            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(exportarAdapter);

        btnExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyAsyncTask().execute(100);
//                mostrarMensaje(mensaje);
            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void inicializarDatos() {
        marcos = new ArrayList<Marco>();
        exportarItems = new ArrayList<>();
        data = new Data(this);
        data.open();
        marcos = data.getAllMarcos(idUsuario,Integer.parseInt(permisoUsuario));
        data.close();

        for(Marco marco1: marcos){
            ExportarItem exportarItem = new ExportarItem(0,marco1.getID(),marco1.getRUC(),marco1.getRAZON_SOCIAL());
            exportarItems.add(exportarItem);
        }
    }
    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void exportarEmpresa(String idEmpresa){
        String nombreArchivo = idEmpresa + ".xml";
        Marco marco;
        CaratulaPojo caratula;
        ResultadoEncuesta resultadoEncuesta;
        ArrayList<Visita> visitas;
        IdentificacionPojo identificacion;
        Sec100PojoF1 modulo1;
        Sec200PojoF1 modulo2;
        Sec300PojoF1 modulo3;
        Sec400PojoF1 modulo4;


        Data data = new Data(this);
        data.open();
        marco = data.getMarco(idEmpresa);
        caratula = data.getCaratula(idEmpresa);
        visitas = data.getVisitas(idEmpresa);
        resultadoEncuesta = data.getResultados(idEmpresa);
        identificacion = data.getIdentificacion(idEmpresa);
        modulo1 = data.getModulo1(idEmpresa);
        modulo2 = data.getModulo2(idEmpresa);
        modulo3 = data.getModulo3(idEmpresa);
        modulo4 = data.getModulo4(idEmpresa);
        data.close();

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "ENCAMY");
            serializer.attribute("", "id",idEmpresa);

            serializer.startTag("", "MARCO");
            escribirCampoXml(serializer,"ID",marco.getID());
            escribirCampoXml(serializer, SQLConstantes.MARCO_RUC,marco.getRUC());
            escribirCampoXml(serializer,SQLConstantes.MARCO_RAZON_SOCIAL,marco.getRAZON_SOCIAL());
            escribirCampoXml(serializer,SQLConstantes.MARCO_NOMBRE_COMERCIAL,marco.getNOMBRE_COMERCIAL());
            escribirCampoXml(serializer,SQLConstantes.MARCO_OPERADOR,marco.getOPERADOR());
            escribirCampoXml(serializer,SQLConstantes.MARCO_JEFE,marco.getJEFE());
            escribirCampoXml(serializer,SQLConstantes.MARCO_OBSERVADOR,marco.getOBSERVADOR());
            escribirCampoXml(serializer,SQLConstantes.MARCO_ANIO,marco.getANIO());
            escribirCampoXml(serializer,SQLConstantes.MARCO_MES,marco.getMES());
            escribirCampoXml(serializer,SQLConstantes.MARCO_PERIODO,marco.getPERIODO());
            escribirCampoXml(serializer,SQLConstantes.MARCO_CCDD,marco.getCCDD());
            escribirCampoXml(serializer,SQLConstantes.MARCO_DEPARTAMENTO,marco.getDEPARTAMENTO());
            escribirCampoXml(serializer,SQLConstantes.MARCO_CCPP,marco.getCCPP());
            escribirCampoXml(serializer,SQLConstantes.MARCO_PROVINCIA,marco.getPROVINCIA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_CCDI,marco.getCCDI());
            escribirCampoXml(serializer,SQLConstantes.MARCO_DISTRITO,marco.getDISTRITO());
            escribirCampoXml(serializer,SQLConstantes.MARCO_T_EMPRESA,marco.getT_EMPRESA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_FRENTE,marco.getFRENTE());
            escribirCampoXml(serializer,SQLConstantes.MARCO_ZONA,marco.getZONA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_MANZANA,marco.getMANZANA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_CAT_VIA,marco.getCAT_VIA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_NOM_VIA,marco.getNOM_VIA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_PUERTA,marco.getPUERTA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_INTERIOR,marco.getINTERIOR());
            escribirCampoXml(serializer,SQLConstantes.MARCO_PISO,marco.getPISO());
            escribirCampoXml(serializer,SQLConstantes.MARCO_MZ,marco.getMZ());
            escribirCampoXml(serializer,SQLConstantes.MARCO_LOTE,marco.getLOTE());
            serializer.endTag("", "MARCO");

            if(!caratula.getID().equals("")) {
                serializer.startTag("", "CARATULA");
                escribirCampoXml(serializer, "ID", caratula.getID());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_DEPARTAMENTO, caratula.getNOMBREDD());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_DEPARTAMENTO_COD, caratula.getCCDD());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_PROVINCIA, caratula.getNOMBREPV());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_PROVINCIA_COD, caratula.getCCPP());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_DISTRITO, caratula.getNOMBREDI());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_DISTRITO_COD, caratula.getCCDI());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_GPSLATITUD, caratula.getGPSLATITUD());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_GPSLONGITUD, caratula.getGPSLONGITUD());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_SECTOR, caratula.getSECTOR_TR());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_AREA, caratula.getARA_TR());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_ZONA, caratula.getZONA());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_MANZANA_MUESTRA, caratula.getMANZANA_ID());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_FRENTE, caratula.getFRENTE());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_TIPVIA, caratula.getTIPVIA());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_NOMVIA, caratula.getTIPVIA_D());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_NPUERTA, caratula.getNROPTA());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_BLOCK, caratula.getBLOCK());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_INTERIOR, caratula.getINTERIOR());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_PISO, caratula.getPISO());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_MANZANA_VIA, caratula.getMZA());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_LOTE, caratula.getLOTE());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_KM, caratula.getKM());
                escribirCampoXml(serializer, SQLConstantes.CARATULA_REFERENCIA, caratula.getREF_DIREC());
                serializer.endTag("", "CARATULA");
            }

            serializer.startTag("","RESULTADO_ENCUESTA");
            escribirCampoXml(serializer,SQLConstantes.RESULTADO_ID,resultadoEncuesta.getRESFIN_ID());
            escribirCampoXml(serializer,SQLConstantes.RESULTADO_DIA,resultadoEncuesta.getRESFIN_DIA());
            escribirCampoXml(serializer,SQLConstantes.RESULTADO_MES,resultadoEncuesta.getRESFIN_MES());
            escribirCampoXml(serializer,SQLConstantes.RESULTADO_ANIO,resultadoEncuesta.getRESFIN_ANIO());
            escribirCampoXml(serializer,SQLConstantes.RESULTADO_HORA,resultadoEncuesta.getRESFIN_HORA());
            escribirCampoXml(serializer,SQLConstantes.RESULTADO_MIN,resultadoEncuesta.getRESFIN_MIN());
            escribirCampoXml(serializer,SQLConstantes.RESULTADO_RESULTADO,resultadoEncuesta.getRESFIN());
            escribirCampoXml(serializer,SQLConstantes.RESULTADO_RESULTADO_ESP,resultadoEncuesta.getRESFIN_O());
            serializer.endTag("","RESULTADO_ENCUESTA");



            if(visitas.size()>0) {
                serializer.startTag("", "VISITAS");
                for (Visita visita : visitas) {
                    serializer.startTag("", "VISITA");
                    escribirCampoXml(serializer, "ID", visita.getID_EMPRESA());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_N, visita.getV_NRO());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_DIA, visita.getV_DIA());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_MES, visita.getV_MES());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_ANIO, visita.getV_ANIO());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_HORA, visita.getV_HORA());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_MINUTO, visita.getV_MINUTO());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_RESULTADO, visita.getV_RESULTADO());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_RESULTADO_ESP, visita.getV_RESULTADO_O());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_PROX_DIA, visita.getV_PROX_VIS_DIA());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_PROX_MES, visita.getV_PROX_VIS_MES());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_PROX_ANIO, visita.getV_PROX_VIS_ANIO());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_PROX_HORA, visita.getV_PROX_VIS_HORA());
                    escribirCampoXml(serializer, SQLConstantes.VISITA_PROX_MINUTO, visita.getV_PROX_VIS_MINUTO());
                    serializer.endTag("", "VISITA");
                }
                serializer.endTag("", "VISITAS");
            }
            if(!identificacion.getID().equals("")) {
                serializer.startTag("", "IDENTIFICACION");
                escribirCampoXml(serializer, "ID", identificacion.getID());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_RUC, identificacion.getNUM_RUC());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_RAZON, identificacion.getRAZON_SOCIAL());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_NOMBRE, identificacion.getNOM_COMER_MYPE());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_WEB, identificacion.getPAGWEB());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_WEBNO, identificacion.getPAGWEB_NO());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CORREO, identificacion.getCORREO());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CORREONO, identificacion.getCORREO_NO());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_FIJO, identificacion.getTELFIJO());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_FIJONO, identificacion.getTELFIJO_NO());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_MOVIL, identificacion.getTELMOVIL());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_MOVILNO, identificacion.getTELMOVIL_NO());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_ANIO_FUNCIONAMIENTO, identificacion.getANO_INI());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CONDUCTOR_NOMBRE, identificacion.getCOND_APEL_NOM());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CONDUCTOR_SEXO, identificacion.getCOND_SEXO());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CONDUCTOR_EDAD, identificacion.getCOND_EDAD());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CONDUCTOR_ESTUDIOS, identificacion.getCOND_NEST());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO, identificacion.getINFOR_CARGO());
                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO_ESP, identificacion.getINFOR_CARGO_O());
                serializer.endTag("", "IDENTIFICACION");
            }
            if(!modulo1.getID().equals("")) {
                serializer.startTag("", "MODULO1");
                escribirCampoXml(serializer, "ID", modulo1.getID());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_101,modulo1.getP_101());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_101_1,modulo1.getP_101_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_101_1_O,modulo1.getP_101_1_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102A,modulo1.getP_102A());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102_1,modulo1.getP_102_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102B,modulo1.getP_102B());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102_2,modulo1.getP_102_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102C,modulo1.getP_102C());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102_3,modulo1.getP_102_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102D,modulo1.getP_102D());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102_4,modulo1.getP_102_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_103,convertir(modulo1.getP_103()));
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_103_O,modulo1.getP_103_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_104,modulo1.getP_104());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_105,modulo1.getP_105());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_106_1,modulo1.getP_106_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_106_2,modulo1.getP_106_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_106_3,modulo1.getP_106_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_106_4,modulo1.getP_106_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_106_5,modulo1.getP_106_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_107_1,modulo1.getP_107_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_107_2,modulo1.getP_107_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_107_3,modulo1.getP_107_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_108,modulo1.getP_108());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_1,modulo1.getP_109_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_2,modulo1.getP_109_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_3,modulo1.getP_109_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_4,modulo1.getP_109_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_5,modulo1.getP_109_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_6,modulo1.getP_109_6());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_6_O,modulo1.getP_109_6_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_1,modulo1.getP_110_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_2,modulo1.getP_110_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_3,modulo1.getP_110_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_4,modulo1.getP_110_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_5,modulo1.getP_110_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_6,modulo1.getP_110_6());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_7,modulo1.getP_110_7());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_7_O,modulo1.getP_110_7_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_111,modulo1.getP_111());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_112,modulo1.getP_112());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_112_O,modulo1.getP_112_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_113_1,modulo1.getP_113_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_113_2,modulo1.getP_113_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_113_3,modulo1.getP_113_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_113_4,modulo1.getP_113_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_113_5,modulo1.getP_113_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_113_5_O,modulo1.getP_113_5_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_1,modulo1.getP_114_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_2,modulo1.getP_114_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_3,modulo1.getP_114_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_4,modulo1.getP_114_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_5,modulo1.getP_114_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_6,modulo1.getP_114_6());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_7,modulo1.getP_114_7());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_7_O,modulo1.getP_114_7_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION100_OBS,modulo1.getOBS());
                serializer.endTag("", "MODULO1");
            }
            if(!modulo2.getID().equals("")) {
                serializer.startTag("", "MODULO2");
                escribirCampoXml(serializer, "ID", modulo2.getID());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_201_1,modulo2.getP_201_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_201_2,modulo2.getP_201_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_201_3,modulo2.getP_201_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_201_4,modulo2.getP_201_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_202,modulo2.getP_202());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_203,modulo2.getP_203());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_203_O,modulo2.getP_203_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_204,modulo2.getP_204());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_205_1,modulo2.getP_205_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_205_2,modulo2.getP_205_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_205_3,modulo2.getP_205_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_205_4,modulo2.getP_205_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_205_5,modulo2.getP_205_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_205_6,modulo2.getP_205_6());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_P_205_6_O,modulo2.getP_205_6_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION200_OBS,modulo2.getOBS());
                serializer.endTag("", "MODULO2");
            }
            if(!modulo3.getID().equals("")) {
                serializer.startTag("", "MODULO3");
                escribirCampoXml(serializer, "ID", modulo3.getID());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_301,modulo3.getP_301());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302,modulo3.getP_302());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_M_1,modulo3.getP_302A_M_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_M_2,modulo3.getP_302A_M_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_M_3,modulo3.getP_302A_M_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_M_4,modulo3.getP_302A_M_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_M_4_O,modulo3.getP_302A_M_4_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_L_1,modulo3.getP_302A_L_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_L_2,modulo3.getP_302A_L_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_L_3,modulo3.getP_302A_L_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_L_4,modulo3.getP_302A_L_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_L_4_O,modulo3.getP_302A_L_4_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_P_1,modulo3.getP_302A_P_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_P_2,modulo3.getP_302A_P_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_P_3,modulo3.getP_302A_P_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_P_4,modulo3.getP_302A_P_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_P_5,modulo3.getP_302A_P_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_P_5_O,modulo3.getP_302A_P_5_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_T_1,modulo3.getP_302A_T_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_T_2,modulo3.getP_302A_T_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_T_3,modulo3.getP_302A_T_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_T_4,modulo3.getP_302A_T_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_T_4_O,modulo3.getP_302A_T_4_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_V_1,modulo3.getP_302A_V_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_V_2,modulo3.getP_302A_V_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_V_3,modulo3.getP_302A_V_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_V_3_O,modulo3.getP_302A_V_3_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_O_1,modulo3.getP_302A_O_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302A_O_1_O,modulo3.getP_302A_O_1_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_M_1,modulo3.getP_302B_M_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_M_2,modulo3.getP_302B_M_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_M_3,modulo3.getP_302B_M_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_M_4,modulo3.getP_302B_M_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_L_1,modulo3.getP_302B_L_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_L_2,modulo3.getP_302B_L_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_L_3,modulo3.getP_302B_L_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_L_4,modulo3.getP_302B_L_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_P_1,modulo3.getP_302B_P_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_P_2,modulo3.getP_302B_P_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_P_3,modulo3.getP_302B_P_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_P_4,modulo3.getP_302B_P_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_P_5,modulo3.getP_302B_P_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_T_1,modulo3.getP_302B_T_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_T_2,modulo3.getP_302B_T_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_T_3,modulo3.getP_302B_T_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_T_4,modulo3.getP_302B_T_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_V_1,modulo3.getP_302B_V_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_V_2,modulo3.getP_302B_V_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_V_3,modulo3.getP_302B_V_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302B_O_1,modulo3.getP_302B_O_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_M_1,modulo3.getP_302C_M_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_M_2,modulo3.getP_302C_M_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_M_3,modulo3.getP_302C_M_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_M_4,modulo3.getP_302C_M_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_L_1,modulo3.getP_302C_L_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_L_2,modulo3.getP_302C_L_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_L_3,modulo3.getP_302C_L_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_L_4,modulo3.getP_302C_L_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_P_1,modulo3.getP_302C_P_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_P_2,modulo3.getP_302C_P_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_P_3,modulo3.getP_302C_P_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_P_4,modulo3.getP_302C_P_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_P_5,modulo3.getP_302C_P_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_T_1,modulo3.getP_302C_T_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_T_2,modulo3.getP_302C_T_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_T_3,modulo3.getP_302C_T_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_T_4,modulo3.getP_302C_T_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_V_1,modulo3.getP_302C_V_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_V_2,modulo3.getP_302C_V_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_V_3,modulo3.getP_302C_V_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_302C_O_1,modulo3.getP_302C_O_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_303_1,modulo3.getP_303_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_303_2,modulo3.getP_303_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_303_3,modulo3.getP_303_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_303_4,modulo3.getP_303_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_303_5,modulo3.getP_303_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_304,modulo3.getP_304());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_P_305,modulo3.getP_305());
                escribirCampoXml(serializer, SQLConstantes.SECCION300_OBS,modulo3.getOBS());
                serializer.endTag("", "MODULO3");
            }
            if(!modulo4.getID().equals("")) {
                serializer.startTag("", "MODULO4");
                escribirCampoXml(serializer, "ID", modulo4.getID());

                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_401_1,modulo4.getP_401_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_401_2,modulo4.getP_401_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_401_3,modulo4.getP_401_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_401_4,modulo4.getP_401_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_401_5,modulo4.getP_401_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_402,modulo4.getP_402());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_403_1,modulo4.getP_403_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_403_2,modulo4.getP_403_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_403_3,modulo4.getP_403_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_403_4,modulo4.getP_403_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_404,modulo4.getP_404());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_405,modulo4.getP_405());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_406,modulo4.getP_406());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_407_1,modulo4.getP_407_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_407_2,modulo4.getP_407_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_407_3,modulo4.getP_407_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_407_4,modulo4.getP_407_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_407_5,modulo4.getP_407_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_407_6,modulo4.getP_407_6());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_407_7,modulo4.getP_407_7());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_407_7_O,modulo4.getP_407_7_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_408_1,modulo4.getP_408_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_408_2,modulo4.getP_408_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_408_3,modulo4.getP_408_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_408_4,modulo4.getP_408_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_408_5,modulo4.getP_408_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_408_6,modulo4.getP_408_6());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_408_6_O,modulo4.getP_408_6_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_409_1,modulo4.getP_409_1());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_409_2,modulo4.getP_409_2());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_409_3,modulo4.getP_409_3());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_409_4,modulo4.getP_409_4());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_409_5,modulo4.getP_409_5());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_409_5_O,modulo4.getP_409_5_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_410,modulo4.getP_410());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_P_410_O,modulo4.getP_410_O());
                escribirCampoXml(serializer, SQLConstantes.SECCION400_OBS,modulo4.getOBS());
                serializer.endTag("", "MODULO4");
            }

            serializer.endTag("", "ENCAMY");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "ENCAMY5");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
//            IOHelper.writeToFile(this, "cities.xml", result);
//                    txtXml.setText("From writeToXmlFile\n" + result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    void escribirCampoXml(XmlSerializer s, String campo,String valor){
        try {
            s.startTag("", campo);
            if(valor != null) s.text(valor);
            else s.text("");
            s.endTag("", campo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class MyAsyncTask extends AsyncTask<Integer,Integer,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtMensaje.setText("Exportando...");
            txtMensaje.setVisibility(View.VISIBLE);
            progreso.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            String mensaje = "";
            int i = 1;
            for(ExportarItem exportarItem : exportarItems){
                if(exportarItem.getSeleccionado() == 1){
                    //aqui exporta
                    exportarEmpresa(exportarItem.getIdEmpresa());
                    publishProgress(i);
                }
                i++;
            }
            return "Listo";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progreso.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String string) {
            super.onPostExecute(string);
            txtMensaje.setText(string);
            progreso.setVisibility(View.GONE);
            txtMensaje.setVisibility(View.GONE);
            Toast.makeText(ExportarActivity.this, "Exportacion Completa", Toast.LENGTH_SHORT).show();
        }
    }

    public String convertir(String num){
        String valor = "";
        if(!num.equals("")){
            int n = Integer.parseInt(num) + 1;
            valor = valor + n;
        }
        return valor;
    }
}
