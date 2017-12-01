package com.example.administrador.encal.Fragments;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Modelo.SQLConstantes;
import com.example.administrador.encal.Pojos.Sec100PojoF1;
import com.example.administrador.encal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Seccion100Fragment1 extends Fragment {
    private TextView p101_txt1;
    private AutoCompleteTextView p101_act1;
    private EditText p101_edt1;

    private CheckBox p102_ck1;
    private CheckBox p102_ck2;
    private CheckBox p102_ck3;
    private CheckBox p102_ck4;
    private TextView p102_txt1;
    private TextView p102_txt2;
    private TextView p102_txt3;
    private TextView p102_txt4;
    private AutoCompleteTextView p102_act1;
    private AutoCompleteTextView p102_act2;
    private AutoCompleteTextView p102_act3;
    private AutoCompleteTextView p102_act4;

    private RadioGroup p103_rg1;
    private RadioButton p103_rb1;
    private RadioButton p103_rb2;
    private RadioButton p103_rb3;
    private RadioButton p103_rb4;
    private RadioButton p103_rb5;
    private RadioButton p103_rb6;
    private EditText p103_edt1;

    private RadioGroup p104_rg1;
    private RadioButton p104_rb1;
    private RadioButton p104_rb2;

    private  EditText p105_edt1;

    private String idempresa;
    private Sec100PojoF1 sec100;
    private Context context;
    private Data data;

    String P101_1;String P101_2;String P101_3;
    int P102_1_1;String P102_1_2;String P102_1_3;
    int P102_2_1;String P102_2_2;String P102_2_3;
    int P102_3_1;String P102_3_2;String P102_3_3;
    int P102_4_1;String P102_4_2;String P102_4_3;
    int P103;String P103_0;
    int P104;String P105;


    public Seccion100Fragment1() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Seccion100Fragment1(String idempresa, Context context) {
        this.idempresa = idempresa;
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment1_s100, container, false);
        p101_txt1 = (TextView) view.findViewById(R.id.sec100_p101_txt1);
        p101_act1 = (AutoCompleteTextView) view.findViewById(R.id.sec100_p101_atc1);
        p101_edt1 = (EditText) view.findViewById(R.id.sec100_p101_edt1);

//        p102_ck1 = (CheckBox) view.findViewById(R.id.sec100_p102_ck1);
//        p102_ck2 = (CheckBox) view.findViewById(R.id.sec100_p102_ck2);
//        p102_ck3 = (CheckBox) view.findViewById(R.id.sec100_p102_ck3);
//        p102_ck4 = (CheckBox) view.findViewById(R.id.sec100_p102_ck4);
        p102_txt1 = (TextView) view.findViewById(R.id.sec100_p102_txt1);
        p102_txt2 = (TextView) view.findViewById(R.id.sec100_p102_txt2);
        p102_txt3 = (TextView) view.findViewById(R.id.sec100_p102_txt3);
        p102_txt4 = (TextView) view.findViewById(R.id.sec100_p102_txt4);
        p102_act1 = (AutoCompleteTextView) view.findViewById(R.id.sec100_p102_act1);
        p102_act2 = (AutoCompleteTextView) view.findViewById(R.id.sec100_p102_act2);
        p102_act3 = (AutoCompleteTextView) view.findViewById(R.id.sec100_p102_act3);
        p102_act4 = (AutoCompleteTextView) view.findViewById(R.id.sec100_p102_act4);

        p103_rg1 = (RadioGroup) view.findViewById(R.id.sec100_p103_rg);
        p103_edt1 = (EditText) view.findViewById(R.id.edtEspecifique_p103);

        p104_rg1 = (RadioGroup) view.findViewById(R.id.sec100_p104_rg);

        p105_edt1 = (EditText) view.findViewById(R.id.sec100_p105_edt1);



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //-----Pregunta2

//        p102_ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b){
//                    p102_act1.setEnabled(true);
//                }
//                else p102_act1.setEnabled(false);
//            }
//        });
//
//        p102_ck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b){
//                    p102_act2.setEnabled(true);
//                }
//                else p102_act2.setEnabled(false);
//            }
//        });
//        p102_ck3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b){
//                    p102_act3.setEnabled(true);
//                }
//                else p102_act3.setEnabled(false);
//            }
//        });
//
//        p102_ck4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b){
//                    p102_act4.setEnabled(true);
//                }
//                else p102_act4.setEnabled(false);
//            }
//        });


        //----pregunta3
        p103_rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.sec100_p103_rb1:   p103_edt1.setVisibility(View.GONE);p103_edt1.setText("");break;
                    case R.id.sec100_p103_rb2:   p103_edt1.setVisibility(View.GONE);p103_edt1.setText("");break;
                    case R.id.sec100_p103_rb3:   p103_edt1.setVisibility(View.GONE);p103_edt1.setText("");break;
                    case R.id.sec100_p103_rb4:   p103_edt1.setVisibility(View.GONE);p103_edt1.setText("");break;
                    case R.id.sec100_p103_rb5:   p103_edt1.setVisibility(View.GONE);p103_edt1.setText("");break;
                    case R.id.sec100_p103_rb6:   p103_edt1.setVisibility(View.VISIBLE);
                        p103_edt1.setBackgroundResource(R.drawable.fondo_edit_text);
                        p103_edt1.requestFocus();
                        break;
                }
            }
        });


        //---pregunta4
        p104_rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.sec100_p104_rb1:   break;
                    case R.id.sec100_p104_rb2:   break;
                }
            }
        });

        cargarDatos();


    }

    ///////////////GUARDADO///////////////////////

    public void cargarDatos(){
//        data = new Data(context);
//        data.open();
//        //verifico si ya existe un objeto con datos llenados previamente
//        if(data.existeModulo1(idempresa)){
//            //si existe traigo el objeto
//            sec100 = data.getModulo1(idempresa);
//            //saco los datos del objeto para llenarlos en los elementos del fragment
//            //PREGUNTA 101
//            p101_txt1.setText(sec100.getP_101());
//            p101_edt1.setText(sec100.getP_101_1());
//            p101_act1.setText(sec100.getP_101_1_O());
//
//            p102_txt1.setText(sec100.getP_102_1());
//            p102_txt2.setText(sec100.getP_102_2());
//            p102_txt3.setText(sec100.getP_102_3());
//            p102_txt4.setText(sec100.getP_102_4());
//
//            p102_act1.setText(sec100.getP_102A());
//            p102_act2.setText(sec100.getP_102B());
//            p102_act3.setText(sec100.getP_102C());
//            p102_act4.setText(sec100.getP_102D());
//
//            //PREGUNTA 103
//            if(!sec100.getP_103().equals("") && !sec100.getP_103().equals("-1")){
//                ((RadioButton)p103_rg1.getChildAt(Integer.parseInt(sec100.getP_103()))).setChecked(true);
//            }
//            p103_edt1.setText(sec100.getP_103_O());
//            //PREGUNTA 104
//            if(!sec100.getP_104().equals("") && !sec100.getP_104().equals("-1")){
//                ((RadioButton)p104_rg1.getChildAt(Integer.parseInt(sec100.getP_104()))).setChecked(true);
//            }
//            //PREGUNTA 105
//            p105_edt1.setText(sec100.getP_105());
//
//        }
//        data.close();
    }
    public void llenarMapaVariables(){

//        //PREGUNTA 101
//        P101_1 = p101_txt1.getText().toString();
//        P101_2 = p101_edt1.getText().toString();
//        P101_3 = p101_act1.getText().toString();
//        //P101_3 = "";
//
//
//        //PREGUNTA 102-1
//        //if(p102_ck1.isChecked())P102_1_1 = 1;
//        // else P102_1_1 = 0;
//        P102_1_2 = p102_txt1.getText().toString();
////        P102_1_3 = p102_act1.getText().toString();
//        P102_1_3 = "";
//
//        //PREGUNTA 102_2
//        // if(p102_ck2.isChecked())P102_2_1 = 1;
//        // else P102_2_1 = 0;
//        P102_2_2 = p102_txt1.getText().toString();
//        P102_2_3 = p102_act1.getText().toString();
//        P102_2_3 = "";
//
//        //PREGUNTA 102_3
//        //if(p102_ck3.isChecked())P102_3_1 = 1;
//        //else P102_3_1 = 0;
//        P102_3_2 = p102_txt1.getText().toString();
////        P102_3_3 = p102_act1.getText().toString();
//        P102_3_3 = "";
//
//        //PREGUNTA 102_4
//        //if(p102_ck4.isChecked())P102_4_1 = 1;
//        //else P102_4_1 = 0;
//        P102_4_2 = p102_txt1.getText().toString();
////        P102_4_3 = p102_act1.getText().toString();
//        P102_4_3 = "";
//
//
//
//        //PREGUNTA 103
//        int childPosP103 = p103_rg1.indexOfChild(p103_rg1.findViewById(p103_rg1.getCheckedRadioButtonId()));
//        P103 = childPosP103;
//        P103_0 = p103_edt1.getText().toString();
//        //PREGUNTA 104
//        int childPosP104 = p104_rg1.indexOfChild(p104_rg1.findViewById(p104_rg1.getCheckedRadioButtonId()));
//        P104 = childPosP104;
//        //PREGUNTA 105
//        P105 = p105_edt1.getText().toString();
    }
    public void guardarDatos(){
//        llenarMapaVariables();
//        data = new Data(context);
//        data.open();
//        if(data.existeModulo1(idempresa)){
//            ContentValues contentValues = new ContentValues(58);
//            contentValues.put(SQLConstantes.SECCION100_P_101,P101_1);
//            contentValues.put(SQLConstantes.SECCION100_P_101_1,P101_2);
//            contentValues.put(SQLConstantes.SECCION100_P_101_1_O,P101_3);
//            contentValues.put(SQLConstantes.SECCION100_P_102_1,P102_1_2);
//            contentValues.put(SQLConstantes.SECCION100_P_102_2,P102_2_2);
//            contentValues.put(SQLConstantes.SECCION100_P_102_3,P102_3_2);
//            contentValues.put(SQLConstantes.SECCION100_P_102_4,P102_4_2);
//            contentValues.put(SQLConstantes.SECCION100_P_102A,P102_1_3);
//            contentValues.put(SQLConstantes.SECCION100_P_102B,P102_2_3);
//            contentValues.put(SQLConstantes.SECCION100_P_102C,P102_3_3);
//            contentValues.put(SQLConstantes.SECCION100_P_102D,P102_4_3);
//            contentValues.put(SQLConstantes.SECCION100_P_103,P103+"");
//            contentValues.put(SQLConstantes.SECCION100_P_103_O,P103_0);
//            contentValues.put(SQLConstantes.SECCION100_P_104,P104+"");
//            contentValues.put(SQLConstantes.SECCION100_P_105,P105);
//            data.actualizarModulo1(idempresa,contentValues);
//        }else{
//            //si no existe el elemento, lo construye para insertarlo
//            sec100 = new Sec100PojoF1();
//            //llena el objeto a insertar
//            sec100.setID(idempresa);
//            sec100.setP_101(P101_1);
//            sec100.setP_101_1(P101_2);
//            sec100.setP_101_1_O(P101_3);
//            sec100.setP_102_1(P102_1_2);
//            sec100.setP_102_2(P102_2_2);
//            sec100.setP_102_3(P102_3_2);
//            sec100.setP_102_4(P102_4_2);
//            sec100.setP_102A(P102_1_3);
//            sec100.setP_102B(P102_2_3);
//            sec100.setP_102C(P102_3_3);
//            sec100.setP_102D(P102_4_3);
//            sec100.setP_103(P103+"");
//            sec100.setP_103_O(P103_0);
//            sec100.setP_104(P104+"");
//            sec100.setP_105(P105);
//            data.insertarModulo1(sec100);
//        }
//        data.close();
    }
    public boolean validar(){
        //revisarcampos
        boolean valido = true;
        llenarMapaVariables();


        return valido;

    }





}