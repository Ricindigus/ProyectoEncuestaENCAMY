package com.example.administrador.encal.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

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
import com.example.administrador.encal.R;

public class EncuestaActivity extends AppCompatActivity {
    private Fragment fragmentActual;
    private Toolbar toolbar;
    private String idEmpresa = "";
    private Data data;
    private String observaciones = "";
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_control,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId() ){
            case R.id.adelante:
                if(cont<9){
                    if(validarFragment(cont)){
                        guardarFragment(cont);
                        cont++;
                        setFragment(cont, 1);
                    }
                }else{
                    if(validarFragment(cont)){
                        guardarFragment(cont);
                        cont=0;
                        setFragment(cont, 1);
                    }
                }
                return true;
            case R.id.atras:
                if(cont>0){
                    if(validarFragment(cont)){
                        cont--;
                        setFragment(cont,-1);
                    }
                }
                return true;
            default:return super.onOptionsItemSelected(item);
        }
    }

    public void setFragment(int poscicion, int direccion){
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
                visitaFragment.guardarDatos();break;
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
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Está seguro que desea volver al marco y salir de la encuesta?")
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
                                    finish();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
