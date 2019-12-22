package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.Edoentity;

@Dao
public interface yorubaDao {

    @Insert
    void inserts(yorubaentity myorubaentity);

    @Query("DELETE from yorubareadings")
    void deletealls();

    @Query("SELECT * from yorubareadings WHERE androiddate= :date LIMIT 1")
    LiveData<List<yorubaentity>> getAlldatas(String date);
}
