package com.phonepe.logoquiz;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogosAdapter extends RecyclerView.Adapter<LogosAdapter.LogosViewHolder> {

    public JSONArray jsonArray;
    public MainActivity mainActivity;

    LogosAdapter(JSONArray jsonArray, MainActivity mainActivity) {
        this.jsonArray = jsonArray;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public LogosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.logos_adapter_layout,
                parent, false);
        return new LogosViewHolder(view, mainActivity);
    }

    @Override
    public void onBindViewHolder(@NonNull LogosViewHolder holder, int position) {
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            String uri = jsonObject.getString("imgUrl");
            Glide.with(mainActivity)
                    .load(uri)
                    .into(holder.ivLogo);

            holder.ivLogo.setOnClickListener(view -> {
                Intent intent = new Intent(mainActivity, LogoInfoActivity.class);
                intent.putExtra("pos",position);
                mainActivity.startActivity(intent);
            });
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public static class LogosViewHolder extends RecyclerView.ViewHolder {
        ImageView ivLogo;

        public LogosViewHolder(@NonNull View itemView, MainActivity mainActivity) {
            super(itemView);
            ivLogo = itemView.findViewById(R.id.ivLogo);
        }
    }
}
