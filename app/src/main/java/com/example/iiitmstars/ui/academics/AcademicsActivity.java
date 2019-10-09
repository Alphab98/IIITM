package com.example.iiitmstars.ui.academics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.iiitmstars.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AcademicsActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private List<Academics> about_list;
    private AcademicsAdapter academicsAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academics);
        firebaseFirestore = FirebaseFirestore.getInstance();
        about_list = new ArrayList<>();
        recyclerView = findViewById(R.id.about_home_view);
        academicsAdapter = new AcademicsAdapter(about_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(academicsAdapter);
        firebaseFirestore.collection("about").document(getIntent().getStringExtra("user_id")).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Map<String,Object> doc = documentSnapshot.getData();
                //Toast.makeText(getBaseContext(),""+doc.values(),Toast.LENGTH_LONG).show();
                for(Object x : doc.values()){
                    Academics academics = new Academics(x.toString());
                    about_list.add(academics);
                    academicsAdapter.notifyDataSetChanged();
                }

            }
        });
    }
}
