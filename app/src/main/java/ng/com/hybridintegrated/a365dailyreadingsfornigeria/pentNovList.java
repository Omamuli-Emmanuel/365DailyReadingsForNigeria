package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.app.Activity;
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

public class pentNovList extends AppCompatActivity {
    private AdView mAdview;
    private Toolbar mtoolbar;

    private LinearLayout pentIntro, pentFirst, pentSecond, pentThird, pentFourth, pentFifth, pentSixth, pentSeven, pentEight,pentNine,pentday;
    private ImageView read, pray, rose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pent_nov_list);
        mAdview=findViewById(R.id.addpentnovlist);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarpentnovlist);
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
                Intent intent = (new Intent(pentNovList.this, dailyReadings.class));
                startActivity(intent);
            }
        });

        pray = (ImageView)findViewById(R.id.toPrayers);
        pray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, churchPrayers.class));
                startActivity(intent);
            }
        });

        rose = (ImageView)findViewById(R.id.toRosary);
        rose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, holyRosary.class));
                startActivity(intent);
            }
        });

        pentday=(LinearLayout) findViewById(R.id.pentday);
        pentday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, penticcostDay.class));
                startActivity(intent);
            }
        });

        pentNine=(LinearLayout) findViewById(R.id.pentnovNine);
        pentNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, pentDayNine.class));
                startActivity(intent);
            }
        });

        pentEight=(LinearLayout) findViewById(R.id.pentnovEight);
        pentEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, pentDayEight.class));
                startActivity(intent);
            }
        });



        pentSeven = (LinearLayout)findViewById(R.id.pentNovSeven);
        pentSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, pentDaySeven.class));
                startActivity(intent);
            }
        });

        pentSixth = (LinearLayout)findViewById(R.id.pentNovSix);
        pentSixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, pentDaySix.class));
                startActivity(intent);
            }
        });

        pentFifth = (LinearLayout)findViewById(R.id.pentNovFive);
        pentFifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, pentDayFive.class));
                startActivity(intent);
            }
        });

        pentFourth = (LinearLayout)findViewById(R.id.pentNovFour);
        pentFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, pentDayFour.class));
                startActivity(intent);
            }
        });

        pentThird = (LinearLayout)findViewById(R.id.pentNovThree);
        pentThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, pentDayThree.class));
                startActivity(intent);
            }
        });


        pentSecond = (LinearLayout)findViewById(R.id.pentTwo);
        pentSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, pentDayTwo.class));
                startActivity(intent);
            }
        });

        pentFirst = (LinearLayout)findViewById(R.id.pentOne);
        pentFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, pentDayOne.class));
                startActivity(intent);
            }
        });

        pentIntro = (LinearLayout)findViewById(R.id.introPent);
        pentIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(pentNovList.this, pentIntro.class));
                startActivity(intent);
            }
        });


    }
    @Override
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
    }

}
