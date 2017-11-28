package com.example.hnino.consumingopendata;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hnino.consumingopendata.entities.CultivoIlicito;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CultivoRecyclerViewAdapter extends RecyclerView.Adapter<CultivoRecyclerViewAdapter.ViewHolder> {
    private final List<CultivoIlicito> mValues;

    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @BindView(R.id.tvDepartamento)
        public TextView tvDepartamento;
        @BindView(R.id.tvMunicipio)
        public TextView tvMunicipio;
        @BindView(R.id.tvDosMilUno)
        public TextView tvDosMilUno;

        @BindView(R.id.tvDosMilDos)
        public TextView tvDosMilDos;
        @BindView(R.id.tvDosMilTres)
        public TextView tvDosMilTres;
        @BindView(R.id.tvDosMilCuatro)
        public TextView tvDosMilCuatro;
        @BindView(R.id.tvDosMilCinco)
        public TextView tvDosMilCinco;
        @BindView(R.id.tvDosMilSeis)
        public TextView tvDosMilSeis;

        public CultivoIlicito mItem;
        public View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            ButterKnife.bind(this, view);
        }

    }

    public CultivoRecyclerViewAdapter(List<CultivoIlicito> items) {
        this.mValues = items;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cultivo, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mItem = this.mValues.get(position);
        holder.tvDepartamento.setText((this.mValues.get(position)).getDepartamento());
        holder.tvMunicipio.setText((this.mValues.get(position)).getMunicipio());
        holder.tvDosMilUno.setText((this.mValues.get(position)).get2001());
        holder.tvDosMilDos.setText((this.mValues.get(position)).get2002());
        holder.tvDosMilTres.setText((this.mValues.get(position)).get2003());
        holder.tvDosMilCuatro.setText((this.mValues.get(position)).get2004());
        holder.tvDosMilCinco.setText((this.mValues.get(position)).get2005());
        holder.tvDosMilSeis.setText((this.mValues.get(position)).get2006());
    }

    public int getItemCount() {
        if (this.mValues != null) {
            return this.mValues.size();
        } else {
            return 0;
        }

    }
}
