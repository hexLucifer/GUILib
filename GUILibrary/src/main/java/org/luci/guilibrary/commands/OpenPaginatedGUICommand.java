package org.luci.guilibrary.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.luci.guilibrary.utils.PaginatedChestGUI;

public class OpenPaginatedGUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            PaginatedChestGUI paginatedGUI = new PaginatedChestGUI("Paginated GUI", 27, 2); // 3 rows

            // Add multiple items to demonstrate pagination
            for (int i = 1; i <= 50; i++) {
                ItemStack item = new ItemStack(Material.DIAMOND);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName("Item #" + i);
                item.setItemMeta(meta);

                int finalI = i;
                paginatedGUI.addItem(item, () -> {
                    player.sendMessage("You clicked Item #" + finalI);
                });
            }

            paginatedGUI.open(player);
            return true;
        }
        return false;
    }
}
