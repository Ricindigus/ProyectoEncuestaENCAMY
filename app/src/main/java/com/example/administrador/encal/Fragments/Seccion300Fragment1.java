package com.example.administrador.encal.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
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
  /*
    private RadioGroup p302_rgM1;
    private RadioGroup p302_rgM2;
    private RadioGroup p302_rgM3;
    private RadioGroup p302_rgM4;
    private RadioGroup p302_rgM5;
    private RadioGroup p302_rgM6;
    private RadioGroup p302_rgM7;
    private RadioGroup p302_rgM8;
    private RadioGroup p302_rgL1;
    private RadioGroup p302_rgL2;
    private RadioGroup p302_rgL3;
    private RadioGroup p302_rgL4;
    private RadioGroup p302_rgL5;
    private RadioGroup p302_rgL6;
    private RadioGroup p302_rgL7;
    private RadioGroup p302_rgL8;
    private RadioGroup p302_rgP1;
    private RadioGroup p302_rgP2;
    private RadioGroup p302_rgP3;
    private RadioGroup p302_rgP4;
    private RadioGroup p302_rgP5;
    private RadioGroup p302_rgP6;
    private RadioGroup p302_rgP7;
    private RadioGroup p302_rgP8;
    private RadioGroup p302_rgP9;
    private RadioGroup p302_rgP10;
    private RadioGroup p302_rgT1;
    private RadioGroup p302_rgT2;
    private RadioGroup p302_rgT3;
    private RadioGroup p302_rgT4;
    private RadioGroup p302_rgT5;
    private RadioGroup p302_rgT6;
    private RadioGroup p302_rgT7;
    private RadioGroup p302_rgT8;
    private RadioGroup p302_rgV1;
    private RadioGroup p302_rgV2;
    private RadioGroup p302_rgV3;
    private RadioGroup p302_rgV4;
    private RadioGroup p302_rgV5;
    private RadioGroup p302_rgV6;
    private RadioGroup p302_rgO1;
    private RadioGroup p302_rgO2;

    */
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

    private RadioButton p302_rbM9;
    private RadioButton p302_rbM10;
    private RadioButton p302_rbM11;
    private RadioButton p302_rbM12;
    private RadioButton p302_rbM13;
    private RadioButton p302_rbM14;
    private RadioButton p302_rbM15;
    private RadioButton p302_rbM16;




    private CheckBox p303_ck1;
    private CheckBox p303_ck2;
    private CheckBox p303_ck3;
    private CheckBox p303_ck4;
    private CheckBox p303_ck5;
    private CardView p303_card;

    private RadioGroup p304_rg;
    private CardView p304_card;

    private TextInputEditText p305_edt;
    private CardView p305_card;


    private String idEmpresa;
    private Context context;

    public Seccion300Fragment1() {
        // Required empty public constructor
    }

    public Seccion300Fragment1(String idEmpresa, Context context) {
        this.idEmpresa = idEmpresa;
        this.context = context;
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

        p305_edt = (TextInputEditText) view.findViewById(R.id.sec300_p305_edt1);
        p305_card = (CardView) view.findViewById(R.id.p305_card);



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //----pregunta 302

        p302_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.sec300_p302_rbSi:   p302_lyt.setVisibility(View.VISIBLE);
                                                 p303_card.setVisibility(View.VISIBLE);
                                                 p304_card.setVisibility(View.VISIBLE);
                                                 p305_card.setVisibility(View.VISIBLE);break;
                    case R.id.sec300_p302_rbNo:   p302_lyt.setVisibility(View.GONE);
                                                 p303_card.setVisibility(View.GONE);
                                                 p304_card.setVisibility(View.GONE);
                                                 p305_card.setVisibility(View.GONE); break;
                }

            }
        });


        final CheckBox[] checkBox_ck_col1 = {p302_ckM1,p302_ckM2, p302_ckM3,p302_ckM4,p302_ckL1,p302_ckL2, p302_ckL3,p302_ckL4,p302_ckP1,p302_ckP2, p302_ckP3,p302_ckP4,p302_ckP5, p302_ckT1,p302_ckT2,p302_ckT3,p302_ckT4,p302_ckV1,p302_ckV2,p302_ckV3,p302_ckO1};
        final CheckBox[] checkBox_ck_col2 = {p302_ckM5,p302_ckM6,p302_ckM7,p302_ckM8,p302_ckL5,p302_ckL6, p302_ckL7,p302_ckL8,p302_ckP6,p302_ckP7, p302_ckP8,p302_ckP9,p302_ckP10, p302_ckT5,p302_ckT6,p302_ckT7,p302_ckT8,p302_ckV4,p302_ckV5,p302_ckV6,p302_ckO2};
        final EditText[] editText_edt_col3 = {p302_mCant1,p302_mCant2,p302_mCant3,p302_mCant4,p302_lCant1,p302_lCant2,p302_lCant3,p302_lCant4,p302_pCant1,p302_pCant2,p302_pCant3,p302_pCant4,p302_pCant5,p302_tCant1,p302_tCant2,p302_tCant3,p302_tCant4,p302_vCant1,p302_vCant2,p302_vCant3,p302_oCant1};

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
        final CheckBox[] checkBox = {p303_ck1,p303_ck2,p303_ck3,p303_ck4};

        for(int i=0;i<checkBox.length;i++){
            checkBox[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        p304_card.setVisibility(View.GONE);
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




    }

    public void cargardatos(){}
    public void guardarDatos(){}
    public boolean validar(){
        //revisarcampos
        boolean valido = true;
        //llenarMapaVariables();


        return valido;

    }
}
