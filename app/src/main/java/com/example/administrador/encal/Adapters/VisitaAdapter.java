package com.example.administrador.encal.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.administrador.encal.Pojos.Visita;
import com.example.administrador.encal.R;
import java.util.ArrayList;

/**
 * Created by otin016 on 28/06/2017.
 */

public class VisitaAdapter extends RecyclerView.Adapter<VisitaAdapter.ViewHolder>{

    ArrayList<Visita> visitas;
    Context context;
    OnItemClickListener onItemClickListener;

    public VisitaAdapter(ArrayList<Visita> visitas, Context context, OnItemClickListener onItemClickListener) {
        this.visitas = visitas;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int i);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_visita,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtNumero.setText(visitas.get(position).getV_NRO());
        holder.txtFecha.setText(checkDigito(Integer.parseInt(visitas.get(position).getV_DIA())) + "/" +
                checkDigito(Integer.parseInt(visitas.get(position).getV_MES())) + "/" +
                checkDigito(Integer.parseInt(visitas.get(position).getV_ANIO()))
        );
        holder.txtHoraInicio.setText(checkDigito(Integer.parseInt(visitas.get(position).getV_HORA())) + ":"
                + checkDigito(Integer.parseInt(visitas.get(position).getV_MINUTO())));
        if(!visitas.get(position).getV_RESULTADO().equals("")){
            holder.txtResultado.setText(context.getResources().getStringArray(R.array.array_resultado_visita)[Integer.parseInt(visitas.get(position).getV_RESULTADO())]);
        }else{
            holder.txtResultado.setText("No finalizado");
        }
        if(!visitas.get(position).getV_PROX_VIS_DIA().equals("")){
            holder.txtFechaProxVisita.setText(checkDigito(Integer.parseInt(visitas.get(position).getV_PROX_VIS_DIA())) + "/" +
                    checkDigito(Integer.parseInt(visitas.get(position).getV_PROX_VIS_MES())) + "/" +
                    checkDigito(Integer.parseInt(visitas.get(position).getV_PROX_VIS_ANIO())));
            holder.txtHoraProxVisita.setText(checkDigito(Integer.parseInt(visitas.get(position).getV_PROX_VIS_HORA())) +
                    ":" + checkDigito(Integer.parseInt(visitas.get(position).getV_PROX_VIS_MINUTO())));
        }else{
            holder.txtFechaProxVisita.setText("-/-/-");
            holder.txtHoraProxVisita.setText("-:-");
        }
        holder.cardViewVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return visitas.size();
    }

    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNumero;
        TextView txtFecha;
        TextView txtHoraInicio;
        TextView txtResultado;
        TextView txtFechaProxVisita;
        TextView txtHoraProxVisita;
        CardView cardViewVisita;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNumero = (TextView) itemView.findViewById(R.id.txt_item_visita_numero);
            txtFecha = (TextView) itemView.findViewById(R.id.txt_item_visita_fecha);
            txtHoraInicio = (TextView) itemView.findViewById(R.id.txt_item_visita_horai);
            txtResultado = (TextView) itemView.findViewById(R.id.txt_item_visita_resultado);
            txtFechaProxVisita = (TextView) itemView.findViewById(R.id.txt_item_visita_fprox);
            txtHoraProxVisita = (TextView) itemView.findViewById(R.id.txt_item_visita_hprox);
            cardViewVisita = (CardView) itemView.findViewById(R.id.cardview_visita);
        }
    }

}
