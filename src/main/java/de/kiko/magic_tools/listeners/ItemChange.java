package de.kiko.magic_tools.listeners;

import de.kiko.magic_tools.helper.Lore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ItemChange implements Listener {

    @EventHandler
    public void onChange(PlayerItemHeldEvent event){
        if (Lore.hasLore(event.getPlayer().getInventory().getItem(event.getNewSlot()))) {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 0));
        }
        else{
            event.getPlayer().removePotionEffect(PotionEffectType.SLOW_DIGGING);
        };

    }
}
