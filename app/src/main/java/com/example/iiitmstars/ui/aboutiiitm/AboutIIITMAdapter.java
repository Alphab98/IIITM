package com.example.iiitmstars.ui.aboutiiitm;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iiitmstars.R;

import java.util.List;

public class AboutIIITMAdapter extends RecyclerView.Adapter<AboutIIITMAdapter.ViewHolder> {
    public List<AboutIIITM> about_list;


    public AboutIIITMAdapter(List<AboutIIITM> about_list) {
        this.about_list = about_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_item, parent, false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AboutIIITM aboutIIITM = about_list.get(position);

        holder.textView.setText(aboutIIITM.getString());

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

