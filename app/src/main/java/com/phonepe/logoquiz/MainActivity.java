package com.phonepe.logoquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.phonepe.Utils;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvLogos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvLogos = findViewById(R.id.rvLogos);
        try {
            JSONArray jsonArray = new JSONArray(Utils.loadJSONFile(this));
            rvLogos.setLayoutManager(new GridLayoutManager(this, 3));
            rvLogos.setAdapter(new LogosAdapter(jsonArray, this));
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

    }


}