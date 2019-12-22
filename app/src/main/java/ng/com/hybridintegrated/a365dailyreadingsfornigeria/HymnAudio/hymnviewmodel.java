package ng.com.hybridintegrated.a365dailyreadingsfornigeria.HymnAudio;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

public class hymnviewmodel extends AndroidViewModel {
    private Hymndatabase mdatadb;
    private Hymndao medodao;


    public hymnviewmodel(@NonNull Application application) {
        super(application);
        mdatadb= Hymndatabase.getDatabase(application);
        medodao=mdatadb.medodao();
    }

    public LiveData<List<hymnentity>> getAlldata(){
        return medodao.getAlldatas();
    }



    public void inserts(hymnentity medo){
        new hymnviewmodel.InsertsAsyncTassks(medodao).execute(medo);
    }

    public void deletes(){
        new hymnviewmodel.deleteAsynctasks(medodao).execute();
    }

    private class InsertsAsyncTassks extends AsyncTask<hymnentity,Void,Void> {
        Hymndao medodao;
        public InsertsAsyncTassks(Hymndao medodao) {
           this.medodao=medodao;
        }

        @Override
        protected Void doInBackground(hymnentity... hymnentities) {
            medodao.inserts(hymnentities[0]);
            return null;
        }
    }

    private class deleteAsynctasks extends AsyncTask<hymnentity,Void,Void> {

        Hymndao medodao;
        public deleteAsynctasks(Hymndao medodao) {
            this.medodao=medodao;
        }

        @Override
        protected Void doInBackground(hymnentity... hymnentities) {
            medodao.deletealls();
            return null;
        }
    }

}
