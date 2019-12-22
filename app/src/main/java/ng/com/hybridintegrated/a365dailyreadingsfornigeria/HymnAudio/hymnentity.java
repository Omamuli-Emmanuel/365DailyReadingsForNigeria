package ng.com.hybridintegrated.a365dailyreadingsfornigeria.HymnAudio;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Hymn")
public class hymnentity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int ids;

    @NonNull
    @ColumnInfo(name ="title")
    private String mtitle;

    @NonNull
    @ColumnInfo(name ="chbno")
    private String mchbno;

    @NonNull
    @ColumnInfo(name ="jsno")
    private String mmjsno;
    @NonNull
    @ColumnInfo(name ="hymn")
    private String mhymn;
    @NonNull
    @ColumnInfo(name ="aboutsong")
    private String maboutsong;



    @NonNull
    @ColumnInfo(name ="audio")
    private String audio;


    public hymnentity(@NonNull int ids, @NonNull String mtitle, @NonNull String mchbno, @NonNull String mmjsno, @NonNull String mhymn, @NonNull String maboutsong, String audio) {
        this.ids = ids;
        this.mtitle = mtitle;
        this.mchbno = mchbno;
        this.mmjsno = mmjsno;
        this.mhymn = mhymn;
        this.maboutsong = maboutsong;
        this.audio=audio;
    }

    @NonNull
    public String getAudio() {
        return audio;
    }

    @NonNull
    public int getIds() {
        return ids;
    }

    @NonNull
    public String getMtitle() {
        return mtitle;
    }

    @NonNull
    public String getMchbno() {
        return mchbno;
    }

    @NonNull
    public String getMmjsno() {
        return mmjsno;
    }

    @NonNull
    public String getMhymn() {
        return mhymn;
    }

    @NonNull
    public String getMaboutsong() {
        return maboutsong;
    }


}
