package com.example.administrador.encal.Fragments;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.administrador.encal.Adapters.VisitaAdapter;
import com.example.administrador.encal.Modelo.Data;
import com.example.administrador.encal.Pojos.Visita;
import com.example.administrador.encal.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisitaFragment extends Fragment {

    private ArrayList<Visita> visitas;
    private ArrayList<Integer> eliminados;

    private LinearLayoutManager linearLayoutManager;
    private VisitaAdapter visitaAdapter;
    private RecyclerView recyclerView;

    private FloatingActionButton btnAgregar;

    private TextView txtFechaFinal;
    private TextView txtHorafinal;
    private TextView txtResultadoFinal;

    private Context context;
    private String idEmpresa;
    private Data data;

    int diaInicio;
    int mesInicio;
    int anioInicio;

    int horaInicio;
    int minutoInicio;

    int diaProx;
    int mesProx;
    int anioProx;

    int horaProx;
    int minutoProx;

    private  int ID;
    private  String ID_EMPRESA;
    private  int V_NRO;
    private  int V_DIA;
    private  int V_MES;
    private  int V_ANIO;
    private  int V_HORA;
    private  int V_MINUTO;
    private  String V_RESULTADO;
    private  String V_RESULTADO_O;
    private  int V_PROX_VIS_DIA;
    private  int V_PROX_VIS_MES;
    private  int V_PROX_VIS_ANIO;
    private  int V_PROX_VIS_HORA;
    private  int V_PROX_VIS_MINUTO;

    public VisitaFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public VisitaFragment(String idEmpresa, Context context) {
        this.idEmpresa = idEmpresa;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_visita, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.visita_recycler);
        txtResultadoFinal = (TextView) rootView.findViewById(R.id.visita_txtResultadoFinal);
        txtFechaFinal = (TextView) rootView.findViewById(R.id.visita_txtFechaResulFinal);
        txtHorafinal = (TextView) rootView.findViewById(R.id.visita_txtHoraResulFinal);
        btnAgregar = (FloatingActionButton) rootView.findViewById(R.id.visitas_btnAgregarVisita);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarDatos();
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        visitaAdapter = new VisitaAdapter(visitas, context, new VisitaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int pos) {
//                if(visitas.get(pos).getR_VISITA().equals("")){
//                    PopupMenu popupMenu = new PopupMenu(context,view);
//                    popupMenu.getMenuInflater().inflate(R.menu.menu_visita,popupMenu.getMenu());
//                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                        @Override
//                        public boolean onMenuItemClick(MenuItem item) {
//                            switch(item.getItemId()){
//                                case R.id.opcion_editar:
//                                    editarVisita(pos);
//                                    break;
////                                case R.id.opcion_eliminar:
////                                    eliminarVisita(pos);
////                                    break;
//                                case R.id.opcion_finalizar:
//                                    finalizarVisita(pos);
//                                    break;
//                            }
//                            return true;
//                        }
//                    });
//                    popupMenu.show();
//                }
            }
        });
        recyclerView.setAdapter(visitaAdapter);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numVisitas = visitas.size();
                if(numVisitas > 0 ){
                    if(!visitas.get(numVisitas - 1).getV_RESULTADO().equals("")){
                        agregarVisita();
                    }else{
                        Toast.makeText(context, "DEBE FINALIZAR LA VISITA ACTUAL", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    agregarVisita();
                }
            }
        });
    }

    public void agregarVisita(){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_agregar_visita, null);
        final LinearLayout lytDialog = (LinearLayout) dialogView.findViewById(R.id.dialog_agregar_visita_lyt);
        final TextView txtNumero = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtNumero);
        final TextView txtFechaI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtFI);
        final TextView txtHoraI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtHI);

        txtFechaI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendario = Calendar.getInstance();
                int yy = calendario.get(Calendar.YEAR);
                int mm = calendario.get(Calendar.MONTH);
                int dd = calendario.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        diaInicio = dayOfMonth;
                        mesInicio = monthOfYear + 1;
                        anioInicio = year;
                        String fecha = checkDigito(diaInicio) +"/"+checkDigito(mesInicio)
                                +"/"+checkDigito(anioInicio);
                        txtFechaI.setText(fecha);

                    }
                }, yy, mm, dd);
                datePicker.show();
            }
        });

        txtHoraI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendario = Calendar.getInstance();
                int hh = calendario.get(Calendar.HOUR_OF_DAY);
                int mm = calendario.get(Calendar.MINUTE);

                TimePickerDialog timePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                        String hora = checkDigito(hourofDay) +":"+checkDigito(minute);
                        txtHoraI.setText(hora);
                        horaInicio = hourofDay;
                        minutoInicio = minute;
                    }
                }, hh, mm,true);
                timePicker.show();
            }
        });

        alert.setTitle("AGREGAR VISITA");
        alert.setView(dialogView);
        alert.setPositiveButton("Agregar",null);
        alert.setNegativeButton("Cancelar",null);
        final AlertDialog alertDialog = alert.create();

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Calendar c = Calendar.getInstance();
                diaInicio = c.get(Calendar.DAY_OF_MONTH);
                mesInicio = c.get(Calendar.MONTH) + 1;
                anioInicio = c.get(Calendar.YEAR);
                horaInicio = c.get(Calendar.HOUR_OF_DAY);
                minutoInicio = c.get(Calendar.MINUTE);

                txtNumero.setText(checkDigito((visitaAdapter.getItemCount() + 1)));
                txtFechaI.setText(checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio));
                txtHoraI.setText(checkDigito(horaInicio) + ":" + checkDigito(minutoInicio));
                Button btnAdd = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO Do something
                        boolean valido =true;
                        String mensaje = "";
                        boolean vFechaInicio = true, vHoraInicio = true;
                        if(visitas.size() > 0){
                            int y = Integer.parseInt(visitas.get(visitas.size()-1).getV_ANIO());
                            int m = Integer.parseInt(visitas.get(visitas.size()-1).getV_MES());
                            int d = Integer.parseInt(visitas.get(visitas.size()-1).getV_DIA());

                            Date fi1 = new Date(y,m,d);
                            Date fi2 = new Date(anioInicio,mesInicio,diaInicio);
                            String sfi1 = checkDigito(d) + "/" + checkDigito(m) + "/" + checkDigito(y);
                            String sfi2 = checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio);
                            if(fi2.before(fi1)){
                                vFechaInicio = false;
                                if(mensaje.equals("")) mensaje = "FECHA: LA FECHA DE LA NUEVA VISITA NO DEBE SER MENOR A LA VISITA ANTERIOR";
                            }
                        }

                        valido = vFechaInicio;
                        if(valido){
                            Visita visita = new Visita();
                            visita.setID_EMPRESA(idEmpresa);
                            visita.setV_NRO(String.valueOf(visitaAdapter.getItemCount()+1));
                            visita.setV_DIA(diaInicio+"");
                            visita.setV_MES(mesInicio+"");
                            visita.setV_ANIO(anioInicio + "");
                            visita.setV_HORA(horaInicio +"");
                            visita.setV_MINUTO(minutoInicio + "");
                            visitas.add(visita);
                            txtResultadoFinal.setText("");
                            txtFechaFinal.setText("");
                            txtFechaFinal.setOnClickListener(null);
//                            rgEstadoEnvio.clearCheck();
                            recyclerView.getAdapter().notifyDataSetChanged();
                            alertDialog.dismiss();
                        }else Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        alertDialog.show();
    }

    public void cargarDatos(){
        visitas = new ArrayList<Visita>();
        data = new Data(context);
        data.open();
        if(data.existenVisitas(idEmpresa)){
            visitas = data.getVisitas(idEmpresa);
        }
        data.close();
    }
    public void guardarDatos(){}
    public boolean validar(){
        //revisarcampos
        boolean valido = true;
        //llenarMapaVariables();
        return valido;
    }

    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}
