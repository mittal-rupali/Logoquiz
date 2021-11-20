package com.phonepe.logoquiz;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class LogoNameAdapter extends RecyclerView.Adapter<LogoNameAdapter.LogoNameViewHolder> {

    public String  logoName;

    public LogoNameAdapter(String name) {
        logoName = name;
    }

    @NonNull
    @Override
    public LogoNameAdapter.LogoNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_logo_name,
                parent, false);
        return new LogoNameAdapter.LogoNameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogoNameAdapter.LogoNameViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return logoName.length();
    }

    public static class LogoNameViewHolder extends RecyclerView.ViewHolder {
        TextView tvChar;

        public LogoNameViewHolder(@NonNull View itemView) {
            super(itemView);
            tvChar = itemView.findViewById(R.id.tvChar);
        }
    }
}

