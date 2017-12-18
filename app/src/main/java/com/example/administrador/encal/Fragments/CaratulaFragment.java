package com.example.administrador.encal.Fragments;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Modelo.SQLConstantes;
import com.example.administrador.encal.NumericKeyBoardTransformationMethod;
import com.example.administrador.encal.Pojos.CaratulaPojo;
import com.example.administrador.encal.Pojos.Marco;
import com.example.administrador.encal.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CaratulaFragment extends Fragment {

    private LinearLayout lytCaratula;
    private LinearLayout lytUbicacion;
    private LinearLayout lytDireccion;


    private Spinner spDepartamento;
    private Spinner spProvincia;
    private Spinner spDistrito;

    private EditText txtLatitud;
    private EditText txtLongitud;

    private EditText edtSector;
    private EditText edtArea;
    private EditText edtZona;
    private EditText edtManzana;
    private EditText edtFrente;
    private EditText edtNombreVia;
    private EditText edtNPuerta;
    private EditText edtInterior;
    private EditText edtBlock;
    private EditText edtPiso;
    private EditText edtManzanaVia;
    private EditText edtLote;
    private EditText edtKm;
    private EditText edtReferencia;
    private EditText edtEspecifiqueVia;

    private Button btnGPS;
    LocationManager locationManager;

    double longitudeGPS, latitudeGPS, altitudGPS;


    private Spinner spTipoVia;
    private String idCaratula;
    private CaratulaPojo caratula;
    private Context context;
    private Data data;
    private int[] arreglosDepartamentos  = {
            R.array.D_AMAZONAS, R.array.D_ANCASH, R.array.D_APURIMAC, R.array.D_AREQUIPA,
            R.array.D_AYACUCHO, R.array.D_CAJAMARCA, R.array.D_CALLAO, R.array.D_CUSCO,
            R.array.D_HUANCAVELICA, R.array.D_HUANUCO, R.array.D_ICA, R.array.D_JUNIN,
            R.array.D_LA_LIBERTAD, R.array.D_LAMBAYEQUE, R.array.D_LIMA, R.array.D_LORETO,
            R.array.D_MADRE_DE_DIOS, R.array.D_MOQUEGUA, R.array.D_PASCO, R.array.D_PIURA,
            R.array.D_PUNO, R.array.D_SAN_MARTIN, R.array.D_TACNA, R.array.D_TUMBES, R.array.D_UCAYALI
    };

    //mapa de variables
    private String ID;
    private String NOMBREDD;
    private String CCDD;
    private String NOMBREPV;
    private String CCPP;
    private String NOMBREDI;
    private String CCDI;
    private String GPSLATITUD;
    private String GPSLONGITUD;
    private String SECTOR_TR;
    private String AREA_TR;
    private String ZONA;
    private String MANZANA_ID;
    private String FRENTE;
    private int TIPVIA;
    private String TIPVIA_ESPEC;
    private String TIPVIA_D;
    private String NROPTA;
    private String BLOCK;
    private String INTERIOR;
    private String PISO;
    private String MZA;
    private String LOTE;
    private String KM;
    private String REF_DIREC;

    public CaratulaFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public CaratulaFragment(String idCaratula, Context context) {
        this.idCaratula = idCaratula;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_caratula, container, false);
        lytCaratula = rootView.findViewById(R.id.layout_caratulaFragment);
        lytDireccion = rootView.findViewById(R.id.caratula_lytDireccion);
        lytUbicacion = rootView.findViewById(R.id.caratula_lytUbicacion);

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        spDepartamento = (Spinner) rootView.findViewById(R.id.caratula_spDepartamento);
        spProvincia = (Spinner) rootView.findViewById(R.id.caratula_spProvincia);
        spDistrito = (Spinner) rootView.findViewById(R.id.caratula_spDistrito);
        txtLatitud = (EditText) rootView.findViewById(R.id.caratula_txtLatitud);
        txtLongitud = (EditText) rootView.findViewById(R.id.caratula_txtLongitud);
        edtSector = (EditText) rootView.findViewById(R.id.caratula_edtSector);
        edtArea = (EditText) rootView.findViewById(R.id.caratula_edtArea);
        edtZona = (EditText) rootView.findViewById(R.id.caratula_edtZona);
        edtManzana = (EditText) rootView.findViewById(R.id.caratula_edtManzana);
        edtFrente = (EditText) rootView.findViewById(R.id.caratula_edtFrente);
        edtNombreVia = (EditText) rootView.findViewById(R.id.caratula_edtNombreVia);
        edtNPuerta = (EditText) rootView.findViewById(R.id.caratula_edtNPuerta);
        edtInterior = (EditText) rootView.findViewById(R.id.caratula_edtInterior);
        edtBlock = (EditText) rootView.findViewById(R.id.caratula_edtBlock);
        edtPiso = (EditText) rootView.findViewById(R.id.caratula_edtPiso);
        edtManzanaVia = (EditText) rootView.findViewById(R.id.caratula_edtManzanaVia);
        edtLote = (EditText) rootView.findViewById(R.id.caratula_edtLote);
        edtKm = (EditText) rootView.findViewById(R.id.caratula_edtKm);
        edtReferencia = (EditText) rootView.findViewById(R.id.caratula_edtReferencia);
        spTipoVia = (Spinner) rootView.findViewById(R.id.caratula_spTipoVia);
        edtEspecifiqueVia = (EditText) rootView.findViewById(R.id.caratula_edt_especifique);
        btnGPS = (Button) rootView.findViewById(R.id.caratula_btnGPS);
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lytCaratula.requestFocus();

        spDepartamento.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    spDepartamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, final int pos, long l) {
                            if(pos != 0){
                                final String[] provincias = context.getResources().getStringArray(arreglosDepartamentos[pos-1]);
                                cargarSpinerProvincias(provincias);
                            }
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {}
                    });

                    spProvincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, final int pos, long l) {
                            data = new Data(context);
                            data.open();
                            String idUbi = checkDigito(spDepartamento.getSelectedItemPosition()) + checkDigito(pos);
                            final ArrayList<String> ubis = data.getUbigeos(idUbi);
                            data.close();
                            cargarSpinerDistritos(ubis);
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {}
                    });
                }
                return false;
            }
        });


        spProvincia.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    spProvincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, final int pos, long l) {
                            data = new Data(context);
                            data.open();
                            String idUbi = checkDigito(spDepartamento.getSelectedItemPosition()) + checkDigito(pos);
                            final ArrayList<String> ubis = data.getUbigeos(idUbi);
                            data.close();
                            cargarSpinerDistritos(ubis);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {}
                    });
                }
                return false;
            }
        });

        btnGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkLocation())
                    return;
                if (btnGPS.getText().equals(getResources().getString(R.string.cancelar_gps))) {
                    locationManager.removeUpdates(locationListenerGPS);
                    txtLongitud.setText("99.99999999");
                    txtLatitud.setText("99.99999999");
                    btnGPS.setText(getResources().getString(R.string.capturar_gps));
                } else {
                    txtLatitud.setText("Buscando, puede tardar 1 min...");
                    txtLongitud.setText("Buscando, puede tardar 1 min...");
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                            ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    }
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER, 2 * 20 * 1000, 10, locationListenerGPS);
                    btnGPS.setText(getResources().getString(R.string.cancelar_gps));
                }
            }
        });
        edtFrente.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(edtFrente);
                    lytUbicacion.requestFocus();
                    return true;
                }
                return false;
            }
        });
        edtNombreVia.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(edtNombreVia);
                    lytDireccion.requestFocus();
                    return true;
                }
                return false;
            }
        });

        spTipoVia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 7) edtEspecifiqueVia.setVisibility(View.VISIBLE);
                else {
                    edtEspecifiqueVia.setText("");
                    edtEspecifiqueVia.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        EditText[] editTexts = {edtSector,edtArea,edtZona,
                edtManzana,edtFrente,edtNombreVia,edtNPuerta,edtBlock,edtInterior,edtPiso,
                edtManzanaVia,edtLote,edtKm,edtReferencia};

        for (int i = 0; i <editTexts.length ; i++) {
            EditText editText = editTexts[i];
            editText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        }
        cargarCaratula();
        cargarDatosIniciales();

    }

    public void cargarCaratula(){
        Context contexto3 = context;
        data = new Data(contexto3);
        data.open();
        caratula = data.getCaratula(idCaratula);
        if(caratula.getID().equals("")){
            Marco marco = data.getMarco(idCaratula);
            caratula.setID(marco.getID());
            caratula.setCCDD(marco.getCCDD());
            caratula.setNOMBREDD(marco.getDEPARTAMENTO());
            caratula.setCCPP(marco.getCCPP());
            caratula.setNOMBREPV(marco.getPROVINCIA());
            caratula.setCCDI(marco.getCCDI());
            caratula.setNOMBREDI(marco.getDISTRITO());
            caratula.setARA_TR("001");
            caratula.setSECTOR_TR("001");
            caratula.setFRENTE(marco.getFRENTE());
            caratula.setZONA(marco.getZONA());
            caratula.setMANZANA_ID(marco.getMANZANA());
            caratula.setTIPVIA(marco.getCAT_VIA());
        }
        data.close();
    }

    public void cargarDatosIniciales(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                final String[] departamentos = context.getResources().getStringArray(R.array.DEPARTAMENTOS);
                data = new Data(context);
                data.open();
                final String[] provincias = context.getResources().getStringArray(arreglosDepartamentos[Integer.parseInt(caratula.getCCDD())-1]);
                final String idUbi = checkDigito(Integer.parseInt(caratula.getCCDD())) + checkDigito(Integer.parseInt(caratula.getCCPP()));
                final ArrayList<String> distritos = data.getUbigeos(idUbi);
                data.close();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        cargarSpinerDepartamentos(departamentos);
                        cargarSpinerProvincias(provincias);
                        cargarSpinerDistritos(distritos);
                        spDepartamento.setSelection(Integer.parseInt(caratula.getCCDD()));
                        spProvincia.setSelection(Integer.parseInt(caratula.getCCPP()));
                        spDistrito.setSelection(obtenerPosDistrito(idUbi,Integer.parseInt(caratula.getCCDI())));
                        cargarDatos();
                    }
                });
            }
        };
        thread.start();
    }

    public void cargarDatos(){
        txtLatitud.setText(caratula.getGPSLATITUD());
        txtLongitud.setText(caratula.getGPSLONGITUD());
        edtSector.setText(caratula.getSECTOR_TR());
        edtArea.setText(caratula.getARA_TR());
        edtZona.setText(caratula.getZONA());
        edtManzana.setText(caratula.getMANZANA_ID());
        edtFrente.setText(caratula.getFRENTE());
//        if(!caratula.getTIPVIA().equals("")){
//            spTipoVia.setSelection(Integer.parseInt(caratula.getTIPVIA()));
//            if(Integer.parseInt(caratula.getTIPVIA()) == 7){
//                edtEspecifiqueVia.setText(caratula.getTIPVIA_ESPEC());
//            }
//        }
        edtNombreVia.setText(caratula.getTIPVIA_D());
        edtNPuerta.setText(caratula.getNROPTA());
        edtBlock.setText(caratula.getBLOCK());
        edtInterior.setText(caratula.getINTERIOR());
        edtPiso.setText(caratula.getPISO());
        edtManzanaVia.setText(caratula.getMZA());
        edtLote.setText(caratula.getLOTE());
        edtKm.setText(caratula.getKM());
        edtReferencia.setText(caratula.getREF_DIREC());
    }

    public void cargarSpinerDepartamentos(String[] datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDepartamento.setAdapter(adapter);
    }

    public void cargarSpinerProvincias(String[] datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProvincia.setAdapter(adapter);
    }

    public void cargarSpinerDistritos(ArrayList<String> datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDistrito.setAdapter(adapter);
    }
    public String obtenerCCDI(int pos, String ubi){
        String codigo = "";
        if(ubi.equals("0907")){
            int[] codigos = {1 ,2 , 3, 4, 5, 6, 7, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
            codigo = checkDigito(codigos[pos-1]);
        }else if(ubi.equals("1003")){
            int[] codigos = {1, 7, 11, 13, 16, 17, 21, 22, 23};
            codigo = checkDigito(codigos[pos-1]);
        }else if(ubi.equals("1201")){
            int[] codigos = {1, 4, 5, 6, 7, 8, 11, 12, 13, 14, 16, 17, 19, 20, 21, 22, 24, 25, 26, 27, 28, 29, 30, 32, 33, 34, 35, 36};
            codigo = checkDigito(codigos[pos-1]);
        }else if(ubi.equals("1206")){
            int[] codigos = {1, 2,3,5,7,8,9,99};
            codigo = checkDigito(codigos[pos-1]);
        }else if(ubi.equals("1306")){
            int[] codigos = {1,2,4,5,6,8,10,11,13,14};
            codigo = checkDigito(codigos[pos-1]);
        }else  if(ubi.equals("1601")){
            int[] codigos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14};
            codigo = checkDigito(codigos[pos-1]);
        }else if(ubi.equals("1602")){
            int[] codigos = {1, 2, 5, 6, 10, 11};
            codigo = checkDigito(codigos[pos-1]);
        }else if(ubi.equals("2001")){
            int[] codigos = {1,4,5,7,8,9,10,11,14,15};
            codigo = checkDigito(codigos[pos-1]);
        }else{
            codigo = checkDigito(pos);
        }
        return codigo;
    }
    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
    public int obtenerPosDistrito(String ubi, int cod){
        int posicion = 0;
        if(ubi.equals("0907")){
            int[] codigos = {1 ,2 , 3, 4, 5, 6, 7, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
            for (int i = 0; i < codigos.length; i++) {
                if(codigos[i] == cod){ posicion = i + 1;break;}
            }
        }else if(ubi.equals("1003")){
            int[] codigos = {1, 7, 11, 13, 16, 17, 21, 22, 23};
            for (int i = 0; i < codigos.length; i++) {
                if(codigos[i] == cod){ posicion = i+ 1;break;}
            }
        }else if(ubi.equals("1201")){
            int[] codigos = {1, 4, 5, 6, 7, 8, 11, 12, 13, 14, 16, 17, 19, 20, 21, 22, 24, 25, 26, 27, 28, 29, 30, 32, 33, 34, 35, 36};
            for (int i = 0; i < codigos.length; i++) {
                if(codigos[i] == cod){ posicion = i+ 1;break;}
            }
        }else if(ubi.equals("1206")){
            int[] codigos = {1, 2,3,5,7,8,9,99};
            for (int i = 0; i < codigos.length; i++) {
                if(codigos[i] == cod){ posicion = i+ 1;break;}
            }
        }else if(ubi.equals("1306")){
            int[] codigos = {1,2,4,5,6,8,10,11,13,14};
            for (int i = 0; i < codigos.length; i++) {
                if(codigos[i] == cod){ posicion = i+ 1;break;}
            }
        }else  if(ubi.equals("1601")){
            int[] codigos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14};
            for (int i = 0; i < codigos.length; i++) {
                if(codigos[i] == cod){ posicion = i+ 1;break;}
            }
        }else if(ubi.equals("1602")){
            int[] codigos = {1, 2, 5, 6, 10, 11};
            for (int i = 0; i < codigos.length; i++) {
                if(codigos[i] == cod){ posicion = i+ 1;break;}
            }
        }else if(ubi.equals("2001")){
            int[] codigos = {1,4,5,7,8,9,10,11,14,15};
            for (int i = 0; i < codigos.length; i++) {
                if(codigos[i] == cod){ posicion = i+ 1;break;}
            }
        }else{
            posicion = cod;
        }
        return posicion;
    }
    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    private boolean checkLocation() {
        if (!isLocationEnabled())
            showAlert();
        return isLocationEnabled();
    }

    private void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("Enable Location")
                .setMessage("Su ubicación esta desactivada.\npor favor active su ubicación " +
                        "usa esta app")
                .setPositiveButton("Configuración de ubicación", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(myIntent);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    }
                });
        dialog.show();
    }

    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }
    private final LocationListener locationListenerGPS = new LocationListener() {
        public void onLocationChanged(Location location) {
            try{
                longitudeGPS = location.getLongitude();
                latitudeGPS = location.getLatitude();
//                altitudGPS = location.getAltitude();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtLongitud.setText(longitudeGPS + "");
                        txtLatitud.setText(latitudeGPS + "");
                        btnGPS.setText("LISTO");
                        btnGPS.setEnabled(false);
                    }
                });
            }catch (Exception e){
            }finally{
            }
        }
        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
        }

        @Override
        public void onProviderEnabled(String s) {
        }
        @Override
        public void onProviderDisabled(String s) {
        }
    };


    public void llenarMapaVariables(){
        CCDD = String.valueOf(spDepartamento.getSelectedItemPosition());
        CCPP = String.valueOf(spProvincia.getSelectedItemPosition());
        String idUbica = checkDigito(spDepartamento.getSelectedItemPosition()) + checkDigito(spProvincia.getSelectedItemPosition());
        CCDI = obtenerCCDI(spDistrito.getSelectedItemPosition(),idUbica);
        NOMBREDD = spDepartamento.getSelectedItem().toString();
        NOMBREPV = spProvincia.getSelectedItem().toString();
        NOMBREDI = spDistrito.getSelectedItem().toString();
        GPSLATITUD=txtLatitud.getText().toString();
        GPSLONGITUD=txtLongitud.getText().toString();
        SECTOR_TR=edtSector.getText().toString();
        AREA_TR=edtArea.getText().toString();
        ZONA=edtZona.getText().toString();
        MANZANA_ID=edtManzana.getText().toString();
        FRENTE=edtFrente.getText().toString();
        TIPVIA = spTipoVia.getSelectedItemPosition();
        TIPVIA_D=edtNombreVia.getText().toString();
        TIPVIA_ESPEC = edtEspecifiqueVia.getText().toString();
        NROPTA=edtNPuerta.getText().toString();
        BLOCK=edtBlock.getText().toString();
        INTERIOR=edtInterior.getText().toString();
        PISO=edtPiso.getText().toString();
        MZA=edtManzanaVia.getText().toString();
        LOTE=edtLote.getText().toString();
        KM=edtKm.getText().toString();
        REF_DIREC=edtReferencia.getText().toString();
    }

    public void guardarDatos(){
        llenarMapaVariables();
        data = new Data(context);
        data.open();
        if(data.existeCaratula(idCaratula)){
            ContentValues contentValues = new ContentValues(26);
            contentValues.put(SQLConstantes.CARATULA_DEPARTAMENTO,NOMBREDD);
            contentValues.put(SQLConstantes.CARATULA_DEPARTAMENTO_COD,CCDD);
            contentValues.put(SQLConstantes.CARATULA_PROVINCIA,NOMBREPV);
            contentValues.put(SQLConstantes.CARATULA_PROVINCIA_COD,CCPP);
            contentValues.put(SQLConstantes.CARATULA_DISTRITO,NOMBREDI);
            contentValues.put(SQLConstantes.CARATULA_DISTRITO_COD,CCDI);
            contentValues.put(SQLConstantes.CARATULA_GPSLATITUD,GPSLATITUD);
            contentValues.put(SQLConstantes.CARATULA_GPSLONGITUD,GPSLONGITUD);
            contentValues.put(SQLConstantes.CARATULA_SECTOR,SECTOR_TR);
            contentValues.put(SQLConstantes.CARATULA_AREA,AREA_TR);
            contentValues.put(SQLConstantes.CARATULA_ZONA,ZONA);
            contentValues.put(SQLConstantes.CARATULA_MANZANA_MUESTRA,MANZANA_ID);
            contentValues.put(SQLConstantes.CARATULA_FRENTE,FRENTE);
            contentValues.put(SQLConstantes.CARATULA_TIPVIA,String.valueOf(TIPVIA));
            contentValues.put(SQLConstantes.CARATULA_TIPVIA_OTRO,TIPVIA_ESPEC);
            contentValues.put(SQLConstantes.CARATULA_NOMVIA,TIPVIA_D);
            contentValues.put(SQLConstantes.CARATULA_NPUERTA,NROPTA);
            contentValues.put(SQLConstantes.CARATULA_BLOCK,BLOCK);
            contentValues.put(SQLConstantes.CARATULA_INTERIOR,INTERIOR);
            contentValues.put(SQLConstantes.CARATULA_PISO,PISO);
            contentValues.put(SQLConstantes.CARATULA_MANZANA_VIA,MZA);
            contentValues.put(SQLConstantes.CARATULA_LOTE,LOTE);
            contentValues.put(SQLConstantes.CARATULA_KM,KM);
            contentValues.put(SQLConstantes.CARATULA_REFERENCIA,REF_DIREC);
            data.actualizarCaratula(idCaratula,contentValues);
        }else{
            caratula = new CaratulaPojo();
            caratula.setID(idCaratula);
            caratula.setNOMBREDD(NOMBREDD);
            caratula.setCCDD(CCDD);
            caratula.setNOMBREPV(NOMBREPV);
            caratula.setCCPP(CCPP);
            caratula.setNOMBREDI(NOMBREDI);
            caratula.setCCDI(CCDI);
            caratula.setGPSLATITUD(GPSLATITUD);
            caratula.setGPSLONGITUD(GPSLONGITUD);
            caratula.setSECTOR_TR(SECTOR_TR);
            caratula.setARA_TR(AREA_TR);
            caratula.setZONA(ZONA);
            caratula.setMANZANA_ID(MANZANA_ID);
            caratula.setFRENTE(FRENTE);
            caratula.setTIPVIA(String.valueOf(TIPVIA));
            caratula.setTIPVIA_D(TIPVIA_D);
            caratula.setTIPVIA_ESPEC(TIPVIA_ESPEC);
            caratula.setNROPTA(NROPTA);
            caratula.setBLOCK(BLOCK);
            caratula.setINTERIOR(INTERIOR);
            caratula.setPISO(PISO);
            caratula.setMZA(MZA);
            caratula.setLOTE(LOTE);
            caratula.setKM(KM);
            caratula.setREF_DIREC(REF_DIREC);
            data.insertarCaratula(caratula);
        }
        data.close();
    }
    public boolean validar(){
        //revisarcampos
        boolean valido = false;
        String mensaje = "";
        boolean vNOMBREDD= false, vNOMBREPV= false, vNOMBREDI= false, vGPSLATITUD= true, vGPSLONGITUD= true;
        // vMZA= true, vLOTE= true, vKM= true,vZON_NUM= false, vMZ_ID= false, vFRENTE= false, vCCST= false, vCCAT= false, vNROPTA= false, vBLOCK= true, vINT= true;
        boolean  vTIPVIA= true, vTIPVIAESP= true, vNOMVIA=false;
        boolean  vPISO= false,vREF_DIREC= false;
        llenarMapaVariables();
        if(!String.valueOf(spDepartamento.getSelectedItemPosition()).equals("0")) vNOMBREDD=true;
        else if(mensaje.equals(""))mensaje = "DEPARTAMENTO: DEBE INDICAR EL DEPARTAMENTO";
        if(!String.valueOf(spProvincia.getSelectedItemPosition()).equals("0")) vNOMBREPV=true;
        else if(mensaje.equals(""))mensaje = "PROVINCIA: DEBE INDICAR LA PROVINCIA";
        if(!String.valueOf(spDistrito.getSelectedItemPosition()).equals("0")) vNOMBREDI=true;
        else if(mensaje.equals(""))mensaje = "DISTRITO: DEBE INDICAR EL DISTRITO";
        if(GPSLATITUD.equals("")) {
            vGPSLATITUD = false;vGPSLONGITUD = false;
            if (mensaje.equals("")) mensaje = "GPS: DEBE REGISTRARSE LAS COORDENADAS CON EL GPS";
        }
        if(GPSLATITUD.equals("Buscando, puede tardar 1 min...")){
            vGPSLATITUD = false;vGPSLONGITUD = false;
            if(mensaje.equals(""))mensaje = "GPS: DEBE ESPERAR A QUE TERMINE DE BUSCARSE LAS COORDENADAS DEL GPS " +
                    "O CANCELAR PARA GUARDAR VALORES POR DEFECTO";
        }
//        if(!CCST.equals("")) vCCST=true;
//        else if(mensaje.equals(""))mensaje = "SECTOR DE TRABAJO: DEBE INDICAR EL SECTOR DE TRABAJO";
//        if(!CCAT.equals("")) vCCAT=true;
//        else if(mensaje.equals(""))mensaje = "AREA DE TRABAJO: DEBE INDICAR EL AREA DE TRABAJO";
//        if(!ZON_NUM.equals("")) vZON_NUM=true;
//        else if(mensaje.equals(""))mensaje = "ZONA: DEBE INDICAR LA ZONA";
//        if(!MZ_ID.equals("")) vMZ_ID=true;
//        else if(mensaje.equals(""))mensaje = "MANZANA: DEBE INDICAR LA MANZANA";
//        if(!FRENTE.equals("")) vFRENTE=true;
//        else if(mensaje.equals(""))mensaje = "FRENTE: DEBE INDICAR EL FRENTE";
        if(TIPVIA==0){
            vTIPVIA=false;
            if(mensaje.equals(""))mensaje = "TIPO DE VIA: DEBE INDICAR EL TIPO DE VIA";
        }
        if (TIPVIA==7){
            if (TIPVIA_ESPEC.trim().length() < 2) {
                vTIPVIAESP = false;
                if (mensaje.equals("")) mensaje = "TIPODE VIA ESPECIFIQUE: DEBE REGISTRAR INFORMACION";
            }
        }
//        if(TIPVIA == 5 && KM.equals("")){
//            vKM = false;
//            if(mensaje.equals(""))mensaje = "KILOMETRO: DEBE REGISTRAR KILOMETRO YA QUE EL TIPO DE VIA ES CARRETERA";
//        }
//        if(!BLOCK.equals("") && INTERIOR.equals("")){
//            vINT=false;
//            if(mensaje.equals(""))mensaje = "INTERIOR: SI REGISTRA BLOCK DEBE REGISTRAR INTERIOR";
//        }
//        if((MZA.equals("") && !LOTE.equals("")) || (!MZA.equals("") && LOTE.equals(""))){
//            vMZA=false; vLOTE = false;
//            if(mensaje.equals(""))mensaje = "SI REGISTRA MANZANA  DEBE REGISTRAR LOTE Y VICEVERSA";
//        }
        if(!TIPVIA_D.equals("")) vNOMVIA=true;
        else if(mensaje.equals(""))mensaje = "NOMBRE DE VIA: DEBE REGISTRAR INFORMACION";
//        if(!NROPTA.equals("")) vNROPTA=true;
//        else if(mensaje.equals(""))mensaje = "NUMERO DE PUERTA: DEBE REGISTRAR EL NUMERO DE PUERTA";
        if(!PISO.equals("")) vPISO=true;
        else if(mensaje.equals(""))mensaje = "PISO: DEBE REGISTRAR INFORMACION";
        if(!REF_DIREC.equals("")){
            if (!REF_DIREC.substring(0).equals("1")&& !REF_DIREC.substring(0).equals("2")&& !REF_DIREC.substring(0).equals("3")&& !REF_DIREC.substring(0).equals("4")&& !REF_DIREC.substring(0).equals("5")&& !REF_DIREC.substring(0).equals("6")&& !REF_DIREC.substring(0).equals("7")&& !REF_DIREC.substring(0).equals("8")&& !REF_DIREC.substring(0).equals("9")&& !REF_DIREC.substring(0).equals("0")){
                vREF_DIREC=true;
            }else if(mensaje.equals(""))mensaje = "REFERENCIA: Debe existir información como referencia de la dirección";

        }else if(mensaje.equals(""))mensaje = "REFERENCIA: Debe existir información como referencia de la dirección";

        valido = vNOMBREDD && vNOMBREPV && vNOMBREDI && vGPSLATITUD && vGPSLONGITUD  && vTIPVIA && vTIPVIAESP && vNOMVIA && vPISO && vREF_DIREC;
        if(!valido) mostrarMensaje(mensaje);

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
