package ng.com.hybridintegrated.a365dailyreadingsfornigeria.stations;

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

public class stationadapter extends RecyclerView.Adapter< stationadapter.Myholder>{
    private Context mcontext;
    private List<stationmodel> mlist;
    private String name;
    public stationadapter(Context applicationContext, List<stationmodel> mlist, String name) {
       this.mcontext=applicationContext;
        this.mlist=mlist;
        this.name=name;
    }

    @NonNull
    @Override
    public stationadapter.Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stationsinglelayout,viewGroup,false);
        return new stationadapter.Myholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull stationadapter.Myholder myholder, int i) {
        stationmodel j= mlist.get(i);
        final String title=j.getTitle();
        final String body=j.getBody();

        myholder.mtext.setText(title);
        myholder.ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, StationRead.class);
                intent.putExtra("titless",title);
                intent.putExtra("bodyss",body);
                intent.putExtra("check",name);
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
        public Myholder(@NonNull View itemView) {
            super(itemView);

            mtext=itemView.findViewById(R.id.tt);
            ml=itemView.findViewById(R.id.clickstation);
        }
    }
}
