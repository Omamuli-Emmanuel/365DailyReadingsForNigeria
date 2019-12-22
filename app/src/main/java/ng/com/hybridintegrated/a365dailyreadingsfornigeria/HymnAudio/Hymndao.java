package ng.com.hybridintegrated.a365dailyreadingsfornigeria.HymnAudio;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface Hymndao {
    @Insert
    void inserts(hymnentity madvententity);

    @Query("DELETE from Hymn")
    void deletealls();

    @Query("SELECT * from Hymn")
    LiveData<List<hymnentity>> getAlldatas();
}
