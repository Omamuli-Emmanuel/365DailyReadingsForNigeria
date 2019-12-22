package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase.pidgin;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.pidginchurchprayer.PidginprayerActivity;

public class pidginLangg extends AppCompatActivity {

    private LinearLayout pRead, pPray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pidgin_langg);


        //find views by id

        pRead = (LinearLayout)findViewById(R.id.pidginRead);
        pPray = (LinearLayout)findViewById(R.id.pidginPray);


        //set listeners

        pRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pidginLangg.this, pidgin.class);
                intent.putExtra("checks","Lpidgin");
                startActivity(intent);
                finish();
            }
        });

        pPray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pidginLangg.this, PidginprayerActivity.class);
                startActivity(intent);
            }
        });
    }
}
