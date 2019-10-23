package com.example.iiitmstars.ui.people;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iiitmstars.R;
import com.example.iiitmstars.ui.academics.Academics;
import com.example.iiitmstars.ui.academics.AcademicsActivity;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    public List<Student> about_list;
    private Context context;


    public StudentAdapter(List<Student> about_list) {
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
        final Student student = about_list.get(position);

        holder.textView.setText(student.getString());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AcademicsActivity.class);
                intent.putExtra("user_id", student.getString());
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
