package ng.com.hybridintegrated.a365dailyreadingsfornigeria.HymnAudio;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = hymnentity.class, version = 2)
public abstract class Hymndatabase extends RoomDatabase {

    public abstract Hymndao medodao();

    private static volatile Hymndatabase INSTANCE;

    static Hymndatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized ( Hymndatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Hymndatabase.class, "HYmn_database")
                            .fallbackToDestructiveMigration()
                            // .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
