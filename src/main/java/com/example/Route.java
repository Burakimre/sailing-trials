package com.example;

import java.awt.*;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.coords.WorldPoint;

public class Route {
    @Getter
    private final List<WorldPoint> points;

    @Getter @Setter
    private Color baseLineColor;

    @Getter @Setter
    private Color tracerLineColor;

    @Getter @Setter
    private boolean visible = true;

    public Route(List<WorldPoint> points, Color baseLineColor, Color tracerLineColor, boolean visible)
    {
        this.points = points;
        this.baseLineColor = baseLineColor;
        this.tracerLineColor = tracerLineColor;
        this.visible = visible;
    }
}
