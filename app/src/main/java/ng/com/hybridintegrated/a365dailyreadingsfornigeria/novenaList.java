package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class novenaList extends AppCompatActivity {

    private ImageView read, pray, rose;


    private LinearLayout intro;
    private LinearLayout novOne;
    private LinearLayout novTwo;
    private LinearLayout novThree;
    private LinearLayout novFour;
    private LinearLayout novFive;
    private LinearLayout novSix;
    private LinearLayout novSeven;
    private LinearLayout novEight;
    private LinearLayout novNine;
    private AdView mAdview;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novena_list);
        mAdview=findViewById(R.id.addnovenalist);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarnovenalist);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),novena.class));
                finish();
            }
        });

        read = (ImageView)findViewById(R.id.toReading);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novenaList.this, dailyReadings.class));
                startActivity(intent);
            }
        });

        pray = (ImageView)findViewById(R.id.toPrayers);
        pray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novenaList.this, churchPrayers.class));
                startActivity(intent);
            }
        });

        rose = (ImageView)findViewById(R.id.toRosary);
        rose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novenaList.this, holyRosary.class));
                startActivity(intent);
            }
        });



        novNine = (LinearLayout)findViewById(R.id.novNine);
        novNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novenaList.this, novNine.class));
                startActivity(intent);
            }
        });

        novEight = (LinearLayout)findViewById(R.id.novEight);
        novEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novenaList.this, novEight.class));
                startActivity(intent);
            }
        });

        novSeven = (LinearLayout)findViewById(R.id.novSeven);
        novSeven.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = (new Intent(novenaList.this, novSeven.class));
                    startActivity(intent);
                }
            });

            novSix = (LinearLayout)findViewById(R.id.novSix);
        novSix.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novenaList.this, novSix.class));
                startActivity(intent);
            }
        });

        novFive = (LinearLayout)findViewById(R.id.novFive);
        novFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novenaList.this, novFive.class));
                startActivity(intent);
            }
        });


        novFour = (LinearLayout)findViewById(R.id.novFour);
        novFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novenaList.this, novFour.class));
                startActivity(intent);
            }
        });


        novThree = (LinearLayout)findViewById(R.id.pent3);
        novThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novenaList.this, novThree.class));
                startActivity(intent);
            }
        });


        novTwo = (LinearLayout)findViewById(R.id.novTwo);
        novTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novenaList.this, novTwo.class));
                startActivity(intent);
            }
        });

        novOne = (LinearLayout)findViewById(R.id.novOne);
        novOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novenaList.this, novOne.class));
                startActivity(intent);
            }
        });

        intro = (LinearLayout)findViewById(R.id.intro);
        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novenaList.this, novenaIntro.class));
                startActivity(intent);
            }
        });

    }


}
