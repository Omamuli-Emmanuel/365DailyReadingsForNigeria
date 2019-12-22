package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Ekpereuka;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.newIgbo;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.stations.stationadapter;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.stations.stationmodel;

public class EkpereActivity extends AppCompatActivity {
    private AdView mAdview;
    private Toolbar mtoolbar;
    private DatabaseReference mref;
    private List<stationmodel> mlist;
    private stationadapter madapter;
    private RecyclerView mrecyclervies;
    private stationmodel mstationmodel;
    private  String name;
    private ProgressBar mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekpere);

        name="igbo";

        mp=findViewById(R.id.akperee);
        mp.setVisibility(View.VISIBLE);

        mAdview=findViewById(R.id.addekpereuka);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarekpereuka);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               // startActivity(new Intent(getApplicationContext(),newIgbo.class));
                finish();
            }
        });

        mlist=new ArrayList<>();
        mrecyclervies=(RecyclerView)findViewById(R.id.recyekpere);
        mrecyclervies.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        madapter=new stationadapter(getApplicationContext(),mlist, name);


        mlist.clear();

        mref= FirebaseDatabase.getInstance().getReference().child("EkpereUka");
        mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String body=dataSnapshot.child("body").getValue().toString();
                String title=dataSnapshot.child("title").getValue().toString();

                mp.setVisibility(View.GONE);

                mstationmodel=new stationmodel(title,body);
                mlist.add(mstationmodel);
                madapter=new stationadapter(getApplicationContext(),mlist,name);
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
}
