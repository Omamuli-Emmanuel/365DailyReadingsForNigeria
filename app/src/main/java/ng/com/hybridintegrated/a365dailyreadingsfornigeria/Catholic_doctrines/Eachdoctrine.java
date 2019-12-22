package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Catholic_doctrines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Catholicdoctrine;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.FrontPage;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;

public class Eachdoctrine extends AppCompatActivity {
    private TextView mquestions,moption1,moption2,moption3;
    private String question,option1,option2,option3;
    private AdView mAdview;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eachdoctrine);

        mAdview = findViewById(R.id.addeachdoctrine);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar = findViewById(R.id.toolbareachdoctrine);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Catholicdoctrine.class));
                finish();
            }
        });

        mquestions=(TextView)findViewById(R.id.docquesstion);
        moption1=(TextView)findViewById(R.id.option1);


       question=getIntent().getStringExtra("question");
        option1=getIntent().getStringExtra("option1");



       mquestions.setText(question);
       moption1.setText(option1);

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
