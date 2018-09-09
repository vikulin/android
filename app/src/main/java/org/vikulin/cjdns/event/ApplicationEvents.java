package org.vikulin.cjdns.event;

/**
 * Events associated with the application state.
 */
public interface ApplicationEvents {

    /**
     * Request to start the {@link org.vikulin.cjdns.CjdnsService}.
     */
    class StartCjdnsService {
    }

    /**
     * Request to stop the {@link org.vikulin.cjdns.CjdnsService}.
     */
    class StopCjdnsService {
    }

    /**
     * Request to change the page.
     */
    class ChangePage {

        public final String mSelectedContent;

        public ChangePage(String selectedContent) {
            mSelectedContent = selectedContent;
        }
    }

    /**
     * Request to list the connections of a {@link org.vikulin.cjdns.model.Node.Peer}.
     */
    class ListConnections {

        public final int mPeerId;

        public ListConnections(int peerId) {
            mPeerId = peerId;
        }
    }

    /**
     * Request to exchange a {@link org.vikulin.cjdns.model.Credential}.
     */
    class ExchangeCredential {

        public final Type mType;

        public final String mMessage;

        public ExchangeCredential(Type type, String message) {
            mType = type;
            mMessage = message;
        }

        /**
         * The list of exchange types.
         */
        public enum Type {
            target,
            broadcast
        }
    }
}