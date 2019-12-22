package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Readreading;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase.Englishdao;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase.Englishentity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase.Englishroomdatabase;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase.Englishviewmodel;

public class Readreadingviewmodel extends AndroidViewModel {
    private Readroomd mdatadb;
    private Readdao mReaddao;

    public Readreadingviewmodel (@NonNull Application application) {
        super(application);

        mdatadb=Readroomd.getDatabase(application);
        mReaddao=mdatadb.mreaddao();

    }

    public LiveData<List<Readentity>> getAlldata(String mdate){
        return mReaddao.getAlldatas(mdate);
    }

    public void inserts(Readentity mreadentity){
        new Readreadingviewmodel.InsertsAsyncTassks(mReaddao).execute(mreadentity);
    }

    //method to delete
    public void deletes(){
        new Readreadingviewmodel.deleteAsynctasks(mReaddao).execute();
    }



    //Async class for inserting into database
    private class InsertsAsyncTassks extends AsyncTask<Readentity,Void,Void> {
        Readdao mreaddao;

        public InsertsAsyncTassks(Readdao mReaddao) {
            this.mreaddao=mReaddao;
        }

        @Override
        protected Void doInBackground(Readentity... readentities) {
            mreaddao.inserts(readentities[0]);
            return null;
        }
    }


    private class deleteAsynctasks extends AsyncTask<Readentity,Void,Void>  {
        Readdao mreaddao;
        public deleteAsynctasks(Readdao mReaddao) {
            this.mreaddao=mReaddao;
        }

        @Override
        protected Void doInBackground(Readentity... readentities) {
            mreaddao.deletealls();
            return null;
        }
    }
}
