package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class prayerRequest extends AppCompatActivity {
    private AdView mAdview;
    private Toolbar mtoolbar;

    private Button pray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_request);
        mAdview=findViewById(R.id.addprayerrequest);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarprayerrequest);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FrontPage.class));
                finish();
            }
        });

        pray = (Button)findViewById(R.id.prayButton);
        pray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(prayerRequest.this, prayerRequestNext.class));
                startActivity(intent);
            }
        });

    }

}
