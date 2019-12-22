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

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.EdoReading;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Hausadatabase.Hausa;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Igbodatabasse.igbo;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase.pidgin;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yoru;

public class LocalLanguages extends AppCompatActivity {
    private TextView DateBold, Bodydatenorma, firstreadingbold, passagered, firstreadingbody;
    private TextView RedResponsialpsalm, Boldresponsialpsalm, BodyResponsialpsalm, secondReadingbold, Redsecondreading;
    private TextView bodysecondreading, alleuliabold, bodyallelluaia, Gospel, redGospel, bodygospel;
    private TextView anything,bodyanything;

    private String  DateBoldd, Bodydatenormad, firstreadingboldd, passageredd, firstreadingbodyd;
    private String RedResponsialpsalmd, Boldresponsialpsalmd, BodyResponsialpsalmd, secondReadingboldd, Redsecondreadingd;
    private String bodysecondreadingd, alleuliaboldd, bodyallelluaiad, Gospeld, redGospeld, bodygospeld;
    private String anythingd,bodyanythingd;
    private int a=1;
    private ImageView mg,mc,pra;
    private AdView mAdview;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_languages);
        mAdview = findViewById(R.id.addlocallanguage);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar = findViewById(R.id.toolbarlocallanguage);
        setSupportActionBar(mtoolbar);

        mg=(ImageView) findViewById(R.id.glo);
        mc=(ImageView) findViewById(R.id.cre);
        pra=(ImageView) findViewById(R.id.pr);

        mg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(LocalLanguages.this, gloria.class));
                startActivity(intent);
            }
        });

        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(LocalLanguages.this, creed.class));
                startActivity(intent);
            }
        });

        pra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(LocalLanguages.this, prayerAfterComm.class));
                startActivity(intent);
            }
        });

        DateBold=(TextView)findViewById(R.id.Dateboldl);
        Bodydatenorma =(TextView)findViewById(R.id.bodydatel);
        firstreadingbold =(TextView)findViewById(R.id.firstreadingl);
        passagered =(TextView)findViewById(R.id.pasageredl);
        firstreadingbody=(TextView)findViewById(R.id.bodyfirstreadingl);
        RedResponsialpsalm=(TextView)findViewById(R.id.redresponsialpsalml);
        Boldresponsialpsalm=(TextView)findViewById(R.id.boldresponsel);
        BodyResponsialpsalm=(TextView)findViewById(R.id.bodyresponsialpsalml);
        secondReadingbold=(TextView)findViewById(R.id.SecondReadingboldl);
        Redsecondreading=(TextView)findViewById(R.id.redsecondreadingl);
        bodysecondreading=(TextView)findViewById(R.id.bodysecondreadingl);
        alleuliabold=(TextView)findViewById(R.id.Alleulial);
        bodyallelluaia=(TextView)findViewById(R.id.bodyAlleluial);
        Gospel=(TextView)findViewById(R.id.Gospelreadingl);
        redGospel=(TextView)findViewById(R.id.redGospelreadingl);
        bodygospel=(TextView)findViewById(R.id.bodyGospelreadingl);
       anything=(TextView)findViewById(R.id.anythingl);
        bodyanything =(TextView)findViewById(R.id.bodyanythingl);


        DateBoldd =getIntent().getStringExtra("rdateboldd");
        Bodydatenormad=getIntent().getStringExtra("rdateebody");
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
        anythingd=getIntent().getStringExtra("ranyting");
        bodyanythingd=getIntent().getStringExtra("rbodyanything");


        if(DateBoldd.equals("default")){
            DateBold.setVisibility(View.GONE);
        }else{
            DateBold.setText(DateBoldd);
        }

        if(Bodydatenormad.equals("default")){
            Bodydatenorma.setVisibility(View.GONE);
        }else{
            Bodydatenorma.setText(Bodydatenormad);
        }
        if(Bodydatenormad.equals("default")){
            Bodydatenorma.setVisibility(View.GONE);
        }else{
            Bodydatenorma.setText(Bodydatenormad);
        }

        if(firstreadingboldd.equals("default")){
            firstreadingbold.setVisibility(View.GONE);
        }else{
            firstreadingbold.setText(firstreadingboldd);
        }
        if(passageredd.equals("default")){
            passagered.setVisibility(View.GONE);
        }else{
            passagered.setText(passageredd);
        }
        if(firstreadingbodyd.equals("default")){
            firstreadingbody.setVisibility(View.GONE);
        }else{
            firstreadingbody.setText(firstreadingbodyd);
        }
        if(RedResponsialpsalmd.equals("default")){
            RedResponsialpsalm.setVisibility(View.GONE);
        }else{
            RedResponsialpsalm.setText(RedResponsialpsalmd);
        }
        if(Boldresponsialpsalmd.equals("default")){
            Boldresponsialpsalm.setVisibility(View.GONE);
        }else{
            Boldresponsialpsalm.setText(Boldresponsialpsalmd);
        }
        if(BodyResponsialpsalmd.equals("default")){
            BodyResponsialpsalm.setVisibility(View.GONE);
        }else{
            BodyResponsialpsalm.setText(BodyResponsialpsalmd);
        }

        if(secondReadingboldd.equals("default")){
            secondReadingbold.setVisibility(View.GONE);
        }else{
            secondReadingbold.setText(secondReadingboldd);
        }
        if(Redsecondreadingd.equals("default")){
            Redsecondreading.setVisibility(View.GONE);
        }else{
            Redsecondreading.setText(Redsecondreadingd);
        }

        if(bodysecondreadingd.equals("default")){
            bodysecondreading.setVisibility(View.GONE);
        }else{
            bodysecondreading.setText(bodysecondreadingd);
        }

        if(alleuliaboldd.equals("default")){
            alleuliabold.setVisibility(View.GONE);
        }else{
            alleuliabold.setText(alleuliaboldd);
        }
        if(bodyallelluaiad.equals("default")){
            bodyallelluaia.setVisibility(View.GONE);
        }else{
            bodyallelluaia.setText(bodyallelluaiad);
        }

        if(Gospeld.equals("default")){
            Gospel.setVisibility(View.GONE);
        }else{
            Gospel.setText(Gospeld);
        }
        if(redGospeld.equals("default")){
            redGospel.setVisibility(View.GONE);
        }else{
            redGospel.setText(redGospeld);
        }
        if(bodygospeld.equals("default")){
            bodygospel.setVisibility(View.GONE);
        }else{
            bodygospel.setText(bodygospeld);
        }
        if(anythingd.equals("default")){
            anything.setVisibility(View.GONE);
        }else{
            anything.setText(anythingd);
        }
        if(bodyanythingd.equals("default")){
            bodyanything.setVisibility(View.GONE);
        }else{
            bodyanything.setText(bodyanythingd);
        }




















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

        if (a == 1) {
            //startActivity(new Intent(this, dailyReadings.class));
            finish();
        }



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
}
