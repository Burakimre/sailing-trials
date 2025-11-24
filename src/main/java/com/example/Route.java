package com.example;

import java.awt.*;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.coords.WorldPoint;

public class Route {
    @Getter private final int id;

    @Getter private final List<WorldPoint> points;

    public Route(int id, List<WorldPoint> points)
    {
        this.id = id;
        this.points = points;
    }
}
