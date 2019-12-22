package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.HymnAudio.Hymn;

public class FrontPage extends AppCompatActivity {

    private LinearLayout prayers;
    private LinearLayout rosary;
    private LinearLayout requests;
    private LinearLayout stationOfCross;
    private LinearLayout mappreciation;
    private LinearLayout novena;
    private LinearLayout confss,dailyreading,bulletin,catholicdoctrine, languages, audioDev;
    private AdView mAdview;
    private Toolbar mtoolbar;
    private int storage_pemission=23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        // android:label="365 Daily Readings For Nigeria"
       // this.setTitle("365 Daily Readings For Nigeria");
        mAdview=findViewById(R.id.addfrontpage);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarfrontpage);
        setSupportActionBar(mtoolbar);
        mtoolbar.setTitle("365 Daily Readings For Nigeria");


        if(isReadStorageAllowed()){
            // Toast.makeText(getApplicationContext(),"permission already approved",Toast.LENGTH_SHORT).show();
        }
        //if the app dosent have the permission ,request for permission
        requestStoragePermission();


        languages = (LinearLayout)findViewById(R.id.languages);
        languages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FrontPage.this, languages.class);
                startActivity(intent);
            }
        });

        catholicdoctrine=findViewById(R.id.catholicdoc);
        catholicdoctrine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(FrontPage.this, Catholicdoctrine.class));
                startActivity(intent);
            }
        });

        bulletin=findViewById(R.id.bulletin);
        bulletin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(FrontPage.this, catholicbulletin.class));
                startActivity(intent);
            }
        });

        mappreciation=findViewById(R.id.appreciation);
        mappreciation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(FrontPage.this, Appreciation.class));
                startActivity(intent);
            }
        });

        dailyreading=findViewById(R.id.dailrd);
        dailyreading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(FrontPage.this, LoadActivity.class));
                startActivity(intent);
            }
        });

        confss = (LinearLayout)findViewById(R.id.confRec);
        confss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(FrontPage.this, conff.class));
                startActivity(intent);
            }
        });

        novena = (LinearLayout)findViewById(R.id.novena);
        novena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(FrontPage.this, novena.class));
                startActivity(intent);
            }
        });

        stationOfCross = (LinearLayout)findViewById(R.id.stationOfCross);
        stationOfCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(FrontPage.this, stationOfTheCross.class));
                startActivity(intent);
            }
        });

        requests = (LinearLayout)findViewById(R.id.request);
        requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(FrontPage.this, prayerRequest.class));
                startActivity(intent);
            }
        });

        prayers = (LinearLayout)findViewById(R.id.churchPrayers);
        prayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(FrontPage.this, churchPrayers.class));
                startActivity(intent);
            }
        });

        rosary = (LinearLayout)findViewById(R.id.rosary);
        rosary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(FrontPage.this, holyRosary.class));
                startActivity(intent);
            }
        });

        audioDev = (LinearLayout)findViewById(R.id.audioDev);
        audioDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FrontPage.this, Hymn.class);
                startActivity(intent);
            }
        });
    }

    private Boolean isReadStorageAllowed(){
        //Getting the permission status
        int result= ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE);

        //if permission is granted returning true
        if(result== PackageManager.PERMISSION_GRANTED)
            return  true;
        //if permission not granted return false
        return  false;

    }

    private void requestStoragePermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)){
            //give a reason y
        }
        //ask for permission
        ActivityCompat.requestPermissions(this,new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE},storage_pemission);
    }

    //this method will be called when the user clicks on allow or deny


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == storage_pemission) {
            //if permission is granted
            if (grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                // Toast.makeText(getApplicationContext(),"permission approved",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

}
