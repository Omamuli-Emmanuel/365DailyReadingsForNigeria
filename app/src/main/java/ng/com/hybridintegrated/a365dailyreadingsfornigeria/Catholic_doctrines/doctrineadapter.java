package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Catholic_doctrines;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.R;

public class doctrineadapter extends RecyclerView.Adapter< doctrineadapter.Myholder> {
    private  List<doctrinemodel> mlist;
    private Context mcont;
    public doctrineadapter(Context applicationContext, List<doctrinemodel> mlist) {
        this.mlist=mlist;
        this.mcont=applicationContext;
    }

    @NonNull
    @Override
    public doctrineadapter.Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.doctrinesinglelayout,viewGroup,false);
        return new doctrineadapter.Myholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull doctrineadapter.Myholder myholder, int i) {
        doctrinemodel j= mlist.get(i);
        final String questions=j.getQuestions();
        final String option1=j.getOption1();

        myholder.question.setText(questions +"....");

        myholder.mcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcont, Eachdoctrine.class);
                intent.putExtra("question",questions);
                intent.putExtra("option1",option1);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcont.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        private TextView question;
        private CardView mcard;
        public Myholder(@NonNull View v) {
            super(v);
            question=v.findViewById(R.id.question);
            mcard=v.findViewById(R.id.doctrinecad);


        }
    }
}
