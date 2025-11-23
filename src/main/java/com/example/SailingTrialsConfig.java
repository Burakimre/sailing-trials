package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("example")
public interface SailingTrialsConfig extends Config
{
    @ConfigSection(
            position = 6,
            name = "Barracuda Trials",
            description = "Configure the barracuda trials settings"
    )
    String barracudaTrialsSection = "barracudaTrialsSection";

    @ConfigItem(
            position = 0,
            keyName = "showRoute1",
            name = "Show route 1",
            description = "Show the path drawn for route 1",
            section = barracudaTrialsSection
    )
    default boolean showRoute1()
    {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "baseLineColorRoute1",
            name = "Route 1 base line color",
            description = "Color used to draw the base path line for route 1.",
            section = barracudaTrialsSection
    )
    default Color baseLineColorRoute1()
    {
        return new Color(0, 153, 0, 255);
    }

    @ConfigItem(
            position = 2,
            keyName = "tracerLineColorRoute1",
            name = "Route 1 tracer line color",
            description = "Color used to draw the moving tracer line on route 1.",
            section = barracudaTrialsSection
    )
    default Color tracerLineColorRoute1()
    {
        return new Color(0, 255, 0, 255);
    }

    @ConfigItem(
            position = 3,
            keyName = "showRoute2",
            name = "Show route 2",
            description = "Show the path drawn for route 2",
            section = barracudaTrialsSection
    )
    default boolean showRoute2()
    {
        return true;
    }

    @ConfigItem(
            position = 4,
            keyName = "baseLineColorRoute2",
            name = "Route 2 base line color",
            description = "Color used to draw the base path line for route 2.",
            section = barracudaTrialsSection
    )
    default Color baseLineColorRoute2()
    {
        return new Color(153, 56, 0, 255);
    }

    @ConfigItem(
            position = 5,
            keyName = "tracerLineColorRoute2",
            name = "Route 2 tracer line color",
            description = "Color used to draw the moving tracer line on route 2.",
            section = barracudaTrialsSection
    )
    default Color tracerLineColorRoute2()
    {
        return new Color(255, 92, 0, 255);
    }

    @ConfigItem(
            position = 6,
            keyName = "showRoute3",
            name = "Show route 3",
            description = "Show the path drawn for route 3",
            section = barracudaTrialsSection
    )
    default boolean showRoute3()
    {
        return true;
    }

    @ConfigItem(
            position = 7,
            keyName = "baseLineColorRoute3",
            name = "Route 3 base line color",
            description = "Color used to draw the base path line for route 3.",
            section = barracudaTrialsSection
    )
    default Color baseLineColorRoute3()
    {
        return new Color(102, 0, 153, 255);
    }

    @ConfigItem(
            position = 8,
            keyName = "tracerLineColorRoute3",
            name = "Route 3 tracer line color",
            description = "Color used to draw the moving tracer line on route 3.",
            section = barracudaTrialsSection
    )
    default Color tracerLineColorRoute3()
    {
        return new Color(191, 0, 255, 255);
    }
}