package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.w3c.dom.Text;

public class Eachreadings extends AppCompatActivity {

    private ImageView mg,mc,pra,bul,cal;
    private String mreadings, mdate;
    private TextView DateBold, Bodydatenorma, Boldcollet, bodycollet, firstreadingbold, passagered, firstreadingbody;
    private TextView RedResponsialpsalm, Boldresponsialpsalm, BodyResponsialpsalm, secondReadingbold, Redsecondreading;
    private TextView bodysecondreading, alleuliabold, bodyallelluaia, Gospel, redGospel, bodygospel, boldprayerofthefaithful, bodyprayeroffaithful;
    private TextView Todayreflecion, bodytodayreflection, personaldevotion, bodypersonaldevotion;
    private String andoiddated, DateBoldd, Bodydatenormad, Boldcolletd, bodycolletd, firstreadingboldd, passageredd, firstreadingbodyd;
    private String RedResponsialpsalmd, Boldresponsialpsalmd, BodyResponsialpsalmd, secondReadingboldd, Redsecondreadingd;
    private String bodysecondreadingd, alleuliaboldd, bodyallelluaiad, Gospeld, redGospeld, bodygospeld, boldprayerofthefaithfuld, bodyprayeroffaithfuld;
    private String Todayrefleciond, bodytodayreflectiond, personaldevotiond, bodypersonaldevotiond;

    private String defaulted="default";
    private AdView mAdview;
    private Toolbar mtoolbar;
    private int a=1;
    private String mfrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eachreadings);
        mAdview = findViewById(R.id.addeachreading);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar = findViewById(R.id.toolbareachreading);
        setSupportActionBar(mtoolbar);




        cal = (ImageView) findViewById(R.id.calendarread);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Eachreadings.this, dailyReadings.class));
                startActivity(intent);
            }
        });

        bul = (ImageView)findViewById(R.id.bulletinread);
        bul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Eachreadings.this, catholicbulletin.class));
                startActivity(intent);
            }
        });


        pra = (ImageView) findViewById(R.id.prs);
        pra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Eachreadings.this, prayerAfterComm.class));
                startActivity(intent);
            }
        });

       mg = (ImageView)findViewById(R.id.glos);
       mg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Eachreadings.this, gloria.class));
                startActivity(intent);
            }
        });

        mc= (ImageView) findViewById(R.id.cres);
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Eachreadings.this, creed.class));
                startActivity(intent);
            }
        });

        DateBold=(TextView)findViewById(R.id.Datebold);
        Bodydatenorma =(TextView)findViewById(R.id.bodydate);
        Boldcollet =(TextView)findViewById(R.id.boldcollet);
        bodycollet=(TextView)findViewById(R.id.bodycollet);
        firstreadingbold =(TextView)findViewById(R.id.firstreading);
        passagered =(TextView)findViewById(R.id.pasagered);
        firstreadingbody=(TextView)findViewById(R.id.bodyfirstreading);

        RedResponsialpsalm=(TextView)findViewById(R.id.redresponsialpsalm);
        Boldresponsialpsalm=(TextView)findViewById(R.id.boldresponse);
        BodyResponsialpsalm=(TextView)findViewById(R.id.bodyresponsialpsalm);
        secondReadingbold=(TextView)findViewById(R.id.SecondReadingbold);
        Redsecondreading=(TextView)findViewById(R.id.redsecondreading);
        bodysecondreading=(TextView)findViewById(R.id.bodysecondreading);
        alleuliabold=(TextView)findViewById(R.id.Alleulia);
        bodyallelluaia=(TextView)findViewById(R.id.bodyAlleluia);
        Gospel=(TextView)findViewById(R.id.Gospelreading);
        redGospel=(TextView)findViewById(R.id.redGospelreading);
        bodygospel=(TextView)findViewById(R.id.bodyGospelreading);
        boldprayerofthefaithful =(TextView)findViewById(R.id.prayerofthefaithful);
        bodyprayeroffaithful =(TextView)findViewById(R.id.bodyprayerofthefaithful);
        Todayreflecion=(TextView)findViewById(R.id.Todaysreflection);
        bodytodayreflection=(TextView)findViewById(R.id.bodyTodaysreflection);
        personaldevotion=(TextView)findViewById(R.id.personalDevotional);
        bodypersonaldevotion=(TextView)findViewById(R.id.bodypersonalDevotional);

        DateBoldd =getIntent().getStringExtra("rdateboldd");
        Bodydatenormad=getIntent().getStringExtra("rdateebody");
        Boldcolletd=getIntent().getStringExtra("rboldcollet");
        bodycolletd=getIntent().getStringExtra("rbodycolletss");
        firstreadingboldd=getIntent().getStringExtra("rfirstreadbold");
        passageredd=getIntent().getStringExtra("rpassagereds");
        firstreadingbodyd=getIntent().getStringExtra("rfirstreadingbodys");
        RedResponsialpsalmd=getIntent().getStringExtra("rredresponsialpsalm");
        Boldresponsialpsalmd=getIntent().getStringExtra("rboldresponsialpsalm");
        BodyResponsialpsalmd=getIntent().getStringExtra("rbodyresponsialpsalm");
        secondReadingboldd=getIntent().getStringExtra("rsecondreadingbold");
        Redsecondreadingd=getIntent().getStringExtra("rredsecondreadingss");
        bodysecondreadingd=getIntent().getStringExtra("rbodysecondreadings");
        alleuliaboldd=getIntent().getStringExtra("ralleliabolds");
        bodyallelluaiad=getIntent().getStringExtra("rbodyalleuias");
        Gospeld=getIntent().getStringExtra("rgospels");
        redGospeld=getIntent().getStringExtra("rredgospel");
        bodygospeld=getIntent().getStringExtra("rgospelbody");
        boldprayerofthefaithfuld=getIntent().getStringExtra("rboldprayeroffaithfuls");
        bodyprayeroffaithfuld=getIntent().getStringExtra("rbodyprayeroffaith");
        Todayrefleciond=getIntent().getStringExtra("rtodayreflections");
        bodytodayreflectiond=getIntent().getStringExtra("rbodytodayreflectionss");
        personaldevotiond=getIntent().getStringExtra("rpersonaldevotionss");
        bodypersonaldevotiond=getIntent().getStringExtra("rbodypersonaldevotionss");
        mfrom=getIntent().getStringExtra("from");


        DateBold.setText(DateBoldd);
        Bodydatenorma.setText(Bodydatenormad);
        Boldcollet.setText(Boldcolletd);
        bodycollet.setText(bodycolletd);
        firstreadingbold.setText(firstreadingboldd);
        passagered.setText(passageredd);
        firstreadingbody.setText(firstreadingbodyd);
        RedResponsialpsalm.setText(RedResponsialpsalmd);
        Boldresponsialpsalm.setText(Boldresponsialpsalmd);
        BodyResponsialpsalm.setText(BodyResponsialpsalmd);
        secondReadingbold.setText(secondReadingboldd);
        Redsecondreading.setText(Redsecondreadingd);
        bodysecondreading.setText(bodysecondreadingd);
        alleuliabold.setText(alleuliaboldd);
        bodyallelluaia.setText(bodyallelluaiad);
        Gospel.setText(Gospeld);
        redGospel.setText(redGospeld);
        bodygospel.setText(bodygospeld);
        boldprayerofthefaithful.setText(boldprayerofthefaithfuld);
        bodyprayeroffaithful.setText(bodyprayeroffaithfuld);
        Todayreflecion.setText(Todayrefleciond);
        bodytodayreflection.setText(bodytodayreflectiond);
        personaldevotion.setText(personaldevotiond);
        bodypersonaldevotion.setText(bodypersonaldevotiond);


        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mfrom.equals("load")) {
                    startActivity(new Intent(getApplicationContext(), FrontPage.class));
                    finish();
                }else if (mfrom.equals("loads")){
                    startActivity(new Intent(getApplicationContext(), dailyReadings.class));
                    finish();

                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.mmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);


        if(item.getItemId()==R.id.shareapp){
            Intent sendIntent=new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=ng.com.hybridintegrated.a365dailyreadingsfornigeria"
            );
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (mfrom.equals("load")) {
            startActivity(new Intent(getApplicationContext(), FrontPage.class));
            finish();
        }else if (mfrom.equals("loads")){
            startActivity(new Intent(getApplicationContext(), dailyReadings.class));
            finish();

        }
    }

    /*@Override
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
    }*/
}
