package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.appreciation.appreciationadapter;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.appreciation.appreciationmodel;

public class Appreciation extends AppCompatActivity {
    private DatabaseReference mappreciation;
    private List<appreciationmodel> mlist;
    private appreciationadapter madapter;
    private appreciationmodel mappreciationmodel;
    private RecyclerView mrecyclerview;
    private AdView mAdview;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appreciation);

        mAdview = findViewById(R.id.appadd);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar = findViewById(R.id.toolbarapp);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FrontPage.class));
                finish();
            }
        });


        mlist = new ArrayList<>();
        mrecyclerview = findViewById(R.id.mrecyapp);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        madapter = new appreciationadapter(getApplicationContext(), mlist);
        mrecyclerview.setAdapter(madapter);

        mlist.clear();

        mappreciation = FirebaseDatabase.getInstance().getReference().child("Appreciation");
        mappreciation.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String body2 = dataSnapshot.child("bodybelow").getValue().toString();
                String body = dataSnapshot.child("bodytop").getValue().toString();
                String contact = dataSnapshot.child("contact").getValue().toString();


                mappreciationmodel = new appreciationmodel(body2, contact, body);
                mlist.add(mappreciationmodel);
                mrecyclerview.setAdapter(madapter);
                madapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
