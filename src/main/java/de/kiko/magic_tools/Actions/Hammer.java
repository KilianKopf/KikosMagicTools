package de.kiko.magic_tools.Actions;

import de.kiko.magic_tools.helper.Direction;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class Hammer {

    public static void hammer(BlockBreakEvent event){
        Player p = event.getPlayer();
        //if player is facing up or down
        if (getFacingUD(p) == Direction.UP || getFacingUD(p) == Direction.DOWN){
            destroyBlocksDownUp(event);
            return;
        }

        //if player is facing west or east
        if (getFacingYaw(p) == Direction.WEST || getFacingYaw(p) == Direction.EAST){
            destroyBlocksWestEast(event);
            return;
        }

        //if player is facing north or south
        if (getFacingYaw(p) == Direction.NORTH || getFacingYaw(p) == Direction.SOUTH){
            destroyBlocksNorthSouth(event);
            return;
        }
    }

    public static void destroyBlocksWestEast(BlockBreakEvent e){
        Block b = e.getBlock();
        Material m = b.getType();
        Block d = b.getRelative(BlockFace.DOWN);
        Block u = b.getRelative(BlockFace.UP);

        //first X
        if (d.getType() == m)
            destroyBlock(d, e);
        if (u.getType() == m)
            destroyBlock(u, e);

        if (b.getRelative(BlockFace.SOUTH).getType() == m)
            destroyBlock(b.getRelative(BlockFace.SOUTH), e);
        if (b.getRelative(BlockFace.NORTH).getType() == m)
            destroyBlock(b.getRelative(BlockFace.NORTH), e);

        //diagonal down
        if (d.getRelative(BlockFace.SOUTH).getType() == m)
            destroyBlock(d.getRelative(BlockFace.SOUTH), e);
        if (d.getRelative(BlockFace.NORTH).getType() == m)
            destroyBlock(d.getRelative(BlockFace.NORTH), e);

        //diagonal up
        if (u.getRelative(BlockFace.SOUTH).getType() == m)
            destroyBlock(u.getRelative(BlockFace.SOUTH), e);
        if (u.getRelative(BlockFace.NORTH).getType() == m)
            destroyBlock(u.getRelative(BlockFace.NORTH), e);
    }

    public static void destroyBlocksDownUp(BlockBreakEvent e){
        Block b = e.getBlock();
        Material m = b.getType();
        Block w = b.getRelative(BlockFace.EAST);
        Block ea = b.getRelative(BlockFace.WEST);

        //first X
        if (w.getType() == m)
            destroyBlock(w, e);
        if (ea.getType() == m)
            destroyBlock(ea, e);


        if (b.getRelative(BlockFace.SOUTH).getType() == m)
            destroyBlock(b.getRelative(BlockFace.SOUTH), e);
        if (b.getRelative(BlockFace.NORTH).getType() == m)
            destroyBlock(b.getRelative(BlockFace.NORTH), e);

        //diagonal down
        if (ea.getRelative(BlockFace.NORTH).getType() == m)
            destroyBlock(ea.getRelative(BlockFace.NORTH), e);
        if (ea.getRelative(BlockFace.SOUTH).getType() == m)
            destroyBlock(ea.getRelative(BlockFace.SOUTH), e);

        //diagonal up
        if (w.getRelative(BlockFace.NORTH).getType() == m)
            destroyBlock(w.getRelative(BlockFace.NORTH), e);
        if (w.getRelative(BlockFace.SOUTH).getType() == m)
            destroyBlock(w.getRelative(BlockFace.SOUTH), e);
    }

    public static void destroyBlocksNorthSouth(BlockBreakEvent e){
        Block b = e.getBlock();
        Material m = b.getType();
        Block d = b.getRelative(BlockFace.DOWN);
        Block u = b.getRelative(BlockFace.UP);

        //first X
        if (d.getType() == m)
            destroyBlock(d, e);
        if (u.getType() == m)
            destroyBlock(u, e);


        if (b.getRelative(BlockFace.WEST).getType() == m)
            destroyBlock(b.getRelative(BlockFace.WEST), e);
        if (b.getRelative(BlockFace.EAST).getType() == m)
            destroyBlock(b.getRelative(BlockFace.EAST), e);

        //diagonal down
        if (d.getRelative(BlockFace.WEST).getType() == m)
            destroyBlock(d.getRelative(BlockFace.WEST), e);
        if (d.getRelative(BlockFace.EAST).getType() == m)
            destroyBlock(d.getRelative(BlockFace.EAST), e);

        //diagonal up
        if (u.getRelative(BlockFace.WEST).getType() == m)
            destroyBlock(u.getRelative(BlockFace.WEST), e);
        if (u.getRelative(BlockFace.EAST).getType() == m)
            destroyBlock(u.getRelative(BlockFace.EAST), e);
    }

    public static String getFacingYaw(Player player){
        float yaw = player.getLocation().getYaw();
        if (yaw < 0) {
            yaw += 360;
        }
        if (yaw >= 315 || yaw < 45) {
            return Direction.SOUTH;
        } else if (yaw < 135) {
            return Direction.WEST;
        } else if (yaw < 225) {
            return Direction.NORTH;
        } else if (yaw < 315) {
            return Direction.EAST;
        }
        return Direction.NORTH;
    }

    public static String getFacingUD(Player player){
        int degrees = Math.round(player.getLocation().getPitch());
        if (degrees < -45 ) return Direction.UP;
        if (degrees > 45 ) return Direction.DOWN;
        return Direction.STRAIGHT;
    }

    public static void destroyBlock(Block b, BlockBreakEvent event){
        ItemStack mainHand = event.getPlayer().getInventory().getItemInMainHand();
        ItemMeta mainHandMeta = mainHand.getItemMeta();
        Damageable dmg = (Damageable)mainHandMeta;

        dmg.setDamage(dmg.getDamage() + 1);
        mainHand.setItemMeta(dmg);
        event.getPlayer().getInventory().setItemInMainHand(mainHand);
        if (event.getExpToDrop() > 0) {
            ExperienceOrb exp = event.getPlayer().getWorld().spawn(b.getLocation(), ExperienceOrb.class);
            exp.setExperience(event.getExpToDrop());
        }
        b.breakNaturally();
    }
}
