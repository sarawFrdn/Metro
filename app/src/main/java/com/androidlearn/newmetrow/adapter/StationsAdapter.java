package com.androidlearn.newmetrow.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlearn.newmetrow.R;
import com.androidlearn.newmetrow.State;
import com.androidlearn.newmetrow.activities.StationDetailActivity;
import com.androidlearn.newmetrow.modeles.Stations;

import java.util.List;

public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.StationVH> {


    Context context;
    List<Stations> stationsList;
    LayoutInflater layoutInflater;

    public StationsAdapter(Context context , List<Stations> stationsList){
        this.stationsList = stationsList ;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public StationVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.stations_row, parent, false);


        return new StationVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StationVH holder, int position) {
        Stations stations = stationsList.get(position);
        holder.txt_title.setText(stations.getTitle());
        holder.txt_english_title.setText(stations.getTitle_english());
        switch (stations.getLineId())
        {
            case "1" :
                holder.rel_station.setBackgroundResource(R.color.design_default_color_error);
                break;

            case "2" :
                holder.rel_station.setBackgroundResource(R.color.purple_700);
                break;

            case "3" :
                holder.rel_station.setBackgroundResource(R.color.teal_200);
                break;

            case "4" :
                holder.rel_station.setBackgroundResource(android.R.color.holo_orange_light);
                break;

            case"5" :
                holder.rel_station.setBackgroundResource(android.R.color.holo_green_dark);
                break;

            case "6" :
                holder.rel_station.setBackgroundResource(android.R.color.holo_red_light);
                break;

            case "7" :
                holder.rel_station.setBackgroundResource(android.R.color.holo_purple);
                break;
        }
        Log.e("station",stations.getTitle() +" "+stations.getCreossLine_ID());

        if(Integer.parseInt(stations.getCreossLine_ID() ) >= State.TRUE.getState()){
          holder.img_crossLine.setVisibility(View.VISIBLE);
        }else{
            holder.img_crossLine.setVisibility(View.INVISIBLE);
        }

        holder.rel_station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(context, StationDetailActivity.class);
             intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data",stations);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return stationsList.size();
    }

    static class StationVH extends RecyclerView.ViewHolder{
        TextView txt_title;
        TextView txt_english_title;
        AppCompatImageView  img_crossLine;
        RelativeLayout rel_station;

        public StationVH(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_english_title = itemView.findViewById(R.id.txt_english_title);
            img_crossLine = itemView.findViewById(R.id.img_crossLine);
            rel_station = itemView.findViewById(R.id.rel_station);
        }
    }


}
