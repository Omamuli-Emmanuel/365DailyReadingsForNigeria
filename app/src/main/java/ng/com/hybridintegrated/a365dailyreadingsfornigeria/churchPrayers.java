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

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Churchprayer.churchadapter;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.stations.stationadapter;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.stations.stationmodel;

public class churchPrayers extends AppCompatActivity {
    private LinearLayout prayerOne;
    private LinearLayout prayerTwo;
    private LinearLayout prayerThree;
    private LinearLayout prayerFour;
    private LinearLayout prayerFive;
    private LinearLayout prayerSix;
    private LinearLayout prayerSeven;
    private LinearLayout prayerEight;
    private LinearLayout prayerNine;
    private LinearLayout prayerTen;
    private LinearLayout prayerEleven;
    private LinearLayout prayerTwelve;
    private LinearLayout prayerThirteen;
    private LinearLayout prayerFourteen;
    private LinearLayout prayerFifteen;
    private LinearLayout prayerSixteen;
    private LinearLayout prayerSeventeen;
    private LinearLayout prayerEighteen;
    private LinearLayout prayerNineteen;
    private LinearLayout prayerTwenty;
    private LinearLayout prayerTwentyOne;
    private LinearLayout prayerTwentyTwo;
    private LinearLayout prayerTwentyThree;
    private LinearLayout prayerTwentyFour;
    private LinearLayout prayerTwentyFive;
    private LinearLayout prayerTwentySix;
    private LinearLayout prayerTwentySeven;
    private LinearLayout prayerTwentyEight;
    private LinearLayout prayerTwentyNine;
    private LinearLayout prayerThirty;
    private LinearLayout prayerThirtyOne;
    private LinearLayout prayerThirtyTwo;
    private LinearLayout prayerThirtyThree;
    private LinearLayout prayerThirtyFour;
    private LinearLayout prayerThirtyFive;
    private LinearLayout prayerThirtySix;
    private AdView mAdview;
    private Toolbar mtoolbar;
    private DatabaseReference mref;
    private List<stationmodel> mlist;
    private churchadapter madapter;
    private RecyclerView mrecyclervies;
    private stationmodel mstationmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_church_prayers);

        mAdview=findViewById(R.id.addchurchprayer);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarchurchprayer);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FrontPage.class));
                finish();
            }
        });




        mlist=new ArrayList<>();
        mrecyclervies=(RecyclerView)findViewById(R.id.recystationsd);
        mrecyclervies.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        madapter=new churchadapter(getApplicationContext(),mlist);


        mlist.clear();

        mref= FirebaseDatabase.getInstance().getReference().child("Churchprayers");
        mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String body=dataSnapshot.child("body").getValue().toString();
                String title=dataSnapshot.child("title").getValue().toString();

                mstationmodel=new stationmodel(title,body);
                mlist.add(mstationmodel);
                madapter=new churchadapter(getApplicationContext(),mlist);
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


        prayerThirtySix = (LinearLayout)findViewById(R.id.thirtySix);
        prayerThirtySix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerThirtySix.class));
                startActivity(intent);
            }
        });

        prayerThirtyFive = (LinearLayout)findViewById(R.id.thirtyFive);
        prayerThirtyFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerThirtyFive.class));
                startActivity(intent);
            }
        });

        prayerThirtyFour = (LinearLayout)findViewById(R.id.thirtyFour);
        prayerThirtyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerThirtyFour.class));
                startActivity(intent);
            }
        });

        prayerThirtyThree = (LinearLayout)findViewById(R.id.thirtyThree);
        prayerThirtyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerThirtyThree.class));
                startActivity(intent);
            }
        });

        prayerThirtyTwo = (LinearLayout)findViewById(R.id.thirtyTwo);
        prayerThirtyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerThirtyTwo.class));
                startActivity(intent);
            }
        });

        prayerThirtyOne = (LinearLayout)findViewById(R.id.thirtyOne);
        prayerThirtyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerThirtyOne.class));
                startActivity(intent);
            }
        });

        prayerThirty = (LinearLayout)findViewById(R.id.thirty);
        prayerThirty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerThirty.class));
                startActivity(intent);
            }
        });

        prayerTwentyNine = (LinearLayout)findViewById(R.id.twentyNine);
        prayerTwentyNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTwentyNine.class));
                startActivity(intent);
            }
        });

        prayerTwentyEight = (LinearLayout)findViewById(R.id.twentyEight);
        prayerTwentyEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTwentyEight.class));
                startActivity(intent);
            }
        });

        prayerTwentySeven = (LinearLayout)findViewById(R.id.twentySeven);
        prayerTwentySeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTwentySeven.class));
                startActivity(intent);
            }
        });

        prayerTwentySix = (LinearLayout)findViewById(R.id.twentySix);
        prayerTwentySix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTwentySix.class));
                startActivity(intent);
            }
        });


        prayerTwentyFive = (LinearLayout)findViewById(R.id.twentyFive);
        prayerTwentyFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTwentyFive.class));
                startActivity(intent);
            }
        });

        prayerTwentyFour = (LinearLayout)findViewById(R.id.twentyFour);
        prayerTwentyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTwentyFour.class));
                startActivity(intent);
            }
        });

        prayerTwentyThree = (LinearLayout)findViewById(R.id.twentyThree);
        prayerTwentyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTwentyThree.class));
                startActivity(intent);
            }
        });

        prayerTwentyTwo = (LinearLayout)findViewById(R.id.twentyTwo);
        prayerTwentyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTwentyTwo.class));
                startActivity(intent);
            }
        });

        prayerTwentyOne = (LinearLayout)findViewById(R.id.twentyOne);
        prayerTwentyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTwentyOne.class));
                startActivity(intent);
            }
        });

        prayerTwenty = (LinearLayout)findViewById(R.id.twenty);
        prayerTwenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTwenty.class));
                startActivity(intent);
            }
        });

        prayerNineteen = (LinearLayout)findViewById(R.id.nineteen);
        prayerNineteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerNineteen.class));
                startActivity(intent);
            }
        });

        prayerEighteen = (LinearLayout)findViewById(R.id.eighteen);
        prayerEighteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerEighteen.class));
                startActivity(intent);
            }
        });

        prayerSeventeen = (LinearLayout)findViewById(R.id.seventeen);
        prayerSeventeen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerSeventeen.class));
                startActivity(intent);
            }
        });

        prayerSixteen = (LinearLayout)findViewById(R.id.sixteen);
        prayerSixteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerSixteen.class));
                startActivity(intent);
            }
        });

        prayerFifteen = (LinearLayout)findViewById(R.id.fifteen);
        prayerFifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerFifteen.class));
                startActivity(intent);
            }
        });


        prayerFourteen = (LinearLayout)findViewById(R.id.fourteen);
        prayerFourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerFourteen.class));
                startActivity(intent);
            }
        });

        prayerThirteen = (LinearLayout)findViewById(R.id.thirteen);
        prayerThirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerThirteen.class));
                startActivity(intent);
            }
        });

        prayerTwelve = (LinearLayout)findViewById(R.id.twelve);
        prayerTwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTwelve.class));
                startActivity(intent);
            }
        });

        prayerEleven = (LinearLayout)findViewById(R.id.eleven);
        prayerEleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerEleven.class));
                startActivity(intent);
            }
        });

        prayerTen = (LinearLayout)findViewById(R.id.ten);
        prayerTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTen.class));
                startActivity(intent);
            }
        });

        prayerNine = (LinearLayout)findViewById(R.id.nine);
        prayerNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerNine.class));
                startActivity(intent);
            }
        });

        prayerEight = (LinearLayout)findViewById(R.id.eight);
        prayerEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerEight.class));
                startActivity(intent);
            }
        });

        prayerSeven = (LinearLayout)findViewById(R.id.seven);
        prayerSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerSeven.class));
                startActivity(intent);
            }
        });

        prayerSix = (LinearLayout)findViewById(R.id.six);
        prayerSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerSix.class));
                startActivity(intent);
            }
        });


        prayerFive = (LinearLayout)findViewById(R.id.five);
        prayerFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerFive.class));
                startActivity(intent);
            }
        });


        prayerFour = (LinearLayout)findViewById(R.id.four);
        prayerFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerFour.class));
                startActivity(intent);
            }
        });

        prayerThree = (LinearLayout)findViewById(R.id.three);
        prayerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerThree.class));
                startActivity(intent);
            }
        });

        prayerTwo = (LinearLayout)findViewById(R.id.two);
        prayerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerTwo.class));
                startActivity(intent);
            }
        });

        prayerOne = (LinearLayout)findViewById(R.id.one);
        prayerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(churchPrayers.this, prayerOne.class));
                startActivity(intent);
            }
        });
    }



}
