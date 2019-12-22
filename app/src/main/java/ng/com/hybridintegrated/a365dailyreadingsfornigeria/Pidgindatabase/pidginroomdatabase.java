package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.Yorubaroomdatabase;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yorubaDao;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase.yorubaentity;

@Database(entities = pidginentity.class, version = 1)
public abstract class pidginroomdatabase extends RoomDatabase {
    public abstract pidginDao mpidgindao();

    private static volatile pidginroomdatabase INSTANCE;

    static pidginroomdatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (pidginroomdatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            pidginroomdatabase.class, "pidgin_database")
                            .fallbackToDestructiveMigration()
                            // .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
