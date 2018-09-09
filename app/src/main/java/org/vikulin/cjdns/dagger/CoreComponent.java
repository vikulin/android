package org.vikulin.cjdns.dagger;

import javax.inject.Singleton;

import org.vikulin.cjdns.CjdnsService;
import org.vikulin.cjdns.CjdnsVpnService;
import org.vikulin.cjdns.MainActivity;
import org.vikulin.cjdns.dialog.ConnectionsDialogFragment;
import org.vikulin.cjdns.page.AboutPageFragment;
import org.vikulin.cjdns.page.CredentialsPageFragment;
import org.vikulin.cjdns.page.MePageFragment;
import org.vikulin.cjdns.page.PeersPageFragment;
import org.vikulin.cjdns.page.SettingsPageFragment;
import dagger.Component;

/**
 * {@link Component} providing core dependencies.
 */
@Singleton
@Component(modules = DefaultModule.class)
public interface CoreComponent {

    void inject(MainActivity inject);

    void inject(CjdnsVpnService inject);

    void inject(CjdnsService inject);

    void inject(MePageFragment inject);

    void inject(PeersPageFragment inject);

    void inject(CredentialsPageFragment inject);

    void inject(SettingsPageFragment inject);

    void inject(AboutPageFragment inject);

    void inject(ConnectionsDialogFragment inject);
}
