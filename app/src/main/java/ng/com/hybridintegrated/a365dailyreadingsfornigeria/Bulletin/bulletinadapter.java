package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Bulletin;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Catholic_doctrines.Eachdoctrine;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.appreciation.appreciationadapter;

public class bulletinadapter extends RecyclerView.Adapter< bulletinadapter.Myholder> {
    private  List<bulletinmodel> mlist;
    private Context mcontext;
    public bulletinadapter(Context applicationContext, List<bulletinmodel> mlist) {
        this.mcontext=applicationContext;
        this.mlist=mlist;

    }

    @NonNull
    @Override
    public bulletinadapter.Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bulletinsinglelayout,viewGroup,false);
        return new bulletinadapter.Myholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull bulletinadapter.Myholder myholder, int i) {
        bulletinmodel g=mlist.get(i);
        final String title=g.getTitle();
        final String body=g.getBody();
        final String thumbimage=g.getThumbimage();

        if(!thumbimage.equals("")){
            //if thumbimage not equal to null
            myholder.bulsignimages.setVisibility(View.GONE);
            myholder.bulimages.setVisibility(View.VISIBLE);
            Glide.with(mcontext).load(thumbimage).into(myholder.bulimages);
            myholder.title.setText(title);
            myholder.body.setText(body);
        }else if(thumbimage.equals("")){
            myholder.bulsignimages.setVisibility(View.VISIBLE);
            myholder.bulimages.setVisibility(View.GONE);
            myholder.title.setText(title);
            myholder.body.setText(body);
        }

        myholder.mcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, Bulletinread.class);
                intent.putExtra("image",thumbimage);
                intent.putExtra("title",title);
                intent.putExtra("body",body);
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
        TextView title,body;
        ImageView bulimages,bulsignimages;
        CardView mcard;
        public Myholder(@NonNull View v) {
            super(v);
            title=v.findViewById(R.id.title);
            body=v.findViewById(R.id.bodysss);
            bulimages=v.findViewById(R.id.bulimage);
            bulsignimages=v.findViewById(R.id.bulsignimage);
            mcard=v.findViewById(R.id.bullcard);

        }
    }
}
