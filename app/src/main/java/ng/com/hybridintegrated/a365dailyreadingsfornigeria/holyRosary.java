package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class holyRosary extends AppCompatActivity {
    private LinearLayout divinemercy,holyrosarys,maydev,perpetualhelps,rosarylibs,thankyous;
    private ImageView praye, reade, novee;
    private AdView mAdview;
    private android.support.v7.widget.Toolbar mtoolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holy_rosary);

        mAdview=findViewById(R.id.addholyrosarytwo);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarholyrosarytwo);
        //setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FrontPage.class));
                finish();
            }
        });

        reade = (ImageView)findViewById(R.id.toReading);
        reade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(holyRosary.this, dailyReadings.class));
                startActivity(intent);
            }
        });

        praye = (ImageView)findViewById(R.id.toPrayers);
        praye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(holyRosary.this, churchPrayers.class));
                startActivity(intent);
            }
        });

        novee = (ImageView)findViewById(R.id.toNovena);
        novee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(holyRosary.this, novena.class));
                startActivity(intent);
            }
        });

        thankyous=(LinearLayout)findViewById(R.id.thankje);
        thankyous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(holyRosary.this,Thankyou.class));
                startActivity(intent);
            }
        });

        rosarylibs=(LinearLayout)findViewById(R.id.rosarylib);
        rosarylibs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(holyRosary.this,Rosaryofliberation.class));
                startActivity(intent);
            }
        });

        perpetualhelps=(LinearLayout)findViewById(R.id.perpe);
        perpetualhelps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(holyRosary.this, pepertualhelp.class));
                startActivity(intent);
            }
        });

        maydev=(LinearLayout)findViewById(R.id.maydev);
        maydev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(holyRosary.this,mayprayer.class));
                startActivity(intent);
            }
        });

        holyrosarys=(LinearLayout)findViewById(R.id.holyros);
        holyrosarys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(holyRosary.this,holryrosary.class));
                startActivity(intent);
            }
        });

        divinemercy=(LinearLayout)findViewById(R.id.divinemercy);
        divinemercy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(holyRosary.this,divinemercychaplet.class));
                startActivity(intent);
            }
        });

    }

}
