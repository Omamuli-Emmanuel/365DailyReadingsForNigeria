package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;


import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class prayerAfterComm extends Activity {
    private AdView mAdview;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_after_comm);

        mAdview=findViewById(R.id.addprayeraftrcommunin);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarprayeraftercommnin);
       // setSupportActionBar(mtoolbar);



       /* mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Eachreadings.class));
                finish();
            }
        });*/

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