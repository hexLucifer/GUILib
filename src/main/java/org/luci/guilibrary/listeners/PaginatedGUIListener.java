package org.luci.guilibrary.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.luci.guilibrary.utils.PaginatedChestGUI;

public class PaginatedGUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getHolder() instanceof PaginatedChestGUI) {
            PaginatedChestGUI paginatedGUI = (PaginatedChestGUI) event.getInventory().getHolder();
            int slot = event.getRawSlot();

            paginatedGUI.handleInventoryClick(slot);
            event.setCancelled(true); // Prevent item movement
        }
    }
}
