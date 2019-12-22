package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase.Englishentity;

public class ReadReadings extends AppCompatActivity {
    private String mreadingkey;
    private boolean connected = false;
    private LinearLayout mscroll;
    private String Current_date;
    private DatabaseReference mcheck,mcalendar;
    private ProgressBar mp;
    private AdView mAdview;
    private Toolbar mtoolbar;
    private ImageView mg,mc,pra,bul,cal;
    private TextView DateBold, Bodydatenorma, Boldcollet, bodycollet, firstreadingbold, passagered, firstreadingbody;
    private TextView RedResponsialpsalm, Boldresponsialpsalm, BodyResponsialpsalm, secondReadingbold, Redsecondreading;
    private TextView bodysecondreading, alleuliabold, bodyallelluaia, Gospel, redGospel, bodygospel, boldprayerofthefaithful, bodyprayeroffaithful;
    private TextView Todayreflecion, bodytodayreflection, personaldevotion, bodypersonaldevotion;
    private String andoiddatess, DateBoldss, ssBodydatenorma, ssBoldcollet, ssbodycollet, ssfirstreadingbold, sspassagered, ssfirstreadingbody;
    private String ssRedResponsialpsalm, ssBoldresponsialpsalm, ssBodyResponsialpsalm, sssecondReadingbold, ssRedsecondreading;
    private String ssbodysecondreading, ssalleuliabold, ssbodyallelluaia, ssGospel, ssredGospel, ssbodygospel, ssboldprayerofthefaithful, ssbodyprayeroffaithful;
    private String ssTodayreflecion, ssbodytodayreflection, sspersonaldevotion, ssbodypersonaldevotion;
    private String mfrom;

    // private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_readings);

        SimpleDateFormat dateformts=new SimpleDateFormat("dd/MM/yyyy");
        Current_date=dateformts.format(new Date());

        mscroll=findViewById(R.id.readscroll);
        mp=findViewById(R.id.rotatereadreadings);
        mscroll.setVisibility(View.GONE);
        mp.setVisibility(View.VISIBLE);

        //initializing views
        mAdview = findViewById(R.id.addreadreadings);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar = findViewById(R.id.toolbarreadreadings);
        setSupportActionBar(mtoolbar);


        cal = (ImageView) findViewById(R.id.calendarread);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(ReadReadings.this, dailyReadings.class));
                startActivity(intent);
            }
        });

        bul = (ImageView)findViewById(R.id.bulletinread);
        bul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(ReadReadings.this, catholicbulletin.class));
                startActivity(intent);
            }
        });

        pra = (ImageView) findViewById(R.id.prsread);
        pra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(ReadReadings.this, prayerAfterComm.class));
                startActivity(intent);
            }
        });

        mg = (ImageView)findViewById(R.id.glosread);
        mg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(ReadReadings.this, gloria.class));
                startActivity(intent);
            }
        });

        mc= (ImageView) findViewById(R.id.cresread);
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(ReadReadings.this, creed.class));
                startActivity(intent);
            }
        });


        DateBold=(TextView)findViewById(R.id.Datebolds);
        Bodydatenorma =(TextView)findViewById(R.id.bodydates);
        Boldcollet =(TextView)findViewById(R.id.boldcollets);
        bodycollet=(TextView)findViewById(R.id.bodycollets);
        firstreadingbold =(TextView)findViewById(R.id.firstreadings);
        passagered =(TextView)findViewById(R.id.pasagereds);
        firstreadingbody=(TextView)findViewById(R.id.bodyfirstreadings);

        RedResponsialpsalm=(TextView)findViewById(R.id.redresponsialpsalms);
        Boldresponsialpsalm=(TextView)findViewById(R.id.boldresponses);
        BodyResponsialpsalm=(TextView)findViewById(R.id.bodyresponsialpsalms);
        secondReadingbold=(TextView)findViewById(R.id.SecondReadingbolds);
        Redsecondreading=(TextView)findViewById(R.id.redsecondreadings);
        bodysecondreading=(TextView)findViewById(R.id.bodysecondreadings);
        alleuliabold=(TextView)findViewById(R.id.Alleulias);
        bodyallelluaia=(TextView)findViewById(R.id.bodyAlleluias);
        Gospel=(TextView)findViewById(R.id.Gospelreadings);
        redGospel=(TextView)findViewById(R.id.redGospelreadings);
        bodygospel=(TextView)findViewById(R.id.bodyGospelreadings);
        boldprayerofthefaithful =(TextView)findViewById(R.id.prayerofthefaithfuls);
        bodyprayeroffaithful =(TextView)findViewById(R.id.bodyprayerofthefaithfuls);
        Todayreflecion=(TextView)findViewById(R.id.Todaysreflections);
        bodytodayreflection=(TextView)findViewById(R.id.bodyTodaysreflections);
        personaldevotion=(TextView)findViewById(R.id.personalDevotionals);
        bodypersonaldevotion=(TextView)findViewById(R.id.bodypersonalDevotionals);



        mcheck = FirebaseDatabase.getInstance().getReference().child("English_Readings").child(Current_date);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {

            mcheck.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    andoiddatess = dataSnapshot.child("mandroiddates").getValue().toString();
                    if(andoiddatess.equals(Current_date)){
                        mreadingkey=dataSnapshot.getKey();
                        Toast.makeText(getApplicationContext(),mreadingkey,Toast.LENGTH_LONG).show();
                        mp.setVisibility(View.GONE);
                        mscroll.setVisibility(View.VISIBLE);

                    }else{
                        Toast.makeText(getApplicationContext(),"wrong",Toast.LENGTH_LONG).show();
                        mp.setVisibility(View.GONE);
                        mscroll.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            connected = true;
        } else {
            connected = false;
            mp.setVisibility(View.GONE);
            mscroll.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(), "Internet Conection Unavailable", Toast.LENGTH_SHORT).show();
        }





    }
}
