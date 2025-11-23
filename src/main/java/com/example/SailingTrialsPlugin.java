package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;

import net.runelite.api.Client;
import net.runelite.api.events.ClientTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(name = "Sailing Trials")
public class SailingTrialsPlugin extends Plugin
{
    @Inject private Client client;
    @Inject private SailingTrialsConfig config;
    @Inject private OverlayManager overlayManager;

    @Inject private RouteManager routeManager;
    @Inject private SailingTrialsOverlay overlay;

    @Override
    protected void startUp()
    {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(overlay);
    }

    @Subscribe
    public void onClientTick(ClientTick tick)
    {
        overlay.tick();
    }

    @Provides
    SailingTrialsConfig provideConfig(ConfigManager cm)
    {
        return cm.getConfig(SailingTrialsConfig.class);
    }
}
