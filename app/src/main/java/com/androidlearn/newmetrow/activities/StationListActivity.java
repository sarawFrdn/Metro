package com.androidlearn.newmetrow.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidlearn.newmetrow.R;
import com.androidlearn.newmetrow.adapter.StationsAdapter;
import com.androidlearn.newmetrow.databinding.ActivityStationListBinding;
import com.androidlearn.newmetrow.modeles.Stations;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StationListActivity extends AppCompatActivity {
    ActivityStationListBinding binding;
    Bundle bundle;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStationListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();

        if(bundle != null )
        {
            binding.txtLine.setText(bundle.getString("title"));
            binding.txtLineEnglish.setText(bundle.getString("englishName"));
            id =  bundle.getInt("id");
            getStations(id);
        }
       binding.imgBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
    }

    public void getStations(int lineId){

        binding.progressStation.setVisibility(View.VISIBLE);
        String url = "https://androidsupport.ir/pack/metro/getStations.php";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("onResponse",response);
                binding.progressStation.setVisibility(View.GONE);

                try {
                    JSONArray array = new JSONArray(response);

                    ArrayList<Stations> stationsArrayList = new ArrayList<>();
                    for(int i=0 ; i< array.length() ; i++)
                    {

                        JSONObject obj = array.getJSONObject(i);
                        Stations stations = new Stations();
                        stations.setId(obj.getString("id"));
                        stations.setLineId(obj.getString("LineId"));
                        stations.setOrderID(obj.getString("OrderID"));
                        stations.setStation_Duration(obj.getString("Station_Duration"));
                        stations.setTitle(obj.getString("Title"));
                        stations.setTitle_english(obj.getString("Title_English"));
                        stations.setCreossLine_ID(obj.getString("CrossLine_ID"));
                        stations.setAddr(obj.getString("addr"));
                        stations.setEscalator(obj.getString("escalator"));
                        stations.setAtm(obj.getString("atm"));
                        stations.setTaxi(obj.getString("taxi"));
                        stations.setBus(obj.getString("bus"));
                        stations.setPhone(obj.getString("phone"));
                        stations.setWater(obj.getString("water"));
                        stations.setLost(obj.getString("lost"));
                        stations.setParking(obj.getString("parking"));
                        stations.setElevator(obj.getString("elevator"));
                        stations.setLatitude(obj.getString("latitude"));
                        stations.setLongitude(obj.getString("longitude"));

                        stationsArrayList.add(stations);

                    }
                    StationsAdapter stationsAdapter = new StationsAdapter(getApplicationContext(), stationsArrayList);
                    binding.recyclerStations.setAdapter(stationsAdapter);

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
                    binding.recyclerStations.setLayoutManager(linearLayoutManager);



                } catch (JSONException e) {
                    e.printStackTrace();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("onErrorResponse",error.getMessage().toString());
                binding.progressStation.setVisibility(View.GONE);
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("id",String.valueOf(lineId));
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }

}