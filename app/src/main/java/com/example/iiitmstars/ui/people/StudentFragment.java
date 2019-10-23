package com.example.iiitmstars.ui.people;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iiitmstars.R;
import com.example.iiitmstars.ui.academics.Academics;
import com.example.iiitmstars.ui.academics.AcademicsAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class StudentFragment extends Fragment {
    private FirebaseFirestore firebaseFirestore;
    private List<Student> about_list;
    private StudentAdapter studentAdapter;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_student, container, false);
        firebaseFirestore = FirebaseFirestore.getInstance();
        about_list = new ArrayList<>();
        recyclerView = root.findViewById(R.id.student_list_view);
        studentAdapter = new StudentAdapter(about_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(studentAdapter);
        firebaseFirestore.collection("student").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentChange documentChange : queryDocumentSnapshots.getDocumentChanges()) {
                    //Toast.makeText(getContext(),""+ documentChange.getDocument().getId(),Toast.LENGTH_LONG).show();
                    about_list.add(new Student(documentChange.getDocument().getId()));
                    studentAdapter.notifyDataSetChanged();
                }


            }
        });


        return root;
    }


}
