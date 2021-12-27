package com.androidlearn.newmetrow.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlearn.newmetrow.R;
import com.androidlearn.newmetrow.activities.StationListActivity;
import com.androidlearn.newmetrow.config.AppConfig;
import com.androidlearn.newmetrow.modeles.Lines;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LinesAdapter extends RecyclerView.Adapter<LinesAdapter.LinesVH> {

    ArrayList<Lines> linesList;
    Context context;
    LayoutInflater layoutInflater;

    AppConfig appConfig;

    public LinesAdapter(Context context, ArrayList<Lines> lines){
        linesList = lines ;
        this.context = context ;
        layoutInflater = LayoutInflater.from(context);
        appConfig = new AppConfig(context);
    }


    @NonNull
    @Override
    public LinesVH onCreateViewHolder(@Nullable ViewGroup parent, int viewType) {

        View view =layoutInflater.inflate(R.layout.lines_row, parent, false);
        return new LinesVH(view);
    }

    @Override
    public void onBindViewHolder( LinesVH holder, int position) {

        Lines lines = linesList.get(position);
        holder.txt_title.setText(lines.getTitle());
        holder.txt_english_title.setText(lines.getEnglishTitle());

        switch (lines.getId())
        {
            case 1 :
                holder.rel_lines.setBackgroundResource(R.color.design_default_color_error);
            break;

            case 2 :
                holder.rel_lines.setBackgroundResource(R.color.purple_700);
                break;

            case 3 :
                holder.rel_lines.setBackgroundResource(R.color.teal_200);
                break;

            case 4 :
                holder.rel_lines.setBackgroundResource(android.R.color.holo_orange_light);
                break;

            case 5 :
                holder.rel_lines.setBackgroundResource(android.R.color.holo_green_dark);
                break;

            case 6 :
                holder.rel_lines.setBackgroundResource(android.R.color.holo_red_light);
                break;

            case 7 :
                holder.rel_lines.setBackgroundResource(android.R.color.holo_purple);
                break;
        }

        holder.rel_lines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                appConfig.saveStation(lines.getTitle(), lines.getEnglishTitle());
                Intent intent = new Intent(context , StationListActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id",lines.getId());
                intent.putExtra("title",lines.getTitle());
                intent.putExtra("englishName",lines.getEnglishTitle());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return linesList.size();
    }

    static class LinesVH extends RecyclerView.ViewHolder{

       TextView txt_title;
       TextView txt_english_title;
       RelativeLayout rel_lines;

        public LinesVH( View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_english_title = itemView.findViewById(R.id.txt_english_title);
            rel_lines = itemView.findViewById(R.id.rel_lines);
        }
    }


}
