package org.vikulin.cjdns.producer;

import android.content.Context;

import org.vikulin.cjdns.CjdrouteConf;
import org.vikulin.cjdns.model.Node;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

/**
 * Producer of a {@link org.vikulin.cjdns.model.Node.Me} stream.
 */
public interface MeProducer {

    Observable<Node.Me> stream(Context context);

    /**
     * Default implementation of a {@link MeProducer}.
     */
    class Default implements MeProducer {

        @Override
        public Observable<Node.Me> stream(Context context) {
            return CjdrouteConf.fetch0(context)
                    .subscribeOn(Schedulers.io());
        }
    }

    /**
     * Mock implementation of a {@link MeProducer}.
     */
    class Mock implements MeProducer {

        @Override
        public Observable<Node.Me> stream(Context context) {
            return BehaviorSubject.<Node.Me>create()
                    .startWith(new Node.Me("Me",
                            "fc00::/8",
                            "Loremipsumdolorsitametpharetraeratestvivamusrisusi.k",
                            "LoremipsumdolorsitametpraesentconsequatliberolacusmagnisEratgrav"));
        }
    }
}
