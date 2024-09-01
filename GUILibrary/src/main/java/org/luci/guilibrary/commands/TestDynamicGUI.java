package org.luci.guilibrary.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.luci.guilibrary.utils.ChestGUI;

public class TestDynamicGUI implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command,String level, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ChestGUI chestGUI = new ChestGUI("Dynamic GUI", 27);

            ItemStack healthItem = new ItemStack(Material.APPLE);
            ItemMeta meta = healthItem.getItemMeta();
            meta.displayName(Component.text("Health: " + player.getHealth()));
            healthItem.setItemMeta(meta);

            chestGUI.setItem(13, healthItem, () -> {
                player.sendMessage("You clicked the health item!");
            });

            chestGUI.open(player);
            return true;
        }

        return false;
    }
}
