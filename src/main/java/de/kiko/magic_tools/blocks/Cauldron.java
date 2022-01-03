package de.kiko.magic_tools.blocks;

import de.kiko.magic_tools.helper.Text;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Cauldron {

    public static boolean is(Material m){
        return m == Material.LAVA_CAULDRON;
    }

    public static void doMagic(Block b, Player p){
        b.setType(Material.CAULDRON);
        b.getWorld().strikeLightningEffect(b.getLocation());
        p.sendMessage(Text.PREFIX + " " + Text.ITEM_HAS_BEEN_ENCH);
    }
}
