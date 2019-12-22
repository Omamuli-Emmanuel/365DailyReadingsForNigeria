package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Application_subclass;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHandler extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseApp.initializeApp(getApplicationContext());
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        // MobileAds.initialize(this, "ca-app-pub-7341690483968301~7385790689");
        MobileAds.initialize(this, "ca-app-pub-4749983620523460~8691479945");

    }
}
