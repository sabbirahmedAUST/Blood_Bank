package com.example.blood_bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class show_ambulance extends AppCompatActivity  {
    private RecyclerView recyclerView;
    private AmbulanceAdapter adapter;
    private List<Ambulance> profileList;
    private ProgressBar progressBar;

    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ambulance);


        progressBar = findViewById(R.id.progressbar);
        recyclerView = findViewById(R.id.recyclerview_products);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        profileList = new ArrayList<>();
        adapter = new AmbulanceAdapter(this, profileList);
        recyclerView.setAdapter(adapter);

        String district="Noakhali District";

        db = FirebaseFirestore.getInstance();

        db.collection("Ambulance")
                .whereEqualTo("district",district)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {



                        if(!queryDocumentSnapshots.isEmpty()){

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                            for(DocumentSnapshot d : list){

                                Ambulance p = d.toObject(Ambulance.class);
                                profileList.add(p);

                            }

                            adapter.notifyDataSetChanged();

                        }


                    }
                });
    }
}