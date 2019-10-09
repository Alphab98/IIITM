package com.example.iiitmstars.ui.academics;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iiitmstars.R;

import java.util.List;

public class AcademicsAdapter extends RecyclerView.Adapter<AcademicsAdapter.ViewHolder> {
    public List<Academics> about_list;
    private Context context;


    public AcademicsAdapter(List<Academics> about_list) {
        this.about_list = about_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_item, parent, false);
        context = parent.getContext();


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Academics academics = about_list.get(position);

        holder.textView.setText(academics.getString());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AcademicsActivity.class);
                intent.putExtra("user_id", academics.getString());
               context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return about_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;

        public TextView textView;


        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            textView = mView.findViewById(R.id.about_name);

        }
    }
}
