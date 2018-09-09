package org.vikulin.cjdns.model;

/**
 * Immutable model object for a node.
 */
public abstract class Node {

    public final String name;

    public final String address;

    public final String publicKey;

    public Node(String name, String address, String publicKey) {
        this.name = name;
        this.address = address;
        this.publicKey = publicKey;
    }

    /**
     * Immutable model object for the self node.
     */
    public static class Me extends Node {

        public final String privateKey;

        public final Stats.Me stats;

        public Me(String name, String address, String publicKey, String privateKey) {
            super(name, address, publicKey);
            this.privateKey = privateKey;
            this.stats = new Stats.Me("", true, 0L, 0, 0, 0, 0, 0, 0);
        }
    }

    /**
     * Immutable model object for a peer node.
     */
    public static class Peer extends Node {

        public final int id;

        public final Credential[] outgoingConnections;

        public final Stats stats;

        public Peer(int id, String name, String address, String publicKey, Credential[] outgoingConnections) {
            super(name, address, publicKey);
            this.id = id;
            this.outgoingConnections = outgoingConnections;
            this.stats = new Stats("", true, 0L, 0, 0, 0, 0, 0);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Peer peer = (Peer) o;
            if (id != peer.id) return false;
            return true;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}
