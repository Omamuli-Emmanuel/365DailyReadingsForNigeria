package ng.com.hybridintegrated.a365dailyreadingsfornigeria.appreciation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;

public class appreciationadapter extends RecyclerView.Adapter< appreciationadapter.Myholder> {
    private List<appreciationmodel> mlist;
    private Context mcontext;
    public appreciationadapter(Context applicationContext, List<appreciationmodel> mlist) {
        this.mlist=mlist;
        this.mcontext=applicationContext;
    }

    @NonNull
    @Override
    public appreciationadapter.Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.appreciationsinglelayout,viewGroup,false);
        return new appreciationadapter.Myholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull appreciationadapter.Myholder myholder, int i) {
        appreciationmodel m=mlist.get(i);


        String body2=m.getBody2();
        String contact=m.getContact();
        String body=m.getBody();




        myholder.body2.setText(body2);
        myholder.contact.setText(contact);
        myholder.body.setText(body);


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
      private   TextView body2,contact,body;
        public Myholder(@NonNull View v) {
            super(v);


            body2=v.findViewById(R.id.body2);
            contact=v.findViewById(R.id.contact);
            body=v.findViewById(R.id.body);




        }
    }
}
