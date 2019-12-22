package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase.Englishentity;

@Dao
public interface EdoDao {

    @Insert
    void inserts(Edoentity medoentity);

    @Query("DELETE from Edoreadings")
    void deletealls();

    @Query("SELECT * from Edoreadings WHERE androiddate= :date LIMIT 1")
    LiveData<List<Edoentity>> getAlldatas(String date);
}
