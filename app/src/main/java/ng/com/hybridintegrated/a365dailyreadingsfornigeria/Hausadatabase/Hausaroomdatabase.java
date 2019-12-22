package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Hausadatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.Yorubaroomdatabase;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yorubaDao;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yorubaentity;

@Database(entities = hausaentity.class, version = 1)
public abstract class Hausaroomdatabase extends RoomDatabase {
    public abstract hausaDao mhausadao();

    private static volatile Hausaroomdatabase INSTANCE;

    static Hausaroomdatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Hausaroomdatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Hausaroomdatabase.class, "hausa_database")
                            .fallbackToDestructiveMigration()
                            // .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
