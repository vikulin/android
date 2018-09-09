package org.vikulin.cjdns.event;

import org.vikulin.cjdns.model.Credential;

/**
 * Events associated with {@link org.vikulin.cjdns.model.Credential.Authorized}.
 */
public interface AuthorizedCredentialEvents {

    /**
     * Request to create a new {@link org.vikulin.cjdns.model.Credential.Authorized}.
     */
    class Create {
    }

    /**
     * Request to update a {@link org.vikulin.cjdns.model.Credential.Authorized}.
     */
    class Update {

        public final Credential.Authorized mCredential;

        public Update(Credential.Authorized credential) {
            mCredential = credential;
        }
    }

    /**
     * Request to remove a {@link org.vikulin.cjdns.model.Credential.Authorized}.
     */
    class Remove {

        public final Credential.Authorized mCredential;

        public Remove(Credential.Authorized credential) {
            mCredential = credential;
        }
    }
}
