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
import com.example.administrador.encal.Pojos.Sec100PojoF1;
import com.example.administrador.encal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Seccion100Fragment3 extends Fragment {

    private RadioGroup p111_rg;

    private RadioGroup p112_rg;
    private EditText p112_edt;
    private CardView p112_card;

    private CheckBox p113_ck1;
    private CheckBox p113_ck2;
    private CheckBox p113_ck3;
    private CheckBox p113_ck4;
    private CheckBox p113_ck5;
    private EditText p113_edt;
    private CardView p113_card;


    private CheckBox p114_ck1;
    private CheckBox p114_ck2;
    private CheckBox p114_ck3;
    private CheckBox p114_ck4;
    private CheckBox p114_ck5;
    private CheckBox p114_ck6;
    private CheckBox p114_ck7;
    private EditText p114_edt;
    private CardView p114_card;

    private String idempresa;
    private Sec100PojoF1 sec100PojoF1;
    private Context context;
    private Data data;

    //mapeo de variables
    int P_111;
    int P_112;
    String P_112_O;
    int P_113_1;
    int P_113_2;
    int P_113_3;
    int P_113_4;
    int P_113_5;
    String P_113_5_O;
    int P_114_1;
    int P_114_2;
    int P_114_3;
    int P_114_4;
    int P_114_5;
    int P_114_6;
    int P_114_7;
    String P_114_7_O;
    ;


    public Seccion100Fragment3() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Seccion100Fragment3(String idempresa, Context context) {
        this.idempresa = idempresa;
        this.context = context;
        //data = new Data(context);
        //data.open();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment3_s100, container, false);
        p111_rg = (RadioGroup) view.findViewById(R.id.sec100_p111_rg);

        p112_rg = (RadioGroup) view.findViewById(R.id.sec100_p112_rg);
        p112_edt = (EditText) view.findViewById(R.id.edtEspecifique_p112);
        p112_card = (CardView) view.findViewById(R.id.p112_card);

        p113_ck1 = (CheckBox) view.findViewById(R.id.sec100_p113_ck1);
        p113_ck2 = (CheckBox) view.findViewById(R.id.sec100_p113_ck2);
        p113_ck3 = (CheckBox) view.findViewById(R.id.sec100_p113_ck3);
        p113_ck4 = (CheckBox) view.findViewById(R.id.sec100_p113_ck4);
        p113_ck5 = (CheckBox) view.findViewById(R.id.sec100_p113_ck5);
        p113_edt = (EditText) view.findViewById(R.id.txtEspecifique_p113);
        p113_card = (CardView) view.findViewById(R.id.p113_card);

        p114_ck1 = (CheckBox) view.findViewById(R.id.sec100_p114_ck1);
        p114_ck2 = (CheckBox) view.findViewById(R.id.sec100_p114_ck2);
        p114_ck3 = (CheckBox) view.findViewById(R.id.sec100_p114_ck3);
        p114_ck4 = (CheckBox) view.findViewById(R.id.sec100_p114_ck4);
        p114_ck5 = (CheckBox) view.findViewById(R.id.sec100_p114_ck5);
        p114_ck6 = (CheckBox) view.findViewById(R.id.sec100_p114_ck6);
        p114_ck7 = (CheckBox) view.findViewById(R.id.sec100_p114_ck7);
        p114_edt = (EditText) view.findViewById(R.id.txtEspecifique_p114);
        p114_card = (CardView) view.findViewById(R.id.p114_card);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //----pregunta 111
        p111_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.sec100_p111_rb1:
                        p112_card.setVisibility(View.VISIBLE);
                        p113_card.setVisibility(View.VISIBLE);
                        p114_card.setVisibility(View.GONE);
                        break;
                    case R.id.sec100_p111_rb2:
                        p112_card.setVisibility(View.GONE);
                        p113_card.setVisibility(View.GONE);
                        p114_card.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        //----pregunta 112
        p112_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.sec100_p112_rb1:
                        p112_edt.setVisibility(View.GONE);
                        break;
                    case R.id.sec100_p112_rb2:
                        p112_edt.setVisibility(View.GONE);
                        break;
                    case R.id.sec100_p112_rb3:
                        p112_edt.setVisibility(View.GONE);
                        break;
                    case R.id.sec100_p112_rb4:
                        p112_edt.setVisibility(View.GONE);
                        break;
                    case R.id.sec100_p112_rb5:
                        p112_edt.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        //----pregunta 113
        p113_ck5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    p113_edt.setVisibility(View.VISIBLE);
                } else p113_edt.setVisibility(View.GONE);
            }
        });

        //-----pregunta 114

        p114_ck7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    p114_edt.setVisibility(View.VISIBLE);
                } else p114_edt.setVisibility(View.GONE);
            }
        });
        cargarDatos();

    }

    public void cargarDatos() {
        data = new Data(context);
        data.open();
        //verifico si ya existe un objeto con datos llenados previamente
        if (data.existeModulo1(idempresa)) {
            //si existe traigo el objeto
            sec100PojoF1 = data.getModulo1(idempresa);
            //saco los datos del objeto para llenarlos en los elementos del fragment
            //111
            if (!sec100PojoF1.getP_111().equals("") && !sec100PojoF1.getP_111().equals("-1")) {
                ((RadioButton) p111_rg.getChildAt(Integer.parseInt(sec100PojoF1.getP_111()))).setChecked(true);
            }
            //112
            if (!sec100PojoF1.getP_112().equals("") && !sec100PojoF1.getP_112().equals("-1")) {
                ((RadioButton) p112_rg.getChildAt(Integer.parseInt(sec100PojoF1.getP_112()))).setChecked(true);
            }
            p112_edt.setText(sec100PojoF1.getP_112_O());
            //113
            if (sec100PojoF1.getP_113_1().equals("1")) p113_ck1.setChecked(true);
            if (sec100PojoF1.getP_113_1().equals("0")) p113_ck1.setChecked(false);
            if (sec100PojoF1.getP_113_2().equals("1")) p113_ck2.setChecked(true);
            if (sec100PojoF1.getP_113_2().equals("0")) p113_ck2.setChecked(false);
            if (sec100PojoF1.getP_113_3().equals("1")) p113_ck3.setChecked(true);
            if (sec100PojoF1.getP_113_3().equals("0")) p113_ck3.setChecked(false);
            if (sec100PojoF1.getP_113_4().equals("1")) p113_ck4.setChecked(true);
            if (sec100PojoF1.getP_113_4().equals("0")) p113_ck4.setChecked(false);
            if (sec100PojoF1.getP_113_5().equals("1")) p113_ck5.setChecked(true);
            if (sec100PojoF1.getP_113_5().equals("0")) p113_ck5.setChecked(false);
            p113_edt.setText(sec100PojoF1.getP_113_5_O());
            //114
            if (sec100PojoF1.getP_114_1().equals("1")) p114_ck1.setChecked(true);
            if (sec100PojoF1.getP_114_1().equals("0")) p114_ck1.setChecked(false);
            if (sec100PojoF1.getP_114_2().equals("1")) p114_ck2.setChecked(true);
            if (sec100PojoF1.getP_114_2().equals("0")) p114_ck2.setChecked(false);
            if (sec100PojoF1.getP_114_3().equals("1")) p114_ck3.setChecked(true);
            if (sec100PojoF1.getP_114_3().equals("0")) p114_ck3.setChecked(false);
            if (sec100PojoF1.getP_114_4().equals("1")) p114_ck4.setChecked(true);
            if (sec100PojoF1.getP_114_4().equals("0")) p114_ck4.setChecked(false);
            if (sec100PojoF1.getP_114_5().equals("1")) p114_ck5.setChecked(true);
            if (sec100PojoF1.getP_114_5().equals("0")) p114_ck5.setChecked(false);
            if (sec100PojoF1.getP_114_6().equals("1")) p114_ck6.setChecked(true);
            if (sec100PojoF1.getP_114_6().equals("0")) p114_ck6.setChecked(false);
            if (sec100PojoF1.getP_114_7().equals("1")) p114_ck7.setChecked(true);
            if (sec100PojoF1.getP_114_7().equals("0")) p114_ck7.setChecked(false);
            p114_edt.setText(sec100PojoF1.getP_114_7_O());
        }
        data.close();
    }

    public void llenarMapaVariables() {
        //111
        int childPosP1 = p111_rg.indexOfChild(p111_rg.findViewById(p111_rg.getCheckedRadioButtonId()));
        P_111 = childPosP1;
        //112
        int childPosP2 = p112_rg.indexOfChild(p112_rg.findViewById(p112_rg.getCheckedRadioButtonId()));
        P_112 = childPosP2;

            P_112_O = p112_edt.getText().toString();

        //113
        if (p113_ck1.isChecked()) P_113_1 = 1;
        else P_113_1 = 0;
        if (p113_ck2.isChecked()) P_113_2 = 1;
        else P_113_2 = 0;
        if (p113_ck3.isChecked()) P_113_3 = 1;
        else P_113_3 = 0;
        if (p113_ck4.isChecked()) P_113_4 = 1;
        else P_113_4 = 0;
        if (p113_ck5.isChecked()) P_113_5 = 1;
        else P_113_5 = 0;

            P_113_5_O = p113_edt.getText().toString();

        //114
        if (p114_ck1.isChecked()) P_114_1 = 1;
        else P_114_1 = 0;
        if (p114_ck2.isChecked()) P_114_2 = 1;
        else P_114_2 = 0;
        if (p114_ck3.isChecked()) P_114_3 = 1;
        else P_114_3 = 0;
        if (p114_ck4.isChecked()) P_114_4 = 1;
        else P_114_4 = 0;
        if (p114_ck5.isChecked()) P_114_5 = 1;
        else P_114_5 = 0;
        if (p114_ck6.isChecked()) P_114_6 = 1;
        else P_114_6 = 0;
        if (p114_ck7.isChecked()) P_114_7 = 1;
        else P_114_7 = 0;

            P_114_7_O = p114_edt.getText().toString();


    }

    public void guardarDatos() {
        llenarMapaVariables();
        data = new Data(context);
        data.open();
        if (data.existeModulo1(idempresa)) {
            ContentValues contentValues = new ContentValues(58);
            contentValues.put(SQLConstantes.SECCION100_P_111, P_111 + "");
            contentValues.put(SQLConstantes.SECCION100_P_112, P_112 + "");
            contentValues.put(SQLConstantes.SECCION100_P_112_O, P_112_O);
            contentValues.put(SQLConstantes.SECCION100_P_113_1, P_113_1 + "");
            contentValues.put(SQLConstantes.SECCION100_P_113_2, P_113_2 + "");
            contentValues.put(SQLConstantes.SECCION100_P_113_3, P_113_3 + "");
            contentValues.put(SQLConstantes.SECCION100_P_113_4, P_113_4 + "");
            contentValues.put(SQLConstantes.SECCION100_P_113_5, P_113_5 + "");
            contentValues.put(SQLConstantes.SECCION100_P_113_5_O, P_113_5_O);
            contentValues.put(SQLConstantes.SECCION100_P_114_1, P_114_1 + "");
            contentValues.put(SQLConstantes.SECCION100_P_114_2, P_114_2 + "");
            contentValues.put(SQLConstantes.SECCION100_P_114_3, P_114_3 + "");
            contentValues.put(SQLConstantes.SECCION100_P_114_4, P_114_4 + "");
            contentValues.put(SQLConstantes.SECCION100_P_114_5, P_114_5 + "");
            contentValues.put(SQLConstantes.SECCION100_P_114_6, P_114_6 + "");
            contentValues.put(SQLConstantes.SECCION100_P_114_7, P_114_7 + "");
            contentValues.put(SQLConstantes.SECCION100_P_114_7_O, P_114_7_O);
            data.actualizarModulo1(idempresa, contentValues);
        } else {
            //si no existe el elemento, lo construye para insertarlo
            sec100PojoF1 = new Sec100PojoF1();
            //llena el objeto a insertar
            sec100PojoF1.setID(idempresa);
            sec100PojoF1.setP_111(P_111 + "");
            sec100PojoF1.setP_112(P_112 + "");
            sec100PojoF1.setP_112_O(P_112_O);
            sec100PojoF1.setP_113_1(P_113_1 + "");
            sec100PojoF1.setP_113_2(P_113_2 + "");
            sec100PojoF1.setP_113_3(P_113_3 + "");
            sec100PojoF1.setP_113_4(P_113_4 + "");
            sec100PojoF1.setP_113_5(P_113_5 + "");
            sec100PojoF1.setP_113_5_O(P_113_5_O);
            sec100PojoF1.setP_114_1(P_114_1 + "");
            sec100PojoF1.setP_114_2(P_114_2 + "");
            sec100PojoF1.setP_114_3(P_114_3 + "");
            sec100PojoF1.setP_114_4(P_114_4 + "");
            sec100PojoF1.setP_114_5(P_114_5 + "");
            sec100PojoF1.setP_114_6(P_114_6 + "");
            sec100PojoF1.setP_114_7(P_114_7 + "");
            sec100PojoF1.setP_114_7_O(P_114_7_O);
            data.insertarModulo1(sec100PojoF1);
        }
        data.close();
    }

    public boolean validar() {
        boolean valido = true;
        String mensaje = "";
        llenarMapaVariables();

        boolean v1 = false;
        boolean v2 = true;
        boolean v3 = true;
        boolean v4 = true;
        boolean vt = true;

        //111

        if(P_111 != -1){
            if (P_111==1){
                if (p114_card.getVisibility()==View.VISIBLE){
                    if (P_114_1 != 1 && P_114_2 != 1 && P_114_3 != 1 && P_114_4 != 1 && P_114_5 != 1 && P_114_6 != 1 && P_114_7 != 1) {
                        valido = false;
                        if (mensaje.equals("")) mensaje = "PREGUNTA 114: DEBE SELECCIONAR AL MENOS UNA OPCION";
                    }
                    if (P_114_7==1){
                        if (P_114_7_O.trim().length() < 2) {
                            valido = false;
                            if (mensaje.equals("")) mensaje = "PREGUNTA 114: DEBE REGISTRAR INFORMACION ";
                        }
                    }
                }
            }else{
                if (p112_card.getVisibility()==View.VISIBLE){
                    if(P_112 != -1){
                        if (P_112==4){
                            if (P_112_O.trim().length() < 2) {
                                valido = false;
                                if (mensaje.equals("")) mensaje = "PREGUNTA 112: DEBE REGISTRAR INFORMACION";
                            }
                        }

                    }else if (mensaje.equals("")) mensaje = "PREGUNTA 112: DEBE SELECCIONAR AL MENOS UNA OPCION";
                }
                if (p113_card.getVisibility()==View.VISIBLE){
                    if(P_113_1 != 1 && P_113_2 != 1 && P_113_3 != 1 && P_113_4 != 1 && P_113_5 != 1){
                        valido = false;
                        if (mensaje.equals("")) mensaje = "PREGUNTA 113: DEBE SELECCIONAR AL MENOS UNA OPCION";
                    }
                    if (P_113_5==1){
                        if (P_113_5_O.trim().length() < 2) {
                            valido = false;
                            if (mensaje.equals("")) mensaje = "PREGUNTA 113: DEBE REGISTRAR INFORMACION";
                        }

                    }
                }
            }
        }else {
            valido = false;
            if(mensaje.equals(""))mensaje = "pregunta 111 DEBE selecionar alguna opcion ";
        }

        //valido = v1&&v2&&v3&&v4&&vt;
        if (!valido) {
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