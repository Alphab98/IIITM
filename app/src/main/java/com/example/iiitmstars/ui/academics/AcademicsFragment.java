package com.example.iiitmstars.ui.academics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iiitmstars.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AcademicsFragment extends Fragment {
    private FirebaseFirestore firebaseFirestore;
    private List<Academics> about_list;
    private AcademicsAdapter academicsAdapter;
    private RecyclerView recyclerView;

    public AcademicsFragment(){

    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_academics, container, false);
        firebaseFirestore = FirebaseFirestore.getInstance();
        about_list = new ArrayList<>();
        recyclerView = root.findViewById(R.id.about_list_view);
        academicsAdapter = new AcademicsAdapter(about_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(academicsAdapter);
        firebaseFirestore.collection("about").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(DocumentChange documentChange : queryDocumentSnapshots.getDocumentChanges()){
                    //Toast.makeText(getContext(),""+ documentChange.getDocument().getId(),Toast.LENGTH_LONG).show();
                    about_list.add(new Academics(documentChange.getDocument().getId()));
                    academicsAdapter.notifyDataSetChanged();
                }


            }
        });




        return root;
    }
}