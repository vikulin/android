package org.vikulin.cjdns.page;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.regex.Pattern;

import org.vikulin.cjdns.CjdnsApplication;
import org.vikulin.cjdns.R;
import butterknife.ButterKnife;

/**
 * The page explaining what the application is about.
 */
public class AboutPageFragment extends Fragment {

    private View mView;

    public static Fragment newInstance() {
        return new AboutPageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.inject(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((CjdnsApplication) getActivity().getApplication()).getComponent().inject(this);

        TextView version = (TextView) mView.findViewById(R.id.version);
        TextView ln1 = (TextView) mView.findViewById(R.id.ln1);

        Pattern pattern = Pattern.compile("https://github.com/hyperboria/android");
        Linkify.addLinks(ln1, pattern, "");

        String versionString = "-.-.-";
        try {
            versionString = getActivity().getApplicationContext().getPackageManager().getPackageInfo(
                    getActivity().getApplicationContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        version.setText(getString(R.string.version) + " " + versionString);
    }
}
