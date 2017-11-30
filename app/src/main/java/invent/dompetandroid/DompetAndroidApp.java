package invent.dompetandroid;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by LIMS on 01/12/2017.
 */

public class DompetAndroidApp extends Application {

    @Override
    public void onCreate()
    {
        super.onCreate();
        setupRealmDb();
    }

    private void setupRealmDb()
    {
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);
    }
}
