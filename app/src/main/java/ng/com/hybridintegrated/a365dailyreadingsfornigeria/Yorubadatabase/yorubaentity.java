package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Yorubadatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "yorubareadings")
public class yorubaentity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int ids;

    @NonNull
    @ColumnInfo(name ="androiddate")
    private String mandroiddate;

    @NonNull
    @ColumnInfo(name ="Date")
    private String mdate;

    @NonNull
    @ColumnInfo(name ="bodydate")
    private String mbodydate;
    @NonNull
    @ColumnInfo(name ="firstreading")
    private String mfirstr;
    @NonNull
    @ColumnInfo(name ="Themefirstreading")
    private String mthemefirst;
    @NonNull
    @ColumnInfo(name ="bodyfirstreading")
    private String mbodyfirst;
    @NonNull
    @ColumnInfo(name ="redresponsial")
    private String mredresponsial;
    @NonNull
    @ColumnInfo(name ="responsalblack")
    private String mresponsalblack;
    @NonNull
    @ColumnInfo(name ="BodyResponsal")
    private String mbodyresponsal;
    @NonNull
    @ColumnInfo(name ="Secondreding")
    private String msecondreading;
    @NonNull
    @ColumnInfo(name ="ThemeSecondreading")
    private String mthemesecondreading;
    @NonNull
    @ColumnInfo(name ="Bodysecondreading")
    private String mbodyscondreading;

    @NonNull
    @ColumnInfo(name ="Alleluiad")
    private String malleuiad;


    @NonNull
    @ColumnInfo(name ="Bodyalleuia")
    private String mbodyalleuia;

    @NonNull
    @ColumnInfo(name ="Gospel")
    private String mgospel;
    @NonNull
    @ColumnInfo(name ="ThemeGospel")
    private String mthemegospel;
    @NonNull
    @ColumnInfo(name ="BodyGospel")
    private String mbodygospel;
    @NonNull
    @ColumnInfo(name ="Anthying")
    private String manything;
    @NonNull
    @ColumnInfo(name ="normalAnything")
    private String mnormalanything;

    public yorubaentity(@NonNull int ids, @NonNull String mandroiddate, @NonNull String mdate, @NonNull String mbodydate, @NonNull String mfirstr, @NonNull String mthemefirst, @NonNull String mbodyfirst, @NonNull String mredresponsial, @NonNull String mresponsalblack, @NonNull String mbodyresponsal, @NonNull String msecondreading, @NonNull String mthemesecondreading, @NonNull String mbodyscondreading, @NonNull String malleuiad, @NonNull String mbodyalleuia, @NonNull String mgospel, @NonNull String mthemegospel, @NonNull String mbodygospel, @NonNull String manything, @NonNull String mnormalanything) {
        this.ids = ids;
        this.mandroiddate = mandroiddate;
        this.mdate = mdate;
        this.mbodydate = mbodydate;
        this.mfirstr = mfirstr;
        this.mthemefirst = mthemefirst;
        this.mbodyfirst = mbodyfirst;
        this.mredresponsial = mredresponsial;
        this.mresponsalblack = mresponsalblack;
        this.mbodyresponsal = mbodyresponsal;
        this.msecondreading = msecondreading;
        this.mthemesecondreading = mthemesecondreading;
        this.mbodyscondreading = mbodyscondreading;
        this.malleuiad = malleuiad;
        this.mbodyalleuia = mbodyalleuia;
        this.mgospel = mgospel;
        this.mthemegospel = mthemegospel;
        this.mbodygospel = mbodygospel;
        this.manything = manything;
        this.mnormalanything = mnormalanything;
    }

    @NonNull
    public int getIds() {
        return ids;
    }

    @NonNull
    public String getMandroiddate() {
        return mandroiddate;
    }

    @NonNull
    public String getMdate() {
        return mdate;
    }

    @NonNull
    public String getMbodydate() {
        return mbodydate;
    }

    @NonNull
    public String getMfirstr() {
        return mfirstr;
    }

    @NonNull
    public String getMthemefirst() {
        return mthemefirst;
    }

    @NonNull
    public String getMbodyfirst() {
        return mbodyfirst;
    }

    @NonNull
    public String getMredresponsial() {
        return mredresponsial;
    }

    @NonNull
    public String getMresponsalblack() {
        return mresponsalblack;
    }

    @NonNull
    public String getMbodyresponsal() {
        return mbodyresponsal;
    }

    @NonNull
    public String getMsecondreading() {
        return msecondreading;
    }

    @NonNull
    public String getMthemesecondreading() {
        return mthemesecondreading;
    }

    @NonNull
    public String getMbodyscondreading() {
        return mbodyscondreading;
    }

    @NonNull
    public String getMalleuiad() {
        return malleuiad;
    }

    @NonNull
    public String getMbodyalleuia() {
        return mbodyalleuia;
    }

    @NonNull
    public String getMgospel() {
        return mgospel;
    }

    @NonNull
    public String getMthemegospel() {
        return mthemegospel;
    }

    @NonNull
    public String getMbodygospel() {
        return mbodygospel;
    }

    @NonNull
    public String getManything() {
        return manything;
    }

    @NonNull
    public String getMnormalanything() {
        return mnormalanything;
    }

}
