package org.vikulin.cjdns.model;

/**
 * Immutable model object for a peering credential.
 */
public class Credential {

    public final int id;

    public final String label;

    public final Protocol protocol;

    public final String password;

    public Credential(int id, String label, Protocol protocol, String password) {
        this.id = id;
        this.label = label;
        this.protocol = protocol;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credential that = (Credential) o;
        if (id != that.id) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Immutable model object for a peering credential authorized for the self node.
     */
    public static class Authorized extends Credential {

        public final boolean isAllowed;

        public Authorized(int id, String label, Protocol protocol, String password, boolean isAllowed) {
            super(id, label, protocol, password);
            this.isAllowed = isAllowed;
        }
    }
}
