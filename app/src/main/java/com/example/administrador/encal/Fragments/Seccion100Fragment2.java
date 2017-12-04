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
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Modelo.SQLConstantes;
import com.example.administrador.encal.NumericKeyBoardTransformationMethod;
import com.example.administrador.encal.Pojos.Sec100PojoF1;
import com.example.administrador.encal.Pojos.Sec200PojoF1;
import com.example.administrador.encal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Seccion100Fragment2 extends Fragment {
    private EditText p106_edt1;
    private EditText p106_edt2;
    private EditText p106_edt3;
    private EditText p106_edt4;
    private TextView p106_txt;

    private CheckBox p107_ck1;
    private CheckBox p107_ck2;
    private CheckBox p107_ck3;

    private RadioGroup p108_rg1;

    private CheckBox p109_ck1;
    private CheckBox p109_ck2;
    private CheckBox p109_ck3;
    private CheckBox p109_ck4;
    private CheckBox p109_ck5;
    private CheckBox p109_ck6;
    private EditText p109_edt;

    private CheckBox p110_ck1;
    private CheckBox p110_ck2;
    private CheckBox p110_ck3;
    private CheckBox p110_ck4;
    private CheckBox p110_ck5;
    private CheckBox p110_ck6;
    private CheckBox p110_ck7;
    private EditText p110_edt;

    private int sec100_p105;

    private String idempresa;
    private Sec100PojoF1 sec100PojoF1;
    private Context context;
    private Data data;

    //mapeo de variables
    String P_106_1;String P_106_2;String P_106_3;String P_106_4;String P_106_5;
    int P_107_1;int P_107_2;int P_107_3;int P_108;int P_109_1;int P_109_2;
    int P_109_3;int P_109_4;int P_109_5;int P_109_6;String P_109_6_O;
    int P_110_1;int P_110_2;int P_110_3;int P_110_4;int P_110_5;int P_110_6;int P_110_7;String P_110_7_O;;

    public Seccion100Fragment2() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Seccion100Fragment2(String idempresa, Context context) {
        this.idempresa = idempresa;
        this.context = context;
        Data data = new Data(context);
        data.open();
        if (!data.getModulo1(idempresa).getP_105().equals("")){
            sec100_p105 = Integer.parseInt(data.getModulo1(idempresa).getP_105());
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment2_s100, container, false);
        p106_edt1 = (EditText) view.findViewById(R.id.sec100_p106_edt1);
        p106_edt2 = (EditText) view.findViewById(R.id.sec100_p106_edt2);
        p106_edt3 = (EditText) view.findViewById(R.id.sec100_p106_edt3);
        p106_edt4 = (EditText) view.findViewById(R.id.sec100_p106_edt4);
        p106_txt = (TextView) view.findViewById(R.id.sec100_p106_txt1);

        p107_ck1 = (CheckBox) view.findViewById(R.id.sec100_p107_ck1);
        p107_ck2 = (CheckBox) view.findViewById(R.id.sec100_p107_ck2);
        p107_ck3 = (CheckBox) view.findViewById(R.id.sec100_p107_ck3);

        p108_rg1 = (RadioGroup) view.findViewById(R.id.sec100_p108_rg);

        p109_ck1 = (CheckBox) view.findViewById(R.id.sec100_p109_ck1);
        p109_ck2 = (CheckBox) view.findViewById(R.id.sec100_p109_ck2);
        p109_ck3 = (CheckBox) view.findViewById(R.id.sec100_p109_ck3);
        p109_ck4 = (CheckBox) view.findViewById(R.id.sec100_p109_ck4);
        p109_ck5 = (CheckBox) view.findViewById(R.id.sec100_p109_ck5);
        p109_ck6 = (CheckBox) view.findViewById(R.id.sec100_p109_ck6);
        p109_edt = (EditText) view.findViewById(R.id.txtEspecifique_p109);

        p110_ck1 = (CheckBox) view.findViewById(R.id.sec100_p110_ck1);
        p110_ck2 = (CheckBox) view.findViewById(R.id.sec100_p110_ck2);
        p110_ck3 = (CheckBox) view.findViewById(R.id.sec100_p110_ck3);
        p110_ck4 = (CheckBox) view.findViewById(R.id.sec100_p110_ck4);
        p110_ck5 = (CheckBox) view.findViewById(R.id.sec100_p110_ck5);
        p110_ck6 = (CheckBox) view.findViewById(R.id.sec100_p110_ck6);
        p110_ck7 = (CheckBox) view.findViewById(R.id.sec100_p110_ck7);
        p110_edt = (EditText) view.findViewById(R.id.txtEspecifique_p110);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //---pregunta106
//        EditText[] editTexts1 = {p106_edt1,p106_edt2,p106_edt3,p106_edt4};
//        for (int i = 0; i <editTexts1.length ; i++) {
//            final EditText editText = editTexts1[i];
//            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                @Override
//                public void onFocusChange(View view, boolean conFocus) {
//                    if(view.isEnabled()){
//                        if(conFocus) {
//                            editText.setBackgroundResource(R.drawable.fondo_edit_text);
//                        }
//                        else editText.setBackgroundResource(R.drawable.fondo_edit_text);
//                    }else{
//                        ocultarTeclado(editText);
//                    }
//                }
//            });
//            editText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
//            editText.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                    if(!charSequence.toString().equals("")){
//                        p106_txt.setText((Integer.parseInt(p106_txt.getText().toString()) - Integer.parseInt(charSequence.toString()))+"");
//                    }
//                }
//
//                @Override
//                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                }
//
//                @Override
//                public void afterTextChanged(Editable editable) {
//                    int despues = 0;
//                    if(!editable.toString().equals("")) despues = Integer.parseInt(editable.toString());
//                    if(!(Integer.parseInt(p106_txt.getText().toString())== 0)){
//                        p106_txt.setText((Integer.parseInt(p106_txt.getText().toString()) + despues) +"");
//                    }else{
//                        p106_txt.setText(despues+"");
//                    }
//                }
//            });
//
//        }



        //---pregunta108
        p108_rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.sec100_p108_rb1:   break;
                    case R.id.sec100_p108_rb2:   break;
                }
            }
        });

        //---pregunta109

        p109_ck6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    p109_edt.setVisibility(View.VISIBLE);
                }
                else p109_edt.setVisibility(View.GONE);
            }
        });
        //---pregunta110
        p110_ck7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    p110_edt.setVisibility(View.VISIBLE);
                }
                else p110_edt.setVisibility(View.GONE);
            }
        });
        cargarDatos();

    }
    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void cargarDatos(){
        data = new Data(context);
        data.open();
        //verifico si ya existe un objeto con datos llenados previamente
        if(data.existeModulo1(idempresa)){
            //si existe traigo el objeto
            sec100PojoF1 = data.getModulo1(idempresa);
            //saco los datos del objeto para llenarlos en los elementos del fragment
            //datos cabecera
            //106
            p106_edt1.setText(sec100PojoF1.getP_106_1());
            p106_edt2.setText(sec100PojoF1.getP_106_2());
            p106_edt3.setText(sec100PojoF1.getP_106_3());
            p106_edt4.setText(sec100PojoF1.getP_106_4());
            p106_txt.setText(sec100PojoF1.getP_106_5());
            //107
            if(sec100PojoF1.getP_107_1().equals("1")) p107_ck1.setChecked(true);
            if(sec100PojoF1.getP_107_1().equals("0")) p107_ck1.setChecked(false);
            if(sec100PojoF1.getP_107_2().equals("1")) p107_ck2.setChecked(true);
            if(sec100PojoF1.getP_107_2().equals("0")) p107_ck2.setChecked(false);
            if(sec100PojoF1.getP_107_3().equals("1")) p107_ck3.setChecked(true);
            if(sec100PojoF1.getP_107_3().equals("0")) p107_ck3.setChecked(false);
            //108
            if(!sec100PojoF1.getP_108().equals("") && !sec100PojoF1.getP_108().equals("-1")){
                ((RadioButton)p108_rg1.getChildAt(Integer.parseInt(sec100PojoF1.getP_108()))).setChecked(true);
            }
            //109
            if(sec100PojoF1.getP_109_1().equals("1")) p109_ck1.setChecked(true);
            if(sec100PojoF1.getP_109_1().equals("0")) p109_ck1.setChecked(false);
            if(sec100PojoF1.getP_109_2().equals("1")) p109_ck2.setChecked(true);
            if(sec100PojoF1.getP_109_2().equals("0")) p109_ck2.setChecked(false);
            if(sec100PojoF1.getP_109_3().equals("1")) p109_ck3.setChecked(true);
            if(sec100PojoF1.getP_109_3().equals("0")) p109_ck3.setChecked(false);
            if(sec100PojoF1.getP_109_4().equals("1")) p109_ck4.setChecked(true);
            if(sec100PojoF1.getP_109_4().equals("0")) p109_ck4.setChecked(false);
            if(sec100PojoF1.getP_109_5().equals("1")) p109_ck5.setChecked(true);
            if(sec100PojoF1.getP_109_5().equals("0")) p109_ck5.setChecked(false);
            if(sec100PojoF1.getP_109_6().equals("1")) p109_ck6.setChecked(true);
            if(sec100PojoF1.getP_109_6().equals("0")) p109_ck6.setChecked(false);
            p109_edt.setText(sec100PojoF1.getP_109_6_O());
            //110
            if(sec100PojoF1.getP_110_1().equals("1")) p110_ck1.setChecked(true);
            if(sec100PojoF1.getP_110_1().equals("0")) p110_ck1.setChecked(false);
            if(sec100PojoF1.getP_110_2().equals("1")) p110_ck2.setChecked(true);
            if(sec100PojoF1.getP_110_2().equals("0")) p110_ck2.setChecked(false);
            if(sec100PojoF1.getP_110_3().equals("1")) p110_ck3.setChecked(true);
            if(sec100PojoF1.getP_110_3().equals("0")) p110_ck3.setChecked(false);
            if(sec100PojoF1.getP_110_4().equals("1")) p110_ck4.setChecked(true);
            if(sec100PojoF1.getP_110_4().equals("0")) p110_ck4.setChecked(false);
            if(sec100PojoF1.getP_110_5().equals("1")) p110_ck5.setChecked(true);
            if(sec100PojoF1.getP_110_5().equals("0")) p110_ck5.setChecked(false);
            if(sec100PojoF1.getP_110_6().equals("1")) p110_ck6.setChecked(true);
            if(sec100PojoF1.getP_110_6().equals("0")) p110_ck6.setChecked(false);
            if(sec100PojoF1.getP_110_7().equals("1")) p110_ck7.setChecked(true);
            if(sec100PojoF1.getP_110_7().equals("0")) p110_ck7.setChecked(false);
            p110_edt.setText(sec100PojoF1.getP_110_7_O());
        }
        data.close();
    }
    public void llenarMapaVariables(){
        //106

            P_106_1 =  p106_edt1.getText().toString();


            P_106_2 =  p106_edt2.getText().toString();


            P_106_3 =  p106_edt3.getText().toString();


            P_106_4 =  p106_edt4.getText().toString();


            P_106_5 =  p106_txt.getText().toString();

        //107
        if(p107_ck1.isChecked())P_107_1 = 1;
        else P_107_1 = 0;
        if(p107_ck2.isChecked())P_107_2 = 1;
        else P_107_2 = 0;
        if(p107_ck3.isChecked())P_107_3 = 1;
        else P_107_3 = 0;
        //108
        int childPosP1 = p108_rg1.indexOfChild(p108_rg1.findViewById(p108_rg1.getCheckedRadioButtonId()));
        P_108 = childPosP1;
        //109
        if(p109_ck1.isChecked())P_109_1 = 1;
        else P_109_1 = 0;
        if(p109_ck2.isChecked())P_109_2 = 1;
        else P_109_2 = 0;
        if(p109_ck3.isChecked())P_109_3 = 1;
        else P_109_3 = 0;
        if(p109_ck4.isChecked())P_109_4 = 1;
        else P_109_4 = 0;
        if(p109_ck5.isChecked())P_109_5 = 1;
        else P_109_5 = 0;
        if(p109_ck6.isChecked())P_109_6 = 1;
        else P_109_6 = 0;

            P_109_6_O =  p109_edt.getText().toString();

        //110
        if(p110_ck1.isChecked())P_110_1 = 1;
        else P_110_1 = 0;
        if(p110_ck2.isChecked())P_110_2 = 1;
        else P_110_2 = 0;
        if(p110_ck3.isChecked())P_110_3 = 1;
        else P_110_3 = 0;
        if(p110_ck4.isChecked())P_110_4 = 1;
        else P_110_4 = 0;
        if(p110_ck5.isChecked())P_110_5 = 1;
        else P_110_5 = 0;
        if(p110_ck6.isChecked())P_110_6 = 1;
        else P_110_6 = 0;
        if(p110_ck7.isChecked())P_110_7 = 1;
        else P_110_7 = 0;

            P_110_7_O =  p110_edt.getText().toString();


    }

    public void guardarDatos(){
        llenarMapaVariables();
        data = new Data(context);
        data.open();
        if(data.existeModulo1(idempresa)){
            ContentValues contentValues = new ContentValues(58);
            contentValues.put(SQLConstantes.SECCION100_P_106_1,P_106_1);
            contentValues.put(SQLConstantes.SECCION100_P_106_2,P_106_2);
            contentValues.put(SQLConstantes.SECCION100_P_106_3,P_106_3);
            contentValues.put(SQLConstantes.SECCION100_P_106_4,P_106_4);
            contentValues.put(SQLConstantes.SECCION100_P_106_5,P_106_5);
            contentValues.put(SQLConstantes.SECCION100_P_107_1,P_107_1+"");
            contentValues.put(SQLConstantes.SECCION100_P_107_2,P_107_2+"");
            contentValues.put(SQLConstantes.SECCION100_P_107_3,P_107_3+"");
            contentValues.put(SQLConstantes.SECCION100_P_108,P_108+"");
            contentValues.put(SQLConstantes.SECCION100_P_109_1,P_109_1+"");
            contentValues.put(SQLConstantes.SECCION100_P_109_2,P_109_2+"");
            contentValues.put(SQLConstantes.SECCION100_P_109_3,P_109_3+"");
            contentValues.put(SQLConstantes.SECCION100_P_109_4,P_109_4+"");
            contentValues.put(SQLConstantes.SECCION100_P_109_5,P_109_5+"");
            contentValues.put(SQLConstantes.SECCION100_P_109_6,P_109_6+"");
            contentValues.put(SQLConstantes.SECCION100_P_109_6_O,P_109_6_O);
            contentValues.put(SQLConstantes.SECCION100_P_110_1,P_110_1+"");
            contentValues.put(SQLConstantes.SECCION100_P_110_2,P_110_2+"");
            contentValues.put(SQLConstantes.SECCION100_P_110_3,P_110_3+"");
            contentValues.put(SQLConstantes.SECCION100_P_110_4,P_110_4+"");
            contentValues.put(SQLConstantes.SECCION100_P_110_5,P_110_5+"");
            contentValues.put(SQLConstantes.SECCION100_P_110_6,P_110_6+"");
            contentValues.put(SQLConstantes.SECCION100_P_110_7,P_110_7+"");
            contentValues.put(SQLConstantes.SECCION100_P_110_7_O,P_110_7_O);
            data.actualizarModulo1(idempresa,contentValues);
        }else{
            //si no existe el elemento, lo construye para insertarlo
            sec100PojoF1 = new Sec100PojoF1();
            //llena el objeto a insertar
            sec100PojoF1.setID(idempresa);
            sec100PojoF1.setP_106_1(P_106_1);
            sec100PojoF1.setP_106_2(P_106_2);
            sec100PojoF1.setP_106_3(P_106_3);
            sec100PojoF1.setP_106_4(P_106_4);
            sec100PojoF1.setP_106_5(P_106_5);
            sec100PojoF1.setP_107_1(P_107_1+"");
            sec100PojoF1.setP_107_2(P_107_2+"");
            sec100PojoF1.setP_107_3(P_107_3+"");
            sec100PojoF1.setP_108(P_108+"");
            sec100PojoF1.setP_109_1(P_109_1+"");
            sec100PojoF1.setP_109_2(P_109_2+"");
            sec100PojoF1.setP_109_3(P_109_3+"");
            sec100PojoF1.setP_109_4(P_109_4+"");
            sec100PojoF1.setP_109_5(P_109_5+"");
            sec100PojoF1.setP_109_6(P_109_6+"");
            sec100PojoF1.setP_109_6_O(P_109_6_O);
            sec100PojoF1.setP_110_1(P_110_1+"");
            sec100PojoF1.setP_110_2(P_110_2+"");
            sec100PojoF1.setP_110_3(P_110_3+"");
            sec100PojoF1.setP_110_4(P_110_4+"");
            sec100PojoF1.setP_110_5(P_110_5+"");
            sec100PojoF1.setP_110_6(P_110_6+"");
            sec100PojoF1.setP_110_7(P_110_7+"");
            sec100PojoF1.setP_110_7_O(P_110_7_O);
            data.insertarModulo1(sec100PojoF1);
        }
        data.close();
    }

    public boolean validar(){
        boolean valido = true;
        String mensaje = "";
        llenarMapaVariables();

        boolean v1=true;boolean v2=true;boolean v3=true;boolean v4=true;boolean vt=true;

        //106


            if (P_106_1.trim().length() == 0) {
                v1 = false;
                if(mensaje.equals(""))mensaje = "DEBE INDICAR EL NUMERO DE TRABAJADORES SEGUN NIVEL DE EDUCACION";
            }


            if (P_106_2.trim().length() == 0) {
                v2 = false;
                if(mensaje.equals(""))mensaje = "DEBE INDICAR EL NUMERO DE TRABAJADORES SEGUN NIVEL DE EDUCACION";
            }


            if (P_106_3.trim().length() == 0) {
                v3 = false;
                if(mensaje.equals(""))mensaje = "DEBE INDICAR EL NUMERO DE TRABAJADORES SEGUN NIVEL DE EDUCACION";
            }

            if (P_106_4.trim().length() == 0) {
                v4 = false;
                if(mensaje.equals(""))mensaje = "DEBE INDICAR EL NUMERO DE TRABAJADORES SEGUN NIVEL DE EDUCACION";
            }



        data = new Data(context);
        data.open();
        int ptrabajadores = Integer.parseInt(data.getModulo1(idempresa).getP_105());
        data.close();
        int verificacion =  ptrabajadores;
        if(P_106_1.equals("")) P_106_1 = "0";
        if(P_106_2.equals("")) P_106_2 = "0";
        if(P_106_3.equals("")) P_106_3 = "0";
        if(P_106_4.equals("")) P_106_4 = "0";

        if(!P_106_5.equals("") && verificacion!=0){
            if(Integer.parseInt(P_106_5) != verificacion){
                vt = false;
                if(mensaje.equals(""))mensaje = "PREGUNTA 5: LA SUMATORIA POR TIPO DE PERIODO DE CONTRATO DEBE SER IGUAL AL NUMERO DE TRABAJDORES";
            }
        }
        valido = v1 &&v2&&v3&&v4&& vt;
        //107
        if(P_107_1 != 1 && P_107_2 != 1 && P_107_3 != 1 ) {
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 107: DEBE SELECCIONAR AL MENOS UNA OPCION";
        }
        //109
        if(P_109_1 != 1 && P_109_2 != 1 && P_109_3 != 1 && P_109_4 != 1 && P_109_5 != 1 && P_109_6 != 1 ) {
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 109: DEBE SELECCIONAR AL MENOS UNA OPCION";
        }
        if(P_109_6 == 1) {
            if(P_109_6_O.trim().length() < 2){
                valido = false;
                if(mensaje.equals(""))mensaje = "DEBE REGISTRAR INFORMACION";
            }
        }
        //110
        if(P_110_1 != 1 && P_110_2 != 1 && P_110_3 != 1 && P_110_4 != 1 && P_110_5 != 1 && P_110_6 != 1 && P_110_7 != 1) {
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 110: DEBE SELECCIONAR AL MENOS UNA OPCION";
        }
        if(P_110_7 == 1) {
            if(P_110_7_O.trim().length() < 2){
                valido = false;
                if(mensaje.equals(""))mensaje = "DEBE REGISTRAR INFORMACION";
            }
        }
        //valido = v1&&v2&&v3&&v4&&vt;
        if(!valido){
            mostrarMensaje(mensaje);
//            Log.d("vNUM_RUC" , vNUM_RUC+"");
//            Log.d("vRAZON_SOCIAL",vRAZON_SOCIAL+"");
//            Log.d("vANIO_FUNDACION",vANIO_FUNDACION+"");
//            Log.d("vPAG_WEB",vPAG_WEB+"");
//            Log.d("vCORREO",vCORREO+"");
//            Log.d("vTEL_MOVIL",vTEL_MOVIL+"");
//            Log.d("vANIO_OPERACION",vANIO_OPERACION+"");
//            Log.d("vNOM_INFORMANTE",vNOM_INFORMANTE+"");
//            Log.d("vSEXO_INFORMANTE",vSEXO_INFORMANTE+"");
//            Log.d("vEDAD_INFORMANTE",vEDAD_INFORMANTE+"");
//            Log.d("vACAD_INFORMANTE",vACAD_INFORMANTE+"");
//            Log.d("vCARGO_INFORMANTE",vCARGO_INFORMANTE+"");
//            Log.d("vCARGO_INFORMANTE_ESP",vCARGO_INFORMANTE_ESP+"");
//            Log.d("vTEL_FIJO",vTEL_FIJO+"");
        }

        return valido;
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

}
