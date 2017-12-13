package com.example.administrador.encal.activities;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.administrador.encal.Fragments.CaratulaFragment;
import com.example.administrador.encal.Fragments.Seccion100Fragment1;
import com.example.administrador.encal.Fragments.Seccion200Fragment1;
import com.example.administrador.encal.Fragments.Seccion300Fragment1;
import com.example.administrador.encal.Fragments.Seccion400Fragment1;
import com.example.administrador.encal.Fragments.Seccion100Fragment2;
import com.example.administrador.encal.Fragments.Seccion400Fragment2;
import com.example.administrador.encal.Fragments.Seccion100Fragment3;
import com.example.administrador.encal.Fragments.InicioFragment;
import com.example.administrador.encal.Fragments.VisitaFragment;
import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Modelo.SQLConstantes;
import com.example.administrador.encal.R;

public class EncuestaActivity extends AppCompatActivity {
    private Fragment fragmentActual;
    private Toolbar toolbar;
    private String idEmpresa = "";
    private Data data;
    private String observaciones = "";
    private Button btnAnterior;
    private Button btnSiguiente;
    private int cont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        //AÑADIR TOOLBAR
        toolbar = (Toolbar)findViewById(R.id.encuesta_toolbar);
        setSupportActionBar(toolbar);

        //RECUPERAMOS EL ID DE LA EMPRESA
        final Bundle recupera=getIntent().getExtras();
        if(recupera != null) idEmpresa = recupera.getString("idEmpresa");

        //INICIAMOS VARIABLES
        cont = 0;
        fragmentActual = new Fragment();
        setFragment(0,1);

        //BOTONES
        btnAnterior = (Button) findViewById(R.id.btn_anterior);
        btnSiguiente = (Button) findViewById(R.id.btn_siguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(btnSiguiente);
                if(cont<9){
                    if(validarFragment(cont)){
                        guardarFragment(cont);
                        guardarObservaciones(cont);
                        boolean continuar = true;
                        if(cont == 3){
                            Seccion100Fragment1 seccion100Fragment1 = (Seccion100Fragment1) fragmentActual;
                            if(seccion100Fragment1.validarFinalizar()) continuar = false;
                        }
                        if(continuar){cont++; setFragment(cont, 1);}
                        else {cont = 0;setFragment(cont,-1);}
                    }
                }else{
                    if(validarFragment(cont)){
                        guardarFragment(cont);
                        cont=0;
                        setFragment(cont, 1);
                    }
                }
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(btnAnterior);
                if(cont - 1 >= 0){
                    cont--;
                    setFragment(cont,-1);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_encuesta,menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        if(cont > 2) getMenuInflater().inflate(R.menu.menu_encuesta, menu);
        else getMenuInflater().inflate(R.menu.menu_simple, menu);
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();
        if (id == R.id.volver_marco || id == R.id.action_marco_simple) {
            String men = "";
            if(cont > 0) men = "¿Está seguro que desea guardar la encuesta hasta este punto y finalizarla?";
            else men = "¿Está seguro que desea volver al marco y salir de la encuesta?";
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(men)
                    .setTitle("Aviso")
                    .setCancelable(false)
                    .setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                    .setPositiveButton("Sí",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if(cont > 0){
                                        if(validarFragment(cont)){
                                            guardarFragment(cont);
                                            cont=0;
                                            setFragment(cont, 1);
                                        }
                                    }else{
                                        VisitaFragment visitaFragment = (VisitaFragment) fragmentActual;
                                        if(visitaFragment.tieneVisitas()){
                                            if(visitaFragment.finalizacionCorrecta()) finish();
                                            else{
                                                mostrarMensaje("Debe finalizar una visita");
                                            }
                                        }else{
                                            finish();
                                        }
                                    }
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
            return true;
        }
        if( id == R.id.registrar_observacion){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            final View dialogView = this.getLayoutInflater().inflate(R.layout.observaciones, null);
            CardView lytObservaciones = dialogView.findViewById(R.id.card_obs);
            final EditText edtObservaciones = dialogView.findViewById(R.id.edt_obs);
            dialog.setView(dialogView);
            dialog.setTitle("Observaciones");
            dialog.setPositiveButton("Guardar",null);
            dialog.setNegativeButton("Cancelar",null);
            final AlertDialog alertDialog = dialog.create();
            alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    edtObservaciones.setText(observaciones);
                    Button b = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // TODO Do something
                            observaciones = edtObservaciones.getText().toString();
                            alertDialog.dismiss();
                        }
                    });
                }
            });
            alertDialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void guardarObservaciones(int tipo){
        data = new Data(EncuestaActivity.this);
        data.open();
        if(cont >= 3 && cont <= 4){

            ContentValues contentValues = new ContentValues(1);
            contentValues.put(SQLConstantes.SECCION100_OBS,observaciones);
            data.actualizarModulo1(idEmpresa,contentValues);

        }
        if(cont == 6){

            ContentValues contentValues = new ContentValues(1);
            contentValues.put(SQLConstantes.SECCION200_OBS,observaciones);
            data.actualizarModulo2(idEmpresa,contentValues);

        }
        if(cont == 7){
            ContentValues contentValues = new ContentValues(1);
            contentValues.put(SQLConstantes.SECCION300_OBS,observaciones);
            data.actualizarModulo3(idEmpresa,contentValues);

        }
        if(cont >= 8 && cont <= 8){

            ContentValues contentValues = new ContentValues(1);
            contentValues.put(SQLConstantes.SECCION400_OBS,observaciones);
            data.actualizarModulo4(idEmpresa,contentValues);

        }
        data.close();
    }

    public void setFragment(int poscicion, int direccion){
        observaciones = "";
        data = new Data(this);
        data.open();
        if(cont >= 3 && cont <= 5){
            observaciones = data.getModulo1(idEmpresa).getOBS();
        }
        if(cont == 6){
            observaciones = data.getModulo2(idEmpresa).getOBS();
        }
        if(cont == 7){
            observaciones = data.getModulo3(idEmpresa).getOBS();
        }
        if(cont >= 8 && cont <= 9){
            observaciones = data.getModulo4(idEmpresa).getOBS();
        }
        data.close();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(direccion > 0){
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        }else{
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        }
        switch (poscicion){
            case 0:
                fragmentActual = new VisitaFragment(idEmpresa,this);
                fragmentTransaction.replace(R.id.layout_fragment,fragmentActual);
                break;
            case 1:
                fragmentActual = new CaratulaFragment(idEmpresa,this);
                fragmentTransaction.replace(R.id.layout_fragment, fragmentActual);
                break;
            case 2:
                fragmentActual = new InicioFragment(idEmpresa,this);
                fragmentTransaction.replace(R.id.layout_fragment,fragmentActual);
                break;
            case 3:
                fragmentActual = new Seccion100Fragment1(idEmpresa,this);
                fragmentTransaction.replace(R.id.layout_fragment,fragmentActual);
                break;
            case 4:
                fragmentActual = new Seccion100Fragment2(idEmpresa,this);
                fragmentTransaction.replace(R.id.layout_fragment,fragmentActual);
                break;
            case 5:
                fragmentActual = new Seccion100Fragment3(idEmpresa,this);
                fragmentTransaction.replace(R.id.layout_fragment,fragmentActual);
                break;
            case 6:
                fragmentActual = new Seccion200Fragment1(idEmpresa,this);
                fragmentTransaction.replace(R.id.layout_fragment, fragmentActual);
                break;
            case 7:
                fragmentActual = new Seccion300Fragment1(idEmpresa,this);
                fragmentTransaction.replace(R.id.layout_fragment,fragmentActual);
                break;
            case 8:
                fragmentActual = new Seccion400Fragment1(idEmpresa,this);
                fragmentTransaction.replace(R.id.layout_fragment,fragmentActual);
                break;
            case 9:
                fragmentActual = new Seccion400Fragment2(idEmpresa,this);
                fragmentTransaction.replace(R.id.layout_fragment,fragmentActual);
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public boolean validarFragment(int tipo){
        boolean correcto = false;
        switch (tipo){
            case 0:
                VisitaFragment visitaFragment = (VisitaFragment) fragmentActual;
                correcto = visitaFragment.validar();
                break;
            case 1:
                CaratulaFragment caratulaFragment = (CaratulaFragment) fragmentActual;
                correcto = caratulaFragment.validar();
                break;
            case 2:
                InicioFragment inicioFragment = (InicioFragment) fragmentActual;
                correcto = inicioFragment.validar();
                break;
            case 3:
                Seccion100Fragment1 seccion100Fragment1 = (Seccion100Fragment1) fragmentActual;
                correcto = seccion100Fragment1.validar();
                break;
            case 4:
                Seccion100Fragment2 seccion100Fragment2 = (Seccion100Fragment2) fragmentActual;
                correcto = seccion100Fragment2.validar();
                break;
            case 5:
                Seccion100Fragment3 seccion100Fragment3 = (Seccion100Fragment3) fragmentActual;
                correcto = seccion100Fragment3.validar();
                break;
            case 6:
                Seccion200Fragment1 seccion200Fragment1 = (Seccion200Fragment1) fragmentActual;
                correcto = seccion200Fragment1.validar();
                break;
            case 7:
                Seccion300Fragment1 seccion300Fragment1 = (Seccion300Fragment1) fragmentActual;
                correcto = seccion300Fragment1.validar();
                break;
            case 8:
                Seccion400Fragment1 seccion400Fragment1 = (Seccion400Fragment1) fragmentActual;
                correcto = seccion400Fragment1.validar();
                break;
            case 9:
                Seccion400Fragment2 seccion400Fragment2 = (Seccion400Fragment2) fragmentActual;
                correcto = seccion400Fragment2.validar();
                break;
        }
        return correcto;
    }

    public void guardarFragment(int tipo){
        switch (tipo){
            case 0:
                VisitaFragment visitaFragment = (VisitaFragment) fragmentActual;
                break;
            case 1:
                CaratulaFragment caratulaFragment = (CaratulaFragment) fragmentActual;
                caratulaFragment.guardarDatos();break;
            case 2:
                InicioFragment inicioFragment1 = (InicioFragment) fragmentActual;
                inicioFragment1.guardarDatos();break;
            case 3:
                Seccion100Fragment1 seccion100Fragment1 = (Seccion100Fragment1) fragmentActual;
                seccion100Fragment1.guardarDatos();break;
            case 4:
                Seccion100Fragment2 seccion100Fragment2 = (Seccion100Fragment2) fragmentActual;
                seccion100Fragment2.guardarDatos();break;
            case 5:
                Seccion100Fragment3 seccion100Fragment3 = (Seccion100Fragment3) fragmentActual;
                seccion100Fragment3.guardarDatos();break;
            case 6:
                Seccion200Fragment1 seccion200Fragment1 = (Seccion200Fragment1) fragmentActual;
                seccion200Fragment1.guardarDatos();break;
            case 7:
                Seccion300Fragment1 seccion300Fragment1 = (Seccion300Fragment1) fragmentActual;
                seccion300Fragment1.guardarDatos();break;
            case 8:
                Seccion400Fragment1 seccion400Fragment1 = (Seccion400Fragment1) fragmentActual;
                seccion400Fragment1.guardarDatos();break;
            case 9:
                Seccion400Fragment2 seccion400Fragment2 = (Seccion400Fragment2) fragmentActual;
                seccion400Fragment2.guardarDatos();break;

        }
    }



    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    @SuppressLint("NewApi")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            String men = "";
            if(cont > 0) men = "¿Está seguro que desea guardar la encuesta hasta este punto y finalizarla?";
            else men = "¿Está seguro que desea volver al marco y salir de la encuesta?";
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(men)
                    .setTitle("Aviso")
                    .setCancelable(false)
                    .setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                    .setPositiveButton("Sí",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                        if(cont > 0){
                                            if(validarFragment(cont)){
                                                guardarFragment(cont);
                                                cont=0;
                                                setFragment(cont, 1);
                                            }
                                        }else{
                                            VisitaFragment visitaFragment = (VisitaFragment) fragmentActual;
                                            if(visitaFragment.tieneVisitas()){
                                                if(visitaFragment.finalizacionCorrecta()) finish();
                                                else{
                                                    mostrarMensaje("Debe finalizar una visita");
                                                }
                                            }else{
                                                finish();
                                            }
                                        }
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        return super.onKeyDown(keyCode, event);
    }
    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
