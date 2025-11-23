package com.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

import javax.inject.Inject;

public class RouteManager
{
    @Getter
    private final List<Route> routes = new ArrayList<>();
    private final SailingTrialsConfig sailingTrialsConfig;

    @Inject
    public RouteManager(SailingTrialsConfig sailingTrialsConfig)
    {
        this.sailingTrialsConfig = sailingTrialsConfig;

        loadRoutes();
    }

    private void loadRoutes()
    {
        // Route 1
        List<WorldPoint> r1 = List.of(
                new WorldPoint(3035, 2922, 0),
                new WorldPoint(3027, 2913, 0),
                new WorldPoint(3017, 2899, 0),
                new WorldPoint(3014, 2885, 0)
        );
        Color baseLineColorRoute1 = sailingTrialsConfig.baseLineColorRoute1();
        Color tracerLineColorRoute1 = sailingTrialsConfig.tracerLineColorRoute1();

        // Route 2
        List<WorldPoint> r2 = List.of(
                new WorldPoint(3220, 3400, 0),
                new WorldPoint(3225, 3403, 0),
                new WorldPoint(3230, 3406, 0)
        );
        Color baseLineColorRoute2 = sailingTrialsConfig.baseLineColorRoute2();
        Color tracerLineColorRoute2 = sailingTrialsConfig.tracerLineColorRoute2();

        // Route 3
        List<WorldPoint> r3 = List.of(
                new WorldPoint(3240, 3390, 0),
                new WorldPoint(3245, 3395, 0),
                new WorldPoint(3250, 3400, 0)
        );
        Color baseLineColorRoute3 = sailingTrialsConfig.baseLineColorRoute3();
        Color tracerLineColorRoute3 = sailingTrialsConfig.tracerLineColorRoute3();

        routes.add(new Route(r1, baseLineColorRoute1, tracerLineColorRoute1, true));
        routes.add(new Route(r2, baseLineColorRoute2, tracerLineColorRoute2, true));
        routes.add(new Route(r3, baseLineColorRoute3, tracerLineColorRoute3, true));
    }
}
