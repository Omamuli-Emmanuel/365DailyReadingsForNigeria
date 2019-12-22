package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Adura.AduraActivity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yoru;

public class yoruba extends AppCompatActivity {

    private LinearLayout youRead, youPray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoruba2);

        //find by id

        youRead = (LinearLayout)findViewById(R.id.youRead);
        youPray = (LinearLayout)findViewById(R.id.youPray);


        //set Onclick listeners


        youRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yoruba.this, yoru.class);
                intent.putExtra("checks","Lyoru");
                startActivity(intent);
                finish();
            }
        });

        youPray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yoruba.this, AduraActivity.class);
                startActivity(intent);
            }
        });
    }
}
