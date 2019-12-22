package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Readreading;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = Readentity.class, version = 1)
public abstract class Readroomd extends RoomDatabase {
    public abstract Readdao mreaddao();

    private static volatile Readroomd INSTANCE;

    static Readroomd getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Readroomd.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Readroomd.class, "Read_database")
                            .fallbackToDestructiveMigration()
                            // .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
