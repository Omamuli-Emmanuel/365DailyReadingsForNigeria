package ng.com.hybridintegrated.a365dailyreadingsfornigeria.HymnAudio;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collections;
import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.FrontPage;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.yoruba;

public class Hymn extends AppCompatActivity {
    private AdView mAdview;
    private Toolbar mtoolbar;

    private boolean connected = false;
    private DatabaseReference mentrance;
    private hymnviewmodel mdailymodel;
    private LiveData<List<hymnentity>> Alldata;
    private ProgressBar mp;
    private RecyclerView mrecy,mrecysearch;
    private String title,chbno,jsno,hymn,aboutsong,thumbimage,audio;
    private hymnadapter mentranceadapter;
    private String check="";
    private SearchView msearchv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hymn);

        mAdview=findViewById(R.id.addhymn);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarhymn);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FrontPage.class));
                finish();
            }
        });



        mdailymodel = ViewModelProviders.of(this).get(hymnviewmodel.class);
        mp= findViewById(R.id.rotateadvent);
        mrecy=findViewById(R.id.adventrecy);
        msearchv=findViewById(R.id.adventresearch);


        mrecy.setLayoutManager(new LinearLayoutManager(this));
        mrecy.setVisibility(View.GONE);
        mp.setVisibility(View.VISIBLE);


        mentrance = FirebaseDatabase.getInstance().getReference().child("Hymn");
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {

            mdailymodel.deletes();
            mentrance.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    title= dataSnapshot.child("title").getValue().toString();
                    chbno = dataSnapshot.child("cbno").getValue().toString();
                    jsno= dataSnapshot.child("jsno").getValue().toString();
                    hymn= dataSnapshot.child("hymn").getValue().toString();
                    aboutsong= dataSnapshot.child("aboutsong").getValue().toString();
                    //thumbimage= dataSnapshot.child("thumbimage").getValue().toString();
                    audio=dataSnapshot.child("audio").getValue().toString();


                    mp.setVisibility(View.GONE);
                    mrecy.setVisibility(View.VISIBLE);
                    // mrecysearch.setVisibility(View.GONE);

                    hymnentity m=new hymnentity(
                            0,title,chbno,jsno,hymn,aboutsong,audio
                    );

                    mdailymodel.inserts(m);


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
        }else {
            connected = false;
            mp.setVisibility(View.GONE);
            mrecy.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(), "Internet Connection is Unavailable", Toast.LENGTH_SHORT).show();
        }

        Alldata = mdailymodel.getAlldata();
        tunde();


        msearchv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mentranceadapter.getFilter().filter(s);
                return false;
            }
        });


    }

    private void tunde() {
        Alldata.observe(this, new Observer<List<hymnentity>>() {
            @Override
            public void onChanged(@Nullable List<hymnentity> hymnentities) {
                Collections.shuffle(hymnentities);
                mentranceadapter = new hymnadapter(getApplicationContext(),hymnentities);
                mrecy.setAdapter(mentranceadapter);
                mentranceadapter.notifyDataSetChanged();

            }
        });
    }
}
