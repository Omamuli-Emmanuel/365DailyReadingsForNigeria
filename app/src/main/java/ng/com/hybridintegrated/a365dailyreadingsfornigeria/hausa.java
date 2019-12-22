package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Adduo.AdduoActivity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Hausadatabase.Hausa;

public class hausa extends AppCompatActivity {

    private LinearLayout hread, hpray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hausa);

        //find views by id

        hread = (LinearLayout)findViewById(R.id.hausaRead);
        hpray = (LinearLayout)findViewById(R.id.hausaPray);


        //set OnclickListeners

        hread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(hausa.this, Hausa.class);
                k.putExtra("checks","Lhausa");
                startActivity(k);
                finish();
            }
        });

        hpray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(hausa.this, AdduoActivity.class);
                startActivity(j);
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}
