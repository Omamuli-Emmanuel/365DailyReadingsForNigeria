package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Ekpereuka.EkpereActivity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Igbodatabasse.igbo;

public class newIgbo extends AppCompatActivity {

    private LinearLayout igboPray, igboRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_igbo);

        //find by id

        igboPray = (LinearLayout)findViewById(R.id.igboPrayers);
        igboRead = (LinearLayout)findViewById(R.id.igboReadings);


        //set Onclick listeners

        igboRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(newIgbo.this, igbo.class);
                intent.putExtra("checks","Ligbo");
                startActivity(intent);
                finish();
            }
        });

        igboPray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(newIgbo.this, EkpereActivity.class);
                startActivity(intent);
            }
        });
    }
}
