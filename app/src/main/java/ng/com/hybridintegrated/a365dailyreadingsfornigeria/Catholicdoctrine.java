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

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Bulletin.bulletinadapter;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Bulletin.bulletinmodel;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Catholic_doctrines.doctrineadapter;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Catholic_doctrines.doctrinemodel;


public class Catholicdoctrine extends AppCompatActivity {
    private DatabaseReference mdoctrine;
    private List<doctrinemodel> mlist;
    private doctrineadapter madapter;
    private doctrinemodel mdoctrinemodel;
    private RecyclerView mrecyclerview;
    private ProgressBar mp;
    private AdView mAdview;
    private Toolbar mtoolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catholicdoctrine);
        mAdview=findViewById(R.id.addcatholicdoctrine);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarcatholicdoctrine);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FrontPage.class));
                finish();
            }
        });

        mp=(ProgressBar)findViewById(R.id.pps);

        mlist=new ArrayList<>();
        mrecyclerview=(RecyclerView)findViewById(R.id.recydoctrine);
        LinearLayoutManager ll=new LinearLayoutManager(this);
        ll.setReverseLayout(true);
        ll.setStackFromEnd(true);
        mrecyclerview.setLayoutManager(ll);
       /* mrecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        madapter=new doctrineadapter(getApplicationContext(),mlist);*/

        mrecyclerview.setAdapter(madapter);

        mrecyclerview.setVisibility(View.GONE);
        mp.setVisibility(View.VISIBLE);



        mdoctrine= FirebaseDatabase.getInstance().getReference().child("Catholic Doctrine");
        mdoctrine.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String questions=dataSnapshot.child("question").getValue().toString();
                String option1=dataSnapshot.child("body").getValue().toString();



                mdoctrinemodel=new doctrinemodel(questions,option1);
                mlist.add(mdoctrinemodel);
                madapter=new doctrineadapter(getApplicationContext(),mlist);
                mrecyclerview.setAdapter(madapter);

                mp.setVisibility(View.GONE);
                mrecyclerview.setVisibility(View.VISIBLE);

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



