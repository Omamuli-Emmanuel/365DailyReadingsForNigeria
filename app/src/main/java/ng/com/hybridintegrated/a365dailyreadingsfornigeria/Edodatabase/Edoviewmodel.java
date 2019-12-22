package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase;

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

public class Edoviewmodel extends AndroidViewModel {
    private Edoroomdatabase mdatadb;
    private EdoDao medodao;


    public Edoviewmodel(@NonNull Application application) {
        super(application);

        mdatadb=Edoroomdatabase.getDatabase(application);
        medodao=mdatadb.medodao();
    }

    public LiveData<List<Edoentity>> getAlldata(String mdate){
        return medodao.getAlldatas(mdate);
    }

    public void inserts(Edoentity medo){
        new Edoviewmodel.InsertsAsyncTassks(medodao).execute(medo);
    }

    public void deletes(){
        new Edoviewmodel.deleteAsynctasks(medodao).execute();
    }




//class to insert insert data
    private class InsertsAsyncTassks extends AsyncTask<Edoentity,Void,Void>{
        EdoDao medodao;

        public InsertsAsyncTassks(EdoDao medodao) {
            this.medodao=medodao;

        }

        @Override
        protected Void doInBackground(Edoentity... edoentities) {
            medodao.inserts(edoentities[0]);
            return null;
        }
    }


    //class to delete
    private class deleteAsynctasks extends AsyncTask<Edoentity,Void,Void>{
        EdoDao medodao;

        public deleteAsynctasks(EdoDao medodao) {
            this.medodao=medodao;

        }

        @Override
        protected Void doInBackground(Edoentity...edoentities) {
            medodao.deletealls();
            return null;
        }
    }

}
