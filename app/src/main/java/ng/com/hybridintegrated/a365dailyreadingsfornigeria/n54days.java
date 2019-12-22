package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class n54days extends AppCompatActivity {
    private AdView mAdview;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n54days);
        mAdview=findViewById(R.id.addn54day);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarn54day);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),novena.class));
                finish();
            }
        });

    }


}
