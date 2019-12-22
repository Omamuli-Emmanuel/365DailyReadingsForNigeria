package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Readreading;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase.Englishentity;


@Dao
public interface Readdao {
    @Insert
    void inserts(Readentity mreadentity);

    @Query("DELETE from Readreading")
    void deletealls();

    @Query("SELECT * from Readreading WHERE androiddate= :date LIMIT 1")
    LiveData<List<Readentity>> getAlldatas(String date);
}
