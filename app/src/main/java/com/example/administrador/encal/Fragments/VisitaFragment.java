package com.example.administrador.encal.Fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrador.encal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisitaFragment extends Fragment {

    private String idEmpresa;
    private Context context;

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
        View rootview = inflater.inflate(R.layout.fragment_visita, container, false);
        return rootview;
    }

    public void cargardatos(){}
    public void guardarDatos(){}
    public boolean validar(){
        //revisarcampos
        boolean valido = true;
        //llenarMapaVariables();
        return valido;
    }

}
