package com.example.iiitmstars.ui.aboutiiitm;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iiitmstars.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AboutIIITMFragment extends Fragment {
    private List<AboutIIITM> about_list;
    private AboutIIITMAdapter aboutIIITMAdapter;
    private RecyclerView recyclerView;
    private TextView about_us, ppp_iiitmanipur, mission_vision, facilities, visior_info;

    public AboutIIITMFragment(){

    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_aboutiiitm, container, false);
        List<String> about_iiitm = Arrays.asList("About Us", "PPP for IIIT Manipur", "Mission & Vision", "Facilities", "Visior's Info");
        about_us = root.findViewById(R.id.about_us);
        ppp_iiitmanipur = root.findViewById(R.id.ppp_for_iiitmaipur);
        mission_vision = root.findViewById(R.id.mission_vision);
        facilities = root.findViewById(R.id.facitities);
        visior_info = root.findViewById(R.id.visior_info);


        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(getContext(),AboutUsActivity.class));
            }
        });
        ppp_iiitmanipur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity( new Intent(getContext(),PPPForIIITManipurActivity.class));
            }
        });
        mission_vision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(getContext(),MissionVisionActivity.class));
            }
        });
        facilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(getContext(),FacilitiesActivity.class));
            }
        });
        visior_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(getContext(),VisionInfoActivity.class));
            }
        });


       /** about_list = new ArrayList<>();
        recyclerView = root.findViewById(R.id.about_iiitm);
        aboutIIITMAdapter = new AboutIIITMAdapter(about_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(aboutIIITMAdapter);

        for(String str : about_iiitm){
            AboutIIITM aboutIIITM = new AboutIIITM(str);
            about_list.add(aboutIIITM);
            aboutIIITMAdapter.notifyDataSetChanged();

        }*/
        return root;
    }
}