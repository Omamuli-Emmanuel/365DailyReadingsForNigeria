package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Igbodatabasse;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase.pidginDao;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase.pidginentity;
import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Pidgindatabase.pidginroomdatabase;

@Database(entities = igboentity.class, version = 1)
public abstract class igboroomdatabase extends RoomDatabase {
    public abstract igboDao migbodao();

    private static volatile igboroomdatabase INSTANCE;
    static igboroomdatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (igboroomdatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            igboroomdatabase.class, "igbo_database")
                            .fallbackToDestructiveMigration()
                            // .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
