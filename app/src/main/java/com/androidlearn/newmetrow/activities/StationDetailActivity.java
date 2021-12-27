package com.androidlearn.newmetrow.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.PorterDuff;
import android.os.Bundle;

import com.androidlearn.newmetrow.R;
import com.androidlearn.newmetrow.State;
import com.androidlearn.newmetrow.config.AppConfig;
import com.androidlearn.newmetrow.databinding.ActivityStationDetailBinding;
import com.androidlearn.newmetrow.databinding.ActivityStationListBinding;
import com.androidlearn.newmetrow.modeles.Stations;

public class StationDetailActivity extends AppCompatActivity {

    ActivityStationDetailBinding binding;
    Bundle bundle;
    Stations stations;
    AppConfig appConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityStationDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        appConfig = new AppConfig(getApplicationContext());

        bundle = getIntent().getExtras();
        stations = bundle.getParcelable("data");

        binding.txtStation.setText(stations.getTitle());
        binding.txtEnglishStation.setText((stations.getTitle_english()));
        binding.txtAddress.setText(stations.getAddr());
        binding.txtLinee.setText(appConfig.getTitle());
        binding.txtLineeEnglish.setText(appConfig.getEnglishTitle());

        switch (stations.getLineId())

        {
            case "1" :
                binding.relStation.setBackgroundResource(R.color.design_default_color_error);
                binding.linFeatures.setBackgroundResource(R.color.design_default_color_error);
                break;

            case "2" :
                binding.relStation.setBackgroundResource(R.color.purple_700);
                binding.linFeatures.setBackgroundResource(R.color.design_default_color_error);
                break;

            case "3" :
                binding.relStation.setBackgroundResource(R.color.teal_200);
                binding.linFeatures.setBackgroundResource(R.color.design_default_color_error);
                break;

            case "4" :
                binding.relStation.setBackgroundResource(android.R.color.holo_orange_light);
                binding.linFeatures.setBackgroundResource(R.color.design_default_color_error);
                break;

            case"5" :
                binding.relStation.setBackgroundResource(android.R.color.holo_green_dark);
                binding.linFeatures.setBackgroundResource(R.color.design_default_color_error);
                break;

            case "6" :
                binding.relStation.setBackgroundResource(android.R.color.holo_red_light);
                binding.linFeatures.setBackgroundResource(R.color.design_default_color_error);
                break;

            case "7" :
                binding.relStation.setBackgroundResource(R.color.purple_200);
                binding.linFeatures.setBackgroundResource(R.color.design_default_color_error);

                break;
        }

        if(Integer.parseInt(stations.getAtm()) == State.TRUE.getState()) {
          binding.txtAtm.setTextColor(getResources().getColor(R.color.white));
          binding.txtAtmEnglish.setTextColor(getResources().getColor(R.color.white));
        }else {
            binding.txtAtm.setTextColor(getResources().getColor(R.color.grey));
            binding.txtAtmEnglish.setTextColor(getResources().getColor(R.color.grey));
            binding.imgAtm.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.grey), PorterDuff.Mode.SRC_IN);
        }

        if(Integer.parseInt(stations.getParking()) == State.TRUE.getState()) {
            binding.txtParking.setTextColor(getResources().getColor(R.color.white));
            binding.txtParkingEnglish.setTextColor(getResources().getColor(R.color.white));
        }else {
            binding.txtParking.setTextColor(getResources().getColor(R.color.grey));
            binding.txtParkingEnglish.setTextColor(getResources().getColor(R.color.grey));
            binding.imgParking.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.grey), PorterDuff.Mode.SRC_IN);
        }













    }
}