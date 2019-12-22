package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.stations.stationadapter;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.stations.stationmodel;

public class stationOfTheCross extends AppCompatActivity {
    private AdView mAdview;
    private Toolbar mtoolbar;
    private LinearLayout archdiocesabuja,archlagos,archbenin,august,wayofthecross;
    private DatabaseReference mref;
    private List<stationmodel> mlist;
    private stationadapter madapter;
    private RecyclerView mrecyclervies;
    private stationmodel mstationmodel;
    private  String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_of_the_cross);

        name="English";
        mAdview=findViewById(R.id.addstationofthecross);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarstationofthecross);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FrontPage.class));
                finish();
            }
        });

        wayofthecross=(LinearLayout)findViewById(R.id.wayofthecross);
        wayofthecross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(stationOfTheCross.this,wayofthecross.class));
                startActivity(intent);
            }
        });


        august=(LinearLayout)findViewById(R.id.augustinacommunity);
        august.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(stationOfTheCross.this,Augustinacommunity.class));
                startActivity(intent);
            }
        });
        archbenin=(LinearLayout)findViewById(R.id.benin);
        archbenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(stationOfTheCross.this,beninarch.class));
                startActivity(intent);
            }
        });

        archlagos=(LinearLayout)findViewById(R.id.lagos);
        archlagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(stationOfTheCross.this,lagosActivity.class));
                startActivity(intent);
            }
        });

        archdiocesabuja=(LinearLayout)findViewById(R.id.archabuja);
        archdiocesabuja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(stationOfTheCross.this,archdiocesabujaActivity.class));
                startActivity(intent);
            }
        });


        mlist=new ArrayList<>();
        mrecyclervies=(RecyclerView)findViewById(R.id.recystation);
        mrecyclervies.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        madapter=new stationadapter(getApplicationContext(),mlist, name);


        mlist.clear();

        mref=FirebaseDatabase.getInstance().getReference().child("Station");
        mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String body=dataSnapshot.child("body").getValue().toString();
                String title=dataSnapshot.child("title").getValue().toString();

                mstationmodel=new stationmodel(title,body);
                mlist.add(mstationmodel);
                madapter=new stationadapter(getApplicationContext(),mlist, name);
                mrecyclervies.setAdapter(madapter);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
