package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase;

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

public class pidginviewmodel extends AndroidViewModel {
    private pidginroomdatabase mdatadb;
    private pidginDao mpidgindao;
    public pidginviewmodel(@NonNull Application application) {
        super(application);
        mdatadb=pidginroomdatabase.getDatabase(application);
        mpidgindao=mdatadb.mpidgindao();

    }

    public LiveData<List<pidginentity>> getAlldata(String mdate){
        return mpidgindao.getAlldatas(mdate);
    }

    public void inserts(pidginentity mpidgin){
        new pidginviewmodel.InsertsAsyncTassks(mpidgindao).execute(mpidgin);
    }

    public void deletes(){
        new pidginviewmodel.deleteAsynctasks(mpidgindao).execute();
    }

    private class InsertsAsyncTassks extends AsyncTask<pidginentity,Void,Void>{
        pidginDao mpidgindao;
        public InsertsAsyncTassks(pidginDao mpidgindao) {
            this.mpidgindao=mpidgindao;
        }

        @Override
        protected Void doInBackground(pidginentity... pidginentities) {
            mpidgindao.inserts(pidginentities[0]);
            return null;
        }
    }


    private class deleteAsynctasks extends AsyncTask<pidginentity,Void,Void>{

        pidginDao mpidgindao;
        public deleteAsynctasks(pidginDao mpidgindao) {
            this.mpidgindao=mpidgindao;
        }

        @Override
        protected Void doInBackground(pidginentity... pidginentities) {
            mpidgindao.deletealls();
            return null;
        }
    }
}
