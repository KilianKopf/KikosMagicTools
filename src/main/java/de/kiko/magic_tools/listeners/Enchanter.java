package de.kiko.magic_tools.listeners;

import de.kiko.magic_tools.blocks.Cauldron;
import de.kiko.magic_tools.items.Pickaxe;
import de.kiko.magic_tools.helper.Lore;
import de.kiko.magic_tools.helper.Text;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Enchanter implements Listener {

    @EventHandler
    public void onEnchant(PlayerInteractEvent event) {

        if (event.getHand() == EquipmentSlot.OFF_HAND) return;

        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        Material m = item.getType();

        Block b = event.getClickedBlock();

        if (b == null) return;
        if (!Cauldron.is(b.getBlockData().getMaterial())) return;

        if (Lore.hasLore(item)){
            event.getPlayer().sendMessage(Text.PREFIX + " " + Text.ITEM_ALREADY_ENCH);
            return;
        }

        if (Pickaxe.is(m))
        {
            if (!this.pay(event.getPlayer())) return;
            ItemMeta meta = item.getItemMeta();

            ArrayList<String> lore = new ArrayList<String>();
            lore.add(Text.ITEM_ENCH);
            meta.setLore(lore);

            item.setItemMeta(meta);
            event.getPlayer().getInventory().setItemInMainHand(item);
            Cauldron.doMagic(b, event.getPlayer());
        }
    }

    public boolean pay(Player player){
        if ((player.getInventory().getItemInOffHand().getType() == Material.DIAMOND) && player.getInventory().getItemInOffHand().getAmount() >= 3){
            ItemStack offHand = player.getInventory().getItemInOffHand();
            offHand.setAmount(offHand.getAmount() - 3);
            player.getInventory().setItemInOffHand(offHand);
            return true;
        }
        else{
            player.sendMessage(Text.PREFIX + " " + Text.ITEM_PRICE);
            return false;
        }
    }
}