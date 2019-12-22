package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class novena extends AppCompatActivity {
    private AdView mAdview;
    private Toolbar mtoolbar;
    private LinearLayout threeMins,n54days,maryassumption;
    private LinearLayout pentNov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novena);

        mAdview=findViewById(R.id.addnovena);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarnovena);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FrontPage.class));
                finish();
            }
        });

        maryassumption=(LinearLayout) findViewById(R.id.assumptin);
        maryassumption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novena.this, novenaAssumption.class));
                startActivity(intent);
            }
        });

        n54days=(LinearLayout) findViewById(R.id.n54days);
        n54days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novena.this, n54days.class));
                startActivity(intent);
            }
        });

        pentNov = (LinearLayout)findViewById(R.id.novListTwo);
        pentNov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novena.this, pentNovList.class));
                startActivity(intent);
            }
        });

        threeMins = (LinearLayout)findViewById(R.id.novListOne);
        threeMins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(novena.this, novenaList.class));
                startActivity(intent);
            }
        });

    }


}
