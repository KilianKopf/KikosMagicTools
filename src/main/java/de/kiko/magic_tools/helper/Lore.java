package de.kiko.magic_tools.helper;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Lore {

    public static boolean hasLore(ItemStack it) {
        if (it == null) return false;
        ItemMeta meta = it.getItemMeta();
        if (meta == null)
            return false;
        List<String> lore = meta.getLore();
        if (lore == null) return false;
        return lore.contains(Text.ITEM_ENCH);
    }

}
