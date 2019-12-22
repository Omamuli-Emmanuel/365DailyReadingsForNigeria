package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Edodatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase.Englishentity;


@Database(entities = Edoentity.class, version = 1)
public abstract class Edoroomdatabase extends RoomDatabase {
    public abstract EdoDao medodao();

    private static volatile Edoroomdatabase INSTANCE;

    static Edoroomdatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Edoroomdatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Edoroomdatabase.class, "Edo_database")
                            .fallbackToDestructiveMigration()
                            // .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
