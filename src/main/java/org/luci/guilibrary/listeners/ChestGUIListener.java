package org.luci.guilibrary.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.luci.guilibrary.utils.ChestGUI;

public class ChestGUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getHolder() instanceof ChestGUI) {
            ChestGUI chestGUI = (ChestGUI) event.getInventory().getHolder();


            chestGUI.handleInventoryClick(event);
            event.setCancelled(true);
        }
    }
}
