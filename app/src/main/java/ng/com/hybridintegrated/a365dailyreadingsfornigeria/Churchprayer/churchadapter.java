package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Churchprayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.stations.StationRead;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.stations.stationadapter;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.stations.stationmodel;

public class churchadapter extends RecyclerView.Adapter< churchadapter.Myholder> {
    private Context mcontext;
    private List<stationmodel> mlist;
    public churchadapter(Context applicationContext, List<stationmodel> mlist) {
        this.mcontext=applicationContext;
        this.mlist=mlist;
    }

    @NonNull
    @Override
    public churchadapter.Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stationsinglelayout,viewGroup,false);
        return new churchadapter.Myholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull churchadapter.Myholder myholder, int i) {
        stationmodel j= mlist.get(i);
        final String title=j.getTitle();
        final String body=j.getBody();

        myholder.mtext.setText(title);
        myholder.ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, Churchread.class);
                intent.putExtra("titless",title);
                intent.putExtra("bodyss",body);
               // intent.putExtra("check",name);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        private LinearLayout ml;
        private TextView mtext;
        public Myholder(@NonNull View v) {
            super(v);
            mtext=itemView.findViewById(R.id.tt);
            ml=itemView.findViewById(R.id.clickstation);
        }
    }
}
