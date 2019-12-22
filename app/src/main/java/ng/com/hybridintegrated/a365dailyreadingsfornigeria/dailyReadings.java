package ng.com.hybridintegrated.a365dailyreadingsfornigeria;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.EdoReading;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase.Englishentity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase.Englishviewmodel;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Hausadatabase.Hausa;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Igbodatabasse.igbo;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase.pidgin;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yoru;

public class dailyReadings extends AppCompatActivity {
    private boolean connected = false;
    private CalendarView mcal;
    private String andoiddate, DateBold, Bodydatenorma, Boldcollet, bodycollet, firstreadingbold, passagered, firstreadingbody;
    private String RedResponsialpsalm, Boldresponsialpsalm, BodyResponsialpsalm, secondReadingbold, Redsecondreading;
    private String bodysecondreading, alleuliabold, bodyallelluaia, Gospel, redGospel, bodygospel, boldprayerofthefaithful, bodyprayeroffaithful;
    private String Todayreflecion, bodytodayreflection, personaldevotion, bodypersonaldevotion;

    private DatabaseReference mcalendar;
    private Englishviewmodel mdailymodel;
    private LiveData<List<Englishentity>> Alldata;
    private ProgressBar mp;
    private int a=1;
    private AdView mAdview;
    private Toolbar mtoolbar;
    private LinearLayout ml;
    private String from;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_readings);

        mAdview = findViewById(R.id.adddailyreadings);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar = findViewById(R.id.toolbardailyreadings);
        setSupportActionBar(mtoolbar);
       /* mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FrontPage.class));
                finish();
            }
        });*/

        //connectig the viewmodel to activity
        mdailymodel = ViewModelProviders.of(this).get(Englishviewmodel.class);

        ml=findViewById(R.id.dl);
        mp = (ProgressBar)findViewById(R.id.rotate);
        mcal = (CalendarView) findViewById(R.id.cal);
        mcal.setVisibility(View.GONE);
        mp.setVisibility(View.VISIBLE);

        if(android.os.Build.VERSION.SDK_INT <=19){
            ViewGroup.LayoutParams params =mcal.getLayoutParams();
            params.height=300;
            ml.setLayoutParams(params);


        }


        mcalendar = FirebaseDatabase.getInstance().getReference().child("English_Readings");

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {

            mdailymodel.deletes();
           // Toast.makeText(getApplicationContext(), "deleting calendar", Toast.LENGTH_SHORT).show();
            mcalendar.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                    //retrieving English
                    andoiddate = dataSnapshot.child("mandroiddates").getValue().toString();
                    DateBold = dataSnapshot.child("mdates").getValue().toString();
                    Bodydatenorma = dataSnapshot.child("mbodydates").getValue().toString();
                    Boldcollet = dataSnapshot.child("mboldcollets").getValue().toString();
                    bodycollet = dataSnapshot.child("mbodycollets").getValue().toString();
                    firstreadingbold = dataSnapshot.child("mfirsts").getValue().toString();
                    passagered = dataSnapshot.child("mpassages").getValue().toString();
                    firstreadingbody = dataSnapshot.child("mboddyfirstss").getValue().toString();
                    RedResponsialpsalm = dataSnapshot.child("redresponsialss").getValue().toString();
                    Boldresponsialpsalm = dataSnapshot.child("mboldresponsialss").getValue().toString();
                    BodyResponsialpsalm = dataSnapshot.child("mbodyresponses").getValue().toString();
                    secondReadingbold = dataSnapshot.child("msecondreading").getValue().toString();
                    Redsecondreading = dataSnapshot.child("redsecondreading").getValue().toString();
                    bodysecondreading = dataSnapshot.child("bodysecondreading").getValue().toString();
                    alleuliabold = dataSnapshot.child("malleuias").getValue().toString();
                    bodyallelluaia = dataSnapshot.child("mbodyalleluias").getValue().toString();
                    Gospel = dataSnapshot.child("mgospele").getValue().toString();
                    redGospel = dataSnapshot.child("mredgospelss").getValue().toString();
                    bodygospel = dataSnapshot.child("mbodygospell").getValue().toString();
                    boldprayerofthefaithful = dataSnapshot.child("mprayerfaith").getValue().toString();
                    bodyprayeroffaithful = dataSnapshot.child("mbodyprayerfaith").getValue().toString();
                    Todayreflecion = dataSnapshot.child("mtodayreflectionbold").getValue().toString();
                    bodytodayreflection = dataSnapshot.child("mtodayreflectionbody").getValue().toString();
                    personaldevotion = dataSnapshot.child("mpersonaldevotion").getValue().toString();
                    bodypersonaldevotion = dataSnapshot.child("mbodypersonaldevotion").getValue().toString();


                    mp.setVisibility(View.GONE);
                    mcal.setVisibility(View.VISIBLE);
                    Englishentity m = new Englishentity(0, andoiddate, DateBold, Bodydatenorma, Boldcollet, bodycollet, firstreadingbold, passagered,
                            firstreadingbody, RedResponsialpsalm, Boldresponsialpsalm, BodyResponsialpsalm, secondReadingbold, Redsecondreading,
                            bodysecondreading, alleuliabold, bodyallelluaia, Gospel, redGospel, bodygospel, boldprayerofthefaithful, bodyprayeroffaithful,
                            Todayreflecion, bodytodayreflection, personaldevotion, bodypersonaldevotion
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
            connected = true;
        } else {
            connected = false;
            mp.setVisibility(View.GONE);
            mcal.setVisibility(View.VISIBLE);
            //Toast.makeText(getApplicationContext(), "No network", Toast.LENGTH_SHORT).show();
        }


        mcal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String year = String.valueOf(i);
                String month = String.valueOf(i1 + 1);
                String day = String.valueOf(i2);

                String com = day + "/" + month + "/" + year;
                Alldata = mdailymodel.getAlldata(com);


               // Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
                tunde(com);
                // Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();


            }
        });


    }


    private void tunde(final String com) {
        Alldata.observe(this, new Observer<List<Englishentity>>() {
            @Override
            public void onChanged(@Nullable List<Englishentity> dailyreadingentities) {
                if (dailyreadingentities == null || dailyreadingentities.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Readings Coming Soon", Toast.LENGTH_SHORT).show();
                } else {
                    int i = 0;
                    String from="loads";
                    String andoidates = dailyreadingentities.get(i).getMandroiddate();
                    String Datebolds = dailyreadingentities.get(i).getMdatebold();
                    String datebody = dailyreadingentities.get(i).getMbodydatenormal();
                    String boldcollets = dailyreadingentities.get(i).getMboldcollet();
                    String bodycolletss = dailyreadingentities.get(i).getMbodycollet();
                    String firstreadbold = dailyreadingentities.get(i).getMfirstreadingbold();
                    String passagereds = dailyreadingentities.get(i).getMpassagered();
                    String firstreadingbodys = dailyreadingentities.get(i).getMfirstreadingbody();
                    String redresponsialpsalm = dailyreadingentities.get(i).getMredResponsialpsalm();
                    String boldresponsialpsalm = dailyreadingentities.get(i).getMboldresponsialpsalm();
                    String bodyresponsialpsalm = dailyreadingentities.get(i).getBodyresponsialpsalm();
                    String secondreadingbold = dailyreadingentities.get(i).getMsecondreadingbold();
                    String redsecondreadingss = dailyreadingentities.get(i).getMredsecondreading();
                    String bodysecondreadings = dailyreadingentities.get(i).getMsecondreading();
                    String alleliabolds = dailyreadingentities.get(i).getMalleluiabold();
                    String bodyalleuias = dailyreadingentities.get(i).getMbodyallelluia();
                    String gospels = dailyreadingentities.get(i).getMgospel();
                    String redgospel = dailyreadingentities.get(i).getMredGospel();
                    String gospelbody = dailyreadingentities.get(i).getMbodygospel();
                    String boldprayeroffaithfuls = dailyreadingentities.get(i).getMboldprayerofthefaithful();
                    String bodyprayeroffaith = dailyreadingentities.get(i).getMbodyprayeroffaithful();
                    String todayreflections = dailyreadingentities.get(i).getMtodayreflection();
                    String bodytodayreflectionss = dailyreadingentities.get(i).getMbodytodayreflection();
                    String personaldevotionss = dailyreadingentities.get(i).getMpersonaldevotion();
                    String bodypersonaldevotionss = dailyreadingentities.get(i).getMbodypersonaldevotion();



                    Intent intent = new Intent(dailyReadings.this, Eachreadings.class);
                    intent.putExtra("from", from);
                    intent.putExtra("rdateboldd", Datebolds);
                    intent.putExtra("rdateebody", datebody);
                    intent.putExtra("rboldcollet", boldcollets);
                    intent.putExtra("rbodycolletss", bodycolletss);
                    intent.putExtra("rfirstreadbold", firstreadbold);
                    intent.putExtra("rpassagereds", passagereds);
                    intent.putExtra("rfirstreadingbodys", firstreadingbodys);
                    intent.putExtra("rredresponsialpsalm", redresponsialpsalm);
                    intent.putExtra("rboldresponsialpsalm", boldresponsialpsalm);
                    intent.putExtra("rbodyresponsialpsalm", bodyresponsialpsalm);
                    intent.putExtra("rsecondreadingbold", secondreadingbold);
                    intent.putExtra("rredsecondreadingss", redsecondreadingss);
                    intent.putExtra("rbodysecondreadings", bodysecondreadings);
                    intent.putExtra("ralleliabolds", alleliabolds);
                    intent.putExtra("rbodyalleuias", bodyalleuias);
                    intent.putExtra("rgospels", gospels);
                    intent.putExtra("rredgospel", redgospel);
                    intent.putExtra("rgospelbody", gospelbody);
                    intent.putExtra("rboldprayeroffaithfuls", boldprayeroffaithfuls);
                    intent.putExtra("rbodyprayeroffaith", bodyprayeroffaith);
                    intent.putExtra("rtodayreflections", todayreflections);
                    intent.putExtra("rbodytodayreflectionss", bodytodayreflectionss);
                    intent.putExtra("rpersonaldevotionss", personaldevotionss);
                    intent.putExtra("rbodypersonaldevotionss", bodypersonaldevotionss);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);


                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);

        if(a==1){
            startActivity(new Intent(this,FrontPage.class));
            finish();
        }

        if(item.getItemId()==R.id.pidgin){
           // startActivity(new Intent(this, pidgin.class));
            Intent i=new Intent(this, pidgin.class);
            i.putExtra("checks","mainpidgin");
            startActivity(i);



        }


        if(item.getItemId()==R.id.igbo){
            //startActivity(new Intent(this, igbo.class));
            Intent i=new Intent(this, igbo.class);
            i.putExtra("checks","mainigbo");
            startActivity(i);



        }

        if(item.getItemId()==R.id.Edo){
           // startActivity(new Intent(this, EdoReading.class));
            Intent i=new Intent(this, EdoReading.class);
            i.putExtra("checks","mainedo");
            startActivity(i);


        }
        if(item.getItemId()==R.id.hausa){
           // startActivity(new Intent(this, Hausa.class));
            Intent i=new Intent(this, Hausa.class);
            i.putExtra("checks","mainhausa");
            startActivity(i);


        }
        if(item.getItemId()==R.id.Yoruba){
            //startActivity(new Intent(this, yoru.class));
            Intent i=new Intent(this, yoru.class);
            i.putExtra("checks","mainyoru");
            startActivity(i);


        }

        //this is a product of Crude
        return true;

    }

}


