package ng.com.hybridintegrated.a365dailyreadingsfornigeria.HymnAudio;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;

public class hymnadapter extends RecyclerView.Adapter<hymnadapter.Myholder> implements Filterable {
    private Context mcontext;
    private List<hymnentity> hymnentities;
    private List<hymnentity> searchfulllist;
    public hymnadapter(Context applicationContext, List<hymnentity> hymnentities) {
        this.mcontext=applicationContext;
        this.hymnentities=hymnentities;
        searchfulllist=new ArrayList<>(hymnentities);
    }

    @NonNull
    @Override
    public hymnadapter.Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adventsinglelayout,viewGroup,false);
        return new hymnadapter.Myholder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull hymnadapter.Myholder myholder, int i) {
        hymnentity m=hymnentities.get(i);
        final String title=m.getMtitle();
        final String jsno=m.getMmjsno();
        final String chno=m.getMchbno();
       // final String imageurl=m.getMthumbimage();
        final String aboutsong=m.getMaboutsong();
        final String hymn=m.getMhymn();
        final String audio=m.getAudio();

        // Toast.makeText(mcontext,title,Toast.LENGTH_LONG).show();

        myholder.title.setText(title);
        myholder.jsno.setText(jsno);

        myholder.mcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, Readmore.class);
                intent.putExtra("title",title);
                intent.putExtra("jsno",jsno);
                intent.putExtra("chno",chno);
               // intent.putExtra("imageurl",imageurl);
                intent.putExtra("aboutsong",aboutsong);
                intent.putExtra("hymn",hymn);
                intent.putExtra("audio",audio);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return hymnentities.size();
    }

    @Override
    public Filter getFilter() {
        return searchfilter;
    }

    public class Myholder extends RecyclerView.ViewHolder {
        private TextView title,jsno;
        private CardView mcard;
        public Myholder(@NonNull View v) {
            super(v);
            title=v.findViewById(R.id.adventtitle);
            jsno=v.findViewById(R.id.adventno);
            mcard=v.findViewById(R.id.clickadvent);

        }
    }


    private Filter searchfilter=new Filter(){

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<hymnentity> filterdlist=new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0){
                filterdlist.addAll(searchfulllist);
            }else {
                String filterpattern = charSequence.toString().toLowerCase().trim();
                for (hymnentity item : searchfulllist) {
                    if (item.getMtitle().toLowerCase().contains(filterpattern)) {
                        filterdlist.add(item);
                    }else if (item.getMchbno().toLowerCase().contains(filterpattern)) {
                        filterdlist.add(item);

                    }else if (item.getMmjsno().toLowerCase().contains(filterpattern)) {
                        filterdlist.add(item);

                    }
                }

            }

            FilterResults results =new FilterResults();
            results.values=filterdlist;
            return  results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            hymnentities.clear();
            hymnentities.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };
}
