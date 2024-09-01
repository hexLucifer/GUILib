package org.luci.guilibrary.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaginatedChestGUI implements InventoryHolder {

    private final String title;
    private final int size;
    private final int maxPages;
    private int currentPage = 0;
    private final List<List<ItemStack>> pages = new ArrayList<>();
    private final Map<Integer, Runnable> clickActions = new HashMap<>();
    private Inventory inventory;
    private Player player;

    public PaginatedChestGUI(String title, int size, int maxPages) {
        this.title = title;
        this.size = size;
        this.maxPages = maxPages;
    }

    public void addItem(ItemStack item, Runnable action) {
        if (pages.isEmpty() || pages.get(pages.size() - 1).size() >= size - 9) {
            if (pages.size() < maxPages) {
                pages.add(new ArrayList<>());
            } else {
                return;
            }
        }
        pages.get(pages.size() - 1).add(item);
        clickActions.put((pages.size() - 1) * (size - 9) + pages.get(pages.size() - 1).size() - 1, action);
    }

    public void open(Player player) {
        this.player = player;
        this.currentPage = 0; // Start at page 0
        inventory = Bukkit.createInventory(this, size, title + " - Page " + (currentPage + 1));
        updateInventory();
        player.openInventory(inventory);
    }

    private void updateInventory() {
        inventory.clear();

        List<ItemStack> currentItems = pages.get(currentPage);

        for (int i = 0; i < currentItems.size(); i++) {
            if (i < size - 9) {
                inventory.setItem(i, currentItems.get(i));
            }
        }

        // Add pagination buttons if applicable
        if (currentPage > 0) {
            inventory.setItem(size - 9, createButton("Previous Page"));
            clickActions.put(size - 9, this::previousPage);
        } else {
            inventory.setItem(size - 9, null);
        }

        if (currentPage < pages.size() - 1) {
            inventory.setItem(size - 1, createButton("Next Page"));
            clickActions.put(size - 1, this::nextPage);
        } else {
            inventory.setItem(size - 1, null);
        }
    }

    public void handleInventoryClick(int slot) {
        if (clickActions.containsKey(slot)) {
            clickActions.get(slot).run();
        }
    }

    private void previousPage() {
        if (currentPage > 0) {
            currentPage--; // Move to previous page
            updateInventory();
            player.openInventory(inventory);
        }
    }

    private void nextPage() {
        if (currentPage < pages.size() - 1) {
            currentPage++; // Move to next page
            updateInventory();
            player.openInventory(inventory);
        }
    }

    private ItemStack createButton(String name) {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
