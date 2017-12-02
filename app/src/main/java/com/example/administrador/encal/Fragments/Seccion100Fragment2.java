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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Modelo.SQLConstantes;
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
        //data = new Data(context);
        //data.open();
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
        if(!p106_edt1.getText().toString().equals("")){
            P_106_1 =  p106_edt1.getText().toString();
        }
        if(!p106_edt2.getText().toString().equals("")){
            P_106_2 =  p106_edt2.getText().toString();
        }
        if(!p106_edt3.getText().toString().equals("")){
            P_106_3 =  p106_edt3.getText().toString();
        }
        if(!p106_edt4.getText().toString().equals("")){
            P_106_4 =  p106_edt4.getText().toString();
        }
        if(!p106_txt.getText().toString().equals("")){
            P_106_5 =  p106_txt.getText().toString();
        }
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
        if(!p109_edt.getText().toString().equals("")){
            P_109_6_O =  p109_edt.getText().toString();
        }
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
        if(!p110_edt.getText().toString().equals("")){
            P_110_7_O =  p110_edt.getText().toString();
        }

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
        //revisarcampos
        boolean valido = true;
        //llenarMapaVariables();


        return valido;

    }
}
