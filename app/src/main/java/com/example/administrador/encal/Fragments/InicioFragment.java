package com.example.administrador.encal.Fragments;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Modelo.SQLConstantes;
import com.example.administrador.encal.NumericKeyBoardTransformationMethod;
import com.example.administrador.encal.Pojos.IdentificacionPojo;
import com.example.administrador.encal.Pojos.Marco;
import com.example.administrador.encal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {
    private EditText inicio_edt1;
    private EditText inicio_edt2;
    private EditText inicio_edt3;
    private EditText inicio_edt4;
    private EditText inicio_edt5;
    private EditText inicio_edt6;
    private EditText inicio_edt7;
    private EditText inicio_edt8;
    private EditText inicio_edt9;
    private EditText inicio_edt11;
    private EditText inicio_edt14;
    private EditText edtEspecifique;

    private CheckBox inicio_ck1;
    private CheckBox inicio_ck2;
    private CheckBox inicio_ck3;
    private CheckBox inicio_ck4;

    private Spinner inicio_sp1;
    private Spinner inicio_sp2;
    private Spinner inicio_sp3;

    private RadioGroup inicio_rg;


    private TextView txtError4;
    private TextView txtError12;


    private String idEmpresa;
    private IdentificacionPojo identificacion;
    private Context context;
    private Data data;

    //mapeo de variables
    public String NUM_RUC;
    public String RAZON_SOCIAL;
    public String NOM_COMER_MYPE;
    public String ANO_INI;
    public int PAGWEB_NO;
    public String PAGWEB;
    public int CORREO_NO;
    public String CORREO;
    public int TELFIJO_NO;
    public String TELFIJO;
    public int TELMOVIL_NO;
    public String TELMOVIL;
    public String COND_APEL_NOM;
    public int COND_SEXO;
    public String COND_EDAD;
    public int COND_NEST;
    public int INFOR_CARGO;
    public String INFOR_CARGO_O;
    public String INFOR_APEL_NOM;
    public int CONOCE_INACAL;

    public InicioFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public InicioFragment(String idEmpresa, Context context) {
        this.idEmpresa = idEmpresa;
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_inicio, container, false);
        inicio_edt1 = (EditText) rootview.findViewById(R.id.inicio_edt1);
        inicio_edt2 = (EditText) rootview.findViewById(R.id.inicio_edt2);
        inicio_edt3 = (EditText) rootview.findViewById(R.id.inicio_edt3);
        inicio_edt4 = (EditText) rootview.findViewById(R.id.inicio_edt4);
        inicio_edt5 = (EditText) rootview.findViewById(R.id.inicio_edt5);
        inicio_edt6 = (EditText) rootview.findViewById(R.id.inicio_edt6);
        inicio_edt7 = (EditText) rootview.findViewById(R.id.inicio_edt7);
        inicio_edt8 = (EditText) rootview.findViewById(R.id.inicio_edt8);
        inicio_edt9 = (EditText) rootview.findViewById(R.id.inicio_edt9);
        inicio_edt11 = (EditText) rootview.findViewById(R.id.inicio_edt11);
        inicio_edt14 = (EditText) rootview.findViewById(R.id.inicio_edt14);
        edtEspecifique = (EditText) rootview.findViewById(R.id.inicio_edtEspecifique);
        inicio_ck1 = (CheckBox) rootview.findViewById(R.id.inicio_ck1);
        inicio_ck2 = (CheckBox) rootview.findViewById(R.id.inicio_ck2);
        inicio_ck3 = (CheckBox) rootview.findViewById(R.id.inicio_ck3);
        inicio_ck4 = (CheckBox) rootview.findViewById(R.id.inicio_ck4);
        inicio_sp1 = (Spinner) rootview.findViewById(R.id.inicio_sp1);
        inicio_sp2 = (Spinner) rootview.findViewById(R.id.inicio_sp2);
        inicio_sp3 = (Spinner) rootview.findViewById(R.id.inicio_sp3);
        txtError4 = (TextView) rootview.findViewById(R.id.inicio_txtError4);
        txtError12 = (TextView) rootview.findViewById(R.id.inicio_txtError12);
        inicio_rg = (RadioGroup) rootview.findViewById(R.id.inicio_rg);

        return rootview;


    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarDatos();
        EditText[] edts = {inicio_edt2, inicio_edt3, inicio_edt5, inicio_edt6,inicio_edt9, inicio_edt14, edtEspecifique};
        for (EditText c: edts) { c.setFilters(new InputFilter[]{new InputFilter.AllCaps()});}
        EditText[] edtsNumero = {inicio_edt1,inicio_edt4,inicio_edt7, inicio_edt8,  inicio_edt11};
        for (EditText r: edtsNumero) { r.setTransformationMethod(new NumericKeyBoardTransformationMethod());}

        inicio_edt1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        inicio_edt7.setFilters(new InputFilter[]{new InputFilter.LengthFilter(9)});
        inicio_edt8.setFilters(new InputFilter[]{new InputFilter.LengthFilter(9)});


        inicio_edt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    data = new Data(context);
                    data.open();
                    identificacion = data.getIdentificacion(idEmpresa);
                    Marco marco = data.getMarco(idEmpresa);
                    if(marco.getRUC().substring(0,2).equals("10")){
                        inicio_edt9.setText(inicio_edt9.getText().toString().replace(inicio_edt9.getText().toString(),charSequence)+"");
                        if (inicio_sp3.getSelectedItemPosition()==1 ||inicio_sp3.getSelectedItemPosition()==3){
                            inicio_edt14.setText(inicio_edt9.getText().toString());
                        }
                    }
                    data.close();


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String despues = "";
                if(!editable.toString().equals("")) despues = editable.toString();
                data = new Data(context);
                data.open();
                identificacion = data.getIdentificacion(idEmpresa);
                Marco marco = data.getMarco(idEmpresa);
                if(marco.getRUC().substring(0,2).equals("10")){
                    if(!inicio_edt9.getText().toString().equals("")){
                        inicio_edt9.setText(inicio_edt9.getText().toString().replace(inicio_edt9.getText().toString(),despues)+"");
                        if (inicio_sp3.getSelectedItemPosition()==1 ||inicio_sp3.getSelectedItemPosition()==3){
                            inicio_edt14.setText(inicio_edt9.getText().toString());
                        }
                    }else{
                        inicio_edt9.setText(despues+"");
                        if (inicio_sp3.getSelectedItemPosition()==1 ||inicio_sp3.getSelectedItemPosition()==3){
                            inicio_edt14.setText(inicio_edt9.getText().toString());
                        }

                    }
                }
                data.close();
            }
        });
        inicio_edt9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().equals("")){
                        if (inicio_sp3.getSelectedItemPosition()==1 ||inicio_sp3.getSelectedItemPosition()==3){
                           // inicio_edt14.setText(inicio_edt9.getText().toString());
                            inicio_edt14.setText(inicio_edt14.getText().toString().replace(inicio_edt14.getText().toString(),charSequence)+"");
                        }
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String despues = "";
                if(!editable.toString().equals("")) despues = editable.toString();
                    if(!inicio_edt14.getText().toString().equals("")){
                        if (inicio_sp3.getSelectedItemPosition()==1 ||inicio_sp3.getSelectedItemPosition()==3){
                            inicio_edt14.setText(inicio_edt14.getText().toString().replace(inicio_edt14.getText().toString(),despues)+"");
                        }
                    }else{
                        if (inicio_sp3.getSelectedItemPosition()==1 ||inicio_sp3.getSelectedItemPosition()==3){
                            inicio_edt14.setText(despues+"");
                        }

                    }

            }
        });

        validarAnio(inicio_edt4,txtError4);

//        okLayout(inicio_edt6,lytP7);
//        okLayout(inicio_edt9,lytP10);
//        okLayout(inicio_edt10,lytP10);
//        okLayout(inicio_edt12,lytP10);

        validarEdad(inicio_edt11,txtError12);

        checkNoTiene(inicio_ck1,inicio_edt5);
        checkNoTiene(inicio_ck2,inicio_edt6);
        checkNoTiene(inicio_ck4,inicio_edt8);



        inicio_ck3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    //inicio_lyt1.setBackgroundResource(R.drawable.fondo_spinner_disabled);
                    inicio_edt7.setText("");
                    inicio_edt7.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
                    inicio_edt7.setEnabled(false);
                }else{
                    //inicio_lyt1.setBackgroundResource(R.drawable.fondo_spinner);
                    inicio_edt7.setBackgroundResource(R.drawable.fondo_edit_text);
                    inicio_edt7.setEnabled(true);
                }
            }
        });

        inicio_sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                edtEspecifique.setVisibility(View.GONE);
                edtEspecifique.setEnabled(false);
                edtEspecifique.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
                String op =inicio_edt9.getText().toString();
                switch (pos){
                    case 0:break;
                    case 1: inicio_edt14.setText(op);break;
                    case 2:break;
                    case 3:inicio_edt14.setText(op);break;
                    case 4:
                        edtEspecifique.setVisibility(View.VISIBLE);
                        edtEspecifique.setEnabled(true);
                        edtEspecifique.setBackgroundResource(R.drawable.fondo_edit_text);
                        edtEspecifique.requestFocus();
                        break;
                }
                if (pos >= 0 && pos <4){
                    edtEspecifique.setText("");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

    }
    public void llenarMapaVariables(){
        llenarVariablesEdit();
        llenarVariablesCheck();
        llenarVariablesSpinner();
        int childPosP2 = inicio_rg.indexOfChild(inicio_rg.findViewById(inicio_rg.getCheckedRadioButtonId()));
        CONOCE_INACAL = childPosP2;

    }


    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void cargarDatos(){
        data = new Data(context);
        data.open();
        identificacion = data.getIdentificacion(idEmpresa);
        if(identificacion.getID().equals("")){
            Marco marco = data.getMarco(idEmpresa);
            identificacion.setNUM_RUC(marco.getRUC());
            identificacion.setRAZON_SOCIAL(marco.getRAZON_SOCIAL());
            identificacion.setNOM_COMER_MYPE(marco.getNOMBRE_COMERCIAL());
            if(identificacion.getNUM_RUC().substring(0,2).equals("10")){
                identificacion.setCOND_APEL_NOM(marco.getRAZON_SOCIAL());
            }

        }
        data.close();
        inicio_edt1.setText(identificacion.getNUM_RUC());
        inicio_edt2.setText(identificacion.getRAZON_SOCIAL());
        inicio_edt3.setText(identificacion.getNOM_COMER_MYPE());
        inicio_edt4.setText(identificacion.getANO_INI());

        int ckPagWeb = 0;
        if(!identificacion.getPAGWEB_NO().equals("")) ckPagWeb = Integer.parseInt(identificacion.getPAGWEB_NO());
        int ckCorreo = 0;
        if(!identificacion.getCORREO_NO().equals("")) ckCorreo = Integer.parseInt(identificacion.getCORREO_NO());
        int ckTelFijo = 0;
        if(!identificacion.getTELFIJO_NO().equals("")) ckTelFijo = Integer.parseInt(identificacion.getTELFIJO_NO());
        int ckTelMovil = 0;
        if(!identificacion.getTELMOVIL_NO().equals("")) ckTelMovil = Integer.parseInt(identificacion.getTELMOVIL_NO());

        if(ckPagWeb == 1){
            inicio_ck1.setChecked(true);
            inicio_edt5.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
            inicio_edt5.setEnabled(false);
        }
        if(ckPagWeb == 0){
            inicio_ck1.setChecked(false);
            inicio_edt5.setText(identificacion.getPAGWEB());
        }
        if(ckCorreo == 1){
            inicio_ck2.setChecked(true);
            inicio_edt6.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
            inicio_edt6.setEnabled(false);
        }
        if(ckCorreo == 0){
            inicio_ck2.setChecked(false);
            inicio_edt6.setText(identificacion.getCORREO());
        }
        if(ckTelFijo == 1){
            inicio_ck3.setChecked(true);
            //inicio_lyt1.setBackgroundResource(R.drawable.fondo_spinner_disabled);
            inicio_edt7.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
            inicio_edt7.setEnabled(false);
        }
        if(ckTelFijo == 0){
            inicio_ck3.setChecked(false);
            inicio_edt7.setText(identificacion.getTELFIJO());
        }
        if(ckTelMovil == 1){
            inicio_ck4.setChecked(true);
            inicio_edt8.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
            inicio_edt8.setEnabled(false);
        }
        if(ckTelMovil == 0){
            inicio_ck4.setChecked(false);
            inicio_edt8.setText(identificacion.getTELMOVIL());
        }
        //
            inicio_edt9.setText(identificacion.getCOND_APEL_NOM());
        //}

        if(!identificacion.getCOND_SEXO().equals("")) inicio_sp1.setSelection(Integer.parseInt(identificacion.getCOND_SEXO()));
        inicio_edt11.setText(identificacion.getCOND_EDAD());
        if(!identificacion.getCOND_NEST().equals(""))inicio_sp2.setSelection(Integer.parseInt(identificacion.getCOND_NEST()));
        if(!identificacion.getINFOR_CARGO().equals(""))inicio_sp3.setSelection(Integer.parseInt(identificacion.getINFOR_CARGO()));
        edtEspecifique.setText(identificacion.getINFOR_CARGO_O());
        inicio_edt14.setText(identificacion.getINFOR_APEL_NOM());
        if(!identificacion.getCONOCE_INACAL().equals("") && !identificacion.getCONOCE_INACAL().equals("-1")){
            ((RadioButton)inicio_rg.getChildAt(Integer.parseInt(identificacion.getCONOCE_INACAL()))).setChecked(true);
        }
    }

    public void guardarDatos(){
        llenarMapaVariables();
        data = new Data(context);
        data.open();
        if(data.existeIdentificacion(idEmpresa)){
            ContentValues contentValues = new ContentValues(21);
            contentValues.put(SQLConstantes.IDENTIFICACION_RUC,inicio_edt1.getText().toString());
            contentValues.put(SQLConstantes.IDENTIFICACION_RAZON,inicio_edt2.getText().toString());
            contentValues.put(SQLConstantes.IDENTIFICACION_NOMBRE,inicio_edt3.getText().toString());
            contentValues.put(SQLConstantes.IDENTIFICACION_ANIO_FUNCIONAMIENTO,inicio_edt4.getText().toString());
            if(inicio_ck1.isChecked())contentValues.put(SQLConstantes.IDENTIFICACION_WEBNO,"1");
            if(!inicio_ck1.isChecked())contentValues.put(SQLConstantes.IDENTIFICACION_WEBNO,"0");
            contentValues.put(SQLConstantes.IDENTIFICACION_WEB,inicio_edt5.getText().toString());
            if(inicio_ck2.isChecked())contentValues.put(SQLConstantes.IDENTIFICACION_CORREONO,"1");
            if(!inicio_ck2.isChecked())contentValues.put(SQLConstantes.IDENTIFICACION_CORREONO,"0");
            contentValues.put(SQLConstantes.IDENTIFICACION_CORREO,inicio_edt6.getText().toString());
            if(inicio_ck3.isChecked())contentValues.put(SQLConstantes.IDENTIFICACION_FIJONO,"1");
            if(!inicio_ck3.isChecked())contentValues.put(SQLConstantes.IDENTIFICACION_FIJONO,"0");
            contentValues.put(SQLConstantes.IDENTIFICACION_FIJO,inicio_edt7.getText().toString());
            if(inicio_ck4.isChecked())contentValues.put(SQLConstantes.IDENTIFICACION_MOVILNO,"1");
            if(!inicio_ck4.isChecked())contentValues.put(SQLConstantes.IDENTIFICACION_MOVILNO,"0");
            contentValues.put(SQLConstantes.IDENTIFICACION_MOVIL,inicio_edt8.getText().toString());
            contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_NOMBRE,inicio_edt9.getText().toString());
            contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_SEXO,String.valueOf(inicio_sp1.getSelectedItemPosition()));
            contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_EDAD,inicio_edt11.getText().toString());
            contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_ESTUDIOS,String.valueOf(inicio_sp2.getSelectedItemPosition()));
            contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO,String.valueOf(inicio_sp3.getSelectedItemPosition()));
            contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO_ESP,edtEspecifique.getText().toString());
            contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_APEYNOM,inicio_edt14.getText().toString());
            contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_CONOCE_INACAL,CONOCE_INACAL+"");
            data.actualizarIdentificacion(idEmpresa,contentValues);
        }else{
            identificacion = new IdentificacionPojo();
            identificacion.setID(idEmpresa);
            identificacion.setNUM_RUC(inicio_edt1.getText().toString());
            identificacion.setRAZON_SOCIAL(inicio_edt2.getText().toString());
            identificacion.setNOM_COMER_MYPE(inicio_edt3.getText().toString());
            identificacion.setANO_INI(inicio_edt4.getText().toString());
            if(inicio_ck1.isChecked())identificacion.setPAGWEB_NO("1");
            if(!inicio_ck1.isChecked())identificacion.setPAGWEB_NO("0");
            identificacion.setPAGWEB(inicio_edt5.getText().toString());
            if(inicio_ck2.isChecked())identificacion.setCORREO_NO("1");
            if(!inicio_ck2.isChecked())identificacion.setCORREO_NO("0");
            identificacion.setCORREO(inicio_edt6.getText().toString());
            if(inicio_ck3.isChecked())identificacion.setTELFIJO_NO("1");
            if(!inicio_ck3.isChecked())identificacion.setTELFIJO_NO("0");
            identificacion.setTELFIJO(inicio_edt7.getText().toString());
            if(inicio_ck4.isChecked())identificacion.setTELMOVIL_NO("1");
            if(!inicio_ck4.isChecked())identificacion.setTELMOVIL_NO("0");
            identificacion.setTELMOVIL(inicio_edt8.getText().toString());
            identificacion.setCOND_APEL_NOM(inicio_edt9.getText().toString());
            identificacion.setCOND_SEXO(String.valueOf(inicio_sp1.getSelectedItemPosition()));
            identificacion.setCOND_EDAD(inicio_edt11.getText().toString());
            identificacion.setCOND_NEST(String.valueOf(inicio_sp2.getSelectedItemPosition()));
            identificacion.setINFOR_CARGO(String.valueOf(inicio_sp3.getSelectedItemPosition()));
            identificacion.setINFOR_CARGO_O(edtEspecifique.getText().toString());
            identificacion.setINFOR_APEL_NOM(inicio_edt14.getText().toString());
            identificacion.setCONOCE_INACAL(CONOCE_INACAL+"");
            data.insertarIdentificacion(identificacion);
        }
        data.close();
    }
    public boolean validar(){
        boolean valido = true;
        String mensaje = "";
        llenarMapaVariables();
        boolean vCONOCE=false;boolean vNUM_RUC=false; boolean vRAZON_SOCIAL=false; boolean vNOM_COMER_MYPE=false;
        boolean vANIO_FUNDACION=false;boolean vPAG_WEB=false; boolean vCORREO=false, vTelefonoMovil = true, condTelFijo1=true,condTelFijo2=true;
        boolean vTEL_MOVIL=false; boolean vANIO_OPERACION=false; boolean vNOM_INFORMANTE=false;
        boolean vSEXO_INFORMANTE=false; boolean vEDAD_INFORMANTE=false; boolean vACAD_INFORMANTE=false; boolean vCARGO_INFORMANTE=false; boolean vCARGO_INFORMANTE_ESP=false;
        boolean vTEL_FIJO=false; boolean vINFORMANTE_NOM=false;

        if(NUM_RUC.trim().length() != 0)vNUM_RUC=true;
        else if(mensaje.equals(""))mensaje = "DEBE REGISTRAR RUC";

        if(RAZON_SOCIAL.trim().length() != 0)vRAZON_SOCIAL=true;
        else if(mensaje.equals(""))mensaje = "DEBE REGISTRAR LA RAZON SOCIAL";
        if(NOM_COMER_MYPE.trim().length() != 0)vNOM_COMER_MYPE=true;
        else if(mensaje.equals(""))mensaje = "DEBE EXISTIR NOMBRE COMERCIAL DE LA MYPE";
        if(ANO_INI.trim().length() != 0){
            if(Integer.parseInt(ANO_INI)>=1900 && Integer.parseInt(ANO_INI)<=2016) vANIO_FUNDACION=true;
            else if(mensaje.equals(""))mensaje = "DEBE REGISTRAR UN AÑO VALIDO";
        }
        else if(mensaje.equals(""))mensaje = "AÑO DE INICIO DE FUNCIONAMIENTO DEBE ESTAR ENTRE LOS AÃ‘OS 1900 A 2016";
        if(PAGWEB_NO==1) vPAG_WEB=true;
        if(PAGWEB_NO==0) {
            if(PAGWEB.trim().length() != 0) {
                if (PAGWEB.indexOf(".")!=-1){
                    vPAG_WEB = true;
                }else if(mensaje.equals(""))mensaje = "DEBE INCLUIR EL (.PUNTO)";
            }
            else if(mensaje.equals(""))mensaje = "DEBE EXISTIR INFORMACUION EN PAGINA WEB";
        }
        if(CORREO_NO==1) vCORREO=true;
        if(CORREO_NO==0) {
            if(CORREO.trim().length() != 0){
                if (CORREO.indexOf("@")!=-1){
                    vCORREO=true;
                }else if(mensaje.equals(""))mensaje = "DEBE INCLUIR EL @";
            }
            else if(mensaje.equals(""))mensaje = "DEBE REGISTRAR CORREO ELECTRONICO O INDICAR QUE NO TIENE";
        }
        if(TELFIJO_NO==1){ vTEL_FIJO=true;}
        if(TELFIJO_NO==0) {
            if(TELFIJO.trim().length() != 0) vTEL_FIJO=true;
            else if(mensaje.equals(""))mensaje = "DEBE EXISTIR INFORMACION EN TELEFONO FIJO";
        }
        if(TELMOVIL_NO==1) vTEL_MOVIL=true;
        if(TELMOVIL_NO==0) {
            if(TELMOVIL.trim().length() == 9)vTEL_MOVIL=true;
            else if(mensaje.equals(""))mensaje = "DEBE EXISTIR INFORMACION EN TELEFONO MOVIL";
        }
        if(TELFIJO_NO == 1 && TELMOVIL_NO == 1){
            vTelefonoMovil = false;
            if(mensaje.equals(""))mensaje = "TELEFONO: DEBE REGISTRAR TELEFONO FIJO O DE CELULAR";
        }
        if(COND_APEL_NOM.trim().length() != 0)vNOM_INFORMANTE=true;
        else if(mensaje.equals(""))mensaje = "DEBE REGISTRAR NOMBRE DEL CONDUCTOR";
        if(COND_EDAD.trim().length() != 0)vEDAD_INFORMANTE=true;
        else if(mensaje.equals(""))mensaje = "DEBE REGISTRAR LA EDAD DEL INFORMANTE";
        if(COND_SEXO!=0)vSEXO_INFORMANTE=true;
        else if(mensaje.equals(""))mensaje = "DEBE INDICAR SEXO DEL INFORMANTE";
        if(COND_NEST!=0)vACAD_INFORMANTE=true;
        else if(mensaje.equals(""))mensaje = "DEBE INDICAR NIVEL DE ESTUDIOS";
        if(INFOR_CARGO!=0)vCARGO_INFORMANTE=true;
        else if(mensaje.equals(""))mensaje = "DEBE INDICAR CARGO DEL INFORMANTE";
        if(INFOR_CARGO== 4) {
            if(INFOR_CARGO_O.trim().length() >= 3){
                vCARGO_INFORMANTE_ESP=true;
            }else if(mensaje.equals(""))mensaje = "DEBE REGISTRAR INFORMACION VALIDA EN ESPECIFIQUE";
        }else vCARGO_INFORMANTE_ESP=true;
        if(INFOR_APEL_NOM.trim().length() >= 3){
            vINFORMANTE_NOM=true;
        }else if(mensaje.equals(""))mensaje = "DEBE INGRESAR NOMBRE DEL INFORMANTE";
        if(CONOCE_INACAL != -1){
            vCONOCE=true;
        }else if(mensaje.equals(""))mensaje = "DEBE MARCAR SI/NO CONOCE INACAL E";


        valido= vNUM_RUC &&  vRAZON_SOCIAL &&  vANIO_FUNDACION && vPAG_WEB &&vNOM_COMER_MYPE&&
                vCORREO && vTEL_MOVIL &&vNOM_INFORMANTE&& vSEXO_INFORMANTE &&  vEDAD_INFORMANTE &&  vACAD_INFORMANTE &&
                vCARGO_INFORMANTE &&  vCARGO_INFORMANTE_ESP &&  vTEL_FIJO && vTelefonoMovil &&vINFORMANTE_NOM && vCONOCE;
        if(!valido){
            mostrarMensaje(mensaje);
            Log.d("vNUM_RUC" , vNUM_RUC+"");
            Log.d("vRAZON_SOCIAL",vRAZON_SOCIAL+"");
            Log.d("vANIO_FUNDACION",vANIO_FUNDACION+"");
            Log.d("vPAG_WEB",vPAG_WEB+"");
            Log.d("vCORREO",vCORREO+"");
            Log.d("vTEL_MOVIL",vTEL_MOVIL+"");
            Log.d("vANIO_OPERACION",vANIO_OPERACION+"");
            Log.d("vNOM_INFORMANTE",vNOM_INFORMANTE+"");
            Log.d("vSEXO_INFORMANTE",vSEXO_INFORMANTE+"");
            Log.d("vEDAD_INFORMANTE",vEDAD_INFORMANTE+"");
            Log.d("vACAD_INFORMANTE",vACAD_INFORMANTE+"");
            Log.d("vCARGO_INFORMANTE",vCARGO_INFORMANTE+"");
            Log.d("vCARGO_INFORMANTE_ESP",vCARGO_INFORMANTE_ESP+"");
            Log.d("vTEL_FIJO",vTEL_FIJO+"");
        }
        return valido;
    }


    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void validarAnio(final EditText editText, final TextView textView){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                int despues = 0;
                if (!editable.toString().equals("")) despues = Integer.parseInt(editable.toString());
                if(despues > 1000){
                    if(despues<1900 || despues >2017){
                        //editText.setBackgroundResource(R.drawable.fondo_edit_text_error);
                        textView.setText("Debe ingresar un año en el rango de 1900 a 2016");
                    } else{
                        editText.setBackgroundResource(R.drawable.fondo_edit_text);
                        textView.setText("");
                    }
                }
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    if(!editText.getText().toString().equals("")){
                        int valor =Integer.parseInt(editText.getText().toString());
                        if(valor < 1900 || valor >2017){
                            //editText.setBackgroundResource(R.drawable.fondo_edit_text_error);
                            textView.setText("Debe ingresar un año en el rango de 1900 a 2016");
                        }else{
                            editText.setBackgroundResource(R.drawable.fondo_edit_text);
                            textView.setText("");
                        }
                    }else{
                        editText.setBackgroundResource(R.drawable.fondo_edit_text);
                        textView.setText("");
                    }

                }
            }
        });
    }

    public void validarEdad(final EditText editText, final TextView textView){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                int despues = 0;
                if (!editable.toString().equals("")) despues = Integer.parseInt(editable.toString());
                if(despues > 10){
                    if(despues<18 || despues >99){
                        //editText.setBackgroundResource(R.drawable.fondo_edit_text_error);
                        textView.setText("Rango edad: 18 a 99");
                    } else{
                        editText.setBackgroundResource(R.drawable.fondo_edit_text);
                        textView.setText("");
                    }
                }
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    if(!editText.getText().toString().equals("")){
                        int valor =Integer.parseInt(editText.getText().toString());
                        if(valor < 18 || valor >99){
                            //editText.setBackgroundResource(R.drawable.fondo_edit_text_error);
                            textView.setText("Rango edad: 18 a 99");
                        }else{
                            editText.setBackgroundResource(R.drawable.fondo_edit_text);
                            textView.setText("");
                        }
                    }else{
                        editText.setBackgroundResource(R.drawable.fondo_edit_text);
                        textView.setText("");
                    }

                }
            }
        });
    }

//    public void okLayout(final EditText editText, final LinearLayout linearLayout){
//        editText.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
//                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
//                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    ocultarTeclado(editText);
//                    linearLayout.requestFocus();
//                    return true;
//                }
//                return false;
//            }
//        });
//    }

    public void checkNoTiene(CheckBox checkBox, final EditText editText){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    editText.setEnabled(false);
                    editText.setText("");
                    editText.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
                }else{
                    editText.setEnabled(true);
                    editText.setBackgroundResource(R.drawable.fondo_edit_text);
                }
            }
        });
    }
    public void llenarVariablesEdit(){
        NUM_RUC = inicio_edt1.getText().toString();
        RAZON_SOCIAL = inicio_edt2.getText().toString() ;
        NOM_COMER_MYPE = inicio_edt3.getText().toString() ;
        ANO_INI = inicio_edt4.getText().toString();
        PAGWEB = inicio_edt5.getText().toString();
        CORREO = inicio_edt6.getText().toString();
        TELFIJO = inicio_edt7.getText().toString();
        TELMOVIL = inicio_edt8.getText().toString();
        COND_APEL_NOM = inicio_edt9.getText().toString();
        COND_EDAD = inicio_edt11.getText().toString();
        INFOR_CARGO_O= edtEspecifique.getText().toString();
        INFOR_APEL_NOM = inicio_edt14.getText().toString();
    }

    public void llenarVariablesCheck(){
        if(inicio_ck1.isChecked())PAGWEB_NO=1;
        else PAGWEB_NO = 0;
        if(inicio_ck2.isChecked())CORREO_NO=1;
        else CORREO_NO = 0;
        if(inicio_ck3.isChecked())TELFIJO_NO=1;
        else TELFIJO_NO = 0;
        if(inicio_ck4.isChecked())TELMOVIL_NO=1;
        else TELMOVIL_NO = 0;
    }

    public void llenarVariablesSpinner(){
        COND_SEXO = inicio_sp1.getSelectedItemPosition();
        COND_NEST = inicio_sp2.getSelectedItemPosition();
        INFOR_CARGO = inicio_sp3.getSelectedItemPosition();
    }


}
