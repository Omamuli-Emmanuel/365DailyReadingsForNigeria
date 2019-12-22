package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Hausadatabase;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.Edoentity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.Edoviewmodel;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.FrontPage;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Igbodatabasse.igbo;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.LocalLanguages;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase.pidgin;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yoru;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.dailyReadings;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.edo;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.hausa;

public class Hausa extends AppCompatActivity {
    private String mandroiddate, mdate,mbodydate,mfirstr,mthemefirst,mbodyfirst,mredresponsial,mresponsalblack;
    private String mbodyresponsal,msecondreading,mthemesecondreading,mbodyscondreading,mAlleuiad;
    private String mbodyalleuia,mgospel,mthemegospel,mbodygospel,manything,mnormalanything;
    private boolean connected = false;
    private CalendarView mcal;
    private DatabaseReference medocalendar;
    private hausaviewmodel mdailymodel;
    private LiveData<List<hausaentity>> Alldata;
    private ProgressBar mp;
    private int a=1;
    private AdView mAdview;
    private Toolbar mtoolbar;
    private LinearLayout ml;
    private String mmcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hausa2);


        mmcheck=getIntent().getStringExtra("checks");


        mAdview = findViewById(R.id.addhausareading);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar = findViewById(R.id.toolbarhausareading);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getApplicationContext(),dailyReadings.class));
                //finish();

                if(mmcheck!=null){
                    if(mmcheck.equals("mainhausa")){
                        startActivity(new Intent(getApplicationContext(),dailyReadings.class));
                        finish();
                    }else if(mmcheck.equals("Lhausa")){
                        startActivity(new Intent(getApplicationContext(),FrontPage.class));
                        finish();

                    }
                }
            }
        });


        mdailymodel = ViewModelProviders.of(this).get(hausaviewmodel.class);

        ml=findViewById(R.id.hausall);
        mp = (ProgressBar)findViewById(R.id.rotateha);
        mcal = (CalendarView) findViewById(R.id.calha);
        mcal.setVisibility(View.GONE);
        mp.setVisibility(View.VISIBLE);

        if(android.os.Build.VERSION.SDK_INT <=19){
            ViewGroup.LayoutParams params =mcal.getLayoutParams();
            params.height=300;
            ml.setLayoutParams(params);


        }
        medocalendar = FirebaseDatabase.getInstance().getReference().child("Hausa_Readings");
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {

            mdailymodel.deletes();
           // Toast.makeText(getApplicationContext(), "deleting calendar", Toast.LENGTH_SHORT).show();
            medocalendar.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    mandroiddate= dataSnapshot.child("mandroiddates").getValue().toString();
                    mdate = dataSnapshot.child("mdates").getValue().toString();
                    mbodydate= dataSnapshot.child("mbodydates").getValue().toString();
                    mfirstr= dataSnapshot.child("mfirsts").getValue().toString();
                    mthemefirst= dataSnapshot.child("mpassages").getValue().toString();
                    mbodyfirst= dataSnapshot.child("mboddyfirstss").getValue().toString();
                    mredresponsial= dataSnapshot.child("redresponsialss").getValue().toString();
                    mresponsalblack= dataSnapshot.child("mboldresponsialss").getValue().toString();
                    mbodyresponsal= dataSnapshot.child("mbodyresponses").getValue().toString();
                    msecondreading= dataSnapshot.child("msecondreading").getValue().toString();
                    mthemesecondreading= dataSnapshot.child("redsecondreading").getValue().toString();
                    mbodyscondreading= dataSnapshot.child("bodysecondreading").getValue().toString();
                    mAlleuiad= dataSnapshot.child("malleuias").getValue().toString();
                    mbodyalleuia= dataSnapshot.child("mbodyalleluias").getValue().toString();
                    mgospel= dataSnapshot.child("mgospele").getValue().toString();
                    mthemegospel= dataSnapshot.child("mredgospelss").getValue().toString();
                    mbodygospel= dataSnapshot.child("mbodygospell").getValue().toString();
                    manything=dataSnapshot.child("maything").getValue().toString();
                    mnormalanything= dataSnapshot.child("mormalanything").getValue().toString();

                    mp.setVisibility(View.GONE);
                    mcal.setVisibility(View.VISIBLE);
                    hausaentity m=new hausaentity(
                            0, mandroiddate, mdate,mbodydate,mfirstr,mthemefirst,mbodyfirst,mredresponsial,mresponsalblack,
                            mbodyresponsal,msecondreading,mthemesecondreading,mbodyscondreading,mAlleuiad, mbodyalleuia,mgospel,mthemegospel,mbodygospel,manything,mnormalanything
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

        } else {
            connected = false;
            mp.setVisibility(View.GONE);
            mcal.setVisibility(View.VISIBLE);
           // Toast.makeText(getApplicationContext(), "No network", Toast.LENGTH_SHORT).show();
        }


        mcal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String year = String.valueOf(i);
                String month = String.valueOf(i1 + 1);
                String day = String.valueOf(i2);

                String com = day + "/" + month + "/" + year;
                Alldata = mdailymodel.getAlldata(com);


                //Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
                tunde(com);
                // Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();


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
            startActivity(new Intent(this, pidgin.class));


        }


        if(item.getItemId()==R.id.igbo){
            startActivity(new Intent(this, igbo.class));


        }

        if(item.getItemId()==R.id.Edo){
            startActivity(new Intent(this, EdoReading.class));


        }
        if(item.getItemId()==R.id.hausa){
            startActivity(new Intent(this, Hausa.class));


        }
        if(item.getItemId()==R.id.Yoruba){
            startActivity(new Intent(this, yoru.class));


        }

        //this is a product of Crude
        return true;

    }


    private void tunde(final String com) {
        Alldata.observe(this, new Observer<List<hausaentity>>() {
            @Override
            public void onChanged(@Nullable List<hausaentity> hausaentities) {
                if(hausaentities  == null || hausaentities.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Readings Coming Soon", Toast.LENGTH_SHORT).show();
                }else{
                    int i=0;
                    String mdates=hausaentities.get(i).getMdate();
                    String mbodydates=hausaentities.get(i).getMbodydate();
                    String mfirstrs=hausaentities.get(i).getMfirstr();
                    String mthemefirst=hausaentities.get(i).getMthemefirst();
                    String mbodyfirsts=hausaentities.get(i).getMbodyfirst();
                    String mredresponsials=hausaentities.get(i).getMredresponsial();
                    String mresponsalblacks=hausaentities.get(i).getMresponsalblack();
                    String mbodyresponsals=hausaentities.get(i).getMbodyresponsal();
                    String msecondreadings=hausaentities.get(i).getMsecondreading();
                    String mthemesecondreadings=hausaentities.get(i).getMthemesecondreading();
                    String mbodyscondreadings=hausaentities.get(i).getMbodyscondreading();
                    String mAlleuias=hausaentities.get(i).getMalleuiad();
                    String mbodyalleuia=hausaentities.get(i).getMbodyalleuia();
                    String mgospels=hausaentities.get(i).getMgospel();
                    String mthemegospels=hausaentities.get(i).getMthemegospel();
                    String mbodygospels=hausaentities.get(i).getMbodygospel();
                    String manything=hausaentities.get(i).getManything();
                    String mnormalanything=hausaentities.get(i).getMnormalanything();



                    Intent intent = new Intent(Hausa.this,LocalLanguages.class);
                    intent.putExtra("rdateboldd", mdates);
                    intent.putExtra("rdateebody",mbodydates);
                    intent.putExtra("rfirstreadbold", mfirstrs);
                    intent.putExtra("rpassagereds", mthemefirst);
                    intent.putExtra("rfirstreadingbodys",mbodyfirsts);
                    intent.putExtra("rredresponsialpsalm",  mredresponsials);
                    intent.putExtra("rboldresponsialpsalm", mresponsalblacks);
                    intent.putExtra("rbodyresponsialpsalm",mbodyresponsals);
                    intent.putExtra("rsecondreadingbold", msecondreadings);
                    intent.putExtra("rredsecondreadingss", mthemesecondreadings);
                    intent.putExtra("rbodysecondreadings", mbodyscondreadings);
                    intent.putExtra("ralleliabolds", mAlleuias);
                    intent.putExtra("rbodyalleuias", mbodyalleuia);
                    intent.putExtra("rgospels",  mgospels);
                    intent.putExtra("rredgospel",  mthemegospels);
                    intent.putExtra("rgospelbody", mbodygospels);
                    intent.putExtra("ranyting",manything);
                    intent.putExtra("rbodyanything", mnormalanything);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            }
        });
    }
}
