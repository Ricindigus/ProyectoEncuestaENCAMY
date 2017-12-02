package com.example.administrador.encal.Fragments;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Modelo.SQLConstantes;
import com.example.administrador.encal.Pojos.Sec200PojoF1;
import com.example.administrador.encal.Pojos.Sec400PojoF1;
import com.example.administrador.encal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Seccion400Fragment2 extends Fragment {
    private CheckBox p409_ck1;
    private CheckBox p409_ck2;
    private CheckBox p409_ck3;
    private CheckBox p409_ck4;
    private CheckBox p409_ck5;
    private EditText p409_edt;
    private CardView p409_card;

    private RadioGroup p410_rg;
    private EditText p410_edt;
    private CardView p410_card;

    private String idempresa;
    private Sec400PojoF1 sec400PojoF1;
    private Context context;
    private Data data;

    //mapeo de variables
    int P_409_1;int P_409_2;int P_409_3;int P_409_4;int P_409_5;String P_409_5_O;
    int P_410;String P_410_O;


    public Seccion400Fragment2() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Seccion400Fragment2(String idempresa, Context context) {
        this.idempresa = idempresa;
        this.context = context;
        //data = new Data(context);
        //data.open();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment2_s400, container, false);
        p409_ck1  = (CheckBox) view.findViewById(R.id.sec400_p409_ck1);
        p409_ck2  = (CheckBox) view.findViewById(R.id.sec400_p409_ck2);
        p409_ck3  = (CheckBox) view.findViewById(R.id.sec400_p409_ck3);
        p409_ck4  = (CheckBox) view.findViewById(R.id.sec400_p409_ck4);
        p409_ck5  = (CheckBox) view.findViewById(R.id.sec400_p409_ck5);
        p409_edt = (EditText) view.findViewById(R.id.txtEspecifique_p409);
        p409_card = (CardView) view.findViewById(R.id.p409_card);


        p410_rg = (RadioGroup) view.findViewById(R.id.sec400_p410_rg);
        p410_edt = (EditText) view.findViewById(R.id.edtEspecifique_p410);
        p410_card = (CardView) view.findViewById(R.id.p410_card);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //-----ñpregunta409
        p409_ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    p410_card.setVisibility(View.GONE);
                    p409_ck2.setEnabled(false);
                    p409_ck3.setEnabled(false);
                    p409_ck4.setEnabled(false);
                    p409_ck5.setEnabled(false);
                }else{
                    p410_card.setVisibility(View.VISIBLE);
                    p409_ck2.setEnabled(true);
                    p409_ck3.setEnabled(true);
                    p409_ck4.setEnabled(true);
                    p409_ck5.setEnabled(true);

                }
            }
        });

        p409_ck5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    p409_edt.setVisibility(View.VISIBLE);
                }else{
                    p409_edt.setVisibility(View.GONE);
                }
            }
        });

        //-----pregunta410
        p410_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.sec400_p410_rb1: p410_edt.setVisibility(View.GONE);break;
                    case R.id.sec400_p410_rb2: p410_edt.setVisibility(View.GONE);break;
                    case R.id.sec400_p410_rb3: p410_edt.setVisibility(View.GONE);break;
                    case R.id.sec400_p410_rb4: p410_edt.setVisibility(View.VISIBLE);break;


                }
            }
        });
        cargarDatos();
    }

    public void cargarDatos(){
        data = new Data(context);
        data.open();
        //verifico si ya existe un objeto con datos llenados previamente
        if(data.existeModulo4(idempresa)){
            //si existe traigo el objeto
            sec400PojoF1 = data.getModulo4(idempresa);
            //saco los datos del objeto para llenarlos en los elementos del fragment
            //409
            if(sec400PojoF1.getP_409_1().equals("1")) p409_ck1.setChecked(true);
            if(sec400PojoF1.getP_409_1().equals("0")) p409_ck1.setChecked(false);
            if(sec400PojoF1.getP_409_2().equals("1")) p409_ck2.setChecked(true);
            if(sec400PojoF1.getP_409_2().equals("0")) p409_ck2.setChecked(false);
            if(sec400PojoF1.getP_409_3().equals("1")) p409_ck3.setChecked(true);
            if(sec400PojoF1.getP_409_3().equals("0")) p409_ck3.setChecked(false);
            if(sec400PojoF1.getP_409_4().equals("1")) p409_ck4.setChecked(true);
            if(sec400PojoF1.getP_409_4().equals("0")) p409_ck4.setChecked(false);
            if(sec400PojoF1.getP_409_5().equals("1")) p409_ck5.setChecked(true);
            if(sec400PojoF1.getP_409_5().equals("0")) p409_ck5.setChecked(false);
            p409_edt.setText(sec400PojoF1.getP_409_5_O());
            //410
            if(!sec400PojoF1.getP_410().equals("") && !sec400PojoF1.getP_410().equals("-1")){
                ((RadioButton)p410_rg.getChildAt(Integer.parseInt(sec400PojoF1.getP_410()))).setChecked(true);
            }
            p410_edt.setText(sec400PojoF1.getP_410_O());

        }
        data.close();
    }
    public void llenarMapaVariables(){
        //409
        if(p409_ck1.isChecked())P_409_1 = 1;
        else P_409_1 = 0;
        if(p409_ck2.isChecked())P_409_2 = 1;
        else P_409_2 = 0;
        if(p409_ck3.isChecked())P_409_3 = 1;
        else P_409_3 = 0;
        if(p409_ck4.isChecked())P_409_4 = 1;
        else P_409_4 = 0;
        if(p409_ck4.isChecked())P_409_5 = 1;
        else P_409_5 = 0;
        if(!p409_edt.getText().toString().equals("")){
            P_409_5_O=  p409_edt.getText().toString();
        }
        //402
        int childPosP1 = p410_rg.indexOfChild(p410_rg.findViewById(p410_rg.getCheckedRadioButtonId()));
        P_410 = childPosP1;
        if(!p410_edt.getText().toString().equals("")){
            P_410_O =  p410_edt.getText().toString();
        }
    }

    public void guardarDatos(){
        llenarMapaVariables();
        data = new Data(context);
        data.open();
        if(data.existeModulo4(idempresa)){
            ContentValues contentValues = new ContentValues(38);
            contentValues.put(SQLConstantes.SECCION400_P_409_1,P_409_1+"");
            contentValues.put(SQLConstantes.SECCION400_P_409_2,P_409_2+"");
            contentValues.put(SQLConstantes.SECCION400_P_409_3,P_409_3+"");
            contentValues.put(SQLConstantes.SECCION400_P_409_4,P_409_4+"");
            contentValues.put(SQLConstantes.SECCION400_P_409_5,P_409_5+"");
            contentValues.put(SQLConstantes.SECCION400_P_409_5_O,P_409_5_O);
            contentValues.put(SQLConstantes.SECCION400_P_410,P_410+"");
            contentValues.put(SQLConstantes.SECCION400_P_410_O,P_410_O);
            data.actualizarModulo4(idempresa,contentValues);
        }else{
            //si no existe el elemento, lo construye para insertarlo
            sec400PojoF1 = new Sec400PojoF1();
            //llena el objeto a insertar
            sec400PojoF1.setID(idempresa);
            sec400PojoF1.setP_409_1(P_409_1+"");
            sec400PojoF1.setP_409_2(P_409_2+"");
            sec400PojoF1.setP_409_3(P_409_3+"");
            sec400PojoF1.setP_409_4(P_409_4+"");
            sec400PojoF1.setP_409_5(P_409_5+"");
            sec400PojoF1.setP_409_5_O(P_409_5_O);
            sec400PojoF1.setP_410(P_410+"");
            sec400PojoF1.setP_410_O(P_410_O);
            data.insertarModulo4(sec400PojoF1);
        }
        data.close();
    }

    public boolean validar() {
        //revisarcampos
        boolean valido = true;
        //llenarMapaVariables();


        return valido;

    }
}
