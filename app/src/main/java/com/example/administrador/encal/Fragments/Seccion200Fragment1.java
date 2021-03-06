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
import com.example.administrador.encal.Pojos.Sec200PojoF1;
import com.example.administrador.encal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Seccion200Fragment1 extends Fragment {

    private CheckBox p201_ck1;
    private CheckBox p201_ck2;
    private CheckBox p201_ck3;
    private CheckBox p201_ck4;

    private RadioGroup p202_rg;

    private RadioGroup p203_rg;
    private EditText p203_edt;
    private CardView p203_card;

    private EditText p204_edt;
    private CardView p204_card;

    private CheckBox p205_ck1;
    private CheckBox p205_ck2;
    private CheckBox p205_ck3;
    private CheckBox p205_ck4;
    private CheckBox p205_ck5;
    private CheckBox p205_ck6;
    private EditText p205_edt;
    private CardView p205_card;
    private EditText edtobs2;

    private IdentificacionPojo identificacion;

    private String idempresa;
    private Sec200PojoF1 sec200PojoF1;
    private Context context;
    private Data data;

    //mapeo de variables
    int P_201_1;int P_201_2;int P_201_3;int P_201_4;int P_202;
    int P_203;String P_203_O;String P_204;int P_205_1;int P_205_2;
    int P_205_3;int P_205_4;int P_205_5;int P_205_6;String P_205_6_O; String OBS_SEC200;

    public Seccion200Fragment1() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Seccion200Fragment1(String idempresa, Context context) {
        this.idempresa = idempresa;
        this.context = context;
        data = new Data(context);
        data.open();
        identificacion = data.getIdentificacion(idempresa);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment1_s200, container, false);
        p201_ck1 = (CheckBox) view.findViewById(R.id.sec200_p201_ck1);
        p201_ck2 = (CheckBox) view.findViewById(R.id.sec200_p201_ck2);
        p201_ck3 = (CheckBox) view.findViewById(R.id.sec200_p201_ck3);
        p201_ck4 = (CheckBox) view.findViewById(R.id.sec200_p201_ck4);

        p202_rg =  (RadioGroup) view.findViewById(R.id.sec200_p202_rg);

        p203_rg =  (RadioGroup) view.findViewById(R.id.sec200_p203_rg);
        p203_edt = (EditText) view.findViewById(R.id.edtEspecifique_p203);
        p203_card = (CardView) view.findViewById(R.id.p203_card);

        p204_edt = (EditText) view.findViewById(R.id.sec200_p204_edt1);
        p204_card = (CardView) view.findViewById(R.id.p204_card);


        p205_ck1 = (CheckBox) view.findViewById(R.id.sec200_p205_ck1);
        p205_ck2 = (CheckBox) view.findViewById(R.id.sec200_p205_ck2);
        p205_ck3 = (CheckBox) view.findViewById(R.id.sec200_p205_ck3);
        p205_ck4 = (CheckBox) view.findViewById(R.id.sec200_p205_ck4);
        p205_ck5 = (CheckBox) view.findViewById(R.id.sec200_p205_ck5);
        p205_ck6 = (CheckBox) view.findViewById(R.id.sec200_p205_ck6);
        p205_edt = (EditText) view.findViewById(R.id.txtEspecifique_p205);
        p205_card = (CardView) view.findViewById(R.id.p205_card);

        edtobs2 = (EditText) view.findViewById(R.id.edt_obs);


        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //----pregunta202
        p202_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.sec200_p202_rb1:   p203_card.setVisibility(View.VISIBLE); p204_card.setVisibility(View.VISIBLE);p205_card.setVisibility(View.VISIBLE);break;
                    case R.id.sec200_p202_rb2:   p203_card.setVisibility(View.GONE); p204_card.setVisibility(View.GONE);p205_card.setVisibility(View.GONE); break;
                }
            }
        });

        //----pregunta203
        p203_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.sec200_p203_rb1:   p203_edt.setVisibility(View.GONE); p203_edt.setText("");break;
                    case R.id.sec200_p203_rb2:   p203_edt.setVisibility(View.GONE);p203_edt.setText("");break;
                    case R.id.sec200_p203_rb3:   p203_edt.setVisibility(View.GONE);p203_edt.setText("");break;
                    case R.id.sec200_p203_rb4:   p203_edt.setVisibility(View.VISIBLE);break;
                }
            }
        });

        //----pregunta 205
        p205_ck5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    p205_ck1.setEnabled(false); p205_ck1.setChecked(false);
                    p205_ck2.setEnabled(false); p205_ck2.setChecked(false);
                    p205_ck3.setEnabled(false); p205_ck3.setChecked(false);
                    p205_ck4.setEnabled(false); p205_ck4.setChecked(false);
                    p205_ck6.setEnabled(false); p205_ck6.setChecked(false);
                }
                else {
                    p205_ck1.setEnabled(true);
                    p205_ck2.setEnabled(true);
                    p205_ck3.setEnabled(true);
                    p205_ck4.setEnabled(true);
                    p205_ck6.setEnabled(true);
                }
            }
        });

        p205_ck6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    p205_edt.setVisibility(View.VISIBLE);
                }
                else p205_edt.setVisibility(View.GONE);
            }
        });
        cargarDatos();

    }
    public void cargarDatos(){
        data = new Data(context);
        data.open();
        //verifico si ya existe un objeto con datos llenados previamente
        if(data.existeModulo2(idempresa)){
            //si existe traigo el objeto
            sec200PojoF1 = data.getModulo2(idempresa);
            //saco los datos del objeto para llenarlos en los elementos del fragment
            //datos cabecera
            if(sec200PojoF1.getP_201_1().equals("1")) p201_ck1.setChecked(true);
            if(sec200PojoF1.getP_201_1().equals("0")) p201_ck1.setChecked(false);
            if(sec200PojoF1.getP_201_2().equals("1")) p201_ck2.setChecked(true);
            if(sec200PojoF1.getP_201_2().equals("0")) p201_ck2.setChecked(false);
            if(sec200PojoF1.getP_201_3().equals("1")) p201_ck3.setChecked(true);
            if(sec200PojoF1.getP_201_3().equals("0")) p201_ck3.setChecked(false);
            if(sec200PojoF1.getP_201_4().equals("1")) p201_ck4.setChecked(true);
            if(sec200PojoF1.getP_201_4().equals("0")) p201_ck4.setChecked(false);

            if(!sec200PojoF1.getP_202().equals("") && !sec200PojoF1.getP_202().equals("-1")){
                ((RadioButton)p202_rg.getChildAt(Integer.parseInt(sec200PojoF1.getP_202()))).setChecked(true);
            }
            if(!sec200PojoF1.getP_203().equals("") && !sec200PojoF1.getP_203().equals("-1")){
                ((RadioButton)p203_rg.getChildAt(Integer.parseInt(sec200PojoF1.getP_203()))).setChecked(true);
            }
            p203_edt.setText(sec200PojoF1.getP_203_O());

            p204_edt.setText(sec200PojoF1.getP_204());

            if(sec200PojoF1.getP_205_1().equals("1")) p205_ck1.setChecked(true);
            if(sec200PojoF1.getP_205_1().equals("0")) p205_ck1.setChecked(false);
            if(sec200PojoF1.getP_205_2().equals("1")) p205_ck2.setChecked(true);
            if(sec200PojoF1.getP_205_2().equals("0")) p205_ck2.setChecked(false);
            if(sec200PojoF1.getP_205_3().equals("1")) p205_ck3.setChecked(true);
            if(sec200PojoF1.getP_205_3().equals("0")) p205_ck3.setChecked(false);
            if(sec200PojoF1.getP_205_4().equals("1")) p205_ck4.setChecked(true);
            if(sec200PojoF1.getP_205_4().equals("0")) p205_ck4.setChecked(false);
            if(sec200PojoF1.getP_205_5().equals("1")) p205_ck5.setChecked(true);
            if(sec200PojoF1.getP_205_5().equals("0")) p205_ck5.setChecked(false);
            if(sec200PojoF1.getP_205_6().equals("1")) p205_ck6.setChecked(true);
            if(sec200PojoF1.getP_205_6().equals("0")) p205_ck6.setChecked(false);
            p205_edt.setText(sec200PojoF1.getP_205_6_O());
            edtobs2.setText(sec200PojoF1.getOBS());
        }
        data.close();
    }
    public void llenarMapaVariables(){
        //preguntas cabecera
        if(p201_ck1.isChecked())P_201_1 = 1;
        else P_201_1 = 0;
        if(p201_ck2.isChecked())P_201_2 = 1;
        else P_201_2 = 0;
        if(p201_ck3.isChecked())P_201_3 = 1;
        else P_201_3 = 0;
        if(p201_ck4.isChecked())P_201_4 = 1;
        else P_201_4 = 0;
        int childPosP1 = p202_rg.indexOfChild(p202_rg.findViewById(p202_rg.getCheckedRadioButtonId()));
        P_202 = childPosP1;

        int childPosP2 = p203_rg.indexOfChild(p203_rg.findViewById(p203_rg.getCheckedRadioButtonId()));
        P_203 = childPosP2;

            P_203_O =  p203_edt.getText().toString();



            P_204 =  p204_edt.getText().toString();


        if(p205_ck1.isChecked())P_205_1 = 1;
        else P_205_1 = 0;
        if(p205_ck2.isChecked())P_205_2 = 1;
        else P_205_2 = 0;
        if(p205_ck3.isChecked())P_205_3 = 1;
        else P_205_3 = 0;
        if(p205_ck4.isChecked())P_205_4 = 1;
        else P_205_4 = 0;
        if(p205_ck5.isChecked())P_205_5 = 1;
        else P_205_5 = 0;
        if(p205_ck6.isChecked())P_205_6 = 1;
        else P_205_6 = 0;

        P_205_6_O =  p205_edt.getText().toString();
        OBS_SEC200 = edtobs2.getText().toString();
    }

    public void guardarDatos(){
        llenarMapaVariables();
        data = new Data(context);
        data.open();
        if(data.existeModulo2(idempresa)){
            ContentValues contentValues = new ContentValues(17);
            contentValues.put(SQLConstantes.SECCION200_P_201_1,P_201_1+"");
            contentValues.put(SQLConstantes.SECCION200_P_201_2,P_201_2+"");
            contentValues.put(SQLConstantes.SECCION200_P_201_3,P_201_3+"");
            contentValues.put(SQLConstantes.SECCION200_P_201_4,P_201_4+"");
            contentValues.put(SQLConstantes.SECCION200_P_202,P_202+"");
            contentValues.put(SQLConstantes.SECCION200_P_203,P_203+"");
            contentValues.put(SQLConstantes.SECCION200_P_203_O,P_203_O);
            contentValues.put(SQLConstantes.SECCION200_P_204,P_204);
            contentValues.put(SQLConstantes.SECCION200_P_205_1,P_205_1+"");
            contentValues.put(SQLConstantes.SECCION200_P_205_2,P_205_2+"");
            contentValues.put(SQLConstantes.SECCION200_P_205_3,P_205_3+"");
            contentValues.put(SQLConstantes.SECCION200_P_205_4,P_205_4+"");
            contentValues.put(SQLConstantes.SECCION200_P_205_5,P_205_5+"");
            contentValues.put(SQLConstantes.SECCION200_P_205_6,P_205_6+"");
            contentValues.put(SQLConstantes.SECCION200_P_205_6_O,P_205_6_O);
            contentValues.put(SQLConstantes.SECCION100_OBS,OBS_SEC200);
            data.actualizarModulo2(idempresa,contentValues);
        }else{
            //si no existe el elemento, lo construye para insertarlo
            sec200PojoF1 = new Sec200PojoF1();
            //llena el objeto a insertar
            sec200PojoF1.setID(idempresa);
            sec200PojoF1.setP_201_1(P_201_1+"");
            sec200PojoF1.setP_201_2(P_201_2+"");
            sec200PojoF1.setP_201_3(P_201_3+"");
            sec200PojoF1.setP_201_4(P_201_4+"");
            sec200PojoF1.setP_202(P_202+"");
            sec200PojoF1.setP_203(P_203+"");
            sec200PojoF1.setP_203_O(P_203_O);
            sec200PojoF1.setP_204(P_204);
            sec200PojoF1.setP_205_1(P_205_1+"");
            sec200PojoF1.setP_205_2(P_205_2+"");
            sec200PojoF1.setP_205_3(P_205_3+"");
            sec200PojoF1.setP_205_4(P_205_4+"");
            sec200PojoF1.setP_205_5(P_205_5+"");
            sec200PojoF1.setP_205_6(P_205_6+"");
            sec200PojoF1.setP_205_6_O(P_205_6_O);
            sec200PojoF1.setOBS(OBS_SEC200);
            data.insertarModulo2(sec200PojoF1);
        }
        data.close();
    }

    public boolean validar(){
        boolean valido = true;
        String mensaje = "";
        llenarMapaVariables();

        boolean v1=true;boolean v2=true;boolean v3=true;boolean v4=true;boolean vt=true;

        //201
        if(P_201_1 != 1 && P_201_2 != 1 && P_201_3 != 1 && P_201_4 != 1 ) {
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 201: DEBE SELECCIONAR AL MENOS UNA OPCION";
        }
        //202
        if (P_202!=-1){
            if (P_202==0){
                if(p203_card.getVisibility()==View.VISIBLE){
                    if(P_203 != -1){
                        if (P_203==3){
                            if (P_203_O.trim().length() < 2) {
                                valido = false;
                                if (mensaje.equals("")) mensaje = "PREGUNTA 203: DEBE REGISTRAR INFORMACION";
                            }
                        }

                    }else if (mensaje.equals("")) mensaje = "PREGUNTA 203: DEBE SELECCIONAR AL MENOS UNA OPCION";
                }

                if(p204_card.getVisibility()==View.VISIBLE){
                    if (P_204.trim().length() < 2) {
                        valido = false;
                        if (mensaje.equals("")) mensaje = "PREGUNTA 204: DEBE REGISTRAR INFORMACION";
                    }
                    data = new Data(context);
                    data.open();
                    int ainicio = Integer.parseInt(data.getIdentificacion(idempresa).getANO_INI());
                    data.close();
                    int verificacion =  ainicio;
                    if(!P_204.equals("") && verificacion!=0){
                        if(Integer.parseInt(P_204) < verificacion || Integer.parseInt(P_204)>2017){
                            valido = false;
                            if(mensaje.equals(""))mensaje = "PREGUNTA 204: Año de implementación de la norma técnica o estándar de calidad más importante no debe ser menor al año de inicio de funcionamiento ni mayor a 2017";
                        }
                    }
                }
                if (p205_card.getVisibility()==View.VISIBLE){
                    if(P_205_1 != 1 && P_205_2 != 1 && P_205_3 != 1 && P_205_4 != 1 && P_205_5 != 1 && P_205_6 != 1){
                        valido = false;
                        if (mensaje.equals("")) mensaje = "PREGUNTA 205: DEBE SELECCIONAR AL MENOS UNA OPCION";
                    }
                    if (P_205_6==1){
                        if (P_205_6_O.trim().length() < 2) {
                            valido = false;
                            if (mensaje.equals("")) mensaje = "PREGUNTA 205: DEBE REGISTRAR INFORMACION";
                        }

                    }
                }
            }
        }else {
            valido = false;
            if(mensaje.equals(""))mensaje = "pregunta 202: DEBE selecionar alguna opcion ";
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
