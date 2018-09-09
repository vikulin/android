package org.vikulin.cjdns.event;

import org.vikulin.cjdns.model.Node;

/**
 * Events associated with {@link org.vikulin.cjdns.model.Node.Peer}.
 */
public interface PeerEvents {

    /**
     * Request to create a new {@link org.vikulin.cjdns.model.Node.Peer}.
     */
    class Create {
    }

    /**
     * Request to update a {@link org.vikulin.cjdns.model.Node.Peer}.
     */
    class Update {

        public final Node.Peer mPeer;

        public Update(Node.Peer peer) {
            mPeer = peer;
        }
    }

    /**
     * Request to remove a {@link org.vikulin.cjdns.model.Node.Peer}.
     */
    class Remove {

        public final Node.Peer mPeer;

        public Remove(Node.Peer peer) {
            mPeer = peer;
        }
    }
}
