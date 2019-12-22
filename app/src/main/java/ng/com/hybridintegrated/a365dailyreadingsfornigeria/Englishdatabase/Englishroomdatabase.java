package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;




@Database(entities = Englishentity.class, version = 1)
public abstract class Englishroomdatabase extends RoomDatabase {
    public abstract Englishdao menglishdao();

    private static volatile Englishroomdatabase INSTANCE;

    static Englishroomdatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Englishroomdatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Englishroomdatabase.class, "English_database")
                            .fallbackToDestructiveMigration()
                            // .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
