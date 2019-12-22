package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


@Dao
public interface Englishdao {

    @Insert
    void inserts(Englishentity menglishentity);

    @Query("DELETE from Engishreading")
    void deletealls();

    @Query("SELECT * from Engishreading WHERE androiddate= :date LIMIT 1")
    LiveData<List<Englishentity>> getAlldatas(String date);
}
