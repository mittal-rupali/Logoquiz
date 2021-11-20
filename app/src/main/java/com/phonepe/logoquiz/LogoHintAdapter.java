package com.phonepe.logoquiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LogoHintAdapter extends RecyclerView.Adapter<LogoHintAdapter.LogoNameViewHolder> {

    public StringBuilder hint;

    public LogoHintAdapter(StringBuilder hint) {
        this.hint = hint;
    }

    @NonNull
    @Override
    public LogoHintAdapter.LogoNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_logo_name,
                parent, false);
        return new LogoHintAdapter.LogoNameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogoHintAdapter.LogoNameViewHolder holder, int position) {
        Character character = hint.charAt(position);
        holder.tvChar.setText(""+character);
    }

    @Override
    public int getItemCount() {
        return hint.length();
    }

    public static class LogoNameViewHolder extends RecyclerView.ViewHolder {
        TextView tvChar;

        public LogoNameViewHolder(@NonNull View itemView) {
            super(itemView);
            tvChar = itemView.findViewById(R.id.tvChar);
        }
    }
}

