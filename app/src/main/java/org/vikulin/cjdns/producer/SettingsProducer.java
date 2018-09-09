package org.vikulin.cjdns.producer;

import android.content.Context;
import android.content.SharedPreferences;

import org.vikulin.cjdns.R;
import org.vikulin.cjdns.model.Theme;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Producer of a settings stream.
 */
public interface SettingsProducer {

    Observable<Theme> themeStream();

    /**
     * Minimalist implementation of a {@link SettingsProducer}.
     */
    class MinimalMock implements SettingsProducer {

        @Override
        public Observable<Theme> themeStream() {
            return Observable.just(new Theme(false));
        }
    }

    /**
     * Verbose implementation of a {@link SettingsProducer}.
     */
    class VerboseMock implements SettingsProducer {

        @Override
        public Observable<Theme> themeStream() {
            return Observable.just(new Theme(true));
        }
    }

    /**
     * Default implementation of a {@link SettingsProducer}.
     */
    class Default implements SettingsProducer {

        private Context mContext;

        private SharedPreferences mSharedPreferences;

        public Default(Context context, SharedPreferences sharedPreferences) {
            mContext = context;
            mSharedPreferences = sharedPreferences;
        }

        @Override
        public Observable<Theme> themeStream() {
            BehaviorSubject<Theme> stream = BehaviorSubject.create();
            return stream.startWith(new Theme(mSharedPreferences.getBoolean(mContext.getString(R.string.setting_verbose_enabled_key), false)));
        }
    }
}
