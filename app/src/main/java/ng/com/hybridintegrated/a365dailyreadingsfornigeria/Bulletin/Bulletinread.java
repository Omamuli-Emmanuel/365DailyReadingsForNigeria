package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Bulletin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.catholicbulletin;

public class Bulletinread extends AppCompatActivity {
    private TextView mbody;
    private String mtitle,bodys,imageurl;
    private AdView mAdview;
    private Toolbar mtoolbar;
    private ImageView mimage,shre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulletinread);

        mAdview = findViewById(R.id.addbulletinread);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar = findViewById(R.id.toolbarbulletinread);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), catholicbulletin.class));
                finish();
            }
        });

        mbody=(TextView)findViewById(R.id.bullreadbody);
        mimage=findViewById(R.id.bullreadimage);
        shre=findViewById(R.id.shared);




        mtitle=getIntent().getStringExtra("title");
        bodys=getIntent().getStringExtra("body");
        imageurl=getIntent().getStringExtra("image");

        if(!imageurl.equals("")){
            Glide.with(getApplicationContext()).load(imageurl).into(mimage);

        }else if(imageurl.equals("")){
            mimage.setVisibility(View.GONE);
        }

        mbody.setText(bodys);
        mtoolbar.setTitle(mtitle);

        shre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent=new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, bodys);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }
}
