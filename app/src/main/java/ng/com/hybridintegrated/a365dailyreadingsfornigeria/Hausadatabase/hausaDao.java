package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Hausadatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yorubaentity;

@Dao
public interface hausaDao {
    @Insert
    void inserts(hausaentity mhausaentity);

    @Query("DELETE from hausareadings")
    void deletealls();

    @Query("SELECT * from hausareadings WHERE androiddate= :date LIMIT 1")
    LiveData<List<hausaentity>> getAlldatas(String date);
}
