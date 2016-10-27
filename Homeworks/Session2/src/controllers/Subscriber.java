package controllers;

/**
 * Created by Cuong on 10/25/2016.
 */
public interface Subscriber {

    void onEvent(EventType eventType, SingleController singleController);


}
