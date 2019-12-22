package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yorubaentity;

@Dao
public interface pidginDao {
    @Insert
    void inserts(pidginentity mpidginentity);

    @Query("DELETE from pidginreadings")
    void deletealls();

    @Query("SELECT * from pidginreadings WHERE androiddate= :date LIMIT 1")
    LiveData<List<pidginentity>> getAlldatas(String date);

}
