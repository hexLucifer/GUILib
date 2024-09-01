package org.luci.guilibrary;

import org.bukkit.plugin.java.JavaPlugin;
import org.luci.guilibrary.commands.OpenPaginatedGUICommand;
import org.luci.guilibrary.commands.TestDynamicGUI;
import org.luci.guilibrary.listeners.ChestGUIListener;
import org.luci.guilibrary.listeners.PaginatedGUIListener;

public final class GUILibrary extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("GUILib enabled.");

        // Listeners
        getServer().getPluginManager().registerEvents(new ChestGUIListener(), this);
        getServer().getPluginManager().registerEvents(new PaginatedGUIListener(), this);

        // Commands


    }

    @Override
    public void onDisable() {
        getLogger().info("GUILib has been disabled.");
    }
}
