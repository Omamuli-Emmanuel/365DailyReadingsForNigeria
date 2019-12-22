package ng.com.hybridintegrated.a365dailyreadingsfornigeria.stations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;

public class StationRead extends AppCompatActivity {
    private TextView mt,mb;
    private String mts,mtbs,mmcheck;
    private AdView mAdview;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_read);

        mmcheck=getIntent().getStringExtra("check");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAdview=findViewById(R.id.addstationread);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);


        mtoolbar=findViewById(R.id.toolbarstationread);
        setSupportActionBar(mtoolbar);
        if(mmcheck!=null) {
            if (mmcheck.equals("English")) {
                mtoolbar.setTitle("Stations of the Cross");

            } else if (mmcheck.equals("igbo")) {
                mtoolbar.setTitle("Ekpere Uka");

            } else if (mmcheck.equals("hausa")) {
                mtoolbar.setTitle("Addu'o'in Coci");

            } else if (mmcheck.equals("yoruba")) {
                mtoolbar.setTitle("Adura Ojojumo");

            }else if (mmcheck.equals("Edo")) {
                mtoolbar.setTitle("Eruhmwen");
            }else if (mmcheck.equals("pidgin")) {
                mtoolbar.setTitle("Church Prayers");
            }
        }

        mt=(TextView) findViewById(R.id.tts);
        mb=(TextView)findViewById(R.id.ttsbody);



       mts=getIntent().getStringExtra("titless");
        mtbs=getIntent().getStringExtra("bodyss");



        mt.setText(mts);
        mb.setText(mtbs);

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
