package de.kiko.magic_tools.items;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;

public class Pickaxe extends Tool{

    protected BlockBreakEvent event;

    public Pickaxe(BlockBreakEvent event){
        super(event);
    }

    public boolean isRightMaterial(){
        Material material = this.event.getBlock().getType();
        for(Material mat: this.rightMaterials){
            if (mat == material) {
                return true;
            }
        }
        return false;
    }

    protected ArrayList<Material> getMaterialList(){
        ArrayList<Material> blocks = new ArrayList<Material>();

        //ice
        blocks.add(Material.ICE);
        blocks.add(Material.PACKED_ICE);
        blocks.add(Material.BLUE_ICE);
        blocks.add(Material.FROSTED_ICE);

        //metal 1
        blocks.add(Material.REDSTONE_BLOCK);

        //metal 2
        blocks.add(Material.IRON_BLOCK);
        blocks.add(Material.COPPER_BLOCK);
        blocks.add(Material.CUT_COPPER);
        blocks.add(Material.LAPIS_BLOCK);

        //metal 3
        blocks.add(Material.DIAMOND_BLOCK);
        blocks.add(Material.EMERALD_BLOCK);
        blocks.add(Material.GOLD_BLOCK);

        //metal 4
        blocks.add(Material.NETHERITE_BLOCK);

        //rock 1
        blocks.add(Material.STONE);
        blocks.add(Material.ANDESITE);
        blocks.add(Material.BASALT);
        blocks.add(Material.BLACKSTONE);
        blocks.add(Material.AMETHYST_BLOCK);
        blocks.add(Material.COAL_BLOCK);
        blocks.add(Material.BRICK);
        blocks.add(Material.COAL_ORE);
        blocks.add(Material.COBBLESTONE);
        blocks.add(Material.WHITE_CONCRETE);
        blocks.add(Material.ORANGE_CONCRETE);
        blocks.add(Material.MAGENTA_CONCRETE);
        blocks.add(Material.LIGHT_BLUE_CONCRETE);
        blocks.add(Material.YELLOW_CONCRETE);
        blocks.add(Material.LIME_CONCRETE);
        blocks.add(Material.PINK_CONCRETE);
        blocks.add(Material.GRAY_CONCRETE);
        blocks.add(Material.LIGHT_GRAY_CONCRETE);
        blocks.add(Material.CYAN_CONCRETE);
        blocks.add(Material.PURPLE_CONCRETE);
        blocks.add(Material.BLUE_CONCRETE);
        blocks.add(Material.BROWN_CONCRETE);
        blocks.add(Material.GREEN_CONCRETE);
        blocks.add(Material.GREEN_CONCRETE);
        blocks.add(Material.BLACK_CONCRETE);
        blocks.add(Material.DARK_PRISMARINE);
        blocks.add(Material.DIORITE);
        blocks.add(Material.DRIPSTONE_BLOCK);
        blocks.add(Material.END_STONE);
        blocks.add(Material.TERRACOTTA);
        blocks.add(Material.WHITE_TERRACOTTA);
        blocks.add(Material.ORANGE_TERRACOTTA);
        blocks.add(Material.MAGENTA_TERRACOTTA);
        blocks.add(Material.LIGHT_BLUE_TERRACOTTA);
        blocks.add(Material.YELLOW_TERRACOTTA);
        blocks.add(Material.LIME_TERRACOTTA);
        blocks.add(Material.PINK_TERRACOTTA);
        blocks.add(Material.GRAY_TERRACOTTA);
        blocks.add(Material.LIGHT_GRAY_TERRACOTTA);
        blocks.add(Material.CYAN_TERRACOTTA);
        blocks.add(Material.PURPLE_TERRACOTTA);
        blocks.add(Material.BLUE_TERRACOTTA);
        blocks.add(Material.BROWN_TERRACOTTA);
        blocks.add(Material.GREEN_TERRACOTTA);
        blocks.add(Material.BLACK_TERRACOTTA);
        blocks.add(Material.RED_TERRACOTTA);
        blocks.add(Material.WHITE_GLAZED_TERRACOTTA);
        blocks.add(Material.ORANGE_GLAZED_TERRACOTTA);
        blocks.add(Material.MAGENTA_GLAZED_TERRACOTTA);
        blocks.add(Material.LIGHT_BLUE_GLAZED_TERRACOTTA);
        blocks.add(Material.YELLOW_GLAZED_TERRACOTTA);
        blocks.add(Material.LIME_GLAZED_TERRACOTTA);
        blocks.add(Material.PINK_GLAZED_TERRACOTTA);
        blocks.add(Material.GRAY_GLAZED_TERRACOTTA);
        blocks.add(Material.LIGHT_GRAY_GLAZED_TERRACOTTA);
        blocks.add(Material.CYAN_GLAZED_TERRACOTTA);
        blocks.add(Material.PURPLE_GLAZED_TERRACOTTA);
        blocks.add(Material.LIGHT_GRAY_GLAZED_TERRACOTTA);
        blocks.add(Material.BLUE_GLAZED_TERRACOTTA);
        blocks.add(Material.BROWN_GLAZED_TERRACOTTA);
        blocks.add(Material.GREEN_GLAZED_TERRACOTTA);
        blocks.add(Material.RED_GLAZED_TERRACOTTA);
        blocks.add(Material.BLACK_GLAZED_TERRACOTTA);
        blocks.add(Material.GRANITE);
        blocks.add(Material.LODESTONE);
        blocks.add(Material.MOSSY_COBBLESTONE);
        blocks.add(Material.NETHER_BRICK);
        blocks.add(Material.NETHER_GOLD_ORE);
        blocks.add(Material.NETHER_QUARTZ_ORE);
        blocks.add(Material.NETHERRACK);
        blocks.add(Material.PRISMARINE);
        blocks.add(Material.PRISMARINE_BRICKS);
        blocks.add(Material.POLISHED_ANDESITE);
        blocks.add(Material.POLISHED_BLACKSTONE);
        blocks.add(Material.POLISHED_BLACKSTONE_BRICKS);
        blocks.add(Material.POLISHED_DIORITE);
        blocks.add(Material.POLISHED_GRANITE);
        blocks.add(Material.RED_SANDSTONE);
        blocks.add(Material.SANDSTONE);
        blocks.add(Material.STONE_BRICKS);

        //rock 2
        blocks.add(Material.COPPER_ORE);
        blocks.add(Material.IRON_ORE);
        blocks.add(Material.LAPIS_ORE);
        blocks.add(Material.LAPIS_ORE);

        //rock 3
        blocks.add(Material.DIAMOND_ORE);
        blocks.add(Material.EMERALD_ORE);
        blocks.add(Material.GOLD_ORE);
        blocks.add(Material.REDSTONE_ORE);

        //rock 4
        blocks.add(Material.ANCIENT_DEBRIS);
        blocks.add(Material.CRYING_OBSIDIAN);
        blocks.add(Material.OBSIDIAN);

        return blocks;
    }

    public static boolean is(Material m){
        return m == Material.DIAMOND_PICKAXE ||
                m == Material.GOLDEN_PICKAXE ||
                m == Material.WOODEN_PICKAXE ||
                m == Material.STONE_PICKAXE ||
                m == Material.NETHERITE_PICKAXE;
    }
}
