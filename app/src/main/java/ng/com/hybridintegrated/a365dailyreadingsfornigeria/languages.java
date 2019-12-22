package ng.com.hybridintegrated.a365dailyreadingsfornigeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class languages extends AppCompatActivity {

    private LinearLayout edo, hausa, igbo, pidgin, yoruba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        edo = (LinearLayout)findViewById(R.id.edolang);
        hausa = (LinearLayout)findViewById(R.id.hausalang);
        igbo = (LinearLayout)findViewById(R.id.igbolang);
        pidgin = (LinearLayout)findViewById(R.id.pidginlang);
        yoruba = (LinearLayout)findViewById(R.id.yorubalang);

        //set on click listeners

        edo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(languages.this, edo.class);
                startActivity(i);
            }
        });

        hausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z = new Intent(languages.this, hausa.class);
                startActivity(z);
            }
        });

        igbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(languages.this, newIgbo.class);
                startActivity(intent);
            }
        });

        yoruba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(languages.this, yoruba.class);
                startActivity(intent);
            }
        });

        pidgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(languages.this, pidginLangg.class);
                startActivity(intent);
            }
        });
    }
}
