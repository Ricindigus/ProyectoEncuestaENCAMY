package com.example.administrador.encal.activities;


import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.encal.Adapters.MarcoAdapter;
import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Pojos.ItemMarco;
import com.example.administrador.encal.Pojos.Marco;
import com.example.administrador.encal.R;

import java.util.ArrayList;

public class MarcoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MarcoAdapter marcoAdapter;
    private ArrayList<Marco> marcos;
    private ArrayList<ItemMarco> itemMarcos;
    private ArrayList<String> departamentos;
    private ArrayList<String> provincias;
    private ArrayList<String> distritos;
    private ArrayList<String> periodos;
    private String idUsuario;
    private String permisoUsuario;
    private Spinner spDepartamento;
    private Spinner spProvincia;
    private Spinner spDistrito;
    private Spinner spPeriodo;
    private Button btnFiltrar;
    private Button btnMostrarTodo;

    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marco);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.marco_toolbar);
        setSupportActionBar(myToolbar);

        final Bundle recupera = getIntent().getExtras();
        if(recupera != null){
            idUsuario = recupera.getString("idUsuario");
            permisoUsuario = recupera.getString("permisoUsuario");
        }

        spDepartamento = (Spinner) findViewById(R.id.marco_sp_departamento);
        spProvincia = (Spinner) findViewById(R.id.marco_sp_provincia);
        spDistrito = (Spinner) findViewById(R.id.marco_sp_distrito);
        spPeriodo = (Spinner) findViewById(R.id.marco_sp_periodo);
        btnFiltrar = (Button) findViewById(R.id.marco_btnFiltrar);
        btnMostrarTodo = (Button) findViewById(R.id.marco_btnMotrarTodo);

        recyclerView = (RecyclerView) findViewById(R.id.marco_recycler);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        inicializarDatos();
        cargarSpinerDepartamentos(departamentos);
        cargarSpinerProvincias(provincias);
        cargarSpinerDistritos(distritos);
        marcoAdapter= new MarcoAdapter(itemMarcos, new MarcoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                final CardView rootView = (CardView) v;
                final TextView txtTextView1 = (TextView) rootView.findViewById(R.id.marco_item_txtId);
                final TextView txtTextView2 = (TextView) rootView.findViewById(R.id.marco_item_txtRuc);
                final TextView txtTextView3 = (TextView) rootView.findViewById(R.id.marco_item_txtRazonSocial);
                final TextView txtTextView5 = (TextView) rootView.findViewById(R.id.marco_item_txtResultado);

                int colorFrom = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);
                int colorTo = ContextCompat.getColor(getApplicationContext(), R.color.icons);

                int colorFrom2 = ContextCompat.getColor(getApplicationContext(), R.color.icons );
                int colorTo2 = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);

                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(800); // milliseconds
                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        rootView.setCardBackgroundColor((int) animator.getAnimatedValue());
                    }
                });
                colorAnimation.start();

                ValueAnimator colorAnimation2 = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom2, colorTo2);
                colorAnimation2.setDuration(800); // milliseconds
                colorAnimation2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        txtTextView1.setTextColor((int) animator.getAnimatedValue());
                        txtTextView2.setTextColor((int) animator.getAnimatedValue());
                        txtTextView3.setTextColor((int) animator.getAnimatedValue());
                        txtTextView5.setTextColor((int) animator.getAnimatedValue());
                    }
                });
                colorAnimation2.start();

                Intent intent = new Intent(getApplicationContext(), EncuestaActivity.class);
                intent.putExtra("idEmpresa",itemMarcos.get(position).getId());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(marcoAdapter);

        spDepartamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i > 0) obtenerProvincias(spDepartamento.getSelectedItem().toString());
                if(i == 0) provincias = new ArrayList<String>();
                cargarSpinerProvincias(provincias);
                distritos = new ArrayList<String>();
                cargarSpinerDistritos(distritos);
                periodos = new ArrayList<String>();
                cargarSpinerPeriodos(periodos);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        spProvincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i > 0) obtenerDistritos(spProvincia.getSelectedItem().toString());
                if(i == 0) distritos = new ArrayList<String>();
                cargarSpinerDistritos(distritos);
                periodos = new ArrayList<String>();
                cargarSpinerPeriodos(periodos);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        spDistrito.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i > 0) obtenerPeriodos(spDistrito.getSelectedItem().toString());
                if(i == 0) periodos = new ArrayList<String>();
                cargarSpinerPeriodos(periodos);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(periodos.size() > 1 && spPeriodo.getSelectedItemPosition() != 0){
                    obtenerMarcoFiltrado(spDepartamento.getSelectedItem().toString(),
                            spProvincia.getSelectedItem().toString(),
                            spDistrito.getSelectedItem().toString(),
                            spPeriodo.getSelectedItem().toString());
                }else{
                    Toast.makeText(MarcoActivity.this, "DEBE SELECCIONAR TODOS LOS CAMPOS ANTES DE FILTRAR", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnMostrarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerMarcoTotal();
                spDepartamento.setSelection(0);
            }
        });

    }

    public void obtenerMarcoFiltrado(String dep, String prov, String dis, String periodo){
        itemMarcos = new ArrayList<ItemMarco>();
        for(Marco marco : marcos){
            if(dep.equals(marco.getDEPARTAMENTO()) && prov.equals(marco.getPROVINCIA())&&
                    dis.equals(marco.getDISTRITO()) && periodo.equals(marco.getPERIODO())){
                itemMarcos.add(new ItemMarco(marco.getID(),marco.getRUC(),marco.getRAZON_SOCIAL(),""));
            }
        }
        marcoAdapter= new MarcoAdapter(itemMarcos, new MarcoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                final CardView rootView = (CardView) v;
                final TextView txtTextView1 = (TextView) rootView.findViewById(R.id.marco_item_txtId);
                final TextView txtTextView2 = (TextView) rootView.findViewById(R.id.marco_item_txtRuc);
                final TextView txtTextView3 = (TextView) rootView.findViewById(R.id.marco_item_txtRazonSocial);
                final TextView txtTextView5 = (TextView) rootView.findViewById(R.id.marco_item_txtResultado);

                int colorFrom = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);
                int colorTo = ContextCompat.getColor(getApplicationContext(), R.color.icons);

                int colorFrom2 = ContextCompat.getColor(getApplicationContext(), R.color.icons );
                int colorTo2 = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);

                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(800); // milliseconds
                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        rootView.setCardBackgroundColor((int) animator.getAnimatedValue());
                    }
                });
                colorAnimation.start();

                ValueAnimator colorAnimation2 = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom2, colorTo2);
                colorAnimation2.setDuration(800); // milliseconds
                colorAnimation2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        txtTextView1.setTextColor((int) animator.getAnimatedValue());
                        txtTextView2.setTextColor((int) animator.getAnimatedValue());
                        txtTextView3.setTextColor((int) animator.getAnimatedValue());
                        txtTextView5.setTextColor((int) animator.getAnimatedValue());
                    }
                });
                colorAnimation2.start();

                Intent intent = new Intent(getApplicationContext(), EncuestaActivity.class);
                String idEmp = itemMarcos.get(position).getId();
                intent.putExtra("idEmpresa", idEmp);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(marcoAdapter);
    }

    public void obtenerMarcoTotal(){
        itemMarcos = new ArrayList<ItemMarco>();
        for(Marco marco : marcos){
            itemMarcos.add(new ItemMarco(marco.getID(),marco.getRUC(),marco.getRAZON_SOCIAL(),""));
        }
        marcoAdapter= new MarcoAdapter(itemMarcos, new MarcoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                final CardView rootView = (CardView) v;
                final TextView txtTextView1 = (TextView) rootView.findViewById(R.id.marco_item_txtId);
                final TextView txtTextView2 = (TextView) rootView.findViewById(R.id.marco_item_txtRuc);
                final TextView txtTextView3 = (TextView) rootView.findViewById(R.id.marco_item_txtRazonSocial);
                final TextView txtTextView5 = (TextView) rootView.findViewById(R.id.marco_item_txtResultado);

                int colorFrom = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);
                int colorTo = ContextCompat.getColor(getApplicationContext(), R.color.icons);

                int colorFrom2 = ContextCompat.getColor(getApplicationContext(), R.color.icons );
                int colorTo2 = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);

                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(800); // milliseconds
                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        rootView.setCardBackgroundColor((int) animator.getAnimatedValue());
                    }
                });
                colorAnimation.start();

                ValueAnimator colorAnimation2 = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom2, colorTo2);
                colorAnimation2.setDuration(800); // milliseconds
                colorAnimation2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        txtTextView1.setTextColor((int) animator.getAnimatedValue());
                        txtTextView2.setTextColor((int) animator.getAnimatedValue());
                        txtTextView3.setTextColor((int) animator.getAnimatedValue());
                        txtTextView5.setTextColor((int) animator.getAnimatedValue());
                    }
                });
                colorAnimation2.start();

                Intent intent = new Intent(getApplicationContext(), EncuestaActivity.class);
                String ide = itemMarcos.get(position).getId();
                intent.putExtra("idEmpresa",ide);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(marcoAdapter);
    }

    public void obtenerProvincias(String departamento){
        provincias = new ArrayList<String>();
        provincias.add("Seleccione");
        for(Marco marco : marcos){
            if(marco.getDEPARTAMENTO().equals(departamento)){
                if(!provincias.contains(marco.getPROVINCIA())){
                    provincias.add(marco.getPROVINCIA());
                }
            }
        }
    }

    public void obtenerDistritos(String provincia){
        distritos = new ArrayList<String>();
        distritos.add("Seleccione");
        for(Marco marco : marcos){
            if(marco.getPROVINCIA().equals(provincia)){
                if(!distritos.contains(marco.getDISTRITO())){
                    distritos.add(marco.getDISTRITO());
                }
            }
        }
    }

    public void obtenerPeriodos(String distrito){
        periodos = new ArrayList<String>();
        periodos.add("Seleccione");
        for(Marco marco : marcos){
            if(marco.getDISTRITO().equals(distrito)){
                if(!periodos.contains(marco.getPERIODO())){
                    periodos.add(marco.getPERIODO());
                }
            }
        }
    }

    public void cargarSpinerDepartamentos(ArrayList<String> datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDepartamento.setAdapter(adapter);
    }
    public void cargarSpinerProvincias(ArrayList<String> datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProvincia.setAdapter(adapter);
    }

    public void cargarSpinerDistritos(ArrayList<String> datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDistrito.setAdapter(adapter);
    }

    public void cargarSpinerPeriodos(ArrayList<String> datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPeriodo.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.marco_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_exportar:
                Intent intent = new Intent(MarcoActivity.this,ExportarActivity.class);
                intent.putExtra("idUsuario",idUsuario);
                intent.putExtra("permisoUsuario",permisoUsuario);
                startActivity(intent);
                return true;
            case R.id.menu_importar:
                Intent intent1 = new Intent(MarcoActivity.this,ImportarActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @SuppressLint("NewApi")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Está seguro que desea salir de la aplicación?")
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
    private void inicializarDatos() {
        marcos = new ArrayList<Marco>();
        itemMarcos = new ArrayList<ItemMarco>();
        departamentos = new ArrayList<String>();
        provincias = new ArrayList<String>();
        distritos = new ArrayList<String>();
        periodos = new ArrayList<String>();
        departamentos.add("Seleccione");
        data = new Data(this);
        data.open();
        marcos = data.getAllMarcos(idUsuario,Integer.parseInt(permisoUsuario));
        data.close();
        for(Marco marco : marcos){
            itemMarcos.add(new ItemMarco(marco.getID(),marco.getRUC(),marco.getRAZON_SOCIAL(),""));
            String departamento = marco.getDEPARTAMENTO();
            if(!departamentos.contains(departamento)){
                departamentos.add(departamento);
            }
        }
    }
}
