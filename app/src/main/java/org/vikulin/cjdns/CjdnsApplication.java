package org.vikulin.cjdns;

import android.app.Application;
import android.preference.PreferenceManager;

import org.vikulin.cjdns.dagger.CoreComponent;
import org.vikulin.cjdns.dagger.DaggerCoreComponent;
import org.vikulin.cjdns.dagger.DefaultModule;

/**
 * The {@link android.app.Application}.
 */
public class CjdnsApplication extends Application {

    CoreComponent mCoreComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Set module to provide dependencies and build core component.
        mCoreComponent = DaggerCoreComponent.builder()
                .defaultModule(new DefaultModule(this))
                .build();

        // Set default values for user preferences.
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    /**
     * Gets the {@link CoreComponent} holding the all dependencies.
     */
    public CoreComponent getComponent() {
        return mCoreComponent;
    }
}