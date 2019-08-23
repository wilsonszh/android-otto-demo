package com.example.otto;

import android.util.Log;

import com.squareup.otto.Bus;

// OttoBus class - declared final so that it cannot be extended
public final class OttoBus {

    //your otto bus object
    private static Bus bus = null;

    public static void createBus() {
        try {
            if (bus == null) {
                bus = new Bus();
            }
        } catch (Exception e) {
            Log.e("Error @ createBus", e.getMessage());
        }
    }

    //method to get otto bus
    public static Bus getBus() {
        return bus;
    }

    //method to post event
    public static void post(Object event) {
        try {
            if (bus != null && event != null) {
                bus.post(event);
            }
        } catch (Exception e) {
            Log.e("Error @ post", e.getMessage());
        }
    }

    //method to register class instance with bus
    public static void register(Object object) {
        try {
            if (bus != null && object != null) {
                bus.register(object);
            }
        } catch (Exception e) {
            Log.e("Error @ register", e.getMessage());
        }
    }

    //method to unregister class instance with bus
    public static void unregister(Object object) {
        try {
            if (bus != null && object != null) {
                bus.unregister(object);
            }
        } catch (Exception e) {
            Log.e("Error @ unregister", e.getMessage());
        }
    }

}
