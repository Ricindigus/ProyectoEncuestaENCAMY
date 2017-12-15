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
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Modelo.SQLConstantes;
import com.example.administrador.encal.Pojos.IdentificacionPojo;
import com.example.administrador.encal.Pojos.Sec100PojoF1;
import com.example.administrador.encal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Seccion100Fragment1 extends Fragment {
    private TextView p101_txt1;
    private AutoCompleteTextView p101_act1;
    private EditText p101_edt1;
    private LinearLayout lytP101;
    private CardView lyt102;
    private CardView lyt103;
    private CardView lyt104;
    private CardView lyt105;

    boolean finalizarEncuesta = false;


    private TextView p102_txt1;
    private TextView p102_txt2;
    private TextView p102_txt3;
    private TextView p102_txt4;
    private AutoCompleteTextView p102_act1;
    private AutoCompleteTextView p102_act2;
    private AutoCompleteTextView p102_act3;
    private AutoCompleteTextView p102_act4;
    private LinearLayout lytP102_1;
    private LinearLayout lytP102_2;
    private LinearLayout lytP102_3;
    private LinearLayout lytP102_4;



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

    private IdentificacionPojo identificacion;

    private String idempresa;
    private Sec100PojoF1 sec100;
    private Context context;
    private Data data;

    String P_101;String P_101_1;String P_101_1_O;String P_102A;String P_102_1;
    String P_102B;String P_102_2;String P_102C;String P_102_3;String P_102D;String P_102_4;
    int P_103;String P_103_O;
    int P_104;String P_105;


    public Seccion100Fragment1() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Seccion100Fragment1(String idempresa, Context context) {
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
        View view = inflater.inflate(R.layout.fragment1_s100, container, false);
        p101_txt1 = (TextView) view.findViewById(R.id.sec100_p101_txt1);
        p101_act1 = (AutoCompleteTextView) view.findViewById(R.id.sec100_p101_atc1);
        p101_edt1 = (EditText) view.findViewById(R.id.sec100_p101_edt1);
        lytP101 = (LinearLayout) view.findViewById(R.id.lytp101);
        lyt102 = (CardView) view.findViewById(R.id.layout_102);
        lyt103 = (CardView) view.findViewById(R.id.layout_103);
        lyt104 = (CardView) view.findViewById(R.id.layout_104);
        lyt105 = (CardView) view.findViewById(R.id.layout_105);

        p102_txt1 = (TextView) view.findViewById(R.id.sec100_p102_txt1);
        p102_txt2 = (TextView) view.findViewById(R.id.sec100_p102_txt2);
        p102_txt3 = (TextView) view.findViewById(R.id.sec100_p102_txt3);
        p102_txt4 = (TextView) view.findViewById(R.id.sec100_p102_txt4);
        p102_act1 = (AutoCompleteTextView) view.findViewById(R.id.sec100_p102_act1);
        p102_act2 = (AutoCompleteTextView) view.findViewById(R.id.sec100_p102_act2);
        p102_act3 = (AutoCompleteTextView) view.findViewById(R.id.sec100_p102_act3);
        p102_act4 = (AutoCompleteTextView) view.findViewById(R.id.sec100_p102_act4);
        lytP102_1 = (LinearLayout) view.findViewById(R.id.lytp102_1);
        lytP102_2 = (LinearLayout) view.findViewById(R.id.lytp102_2);
        lytP102_3 = (LinearLayout) view.findViewById(R.id.lytp102_3);
        lytP102_4 = (LinearLayout) view.findViewById(R.id.lytp102_4);

        p103_rg1 = (RadioGroup) view.findViewById(R.id.sec100_p103_rg);
        p103_edt1 = (EditText) view.findViewById(R.id.edtEspecifique_p103);
        p104_rg1 = (RadioGroup) view.findViewById(R.id.sec100_p104_rg);
        p105_edt1 = (EditText) view.findViewById(R.id.sec100_p105_edt1);



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //-----pregunta1
        String[] paises = getResources().getStringArray(R.array.ciuu);
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(),R.layout.lista_item,R.id.item,paises);
        p101_act1.setAdapter(adapter);
        p102_act1.setAdapter(adapter);
        p102_act2.setAdapter(adapter);
        p102_act3.setAdapter(adapter);
        p102_act4.setAdapter(adapter);

        p101_act1.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        p102_act1.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        p102_act2.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        p102_act3.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        p102_act4.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        AutoCompleteTextView[] autoCompleteTextViews = {p101_act1,p102_act1,p102_act2,p102_act3,p102_act4};
        TextView[] textViews = {p101_txt1,p102_txt1,p102_txt2,p102_txt3,p102_txt4};
        LinearLayout[] linearLayouts = {lytP101,lytP102_1,lytP102_2,lytP102_3,lytP102_4};

        for (int i = 0; i <autoCompleteTextViews.length ; i++) {
            final AutoCompleteTextView autoCompleteTextView = autoCompleteTextViews[i];
            final TextView textView = textViews[i];
            final LinearLayout linearLayout = linearLayouts[i];

            autoCompleteTextView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                    if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        ocultarTeclado(autoCompleteTextView);
                        linearLayout.requestFocus();
                        return true;
                    }
                    return false;
                }
            });
            autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    textView.setText(extraerCodigo(autoCompleteTextView.getText().toString()));
                    ocultarTeclado(autoCompleteTextView);
//                    if(textView.getText().equals("9999")){
//                        p101_edt1.setVisibility(View.VISIBLE);
//                    }else{
//                        p101_edt1.setVisibility(View.GONE);
//                    }
                    linearLayout.requestFocus();
                }
            });
        }

        watcherCIUU(p101_txt1,p101_act1);
        watcherCIUU(p102_txt1,p102_act1);
        watcherCIUU(p102_txt2,p102_act2);
        watcherCIUU(p102_txt3,p102_act3);
        watcherCIUU(p102_txt4,p102_act4);

        p101_txt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().equals("0000")){
                    p102_act1.setText("");
                    p102_act2.setText("");
                    p102_act3.setText("");
                    p102_act4.setText("");
                    p103_rg1.clearCheck();
                    p104_rg1.clearCheck();
                    p105_edt1.setText("");
                    lyt102.setVisibility(View.GONE);
                    lyt103.setVisibility(View.GONE);
                    lyt104.setVisibility(View.GONE);
                    lyt105.setVisibility(View.GONE);
                }else{
                    lyt102.setVisibility(View.VISIBLE);
                    lyt103.setVisibility(View.VISIBLE);
                    lyt104.setVisibility(View.VISIBLE);
                    lyt105.setVisibility(View.VISIBLE);
                }
            }
        });

        //-----Pregunta2

//
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
    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public String extraerCodigo(String ocupacion){
        int indiceI = ocupacion.indexOf("[");
        int indiceF = ocupacion.indexOf("]");
        ocupacion = ocupacion.substring(indiceI + 1, indiceF);

        return ocupacion;
    }

    public void watcherCIUU(final TextView textView, final AutoCompleteTextView autoCompleteTextView){
        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals("")){
                    textView.setText("");
                }

            }
        });

    }

    ///////////////GUARDADO///////////////////////

    public void cargarDatos(){
        data = new Data(context);
        data.open();
        //verifico si ya existe un objeto con datos llenados previamente
        if(data.existeModulo1(idempresa)){
            //si existe traigo el objeto
            sec100 = data.getModulo1(idempresa);
            //saco los datos del objeto para llenarlos en los elementos del fragment
            //PREGUNTA 101
            p101_act1.setText(sec100.getP_101());
            p101_txt1.setText(sec100.getP_101_1());
            p101_edt1.setText(sec100.getP_101_1_O());

            p102_txt1.setText(sec100.getP_102_1());
            p102_txt2.setText(sec100.getP_102_2());
            p102_txt3.setText(sec100.getP_102_3());
            p102_txt4.setText(sec100.getP_102_4());

            p102_act1.setText(sec100.getP_102A());
            p102_act2.setText(sec100.getP_102B());
            p102_act3.setText(sec100.getP_102C());
            p102_act4.setText(sec100.getP_102D());

            //PREGUNTA 103
            if(!sec100.getP_103().equals("") && !sec100.getP_103().equals("-1")){
                ((RadioButton)p103_rg1.getChildAt(Integer.parseInt(sec100.getP_103()))).setChecked(true);
            }
            p103_edt1.setText(sec100.getP_103_O());
            //PREGUNTA 104
            if(!sec100.getP_104().equals("") && !sec100.getP_104().equals("-1")){
                ((RadioButton)p104_rg1.getChildAt(Integer.parseInt(sec100.getP_104()))).setChecked(true);
            }
            //PREGUNTA 105
            p105_edt1.setText(sec100.getP_105());

        }
        data.close();
    }
    public void llenarMapaVariables(){

        //PREGUNTA 101
        P_101 = p101_act1.getText().toString();
        P_101_1 = p101_txt1.getText().toString();
        P_101_1_O = p101_edt1.getText().toString();
        //P101_3 = "";


        //PREGUNTA 102-1
        P_102A = p102_act1.getText().toString();
        P_102_1 = p102_txt1.getText().toString();

        //PREGUNTA 102_2
        P_102B = p102_act2.getText().toString();
        P_102_2 = p102_txt2.getText().toString();

        //PREGUNTA 102_3
        P_102C = p102_act3.getText().toString();
        P_102_3 = p102_txt3.getText().toString();

        //PREGUNTA 102_4
        P_102D = p102_act4.getText().toString();
        P_102_4 = p102_txt4.getText().toString();

        //PREGUNTA 103
        int childPosP103 = p103_rg1.indexOfChild(p103_rg1.findViewById(p103_rg1.getCheckedRadioButtonId()));
        P_103 = childPosP103;
        P_103_O = p103_edt1.getText().toString();
        //PREGUNTA 104
        int childPosP104 = p104_rg1.indexOfChild(p104_rg1.findViewById(p104_rg1.getCheckedRadioButtonId()));
        P_104 = childPosP104;
        //PREGUNTA 105
        P_105 = p105_edt1.getText().toString();
    }
    public void guardarDatos(){
        llenarMapaVariables();
        data = new Data(context);
        data.open();
        if(data.existeModulo1(idempresa)){
            ContentValues contentValues = new ContentValues(58);
            contentValues.put(SQLConstantes.SECCION100_P_101,P_101);
            contentValues.put(SQLConstantes.SECCION100_P_101_1,P_101_1);
            contentValues.put(SQLConstantes.SECCION100_P_101_1_O,P_101_1_O);
            contentValues.put(SQLConstantes.SECCION100_P_102A,P_102A);
            contentValues.put(SQLConstantes.SECCION100_P_102_1,P_102_1);
            contentValues.put(SQLConstantes.SECCION100_P_102B,P_102B);
            contentValues.put(SQLConstantes.SECCION100_P_102_2,P_102_2);
            contentValues.put(SQLConstantes.SECCION100_P_102C,P_102C);
            contentValues.put(SQLConstantes.SECCION100_P_102_3,P_102_3);
            contentValues.put(SQLConstantes.SECCION100_P_102D,P_102D);
            contentValues.put(SQLConstantes.SECCION100_P_102_4,P_102_4);
            contentValues.put(SQLConstantes.SECCION100_P_103,P_103+"");
            contentValues.put(SQLConstantes.SECCION100_P_103_O,P_103_O);
            contentValues.put(SQLConstantes.SECCION100_P_104,P_104+"");
            contentValues.put(SQLConstantes.SECCION100_P_105,P_105);
            data.actualizarModulo1(idempresa,contentValues);
        }else{
            //si no existe el elemento, lo construye para insertarlo
            sec100 = new Sec100PojoF1();
            //llena el objeto a insertar
            sec100.setID(idempresa);
            sec100.setP_101(P_101);
            sec100.setP_101_1(P_101_1);
            sec100.setP_101_1_O(P_101_1_O);
            sec100.setP_102_1(P_102A);
            sec100.setP_102_2(P_102_1);
            sec100.setP_102_3(P_102B);
            sec100.setP_102_4(P_102_2);
            sec100.setP_102A(P_102C);
            sec100.setP_102B(P_102_3);
            sec100.setP_102C(P_102D);
            sec100.setP_102D(P_102_4);
            sec100.setP_103(P_103+"");
            sec100.setP_103_O(P_103_O);
            sec100.setP_104(P_104+"");
            sec100.setP_105(P_105);
            data.insertarModulo1(sec100);
        }
        data.close();
    }
    public boolean validar(){
        boolean valido = true;
        String mensaje = "";
        llenarMapaVariables();

        //101
        if (P_101_1.equals("9999")) {
            if(P_101_1_O.trim().length() < 2){
                valido = false;
                if(mensaje.equals(""))mensaje = "DEBE ESPECIFICAR DICHA ACTIVIDAD MANUFACTURADA";
            }
        }
//falta
//        if (P_101_1.equals("0000")&& RESFIN!=7) {
//            if(mensaje.equals(""))mensaje = "DEBE INDICAR COMO RESULTADO FINAL ACTIVIDAD NO INVESTIGADA";
//        }
        //103
        data = new Data(context);
        data.open();
        String ruc = data.getIdentificacion(idempresa).getNUM_RUC();
        data.close();
        String verificacion =  ruc.substring(0,2);
        if(P_103!=-1 && !verificacion.equals("")){
            if(P_103==0 && verificacion.equals("20")){
                valido = false;
                if(mensaje.equals(""))mensaje = "PREGUNTA 103: Número de RUC no guarda relación con la constitución legal de la empresa";
            }
            if(P_103>0 && P_103<7 && verificacion.equals("10")){
                valido = false;
                if(mensaje.equals(""))mensaje = "PREGUNTA 103: Número de RUC no guarda relación con la constitución legal de la empresa";
            }
            if (P_103==5){
                if(P_103_O.trim().length() < 2){
                    valido = false;
                    if(mensaje.equals(""))mensaje = "PREGUNTA 103: DEBE EXISTIR INFORMACION";
                }
            }
        }else if(mensaje.equals(""))mensaje = "PREGUNTA 103: DEBE SELECCIONAR AL MENOS UNA OPCION";

        //104
        if(P_104== -1 ) {
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 104: DEBE SELECCIONAR AL MENOS UNA OPCION";
        }

        //105
        if(P_105.trim().length() < 1){
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 105: DEBE EXISTIR INFORMACION";
        }
        if(P_105.equals("0")){
            valido = false;
            if(mensaje.equals(""))mensaje = "PREGUNTA 105: EL NUMERO DE TRABAJADORES NO PUEDE SER CERO, DEBE EXISTIR POR LO MENOS UN TRABAJADOR";
        }
        if(p101_txt1.getText().toString().equals("0000")){
            valido = true;
            finalizarEncuesta = true;
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

    public boolean validarFinalizar(){
        return finalizarEncuesta;
    }

}