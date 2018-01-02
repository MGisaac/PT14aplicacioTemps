package com.isaac.pt14_maldonadoisaac.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.isaac.pt14_maldonadoisaac.R;
import com.isaac.pt14_maldonadoisaac.model.Bloc;

import java.util.List;

/**
 * Created by Isaac on 02/01/2018.
 */

public class CiutatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Bloc> blocList;

    public CiutatAdapter(List<Bloc> blocList) {
        this.blocList = blocList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_row_bloc, parent, false);

        return new BlocViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return blocList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final Bloc bloc = blocList.get(position);
        BlocViewHolder blocViewHolder = (BlocViewHolder) holder;

        blocViewHolder.hora.setText(bloc.getHora());
        blocViewHolder.temperatura.setText(bloc.getTemperatura());
        blocViewHolder.fredcalor.setText(""+bloc.isFredcalor());
    }

    static class BlocViewHolder extends RecyclerView.ViewHolder {

        TextView hora;
        TextView temperatura;
        TextView fredcalor;

        BlocViewHolder(View v) {
            super(v);
            hora = v.findViewById(R.id.hora);
            temperatura = v.findViewById(R.id.temperatura);
            fredcalor = v.findViewById(R.id.fredcalor);
        }
    }
}
