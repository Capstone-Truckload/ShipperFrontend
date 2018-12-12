package com.capstone.shipperfrontend.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.capstone.shipperfrontend.R;
import com.capstone.shipperfrontend.models.Load;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrentLoadsActivity extends AppCompatActivity {
    private static final String TAG = "ViewDatabase";
    private String user;
    //private ListView Show;
    private FirebaseAuth auth;
    private RecyclerView show;
    String newName;
    String newOrigin;
    String newDestination;
    String newPrice;
    String newid;
    RecyclerView.Adapter mAdapter;
    ArrayList<Load> loads;

    private FirebaseAuth firebaseAuth;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_loads);

        loads = new ArrayList<>();
        Log.e("Load at beginning", loads.toString());

        show = (RecyclerView) findViewById(R.id.display);
        show.setHasFixedSize(true);
        show.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MainAdapter(loads);
        show.setAdapter(mAdapter);
        auth = FirebaseAuth.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser().getUid();
        reference = FirebaseDatabase.getInstance().getReference("loads");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> contactChildren = dataSnapshot.getChildren();

                for (DataSnapshot ds : contactChildren)
                {
                    String nName,nOrigin,nDestination,nPrice,nid;
                    Load help = new Load();
                    help.setName(ds.getValue(Load.class).getName());
                    help.setOrigin(ds.getValue(Load.class).getOrigin());
                    help.setDestination(ds.getValue(Load.class).getDestination());
                    help.setPrice(ds.getValue(Load.class).getPrice());
                    help.setId(ds.getValue(Load.class).getId());

                    Log.e("The load to store " ,""+ help);
                    Log.e("Count " ,""+ ds.getChildrenCount());
                    Log.e("Value " ,""+ ds.getValue());

                    nName = ds.getValue(Load.class).getName();
                    nOrigin = ds.getValue(Load.class).getOrigin();
                    nDestination = ds.getValue(Load.class).getDestination();
                    nPrice = ds.getValue(Load.class).getPrice();
                    nid = ds.getValue(Load.class).getId();

                    newName = nName;
                    newOrigin = nOrigin;
                    newDestination = nDestination;
                    newPrice = nPrice;
                    newid = nid;

                    Log.e("Name to store " ,newName);
                    Log.e("Origin to store " ,newOrigin);
                    Log.e("Destintation to store " ,newDestination);
                    Log.e("Price to store " ,newPrice);
                    Log.e("ID to store " ,newid);

                    Load temp = new Load (newName,newid,newOrigin,newDestination,newPrice);
                    loads.add(temp);

                    Log.e("Load at end", loads.toString());

                    Toast.makeText(getApplicationContext(),"we made it 1111 !", Toast.LENGTH_SHORT).show();

                    show.setAdapter(mAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
