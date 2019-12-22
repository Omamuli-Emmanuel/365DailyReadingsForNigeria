package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.EdoDao;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.Edoentity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase.Edoroomdatabase;

@Database(entities = yorubaentity.class, version = 1)
public abstract class Yorubaroomdatabase extends RoomDatabase {
    public abstract yorubaDao myorubadao();

    private static volatile Yorubaroomdatabase INSTANCE;

    static Yorubaroomdatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Yorubaroomdatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Yorubaroomdatabase.class, "yoruba_database")
                            .fallbackToDestructiveMigration()
                            // .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
