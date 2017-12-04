package com.example.administrador.encal.Fragments;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import com.example.administrador.encal.Pojos.IdentificacionPojo;
import com.example.administrador.encal.Pojos.Sec100PojoF1;
import com.example.administrador.encal.Pojos.Sec200PojoF1;
import com.example.administrador.encal.Pojos.Sec400PojoF1;
import com.example.administrador.encal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Seccion400Fragment1 extends Fragment {
    private CheckBox p401_ck1;
    private CheckBox p401_ck2;
    private CheckBox p401_ck3;
    private CheckBox p401_ck4;
    private CheckBox p401_ck5;

    private RadioGroup p402_rg;
    private CardView p402_card;

    private CheckBox p403_ck1;
    private CheckBox p403_ck2;
    private CheckBox p403_ck3;
    private CheckBox p403_ck4;


    private RadioGroup p404_rg;
    private CardView p404_card;

    private RadioGroup p405_rg;
    private CardView p405_card;

    private EditText p406_edt1;
    private CardView p406_card;

    private CheckBox p407_ck1;
    private CheckBox p407_ck2;
    private CheckBox p407_ck3;
    private CheckBox p407_ck4;
    private CheckBox p407_ck5;
    private CheckBox p407_ck6;
    private CheckBox p407_ck7;
    private EditText p407_edt;
    private CardView p407_card;

    private CheckBox p408_ck1;
    private CheckBox p408_ck2;
    private CheckBox p408_ck3;
    private CheckBox p408_ck4;
    private CheckBox p408_ck5;
    private CheckBox p408_ck6;
    private EditText p408_edt;
    private CardView p408_card;

    private IdentificacionPojo identificacion;
    private Sec100PojoF1 sec100PojoF1;
    private String idempresa;
    private Sec400PojoF1 sec400PojoF1;
    private Context context;
    private Data data;

    //mapeo de variables
    int P_401_1;int P_401_2;int P_401_3;int P_401_4;int P_401_5;
    int P_402;int P_403_1;int P_403_2;int P_403_3;int P_403_4;
    int P_404; int P_405;String P_406;int P_407_1;int P_407_2;int P_407_3;int P_407_4;int P_407_5;
    int P_407_6;int P_407_7;String P_407_7_O;int P_408_1;int P_408_2;int P_408_3;int P_408_4;int P_408_5;
    int P_408_6;String P_408_6_O;


    public Seccion400Fragment1() {
        // Required empty public constructor
    }
    @SuppressLint("ValidFragment")
    public Seccion400Fragment1(String idempresa, Context context) {
        this.idempresa = idempresa;
        this.context = context;
        data = new Data(context);
        data.open();
        identificacion = data.getIdentificacion(idempresa);
        sec100PojoF1 = data.getModulo1(idempresa);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment1_s400, container, false);
        p401_ck1  = (CheckBox) view.findViewById(R.id.sec400_p401_ck1);
        p401_ck2  = (CheckBox) view.findViewById(R.id.sec400_p401_ck2);
        p401_ck3  = (CheckBox) view.findViewById(R.id.sec400_p401_ck3);
        p401_ck4  = (CheckBox) view.findViewById(R.id.sec400_p401_ck4);
        p401_ck5  = (CheckBox) view.findViewById(R.id.sec400_p401_ck5);

        p402_rg = (RadioGroup) view.findViewById(R.id.sec400_p402_rg);
        p402_card = (CardView) view.findViewById(R.id.p402_card);

        p403_ck1  = (CheckBox) view.findViewById(R.id.sec400_p403_ck1);
        p403_ck2  = (CheckBox) view.findViewById(R.id.sec400_p403_ck2);
        p403_ck3  = (CheckBox) view.findViewById(R.id.sec400_p403_ck3);
        p403_ck4  = (CheckBox) view.findViewById(R.id.sec400_p403_ck4);

        p404_rg = (RadioGroup) view.findViewById(R.id.sec400_p404_rg);
        p404_card = (CardView) view.findViewById(R.id.p404_card);

        p405_rg = (RadioGroup) view.findViewById(R.id.sec400_p405_rg);
        p405_card = (CardView) view.findViewById(R.id.p405_card);

        p406_edt1 = (EditText) view.findViewById(R.id.sec400_p406_edt1);
        p406_card = (CardView) view.findViewById(R.id.p406_card);

        p407_ck1  = (CheckBox) view.findViewById(R.id.sec400_p407_ck1);
        p407_ck2  = (CheckBox) view.findViewById(R.id.sec400_p407_ck2);
        p407_ck3  = (CheckBox) view.findViewById(R.id.sec400_p407_ck3);
        p407_ck4  = (CheckBox) view.findViewById(R.id.sec400_p407_ck4);
        p407_ck5  = (CheckBox) view.findViewById(R.id.sec400_p407_ck5);
        p407_ck6  = (CheckBox) view.findViewById(R.id.sec400_p407_ck6);
        p407_ck7  = (CheckBox) view.findViewById(R.id.sec400_p407_ck7);
        p407_edt = (EditText) view.findViewById(R.id.txtEspecifique_p407);
        p407_card = (CardView) view.findViewById(R.id.p407_card);

        p408_ck1  = (CheckBox) view.findViewById(R.id.sec400_p408_ck1);
        p408_ck2  = (CheckBox) view.findViewById(R.id.sec400_p408_ck2);
        p408_ck3  = (CheckBox) view.findViewById(R.id.sec400_p408_ck3);
        p408_ck4  = (CheckBox) view.findViewById(R.id.sec400_p408_ck4);
        p408_ck5  = (CheckBox) view.findViewById(R.id.sec400_p408_ck5);
        p408_ck6  = (CheckBox) view.findViewById(R.id.sec400_p408_ck6);
        p408_edt = (EditText) view.findViewById(R.id.txtEspecifique_p408);
        p408_card = (CardView) view.findViewById(R.id.p408_card);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //----pregunta 401
        final CheckBox[] checkBox = {p401_ck1,p401_ck2,p401_ck3};

        for(int i=0;i<checkBox.length;i++){
            checkBox[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        p402_card.setVisibility(View.GONE);
                    }else{
                        if (checkBox[0].isChecked()||checkBox[1].isChecked()||checkBox[2].isChecked()){
                            p402_card.setVisibility(View.GONE);
                        }else {
                            p402_card.setVisibility(View.VISIBLE);
                        }

                    }
                }
            });
        }



        //----pregunta 403
        p403_ck4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    p404_card.setVisibility(View.GONE);
                    p405_card.setVisibility(View.GONE);
                    p406_card.setVisibility(View.GONE);
                    p407_card.setVisibility(View.GONE);
                }else{
                    p404_card.setVisibility(View.VISIBLE);
                    p405_card.setVisibility(View.VISIBLE);
                    p406_card.setVisibility(View.VISIBLE);
                    p407_card.setVisibility(View.VISIBLE);
                }

            }
        });

        //----pregunta 407
        p407_ck7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    p407_edt.setVisibility(View.VISIBLE);
                }else{
                    p407_edt.setVisibility(View.GONE);
                }

            }
        });

        //----pregunta 408
        p408_ck6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    p408_edt.setVisibility(View.VISIBLE);
                }else{
                    p408_edt.setVisibility(View.GONE);
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
            //datos cabecera
            //401
            if(sec400PojoF1.getP_401_1().equals("1")) p401_ck1.setChecked(true);
            if(sec400PojoF1.getP_401_1().equals("0")) p401_ck1.setChecked(false);
            if(sec400PojoF1.getP_401_2().equals("1")) p401_ck2.setChecked(true);
            if(sec400PojoF1.getP_401_2().equals("0")) p401_ck2.setChecked(false);
            if(sec400PojoF1.getP_401_3().equals("1")) p401_ck3.setChecked(true);
            if(sec400PojoF1.getP_401_3().equals("0")) p401_ck3.setChecked(false);
            if(sec400PojoF1.getP_401_4().equals("1")) p401_ck4.setChecked(true);
            if(sec400PojoF1.getP_401_4().equals("0")) p401_ck4.setChecked(false);
            if(sec400PojoF1.getP_401_5().equals("1")) p401_ck5.setChecked(true);
            if(sec400PojoF1.getP_401_5().equals("0")) p401_ck5.setChecked(false);
            //402
            if(!sec400PojoF1.getP_402().equals("") && !sec400PojoF1.getP_402().equals("-1")){
                ((RadioButton)p402_rg.getChildAt(Integer.parseInt(sec400PojoF1.getP_402()))).setChecked(true);
            }
            //405
            if(sec400PojoF1.getP_403_1().equals("1")) p403_ck1.setChecked(true);
            if(sec400PojoF1.getP_403_1().equals("0")) p403_ck1.setChecked(false);
            if(sec400PojoF1.getP_403_2().equals("1")) p403_ck2.setChecked(true);
            if(sec400PojoF1.getP_403_2().equals("0")) p403_ck2.setChecked(false);
            if(sec400PojoF1.getP_403_3().equals("1")) p403_ck3.setChecked(true);
            if(sec400PojoF1.getP_403_3().equals("0")) p403_ck3.setChecked(false);
            if(sec400PojoF1.getP_403_4().equals("1")) p403_ck4.setChecked(true);
            if(sec400PojoF1.getP_403_4().equals("0")) p403_ck4.setChecked(false);
            //404
            if(!sec400PojoF1.getP_404().equals("") && !sec400PojoF1.getP_404().equals("-1")){
                ((RadioButton)p404_rg.getChildAt(Integer.parseInt(sec400PojoF1.getP_404()))).setChecked(true);
            }
            //405
            if(!sec400PojoF1.getP_405().equals("") && !sec400PojoF1.getP_405().equals("-1")){
                ((RadioButton)p405_rg.getChildAt(Integer.parseInt(sec400PojoF1.getP_405()))).setChecked(true);
            }
            //406
            p406_edt1.setText(sec400PojoF1.getP_406());
            //407
            if(sec400PojoF1.getP_407_1().equals("1")) p407_ck1.setChecked(true);
            if(sec400PojoF1.getP_407_1().equals("0")) p407_ck1.setChecked(false);
            if(sec400PojoF1.getP_407_2().equals("1")) p407_ck2.setChecked(true);
            if(sec400PojoF1.getP_407_2().equals("0")) p407_ck2.setChecked(false);
            if(sec400PojoF1.getP_407_3().equals("1")) p407_ck3.setChecked(true);
            if(sec400PojoF1.getP_407_3().equals("0")) p407_ck3.setChecked(false);
            if(sec400PojoF1.getP_407_4().equals("1")) p407_ck4.setChecked(true);
            if(sec400PojoF1.getP_407_4().equals("0")) p407_ck4.setChecked(false);
            if(sec400PojoF1.getP_407_5().equals("1")) p407_ck5.setChecked(true);
            if(sec400PojoF1.getP_407_5().equals("0")) p407_ck5.setChecked(false);
            if(sec400PojoF1.getP_407_6().equals("1")) p407_ck6.setChecked(true);
            if(sec400PojoF1.getP_407_6().equals("0")) p407_ck6.setChecked(false);
            if(sec400PojoF1.getP_407_7().equals("1")) p407_ck7.setChecked(true);
            if(sec400PojoF1.getP_407_7().equals("0")) p407_ck7.setChecked(false);
            p407_edt.setText(sec400PojoF1.getP_407_7_O());

            if(sec400PojoF1.getP_408_1().equals("1")) p408_ck1.setChecked(true);
            if(sec400PojoF1.getP_408_1().equals("0")) p408_ck1.setChecked(false);
            if(sec400PojoF1.getP_408_2().equals("1")) p408_ck2.setChecked(true);
            if(sec400PojoF1.getP_408_2().equals("0")) p408_ck2.setChecked(false);
            if(sec400PojoF1.getP_408_3().equals("1")) p408_ck3.setChecked(true);
            if(sec400PojoF1.getP_408_3().equals("0")) p408_ck3.setChecked(false);
            if(sec400PojoF1.getP_408_4().equals("1")) p408_ck4.setChecked(true);
            if(sec400PojoF1.getP_408_4().equals("0")) p408_ck4.setChecked(false);
            if(sec400PojoF1.getP_408_5().equals("1")) p408_ck5.setChecked(true);
            if(sec400PojoF1.getP_408_5().equals("0")) p408_ck5.setChecked(false);
            if(sec400PojoF1.getP_408_6().equals("1")) p408_ck6.setChecked(true);
            if(sec400PojoF1.getP_408_6().equals("0")) p408_ck6.setChecked(false);
            p408_edt.setText(sec400PojoF1.getP_408_6_O());
        }
        data.close();
    }
    public void llenarMapaVariables(){
        //401
        if(p401_ck1.isChecked())P_401_1 = 1;
        else P_401_1 = 0;
        if(p401_ck2.isChecked())P_401_2 = 1;
        else P_401_2 = 0;
        if(p401_ck3.isChecked())P_401_3 = 1;
        else P_401_3 = 0;
        if(p401_ck4.isChecked())P_401_4 = 1;
        else P_401_4 = 0;
        if(p401_ck4.isChecked())P_401_5 = 1;
        else P_401_5 = 0;
        //402
        int childPosP1 = p402_rg.indexOfChild(p402_rg.findViewById(p402_rg.getCheckedRadioButtonId()));
        P_402 = childPosP1;
        //403
        if(p403_ck1.isChecked())P_403_1 = 1;
        else P_403_1 = 0;
        if(p403_ck2.isChecked())P_403_2 = 1;
        else P_403_2 = 0;
        if(p403_ck3.isChecked())P_403_3 = 1;
        else P_403_3 = 0;
        if(p403_ck4.isChecked())P_403_4 = 1;
        else P_403_4 = 0;
        //404
        int childPosP2 = p404_rg.indexOfChild(p404_rg.findViewById(p404_rg.getCheckedRadioButtonId()));
        P_404 = childPosP2;
        //405
        int childPosP3 = p405_rg.indexOfChild(p405_rg.findViewById(p405_rg.getCheckedRadioButtonId()));
        P_405 = childPosP3;
        //406

            P_406=  p406_edt1.getText().toString();

        //407
        if(p407_ck1.isChecked())P_407_1 = 1;
        else P_407_1 = 0;
        if(p407_ck2.isChecked())P_407_2 = 1;
        else P_407_2 = 0;
        if(p407_ck3.isChecked())P_407_3 = 1;
        else P_407_3 = 0;
        if(p407_ck4.isChecked())P_407_4 = 1;
        else P_407_4 = 0;
        if(p407_ck5.isChecked())P_407_5 = 1;
        else P_407_5 = 0;
        if(p407_ck6.isChecked())P_407_6 = 1;
        else P_407_6 = 0;
        if(p407_ck7.isChecked())P_407_7 = 1;
        else P_407_7 = 0;

            P_407_7_O =  p407_edt.getText().toString();

        //408
        if(p408_ck1.isChecked())P_408_1 = 1;
        else P_408_1 = 0;
        if(p408_ck2.isChecked())P_408_2 = 1;
        else P_408_2 = 0;
        if(p408_ck3.isChecked())P_408_3 = 1;
        else P_408_3 = 0;
        if(p408_ck4.isChecked())P_408_4 = 1;
        else P_408_4 = 0;
        if(p408_ck5.isChecked())P_408_5 = 1;
        else P_408_5 = 0;
        if(p408_ck6.isChecked())P_408_6 = 1;
        else P_408_6 = 0;

            P_408_6_O =  p408_edt.getText().toString();

    }

    public void guardarDatos(){
        llenarMapaVariables();
        data = new Data(context);
        data.open();
        if(data.existeModulo4(idempresa)){
            ContentValues contentValues = new ContentValues(38);
            contentValues.put(SQLConstantes.SECCION400_P_401_1,P_401_1+"");
            contentValues.put(SQLConstantes.SECCION400_P_401_2,P_401_2+"");
            contentValues.put(SQLConstantes.SECCION400_P_401_3,P_401_3+"");
            contentValues.put(SQLConstantes.SECCION400_P_401_4,P_401_4+"");
            contentValues.put(SQLConstantes.SECCION400_P_401_5,P_401_5+"");
            contentValues.put(SQLConstantes.SECCION400_P_402,P_402+"");
            contentValues.put(SQLConstantes.SECCION400_P_403_1,P_403_1+"");
            contentValues.put(SQLConstantes.SECCION400_P_403_2,P_403_2+"");
            contentValues.put(SQLConstantes.SECCION400_P_403_3,P_403_3+"");
            contentValues.put(SQLConstantes.SECCION400_P_403_4,P_403_4+"");
            contentValues.put(SQLConstantes.SECCION400_P_404,P_404+"");
            contentValues.put(SQLConstantes.SECCION400_P_405,P_405+"");
            contentValues.put(SQLConstantes.SECCION400_P_406,P_406);
            contentValues.put(SQLConstantes.SECCION400_P_407_1,P_407_1+"");
            contentValues.put(SQLConstantes.SECCION400_P_407_2,P_407_2+"");
            contentValues.put(SQLConstantes.SECCION400_P_407_3,P_407_3+"");
            contentValues.put(SQLConstantes.SECCION400_P_407_4,P_407_4+"");
            contentValues.put(SQLConstantes.SECCION400_P_407_5,P_407_5+"");
            contentValues.put(SQLConstantes.SECCION400_P_407_6,P_407_6+"");
            contentValues.put(SQLConstantes.SECCION400_P_407_7,P_407_7+"");
            contentValues.put(SQLConstantes.SECCION400_P_407_7_O,P_407_7_O);
            contentValues.put(SQLConstantes.SECCION400_P_408_1,P_408_1+"");
            contentValues.put(SQLConstantes.SECCION400_P_408_2,P_408_2+"");
            contentValues.put(SQLConstantes.SECCION400_P_408_3,P_408_3+"");
            contentValues.put(SQLConstantes.SECCION400_P_408_4,P_408_4+"");
            contentValues.put(SQLConstantes.SECCION400_P_408_5,P_408_5+"");
            contentValues.put(SQLConstantes.SECCION400_P_408_6,P_408_6+"");
            contentValues.put(SQLConstantes.SECCION400_P_408_6_O,P_408_6_O);
            data.actualizarModulo4(idempresa,contentValues);
        }else{
            //si no existe el elemento, lo construye para insertarlo
            sec400PojoF1 = new Sec400PojoF1();
            //llena el objeto a insertar
            sec400PojoF1.setID(idempresa);
            sec400PojoF1.setP_401_1(P_401_1+"");
            sec400PojoF1.setP_401_2(P_401_2+"");
            sec400PojoF1.setP_401_3(P_401_3+"");
            sec400PojoF1.setP_401_4(P_401_4+"");
            sec400PojoF1.setP_401_5(P_401_5+"");
            sec400PojoF1.setP_402(P_402+"");
            sec400PojoF1.setP_403_1(P_403_1+"");
            sec400PojoF1.setP_403_2(P_403_2+"");
            sec400PojoF1.setP_403_3(P_403_3+"");
            sec400PojoF1.setP_403_4(P_403_4+"");
            sec400PojoF1.setP_404(P_404+"");
            sec400PojoF1.setP_405(P_405+"");
            sec400PojoF1.setP_406(P_406);
            sec400PojoF1.setP_407_1(P_407_1+"");
            sec400PojoF1.setP_407_2(P_407_2+"");
            sec400PojoF1.setP_407_3(P_407_3+"");
            sec400PojoF1.setP_407_4(P_407_4+"");
            sec400PojoF1.setP_407_5(P_407_5+"");
            sec400PojoF1.setP_407_6(P_407_6+"");
            sec400PojoF1.setP_407_7(P_407_7+"");
            sec400PojoF1.setP_407_7_O(P_407_7_O+"");
            sec400PojoF1.setP_408_1(P_408_1+"");
            sec400PojoF1.setP_408_2(P_408_2+"");
            sec400PojoF1.setP_408_3(P_408_3+"");
            sec400PojoF1.setP_408_4(P_408_4+"");
            sec400PojoF1.setP_408_5(P_408_5+"");
            sec400PojoF1.setP_408_6(P_408_6+"");
            sec400PojoF1.setP_408_6_O(P_408_6_O+"");
            data.insertarModulo4(sec400PojoF1);
        }
        data.close();
    }

    public boolean validar(){
        boolean valido = true;
        String mensaje = "";
        llenarMapaVariables();

        boolean v1=true;boolean v2=true;boolean v3=true;boolean v4=true;boolean vt=true;

        //401
        if(P_401_1 != 1 && P_401_2 != 1 && P_401_3 != 1 && P_401_4 != 1 && P_401_5 != 1) {
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 401: DEBE SELECCIONAR AL MENOS UNA OPCION";
        }
        if(P_401_1 == 1 && (P_401_2 == 1 || P_401_3 == 1 || P_401_4 == 1 || P_401_5 == 1)) {
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 401: Usted indica que no se verifica porque ya está establecido";
        }
        if( P_401_3 == 1 && (P_401_4 == 1 || P_401_5 == 1)) {
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 401: Debe especificar si la empresa o laboratorio está acreditada o no acreditada";
        }
        if(P_401_1 == 0 && P_401_2 == 0 && P_401_3==0 ) {
            if(p402_card.getVisibility()==View.VISIBLE){
                if(P_402 == -1){
                    valido = false;
                    if (mensaje.equals("")) mensaje = "PREGUNTA 402: DEBE SELECCIONAR AL MENOS UNA OPCION";
                }
            }
        }

        //403
        if(P_403_1 != 1 && P_403_2 != 1 && P_403_3 != 1 && P_403_4 != 1) {
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 403: DEBE SELECCIONAR AL MENOS UNA OPCION";
        }else{
            if (P_403_4!=1){
                //404
                if (P_404==-1){
                    valido = false;
                    if(mensaje.equals(""))mensaje = "PREGUNTA 404: DEBE SELECCIONAR AL MENOS UNA OPCION";
                }
                //405
                if (P_405==-1){
                    valido = false;
                    if(mensaje.equals(""))mensaje = "PREGUNTA 405: DEBE SELECCIONAR AL MENOS UNA OPCION";
                }
                //406
                if(p406_card.getVisibility()==View.VISIBLE){
                    if (P_406.trim().length() < 2) {
                        valido = false;
                        if (mensaje.equals("")) mensaje = "PREGUNTA 406: DEBE REGISTRAR INFORMACION";
                    }
                    data = new Data(context);
                    data.open();
                    int ainicio = Integer.parseInt(data.getIdentificacion(idempresa).getANO_INI());
                    data.close();
                    int verificacion =  ainicio;
                    if(!P_406.equals("") && verificacion!=0){
                        if(Integer.parseInt(P_406) < verificacion || Integer.parseInt(P_406)>2017){
                            valido = false;
                            if(mensaje.equals(""))mensaje = "PREGUNTA 406: Año de obtención de la certificación no debe ser menor al año de inicio de funcionamiento ni mayor a 2017";
                        }
                    }
                }
                //407
                if(p407_card.getVisibility()==View.VISIBLE){
                    if(P_407_1 != 1 && P_407_2 != 1 && P_407_3 != 1 && P_407_4 != 1 && P_407_5 != 1 && P_407_6 != 1 && P_407_7 != 1) {
                        valido = false;
                        if(mensaje.equals(""))mensaje = "PREGUNTA 407: DEBE SELECCIONAR AL MENOS UNA OPCION";
                    }
                    data = new Data(context);
                    data.open();
                    int minternacional = Integer.parseInt(data.getModulo1(idempresa).getP_107_3());
                    data.close();
                    int verificacion =  minternacional;
                    if(P_407_1==1 && verificacion==1){
                        valido = false;
                        if(mensaje.equals(""))mensaje = "PREGUNTA 407: Usted indicó que no comercializa en el mercado internacional";

                    }
                    if (P_407_7==1){
                        if (P_407_7_O.trim().length() < 2) {
                            valido = false;
                            if (mensaje.equals("")) mensaje = "PREGUNTA 407: DEBE REGISTRAR INFORMACION";
                        }
                    }
                }
            }
        }
        //408
        if(P_408_1 != 1 && P_408_2 != 1 && P_408_3 != 1 && P_408_4 != 1 && P_408_5 != 1 && P_408_6 != 1 ) {
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 408: DEBE SELECCIONAR AL MENOS UNA OPCION";
        }
        if (P_408_6==1){
            if (P_408_6_O.trim().length() < 2) {
                valido = false;
                if (mensaje.equals("")) mensaje = "PREGUNTA 408: DEBE REGISTRAR INFORMACION";
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
