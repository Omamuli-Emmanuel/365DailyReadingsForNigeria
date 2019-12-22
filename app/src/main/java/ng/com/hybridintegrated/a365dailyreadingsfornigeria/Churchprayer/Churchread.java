package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Churchprayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;

public class Churchread extends AppCompatActivity {
    private TextView mt,mb;
    private String mts,mtbs,mmcheck;
    private AdView mAdview;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_churchread);

        mAdview=findViewById(R.id.addstationreads);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);


        mtoolbar=findViewById(R.id.toolbarstationreads);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mt=(TextView) findViewById(R.id.ttss);
        mb=(TextView)findViewById(R.id.ttsbodys);



        mts=getIntent().getStringExtra("titless");
        mtbs=getIntent().getStringExtra("bodyss");

        mtoolbar.setTitle(mts);



        mt.setText(mts);
        mb.setText(mtbs);
    }
}
