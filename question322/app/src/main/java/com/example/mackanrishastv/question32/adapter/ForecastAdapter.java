package com.example.mackanrishastv.question32.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mackanrishastv.question32.R;
import com.example.mackanrishastv.question32.model.Forecast;
import com.example.mackanrishastv.question32.model.Max;
import com.example.mackanrishastv.question32.model.Min;
import com.master.glideimageview.GlideImageView;

import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.myViewHolder> {

    private List<Forecast> forecastList;
    private Context context;

    public ForecastAdapter(List<Forecast> forecastList, Context context) {
        this.forecastList = forecastList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.glideImageView.loadImageUrl(forecastList.get(position).getImage().getUrl());

        String days = forecastList.get(position).getDateLabel();
        switch (days){
            case "今日":
                holder.txtViewDays.setText("今日");
                break;
            case "明日":
                holder.txtViewDays.setText("明日");
                break;
            case "明後日":
                holder.txtViewDays.setText("明後日");
                break;
        }
        holder.txtViewDate.setText(forecastList.get(position).getDate());
        holder.txtViewTelop.setText(forecastList.get(position).getTelop());

        Min min = forecastList.get(position).getTemperature().getMin();
        String minCelsius = "";
        if( min != null){
            minCelsius = min.getCelsius();
        } else {
            minCelsius = "??";
        }

        Max max = forecastList.get(position).getTemperature().getMax();
        String maxCelsius = "";
        if(max != null){
            maxCelsius = max.getCelsius();
        } else {
            maxCelsius = "??";
        }

        holder.txtViewCelsius.setText(minCelsius + "°C - " + maxCelsius + "°C");
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        GlideImageView glideImageView;
        TextView txtViewDays, txtViewDate, txtViewTelop, txtViewCelsius;

        public myViewHolder(View itemView) {
            super(itemView);

            glideImageView = (GlideImageView) itemView.findViewById(R.id.glideImageView);
            txtViewDays = (TextView) itemView.findViewById(R.id.txtViewDay);
            txtViewDate = (TextView) itemView.findViewById(R.id.txtViewDate);
            txtViewTelop = (TextView) itemView.findViewById(R.id.txtViewTelop);
            txtViewCelsius = (TextView) itemView.findViewById(R.id.txtViewCelcisus);

        }
    }
}
