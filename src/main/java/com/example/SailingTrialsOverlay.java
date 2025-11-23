package com.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.Perspective;
import net.runelite.client.ui.overlay.*;

public class SailingTrialsOverlay extends Overlay
{
    private final Client client;
    private final RouteManager routeManager;

    private double progress = 0;
    private static final double speed = 0.01;

    @Inject
    public SailingTrialsOverlay(Client client, RouteManager routeManager)
    {
        this.client = client;
        this.routeManager = routeManager;

        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.UNDER_WIDGETS);
    }

    public void tick()
    {
        progress += speed;
        if (progress > 1.0)
            progress -= 1.0;
    }

    @Override
    public Dimension render(Graphics2D g)
    {
        for (Route route : routeManager.getRoutes())
        {
            renderRoute(g, route);
        }
        return null;
    }

    private void renderRoute(Graphics2D g, Route route)
    {
        List<Point> canvasPts = new ArrayList<>();

        for (WorldPoint wp : route.getPoints())
        {
            Point p = worldToCanvas(wp);
            if (p != null)
                canvasPts.add(p);
        }

        if (canvasPts.size() < 2)
            return;

        // Base path line
        g.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.setColor(route.getBaseLineColor());

        for (int i = 0; i < canvasPts.size() - 1; i++)
        {
            Point a = canvasPts.get(i);
            Point b = canvasPts.get(i + 1);
            g.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
        }

        // Tracer path line
        double total = routeLength(canvasPts);
        double p = progress % 1.0;
        double startDist = p * total;

        List<Point> segPoints = buildSegmentPoints(canvasPts, startDist, 25);

        g.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.setColor(route.getTracerLineColor());

        for (int i = 0; i < segPoints.size() - 1; i++)
        {
            Point a = segPoints.get(i);
            Point b = segPoints.get(i + 1);
            g.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
        }
    }

    // ---- ROUTE UTILITIES ----

    private double routeLength(List<Point> pts)
    {
        double len = 0;
        for (int i = 0; i < pts.size() - 1; i++)
            len += pts.get(i).distanceTo(pts.get(i + 1));
        return len;
    }

    private Point interpolateRoute(List<Point> pts, double d)
    {
        for (int i = 0; i < pts.size() - 1; i++)
        {
            Point a = pts.get(i);
            Point b = pts.get(i + 1);
            double segLen = a.distanceTo(b);

            if (d <= segLen)
            {
                double t = d / segLen;
                int x = (int)(a.getX() + (b.getX() - a.getX()) * t);
                int y = (int)(a.getY() + (b.getY() - a.getY()) * t);
                return new Point(x, y);
            }
            d -= segLen;
        }
        return pts.get(pts.size() - 1);
    }

    private List<Point> buildSegmentPoints(List<Point> pts, double d, double segLen)
    {
        List<Point> result = new ArrayList<>();

        Point curr = interpolateRoute(pts, d);
        result.add(curr);

        double remaining = segLen;

        for (int i = 0; i < pts.size() - 1 && remaining > 0; i++)
        {
            Point a = pts.get(i);
            Point b = pts.get(i + 1);
            double seg = a.distanceTo(b);

            if (d <= seg)
            {
                double step = Math.min(seg - d, remaining);
                Point next = interpolateRoute(List.of(a, b), d + step);
                result.add(next);

                remaining -= step;
                d = 0;
            }
            else
            {
                d -= seg;
            }
        }

        return result;
    }

    private Point worldToCanvas(WorldPoint wp)
    {
        LocalPoint lp = LocalPoint.fromWorld(client, wp);
        if (lp == null)
            return null;

        return Perspective.localToCanvas(client, lp.getX(), lp.getY(), client.getTopLevelWorldView().getPlane());
    }
}