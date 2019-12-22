package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Hausadatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.Yorubaroomdatabase;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yorubaDao;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yorubaentity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yorubaviewmodel;

public class hausaviewmodel extends AndroidViewModel {
    private Hausaroomdatabase mdatadb;
    private hausaDao mhausaadao;
    public hausaviewmodel(@NonNull Application application) {
        super(application);
        mdatadb=Hausaroomdatabase.getDatabase(application);
        mhausaadao=mdatadb.mhausadao();
    }

    public LiveData<List<hausaentity>> getAlldata(String mdate){
        return mhausaadao.getAlldatas(mdate);
    }

    public void inserts(hausaentity mhausa){
        new hausaviewmodel.InsertsAsyncTassks(mhausaadao).execute(mhausa);
    }

    public void deletes(){
        new hausaviewmodel.deleteAsynctasks(mhausaadao).execute();
    }

    private class InsertsAsyncTassks extends AsyncTask<hausaentity,Void,Void>{
        hausaDao mhausaadao;
        public InsertsAsyncTassks(hausaDao mhausaadao) {
            this.mhausaadao=mhausaadao;
        }

        @Override
        protected Void doInBackground(hausaentity... hausaentities) {
            mhausaadao.inserts(hausaentities[0]);
            return null;
        }
    }

    private class deleteAsynctasks extends AsyncTask<hausaentity,Void,Void>{
        hausaDao mhausaadao;
        public deleteAsynctasks(hausaDao mhausaadao) {
            this.mhausaadao=mhausaadao;
        }

        @Override
        protected Void doInBackground(hausaentity... hausaentities) {
            mhausaadao.deletealls();
            return null;
        }
    }


}
