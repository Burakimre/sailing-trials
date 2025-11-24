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

    @Inject
    public RouteManager()
    {
        loadRoutes();
    }

    private void loadRoutes()
    {
        // Route 1
        List<WorldPoint> r1 = List.of(
                new WorldPoint(3035, 2922, 0),
                new WorldPoint(3027, 2913, 0),
                new WorldPoint(3017, 2899, 0),
                new WorldPoint(3014, 2885, 0),
                new WorldPoint(3002, 2873, 0),
                new WorldPoint(3002, 2858, 0),
                new WorldPoint(3002, 2845, 0),
                new WorldPoint(3004, 2827, 0),
                new WorldPoint(3010, 2817, 0),
                new WorldPoint(3019, 2815, 0),
                new WorldPoint(3029, 2815, 0),
                new WorldPoint(3029, 2798, 0),
                new WorldPoint(3029, 2789, 0),
                new WorldPoint(3037, 2783, 0),
                new WorldPoint(3045, 2776, 0),
                new WorldPoint(3054, 2761, 0),
                new WorldPoint(3066, 2768, 0),
                new WorldPoint(3082, 2797, 0),
                new WorldPoint(3082, 2813, 0),
                new WorldPoint(3094, 2832, 0),
                new WorldPoint(3094, 2842, 0),
                new WorldPoint(3077, 2855, 0),
                new WorldPoint(3079, 2865, 0),
                new WorldPoint(3083, 2874, 0),
                new WorldPoint(3077, 2880, 0),
                new WorldPoint(3077, 2890, 0),
                new WorldPoint(3066, 2897, 0),
                new WorldPoint(3059, 2904, 0),
                new WorldPoint(3052, 2914, 0),
                new WorldPoint(3035, 2922, 0)
        );

        // Route 2
        List<WorldPoint> r2 = List.of(
                new WorldPoint(3220, 3400, 0),
                new WorldPoint(3225, 3403, 0),
                new WorldPoint(3230, 3406, 0)
        );

        // Route 3
        List<WorldPoint> r3 = List.of(
                new WorldPoint(3240, 3390, 0),
                new WorldPoint(3245, 3395, 0),
                new WorldPoint(3250, 3400, 0)
        );

        routes.add(new Route(1, r1));
        routes.add(new Route(2, r2));
        routes.add(new Route(3, r3));
    }
}
