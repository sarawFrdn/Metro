package com.androidlearn.newmetrow.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidlearn.newmetrow.adapter.LinesAdapter;
import com.androidlearn.newmetrow.databinding.ActivityMainBinding;
import com.androidlearn.newmetrow.modeles.Lines;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.progressLines.setVisibility(View.VISIBLE);
        String url="http://androidsupport.ir/pack/metro/getLines.php";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                binding.progressLines.setVisibility(View.GONE);
                Log.e("onResponse",response);
                try {
                    JSONArray array = new JSONArray(response);

                    ArrayList<Lines> linesList = new ArrayList<>();

                    for(int i=0 ; i<array.length() ; i++){
                        JSONObject obj = array.getJSONObject(i);
                        String title = obj.getString("title");
                        int id = obj.getInt("id");
                        String englishTitle = obj.getString("EnglishTitle");

                        Log.e("title",title);
                        Log.e("id", String.valueOf(id));
                        Log.e("engTitle",englishTitle);
                        Lines lines = new Lines(id, title, englishTitle);

                        linesList.add(lines);

                    }
                    LinesAdapter adapter = new LinesAdapter(getApplicationContext(),linesList);
                    binding.recyclerViewLines.setAdapter(adapter);

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
                    binding.recyclerViewLines.setLayoutManager(linearLayoutManager);


                } catch (JSONException e)
                {
                    e.printStackTrace();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                binding.progressLines.setVisibility(View.GONE);
                Log.e("onErrorResponse", error.getMessage().toString());
            }
        });

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);


    }



}