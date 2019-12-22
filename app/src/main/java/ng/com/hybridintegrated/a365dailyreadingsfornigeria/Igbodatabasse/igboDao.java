package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Igbodatabasse;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomDatabase;

import java.util.List;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase.pidginentity;


@Dao
public interface igboDao {
    @Insert
    void inserts(igboentity migboentity);

    @Query("DELETE from igboreadings")
    void deletealls();

    @Query("SELECT * from igboreadings WHERE androiddate= :date LIMIT 1")
    LiveData<List<igboentity>> getAlldatas(String date);

}
