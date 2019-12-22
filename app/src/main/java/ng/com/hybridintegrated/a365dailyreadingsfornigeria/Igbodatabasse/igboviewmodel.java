package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Igbodatabasse;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase.pidginDao;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase.pidginentity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase.pidginroomdatabase;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase.pidginviewmodel;

public class igboviewmodel extends AndroidViewModel {
    private igboroomdatabase mdatadb;
    private igboDao migbodao;
    public igboviewmodel(@NonNull Application application) {
        super(application);
        mdatadb= igboroomdatabase.getDatabase(application);
        migbodao=mdatadb.migbodao();
    }

    public LiveData<List<igboentity>> getAlldata(String mdate){
        return migbodao.getAlldatas(mdate);
    }

    public void inserts(igboentity migbo){
        new igboviewmodel.InsertsAsyncTassks(migbodao).execute(migbo);
    }

    public void deletes(){
        new igboviewmodel.deleteAsynctasks(migbodao).execute();
    }

    private class InsertsAsyncTassks extends AsyncTask<igboentity,Void,Void>{

        igboDao migbodao;
        public InsertsAsyncTassks(igboDao migbodao) {
            this.migbodao=migbodao;
        }

        @Override
        protected Void doInBackground(igboentity... igboentities) {
            migbodao.inserts(igboentities[0]);
            return null;
        }
    }


    private class deleteAsynctasks extends AsyncTask<igboentity,Void,Void>{
        igboDao migbodao;
        public deleteAsynctasks(igboDao migbodao) {
            this.migbodao=migbodao;
        }

        @Override
        protected Void doInBackground(igboentity... igboentities) {
            migbodao.deletealls();
            return null;
        }
    }



}
