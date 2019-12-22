package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;


public class Englishviewmodel extends AndroidViewModel {
    private Englishroomdatabase mdatadb;
    private Englishdao menglishdao;

    public Englishviewmodel(@NonNull Application application) {
        super(application);

        mdatadb=Englishroomdatabase.getDatabase(application);
        menglishdao=mdatadb.menglishdao();

    }

    public LiveData<List<Englishentity>> getAlldata(String mdate){
        return menglishdao.getAlldatas(mdate);
    }

    public void inserts(Englishentity menglish){
        new InsertsAsyncTassks(menglishdao).execute(menglish);
    }

    //method to delete
    public void deletes(){
        new deleteAsynctasks(menglishdao).execute();
    }



    //Async class for inserting into database
    private class InsertsAsyncTassks extends AsyncTask<Englishentity,Void,Void>{
        Englishdao meglishedao;

        public InsertsAsyncTassks(Englishdao menglishdao) {
            this.meglishedao=menglishdao;
        }

        @Override
        protected Void doInBackground(Englishentity... englishentities) {
            menglishdao.inserts(englishentities[0]);
            return null;
        }
    }


    //Async class for deleting all data in english database
    private class deleteAsynctasks extends AsyncTask<Englishentity,Void,Void>{
        Englishdao meglishedao;
        public deleteAsynctasks(Englishdao menglishdao) {
            this.meglishedao=menglishdao;
        }

        @Override
        protected Void doInBackground(Englishentity... englishentities) {
            meglishedao.deletealls();
            return null;
        }
    }
}
