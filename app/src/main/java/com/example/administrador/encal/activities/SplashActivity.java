package com.example.administrador.encal.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Pojos.Marco;
import com.example.administrador.encal.Pojos.Ubigeo;
import com.example.administrador.encal.Pojos.Usuario;
import com.example.administrador.encal.R;
import com.example.administrador.encal.parser.MarcoPullParser;
import com.example.administrador.encal.parser.UbigeoPullParser;
import com.example.administrador.encal.parser.UsuariosPullParser;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    TextView txtMensaje;
    ProgressBar progressBar;
    ProgressBar progressBar1;
    ArrayList<Marco> marcos = new ArrayList<Marco>();
    //    ArrayList<Caratula> caratulas = new ArrayList<Caratula>();
//    ArrayList<Identificacion> identificaciones = new ArrayList<Identificacion>();
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    ArrayList<Ubigeo> ubigeos = new ArrayList<Ubigeo>();
    Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        txtMensaje = (TextView) findViewById(R.id.splash_mensaje);
        progressBar = (ProgressBar) findViewById(R.id.marco_progreso2);
        progressBar1 = (ProgressBar) findViewById(R.id.marco_progreso1);


        progressBar.setMax(6052);
        progressBar.setVisibility(View.GONE);
        progressBar1.setMax(6052);
        progressBar1.setVisibility(View.GONE);

        new MyAsyncTask().execute(0);
    }

    public class MyAsyncTask extends AsyncTask<Integer,Integer,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            progressBar1.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            data = new Data(getApplicationContext());
            data.open();
            long items1 = data.getNumeroItemsMarco();
            data.close();
            if(items1 == 0){
                MarcoPullParser parser = new MarcoPullParser();
                UsuariosPullParser usuarioParser = new UsuariosPullParser();
                UbigeoPullParser ubigeoPullParser = new UbigeoPullParser();
                marcos = parser.parseXML(getApplicationContext());
                usuarios = usuarioParser.parseXML(getApplicationContext());
                ubigeos = ubigeoPullParser.parseXML(getApplicationContext());

            }
            String mensaje = "";
            String mensaje1 = "";
            int i = 1;
            data = new Data(getApplicationContext());
            data.open();
            long items = data.getNumeroItemsMarco();
            if(items == 0){
                for (Marco marco : marcos) {
                    try {
                        data.insertarMarco(marco);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/60.52));
                    i++;
                }
                for (Usuario usuario : usuarios) {
                    try {
                        data.insertarUsuario(usuario);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/60.52));
                    i++;
                }
                for (Ubigeo ubigeo : ubigeos) {
                    try {
                        data.insertarUbigeo(ubigeo);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/60.52));
                    i++;
                }
                mensaje = "LISTO, BIENVENIDO";
            }else{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data.close();
            return mensaje;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int contador = values[1];
            String texto = "CARGANDO MARCO " + contador +"%";
            txtMensaje.setText(texto);
            progressBar.setProgress(values[0]);
            progressBar1.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String mensaje) {
            super.onPostExecute(mensaje);
            txtMensaje.setText(mensaje);
            progressBar.setVisibility(View.GONE);
            progressBar1.setVisibility(View.GONE);
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
