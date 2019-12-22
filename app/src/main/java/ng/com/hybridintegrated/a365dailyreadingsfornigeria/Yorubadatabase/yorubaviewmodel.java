package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.EdoDao;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.Edoentity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.Edoroomdatabase;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.Edoviewmodel;

public class yorubaviewmodel extends AndroidViewModel {
    private Yorubaroomdatabase mdatadb;
    private yorubaDao myorubadao;

    public yorubaviewmodel(@NonNull Application application) {
        super(application);
        mdatadb=Yorubaroomdatabase.getDatabase(application);
        myorubadao=mdatadb.myorubadao();

    }

    public LiveData<List<yorubaentity>> getAlldata(String mdate){
        return myorubadao.getAlldatas(mdate);
    }

    public void inserts(yorubaentity myoruba){
        new yorubaviewmodel.InsertsAsyncTassks(myorubadao).execute(myoruba);
    }

    public void deletes(){
        new yorubaviewmodel.deleteAsynctasks(myorubadao).execute();
    }

    private class InsertsAsyncTassks extends AsyncTask<yorubaentity,Void,Void> {
    yorubaDao myorubadao;

        public InsertsAsyncTassks(yorubaDao myorubadao) {
            this.myorubadao=myorubadao;
        }

        @Override
        protected Void doInBackground(yorubaentity... yorubaentities) {
            myorubadao.inserts(yorubaentities[0]);
            return null;
        }
    }


    private class deleteAsynctasks extends AsyncTask<yorubaentity,Void,Void>{

        yorubaDao myorubadao;
        public deleteAsynctasks(yorubaDao myorubadao) {
            this.myorubadao=myorubadao;

        }

        @Override
        protected Void doInBackground(yorubaentity... yorubaentities) {
            myorubadao.deletealls();
            return null;
        }
    }


}
