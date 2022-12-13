package com.Builders.services;


public class GPSDestination {
    private String route;

    public GPSDestination() {
        this.route = "Going To Hell";
    }

    public GPSDestination(String manualRoute) {
        this.route = manualRoute;
    }

    public String getRoute() {
        return route;
    }
}
