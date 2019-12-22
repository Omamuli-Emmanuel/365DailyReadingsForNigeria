package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase.Englishentity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase.Englishviewmodel;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Readreading.Readentity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Readreading.Readreadingviewmodel;

public class LoadActivity extends AppCompatActivity {
    private ProgressBar mp;
    private String Current_date;
    private boolean connected = false;
    private String andoiddate, DateBold, Bodydatenorma, Boldcollet, bodycollet, firstreadingbold, passagered, firstreadingbody;
    private String RedResponsialpsalm, Boldresponsialpsalm, BodyResponsialpsalm, secondReadingbold, Redsecondreading;
    private String bodysecondreading, alleuliabold, bodyallelluaia, Gospel, redGospel, bodygospel, boldprayerofthefaithful, bodyprayeroffaithful;
    private String Todayreflecion, bodytodayreflection, personaldevotion, bodypersonaldevotion;
    private DatabaseReference mcalendar;
    private Readreadingviewmodel mdailymodel;
    private LiveData<List<Readentity>> Alldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        SimpleDateFormat dateformts=new SimpleDateFormat("d/M/yyyy");
        Current_date=dateformts.format(new Date()).toString();

        mdailymodel = ViewModelProviders.of(this).get(Readreadingviewmodel.class);
        mp=findViewById(R.id.rotatereadreadings);


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


                   // mp.setVisibility(View.GONE);
                    Readentity m = new Readentity(0, andoiddate, DateBold, Bodydatenorma, Boldcollet, bodycollet, firstreadingbold, passagered,
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
           Toast.makeText(getApplicationContext(), "INTERNET CONNECTION UNAVAILABLE", Toast.LENGTH_SHORT).show();
        }


        //CHECK DATAABASE FOR DATE
        mp.setVisibility(View.VISIBLE);
        if(Current_date!=null){
            Toast.makeText(getApplicationContext(),Current_date , Toast.LENGTH_SHORT).show();
            String date="1/6/2019";
           // mp.setVisibility(View.GONE);
        Alldata = mdailymodel.getAlldata(Current_date);
        tunde(Current_date);

        }else{
            mp.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(), "PLEASE SET PHONE DATE", Toast.LENGTH_SHORT).show();
        }


    }

    private void tunde(final String com) {
        Alldata.observe(this, new Observer<List<Readentity>>() {
            @Override
            public void onChanged(@Nullable List<Readentity> dailyreadingentities) {
                if (dailyreadingentities == null || dailyreadingentities.isEmpty()) {
                   // Toast.makeText(getApplicationContext(), "Readings Coming Soon", Toast.LENGTH_SHORT).show();
                } else {
                    int i = 0;
                    String from="load";
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



                    Intent intent = new Intent(LoadActivity.this, Eachreadings.class);
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
}
