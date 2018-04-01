package com.example.android.intangantira_1202154351_modul6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Intan Gantira on 4/1/2018.
 */

public class homes extends Fragment {
    //deklarasi variable
    RecyclerView nRecView;
    DatabaseReference nDatabaseRef;
    ArrayList<databasedua> list;
    adapterdua adapterD;

    public homes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homes, container, false);
        nRecView = view.findViewById(R.id.inirecyclerview2);
        list = new ArrayList<>();
        nDatabaseRef = FirebaseDatabase.getInstance().getReference().child("post");
        adapterD = new adapterdua(list, this.getContext());

        //menampilkan recyclerview nya
        nRecView.setHasFixedSize(true);
        nRecView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        nRecView.setAdapter(adapterD);
        //listener apabila nilai yang terdapat pada virebase berubah
        nDatabaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //mendapatkan nilai dari post yang diunggah
                databasedua nPost = dataSnapshot.getValue(databasedua.class);
                nPost.key = dataSnapshot.getKey();
                list.add(nPost);
                adapterD.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }

}
