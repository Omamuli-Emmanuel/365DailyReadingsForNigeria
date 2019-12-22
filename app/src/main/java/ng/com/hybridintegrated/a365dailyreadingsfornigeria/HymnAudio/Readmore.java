package ng.com.hybridintegrated.a365dailyreadingsfornigeria.HymnAudio;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;

public class Readmore extends AppCompatActivity {
    private TextView jsno,chbno,title,hymn,mscripts,maboutsong;
    private ProgressBar mbar;
    private ImageView mscript;
    private LinearLayout mplay,mstop;
    private String mjjsno,mcchbno,mttitle,mhhymn,mimage,maaboutsong,audios;
    private boolean connected = false;
    private String playing="notplaying";
    private MediaPlayer mp;
    private AdView mAdview;
    private Toolbar mtoolbar;
    private ProgressDialog mdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readmore);

        mAdview=findViewById(R.id.addrread);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        mtoolbar=findViewById(R.id.toolbarread);
        setSupportActionBar(mtoolbar);

        mp=new MediaPlayer();
        mdd=new ProgressDialog(this);

        mjjsno=getIntent().getStringExtra("jsno");
        mcchbno=getIntent().getStringExtra("chno");
        mttitle=getIntent().getStringExtra("title");
        mimage=getIntent().getStringExtra("imageurl");
        maaboutsong=getIntent().getStringExtra("aboutsong");
        mhhymn=getIntent().getStringExtra("hymn");
        audios=getIntent().getStringExtra("audio");

        mtoolbar.setTitle(mttitle);



        maboutsong=findViewById(R.id.aboutsong);
        jsno=findViewById(R.id.adventreadmorejsno);
        chbno=findViewById(R.id.adventreadmorechbno);
        title=findViewById(R.id.adventreadmoretitle);
        hymn=findViewById(R.id.adventreadmorehymn);
        mbar=findViewById(R.id.adventroll);
        mscript=findViewById(R.id.adventhymnscript);
        mplay=findViewById(R.id.adventreadmoreplay);
        mstop=findViewById(R.id.adventreadmorestop);
        mscripts=findViewById(R.id.script);

        mbar.setVisibility(View.GONE);

        jsno.setText(mjjsno);
        chbno.setText(mcchbno);
        title.setText(mttitle);
        hymn.setText(mhhymn);


        if(audios.equals("default")){
            mplay.setVisibility(View.GONE);
        }else if(!audios.equals("default")){
            mplay.setVisibility(View.VISIBLE);
        }



        mplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp=new MediaPlayer();

                mdd.setTitle("Loading");
                mdd.setMessage("Streaming Audio.......");
                mdd.setCanceledOnTouchOutside(false);
                mdd.setCancelable(false);
                mdd.show();

                mplay.setVisibility(View.GONE);
                //mconnecting.setVisibility(View.VISIBLE);



                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {


                    //stopplaying();

                    try {
                        mp.setDataSource(audios);
                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {

                                mediaPlayer.start();
                                // mconnecting.setText("Music is playing");
                                playing = "playing";
                                mdd.dismiss();
                                mstop.setVisibility(View.VISIBLE);
                            }
                        });

                        mp.prepareAsync();

                    } catch (Exception e) {
                        mdd.dismiss();
                        Toast.makeText(Readmore.this, "Error", Toast.LENGTH_SHORT).show();
                        if(e!=null) {
                            String d = e.getMessage();
                            if (d != null) {
                                Toast.makeText(Readmore.this, d, Toast.LENGTH_LONG).show();
                            } else if (d == null) {

                            }

                        }

                    }

                } else {
                    mplay.setVisibility(View.VISIBLE);
                    mdd.dismiss();
                    connected = false;
                    //mp.setVisibility(View.GONE);
                    //mrecy.setVisibility(View.VISIBLE);
                    Toast.makeText(Readmore.this, "Internet Connection is Unavailable", Toast.LENGTH_SHORT).show();
                }


            }
        });


        mstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(playing.equals("playing")){
                    playing="playing";
                    stopplaying();
                    playing="notplaying";
                    Toast.makeText(getApplicationContext(),"stopped",Toast.LENGTH_LONG);
                    mplay.setVisibility(View.VISIBLE);
                    // mconnecting.setVisibility(View.GONE);
                    // mconnecting.setText("Conecting......");
                    mstop.setVisibility(View.GONE);


                }

            }
        });

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(playing.equals("playing")) {
                    stopplaying();
                    finish();
                }else if(playing.equals("not playing")){
                    stopplaying();
                    finish();
                }else{
                    finish();
                }

            }
        });

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(playing.equals("playing")) {
            stopplaying();
        }else if(playing.equals("not playing")){
            stopplaying();
            finish();
        }else{
            finish();
        }
    }

    private void stopplaying() {
        if(mp!=null){
            try {
                mp.stop();
                mp.release();
                mp=null;

            }catch (Exception e){
                String d = e.getMessage().toString();
                if(d==null){

                }else if(d!=null) {
                    Toast.makeText(Readmore.this, d, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
