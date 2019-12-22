package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.EdoReading;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Eruhwen.EruhmwenActivity;

public class edo extends AppCompatActivity {

    private LinearLayout read, pray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edo);

        //find views by id
        read = (LinearLayout)findViewById(R.id.edoRead);
        pray = (LinearLayout)findViewById(R.id.edoPray);


        //set Onclick listeners

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(edo.this, EdoReading.class);
                i.putExtra("checks","Ledo");
                startActivity(i);
                finish();
            }
        });

        pray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(edo.this, EruhmwenActivity.class);
                startActivity(i);
            }
        });
    }
}
