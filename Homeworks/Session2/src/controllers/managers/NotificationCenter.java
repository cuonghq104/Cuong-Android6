package controllers.managers;

import controllers.EventType;
import controllers.SingleController;
import controllers.Subscriber;

import java.util.Vector;

/**
 * Created by Cuong on 10/25/2016.
 */
public class NotificationCenter {

    private Vector<Subscriber> subscriberVector;

    private NotificationCenter() {
        subscriberVector = new Vector<>();
    }

    public void onEvent(EventType eventType, SingleController singleController) {
        for (Subscriber subscriber : subscriberVector) {
            System.out.println("BOOM");
            subscriber.onEvent(eventType, singleController);

        }
    }

    public void register(Subscriber subscriber) {
        subscriberVector.add(subscriber);
    }

    public void unregister(Subscriber subscriber) {
        subscriberVector.remove(subscriber);
    }

    public final static NotificationCenter instance = new NotificationCenter();
}
