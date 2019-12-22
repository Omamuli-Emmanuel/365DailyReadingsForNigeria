package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Englishdatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Engishreading")
public class Englishentity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int ids;

    @NonNull
    @ColumnInfo(name ="androiddate")
    private String mandroiddate;

    @NonNull
    @ColumnInfo(name ="DateBold")
    private String mdatebold;

    @NonNull
    @ColumnInfo(name ="Bodydatenormal")
    private String mbodydatenormal;
    @NonNull
    @ColumnInfo(name ="Boldcollet")
    private String mboldcollet;
    @NonNull
    @ColumnInfo(name ="bodycollet")
    private String mbodycollet;
    @NonNull
    @ColumnInfo(name ="firstreadingbold")
    private String mfirstreadingbold;
    @NonNull
    @ColumnInfo(name ="passagered")
    private String mpassagered;
    @NonNull
    @ColumnInfo(name ="firstreadingbody")
    private String mfirstreadingbody;
    @NonNull
    @ColumnInfo(name ="RedResponsialpsalm")
    private String mredResponsialpsalm;
    @NonNull
    @ColumnInfo(name ="Boldresponsialpsalm")
    private String mboldresponsialpsalm;
    @NonNull
    @ColumnInfo(name ="BodyResponsialpsalm")
    private String bodyresponsialpsalm;
    @NonNull
    @ColumnInfo(name ="secondReadingbold")
    private String msecondreadingbold;
    @NonNull
    @ColumnInfo(name ="Redsecondreading")
    private String mredsecondreading;
    @NonNull
    @ColumnInfo(name ="bodysecondreading")
    private String msecondreading;
    @NonNull
    @ColumnInfo(name ="alleuliabold")
    private String malleluiabold;
    @NonNull
    @ColumnInfo(name ="bodyallelluaia")
    private String mbodyallelluia;
    @NonNull
    @ColumnInfo(name ="Gospel")
    private String mgospel;
    @NonNull
    @ColumnInfo(name ="redGospel")
    private String mredGospel;
    @NonNull
    @ColumnInfo(name ="bodygospel")
    private String mbodygospel;
    @NonNull
    @ColumnInfo(name ="boldprayerofthefaithful")
    private String mboldprayerofthefaithful;
    @NonNull
    @ColumnInfo(name ="bodyprayeroffaithful")
    private String mbodyprayeroffaithful;
    @NonNull
    @ColumnInfo(name ="Todayreflecion")
    private String mtodayreflection;
    @NonNull
    @ColumnInfo(name ="bodytodayreflection")
    private String mbodytodayreflection;
    @NonNull
    @ColumnInfo(name ="personaldevotion")
    private String mpersonaldevotion;
    @NonNull
    @ColumnInfo(name ="bodypersonaldevotion")
    private String mbodypersonaldevotion;


    public Englishentity(@NonNull int ids, @NonNull String mandroiddate, @NonNull String mdatebold, @NonNull String mbodydatenormal, @NonNull String mboldcollet, @NonNull String mbodycollet, @NonNull String mfirstreadingbold, @NonNull String mpassagered, @NonNull String mfirstreadingbody, @NonNull String mredResponsialpsalm, @NonNull String mboldresponsialpsalm, @NonNull String bodyresponsialpsalm, @NonNull String msecondreadingbold, @NonNull String mredsecondreading, @NonNull String msecondreading, @NonNull String malleluiabold, @NonNull String mbodyallelluia, @NonNull String mgospel, @NonNull String mredGospel, @NonNull String mbodygospel, @NonNull String mboldprayerofthefaithful, @NonNull String mbodyprayeroffaithful, @NonNull String mtodayreflection, @NonNull String mbodytodayreflection, @NonNull String mpersonaldevotion, @NonNull String mbodypersonaldevotion) {
        this.ids = ids;
        this.mandroiddate = mandroiddate;
        this.mdatebold = mdatebold;
        this.mbodydatenormal = mbodydatenormal;
        this.mboldcollet = mboldcollet;
        this.mbodycollet = mbodycollet;
        this.mfirstreadingbold = mfirstreadingbold;
        this.mpassagered = mpassagered;
        this.mfirstreadingbody = mfirstreadingbody;
        this.mredResponsialpsalm = mredResponsialpsalm;
        this.mboldresponsialpsalm = mboldresponsialpsalm;
        this.bodyresponsialpsalm = bodyresponsialpsalm;
        this.msecondreadingbold = msecondreadingbold;
        this.mredsecondreading = mredsecondreading;
        this.msecondreading = msecondreading;
        this.malleluiabold = malleluiabold;
        this.mbodyallelluia = mbodyallelluia;
        this.mgospel = mgospel;
        this.mredGospel = mredGospel;
        this.mbodygospel = mbodygospel;
        this.mboldprayerofthefaithful = mboldprayerofthefaithful;
        this.mbodyprayeroffaithful = mbodyprayeroffaithful;
        this.mtodayreflection = mtodayreflection;
        this.mbodytodayreflection = mbodytodayreflection;
        this.mpersonaldevotion = mpersonaldevotion;
        this.mbodypersonaldevotion = mbodypersonaldevotion;
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
    public String getMdatebold() {
        return mdatebold;
    }

    @NonNull
    public String getMbodydatenormal() {
        return mbodydatenormal;
    }

    @NonNull
    public String getMboldcollet() {
        return mboldcollet;
    }

    @NonNull
    public String getMbodycollet() {
        return mbodycollet;
    }

    @NonNull
    public String getMfirstreadingbold() {
        return mfirstreadingbold;
    }

    @NonNull
    public String getMpassagered() {
        return mpassagered;
    }

    @NonNull
    public String getMfirstreadingbody() {
        return mfirstreadingbody;
    }

    @NonNull
    public String getMredResponsialpsalm() {
        return mredResponsialpsalm;
    }

    @NonNull
    public String getMboldresponsialpsalm() {
        return mboldresponsialpsalm;
    }

    @NonNull
    public String getBodyresponsialpsalm() {
        return bodyresponsialpsalm;
    }

    @NonNull
    public String getMsecondreadingbold() {
        return msecondreadingbold;
    }

    @NonNull
    public String getMredsecondreading() {
        return mredsecondreading;
    }

    @NonNull
    public String getMsecondreading() {
        return msecondreading;
    }

    @NonNull
    public String getMalleluiabold() {
        return malleluiabold;
    }

    @NonNull
    public String getMbodyallelluia() {
        return mbodyallelluia;
    }

    @NonNull
    public String getMgospel() {
        return mgospel;
    }

    @NonNull
    public String getMredGospel() {
        return mredGospel;
    }

    @NonNull
    public String getMbodygospel() {
        return mbodygospel;
    }

    @NonNull
    public String getMboldprayerofthefaithful() {
        return mboldprayerofthefaithful;
    }

    @NonNull
    public String getMbodyprayeroffaithful() {
        return mbodyprayeroffaithful;
    }

    @NonNull
    public String getMtodayreflection() {
        return mtodayreflection;
    }

    @NonNull
    public String getMbodytodayreflection() {
        return mbodytodayreflection;
    }

    @NonNull
    public String getMpersonaldevotion() {
        return mpersonaldevotion;
    }

    @NonNull
    public String getMbodypersonaldevotion() {
        return mbodypersonaldevotion;
    }
}


