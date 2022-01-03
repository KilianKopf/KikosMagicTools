package de.kiko.magic_tools.listeners;

import de.kiko.magic_tools.Actions.Hammer;
import de.kiko.magic_tools.helper.Lore;
import de.kiko.magic_tools.items.Pickaxe;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class BlockDestroyPickaxe implements Listener {

    @EventHandler
    public void onDestroy(BlockBreakEvent event){
        //is pickaxe
        if (!Pickaxe.is(event.getPlayer().getInventory().getItemInMainHand().getType())) return;

        //is block droped
        if (event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).isEmpty()) return;

        //if item has not lore in main hand
        Player p = event.getPlayer();
        if (!Lore.hasLore(p.getInventory().getItemInMainHand())) return;

        //can the block be destroyed by the pickaxe
        Pickaxe pickaxe = new Pickaxe(event);
        if (!pickaxe.isRightMaterial()) return;

        Hammer.hammer(event);
    }





}
