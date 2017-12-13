package com.example.administrador.encal.Fragments;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Modelo.SQLConstantes;
import com.example.administrador.encal.NumericKeyBoardTransformationMethod;
import com.example.administrador.encal.Pojos.IdentificacionPojo;
import com.example.administrador.encal.Pojos.Sec300PojoF1;
import com.example.administrador.encal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Seccion300Fragment1 extends Fragment {

    private RadioGroup p301_rg;

    private RadioGroup p302_rg;
    private LinearLayout p302_lyt;
    private EditText p302_masaotro;
    private EditText p302_longotro;
    private EditText p302_presotro;
    private EditText p302_temotro;
    private EditText p302_volotro;
    private EditText p302_ototro;

    private CheckBox p302_ckM1;
    private CheckBox p302_ckM2;
    private CheckBox p302_ckM3;
    private CheckBox p302_ckM4;
    private CheckBox p302_ckM5;
    private CheckBox p302_ckM6;
    private CheckBox p302_ckM7;
    private CheckBox p302_ckM8;
    private CheckBox p302_ckL1;
    private CheckBox p302_ckL2;
    private CheckBox p302_ckL3;
    private CheckBox p302_ckL4;
    private CheckBox p302_ckL5;
    private CheckBox p302_ckL6;
    private CheckBox p302_ckL7;
    private CheckBox p302_ckL8;
    private CheckBox p302_ckP1;
    private CheckBox p302_ckP2;
    private CheckBox p302_ckP3;
    private CheckBox p302_ckP4;
    private CheckBox p302_ckP5;
    private CheckBox p302_ckP6;
    private CheckBox p302_ckP7;
    private CheckBox p302_ckP8;
    private CheckBox p302_ckP9;
    private CheckBox p302_ckP10;
    private CheckBox p302_ckT1;
    private CheckBox p302_ckT2;
    private CheckBox p302_ckT3;
    private CheckBox p302_ckT4;
    private CheckBox p302_ckT5;
    private CheckBox p302_ckT6;
    private CheckBox p302_ckT7;
    private CheckBox p302_ckT8;
    private CheckBox p302_ckV1;
    private CheckBox p302_ckV2;
    private CheckBox p302_ckV3;
    private CheckBox p302_ckV4;
    private CheckBox p302_ckV5;
    private CheckBox p302_ckV6;
    private CheckBox p302_ckO1;
    private CheckBox p302_ckO2;


    private EditText p302_mCant1;
    private EditText p302_mCant2;
    private EditText p302_mCant3;
    private EditText p302_mCant4;
    private EditText p302_lCant1;
    private EditText p302_lCant2;
    private EditText p302_lCant3;
    private EditText p302_lCant4;
    private EditText p302_pCant1;
    private EditText p302_pCant2;
    private EditText p302_pCant3;
    private EditText p302_pCant4;
    private EditText p302_pCant5;
    private EditText p302_tCant1;
    private EditText p302_tCant2;
    private EditText p302_tCant3;
    private EditText p302_tCant4;
    private EditText p302_vCant1;
    private EditText p302_vCant2;
    private EditText p302_vCant3;
    private EditText p302_oCant1;

    private CheckBox p303_ck1;
    private CheckBox p303_ck2;
    private CheckBox p303_ck3;
    private CheckBox p303_ck4;
    private CheckBox p303_ck5;
    private CardView p303_card;

    private RadioGroup p304_rg;
    private RadioButton p304_rb1;
    private RadioButton p304_rb2;
    private RadioButton p304_rb3;
    private CardView p304_card;

    private TextInputEditText p305_edt;
    private CardView p305_card;
    private Sec300PojoF1 sec300;

    private EditText edtobs3;

    private IdentificacionPojo identificacion;

    private String idEmpresa;
    private Context context;
    private Data data;

    int P_301;
    int P_302;
    int P_302A_M_1;
    int P_302A_M_2;
    int P_302A_M_3;
    int P_302A_M_4;
    String P_302A_M_4_O;
    int P_302A_L_1;
    int P_302A_L_2;
    int P_302A_L_3;
    int P_302A_L_4;
    String P_302A_L_4_O;
    int P_302A_P_1;
    int P_302A_P_2;
    int P_302A_P_3;
    int P_302A_P_4;
    int P_302A_P_5;
    String P_302A_P_5_O;
    int P_302A_T_1;
    int P_302A_T_2;
    int P_302A_T_3;
    int P_302A_T_4;
    String P_302A_T_4_O;
    int P_302A_V_1;
    int P_302A_V_2;
    int P_302A_V_3;
    String P_302A_V_3_O;
    int P_302A_O_1;
    String P_302A_O_1_O;

    int P_302B_M_1;
    int P_302B_M_2;
    int P_302B_M_3;
    int P_302B_M_4;
    int P_302B_L_1;
    int P_302B_L_2;
    int P_302B_L_3;
    int P_302B_L_4;
    int P_302B_P_1;
    int P_302B_P_2;
    int P_302B_P_3;
    int P_302B_P_4;
    int P_302B_P_5;
    int P_302B_T_1;
    int P_302B_T_2;
    int P_302B_T_3;
    int P_302B_T_4;
    int P_302B_V_1;
    int P_302B_V_2;
    int P_302B_V_3;
    int P_302B_O_1;

    String P_302C_M_1;
    String P_302C_M_2;
    String P_302C_M_3;
    String P_302C_M_4;
    String P_302C_L_1;
    String P_302C_L_2;
    String P_302C_L_3;
    String P_302C_L_4;
    String P_302C_P_1;
    String P_302C_P_2;
    String P_302C_P_3;
    String P_302C_P_4;
    String P_302C_P_5;
    String P_302C_T_1;
    String P_302C_T_2;
    String P_302C_T_3;
    String P_302C_T_4;
    String P_302C_V_1;
    String P_302C_V_2;
    String P_302C_V_3;
    String P_302C_O_1;

    int P_303_1;
    int P_303_2;
    int P_303_3;
    int P_303_4;
    int P_303_5;

    int P_304;

    String P_305;
    String OBS_SEC300;


    public Seccion300Fragment1() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Seccion300Fragment1(String idEmpresa, Context context) {
        this.idEmpresa = idEmpresa;
        this.context = context;
        data = new Data(context);
        data.open();
        identificacion = data.getIdentificacion(idEmpresa);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment1_s300, container, false);
        p301_rg = (RadioGroup) view.findViewById(R.id.sec300_p301_rg);

        p302_rg = (RadioGroup) view.findViewById(R.id.sec300_p302_rg);

        p302_masaotro = (EditText) view.findViewById(R.id.sec300_p302_edtotro1);
        p302_longotro = (EditText) view.findViewById(R.id.sec300_p302_edtotro2);
        p302_presotro = (EditText) view.findViewById(R.id.sec300_p302_edtotro3);
        p302_temotro = (EditText) view.findViewById(R.id.sec300_p302_edtotro4);
        p302_volotro = (EditText) view.findViewById(R.id.sec300_p302_edtotro5);
        p302_ototro = (EditText) view.findViewById(R.id.sec300_p302_edtotro6);

        p302_mCant1 = (EditText) view.findViewById(R.id.sec300_p302_edtC1);
        p302_mCant2 = (EditText) view.findViewById(R.id.sec300_p302_edtC2);
        p302_mCant3 = (EditText) view.findViewById(R.id.sec300_p302_edtC3);
        p302_mCant4 = (EditText) view.findViewById(R.id.sec300_p302_edtC4);
        p302_lCant1 = (EditText) view.findViewById(R.id.sec300_p302_edtC5);
        p302_lCant2 = (EditText) view.findViewById(R.id.sec300_p302_edtC6);
        p302_lCant3 = (EditText) view.findViewById(R.id.sec300_p302_edtC7);
        p302_lCant4 = (EditText) view.findViewById(R.id.sec300_p302_edtC8);
        p302_pCant1 = (EditText) view.findViewById(R.id.sec300_p302_edtC9);
        p302_pCant2 = (EditText) view.findViewById(R.id.sec300_p302_edtC10);
        p302_pCant3 = (EditText) view.findViewById(R.id.sec300_p302_edtC11);
        p302_pCant4 = (EditText) view.findViewById(R.id.sec300_p302_edtC12);
        p302_pCant5 = (EditText) view.findViewById(R.id.sec300_p302_edtC13);
        p302_tCant1 = (EditText) view.findViewById(R.id.sec300_p302_edtC14);
        p302_tCant2 = (EditText) view.findViewById(R.id.sec300_p302_edtC15);
        p302_tCant3 = (EditText) view.findViewById(R.id.sec300_p302_edtC16);
        p302_tCant4 = (EditText) view.findViewById(R.id.sec300_p302_edtC17);
        p302_vCant1 = (EditText) view.findViewById(R.id.sec300_p302_edtC18);
        p302_vCant2 = (EditText) view.findViewById(R.id.sec300_p302_edtC19);
        p302_vCant3 = (EditText) view.findViewById(R.id.sec300_p302_edtC20);
        p302_oCant1 = (EditText) view.findViewById(R.id.sec300_p302_edtC21);
        p302_lyt = (LinearLayout) view.findViewById(R.id.sec100_p302_lyt);


        // CHECK
        p302_ckM1 = (CheckBox) view.findViewById(R.id.sec300_p302_ckM1);
        p302_ckM2 = (CheckBox) view.findViewById(R.id.sec300_p302_ckM2);
        p302_ckM3 = (CheckBox) view.findViewById(R.id.sec300_p302_ckM3);
        p302_ckM4 = (CheckBox) view.findViewById(R.id.sec300_p302_ckM4);
        p302_ckM5 = (CheckBox) view.findViewById(R.id.sec300_p302_ckM5);
        p302_ckM6 = (CheckBox) view.findViewById(R.id.sec300_p302_ckM6);
        p302_ckM7 = (CheckBox) view.findViewById(R.id.sec300_p302_ckM7);
        p302_ckM8 = (CheckBox) view.findViewById(R.id.sec300_p302_ckM8);

        p302_ckL1 = (CheckBox) view.findViewById(R.id.sec300_p302_ckL1);
        p302_ckL2 = (CheckBox) view.findViewById(R.id.sec300_p302_ckL2);
        p302_ckL3 = (CheckBox) view.findViewById(R.id.sec300_p302_ckL3);
        p302_ckL4 = (CheckBox) view.findViewById(R.id.sec300_p302_ckL4);
        p302_ckL5 = (CheckBox) view.findViewById(R.id.sec300_p302_ckL5);
        p302_ckL6 = (CheckBox) view.findViewById(R.id.sec300_p302_ckL6);
        p302_ckL7 = (CheckBox) view.findViewById(R.id.sec300_p302_ckL7);
        p302_ckL8 = (CheckBox) view.findViewById(R.id.sec300_p302_ckL8);

        p302_ckP1 = (CheckBox) view.findViewById(R.id.sec300_p302_ckP1);
        p302_ckP2 = (CheckBox) view.findViewById(R.id.sec300_p302_ckP2);
        p302_ckP3 = (CheckBox) view.findViewById(R.id.sec300_p302_ckP3);
        p302_ckP4 = (CheckBox) view.findViewById(R.id.sec300_p302_ckP4);
        p302_ckP5 = (CheckBox) view.findViewById(R.id.sec300_p302_ckP5);
        p302_ckP6 = (CheckBox) view.findViewById(R.id.sec300_p302_ckP6);
        p302_ckP7 = (CheckBox) view.findViewById(R.id.sec300_p302_ckP7);
        p302_ckP8 = (CheckBox) view.findViewById(R.id.sec300_p302_ckP8);
        p302_ckP9 = (CheckBox) view.findViewById(R.id.sec300_p302_ckP9);
        p302_ckP10 = (CheckBox) view.findViewById(R.id.sec300_p302_ckP10);

        p302_ckT1 = (CheckBox) view.findViewById(R.id.sec300_p302_ckT1);
        p302_ckT2 = (CheckBox) view.findViewById(R.id.sec300_p302_ckT2);
        p302_ckT3 = (CheckBox) view.findViewById(R.id.sec300_p302_ckT3);
        p302_ckT4 = (CheckBox) view.findViewById(R.id.sec300_p302_ckT4);
        p302_ckT5 = (CheckBox) view.findViewById(R.id.sec300_p302_ckT5);
        p302_ckT6 = (CheckBox) view.findViewById(R.id.sec300_p302_ckT6);
        p302_ckT7 = (CheckBox) view.findViewById(R.id.sec300_p302_ckT7);
        p302_ckT8 = (CheckBox) view.findViewById(R.id.sec300_p302_ckT8);

        p302_ckV1 = (CheckBox) view.findViewById(R.id.sec300_p302_ckV1);
        p302_ckV2 = (CheckBox) view.findViewById(R.id.sec300_p302_ckV2);
        p302_ckV3 = (CheckBox) view.findViewById(R.id.sec300_p302_ckV3);
        p302_ckV4 = (CheckBox) view.findViewById(R.id.sec300_p302_ckV4);
        p302_ckV5 = (CheckBox) view.findViewById(R.id.sec300_p302_ckV5);
        p302_ckV6 = (CheckBox) view.findViewById(R.id.sec300_p302_ckV6);

        p302_ckO1 = (CheckBox) view.findViewById(R.id.sec300_p302_ckO1);
        p302_ckO2 = (CheckBox) view.findViewById(R.id.sec300_p302_ckO2);


        p303_ck1 = (CheckBox) view.findViewById(R.id.sec300_p303_ck1);
        p303_ck2 = (CheckBox) view.findViewById(R.id.sec300_p303_ck2);
        p303_ck3 = (CheckBox) view.findViewById(R.id.sec300_p303_ck3);
        p303_ck4 = (CheckBox) view.findViewById(R.id.sec300_p303_ck4);
        p303_ck5 = (CheckBox) view.findViewById(R.id.sec300_p303_ck5);
        p303_ck5 = (CheckBox) view.findViewById(R.id.sec300_p303_ck5);
        p303_card = (CardView) view.findViewById(R.id.p303_card);

        p304_rg = (RadioGroup) view.findViewById(R.id.sec300_p304_rg);
        p304_card = (CardView) view.findViewById(R.id.p304_card);
        p304_rb1 = (RadioButton) view.findViewById(R.id.sec300_p304_rb1);
        p304_rb2 = (RadioButton) view.findViewById(R.id.sec300_p304_rb2);
        p304_rb3 = (RadioButton) view.findViewById(R.id.sec300_p304_rb3);

        p305_edt = (TextInputEditText) view.findViewById(R.id.sec300_p305_edt1);
        p305_card = (CardView) view.findViewById(R.id.p305_card);

        edtobs3 = (EditText) view.findViewById(R.id.edt_obs);




        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //----pregunta 302
        final EditText[] editText_edt_col3 = {p302_mCant1,p302_mCant2,p302_mCant3,p302_mCant4,p302_lCant1,p302_lCant2,p302_lCant3,p302_lCant4,
                p302_pCant1,p302_pCant2,p302_pCant3,p302_pCant4,p302_pCant5,p302_tCant1,p302_tCant2,p302_tCant3,p302_tCant4,p302_vCant1,p302_vCant2,p302_vCant3,p302_oCant1};
        for (int q=0;q<editText_edt_col3.length;q++){
            editText_edt_col3[q].setTransformationMethod(new NumericKeyBoardTransformationMethod());
        }




        final CheckBox[] checkBoxes = {p302_ckM1,p302_ckM2, p302_ckM3,p302_ckM4,p302_ckL1,p302_ckL2, p302_ckL3,p302_ckL4,p302_ckP1,
                p302_ckP2, p302_ckP3,p302_ckP4,p302_ckP5, p302_ckT1,p302_ckT2,p302_ckT3,p302_ckT4,p302_ckV1,p302_ckV2,p302_ckV3,p302_ckO1,
                p302_ckM5,p302_ckM6,p302_ckM7,p302_ckM8,p302_ckL5,p302_ckL6, p302_ckL7,p302_ckL8,p302_ckP6,p302_ckP7, p302_ckP8,p302_ckP9,
                p302_ckP10, p302_ckT5,p302_ckT6,p302_ckT7,p302_ckT8,p302_ckV4,p302_ckV5,p302_ckV6,p302_ckO2,p303_ck1,p303_ck2,p303_ck3,p303_ck4,p303_ck5};

        final EditText[] editText= {p302_masaotro,p302_longotro,p302_presotro,p302_temotro,p302_volotro,p302_ototro,p302_mCant1,p302_mCant2,p302_mCant3,p302_mCant4,p302_lCant1,p302_lCant2,p302_lCant3,p302_lCant4,
                p302_pCant1,p302_pCant2,p302_pCant3,p302_pCant4,p302_pCant5,p302_tCant1,p302_tCant2,p302_tCant3,p302_tCant4,p302_vCant1,p302_vCant2,p302_vCant3,p302_oCant1,p305_edt};



        p302_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.sec300_p302_rbSi:
                        p302_lyt.setVisibility(View.VISIBLE);
                        p303_card.setVisibility(View.VISIBLE);
                        p304_card.setVisibility(View.VISIBLE);
                        p305_card.setVisibility(View.VISIBLE);break;
                    case R.id.sec300_p302_rbNo:
                        for (int a=0;a<checkBoxes.length;a++){
                            checkBoxes[a].setChecked(false);
                        }
                        for (int e=0;e<editText.length;e++){
                            editText[e].setText("");
                        }
                        p304_rg.clearCheck();
                        p302_lyt.setVisibility(View.GONE);
                        p303_card.setVisibility(View.GONE);
                        p304_card.setVisibility(View.GONE);
                        p305_card.setVisibility(View.GONE); break;
                }

            }
        });


        final CheckBox[] checkBox_ck_col1 = {p302_ckM1,p302_ckM2, p302_ckM3,p302_ckM4,p302_ckL1,p302_ckL2, p302_ckL3,
                p302_ckL4,p302_ckP1,p302_ckP2, p302_ckP3,p302_ckP4,p302_ckP5, p302_ckT1,p302_ckT2,p302_ckT3,p302_ckT4,p302_ckV1,p302_ckV2,p302_ckV3,p302_ckO1};
        final CheckBox[] checkBox_ck_col2 = {p302_ckM5,p302_ckM6,p302_ckM7,p302_ckM8,p302_ckL5,p302_ckL6, p302_ckL7,
                p302_ckL8,p302_ckP6,p302_ckP7, p302_ckP8,p302_ckP9,p302_ckP10, p302_ckT5,p302_ckT6,p302_ckT7,p302_ckT8,p302_ckV4,p302_ckV5,p302_ckV6,p302_ckO2};

        for(int i=0;i<checkBox_ck_col1.length;i++){
            final int m=i;
            checkBox_ck_col1[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        checkBox_ck_col2[m].setEnabled(true);
                    }else{
                        checkBox_ck_col2[m].setEnabled(false);
                        checkBox_ck_col2[m].setChecked(false);
                    }
                }
            });
        }


        for(int i=0;i<checkBox_ck_col2.length;i++){
            final int k=i;
            checkBox_ck_col2[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        editText_edt_col3[k].setEnabled(true);
                    }else{
                        editText_edt_col3[k].setEnabled(false);
                        editText_edt_col3[k].setText("");
                    }
                }
            });
        }


        //----pregunta 303
        final CheckBox[] checkBox = {p303_ck1,p303_ck2,p303_ck3,p303_ck4,p303_ck5};

        for(int i=0;i<checkBox.length;i++){
            checkBox[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){

                        if (!checkBox[4].isChecked()) {
                            p304_card.setVisibility(View.GONE);
                        }
                        if (checkBox[4].isChecked()){
                            p304_card.setVisibility(View.VISIBLE);
                        }
                    }else{
                        if (checkBox[0].isChecked()||checkBox[1].isChecked()||checkBox[2].isChecked()||checkBox[3].isChecked()){
                            p304_card.setVisibility(View.GONE);
                        }else {
                            p304_card.setVisibility(View.VISIBLE);
                        }

                    }
                }
            });
        }
        cargarDatos();

    }

    public void cargarDatos(){
        data = new Data(context);
        data.open();
        //verifico si ya existe un objeto con datos llenados previamente
        if(data.existeModulo3(idEmpresa)){
            //si existe traigo el objeto
            sec300 = data.getModulo3(idEmpresa);
            //saco los datos del objeto para llenarlos en los elementos del fragment
            //PREGUNTA 301
            if(!sec300.getP_301().equals("") && !sec300.getP_301().equals("-1")){
                ((RadioButton)p301_rg.getChildAt(Integer.parseInt(sec300.getP_301()))).setChecked(true);
            }
            //PREGUNTA 302
            if(!sec300.getP_302().equals("") && !sec300.getP_302().equals("-1")){
                ((RadioButton)p302_rg.getChildAt(Integer.parseInt(sec300.getP_302()))).setChecked(true);
            }
            //PREGUNTA 302_1
            p302_masaotro.setText(sec300.getP_302A_M_4_O());
            if(sec300.getP_302A_M_1().equals("1")) p302_ckM1.setChecked(true);
            if(sec300.getP_302A_M_1().equals("0")) p302_ckM1.setChecked(false);
            if(sec300.getP_302A_M_2().equals("1")) p302_ckM2.setChecked(true);
            if(sec300.getP_302A_M_2().equals("0")) p302_ckM2.setChecked(false);
            if(sec300.getP_302A_M_3().equals("1")) p302_ckM3.setChecked(true);
            if(sec300.getP_302A_M_3().equals("0")) p302_ckM3.setChecked(false);
            if(sec300.getP_302A_M_4().equals("1")) p302_ckM4.setChecked(true);
            if(sec300.getP_302A_M_4().equals("0")) p302_ckM4.setChecked(false);

            if(sec300.getP_302B_M_1().equals("1")) p302_ckM5.setChecked(true);
            if(sec300.getP_302B_M_1().equals("0")) p302_ckM5.setChecked(false);
            if(sec300.getP_302B_M_2().equals("1")) p302_ckM6.setChecked(true);
            if(sec300.getP_302B_M_2().equals("0")) p302_ckM6.setChecked(false);
            if(sec300.getP_302B_M_3().equals("1")) p302_ckM7.setChecked(true);
            if(sec300.getP_302B_M_3().equals("0")) p302_ckM7.setChecked(false);
            if(sec300.getP_302B_M_4().equals("1")) p302_ckM8.setChecked(true);
            if(sec300.getP_302B_M_4().equals("0")) p302_ckM8.setChecked(false);

            p302_mCant1.setText(sec300.getP_302C_M_1());
            p302_mCant2.setText(sec300.getP_302C_M_2());
            p302_mCant3.setText(sec300.getP_302C_M_3());
            p302_mCant4.setText(sec300.getP_302C_M_4());

            //PREGUNTA 302_2
            p302_longotro.setText(sec300.getP_302A_L_4_O());
            if(sec300.getP_302A_L_1().equals("1")) p302_ckL1.setChecked(true);
            if(sec300.getP_302A_L_1().equals("0")) p302_ckL1.setChecked(false);
            if(sec300.getP_302A_L_2().equals("1")) p302_ckL2.setChecked(true);
            if(sec300.getP_302A_L_2().equals("0")) p302_ckL2.setChecked(false);
            if(sec300.getP_302A_L_3().equals("1")) p302_ckL3.setChecked(true);
            if(sec300.getP_302A_L_3().equals("0")) p302_ckL3.setChecked(false);
            if(sec300.getP_302A_L_4().equals("1")) p302_ckL4.setChecked(true);
            if(sec300.getP_302A_L_4().equals("0")) p302_ckL4.setChecked(false);

            if(sec300.getP_302B_L_1().equals("1")) p302_ckL5.setChecked(true);
            if(sec300.getP_302B_L_1().equals("0")) p302_ckL5.setChecked(false);
            if(sec300.getP_302B_L_2().equals("1")) p302_ckL6.setChecked(true);
            if(sec300.getP_302B_L_2().equals("0")) p302_ckL6.setChecked(false);
            if(sec300.getP_302B_L_3().equals("1")) p302_ckL7.setChecked(true);
            if(sec300.getP_302B_L_3().equals("0")) p302_ckL7.setChecked(false);
            if(sec300.getP_302B_L_4().equals("1")) p302_ckL8.setChecked(true);
            if(sec300.getP_302B_L_4().equals("0")) p302_ckL8.setChecked(false);

            p302_lCant1.setText(sec300.getP_302C_L_1());
            p302_lCant2.setText(sec300.getP_302C_L_2());
            p302_lCant3.setText(sec300.getP_302C_L_3());
            p302_lCant4.setText(sec300.getP_302C_L_4());

            //PREGUNTA 302_3
            p302_presotro.setText(sec300.getP_302A_P_5_O());
            if(sec300.getP_302A_P_1().equals("1")) p302_ckP1.setChecked(true);
            if(sec300.getP_302A_P_1().equals("0")) p302_ckP1.setChecked(false);
            if(sec300.getP_302A_P_2().equals("1")) p302_ckP2.setChecked(true);
            if(sec300.getP_302A_P_2().equals("0")) p302_ckP2.setChecked(false);
            if(sec300.getP_302A_P_3().equals("1")) p302_ckP3.setChecked(true);
            if(sec300.getP_302A_P_3().equals("0")) p302_ckP3.setChecked(false);
            if(sec300.getP_302A_P_4().equals("1")) p302_ckP4.setChecked(true);
            if(sec300.getP_302A_P_4().equals("0")) p302_ckP4.setChecked(false);
            if(sec300.getP_302A_P_5().equals("1")) p302_ckP5.setChecked(true);
            if(sec300.getP_302A_P_5().equals("0")) p302_ckP5.setChecked(false);

            if(sec300.getP_302B_P_1().equals("1")) p302_ckP6.setChecked(true);
            if(sec300.getP_302B_P_1().equals("0")) p302_ckP6.setChecked(false);
            if(sec300.getP_302B_P_2().equals("1")) p302_ckP7.setChecked(true);
            if(sec300.getP_302B_P_2().equals("0")) p302_ckP7.setChecked(false);
            if(sec300.getP_302B_P_3().equals("1")) p302_ckP8.setChecked(true);
            if(sec300.getP_302B_P_3().equals("0")) p302_ckP8.setChecked(false);
            if(sec300.getP_302B_P_4().equals("1")) p302_ckP9.setChecked(true);
            if(sec300.getP_302B_P_4().equals("0")) p302_ckP9.setChecked(false);
            if(sec300.getP_302B_P_5().equals("1")) p302_ckP10.setChecked(true);
            if(sec300.getP_302B_P_5().equals("0")) p302_ckP10.setChecked(false);

            p302_pCant1.setText(sec300.getP_302C_P_1());
            p302_pCant2.setText(sec300.getP_302C_P_2());
            p302_pCant3.setText(sec300.getP_302C_P_3());
            p302_pCant4.setText(sec300.getP_302C_P_4());
            p302_pCant5.setText(sec300.getP_302C_P_5());

            //PREGUNTA 302_4
            p302_temotro.setText(sec300.getP_302A_T_4_O());
            if(sec300.getP_302A_T_1().equals("1")) p302_ckT1.setChecked(true);
            if(sec300.getP_302A_T_1().equals("0")) p302_ckT1.setChecked(false);
            if(sec300.getP_302A_T_2().equals("1")) p302_ckT2.setChecked(true);
            if(sec300.getP_302A_T_2().equals("0")) p302_ckT2.setChecked(false);
            if(sec300.getP_302A_T_3().equals("1")) p302_ckT3.setChecked(true);
            if(sec300.getP_302A_T_3().equals("0")) p302_ckT3.setChecked(false);
            if(sec300.getP_302A_T_4().equals("1")) p302_ckT4.setChecked(true);
            if(sec300.getP_302A_T_4().equals("0")) p302_ckT4.setChecked(false);

            if(sec300.getP_302B_T_1().equals("1")) p302_ckT5.setChecked(true);
            if(sec300.getP_302B_T_1().equals("0")) p302_ckT5.setChecked(false);
            if(sec300.getP_302B_T_2().equals("1")) p302_ckT6.setChecked(true);
            if(sec300.getP_302B_T_2().equals("0")) p302_ckT6.setChecked(false);
            if(sec300.getP_302B_T_3().equals("1")) p302_ckT7.setChecked(true);
            if(sec300.getP_302B_T_3().equals("0")) p302_ckT7.setChecked(false);
            if(sec300.getP_302B_T_4().equals("1")) p302_ckT8.setChecked(true);
            if(sec300.getP_302B_T_4().equals("0")) p302_ckT8.setChecked(false);

            p302_tCant1.setText(sec300.getP_302C_T_1());
            p302_tCant2.setText(sec300.getP_302C_T_2());
            p302_tCant3.setText(sec300.getP_302C_T_3());
            p302_tCant4.setText(sec300.getP_302C_T_4());

            //PREGUNTA 302_5
            p302_volotro.setText(sec300.getP_302A_V_3_O());
            if(sec300.getP_302A_V_1().equals("1")) p302_ckV1.setChecked(true);
            if(sec300.getP_302A_V_1().equals("0")) p302_ckV1.setChecked(false);
            if(sec300.getP_302A_V_2().equals("1")) p302_ckV2.setChecked(true);
            if(sec300.getP_302A_V_2().equals("0")) p302_ckV2.setChecked(false);
            if(sec300.getP_302A_V_3().equals("1")) p302_ckV3.setChecked(true);
            if(sec300.getP_302A_V_3().equals("0")) p302_ckV3.setChecked(false);

            if(sec300.getP_302B_V_1().equals("1")) p302_ckV4.setChecked(true);
            if(sec300.getP_302B_V_1().equals("0")) p302_ckV4.setChecked(false);
            if(sec300.getP_302B_V_2().equals("1")) p302_ckV5.setChecked(true);
            if(sec300.getP_302B_V_2().equals("0")) p302_ckV5.setChecked(false);
            if(sec300.getP_302B_V_3().equals("1")) p302_ckV6.setChecked(true);
            if(sec300.getP_302B_V_3().equals("0")) p302_ckV6.setChecked(false);

            p302_vCant1.setText(sec300.getP_302C_V_1());
            p302_vCant2.setText(sec300.getP_302C_V_2());
            p302_vCant3.setText(sec300.getP_302C_V_3());

            //PREGUNTA 302_6
            p302_ototro.setText(sec300.getP_302A_O_1_O());
            if(sec300.getP_302A_O_1().equals("1")) p302_ckO1.setChecked(true);
            if(sec300.getP_302A_O_1().equals("0")) p302_ckO1.setChecked(false);

            if(sec300.getP_302B_O_1().equals("1")) p302_ckO2.setChecked(true);
            if(sec300.getP_302B_O_1().equals("0")) p302_ckO2.setChecked(false);

            p302_oCant1.setText(sec300.getP_302C_O_1());

            //PREGUNTA 303
            if(sec300.getP_303_1().equals("1")) p303_ck1.setChecked(true);
            if(sec300.getP_303_1().equals("0")) p303_ck1.setChecked(false);
            if(sec300.getP_303_2().equals("1")) p303_ck2.setChecked(true);
            if(sec300.getP_303_2().equals("0")) p303_ck2.setChecked(false);
            if(sec300.getP_303_3().equals("1")) p303_ck3.setChecked(true);
            if(sec300.getP_303_3().equals("0")) p303_ck3.setChecked(false);
            if(sec300.getP_303_4().equals("1")) p303_ck4.setChecked(true);
            if(sec300.getP_303_4().equals("0")) p303_ck4.setChecked(false);
            if(sec300.getP_303_5().equals("1")) p303_ck5.setChecked(true);
            if(sec300.getP_303_5().equals("0")) p303_ck5.setChecked(false);

            //PREGUNTA 304
            if(!sec300.getP_304().equals("") && !sec300.getP_304().equals("-1")){
                ((RadioButton)p304_rg.getChildAt(Integer.parseInt(sec300.getP_304()))).setChecked(true);
            }
            //PREGUNTA 305
            p305_edt.setText(sec300.getP_305());

            //OBS
            edtobs3.setText(sec300.getOBS());



        }
        data.close();
    }
    public void llenarMapaVariables(){

        //PREGUNTA 301
        int childPosP301 = p301_rg.indexOfChild(p301_rg.findViewById(p301_rg.getCheckedRadioButtonId()));
        P_301= childPosP301;
        //PREGUNTA 302
        int childPosP302 = p302_rg.indexOfChild(p302_rg.findViewById(p302_rg.getCheckedRadioButtonId()));
        P_302 = childPosP302;

        //PREGUNTA 302-1
        P_302A_M_4_O = p302_masaotro.getText().toString();

        if(p302_ckM1.isChecked())P_302A_M_1 = 1;
        else P_302A_M_1 = 0;
        if(p302_ckM2.isChecked())P_302A_M_2 = 1;
        else P_302A_M_2 = 0;
        if(p302_ckM3.isChecked())P_302A_M_3 = 1;
        else P_302A_M_3 = 0;
        if(p302_ckM4.isChecked())P_302A_M_4 = 1;
        else P_302A_M_4 = 0;

        if(p302_ckM5.isChecked())P_302B_M_1 = 1;
        else P_302B_M_1 = 0;
        if(p302_ckM6.isChecked())P_302B_M_2 = 1;
        else P_302B_M_2 = 0;
        if(p302_ckM7.isChecked())P_302B_M_3 = 1;
        else P_302B_M_3 = 0;
        if(p302_ckM8.isChecked())P_302B_M_4 = 1;
        else P_302B_M_4 = 0;


        P_302C_M_1 = p302_mCant1.getText().toString();
        P_302C_M_2 = p302_mCant2.getText().toString();
        P_302C_M_3 = p302_mCant3.getText().toString();
        P_302C_M_4 = p302_mCant4.getText().toString();

        //PREGUNTA 302-2

        P_302A_L_4_O = p302_longotro.getText().toString();

        if(p302_ckL1.isChecked())P_302A_L_1 = 1;
        else P_302A_L_1 = 0;
        if(p302_ckL2.isChecked())P_302A_L_2 = 1;
        else P_302A_L_2 = 0;
        if(p302_ckL3.isChecked())P_302A_L_3 = 1;
        else P_302A_L_3 = 0;
        if(p302_ckL4.isChecked())P_302A_L_4 = 1;
        else P_302A_L_4 = 0;

        if(p302_ckL5.isChecked())P_302B_L_1 = 1;
        else P_302B_L_1 = 0;
        if(p302_ckL6.isChecked())P_302B_L_2 = 1;
        else P_302B_L_2 = 0;
        if(p302_ckL7.isChecked())P_302B_L_3 = 1;
        else P_302B_L_3 = 0;
        if(p302_ckL8.isChecked())P_302B_L_4 = 1;
        else P_302B_L_4 = 0;


        P_302C_L_1 = p302_lCant1.getText().toString();
        P_302C_L_2 = p302_lCant2.getText().toString();
        P_302C_L_3 = p302_lCant3.getText().toString();
        P_302C_L_4 = p302_lCant4.getText().toString();

        //PREGUNTA 302-3
        P_302A_P_5_O = p302_presotro.getText().toString();
        if(p302_ckP1.isChecked())P_302A_P_1 = 1;
        else P_302A_P_1 = 0;
        if(p302_ckP2.isChecked())P_302A_P_2 = 1;
        else P_302A_P_2 = 0;
        if(p302_ckP3.isChecked())P_302A_P_3 = 1;
        else P_302A_P_3 = 0;
        if(p302_ckP4.isChecked())P_302A_P_4 = 1;
        else P_302A_P_4 = 0;
        if(p302_ckP5.isChecked())P_302A_P_5 = 1;
        else P_302A_P_5 = 0;

        if(p302_ckP6.isChecked())P_302B_P_1 = 1;
        else P_302B_P_1 = 0;
        if(p302_ckP7.isChecked())P_302B_P_2 = 1;
        else P_302B_P_2 = 0;
        if(p302_ckP8.isChecked())P_302B_P_3 = 1;
        else P_302B_P_3 = 0;
        if(p302_ckP9.isChecked())P_302B_P_4 = 1;
        else P_302B_P_4 = 0;
        if(p302_ckP10.isChecked())P_302B_P_5 = 1;
        else P_302B_P_5 = 0;


        P_302C_P_1 = p302_pCant1.getText().toString();
        P_302C_P_2 = p302_pCant2.getText().toString();
        P_302C_P_3 = p302_pCant3.getText().toString();
        P_302C_P_4 = p302_pCant4.getText().toString();
        P_302C_P_5 = p302_pCant5.getText().toString();

        //PREGUNTA 302-4
        P_302A_T_4_O = p302_temotro.getText().toString();

        if(p302_ckT1.isChecked())P_302A_T_1 = 1;
        else P_302A_T_1 = 0;
        if(p302_ckT2.isChecked())P_302A_T_2 = 1;
        else P_302A_T_2 = 0;
        if(p302_ckT3.isChecked())P_302A_T_3 = 1;
        else P_302A_T_3 = 0;
        if(p302_ckT4.isChecked())P_302A_T_4 = 1;
        else P_302A_T_4 = 0;

        if(p302_ckT5.isChecked())P_302B_T_1 = 1;
        else P_302B_T_1 = 0;
        if(p302_ckT6.isChecked())P_302B_T_2 = 1;
        else P_302B_T_2 = 0;
        if(p302_ckT7.isChecked())P_302B_T_3 = 1;
        else P_302B_T_3 = 0;
        if(p302_ckT8.isChecked())P_302B_T_4 = 1;
        else P_302B_T_4 = 0;


        P_302C_T_1 = p302_tCant1.getText().toString();
        P_302C_T_2 = p302_tCant2.getText().toString();
        P_302C_T_3 = p302_tCant3.getText().toString();
        P_302C_T_4 = p302_tCant4.getText().toString();

        //PREGUNTA 302-5
        P_302A_V_3_O = p302_volotro.getText().toString();

        if(p302_ckV1.isChecked())P_302A_V_1 = 1;
        else P_302A_V_1 = 0;
        if(p302_ckV2.isChecked())P_302A_V_2 = 1;
        else P_302A_V_2 = 0;
        if(p302_ckV3.isChecked())P_302A_V_3 = 1;
        else P_302A_V_3 = 0;

        if(p302_ckV4.isChecked())P_302B_V_1 = 1;
        else P_302B_V_1 = 0;
        if(p302_ckV5.isChecked())P_302B_V_2 = 1;
        else P_302B_V_2 = 0;
        if(p302_ckV6.isChecked())P_302B_V_3 = 1;
        else P_302B_V_3 = 0;


        P_302C_V_1 = p302_vCant1.getText().toString();
        P_302C_V_2 = p302_vCant2.getText().toString();
        P_302C_V_3 = p302_vCant3.getText().toString();

        //PREGUNTA 302-6
        P_302A_O_1_O = p302_ototro.getText().toString();

        if(p302_ckO1.isChecked())P_302A_O_1 = 1;
        else P_302A_O_1 = 0;

        if(p302_ckO2.isChecked())P_302B_O_1 = 1;
        else P_302B_O_1 = 0;
        P_302C_O_1 = p302_oCant1.getText().toString();

        //PREGUNTA 303
        if(p303_ck1.isChecked())P_303_1 = 1;
        else P_303_1 = 0;
        if(p303_ck2.isChecked())P_303_2 = 1;
        else P_303_2 = 0;
        if(p303_ck3.isChecked())P_303_3 = 1;
        else P_303_3 = 0;
        if(p303_ck4.isChecked())P_303_4 = 1;
        else P_303_4 = 0;
        if(p303_ck5.isChecked())P_303_5 = 1;
        else P_303_5 = 0;

        //PREGUNTA 304
        int childPosP304 = p304_rg.indexOfChild(p304_rg.findViewById(p304_rg.getCheckedRadioButtonId()));
        P_304= childPosP304;

        //PREGUNTA 305
        P_305 = p305_edt.getText().toString();

        OBS_SEC300 = edtobs3.getText().toString();
    }


    public void guardarDatos(){
        llenarMapaVariables();
        data = new Data(context);
        data.open();
        if(data.existeModulo3(idEmpresa)){
            ContentValues contentValues = new ContentValues(77);
            contentValues.put(SQLConstantes.SECCION300_P_301,P_301+"");
            contentValues.put(SQLConstantes.SECCION300_P_302,P_302+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_M_1,P_302A_M_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_M_2,P_302A_M_2+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_M_3,P_302A_M_3+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_M_4,P_302A_M_4+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_M_4_O,P_302A_M_4_O);
            contentValues.put(SQLConstantes.SECCION300_P_302A_L_1,P_302A_L_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_L_2,P_302A_L_2+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_L_3,P_302A_L_3+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_L_4,P_302A_L_4+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_L_4_O,P_302A_L_4_O);
            contentValues.put(SQLConstantes.SECCION300_P_302A_P_1,P_302A_P_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_P_2,P_302A_P_2+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_P_3,P_302A_P_3+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_P_4,P_302A_P_4+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_P_5,P_302A_P_5+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_P_5_O,P_302A_P_5_O);
            contentValues.put(SQLConstantes.SECCION300_P_302A_T_1,P_302A_T_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_T_2,P_302A_T_2+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_T_3,P_302A_T_3+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_T_4,P_302A_T_4+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_T_4_O,P_302A_T_4_O);
            contentValues.put(SQLConstantes.SECCION300_P_302A_V_1,P_302A_V_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_V_2,P_302A_V_2+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_V_3,P_302A_V_3+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_V_3_O,P_302A_V_3_O);
            contentValues.put(SQLConstantes.SECCION300_P_302A_O_1,P_302A_O_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_302A_O_1_O,P_302A_O_1_O);
            contentValues.put(SQLConstantes.SECCION300_P_302B_M_1,P_302B_M_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_M_2,P_302B_M_2+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_M_3,P_302B_M_3+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_M_4,P_302B_M_4+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_L_1,P_302B_L_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_L_2,P_302B_L_2+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_L_3,P_302B_L_3+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_L_4,P_302B_L_4+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_P_1,P_302B_P_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_P_2,P_302B_P_2+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_P_3,P_302B_P_3+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_P_4,P_302B_P_4+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_P_5,P_302B_P_5+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_T_1,P_302B_T_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_T_2,P_302B_T_2+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_T_3,P_302B_T_3+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_T_4,P_302B_T_4+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_V_1,P_302B_V_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_V_2,P_302B_V_2+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_V_3,P_302B_V_3+"");
            contentValues.put(SQLConstantes.SECCION300_P_302B_O_1,P_302B_O_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_302C_M_1,P_302C_M_1);
            contentValues.put(SQLConstantes.SECCION300_P_302C_M_2,P_302C_M_2);
            contentValues.put(SQLConstantes.SECCION300_P_302C_M_3,P_302C_M_3);
            contentValues.put(SQLConstantes.SECCION300_P_302C_M_4,P_302C_M_4);
            contentValues.put(SQLConstantes.SECCION300_P_302C_L_1,P_302C_L_1);
            contentValues.put(SQLConstantes.SECCION300_P_302C_L_2,P_302C_L_2);
            contentValues.put(SQLConstantes.SECCION300_P_302C_L_3,P_302C_L_3);
            contentValues.put(SQLConstantes.SECCION300_P_302C_L_4,P_302C_L_4);
            contentValues.put(SQLConstantes.SECCION300_P_302C_P_1,P_302C_P_1);
            contentValues.put(SQLConstantes.SECCION300_P_302C_P_2,P_302C_P_2);
            contentValues.put(SQLConstantes.SECCION300_P_302C_P_3,P_302C_P_3);
            contentValues.put(SQLConstantes.SECCION300_P_302C_P_4,P_302C_P_4);
            contentValues.put(SQLConstantes.SECCION300_P_302C_P_5,P_302C_P_5);
            contentValues.put(SQLConstantes.SECCION300_P_302C_T_1,P_302C_T_1);
            contentValues.put(SQLConstantes.SECCION300_P_302C_T_2,P_302C_T_2);
            contentValues.put(SQLConstantes.SECCION300_P_302C_T_3,P_302C_T_3);
            contentValues.put(SQLConstantes.SECCION300_P_302C_T_4,P_302C_T_4);
            contentValues.put(SQLConstantes.SECCION300_P_302C_V_1,P_302C_V_1);
            contentValues.put(SQLConstantes.SECCION300_P_302C_V_2,P_302C_V_2);
            contentValues.put(SQLConstantes.SECCION300_P_302C_V_3,P_302C_V_3);
            contentValues.put(SQLConstantes.SECCION300_P_302C_O_1,P_302C_O_1);
            contentValues.put(SQLConstantes.SECCION300_P_303_1,P_303_1+"");
            contentValues.put(SQLConstantes.SECCION300_P_303_2,P_303_2+"");
            contentValues.put(SQLConstantes.SECCION300_P_303_3,P_303_3+"");
            contentValues.put(SQLConstantes.SECCION300_P_303_4,P_303_4+"");
            contentValues.put(SQLConstantes.SECCION300_P_303_5,P_303_5+"");
            contentValues.put(SQLConstantes.SECCION300_P_304,P_304+"");
            contentValues.put(SQLConstantes.SECCION300_P_305,P_305);
            contentValues.put(SQLConstantes.SECCION300_OBS,OBS_SEC300);
            data.actualizarModulo3(idEmpresa,contentValues);
        }else{
            //si no existe el elemento, lo construye para insertarlo
            sec300 = new Sec300PojoF1();
            //llena el objeto a insertar
            sec300.setID(idEmpresa);
            sec300.setP_301(P_301+"");
            sec300.setP_302(P_302+"");
            sec300.setP_302A_M_1(P_302A_M_1+"");
            sec300.setP_302A_M_2(P_302A_M_2+"");
            sec300.setP_302A_M_3(P_302A_M_3+"");
            sec300.setP_302A_M_4(P_302A_M_4+"");
            sec300.setP_302A_M_4_O(P_302A_M_4_O);
            sec300.setP_302A_L_1(P_302A_L_1+"");
            sec300.setP_302A_L_2(P_302A_L_2+"");
            sec300.setP_302A_L_3(P_302A_L_3+"");
            sec300.setP_302A_L_4(P_302A_L_4+"");
            sec300.setP_302A_L_4_O(P_302A_L_4_O);
            sec300.setP_302A_P_1(P_302A_P_1+"");
            sec300.setP_302A_P_2(P_302A_P_2+"");
            sec300.setP_302A_P_3(P_302A_P_3+"");
            sec300.setP_302A_P_4(P_302A_P_4+"");
            sec300.setP_302A_P_5(P_302A_P_5+"");
            sec300.setP_302A_P_5_O(P_302A_P_5_O);
            sec300.setP_302A_T_1(P_302A_T_1+"");
            sec300.setP_302A_T_2(P_302A_T_2+"");
            sec300.setP_302A_T_3(P_302A_T_3+"");
            sec300.setP_302A_T_4(P_302A_T_4+"");
            sec300.setP_302A_T_4_O(P_302A_T_4_O);
            sec300.setP_302A_V_1(P_302A_V_1+"");
            sec300.setP_302A_V_2(P_302A_V_2+"");
            sec300.setP_302A_V_3(P_302A_V_3+"");
            sec300.setP_302A_V_3_O(P_302A_V_3_O);
            sec300.setP_302A_O_1(P_302A_O_1+"");
            sec300.setP_302A_O_1_O(P_302A_O_1_O);
            sec300.setP_302B_M_1(P_302B_M_1+"");
            sec300.setP_302B_M_2(P_302B_M_2+"");
            sec300.setP_302B_M_3(P_302B_M_3+"");
            sec300.setP_302B_M_4(P_302B_M_4+"");
            sec300.setP_302B_L_1(P_302B_L_1+"");
            sec300.setP_302B_L_2(P_302B_L_2+"");
            sec300.setP_302B_L_3(P_302B_L_3+"");
            sec300.setP_302B_L_4(P_302B_L_4+"");
            sec300.setP_302B_P_1(P_302B_P_1+"");
            sec300.setP_302B_P_2(P_302B_P_2+"");
            sec300.setP_302B_P_3(P_302B_P_3+"");
            sec300.setP_302B_P_4(P_302B_P_4+"");
            sec300.setP_302B_P_5(P_302B_P_5+"");
            sec300.setP_302B_T_1(P_302B_T_1+"");
            sec300.setP_302B_T_2(P_302B_T_2+"");
            sec300.setP_302B_T_3(P_302B_T_3+"");
            sec300.setP_302B_T_4(P_302B_T_4+"");
            sec300.setP_302B_V_1(P_302B_V_1+"");
            sec300.setP_302B_V_2(P_302B_V_2+"");
            sec300.setP_302B_V_3(P_302B_V_3+"");
            sec300.setP_302B_O_1(P_302B_O_1+"");
            sec300.setP_302C_M_1(P_302C_M_1);
            sec300.setP_302C_M_2(P_302C_M_2);
            sec300.setP_302C_M_3(P_302C_M_3);
            sec300.setP_302C_M_4(P_302C_M_4);
            sec300.setP_302C_L_1(P_302C_L_1);
            sec300.setP_302C_L_2(P_302C_L_2);
            sec300.setP_302C_L_3(P_302C_L_3);
            sec300.setP_302C_L_4(P_302C_L_4);
            sec300.setP_302C_P_1(P_302C_P_1);
            sec300.setP_302C_P_2(P_302C_P_2);
            sec300.setP_302C_P_3(P_302C_P_3);
            sec300.setP_302C_P_4(P_302C_P_4);
            sec300.setP_302C_P_5(P_302C_P_5);
            sec300.setP_302C_T_1(P_302C_T_1);
            sec300.setP_302C_T_2(P_302C_T_2);
            sec300.setP_302C_T_3(P_302C_T_3);
            sec300.setP_302C_T_4(P_302C_T_4);
            sec300.setP_302C_V_1(P_302C_V_1);
            sec300.setP_302C_V_2(P_302C_V_2);
            sec300.setP_302C_V_3(P_302C_V_3);
            sec300.setP_302C_O_1(P_302C_O_1);
            sec300.setP_303_1(P_303_1+"");
            sec300.setP_303_2(P_303_2+"");
            sec300.setP_303_3(P_303_3+"");
            sec300.setP_303_4(P_303_4+"");
            sec300.setP_303_5(P_303_5+"");
            sec300.setP_304(P_304+"");
            sec300.setP_305(P_305);
            sec300.setOBS(OBS_SEC300);
            data.insertarModulo3(sec300);
        }
        data.close();
    }

    public boolean validar(){
        boolean valido = true;
        String mensaje = "";
        llenarMapaVariables();

        //301
        if(P_301==-1) {
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 301: DEBE SELECCIONAR AL MENOS UNA OPCION";
        }
        //302
        if(P_302==-1) {
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 302: DEBE SELECCIONAR AL MENOS UNA OPCION";
        }else{
            if(P_302 == 1 ){
                valido=true;
            }else{
                if (P_302A_M_1!=1&&P_302A_M_2!=1&&P_302A_M_3!=1&&P_302A_M_4!=1&&
                    P_302A_L_1!=1&&P_302A_L_2!=1&&P_302A_L_3!=1&&P_302A_L_4!=1&&
                    P_302A_P_1!=1&&P_302A_P_2!=1&&P_302A_P_3!=1&&P_302A_P_4!=1&&P_302A_P_5!=1&&
                    P_302A_T_1!=1&&P_302A_T_2!=1&&P_302A_T_3!=1&&P_302A_T_4!=1&&
                    P_302A_V_1!=1&&P_302A_V_2!=1&&P_302A_V_3!=1&&P_302A_O_1!=1){
                    valido = false;
                    if(mensaje.equals(""))mensaje = "PREGUNTA 302A: DEBE SELECCIONAR AL MENOS UN INSTRUMENTO DE MEDICION QUE UTILIZA";
                }
                if ((P_302A_M_4==1 && P_302A_M_4_O.equals("")) || (P_302A_L_4==1 && P_302A_L_4_O.equals(""))
                    || (P_302A_P_5==1 && P_302A_P_5_O.equals(""))|| (P_302A_T_4==1 && P_302A_T_4_O.equals(""))
                    || (P_302A_V_3==1 && P_302A_V_3_O.equals(""))|| (P_302A_O_1==1 && P_302A_O_1_O.equals(""))){
                    valido = false;
                    if(mensaje.equals(""))mensaje = "PREGUNTA 302A: DEBE ESPECIFICAR EL INSTRUMENTO DE MEDICION Q UTILIZA";
                }
                if ((P_302A_M_1==1 && P_302B_M_1==1 && P_302C_M_1.equals(""))||(P_302A_M_2==1 && P_302B_M_2==1 && P_302C_M_2.equals(""))||
                    (P_302A_M_3==1 && P_302B_M_3==1 && P_302C_M_3.equals(""))||(P_302A_M_4==1 && P_302B_M_4==1 && P_302C_M_4.equals(""))||
                    (P_302A_L_1==1 && P_302B_L_1==1 && P_302C_L_1.equals(""))||(P_302A_L_2==1 && P_302B_L_2==1 && P_302C_L_2.equals(""))||
                    (P_302A_L_3==1 && P_302B_L_3==1 && P_302C_L_3.equals(""))||(P_302A_L_4==1 && P_302B_L_4==1 && P_302C_L_4.equals(""))||
                    (P_302A_P_1==1 && P_302B_P_1==1 && P_302C_P_1.equals(""))||(P_302A_P_2==1 && P_302B_P_2==1 && P_302C_P_2.equals(""))||(P_302A_P_3==1 && P_302B_P_3==1 && P_302C_P_3.equals(""))||
                    (P_302A_P_4==1 && P_302B_P_4==1 && P_302C_P_4.equals(""))||(P_302A_P_5==1 && P_302B_P_5==1 && P_302C_P_5.equals(""))||
                    (P_302A_T_1==1 && P_302B_T_1==1 && P_302C_T_1.equals(""))||(P_302A_T_2==1 && P_302B_T_2==1 && P_302C_T_2.equals(""))||
                    (P_302A_T_3==1 && P_302B_T_3==1 && P_302C_T_3.equals(""))||(P_302A_T_4==1 && P_302B_T_4==1 && P_302C_T_4.equals(""))||
                    (P_302A_V_1==1 && P_302B_V_1==1 && P_302C_V_1.equals(""))||(P_302A_V_2==1 && P_302B_V_2==1 && P_302C_V_2.equals(""))||
                    (P_302A_V_3==1 && P_302B_V_3==1 && P_302C_V_3.equals(""))||(P_302A_O_1==1 && P_302B_O_1==1 && P_302C_O_1.equals(""))){
                    valido = false;
                    if(mensaje.equals(""))mensaje = "PREGUNTA 302C: DEBE EXISTIR INFORMACION";
                }
                if ((P_302A_M_1==1 && P_302B_M_1==1 && !P_302C_M_1.equals("")&&Integer.parseInt(P_302C_M_1)<1)||(P_302A_M_2==1 && P_302B_M_2==1 && !P_302C_M_2.equals("")&&Integer.parseInt(P_302C_M_2)<1)||
                        (P_302A_M_3==1 && P_302B_M_3==1 && !P_302C_M_3.equals("")&&Integer.parseInt(P_302C_M_3)<1)||(P_302A_M_4==1 && P_302B_M_4==1 && !P_302C_M_4.equals("")&&Integer.parseInt(P_302C_M_4)<1)||
                        (P_302A_L_1==1 && P_302B_L_1==1 && !P_302C_L_1.equals("")&&Integer.parseInt(P_302C_L_1)<1)||(P_302A_L_2==1 && P_302B_L_2==1 && !P_302C_L_2.equals("")&&Integer.parseInt(P_302C_L_2)<1)||
                        (P_302A_L_3==1 && P_302B_L_3==1 && !P_302C_L_3.equals("")&&Integer.parseInt(P_302C_L_3)<1)||(P_302A_L_4==1 && P_302B_L_4==1 && !P_302C_L_4.equals("")&&Integer.parseInt(P_302C_L_4)<1)||
                        (P_302A_P_1==1 && P_302B_P_1==1 && !P_302C_P_1.equals("")&&Integer.parseInt(P_302C_P_1)<1)||(P_302A_P_2==1 && P_302B_P_2==1 && !P_302C_P_2.equals("")&&Integer.parseInt(P_302C_P_2)<1)||
                        (P_302A_P_3==1 && P_302B_P_3==1 && !P_302C_P_3.equals("")&&Integer.parseInt(P_302C_P_3)<1)||
                        (P_302A_P_4==1 && P_302B_P_4==1 && !P_302C_P_4.equals("")&&Integer.parseInt(P_302C_P_4)<1)||(P_302A_P_5==1 && P_302B_P_5==1 && !P_302C_P_5.equals("")&&Integer.parseInt(P_302C_P_5)<1)||
                        (P_302A_T_1==1 && P_302B_T_1==1 && !P_302C_T_1.equals("")&&Integer.parseInt(P_302C_T_1)<1)||(P_302A_T_2==1 && P_302B_T_2==1 && !P_302C_T_2.equals("")&&Integer.parseInt(P_302C_T_2)<1)||
                        (P_302A_T_3==1 && P_302B_T_3==1 && !P_302C_T_3.equals("")&&Integer.parseInt(P_302C_T_3)<1)||(P_302A_T_4==1 && P_302B_T_4==1 && !P_302C_T_4.equals("")&&Integer.parseInt(P_302C_T_4)<1)||
                        (P_302A_V_1==1 && P_302B_V_1==1 && !P_302C_V_1.equals("")&&Integer.parseInt(P_302C_V_1)<1)||(P_302A_V_2==1 && P_302B_V_2==1 && !P_302C_V_2.equals("")&&Integer.parseInt(P_302C_V_2)<1)||
                        (P_302A_V_3==1 && P_302B_V_3==1 && !P_302C_V_3.equals("")&&Integer.parseInt(P_302C_V_3)<1)||(P_302A_O_1==1 && P_302B_O_1==1 && !P_302C_O_1.equals("")&&Integer.parseInt(P_302C_O_1)<1)){
                    valido = false;
                    if(mensaje.equals(""))mensaje = "PREGUNTA 302C: DEBE EXISTIR POR LO MENOS UN INSTRUMENTO CALIBRADO EN EL 2016";
                }
                //303
                if(P_303_1 != 1 && P_303_2 != 1 && P_303_3 != 1 && P_303_4 != 1 && P_303_5 != 1) {
                    valido = false;
                    if(mensaje.equals(""))mensaje = "PREGUNTA 303: DEBE SELECCIONAR AL MENOS UNA ALTERNATIVA";
                }
                data = new Data(context);
                data.open();
                int cinacal = Integer.parseInt(data.getIdentificacion(idEmpresa).getCONOCE_INACAL());
                data.close();
                int verificacion =  cinacal;
                if(verificacion!=-1){
                    if(P_303_4==1 &&verificacion==1){
                        valido = false;
                        if(mensaje.equals(""))mensaje = "PREGUNTA 303: : Usted indicó que no conoce ni ha oído hablar de INACAL";
                    }
                }
                if (P_303_5==1){

                        data = new Data(context);
                        data.open();
                        int cinacal1 = Integer.parseInt(data.getIdentificacion(idEmpresa).getCONOCE_INACAL());
                        data.close();
                        int verificacion1 =  cinacal1;
                        if(verificacion1!=-1 && P_304!=-1){
                            if((P_304==0 || P_304==1) &&verificacion1==1){
                                valido = false;
                                if(mensaje.equals(""))mensaje = "PREGUNTA 304: : Usted indicó que no conoce ni ha oído hablar de INACAL";
                            }
                        }else{
                            if(mensaje.equals(""))mensaje = "PREGUNTA 304: DEBE SELECCIONAR AL MENOS UNA ALTERNATIVA";
                        }

                }
                if (P_305.equals("")){
                    valido = false;
                    if(mensaje.equals(""))mensaje = "PREGUNTA 305: : Debe existir información de gasto incurrido en las calibraciones, y puede ser mayor o igual a cero";

                }

            }
        }

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
